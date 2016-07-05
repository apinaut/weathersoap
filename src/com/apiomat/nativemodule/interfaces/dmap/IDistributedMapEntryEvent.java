/*
 * Copyright (c) 2014 All Rights Reserved, http://www.apiomat.com/
 *
 * This source is property of apiomat.com. You are not allowed to use or distribute this code without a contract
 * explicitly giving you these permissions. Usage of this code includes but is not limited to running it on a server or
 * copying parts from it.
 *
 * Apinauten GmbH, Hainstrasse 10a, 04109 Leipzig, Germany
 *
 * 21.03.2016
 * phimi
 */
package com.apiomat.nativemodule.interfaces.dmap;

/**
 * @author phimi
 * @param <K> key type of map
 * @param <V> value type of map
 */
public interface IDistributedMapEntryEvent<K, V>
{
	/**
	 * Returns the key of the entry event.
	 *
	 * @return the key of the entry event
	 */
	public K getKey( );

	/**
	 * Returns the old value of the entry event.
	 *
	 * @return the old value of the entry event.
	 */
	public V getOldValue( );

	/**
	 * Returns the value of the entry event.
	 *
	 * @return the value of the entry event
	 */
	public V getValue( );

}
