/*******************************************************************************
 * Copyright (c) 2016 Red Hat.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat - Initial Contribution
 *******************************************************************************/

package org.jboss.trumped.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import org.yaml.snakeyaml.Yaml;

/**
 * Pulls the content from an URL and tokenizes/filters the text from the HTML
 * page.
 */
@ApplicationScoped
public class UrlContentAnalyzer {

	public static final Logger LOGGER = LoggerFactory.getLogger(UrlContentAnalyzer.class);

	private List<String> positiveEmotions = null;
	private List<String> negativeEmotions = null;

	public void loadEmotions() {
		final InputStream emotionsStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("emotions.yml");
		final Yaml yaml = new Yaml();
		final Map<String, List<String>> emotions = (Map<String, List<String>>) yaml.load(emotionsStream);
		this.positiveEmotions = emotions.get("positive");
		this.negativeEmotions = emotions.get("negative");
	}

	public List<String> getPositiveEmotions() {
		return positiveEmotions;
	}

	public List<String> getNegativeEmotions() {
		return negativeEmotions;
	}

	public Map<String, Long> countWordsByEmotion(final String candidateName)
			throws MalformedURLException, IOException, SAXException, TikaException {
		if (this.positiveEmotions == null || this.negativeEmotions == null) {
			loadEmotions();
		}
		final List<String> words = new ArrayList<String>();
		List<String> urls = Candidates.LIST.get(candidateName);
		if (urls != null) {
			for (String url : urls) {
				words.addAll(tokenizePage(url));
			}
		}
		final Map<String, Long> countByEmotion = new HashMap<>();
		final Long positiveCount = words.stream().filter(word -> this.positiveEmotions.contains(word)).count();
		final Long negativeCount = words.stream().filter(word -> this.negativeEmotions.contains(word)).count();
		countByEmotion.put("positive", positiveCount);
		countByEmotion.put("negative", negativeCount);
		return countByEmotion;
	}

	/**
	 * Tokenizes the content of the given URL
	 * 
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 * @throws TikaException
	 */
	public List<String> tokenizePage(final String url)
			throws MalformedURLException, IOException, SAXException, TikaException {
		final URLConnection con = new URL(url).openConnection();
		final InputStream input = con.getInputStream();

		final BodyContentHandler handler = new BodyContentHandler();
		final Metadata metadata = new Metadata();
		new HtmlParser().parse(input, handler, metadata, new ParseContext());
		final String plainText = handler.toString();

		final List<String> words = tokenizeString(new SimpleAnalyzer(), plainText);
		LOGGER.debug(words.toString());
		return words;
	}

	public static List<String> tokenizeString(Analyzer analyzer, String string) {
		List<String> result = new ArrayList<String>();
		try {
			TokenStream stream = analyzer.tokenStream(null, new StringReader(string));
			StopFilter stopFilter = new StopFilter(stream, StopWords.getSet());
			stopFilter.reset();
			while (stopFilter.incrementToken()) {
				result.add(stopFilter.getAttribute(CharTermAttribute.class).toString());
			}
			stopFilter.close();
		} catch (IOException e) {
			// not thrown b/c we're using a string reader...
			throw new RuntimeException(e);
		}
		return result;
	}
}
