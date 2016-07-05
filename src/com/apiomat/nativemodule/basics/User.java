/*
 * Copyright (c) 2011 - 2016, Apinauten GmbH
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
package com.apiomat.nativemodule.basics;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.apiomat.nativemodule.*;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;


import com.apiomat.nativemodule.basics.*;

/**
* Generated default class representing a user in your app 
* 
* DO NOT CHANGE ANY CODE EXCEPT CLASS ANNOTATIONS OR CLASS ATTRIBUTES HERE!
* EVERYTHING ELSE WILL GET OVERWRITTEN!
* 
*/
@SuppressWarnings( "unused" )
@Model( moduleName = "Basics" )
public class User extends AbstractClientDataModel implements IModel<User>
{
    /**
     * Contains the name of the module that this model belongs to
     */
    public static final String MODULE_NAME = "Basics";
    /**
     * Contains the name of the model
     */
    public static final String MODEL_NAME = "User";
    
    /** class specific attributes */
    private Date dateOfBirth = null;
    private Map<String, Object> dynamicAttributes = new ConcurrentHashMap<>();
    private String firstName = null;
    private String lastName = null;
    private double[] loc;
    private String password = null;
    private String sessionToken = null;
    @Mandatory
    private String userName = null;
    /**
     * Protected constructor; to create a new instance, use the createObject() method
     */
    public User ()
    {}
    
    /**
     * Returns the name of the module where this class belongs to
     */
    @Override
    public String getModuleName( )
    {
        return MODULE_NAME;
    }
    
    /**
     * Returns the name of the model
     */
    @Override
    public String getModelName( )
    {
        return MODEL_NAME;
    }

    public Date getDateOfBirth()
    {
         return this.dateOfBirth;
    }

    public void setDateOfBirth( Date arg )
    {
        this.dateOfBirth = arg;
    }

    public Map<String, Object> getDynamicAttributes()
    {
       return this.dynamicAttributes;
    }

    public void setDynamicAttributes( Map<String, Object> map )
    {
       this.dynamicAttributes = map;
    }

    public String getFirstName()
    {
         return this.firstName;
    }

    public void setFirstName( String arg )
    {
        this.firstName = arg;
    }

    public String getLastName()
    {
         return this.lastName;
    }

    public void setLastName( String arg )
    {
        this.lastName = arg;
    }

    public double getLocLatitude( )
    {
         return this.loc !=null && this.loc.length > 0 ? this.loc[0] : 0;
    }

    public double getLocLongitude( )
    {
         return this.loc !=null && this.loc.length > 1 ? this.loc[1] : 0;
    }

    public void setLocLatitude( double latitude )
    {
        if( this.loc == null )
        {
            this.loc = new double[]{};
        }

        if ( this.loc.length < 2 )
        {
            this.loc = new double[]{ latitude, 0 };
        }
        else
        {
            this.loc[0] = latitude;
        }
    }

    public void setLocLongitude( double longitude )
    {
        if( this.loc == null )
        {
            this.loc = new double[]{};
        }

        if ( this.loc.length < 2 )
        {
            this.loc = new double[]{ 0, longitude };
        }
        else
        {
            this.loc[1] = longitude;
        }
    }

    public String getPassword()
    {
         return this.password;
    }

    public void setPassword( String arg )
    {
        this.password = arg;
    }

    public String getSessionToken()
    {
         return this.sessionToken;
    }

    public void setSessionToken( String arg )
    {
        this.sessionToken = arg;
    }

    public String getUserName()
    {
         return this.userName;
    }

    public void setUserName( String arg )
    {
        this.userName = arg;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void write( final Kryo kryo, final Output output )
    {
        super.write( kryo, output );
        output.writeLong( this.dateOfBirth == null ? 0 : this.dateOfBirth.getTime() );
        if( this.dynamicAttributes == null )
        {
            output.writeInt(-1);
        }
        else
        {
            output.writeInt(this.dynamicAttributes.keySet().size());
            for(String key : this.dynamicAttributes.keySet())
            {
                output.writeString( key );
                output.writeString( XSTREAM.toXML( this.dynamicAttributes.get(key) ) );
            }
        }
        final String _firstName = this.firstName;
        output.writeBoolean( _firstName != null );
        if( _firstName != null )
        {
            output.writeString( _firstName );
        }
        final String _lastName = this.lastName;
        output.writeBoolean( _lastName != null );
        if( _lastName != null )
        {
            output.writeString( _lastName );
        }
        output.writeBoolean( this.loc != null );
        if( this.loc != null)
        {
            output.writeDoubles( this.loc );
        }
        final String _password = this.password;
        output.writeBoolean( _password != null );
        if( _password != null )
        {
            output.writeString( _password );
        }
        final String _sessionToken = this.sessionToken;
        output.writeBoolean( _sessionToken != null );
        if( _sessionToken != null )
        {
            output.writeString( _sessionToken );
        }
        final String _userName = this.userName;
        output.writeBoolean( _userName != null );
        if( _userName != null )
        {
            output.writeString( _userName );
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void read( final Kryo kryo, final Input input )
    {
        super.read( kryo, input );
        
        final Request req = (Request)kryo.getContext( ).get( "creq" );
        req.toString( );
        final long _dateOfBirth = input.readLong();
        this.dateOfBirth = _dateOfBirth == 0 ? null : new Date(_dateOfBirth);
        final int dynamicAttributesSize = input.readInt();
        if(dynamicAttributesSize < 0)
        {
            this.dynamicAttributes = null;
        }
        else
        {
            this.dynamicAttributes = new HashMap<>();
        }
        for(int i=0; i<dynamicAttributesSize; i++)
        {
            String key = input.readString();
            final Object value = XSTREAM.fromXML( input.readString() );
            this.dynamicAttributes.put( key, value );
        }
        if( input.readBoolean() )
        {
            this.firstName = input.readString( );
        }
        if( input.readBoolean() )
        {
            this.lastName = input.readString( );
        }
        final boolean loc_isNotNull = input.readBoolean();
        if( loc_isNotNull )
        {
            this.loc = input.readDoubles( 2 );
        }
        if( input.readBoolean() )
        {
            this.password = input.readString( );
        }
        if( input.readBoolean() )
        {
            this.sessionToken = input.readString( );
        }
        if( input.readBoolean() )
        {
            this.userName = input.readString( );
        }
    }
}
