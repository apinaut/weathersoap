/* Copyright (c) 2011 - 2015, Apinauten GmbH
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

	public void throwException( final String applicationName, final String message );

	@Deprecated
	public IModel<?> findByForeignId( final String applicationName, final String foreignId, final String moduleName,
		final String className );

	public IModel<?> findByForeignId( final String applicationName, final String foreignId, final String moduleName,
		final String className, final Request r );

	public IModel<?>[ ] findByForeignIds( final String applicationName, final Collection<String> foreignIds,
		final String moduleName,
		final String className,
		final Request r );

	@Deprecated
	public IModel<?> createObject( final String applicationName, final String moduleName, final String className );

	public IModel<?> createObject( final String applicationName, final String moduleName, final String className,
		final Request r );

	@Deprecated
	public IModel<?> findById( final String applicationName, final String id, final String moduleName,
		final String className );

	public IModel<?> findById( final String applicationName, final String id, final String moduleName,
		final String className, final Request r );

	@Deprecated
	public IModel<?>[ ] findByNames( final String applicationName, final String moduleName, final String className,
		final String query );

	public IModel<?>[ ] findByNames( final String applicationName, final String moduleName, final String className,
		final String query, final Request r );

	public IModel<?> findByAccessToken( final String applicationName, final String accessToken );

}
