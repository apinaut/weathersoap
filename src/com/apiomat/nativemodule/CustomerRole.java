/* Copyright (c) 2011 - 2015 All Rights Reserved, http://www.apiomat.com/
 * 
 * This source is property of apiomat.com. You are not allowed to use or distribute this code without a contract
 * explicitly giving you these permissions. Usage of this code includes but is not limited to running it on a server or
 * copying parts from it.
 * 
 * Apinauten GmbH, Hainstrasse 4, 04109 Leipzig, Germany
 * 
 * 18.12.2014
 * andreas */
package com.apiomat.nativemodule;

import java.util.HashSet;
import java.util.Set;

/**
 * Enum which holds all available roles for a customer;
 * Roles are ordered by master and sub roles (see wiki).
 *
 *
 * @author andreas
 */
public enum CustomerRole
{
	/** master role owning an app or module */
	ADMIN( null, null ),
	/** sub roles of ADMIN */
	DEPLOY( null, ADMIN ),

	/** master role WRITE */
	WRITE( ADMIN, null ),
	/** sub roles of WRITE */
	WRITE_DATA( null, WRITE ),

	/** master role READ */
	READ( WRITE, null ),
	/** sub roles of READ */
	DOWNLOAD_SDK( null, READ ),
	READ_LOGS( null, READ ),
	READ_DATA( null, READ ),
	READ_ANALYTICS( null, READ ),

	/** master role READ */
	VOID( READ, null );

	private CustomerRole parent;
	private CustomerRole master;

	/**
	 * Constructor
	 *
	 * @param parent next higher priority role (vertical)
	 * @param master next master of this subrole (horizontal)
	 */
	CustomerRole( final CustomerRole parent, final CustomerRole master )
	{
		this.parent = parent;
		this.master = master;
	}

	private CustomerRole getParent( )
	{
		return this.parent;
	}

	private CustomerRole getMaster( )
	{
		return this.master;
	}

	private boolean isMaster( )
	{
		return this.master == null;
	}

	/**
	 * Returns all roles which inherit the current role
	 *
	 * @param r the role
	 * @return all roles which inherit the current role
	 */
	public static Set<CustomerRole> getInheritedRoles( final CustomerRole r )
	{
		final Set<CustomerRole> roles = new HashSet<>( );
		if ( r != null )
		{
			for ( final CustomerRole _r : CustomerRole.values( ) )
			{
				CustomerRole currentRole = _r;
				do
				{
					/* check current */
					if ( r.equals( currentRole ) ||
						( r.getMaster( ) != null && r.getMaster( ).equals( currentRole.getParent( ) ) ) )
					{
						roles.add( _r );
						currentRole = null;
					}
					else
					{
						/* find the next higher role */
						if ( currentRole.getParent( ) != null )
						{
							currentRole = currentRole.getParent( );
						}
						else
						{
							currentRole = currentRole.getMaster( );
						}
					}
				} while ( currentRole != null );

			}
		}
		return roles;
	}

	/**
	 * Tests if the set contains at least one role which is of equal or higher priority than the minimalneededRole
	 *
	 * @param roles set of roles of the customer
	 * @param mininalNeededRole minimal needed role
	 * @return TRUE or FALSE
	 */
	public static boolean hasRoleWithPriority( final Set<CustomerRole> roles, final CustomerRole mininalNeededRole )
	{
		/* first, look if the needed master role is lower than the one the customer has */
		CustomerRole needMasterRole = mininalNeededRole;
		if ( needMasterRole.isMaster( ) == false )
		{
			needMasterRole = needMasterRole.getMaster( );
		}
		while ( needMasterRole != null )
		{
			/* look for each role of the customer if the master of it is higher than the needed role master */
			for ( final CustomerRole role : roles )
			{
				final CustomerRole cRole = role.isMaster( ) ? role : role.getMaster( );
				if ( needMasterRole.getParent( ) != null && needMasterRole.getParent( ).equals( cRole ) )
				{
					return true;
				}
			}
			needMasterRole = needMasterRole.getParent( );
		}

		/* then, look into the "rows" */
		CustomerRole needRole = mininalNeededRole;
		do
		{
			if ( roles.contains( needRole ) )
			{
				return true;
			}

			/* find the next higher role needed */
			if ( needRole.getParent( ) != null )
			{
				needRole = needRole.getParent( );
			}
			else
			{
				needRole = needRole.getMaster( );
			}
		} while ( needRole != null );

		return false;
	}

	/**
	 * Tests if the set contains at least one role which is of equal or higher priority than one of the
	 * minimalneededRoles
	 *
	 * @param roles set of roles
	 * @param mininalNeededRoles set of minimal needed roles
	 * @return TRUE or FALSE
	 */
	public static boolean hasRoleWithPriority( final Set<CustomerRole> roles,
		final Set<CustomerRole> mininalNeededRoles )
	{
		for ( final CustomerRole role : mininalNeededRoles )
		{
			if ( hasRoleWithPriority( roles, role ) )
			{
				return true;
			}
		}
		return false;
	}
}
