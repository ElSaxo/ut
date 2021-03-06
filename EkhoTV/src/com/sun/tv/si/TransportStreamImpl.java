/*
 * @(#)TransportStreamImpl.java	1.9 08/09/15
 * 
 * Copyright � 2008 Sun Microsystems, Inc. All rights reserved. 
 * Use is subject to license terms.
 * 
 */

package com.sun.tv.si;

import java.util.Date;

import javax.tv.locator.Locator;
import javax.tv.locator.LocatorFactory;
import javax.tv.service.ServiceInformationType;
import javax.tv.service.transport.TransportStream;

import com.sun.tv.LocatorImpl;

/**
 * This interface provides information about a transport stream.
 */
public class TransportStreamImpl implements TransportStream {

    private String description = null;
    private int transportStreamID = -1;
    private int networkID = -1;
    private Date updatedTime = null;
    private Locator locator = null;
    private ServiceInformationType siType;

    public TransportStreamImpl(String description, int transportStreamID,
	    ServiceInformationType siType, Date updatedTime, int networkID) {

	this.description = description;
	this.transportStreamID = transportStreamID;
	this.siType = siType;
	this.updatedTime = updatedTime;
	this.networkID = networkID;
    }

    /**
     * Returns a textual name or a description of this transport stream.
     * 
     * @return A string representing the name of this transport stream.
     */
    public String getDescription() {
	return this.description;
    }

    /**
     * This method returns the ID of this Transport Stream.
     * 
     * @return A number identifying this transport stream.
     */
    public int getTransportStreamID() {
	return this.transportStreamID;
    }

    /**
     * Gets the complete Locator of this SI Element. Each SI Element (such as
     * BroadcastService, ProgramEvent, etc.) in the MPEG-2 domain is identified
     * by a Locator. This identification is encapsulated by the Locator object
     * which may use a URL format, specific MPEG numbers, such as network ID,
     * etc., or other mechanisms.
     * 
     * @return Locator representing this SI Element
     */
    public Locator getLocator() {
	if (locator == null) {
	    try {
		this.locator = LocatorFactory.getInstance().createLocator(
			LocatorImpl.TransportStreamProtocol + description);
	    } catch (Exception e) {
		;
	    }
	}
	return this.locator;
    }

    /**
     * Returns the time when this object was last updated from data in the
     * broadcast.
     * 
     * @return The date of the last update in UTC format, or <code>null</code>
     *         if unknown.
     */
    public Date getUpdateTime() {
	return this.updatedTime;
    }

    /**
     * Reports the service information format of this object.
     * 
     * @return The service information format.
     */
    public ServiceInformationType getServiceInformationType() {
	return this.siType;
    }

    public int getNetworkID() {
	return this.networkID;
    }
}
