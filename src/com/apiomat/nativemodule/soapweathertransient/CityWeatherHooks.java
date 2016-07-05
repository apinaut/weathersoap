/*
 * Copyright (c) 2011 - 2015, Apinauten GmbH
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
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
 */
package com.apiomat.nativemodule.soapweathertransient;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.apiomat.nativemodule.AbstractClientDataModel;
import com.apiomat.nativemodule.IModelHooks;
import com.apiomat.nativemodule.Request;

/**
 * Generated class for hooks on your CityWeather data model
 */
public class CityWeatherHooks<T extends CityWeather> implements IModelHooks<CityWeather>
{
	protected CityWeather model;

	@Override
	public void setCallingModel( CityWeather model )
	{
		this.model = model;
	}

	/* do-Methods can be used if your data model is set to TRANSIENT */

	@Override
	public String doPost( CityWeather obj, Request r )
	{
		return null;
	}

	@Override
	public void doPut( CityWeather obj, Request r )
	{}

	@Override
	public CityWeather doGet( String foreignId, Request r )
	{
		return null;
	}

	@Override
	public boolean doDelete( String foreignId, Request r )
	{
		return false;
	}

	@Override
	public List<CityWeather> doGetAll( String query, Request r )
	{
		String cityName = "Frankfurt";
		String countryName = "Germany";
		Matcher matches = Pattern.compile( "cityName == \"(.*?)\" && countryName == \"(.*?)\"" ).matcher( query );
		if ( matches.find( ) )
		{
			cityName = matches.group( 1 );
			countryName = matches.group( 2 );
		}
		List<CityWeather> cityList = new ArrayList<>( );
		if ( StringUtils.isNotBlank( cityName ) && StringUtils.isNotBlank( countryName ) )
		{
			GlobalWeather weatherServiceStub = new GlobalWeather( );
			final GlobalWeatherSoap webService = weatherServiceStub.getGlobalWeatherSoap12( );
			String weatherCity = webService.getWeather( cityName, countryName );
			SOAPWeatherTransient.AOM.log( r.getApplicationName( ), "String: " + weatherCity );
			/* write result to obj */
			try
			{
				final long resultInC = parseResult( weatherCity );
				CityWeather weatherObj =
					( CityWeather ) SOAPWeatherTransient.AOM.createObject( r.getApplicationName( ),
						SOAPWeatherTransient.class.getSimpleName( ), CityWeather.class.getSimpleName( ), r );
				weatherObj.setCityName( cityName );
				weatherObj.setCountryName( countryName );
				weatherObj.setTemperature( resultInC * 1.0d );
				cityList.add( weatherObj );
			}
			catch ( ParserConfigurationException | SAXException | IOException e )
			{
				SOAPWeatherTransient.AOM
					.logError( r.getApplicationName( ), "Can't get temperature: " + e.getMessage( ) );
			}
		}
		return cityList;
	}

	@Override
	public long doCountAll( String query, Request r )
	{
		return 0;
	}

	@Override
	public void doPostRef( Object referencedObject, String referenceName, Request r )
	{}

	@Override
	public void doDeleteRef( String refName, String refForeignId, Request r )
	{}

	@Override
	public <Z extends AbstractClientDataModel> List<Z> doGetRef( String refName, String query, Request r )
	{
		return null;
	}

	@Override
	public boolean auth( String httpVerb, String modelName, String modelForeignId, String userNameOrEmail,
		String password, Request r )
	{
		return false;
	}

	/* Following Methods can be used if your data model is NOT set to TRANSIENT */

	@Override
	public void beforePost( CityWeather obj, Request r )
	{}

	@Override
	public void afterPost( CityWeather obj, Request r )
	{}

	@Override
	public void beforeGet( CityWeather obj, Request r )
	{}

	@Override
	public boolean beforePut( CityWeather objFromDB, CityWeather obj, Request r )
	{

		return false;
	}

	/**
	 * @param weatherCity
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	private long parseResult( final String weatherResult ) throws ParserConfigurationException, SAXException,
		IOException
	{
		long temp = -1000;
		if ( StringUtils.isNotBlank( weatherResult ) )
		{
			InputStream stream = new ByteArrayInputStream( weatherResult.getBytes( StandardCharsets.UTF_16 ) );
			DocumentBuilder builder = DocumentBuilderFactory.newInstance( ).newDocumentBuilder( );
			Document doc = builder.parse( stream );
			NodeList currentWeatherXML = doc.getElementsByTagName( "Temperature" );
			Node tempNode = currentWeatherXML.item( 0 );
			if ( tempNode != null )
			{
				final String content = tempNode.getTextContent( );
				if ( content != null )
				{
					Matcher matches = Pattern.compile( ".*?\\(([0-9]+).*?\\)" ).matcher( content );
					if ( matches.find( ) )
					{
						final String tempStr = matches.group( 1 );
						if ( StringUtils.isNotBlank( tempStr ) )
						{
							temp = Long.valueOf( tempStr );
						}
					}
				}
			}
		}
		return temp;
	}

	@Override
	public void afterPut( CityWeather obj, Request r )
	{

	}

	@Override
	public boolean beforeDelete( CityWeather obj, Request r )
	{
		return false;
	}

	@Override
	public List<CityWeather> afterGetAll( List<CityWeather> objects, String query, Request r )
	{
		/* If you want to change the retuned list of elements, you have to create a new list
		 * and add the elements to return to it. Because getting elements from the "objects"
		 * list will return a copy, changing values in this list does not have any effect.
		 * 
		 * If NULL is returned, unnecessary conversions are omitted and result is taken from database. */
		return null;
	}

	@Override
	public boolean beforePostRef( CityWeather obj, Object referencedObject, String referenceName, Request r )
	{
		return false;
	}

	@Override
	public void afterPostRef( CityWeather obj, Object referencedObject, String referenceName, Request r )
	{}

	@Override
	public boolean beforeDeleteRef( CityWeather obj, Object referencedObject, String referenceName, Request r )
	{
		return false;
	}

	@Override
	public void afterDeleteRef( CityWeather obj, Object referencedObject, String referenceName, Request r )
	{}

	@Override
	public <Z extends AbstractClientDataModel> List<Z> afterGetAllReferences( List<Z> objects, String query,
		String referenceName, Request request )
	{
		return null; // return objects here if you changed sth; returning null prevents unnecessary conversions
	}
}
