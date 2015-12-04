/*
 * IronJacamar, a Java EE Connector Architecture implementation
 * Copyright 2010, Red Hat Inc, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package ch.schlau.pesche.coffee.hellorar;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;

/**
 * HelloWorldConnectionFactoryImpl
 */
public class HelloWorldConnectionFactoryImpl implements HelloWorldConnectionFactory {

    private static final long serialVersionUID = 1L;

    private Reference reference;

    private HelloWorldManagedConnectionFactory mcf;
    private ConnectionManager connectionManager;

    /**
     * Default constructor
     *
     * @param mcf       ManagedConnectionFactory
     * @param cxManager ConnectionManager
     */
    public HelloWorldConnectionFactoryImpl(HelloWorldManagedConnectionFactory mcf,
            ConnectionManager cxManager) {
        this.mcf = mcf;
        this.connectionManager = cxManager;
    }

    @Override
    public HelloWorldConnection getConnection() throws ResourceException {
        return (HelloWorldConnection) connectionManager.allocateConnection(mcf, null);
    }

    @Override
    public Reference getReference() throws NamingException {
        return reference;
    }

    @Override
    public void setReference(Reference reference) {
        this.reference = reference;
    }
}
