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
 * 
 * THIS FILE IS GENERATED AUTOMATICALLY. DON'T MODIFY IT.
 */
package com.apiomat.nativemodule;

/**
 * Interface for resource methods.
 * 
 * This class is also delived to module develpers via module SDK. Developers can implement their own stub methods my
 * implementing this interface and setting the setResourceMethods in the model class. On server side, an own
 * implementation is
 * used to manage database access
 * 
 * @author andreas
 */
public interface IResourceMethods
{
	/**
	 * The type of the resource
	 * 
	 * @author andreas
	 */
	public enum ResourceType
	{
		IMAGE, FILE;
	}

	/**
	 * Posts data and returns the URL to it
	 * 
	 * @param data the data
	 * @return URL
	 */
	public String postData( final ResourceType type, final String name, final String format, final byte[ ] data );

	/**
	 * Deletes data by its URL
	 * 
	 * @param url the URL
	 * @return TRUE on success
	 */
	public boolean deleteData( final ResourceType type, final String url );

	/**
	 * Returns the data of an image based on its URL
	 * 
	 * @param type
	 * @param url
	 * @return
	 */
	public byte[ ] getData( final ResourceType type, final String url );
}
