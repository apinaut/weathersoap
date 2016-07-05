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
 * @param <K>
 * @param <V>
 */
public interface IDistributedMapHandler<K, V>
{
	/**
	 * Returns the map implementation
	 *
	 * @return the map
	 */
	public IDistributedMap<K, V> getMap( );

	/**
	 * Add a listener to specific map
	 *
	 * @param listener
	 * @return Returns uuid of this registered listener
	 */
	public String addListener( final IDistributedMapListener<K, V> listener );

	/**
	 * Remove a listener from a map
	 *
	 * @param listenerID the uuid of the listener
	 * @return {@code true} if listener was successfully removed
	 */
	public boolean removeListener( final String listenerID );
}
