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

/** common interface for hook classes */
public interface IModelHooksCommon<T>
{
	/**
	 * sets the calling model
	 *
	 * @param model the model
	 */
	public void setCallingModel( T model );

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
	default public boolean auth( String httpVerb, String modelName, String modelForeignId, String userNameOrEmail,
		String passwordOrToken, Request request )
	{
		return false;
	}
}