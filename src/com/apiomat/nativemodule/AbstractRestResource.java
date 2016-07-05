/* Copyright (c) 2011 - 2016, Apinauten GmbH
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * THIS FILE IS GENERATED AUTOMATICALLY. DON'T MODIFY IT. */
package com.apiomat.nativemodule;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

/**
 * @author Andreas Fey
 */
@SuppressWarnings( "PMD.AbstractClassWithoutAbstractMethod" )
public abstract class AbstractRestResource
{
	@Context
	private UriInfo uri;
	@Context
	private HttpServletRequest request;
	@Context
	private SecurityContext securityContext;
	@Context
	private Request wsRequest;

	/**
	 * The request containing the user data when using Native Module
	 */
	private com.apiomat.nativemodule.Request aomRequest;

	/**
	 * Non-arg constructor, needed internally
	 */
	protected AbstractRestResource( )
	{}

	/**
	 * Constructor, must be overwritten by subclass
	 *
	 * @param uriInfo
	 * @param servletRequest
	 * @param securityContext
	 * @param wsRequest
	 */
	protected AbstractRestResource( final UriInfo uriInfo, final HttpServletRequest servletRequest,
		final SecurityContext securityContext, final Request wsRequest )
	{
		this.uri = uriInfo;
		this.request = servletRequest;
		this.securityContext = securityContext;
		this.wsRequest = wsRequest;
	}

	protected final UriInfo getUriInfo( )
	{
		return this.uri;
	}

	protected final HttpServletRequest getHttpServletRequest( )
	{
		return this.request;
	}

	protected final Request getWsRequest( )
	{
		return this.wsRequest;
	}

	protected final SecurityContext getSecurityContext( )
	{
		return this.securityContext;
	}

	protected final com.apiomat.nativemodule.Request getAOMRequest( )
	{
		return this.aomRequest;
	}
}
