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
* Generated class for your Role data model 
* 
* DO NOT CHANGE ANY CODE EXCEPT CLASS ANNOTATIONS OR CLASS ATTRIBUTES HERE!
* EVERYTHING ELSE WILL GET OVERWRITTEN!
* 
*/
@SuppressWarnings( "unused" )
@Model( moduleName = "Basics" )
public class Role extends AbstractClientDataModel implements IModel<Role>
{
    /**
     * Contains the name of the module that this model belongs to
     */
    public static final String MODULE_NAME = "Basics";
    /**
     * Contains the name of the model
     */
    public static final String MODEL_NAME = "Role";
    
    /** class specific attributes */
    private List<String> members = new ArrayList<>();
    @Mandatory
    private String name = null;
    /**
     * Protected constructor; to create a new instance, use the createObject() method
     */
    public Role ()
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

    public List<String> getMembers()
    {
         return this.members;
    }

    public void setMembers( List<String> arg )
    {
        this.members = arg;
    }

    public String getName()
    {
         return this.name;
    }

    public void setName( String arg )
    {
        this.name = arg;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void write( final Kryo kryo, final Output output )
    {
        super.write( kryo, output );
        output.writeInt( this.members == null ? -1 : this.members.size() );
        
        if(this.members != null)
            for( String _members : this.members )
        {
            output.writeString( _members );
        }
        final String _name = this.name;
        output.writeBoolean( _name != null );
        if( _name != null )
        {
            output.writeString( _name );
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void read( final Kryo kryo, final Input input )
    {
        super.read( kryo, input );
        
        final Request req = (Request)kryo.getContext( ).get( "creq" );
        req.toString( );
        int membersSize = input.readInt();

        if(membersSize >= 0)
        {
            this.members = new ArrayList<>();
        }
        else if(membersSize == -1)
        {
            this.members = null;        }
        for(int i=0; i<membersSize; i++)
        {
            this.members.add( input.readString( ) );
        }
        if( input.readBoolean() )
        {
            this.name = input.readString( );
        }
    }
}
