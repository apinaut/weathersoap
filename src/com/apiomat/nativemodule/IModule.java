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

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

/**
 * @author andreas
 */
public interface IModule extends Serializable
{
	/**
	 * Gets called when a module is deployed to ApiOmat
	 */
	void onDeploy( );

	/**
	 * Gts called when a module is undeployed from ApiOmat
	 */
	void onUndeploy( );

	/**
	 * Gets called if the module config is changed for an app
	 * 
	 * @param appName applications name
	 * @param configKey config key name
	 * @param system the system name (LIVE, TEST,..)
	 */
	void onConfigChanged( final String appName, final String configKey, final String system );

	/**
	 * Returns a specific rest subservice, available beyond <i>/modules/MYMODULE/spec</i>
	 * 
	 * @param uriInfo the uri info
	 * @param servletRequest the servlet request
	 * @param securityContext the security context
	 * @param wsRequest the request
	 * @return the specific rest service
	 */
	AbstractRestResource getSpecificRestResource( UriInfo uriInfo, HttpServletRequest servletRequest,
		SecurityContext securityContext, Request wsRequest );

	/**
	 * ApiOmat runs an internal Cron timer. This method is called every hour to enable the module to do recurring tasks.
	 * 
	 * @param appName the app for which this cronjob runs
	 * @param system the apiomat system
	 */
	void onCronHourly( final String appName, final String system );

	/**
	 * ApiOmat runs an internal Cron timer. This method is called every day to enable the module to do recurring tasks.
	 * 
	 * @param appName the app for which this cronjob runs
	 * @param system the apiomat system
	 */
	void onCronDaily( final String appName, final String system );

	/**
	 * ApiOmat runs an internal Cron timer. This method is called every week to enable the module to do recurring tasks.
	 * 
	 * @param appName the app for which this cronjob runs
	 * @param system the apiomat system
	 */
	void onCronWeekly( final String appName, final String system );

	/**
	 * ApiOmat runs an internal Cron timer. This method is called every month to enable the module to do recurring
	 * tasks.
	 * 
	 * @param appName the app for which this cronjob runs
	 * @param system the apiomat system
	 */
	void onCronMonthly( final String appName, final String system );
}
