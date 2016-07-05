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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.thoughtworks.xstream.XStream;

/**
 * @author andreas
 */
public abstract class AbstractClientDataModel implements IModelMethods, IResourceMethods, KryoSerializable
{
	/**
	 * Static XStream var
	 */
	public static final XStream XSTREAM = new XStream( );

	/** The customer-provided ID of this object */
	protected String foreignId;
	/** Creation date of this object */
	protected Date createdAt;
	/** Date of last mofification */
	protected Date lastModifiedAt;
	/** The system-provided ID of this object */
	protected String id;
	/** user name of the owner */
	protected String ownerUserName;
	/** Role names which are allowed to read this object */
	protected Set<String> allowedRolesRead = new HashSet<>( );
	/** Role names which are allowed to write this object */
	protected Set<String> allowedRolesWrite = new HashSet<>( );
	/** Role names which are allowed to set further roles for reading or writing on this object */
	protected Set<String> allowedRolesGrant = new HashSet<>( );
	/** TRUE if all attached resources on this object may also need the same authentication like the object itself */
	protected boolean restrictResourceAccess = false;

	/** attribute to inject the methods class */
	protected IModelMethods methods;

	/** attribute to inject the resource methods class */
	protected IResourceMethods resourceMethods;

	/**
	 * Sets the implementation for the IModelMethods interface
	 *
	 * @param methods IModelMethods implementation
	 */
	public void setMethods( IModelMethods methods )
	{
		this.methods = methods;
	}

	/**
	 * Sets the implementation for the IResourceMethods interface
	 *
	 * @param resourceMethods IResourceMethods implementation
	 */
	public void setResourceMethods( IResourceMethods resourceMethods )
	{
		this.resourceMethods = resourceMethods;
	}
	
	/**
	 * The module name where this class is contained in
	 *
	 * @return module name
	 */
	public abstract String getModuleName( );

	/**
	 * The classes name
	 *
	 * @return class name
	 */
	public abstract String getModelName( );
		
	@Override
	public String getId( )
	{
		return this.id;
	}

	@Override
	public void setId( String id )
	{
		this.id = id;
	}

	@Override
	public String getForeignId( )
	{
		return this.foreignId;
	}

	@Override
	public void setForeignId( String foreignId )
	{
		this.foreignId = foreignId;
	}

	@Override
	public Date getLastModifiedAt( )
	{
		return this.lastModifiedAt;
	}

	@Override
	public void setLastModifiedAt( Date lastModified )
	{
		this.methods.setLastModifiedAt( lastModified );
		this.lastModifiedAt = this.methods.getLastModifiedAt( );
	}

	@Override
	public void setCreatedAt( Date createdAt )
	{
		this.methods.setCreatedAt( createdAt );
		this.createdAt = this.methods.getCreatedAt( );
	}

	@Override
	public Date getCreatedAt( )
	{
		return this.createdAt;
	}

	@Override
	public String save( )
	{
		this.id = this.methods.save( );
		return getId( );
	}

	@Override
	public boolean delete( )
	{
		return this.methods.delete( );
	}

	@Override
	public String getApplicationName( )
	{
		return this.methods.getApplicationName( );
	}

	@Override
	public String getOwnerUserName( )
	{
		return this.ownerUserName;
	}

	public void setOwnerUserName( String ownerUserName )
	{
		this.ownerUserName = ownerUserName;
	}

	@Override
	public String[ ] getAllowedRolesRead( )
	{
		return this.allowedRolesRead.toArray( new String[ ] { } );
	}

	@Override
	public void setAllowedRolesRead( String[ ] allowedRolesRead )
	{
		this.allowedRolesRead.addAll( Arrays.asList( allowedRolesRead ) );
	}

	@Override
	public String[ ] getAllowedRolesWrite( )
	{
		return this.allowedRolesWrite.toArray( new String[ ] { } );
	}

	@Override
	public void setAllowedRolesWrite( String[ ] allowedRolesWrite )
	{
		this.allowedRolesWrite.addAll( Arrays.asList( allowedRolesWrite ) );
	}

	@Override
	public String[ ] getAllowedRolesGrant( )
	{
		return this.allowedRolesGrant.toArray( new String[ ] { } );
	}

	@Override
	public void setAllowedRolesGrant( String[ ] allowedRolesGrant )
	{
		this.allowedRolesGrant.addAll( Arrays.asList( allowedRolesGrant ) );
	}

	@Override
	public Map<String, Set<String>> getReferencedHrefs( )
	{
		return this.methods.getReferencedHrefs( );
	}

	@Override
	public boolean getRestrictResourceAccess( )
	{
		return this.restrictResourceAccess;
	}

	@Override
	public void verifyRequest( String verb, Request r ) throws Exception
	{
		this.methods.verifyRequest( verb, r );
	}

	@Override
	public byte[ ] loadResource( String href )
	{
		return this.methods.loadResource( href );
	}

	@Override
	public String saveResource( byte[ ] data, boolean isImage, String name, String format )
	{
		return this.methods.saveResource( data, isImage, name, format );
	}

	@Override
	public void addReference( String refName, IModel<?> ref )
	{
		this.methods.addReference( refName, ref );
	}

	@Override
	public void removeReference( String refName, IModel<?> ref )
	{
		this.methods.removeReference( refName, ref );
	}

	@Override
	public void log( final String message )
	{
		this.methods.log( message );
	}

	@Override
	public void logError( final String message )
	{
		this.methods.logError( message );
	}

	@Override
	public void logError( Throwable e )
	{
		this.methods.logError( e );
	}

	@Override
	public void logModel( final String message, final IModel<?>[ ] messageArray )
	{
		this.methods.logModel( message, messageArray );
	}

	@Override
	public void logModel( final String message, final IModel<?> messageModel )
	{
		this.methods.logModel( message, messageModel );
	}

	@Override
	public void logModel( final String message, final Object messageModel )
	{
		this.methods.logModel( message, messageModel );
	}

	@Override
	public void throwException( final String message )
	{
		this.methods.throwException( message );
	}

	@Override
	public void throwException( final int statusCode, final String message )
	{
		this.methods.throwException( statusCode, message );
	}

	@Override
	public <T> T loadReference( final String refName, final Class<? extends AbstractClientDataModel> refClazz )
	{
		return this.methods.loadReference( refName, refClazz );
	}

	@Override
	public <T> List<T> loadReferences( final String refName, final Class<? extends AbstractClientDataModel> refClazz )
	{
		return this.methods.loadReferences( refName, refClazz );
	}

	public IModel<?> findByForeignId( final String foreignId, final Request r )
	{
		return this.methods.findByForeignId( foreignId, getModelName( ), r );
	}

	@Override
	public IModel<?> findByForeignId( final String foreignId, final String className, final Request r )
	{
		return this.methods.findByForeignId( foreignId, className, r );
	}

	@Override
	public IModel<?> findByForeignId( final String foreignId, final String moduleName, final String className,
		final Request r )
	{
		return this.methods.findByForeignId( foreignId, moduleName, className, r );
	}

	@Override
	public IModel<?>[ ] findByForeignIds( final Collection<String> foreignIds, final String moduleName,
		final String className,
		final Request r )
	{
		return this.methods.findByForeignIds( foreignIds, moduleName, className, r );
	}

	/**
	 * Finds objects by a collection of foreign IDs
	 *
	 * @param foreignIds
	 * @param clazz
	 * @param r
	 * @return objects with one of the given foreign IDs
	 */
	public <T extends AbstractClientDataModel> List<T> findByForeignIds( final Collection<String> foreignIds,
		final Class<T> clazz, final Request r )
	{
		final String moduleName = getModuleName( clazz );
		@SuppressWarnings( "unchecked" )
		final IModel<?>[ ] retRaw = this.methods.findByForeignIds( foreignIds, moduleName, clazz.getSimpleName( ), r );
		if ( retRaw == null )
		{
			return null;
		}

		final List<T> retList = new ArrayList<T>( );
		for ( IModel<?> m : retRaw )
		{
			retList.add( ( T ) m );
		}
		return retList;
	}

	@Override
	public void callMethod( String methodName, Object... params )
	{
		this.methods.callMethod( methodName, params );
	}

	public IModel<?> createObject( final Request r )
	{
		return this.methods.createObject( getModelName( ), r );
	}

	@Override
	public IModel<?> createObject( final String className )
	{
		return this.methods.createObject( className );
	}

	@Override
	public IModel<?> createObject( final String className, final Request r )
	{
		return this.methods.createObject( className, r );
	}

	@Override
	public IModel<?> createObject( final String moduleName, final String className )
	{
		return this.methods.createObject( moduleName, className );
	}

	@Override
	public IModel<?> createObject( final String moduleName, final String className, final Request r )
	{
		return this.methods.createObject( moduleName, className, r );
	}

	/**
	 * Creates a new object
	 *
	 * @param clazz
	 * @param r
	 * @return the new object
	 */
	public <T extends AbstractClientDataModel> T createObject( final Class<T> clazz, final Request r )
	{
		final String moduleName = getModuleName( clazz );
		final IModel<?> retRaw = this.methods.createObject( moduleName, clazz.getSimpleName( ), r );
		return retRaw != null ? ( T ) retRaw : null;
	}

	public IModel<?> findById( final String id, final Request r )
	{
		return this.methods.findById( id, getModelName( ), r );
	}

	@Override
	public IModel<?> findById( final String id, final String className, final Request r )
	{
		return this.methods.findById( id, className, r );
	}

	@Override
	public IModel<?> findById( final String id, final String moduleName, final String className, final Request r )
	{
		return this.methods.findById( id, moduleName, className, r );
	}

	/**
	 * Finds the object by its mongoDB ID
	 *
	 * @param id
	 * @param clazz
	 * @param r
	 * @return objects by name and query
	 */
	@SuppressWarnings( "unchecked" )
	public <T extends AbstractClientDataModel> T findById( final String id, final Class<T> clazz, final Request r )
	{
		final String moduleName = getModuleName( clazz );
		final IModel<?> retRaw = this.methods.findById( id, moduleName, clazz.getSimpleName( ), r );
		return retRaw != null ? ( T ) retRaw : null;
	}

	@Override
	public IModel<?>[ ] findByNames( final String className, final String query, final Request r )
	{
		return this.methods.findByNames( className, query, r );
	}

	@Deprecated
	public IModel<?>[ ] findByNames( final String query, final Request r )
	{
		return this.methods.findByNames( getModelName( ), query, r );
	}

	@Override
	public IModel<?>[ ] findByNames( final String moduleName, final String className, final String query,
		final Request r )
	{
		return this.methods.findByNames( moduleName, className, query, r );
	}

	/**
	 * finds the objects by name and query
	 *
	 * @param clazz
	 * @param query
	 * @param r
	 * @return objects by name and query
	 */
	public <T extends AbstractClientDataModel> List<T> findByNames( final Class<T> clazz, final String query,
		final Request r )
	{
		final String moduleName = getModuleName( clazz );
		@SuppressWarnings( "unchecked" )
		final IModel<?>[ ] retRaw = this.methods.findByNames( moduleName, clazz.getSimpleName( ), query, r );
		if ( retRaw == null )
		{
			return null;
		}

		final List<T> retList = new ArrayList<T>( );
		for ( IModel<?> m : retRaw )
		{
			retList.add( ( T ) m );
		}
		return retList;
	}

	@Override
	public String toBase64( final String str )
	{
		return this.methods.toBase64( str );
	}

	@Override
	public String getRequestingUsername( )
	{
		return this.methods.getRequestingUsername( );
	}

	@Override
	public void trackGAEvent( final String category, final String action, final String label, final String value )
	{
		this.methods.trackGAEvent( category, action, label, value );
	}

	@Override
	public void trackPiwikGoal( final int goalId )
	{
		this.methods.trackPiwikGoal( goalId );
	}

	@Override
	public void trackPiwikCustomVars( final String action, final String userName, final int id, final String key,
		final String value )
	{
		this.methods.trackPiwikCustomVars( action, userName, id, key, value );
	}

	@Override
	public String postData( final ResourceType type, final String name, final String format, byte[ ] data )
	{
		return this.resourceMethods.postData( type, name, format, data );
	}

	@Override
	public boolean deleteData( final ResourceType type, String url )
	{
		return this.resourceMethods.deleteData( type, url );
	}

	@Override
	public byte[ ] getData( ResourceType type, String url )
	{
		return this.resourceMethods.getData( type, url );
	}

	@Override
	public HttpServletRequest getHttpServletRequest( )
	{
		return this.methods.getHttpServletRequest( );
	}

	private <T extends AbstractClientDataModel> String getModuleName( final Class<T> clazz )
	{
		String moduleName;
		try
		{
			moduleName = clazz.newInstance( ).getModuleName( );
		}
		catch ( Exception e )
		{
			moduleName = getModuleName( );
		}
		return moduleName;
	}

	@Override
	public void write( Kryo kryo, Output output )
	{
		output.writeBoolean( this.id != null );
		if ( this.id != null )
		{
			output.writeString( this.id );
		}
		output.writeBoolean( getForeignId( ) != null );
		if ( getForeignId( ) != null )
		{
			output.writeString( getForeignId( ) );
		}
		output.writeString( getModuleName( ) );
		output.writeString( getModelName( ) );
		output.writeString( getApplicationName( ) );
		output.writeString( getOwnerUserName( ) );
		output.writeInt( this.allowedRolesRead.size( ) );
		for ( String role : this.allowedRolesRead )
		{
			output.writeString( role );
		}
		output.writeInt( this.allowedRolesWrite.size( ) );
		for ( String role : this.allowedRolesWrite )
		{
			output.writeString( role );
		}
		output.writeInt( this.allowedRolesGrant.size( ) );
		for ( String role : this.allowedRolesGrant )
		{
			output.writeString( role );
		}
		output.writeBoolean( this.restrictResourceAccess );
		output.writeLong( this.lastModifiedAt == null ? -1 : this.lastModifiedAt.getTime( ) );
		output.writeLong( this.createdAt == null ? -1 : this.createdAt.getTime( ) );
	}

	@Override
	public void read( Kryo kryo, Input input )
	{
		if ( input.readBoolean( ) )
		{
			this.id = input.readString( );
		}
		if ( input.readBoolean( ) )
		{
			this.foreignId = input.readString( );
		}
		input.readString( );
		input.readString( );
		input.readString( );
		this.ownerUserName = input.readString( );
		this.allowedRolesRead = new HashSet<>( );
		int allowedRolesReadSize = input.readInt( );
		for ( int i = 0; i < allowedRolesReadSize; i++ )
		{
			this.allowedRolesRead.add( input.readString( ) );
		}
		this.allowedRolesWrite = new HashSet<>( );
		int allowedRoleWriteSize = input.readInt( );
		for ( int i = 0; i < allowedRoleWriteSize; i++ )
		{
			this.allowedRolesWrite.add( input.readString( ) );
		}
		this.allowedRolesGrant = new HashSet<>( );
		int allowedRolesGrantSize = input.readInt( );
		for ( int i = 0; i < allowedRolesGrantSize; i++ )
		{
			this.allowedRolesGrant.add( input.readString( ) );
		}
		this.restrictResourceAccess = input.readBoolean( );
		long lma = input.readLong( );
		if ( lma > -1 )
		{
			this.lastModifiedAt = new Date( lma );
		}
		long ca = input.readLong( );
		if ( ca > -1 )
		{
			this.createdAt = new Date( ca );
		}
	}
}
