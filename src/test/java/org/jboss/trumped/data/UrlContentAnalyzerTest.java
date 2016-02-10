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

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.apache.tika.exception.TikaException;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * 
 */
public class UrlContentAnalyzerTest {

	@Test
	public void shouldCountWords() throws MalformedURLException, IOException, SAXException, TikaException {
		// given
		final String candidate = "Donald Trump";
		// when
		Map<String, Long> countWords = new UrlContentAnalyzer().countWordsByEmotion(candidate);
		// then
		assertThat(countWords).isNotEmpty();
	}
	
	@Test
	public void shouldLoadEmotions() {
		// given
		UrlContentAnalyzer urlContentAnalyzer = new UrlContentAnalyzer();
		// when
		urlContentAnalyzer.loadEmotions();
		// then
		assertThat(urlContentAnalyzer.getPositiveEmotions()).isNotNull().isNotEmpty();
		assertThat(urlContentAnalyzer.getNegativeEmotions()).isNotNull().isNotEmpty();
	}
}
