package org.jboss.trumped.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MoodEndpointTest {

	@Test
	public void shouldComputeScore() {
		// given
		final Map<String, Long> emotions = new HashMap<>();
		emotions.put("positive", new Long(1));
		emotions.put("negative", new Long(1));
		// when
		int score = MoodEndpoint.computeScore(emotions);
		// then
		assertThat(score).isEqualTo(50);
	}
}
