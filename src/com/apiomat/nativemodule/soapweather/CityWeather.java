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
package com.apiomat.nativemodule.soapweather;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.apiomat.nativemodule.*;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;


import com.apiomat.nativemodule.basics.*;

/**
* Generated class for your CityWeather data model 
* 
* DO NOT CHANGE ANY CODE EXCEPT CLASS ANNOTATIONS OR CLASS ATTRIBUTES HERE!
* EVERYTHING ELSE WILL GET OVERWRITTEN!
* 
*/
@SuppressWarnings( "unused" )
@Model( moduleName = "SOAPWeather", hooksClassName = "com.apiomat.nativemodule.soapweather.CityWeatherHooks", 
    isTransient = false, 
    requiredUserRoleCreate=UserRole.User, requiredUserRoleRead=UserRole.User, 
    requiredUserRoleWrite=UserRole.Owner, restrictResourceAccess=false,
    allowedRolesCreate={}, allowedRolesRead={},
    allowedRolesWrite={}, allowedRolesGrant={})
public class CityWeather extends AbstractClientDataModel implements IModel<CityWeather>
{
    /** class specific attributes */
    private String cityName = null;
    private String countryName = null;
    private Double temperature = null;
    /**
    * Protected constructor; to create a new instance, use the createObject() method
    */
    public CityWeather ()
    {}
    
    /**
    * Returns the name of the module where this class belongs to
    */
    @Override
    public String getModuleName( )
    {
        return "SOAPWeather";
    }
    
     /**
    * Returns the name of the model
    */
    @Override
    public String getModelName( )
    {
        return "CityWeather";
    }

    public String getCityName()
    {
         return this.cityName;
    }

    public void setCityName( String arg )
    {
        this.cityName = arg;
    }

    public String getCountryName()
    {
         return this.countryName;
    }

    public void setCountryName( String arg )
    {
        this.countryName = arg;
    }

    public Double getTemperature()
    {
         return this.temperature;
    }

    public void setTemperature( Double arg )
    {
        this.temperature = arg;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void write( final Kryo kryo, final Output output )
    {
        super.write( kryo, output );
        final String _cityName = this.cityName;
        output.writeBoolean( _cityName != null );
        if( _cityName != null )
        {
            output.writeString( _cityName );
        }
        final String _countryName = this.countryName;
        output.writeBoolean( _countryName != null );
        if( _countryName != null )
        {
            output.writeString( _countryName );
        }
        final Double _temperature = this.temperature;
        output.writeBoolean( _temperature != null );
        if( _temperature != null )
        {
            output.writeDouble( _temperature );
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void read( final Kryo kryo, final Input input )
    {
        super.read( kryo, input );
        if( input.readBoolean() )
        {
            this.cityName = input.readString( );
        }
        if( input.readBoolean() )
        {
            this.countryName = input.readString( );
        }
        if( input.readBoolean() )
        {
            this.temperature = input.readDouble( );
        }
    }
}