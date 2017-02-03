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
 * Interface for hook methods of transient models
 *
 * This class is also delivered to module developers via module SDK. To implement methods for a specific model, marked as transient, simply
 * create a class implementing this interface. Yambas will find it in the module .jar via lookup and use it
 * automatically.
 * You can test these methods by invoking them manually.
 *
 * @author andreas
 * @param <T> The type of the model
 */
public interface IModelHooksTransient<T> extends IModelHooksCommon<T>
{
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
}
