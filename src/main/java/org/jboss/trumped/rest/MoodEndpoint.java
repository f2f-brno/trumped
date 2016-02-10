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

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	@Path("/")
	public Response compare(@PathParam("democrat") String democratCandidate, @PathParam("republican") String republicanCandidate) {
		
		
		return Response.ok(null).build();
	}

}
