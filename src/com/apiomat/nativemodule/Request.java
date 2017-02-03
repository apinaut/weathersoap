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
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class containing information about the current request
 *
 * @author andreas
 */
public class Request
{
	private static final Pattern elementPattern = Pattern.compile( "," );
	private static final Pattern valuePattern = Pattern.compile( ":" );
	private static final Pattern replacePattern = Pattern.compile( "\"" );

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

	/* indicates if a request is authorized through an instance of AbstractAccount account */
	private boolean isAccountRequest;

	private String deltaSyncHeaderValue;
	private Map<String, Long> deltaSyncMap;
	private long deltaSyncMapComputedTimestamp;
	private long deltaSyncChangedTimestamp;

	private String deltaSyncDeletedHeaderValue;
	private List<String> deltaSyncDeletedList;
	private long deltaSyncDeletedListComputedTimestamp;
	private long deltaSyncDeletedChangedTimestamp;

	private boolean useDeltaSyncInFindByNames;
	private boolean useDeltaSyncDeletedInResponse;

	private Boolean hooksInUsedModulesEnabled;

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
		String callingModule, String system )
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

	public boolean getIsAccountRequest( )
	{
		return this.isAccountRequest;
	}

	public void setNoAuth( boolean noAuth )
	{
		this.noAuth = noAuth;
	}

	public void setIsAccountRequest( boolean isAccountRequest )
	{
		this.isAccountRequest = isAccountRequest;
	}

	public String getApiKey( )
	{
		return this.apiKey;
	}

	/**
	 * Returns the deltaSyncHeaderValue
	 *
	 * @return the deltaSyncHeaderValue
	 */
	public String getDeltaSyncHeaderValue( )
	{
		return this.deltaSyncHeaderValue;
	}

	/**
	 * Sets the deltaSyncHeaderValue
	 *
	 * @param deltaSyncHeaderValue
	 */
	public void setDeltaSyncHeaderValue( String deltaSyncHeaderValue )
	{
		this.deltaSyncHeaderValue = deltaSyncHeaderValue;
		this.deltaSyncChangedTimestamp = System.currentTimeMillis( );
	}

	/**
	 * Computes a Map from the DeltaSync header value and returns it.
	 * Only computes the map if not computed before or
	 * if the DeltaSync header value changed after the last computation.
	 *
	 * @return the computed DeltaSyncMap. Null if any error occurs during computation.
	 */
	public Map<String, Long> getDeltaSyncMap( )
	{
		if ( this.deltaSyncMap == null ||
			this.deltaSyncMapComputedTimestamp < this.deltaSyncChangedTimestamp )
		{
			/* Parse JSON by ourselves so no JSON library needs to be included just for the rarely used DeltaSync header */
			try
			{
				final String elementsString =
					getDeltaSyncHeaderValue( ).trim( ).substring( 1, getDeltaSyncHeaderValue( ).trim( ).length( ) - 1 );
				final String[ ] elements = elementPattern.split( elementsString );
				final Map<String, Long> finalMap = Stream.of( elements )
					.map( element -> valuePattern.split( element ) )
					.collect(
						Collectors.toMap( splitElement -> replacePattern.matcher( splitElement[ 0 ] ).replaceAll( "" ),
							splitElement -> Long.parseLong( splitElement[ 1 ] ) ) );
				this.deltaSyncMap = finalMap;
				this.deltaSyncMapComputedTimestamp = System.currentTimeMillis( );
			}
			catch ( Exception ex )
			{
				this.deltaSyncMap = null;
			}
		}
		return this.deltaSyncMap;
	}

	/**
	 * Sets the deltaSyncMap and computes and sets deltaSyncHeaderValue.
	 *
	 * @param deltaSyncMap
	 */
	public void setDeltaSyncMap( Map<String, Long> deltaSyncMap )
	{
		if ( deltaSyncMap == null )
		{
			this.deltaSyncHeaderValue = null;
		}
		else if ( deltaSyncMap.size( ) == 0 )
		{
			this.deltaSyncHeaderValue = "{}";
		}
		else
		{
			String manualJson = deltaSyncMap.entrySet( ).stream( )
				.map( entry -> "\"" + entry.getKey( ) + "\":" + entry.getValue( ) )
				.reduce( ( accu, newElem ) -> accu + "," + newElem )
				.orElse( null );
			if ( manualJson == null )
			{
				/* size 0 was handled before, so an error must have occurred */
				throw new RuntimeException( "An error occured during computing a JSON object from a Map" );
			}
			manualJson = "{" + manualJson + "}";
			this.deltaSyncHeaderValue = manualJson;
		}
		this.deltaSyncMap = deltaSyncMap;
		this.deltaSyncChangedTimestamp = System.currentTimeMillis( );
	}

	/**
	 * @return the deltaSyncDeletedHeaderValue
	 */
	public String getDeltaSyncDeletedHeaderValue( )
	{
		return this.deltaSyncDeletedHeaderValue;
	}

	/**
	 * @param deltaSyncDeletedHeaderValue the deltaSyncDeletedHeaderValue to set
	 */
	public void setDeltaSyncDeletedHeaderValue( String deltaSyncDeletedHeaderValue )
	{
		this.deltaSyncDeletedHeaderValue = deltaSyncDeletedHeaderValue;
		this.deltaSyncDeletedChangedTimestamp = System.currentTimeMillis( );
	}

	/**
	 * Computes a List from the DeltaSync deleted header value and returns it.
	 * Only computes the list if not computed before or
	 * if the DeltaSync deleted header value changed after the last computation.
	 *
	 * @return the computed deltaSyncDeletedList. Null if any error occurs during computation.
	 */
	public List<String> getDeltaSyncDeletedList( )
	{
		if ( this.deltaSyncDeletedList == null ||
			this.deltaSyncDeletedListComputedTimestamp < this.deltaSyncDeletedChangedTimestamp )
		{
			/* Parse JSON by ourselves so no JSON library needs to be included just for the rarely used DeltaSync header */
			try
			{
				final String elementsString =
					getDeltaSyncDeletedHeaderValue( ).trim( ).substring( 1,
						getDeltaSyncDeletedHeaderValue( ).trim( ).length( ) - 1 );
				final String[ ] elements = elementPattern.split( elementsString );
				this.deltaSyncDeletedList = Stream.of( elements )
					.map( element -> replacePattern.matcher( element ).replaceAll( "" ) )
					.collect( Collectors.toList( ) );
				this.deltaSyncDeletedListComputedTimestamp = System.currentTimeMillis( );
			}
			catch ( Exception ex )
			{
				this.deltaSyncDeletedList = null;
			}
		}
		return this.deltaSyncDeletedList;
	}

	/**
	 * Sets the deltaSyncDeletedList and computes and sets deltaSyncDeletedHeaderValue.
	 *
	 * @param deltaSyncDeletedList the deltaSyncDeletedList to set
	 */
	public void setDeltaSyncDeletedList( List<String> deltaSyncDeletedList )
	{
		if ( deltaSyncDeletedList == null )
		{
			this.deltaSyncDeletedHeaderValue = null;
		}
		else if ( deltaSyncDeletedList.size( ) == 0 )
		{
			this.deltaSyncDeletedHeaderValue = "[]";
		}
		else
		{
			String manualJson = deltaSyncDeletedList.stream( )
				.map( element -> "\"" + element + "\"" )
				.reduce( ( accu, newElem ) -> accu + "," + newElem )
				.orElse( null );
			if ( manualJson == null )
			{
				/* size 0 was handled before, so an error must have occurred */
				throw new RuntimeException( "An error occured during computing a JSON array from a List of Strings" );
			}
			manualJson = "[" + manualJson + "]";
			this.deltaSyncDeletedHeaderValue = manualJson;
		}
		this.deltaSyncDeletedList = deltaSyncDeletedList;
		this.deltaSyncDeletedChangedTimestamp = System.currentTimeMillis( );
	}

	/**
	 * @return the useDeltaSyncInFindByNames
	 */
	public boolean isUseDeltaSyncInFindByNames( )
	{
		return this.useDeltaSyncInFindByNames;
	}

	/**
	 * Needs to be set to true if you want the DeltaSync info in the Request object to be used when calling findByNames
	 *
	 * @param useDeltaSyncInFindByNames the useDeltaSyncInFindByNames to set
	 */
	public void setUseDeltaSyncInFindByNames( boolean useDeltaSyncInFindByNames )
	{
		this.useDeltaSyncInFindByNames = useDeltaSyncInFindByNames;
	}

	/**
	 * @return the useDeltaSyncDeletedInResponse
	 */
	public boolean isUseDeltaSyncDeletedInResponse( )
	{
		return this.useDeltaSyncDeletedInResponse;
	}

	/**
	 * Needs to be set to true if you want the DeltaSync-deleted info in the Request object to be used in the response
	 * to the client
	 *
	 * @param useDeltaSyncDeletedInResponse the useDeltaSyncDeletedInResponse to set
	 */
	public void setUseDeltaSyncDeletedInResponse( boolean useDeltaSyncDeletedInResponse )
	{
		this.useDeltaSyncDeletedInResponse = useDeltaSyncDeletedInResponse;
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
		final MessageDigest md = MessageDigest.getInstance( "SHA-256" );
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

	/**
	 * @return the hooksInUsedModulesEnabled
	 */
	public Boolean getHooksInUsedModulesEnabled( )
	{
		return this.hooksInUsedModulesEnabled;
	}

	/**
	 * Has to be set explicitly to true to secure execution of hook-methods for classes in used modules
	 * 
	 * @param hooksInUsedModulesEnabled the hooksInUsedModulesEnabled-flag to set
	 */
	public void setHooksInUsedModulesEnabled( Boolean hooksInUsedModulesEnabled )
	{
		this.hooksInUsedModulesEnabled = hooksInUsedModulesEnabled;
	}
}
