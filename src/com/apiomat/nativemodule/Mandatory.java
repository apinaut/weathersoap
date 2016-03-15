/* Copyright (c) 2011 - 2015 All Rights Reserved, http://www.apiomat.com/
 *
 * This source is property of apiomat.com. You are not allowed to use or distribute this code without a contract
 * explicitly giving you these permissions. Usage of this code includes but is not limited to running it on a server or
 * copying parts from it.
 *
 * Apinauten GmbH, Hainstrasse 4, 04109 Leipzig, Germany
 *
 * 04.01.2012
 * andreasfey */
package com.apiomat.nativemodule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a field as mandatory; this will be checked in dashboard, and a dialoge will open for this field
 *
 * @author andreasfey
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( value = ElementType.FIELD )
public @interface Mandatory
{}
