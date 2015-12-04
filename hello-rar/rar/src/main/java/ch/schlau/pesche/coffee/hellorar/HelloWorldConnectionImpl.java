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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HelloWorldConnectionImpl
 */
public class HelloWorldConnectionImpl implements HelloWorldConnection {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldConnectionImpl.class);

    /**
     * ManagedConnection
     */
    private HelloWorldManagedConnection mc;

    /**
     * ManagedConnectionFactory
     */
    private HelloWorldManagedConnectionFactory mcf;

    /**
     * Default constructor
     *
     * @param mc  HelloWorldManagedConnection
     * @param mcf HelloWorldManagedConnectionFactory
     */
    public HelloWorldConnectionImpl(HelloWorldManagedConnection mc,
            HelloWorldManagedConnectionFactory mcf) {
        this.mc = mc;
        this.mcf = mcf;
    }

    /**
     * Call helloWorld
     *
     * @return String helloworld
     */
    public String helloWorld() {
        return helloWorld(((HelloWorldResourceAdapter) mcf.getResourceAdapter()).getName());
    }

    /**
     * Call helloWorld
     *
     * @param name String name
     * @return String helloworld
     */
    public String helloWorld(String name) {
        return mc.helloWorld(name);
    }

    /**
     * Close
     */
    public void close() {
        mc.closeHandle(this);
    }
}
