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
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

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
import org.xml.sax.SAXException;

/**
 * 
 */
public class TikaSample {

	public static void main(String[] args) throws IOException, SAXException, TikaException {
		URL url = new URL("http://www.nytimes.com/");
		URLConnection con = url.openConnection();
		InputStream input = con.getInputStream();

		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		new HtmlParser().parse(input, handler, metadata, new ParseContext());
		String plainText = handler.toString();

		List<String> result = tokenizeString(new SimpleAnalyzer(), plainText);
		System.out.println(result);
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
