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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Andreas Fey
 */
@Target( value = ElementType.FIELD )
@Retention( RetentionPolicy.RUNTIME )
public @interface NativeModuleConfig
{

	/**
	 * Datatype enum for defining which kind of value should be used
	 *
	 * @author andreasfey
	 */
	public enum Type
	{
		NUMBER,
		TEXT,
		TIMESTAMP,
		ENUM,
		BOOLEAN,
		TEXTAREA,
		FILEUPLOAD,
		PASSWORD
	}

	/** The key to be used in the app configuration. */
	String key( ) default "";

	/** A list of possible values, this is just to give the user some hints. */
	String values( ) default "";

	/** The default value that could be set if the user does not overwrite this field. */
	String defaultValue( ) default "";

	/** Some info or description or tool tip about this key. */
	String info( ) default "";

	/** A title for this config */
	String title( );

	/** Some example values to illustrate the user how a valid value could look like. */
	String example( ) default "";

	/** Datatype for the field */
	Type datatype( );

	/** display order of this config */
	int order( );
}