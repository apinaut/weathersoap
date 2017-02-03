/*
 * Copyright (c) 2011 - 2017, Apinauten GmbH
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

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXB;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.xml.sax.SAXException;

import com.apiomat.nativemodule.AbstractClientDataModel;
import com.apiomat.nativemodule.IModelHooksTransient;
import com.apiomat.nativemodule.Request;
import com.apiomat.nativemodule.soapweathertransient.xml.NewDataSet;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 * Generated class for hooks on your City data model
 */

public class CityHooksTransient<T extends City> implements IModelHooksTransient<City>
{
	protected City model;

	@Override
	public void setCallingModel( City model )
	{
		this.model = model;
	}

	/* do-Methods can be used if your data model is set to TRANSIENT */

	@Override
	public String doPost( City obj, Request r )
	{
		return null;
	}

	@Override
	public void doPut( City obj, Request r )
	{}

	@Override
	public City doGet( String foreignId, Request r )
	{
		return null;
	}

	@Override
	public boolean doDelete( String foreignId, Request r )
	{
		return false;
	}

	@Override
	public List<City> doGetAll( String query, Request r )
	{
		String countryName = "Germany";
		Matcher matches = Pattern.compile( "countryName == \"(.*?)\"" ).matcher( query );
		if ( matches.find( ) )
		{
			countryName = matches.group( 1 );
		}
		List<City> cityList = new ArrayList<>( );
		if ( StringUtils.isNotBlank( countryName ) )
		{
			GlobalWeather weatherServiceStub = new GlobalWeather( );
			final GlobalWeatherSoap webService = weatherServiceStub.getGlobalWeatherSoap12( );
			String weatherCity = webService.getCitiesByCountry( countryName );
			SOAPWeatherTransient.AOM.log( r.getApplicationName( ), "String: " + weatherCity );
			/* write result to obj */
			try
			{
				final List<NewDataSet.Table> elements = parseResult( weatherCity );
				if ( elements != null )
				{
					for ( NewDataSet.Table cityElem : elements )
					{
						City city =
							( City ) SOAPWeatherTransient.AOM.createObject( r.getApplicationName( ),
								City.MODULE_NAME, City.MODEL_NAME, r );
						city.setCityName( cityElem.getCity( ) );
						city.setCountryName( cityElem.getCountry( ) );
						cityList.add( city );
					}
				}
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

	/* Please note: Before doPostRef gets called, doGet gets called internally,
	 * so that this.model can be populated with attribute values. */
	@Override
	public void doPostRef( Object referencedObject, String referenceName, Request r )
	{}

	/* Please note: Before doDeleteRef gets called, doGet gets called internally,
	 * so that this.model can be populated with attribute values. */
	@Override
	public void doDeleteRef( String refName, String refForeignId, Request r )
	{}

	/* Please note: Before doGetRef gets called, doGet gets called internally,
	 * so that this.model can be populated with attribute values. */
	@Override
	public <Z extends AbstractClientDataModel> List<Z> doGetRef( String refName, String query, Request r )
	{
		return null;
	}

	/**
	 * @param weatherCity
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	private List<NewDataSet.Table> parseResult( final String weatherResult )
		throws ParserConfigurationException, SAXException,
		IOException
	{
		final NewDataSet set = JAXB.unmarshal( new StringReader( weatherResult ), NewDataSet.class );
		return set.getTable( );
	}
}
