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

import java.util.Collection;

import com.apiomat.nativemodule.interfaces.dmap.ADistributedMapHandler;

/**
 * Interface for static methods.
 *
 * @author andreas
 */
public interface IStaticMethods
{
	/**
	 * Logs a message to the apps database
	 *
	 * @param applicationName
	 * @param message
	 */
	public void log( String applicationName, String message );

	/**
	 * Logs an error to the apps database
	 *
	 * @param applicationName
	 * @param message
	 */
	public void logError( String applicationName, String message );

	/**
	 * Logs an exception to the apps database
	 *
	 * @param applicationName
	 * @param e
	 */
	public void logError( String applicationName, Throwable e );

	/**
	 * Logs a message to the apps database
	 *
	 * @param applicationName
	 * @param message
	 * @param messageArray
	 */
	public void logModel( String applicationName, String message, IModel<?>[ ] messageArray );

	/**
	 * Logs a message to the apps database
	 *
	 * @param applicationName
	 * @param message
	 * @param messageModel
	 */
	public void logModel( String applicationName, String message, IModel<?> messageModel );

	/**
	 * Logs a message to the apps database
	 *
	 * @param applicationName
	 * @param message
	 * @param messageModel
	 */
	public void logModel( String applicationName, String message, Object messageModel );

	/**
	 * Throws a TriggeredScriptException with a status code
	 *
	 * @param applicationName
	 * @param message message
	 */
	public void throwException( final String applicationName, final String message );

	/**
	 * Finds a model by its foreign ID
	 *
	 * @param applicationName
	 * @param foreignId foreign ID
	 * @param moduleName The name of the module
	 * @param className The class name of the model
	 * @param r The request
	 * @return The found model
	 */
	public IModel<?> findByForeignId( final String applicationName, final String foreignId, final String moduleName,
		final String className, final Request r );

	/**
	 * Finds models by their foreign IDs
	 *
	 * @param applicationName the apps name
	 * @param foreignIds A collection of foreign IDs
	 * @param moduleName The name of the module, where the class of the objects that are being searched for resides
	 * @param className The class name of the models
	 * @param r The request
	 * @return The found models in an array
	 */
	public IModel<?>[ ] findByForeignIds( final String applicationName, final Collection<String> foreignIds,
		final String moduleName,
		final String className,
		final Request r );

	/**
	 * Creates a new data model object
	 *
	 * @param applicationName
	 * @param moduleName
	 * @param className
	 * @return a new data model object
	 */
	public IModel<?> createObject( final String applicationName, final String moduleName, final String className );

	/**
	 * Creates a new data model object
	 *
	 * @param applicationName
	 * @param moduleName
	 * @param className
	 * @param r
	 * @return a new data model object
	 */
	public IModel<?> createObject( final String applicationName, final String moduleName, final String className,
		final Request r );

	/**
	 * Finds a model by its ID
	 *
	 * @param applicationName the apps name
	 * @param id The ID
	 * @param moduleName The name of the module, where the class of the object that is being searched for resides
	 * @param className The class name of the model
	 * @param r The request
	 * @return The found model
	 */
	public IModel<?> findById( final String applicationName, final String id, final String moduleName,
		final String className, final Request r );

	/**
	 * Finds models by filtering with a query
	 *
	 * @param applicationName the apps name
	 * @param moduleName The name of the module
	 * @param className The class name of the models
	 * @param query The query
	 * @param r The request
	 * @return An array of models
	 */
	public IModel<?>[ ] findByNames( final String applicationName, final String moduleName, final String className,
		final String query, final Request r );

	/**
	 * Returns a user found by his access token
	 *
	 * @param applicationName app name
	 * @param accessToken token
	 * @return The user or user subclass object
	 */
	public IModel<?> findByAccessToken( final String applicationName, final String accessToken );

	/**
	 * Get or create a handler for distributed maps
	 *
	 * @param appName application name
	 * @param moduleName name of module
	 * @param mapName unique name of map
	 * @return Handler object to work with distributed maps
	 */
	public <K, V> ADistributedMapHandler<K, V> getOrCreateDistributedMapHandler( final String appName,
		final String moduleName,
		final String mapName );

}
