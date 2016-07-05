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
 * Listener class to observe changes of a map
 *
 * @author phimi
 * @param <K> key type of map
 * @param <V> value type of map
 */
public interface IDistributedMapListener<K, V>
{
	/**
	 * Invoked when an entry is added.
	 *
	 * @param event entry event
	 */
	public void entryAdded( IDistributedMapEntryEvent<K, V> event );

	/**
	 * Invoked when an entry is updated.
	 *
	 * @param event entry event
	 */
	public void entryUpdated( IDistributedMapEntryEvent<K, V> event );

	/**
	 * Invoked when an entry is removed.
	 *
	 * @param event entry event
	 */
	public void entryRemoved( IDistributedMapEntryEvent<K, V> event );

	/**
	 * Invoked when all entries are removed by {@link IDistributedMap#clear()}.}
	 */
	void mapCleared( );

}
