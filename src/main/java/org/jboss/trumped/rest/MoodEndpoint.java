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

package org.jboss.trumped.rest;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.trumped.data.UrlContentAnalyzer;

/**
 * 
 */
@Path("/mood")
public class MoodEndpoint {

	@Inject
	UrlContentAnalyzer contentAnalyzer;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response compare(@QueryParam("democrat") String democratCandidate,
			@QueryParam("republican") String republicanCandidate) {
		try {
			final Map<String, Long> democratWordsCounts = contentAnalyzer.countWordsByEmotion(democratCandidate);
			final Map<String, Long> republicanWordCounts = contentAnalyzer.countWordsByEmotion(republicanCandidate);
			final Map<String, Integer> result = new HashMap<>();
			// building scores from the positive / (positive + nagative) counts
			
			final int democratScore = computeScore(democratWordsCounts); 
			final int republicanScore = computeScore(republicanWordCounts); 
			result.put(democratCandidate, democratScore);
			result.put(republicanCandidate, republicanScore);
			//System.out.println(result);
			return Response.ok(result).build();
		} catch (Throwable e) {
			e.printStackTrace();
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	public static int computeScore(final Map<String, Long> moods) {
		return (int) ((100 * moods.get("positive") / (moods.get("positive") + moods.get("negative"))));
	}

}
