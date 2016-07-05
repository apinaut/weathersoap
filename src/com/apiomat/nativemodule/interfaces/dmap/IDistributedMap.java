/* Copyright (c) 2014 All Rights Reserved, http://www.apiomat.com/
 *
 * This source is property of apiomat.com. You are not allowed to use or distribute this code without a contract
 * explicitly giving you these permissions. Usage of this code includes but is not limited to running it on a server or
 * copying parts from it.
 *
 * Apinauten GmbH, Hainstrasse 10a, 04109 Leipzig, Germany
 *
 * 21.03.2016
 * phimi */
package com.apiomat.nativemodule.interfaces.dmap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author phimi
 * @param <K> the map key type
 * @param <V> the map value type
 */
public interface IDistributedMap<K, V>
{

	/**
	 * Returns {@code true} if this map contains an entry for the specified
	 * key.
	 * <p/>
	 * <p>
	 * <b>Warning:</b>
	 * </p>
	 * <p>
	 * This method uses <tt>hashCode</tt> and <tt>equals</tt> of binary form of the <tt>key</tt>, not the actual
	 * implementations of <tt>hashCode</tt> and <tt>equals</tt> defined in <tt>key</tt>'s class.
	 * </p>
	 *
	 * @param key
	 * @return {@code true} if this map contains an entry for the specified key
	 * @throws NullPointerException if the specified key is null
	 */
	boolean containsKey( K key );

	/**
	 * Returns {@code true} if this map contains an entry for the specified
	 * value.
	 *
	 * @param value
	 * @return {@code true} if this map contains an entry for the specified value
	 * @throws NullPointerException if the specified value is null
	 */
	boolean containsValue( V value );

	/**
	 * /**
	 * Returns the value for the specified key, or {@code null} if this map does not contain this key.
	 * <p/>
	 * <p>
	 * <b>Warning:</b>
	 * </p>
	 * <p>
	 * This method returns a clone of original value, modifying the returned value does not change the actual value in
	 * the map. One should put modified value back to make changes visible to all nodes.
	 *
	 * <pre>
	 * V value = map.get( key );
	 * value.updateSomeProperty( );
	 * map.put( key, value );
	 * </pre>
	 *
	 * </p>
	 * <p/>
	 * <p>
	 * <b>Warning-2:</b>
	 * </p>
	 * This method uses <tt>hashCode</tt> and <tt>equals</tt> of binary form of
	 * the <tt>key</tt>, not the actual implementations of <tt>hashCode</tt> and <tt>equals</tt> defined in <tt>key</tt>
	 * 's class.
	 * <p/>
	 *
	 * @param key key
	 * @return value
	 * @throws NullPointerException if the specified key is null
	 */
	V get( K key );

	/**
	 * Associates the specified value with the specified key in this map
	 * If the map previously contained a mapping for
	 * the key, the old value is replaced by the specified value.
	 * if there was no mapping for {@code key}.
	 * <p/>
	 * <p>
	 * <b>Warning:</b>
	 * </p>
	 * <p>
	 * This method returns a clone of previous value, not the original (identically equal) value previously put into
	 * map.
	 * </p>
	 * <p/>
	 * <p>
	 * <b>Warning-2:</b>
	 * </p>
	 * This method uses <tt>hashCode</tt> and <tt>equals</tt> of binary form of
	 * the <tt>key</tt>, not the actual implementations of <tt>hashCode</tt> and <tt>equals</tt> defined in <tt>key</tt>
	 * 's class.
	 *
	 * @param key
	 * @param value
	 * @return previous value associated with {@code key} or {@code null}
	 * @throws NullPointerException if the specified key or value is null
	 */
	V put( K key, V value );

	/**
	 * Removes the mapping for a key from this map if it is present.
	 * <p>
	 * The map will not contain a mapping for the specified key once the call returns.
	 * <p/>
	 * <p>
	 * <b>Warning:</b>
	 * </p>
	 * <p>
	 * This method uses <tt>hashCode</tt> and <tt>equals</tt> of binary form of the <tt>key</tt>, not the actual
	 * implementations of <tt>hashCode</tt> and <tt>equals</tt> defined in <tt>key</tt>'s class.
	 * </p>
	 * <p/>
	 * <p>
	 * <b>Warning-2:</b>
	 * </p>
	 * <p>
	 * This method returns a clone of previous value, not the original (identically equal) value previously put into
	 * map.
	 * </p>
	 *
	 * @param key
	 * @return previous value associated with {@code key} or {@code null} if there was no mapping for {@code key}.
	 * @throws NullPointerException if the specified key is null
	 */
	V remove( K key );

	/**
	 * Removes the entry for a key only if currently mapped to a given value.
	 * This is equivalent to
	 *
	 * <pre>
	 * if ( map.containsKey( key ) &amp;&amp; map.get( key ).equals( value ) )
	 * {
	 * 	map.remove( key );
	 * 	return true;
	 * }
	 * else
	 * 	return false;
	 * </pre>
	 *
	 * except that the action is performed atomically.
	 * <p/>
	 * <p>
	 * <b>Warning:</b>
	 * </p>
	 * This method uses <tt>hashCode</tt> and <tt>equals</tt> of binary form of
	 * the <tt>key</tt>, not the actual implementations of <tt>hashCode</tt> and <tt>equals</tt> defined in <tt>key</tt>
	 * 's class.
	 *
	 * @param key
	 * @param value
	 * @return {@code true} if the value was removed
	 * @throws NullPointerException if the specified key or value is null
	 */
	boolean remove( K key, V value );

	/**
	 * Removes the mapping for a key from this map if it is present
	 * (optional operation).
	 * <p/>
	 * <p>
	 * Differently from {@link #remove(Object)}; this operation does not return removed value to avoid serialization
	 * cost of returned value.
	 * <p/>
	 * If the removed value will not be used, delete operation should be preferred over remove operation for a better
	 * performance.
	 * <p/>
	 * <p>
	 * The map will not contain a mapping for the specified key once the call returns.
	 * <p/>
	 * <p>
	 * <b>Warning:</b>
	 * </p>
	 * This method breaks the contract of EntryListener.
	 * When an entry is removed by delete(), it fires an EntryEvent with a null oldValue.
	 * <p/>
	 * Also listener with predicates, will have null values, so only keys can be queried via predicates.
	 * <p/>
	 *
	 * @param key key whose mapping is to be removed from the map
	 * @throws ClassCastException if the key is of an inappropriate type for
	 *         this map (optional)
	 * @throws NullPointerException if the specified key is null
	 */
	void delete( K key );

	/**
	 * Returns the entries for the given keys.
	 * <p/>
	 * <p>
	 * <b>Warning:</b>
	 * </p>
	 * The returned map is <b>NOT</b> backed by the original map,
	 * so changes to the original map are <b>NOT</b> reflected in the returned map, and vice-versa.
	 * <p/>
	 * <p>
	 * <b>Warning-2:</b>
	 * </p>
	 * This method uses <tt>hashCode</tt> and <tt>equals</tt> of binary form of
	 * the <tt>keys</tt>, not the actual implementations of <tt>hashCode</tt> and <tt>equals</tt> defined in
	 * <tt>key</tt>'s class.
	 * <p/>
	 *
	 * @param keys keys to get
	 * @return map of entries
	 * @throws NullPointerException if any of the specified keys are null
	 */
	Map<K, V> getAll( Set<K> keys );

	/**
	 * This method clears the map
	 * <p/>
	 * The MAP_CLEARED event is fired for any registered listeners.
	 */
	void clear( );

	/**
	 * Returns a collection clone of the values contained in this map.
	 * The collection is <b>NOT</b> backed by the map,
	 * so changes to the map are <b>NOT</b> reflected in the collection, and vice-versa.
	 *
	 * @return a collection clone of the values contained in this map
	 */
	Collection<V> values( );

	/**
	 * Returns a {@link Set} clone of the mappings contained in this map.
	 * The set is <b>NOT</b> backed by the map,
	 * so changes to the map are <b>NOT</b> reflected in the set, and vice-versa.
	 *
	 * @return a set clone of the keys mappings in this map
	 */
	Set<Map.Entry<K, V>> entrySet( );
}
