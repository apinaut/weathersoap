/* Copyright (c) 2011 - 2016 All Rights Reserved, http://www.apiomat.com/
 *
 * This source is property of apiomat.com. You are not allowed to use or distribute this code without a contract
 * explicitly giving you these permissions. Usage of this code includes but is not limited to running it on a server or
 * copying parts from it.
 *
 * Apinauten GmbH, Hainstrasse 4, 04109 Leipzig, Germany
 *
 * 21.06.2016
 * 
 * @author glenn */

package com.apiomat.nativemodule;

/* enumeration that holds information about the authentication status of a model within a native module */
public enum AuthState
{
	/* model is providing an auth method */
	YES,
	/* model is not providing an auth method */
	NO,
	/* we do not know if model provides an auth method, usually it is because model was defined in a native model, that
	 * was using the old hooks */
	UNKNOWN
}