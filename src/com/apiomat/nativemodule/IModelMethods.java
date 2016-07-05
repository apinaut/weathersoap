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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface for model methods.
 *
 * This class is also delivered to module developers via module SDK. Developers
 * can implement their own stub methods my implementing this interface and
 * setting the setMethods in the model class. On server side, an own
 * implementation is used to manage database access
 *
 * @author andreas
 */
public interface IModelMethods
{
	/**
	 * saves the object
	 *
	 * @return the id of the saved object
	 */
	public String save( );

	/**
	 * deletes the object
	 *
	 * @return true if deletion was successful
	 */
	public boolean delete( );

	/**
	 * sets the id
	 *
	 * @param id
	 *        the id
	 */
	public void setId( String id );

	/**
	 *
	 * @return the id
	 */
	public String getId( );

	/**
	 *
	 * @return the foreignId
	 */
	public String getForeignId( );

	/**
	 * sets the foreignId
	 *
	 * @param foreignId
	 *        the foreignId
	 */
	public void setForeignId( String foreignId );

	/**
	 * @return the name of the current application
	 */
	public String getApplicationName( );

	/**
	 * Returns the owner user name of the model
	 *
	 * @return owner user name of the model
	 */
	public String getOwnerUserName( );

	/**
	 * @return array of roles which are allowed to read
	 */
	public String[ ] getAllowedRolesRead( );

	/**
	 * Sets the roles which are allowed to read
	 *
	 * @param allowedRolesRead
	 */
	public void setAllowedRolesRead( String[ ] allowedRolesRead );

	/**
	 * @return array of roles which are allowed to write
	 */
	public String[ ] getAllowedRolesWrite( );

	/**
	 * Sets the roles which are allowed to write
	 *
	 * @param allowedRolesWrite
	 */
	public void setAllowedRolesWrite( String[ ] allowedRolesWrite );

	/**
	 * @return array of roles which are allowed to grant further rights
	 */
	public String[ ] getAllowedRolesGrant( );

	/**
	 * Sets roles which are allowed to grant further rights
	 *
	 * @param allowedRolesGrant
	 */
	public void setAllowedRolesGrant( String[ ] allowedRolesGrant );

	/**
	 * @return list of hrefs of all references
	 */
	public Map<String, Set<String>> getReferencedHrefs( );

	/**
	 * @return TRUE of all resources need authentication for access
	 */
	public boolean getRestrictResourceAccess( );

	/**
	 * Start verification of the current request
	 *
	 * @param verb
	 * @param r
	 * @throws Exception
	 */
	public void verifyRequest( final String verb, final Request r )
		throws Exception;

	/**
	 * @return last modified date
	 */
	public Date getLastModifiedAt( );

	/**
	 * Sets the last modified at date, only applicable for transient classes
	 *
	 * @param lastModified
	 */
	public void setLastModifiedAt( final Date lastModified );

	/**
	 * @return created at date
	 */
	public Date getCreatedAt( );

	/**
	 * Sets the created at date, only applicable for transient classes
	 *
	 * @param createdAt
	 */
	public void setCreatedAt( final Date createdAt );

	/**
	 * Loads a resource as byte arraay from url
	 *
	 * @param href
	 * @return byte array
	 */
	public byte[ ] loadResource( final String href );

	/**
	 * Save a resource
	 *
	 * @param data
	 * @param isImage
	 * @param name
	 * @param format
	 * @return URL
	 */
	public String saveResource( byte[ ] data, boolean isImage, String name,
		String format );

	/**
	 * Logs a message
	 *
	 * @param message
	 */
	public void log( String message );

	/**
	 * Logs an error
	 *
	 * @param message
	 */
	public void logError( String message );

	/**
	 * Logs a throwable
	 *
	 * @param e
	 */
	public void logError( Throwable e );

	/**
	 * logs the model
	 *
	 * @param message
	 *        the message to log
	 * @param messageArray
	 *        the objects to log
	 */
	public void logModel( String message, IModel<?>[ ] messageArray );

	/**
	 * logs the model
	 *
	 * @param message
	 *        the message to log
	 * @param messageModel
	 *        the model to log
	 */
	public void logModel( String message, IModel<?> messageModel );

	/**
	 * logs the model
	 *
	 * @param message
	 *        the message to log
	 * @param messageModel
	 *        the object to log
	 */
	public void logModel( String message, Object messageModel );

	/**
	 * Throws an exception with a message
	 *
	 * @param message
	 *        message
	 */
	public void throwException( String message );

	/**
	 * Throws an exception with a message and status code
	 *
	 * @param statusCode
	 * @param message
	 *        message
	 */
	public void throwException( int statusCode, String message );

	/**
	 * Finds a model by its foreign ID
	 *
	 * @param foreignId
	 * @param className
	 * @param r
	 * @return Finds a model by its foreign ID
	 */
	public IModel<?> findByForeignId( final String foreignId,
		final String className, final Request r );

	/**
	 * Finds a model by its foreign ID
	 *
	 * @param foreignId
	 * @param moduleName
	 * @param className
	 * @param r
	 * @return Finds a model by its foreign ID
	 */
	public IModel<?> findByForeignId( final String foreignId,
		final String moduleName, final String className, final Request r );

	/**
	 * Finds models by their foreign IDs
	 *
	 * @param foreignIds
	 *        A collection of foreign IDs
	 * @param moduleName
	 *        The name of the module, where the class of the objects that
	 *        are being searched for resides
	 * @param className
	 *        The class name of the models
	 * @param r
	 *        The request
	 * @return The found models in an array
	 */
	public IModel<?>[ ] findByForeignIds( final Collection<String> foreignIds,
		final String moduleName, final String className, final Request r );

	/**
	 * Creates a new data model object
	 *
	 * @param className
	 * @return a new data model object
	 */
	@Deprecated
	public IModel<?> createObject( final String className );

	/**
	 * Creates a new data model object
	 *
	 * @param className
	 * @param r
	 * @return a new data model object
	 */
	public IModel<?> createObject( final String className, final Request r );

	/**
	 * Creates a new data model object
	 *
	 * @param moduleName
	 * @param className
	 * @return a new data model object
	 */
	@Deprecated
	public IModel<?> createObject( final String moduleName,
		final String className );

	/**
	 * Creates a new data model object
	 *
	 * @param moduleName
	 * @param className
	 * @param r
	 * @return a new data model object
	 */
	public IModel<?> createObject( final String moduleName,
		final String className, final Request r );

	/**
	 * adds the given model to this model at given refName
	 *
	 * @param refName
	 *        the reference-attribute name
	 * @param ref
	 *        the reference to add
	 */
	public void addReference( final String refName, final IModel<?> ref );

	/**
	 * removes the given model from this model as reference
	 *
	 * @param refName
	 *        the reference-attribute name
	 * @param ref
	 *        the reference to remove
	 */
	public void removeReference( final String refName, final IModel<?> ref );

	/**
	 * loads the object for the given attribute
	 *
	 * @param refName
	 *        the reference-attribute name
	 * @param refClazz
	 *        the reference class
	 * @return the referenced object
	 */
	public <T> T loadReference( final String refName,
		final Class<? extends AbstractClientDataModel> refClazz );

	/**
	 * loads the objects as list for the given attributes
	 *
	 * @param refName
	 *        the reference-attribute name
	 * @param refClazz
	 *        the reference class
	 * @return the referenced object list
	 */
	public <T> List<T> loadReferences( final String refName,
		final Class<? extends AbstractClientDataModel> refClazz );

	/**
	 * gets the object by its id
	 *
	 * @param id
	 *        the id of the object
	 * @param className
	 *        the classname of the object
	 * @param r
	 *        the request
	 * @return the object
	 */
	public IModel<?> findById( final String id, final String className,
		final Request r );

	/**
	 * gets the object by its id
	 *
	 * @param id
	 *        the id of the object
	 * @param moduleName
	 *        the modulename
	 * @param className
	 *        the classname of the object
	 * @param r
	 *        the request
	 * @return the object
	 */
	public IModel<?> findById( final String id, final String moduleName,
		final String className, final Request r );

	/**
	 * finds the objects by name and query
	 *
	 * @param className
	 *        the classname of the object
	 * @param query
	 *        the query
	 * @param r
	 *        the request
	 * @return the objects found for that query
	 */
	public IModel<?>[ ] findByNames( final String className, final String query,
		final Request r );

	/**
	 * finds the objects by name and query
	 *
	 * @param moduleName
	 *        the module name
	 * @param className
	 *        the classname of the object
	 * @param query
	 *        the query
	 * @param r
	 *        the request
	 * @return the objects found for that query
	 */
	public IModel<?>[ ] findByNames( final String moduleName,
		final String className, final String query, final Request r );

	/**
	 * Calls a method on server side
	 *
	 * @param methodName name of the method
	 *
	 * @param params
	 */
	public void callMethod( final String methodName, Object... params );

	/**
	 * Encode string with base64
	 *
	 * @param str
	 * @return ecoded string
	 */
	public String toBase64( String str );

	/**
	 * Return the requesting user name
	 *
	 * @return the requesting user name
	 */
	public String getRequestingUsername( );

	/**
	 * Tracks a GA event from Server Code
	 *
	 * @param category
	 *        the category
	 * @param action
	 *        the action
	 * @param label
	 *        the label
	 * @param value
	 *        the value
	 */
	public void trackGAEvent( String category, String action, String label,
		String value );

	/**
	 * Track a Piwik goal
	 *
	 * @param goalId
	 *        the goal ID
	 */
	public void trackPiwikGoal( int goalId );

	/**
	 * Track a Piwik custom variable
	 *
	 * @param action
	 *        the action
	 * @param userName
	 *        the user who called the request
	 * @param id
	 *        the custom var ID
	 * @param key
	 *        the key of the variable
	 * @param value
	 *        the value of the variable (may be null)
	 */
	public void trackPiwikCustomVars( String action, String userName, int id,
		String key, String value );

	/**
	 * Returns the HTTP servlet request
	 *
	 * @return HTTP servlet request
	 */
	public HttpServletRequest getHttpServletRequest( );
}
