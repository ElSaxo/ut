/*
 * @(#)SIChangeType.java	1.18 08/09/15
 * 
 * Copyright � 2008 Sun Microsystems, Inc. All rights reserved. 
 * Use is subject to license terms.
 * 
 */

package javax.tv.service;

/**
 * This class represents types of changes to SI elements.
 * 
 * @see SIChangeEvent
 * @see SIElement
 */
public class SIChangeType {

    private String name = null;

    /**
     * Creates an <code>SIChangeType</code> object.
     * 
     * @param name
     *            The string name of this type (e.g. "ADD").
     */
    protected SIChangeType(String name) {
	this.name = name;
	if (name == null) {
	    throw new NullPointerException("Name is null");
	}
    }

    /**
     * Provides the string name of the type. For the type objects defined in
     * this class, the string name will be identical to the class variable name.
     */
    public String toString() {
	return name;
    }

    /**
     * <code>SIChangeType</code> indicating that an <code>SIElement</code> has
     * been added.
     */
    public static final SIChangeType ADD;

    /**
     * <code>SIChangeType</code> indicating that an <code>SIElement</code> has
     * been removed.
     */
    public static final SIChangeType REMOVE;

    /**
     * <code>SIChangeType</code> indicating that an <code>SIElement</code> has
     * been modified.
     */
    public static final SIChangeType MODIFY;

    static {
	ADD = new SIChangeType("ADD");
	REMOVE = new SIChangeType("REMOVE");
	MODIFY = new SIChangeType("MODIFY");
    }
}
