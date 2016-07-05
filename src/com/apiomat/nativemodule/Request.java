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

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class containing information about the current request
 *
 * @author andreas
 */
public class Request
{
	private final String userEmail;
	private final String userPassword;
	private final String userToken;
	private final String system;
	private final String apiKey;
	/**
	 * module name from which this request was made; needed for determining correct class loader
	 */
	private final String callingModule;
	private final String applicationName;

	/* Introduced so that in a native module auth method a findBy method can be called without another verify call,
	 * which would lead to an endless loop */
	private boolean noAuth;

	/**
	 * Constructor
	 *
	 * @param userEmail requesting users email
	 * @param userPassword requesting users cleartext password
	 * @param userToken requesting users oauth token
	 * @param apiKey the api key
	 * @param callingModule module name from which this request was made; needed for determining correct class loader
	 * @param appName the application name
	 * @param system apiomat system (LIVE/STAGING/TEST)
	 */
	public Request( String userEmail, String userPassword, String userToken, String apiKey, String appName,
		String callingModule,
		String system )
	{
		super( );
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.system = system;
		this.applicationName = appName;
		this.userToken = userToken;
		this.apiKey = apiKey;
		this.callingModule = callingModule;
	}

	@Deprecated
	public Request( String userEmail, String userPassword, String userToken, String apiKey, String callingModule,
		String system )
	{
		this( userEmail, userPassword, userToken, "", "", callingModule, system );
	}

	@Deprecated
	public Request( String userEmail, String userPassword, String userToken, String apiKey, String system )
	{
		this( userEmail, userPassword, userToken, "", "", "", system );
	}

	@Deprecated
	public Request( String userEmail, String userPassword, String userToken, String system )
	{
		this( userEmail, userPassword, userToken, "", "", "", system );
	}

	public String getUserEmail( )
	{
		return this.userEmail;
	}

	public String getUserPassword( )
	{
		return this.userPassword;
	}

	public String getUserToken( )
	{
		return this.userToken;
	}

	public String getSystem( )
	{
		return this.system;
	}

	public String getApplicationName( )
	{
		return this.applicationName;
	}

	public boolean getNoAuth( )
	{
		return this.noAuth;
	}

	public String getCallingModule( )
	{
		return this.callingModule;
	}

	public void setNoAuth( boolean noAuth )
	{
		this.noAuth = noAuth;
	}

	public String getApiKey( )
	{
		return this.apiKey;
	}

	/**
	 * Hashes a password like it is done in ApiOmat core
	 *
	 * @param password the cleartext password
	 * @return the hased password
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String sha( final String password ) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		MessageDigest md;
		md = MessageDigest.getInstance( "SHA-256" );
		md.reset( );
		md.update( password.getBytes( "UTF-8" ) );
		return new String( encodeHex( md.digest( ) ) );
	}

	private static char[ ] encodeHex( byte[ ] data )
	{
		final char[ ] toDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		final int l = data.length;
		final char[ ] out = new char[ l << 1 ];

		int j = 0;
		for ( int i = 0; i < l; i++ )
		{
			out[ ( j++ ) ] = toDigits[ ( ( 0xF0 & data[ i ] ) >>> 4 ) ];
			out[ ( j++ ) ] = toDigits[ ( 0xF & data[ i ] ) ];
		}
		return out;
	}
}
