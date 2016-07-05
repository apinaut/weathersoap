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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for model classes
 *
 * @author andreas
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( value = ElementType.TYPE )
public @interface Model
{
	/**
	 * The {@link IModelHooks} implementation class name (com.apiomat.backend.modules.YOURMODULENAME.CLASSNAME)
	 */
	String hooksClassName( ) default "";

	/** Name of the module where the {@link IModelHooks} implementation is in */
	String moduleName( ) default "";

	/**
	 * TRUE if data of this class is directly loaded/written from a third party system; then, by default no data is
	 * written to MongoDB
	 */
	boolean isTransient( ) default false;

	/**
	 * <code>true</code> if data of this class should be persisted in the global shared-module datastore<br/>
	 * by default, this is set so <code>false</code> <br/>
	 * <b>WARNING:</b> if you set this to true, your stored data will be available in EVERY app for everyone who mets
	 * the given roles
	 */
	boolean isGlobal( ) default false;

	/**
	 * {@link UserRole} which is needed to create a new instance of this class
	 */
	UserRole requiredUserRoleCreate( ) default UserRole.User;

	/**
	 * {@link UserRole} which is needed to read an existing instance of this class
	 */
	UserRole requiredUserRoleRead( ) default UserRole.User;

	/**
	 * {@link UserRole} which is needed to update an existing instance of this class
	 */
	UserRole requiredUserRoleWrite( ) default UserRole.Owner;

	/**
	 * TRUE if access to image or file attributes of this class need authentication
	 */
	boolean restrictResourceAccess( ) default false;

	/**
	 * Array of existing Role names which may create a new instance of this class (ACL). If roles are set, the
	 * requiredUserRole for this operation will automatically be set to ApAdmin!
	 */
	String[ ] allowedRolesCreate( ) default { };

	/**
	 * Array of existing Role names which may read an instance of this class (ACL). If roles are set, the
	 * requiredUserRole for this operation will automatically be set to ApAdmin!
	 */
	String[ ] allowedRolesRead( ) default { };

	/**
	 * Array of existing Role names which may update an instance of this class (ACL). If roles are set, the
	 * requiredUserRole for this operation will automatically be set to ApAdmin!
	 */
	String[ ] allowedRolesWrite( ) default { };

	/**
	 * Array of existing Role names which may grant rights on an instance of this class (ACL).
	 */
	String[ ] allowedRolesGrant( ) default { };

	/**
	 * TRUE if the auth hook method should be used for authentication instead of ApiOmat's internal auth
	 */
	boolean useOwnAuth( ) default false;

}
