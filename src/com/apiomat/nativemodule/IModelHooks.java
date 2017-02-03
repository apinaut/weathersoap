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

import java.util.List;

/**
 * Old interface for hook methods.
 *
 * This class was also delivered to module developers via module SDK. To implement methods for a specific model, simply
 * create a class implementing this interface. Yambas will find it in the module .jar via lookup and use it
 * automatically.
 * You can test these methods by invkoing them manually.
 *
 * @author andreas
 * @param <T> The type of the model
 */
@Deprecated
public interface IModelHooks<T> extends IModelHooksCommon<T>
{
	/**
	 * gets called by server; the module name and model name of the calling object are set here and can be stored in the
	 * hooks class for e.g. determining the type in other hook methods
	 *
	 * @param model the model which is used to call the hook methods
	 *
	 */
	@Override
	void setCallingModel( T model );

	/**
	 * You can implement a custom authentication method in your own class.
	 * If access on an arbitrary model is checked, depending on the order in which an app configured its authentication
	 * classes, this class gets loaded and the authentication method gets called.
	 *
	 * Note: passwordOrToken only contains a token if the Model annotation
	 * {@link com.apiomat.nativemodule.Model#callAuthWithValidToken()} is set to {@value false} AND the token is valid.
	 * Invalid tokens get rejected by ApiOmat automatically.
	 *
	 * @param httpVerb GET / POST / DELETE / PUT
	 * @param modelName name of the model where the user wants access to
	 * @param modelForeignId foreign ID of the model where the user wants access to
	 * @param userNameOrEmail username or email of the user
	 * @param passwordOrToken password or token of the user
	 * @param request the request object
	 * @return TRUE on successful auth
	 */
	@Override
	boolean auth( String httpVerb, String modelName, String modelForeignId, String userNameOrEmail,
		String passwordOrToken, Request request );

	/* The following methods get called when the underlying model is set to "transient" in its meta model. Then, the
	 * usual logic on server side is not called but the following methods */

	/**
	 * Stores the model on an arbitrary storage system. Returns the ID which can be used to query the model later on.
	 *
	 * @param obj the object to store
	 * @param request {@link Request} data
	 * @return the ID (foreignId) of the object
	 */
	String doPost( T obj, Request request );

	/**
	 * Updates the model on an arbitrary storage system.
	 *
	 * @param obj the object to update
	 * @param request {@link Request} data
	 */
	void doPut( T obj, Request request );

	/**
	 * Returns the model from an arbitrary storage system using its foreignId
	 *
	 * @param foreignId the ID of the model in the storage system
	 * @param request {@link Request} data
	 *
	 * @return the model
	 */
	T doGet( String foreignId, Request request );

	/**
	 * Deletes the model from an arbitrary storage system using its foreignId
	 *
	 * @param foreignId the ID of the model in the storage system
	 * @param request {@link Request} data
	 * @return TRUE if delete was successfull
	 */
	boolean doDelete( String foreignId, Request request );

	/**
	 * Returns all models from an arbitrary storage system
	 *
	 * @param query query filter
	 * @param request {@link Request} data
	 * @return all models from an arbitrary storage system
	 */
	List<T> doGetAll( String query, Request request );

	/**
	 * Returns the number of all models from an arbitrary storage system
	 *
	 * @param query query filter
	 * @param request {@link Request} data
	 * @return number of all models from an arbitrary storage system
	 */
	long doCountAll( String query, Request request );

	/**
	 * Adds a new reference to this object
	 *
	 * @param referencedObject the referenced object
	 * @param referenceName name of the reference field
	 * @param request {@link Request} data
	 */
	void doPostRef( Object referencedObject, String referenceName, Request request );

	/**
	 * Deletes a reference from this object
	 *
	 * @param refForeignId if of the referenced object
	 * @param refName name of the reference field
	 * @param request {@link Request} data
	 */
	void doDeleteRef( String refName, String refForeignId, Request request );

	/**
	 * Returns references from this object
	 *
	 * @param query query to filter referenced objects
	 * @param refName name of the reference field
	 * @param request {@link Request} data
	 * @return list of references on this object
	 */
	<Z extends AbstractClientDataModel> List<Z> doGetRef( String refName, String query, Request request );

	/* The following methods get called when the underlying model is NOT set to "transient" in its meta model. Data is
	 * used from ApiOmat database */

	/**
	 * Gets invoked before the object is persisted; one may set additional values here or change existing ones. Changes
	 * will be saved automatically
	 *
	 * @param obj
	 * @param request {@link Request} data
	 */
	void beforePost( T obj, Request request );

	/**
	 * Gets invoked after the object is persisted; manipulations on the object must be saved manually.
	 *
	 * @param obj
	 * @param request {@link Request} data
	 */
	void afterPost( T obj, Request request );

	/**
	 * Gets invoked before the object is returned; one may set additional values here or change existing ones. Changes
	 * must be saved manually.
	 *
	 * @param obj
	 * @param request {@link Request} data
	 */
	void beforeGet( T obj, Request request );

	/**
	 * Gets invoked before the object is updated; one may set additional values here or change existing ones. Changes
	 * are saved automatically.
	 *
	 * Return TRUE here to suppress the update itself.
	 *
	 * @param objFromDB
	 * @param obj
	 * @param request {@link Request} data
	 * @return TRUE to suppress the update
	 */
	boolean beforePut( T objFromDB, T obj, Request request );

	/**
	 * Gets invoked after the object is updated; manipulations on the object must be saved manually.
	 *
	 * @param obj
	 * @param request {@link Request} data
	 */
	void afterPut( T obj, Request request );

	/**
	 * Gets invoked before the object is deleted.
	 *
	 * Return TRUE here to suppress the delete itself.
	 *
	 * @param objFromDB
	 * @param obj
	 * @param request {@link Request} data
	 * @return TRUE to suppress the delete
	 */
	boolean beforeDelete( T obj, Request request );

	/**
	 * Gets invoked if all models of a class are queried. The query string is set as the second parameter. If one wants
	 * to modify the list, just return the manipulated list.
	 *
	 * @param objects the list of models
	 * @param query the query
	 * @param request {@link Request} data
	 * @return the list of objects to use for further proceeding
	 */
	List<T> afterGetAll( List<T> objects, String query, Request request );

	/**
	 * Gets invoked before a reference is added to the object
	 *
	 * Return TRUE here to suppress the adding itself.
	 *
	 * @param obj the model
	 * @param referencedObject the referenced object to add to the model
	 * @param referenceName the name of the reference field
	 * @param request {@link Request} data
	 * @return TRUE to suppress the reference adding
	 */
	boolean beforePostRef( T obj, Object referencedObject, String referenceName, Request request );

	/**
	 * Gets invoked after a refernce was added to the object
	 *
	 * @param obj the model
	 * @param referencedObject the referenced object to add to the model
	 * @param referenceName the name of the reference field
	 * @param request {@link Request} data
	 */
	void afterPostRef( T obj, Object referencedObject, String referenceName, Request request );

	/**
	 * Gets invoked before a reference is deleted from the object
	 *
	 * Return TRUE here to suppress the deletion itself.
	 *
	 * @param obj the model
	 * @param referencedObject the referenced object to delete from the model
	 * @param referenceName the name of the reference field
	 * @param request {@link Request} data
	 * @return TRUE to suppress the reference deletion
	 */
	boolean beforeDeleteRef( T obj, Object referencedObject, String referenceName, Request request );

	/**
	 * Gets invoked after a refernce was deleted from the object
	 *
	 * @param obj the model
	 * @param referencedObject the referenced object to delete from the model
	 * @param referenceName the name of the reference field
	 * @param request {@link Request} data
	 */
	void afterDeleteRef( T obj, Object referencedObject, String referenceName, Request request );

	/**
	 * Gets invoked if all references of a class are queried. The query string is set as the second parameter. If one
	 * wants
	 * to modify the list, just return the manipulated list.
	 *
	 * @param objects the list of references
	 * @param query the query
	 * @param referenceName the name of the reference field
	 * @param request {@link Request} data
	 * @return the list of objects to use for further proceeding
	 */
	<Z extends AbstractClientDataModel> List<Z> afterGetAllReferences( List<Z> objects, String query,
		String referenceName, Request request );
}