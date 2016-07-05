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
 * @param <K> key of map
 * @param <V> value of map
 */
public abstract class ADistributedMapHandler<K, V> implements IDistributedMapHandler<K, V>
{
	/**
	 * unique name of the map
	 */
	protected final String mapName;

	/**
	 * Constructor
	 *
	 * @param mapName unique name of the map
	 */
	public ADistributedMapHandler( final String mapName )
	{
		this.mapName = mapName;
	}
}
