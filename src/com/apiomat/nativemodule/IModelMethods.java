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
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface for model methods.
 *
 * This class is also delived to module develpers via module SDK. Developers can implement their own stub methods my
 * implementing this interface and setting the setMethods in the model class. On server side, an own implementation is
 * used to manage database access
 *
 * @author andreas
 */
public interface IModelMethods
{
	public String save( );

	public boolean delete( );

	public void setId( String id );

	public String getId( );

	public String getForeignId( );

	public void setForeignId( String foreignId );

	public String getApplicationName( );

	public String getOwnerUserName( );

	public String[ ] getAllowedRolesRead( );

	public void setAllowedRolesRead( String[ ] allowedRolesRead );

	public String[ ] getAllowedRolesWrite( );

	public void setAllowedRolesWrite( String[ ] allowedRolesWrite );

	public String[ ] getAllowedRolesGrant( );

	public void setAllowedRolesGrant( String[ ] allowedRolesGrant );

	public Map<String, Set<String>> getReferencedHrefs( );

	public boolean getRestrictResourceAccess( );

	public void verifyRequest( final String verb, final Request r ) throws Exception;

	public Date getLastModifiedAt( );

	public Date getCreatedAt( );

	public byte[ ] loadResource( final String href );

	public String saveResource( byte[ ] data, boolean isImage, String name, String format );

	public void log( String message );

	public void logError( String message );

	public void logError( Throwable e );

	public void logModel( String message, IModel<?>[ ] messageArray );

	public void logModel( String message, IModel<?> messageModel );

	public void logModel( String message, Object messageModel );

	public void throwException( String message );

	public void throwException( int statusCode, String message );

	@Deprecated
	public IModel<?> findByForeignId( final String foreignId, final String className );

	public IModel<?> findByForeignId( final String foreignId, final String className, final Request r );

	@Deprecated
	public IModel<?> findByForeignId( final String foreignId, final String moduleName, final String className );

	public IModel<?> findByForeignId( final String foreignId, final String moduleName, final String className,
		final Request r );

	public IModel<?>[ ] findByForeignIds( final Collection<String> foreignIds, final String moduleName,
		final String className,
		final Request r );

	/**
	 * Creates a new data model object
	 *
	 * @param className
	 * @return a new data model object
	 * @throws Exception
	 */
	@Deprecated
	public IModel<?> createObject( final String className );

	/**
	 * Creates a new data model object
	 *
	 * @param className
	 * @return a new data model object
	 * @throws Exception
	 */
	public IModel<?> createObject( final String className, final Request r );

	/**
	 * Creates a new data model object
	 *
	 * @param moduleName
	 * @param className
	 * @return a new data model object
	 * @throws Exception
	 */
	public IModel<?> createObject( final String moduleName, final String className );

	/**
	 * Creates a new data model object
	 *
	 * @param moduleName
	 * @param className
	 * @return a new data model object
	 * @throws Exception
	 */
	public IModel<?> createObject( final String moduleName, final String className, final Request r );

	public void addReference( final String refName, final IModel<?> ref );

	public void removeReference( final String refName, final IModel<?> ref );

	@Deprecated
	public IModel<?> findById( final String id, final String className );

	public IModel<?> findById( final String id, final String className, final Request r );

	@Deprecated
	public IModel<?> findById( final String id, final String moduleName, final String className );

	public IModel<?> findById( final String id, final String moduleName, final String className, final Request r );

	@Deprecated
	public IModel<?>[ ] findByNames( final String className, final String query );

	public IModel<?>[ ] findByNames( final String className, final String query, final Request r );

	@Deprecated
	public IModel<?>[ ] findByNames( final String moduleName, final String className, final String query );

	public IModel<?>[ ] findByNames( final String moduleName, final String className, final String query,
		final Request r );

	public String toBase64( String str );

	public String getRequestingUsername( );

	/**
	 * Tracks a GA event from Server Code
	 *
	 * @param category the category
	 * @param action the action
	 * @param label the label
	 * @param value the value
	 */
	public void trackGAEvent( String category, String action, String label, String value );

	/**
	 * Track a Piwik goal
	 *
	 * @param goalId the goal ID
	 */
	public void trackPiwikGoal( int goalId );

	/**
	 * Track a Piwik custom variable
	 *
	 * @param action the action
	 * @param userName the user who called the request
	 * @param id the custom var ID
	 * @param key the key of the variable
	 * @param value the value of the variable (may be null)
	 */
	public void trackPiwikCustomVars( String action, String userName, int id, String key, String value );

	/**
	 * Returns the HTTP servlet request
	 *
	 * @return HTTP servlet request
	 */
	public HttpServletRequest getHttpServletRequest( );
}
