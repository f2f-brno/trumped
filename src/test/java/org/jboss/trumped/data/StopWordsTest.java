package org.jboss.trumped.data;

import org.junit.Assert;
import org.junit.Test;

public class StopWordsTest {

	@Test
	public void testStopWordSet() {
		Assert.assertTrue(StopWords.getSet().contains("a"));
	}

}
