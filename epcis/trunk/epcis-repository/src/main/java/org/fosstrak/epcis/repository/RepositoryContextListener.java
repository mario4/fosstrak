/*
 * Copyright (C) 2007 ETH Zurich
 *
 * This file is part of Accada (www.accada.org).
 *
 * Accada is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1, as published by the Free Software Foundation.
 *
 * Accada is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Accada; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA  02110-1301  USA
 */

package org.accada.epcis.repository;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * TODO: javadoc
 * 
 * @author Marco Steybe
 */
public class RepositoryContextListener implements ServletContextListener {

    private static final String LOG4J_CONFIG_LOCATION = "log4jConfigLocation";

    private static final Log LOG = LogFactory.getLog(RepositoryContextListener.class);

    /**
     * {@inheritDoc}
     * 
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
        ServletContext ctx = event.getServletContext();

        /* Note: logging is initialized automatically by reading
         * logging.properties and log4j.properties from the classpath.
         * logging.properties is used to tell commons-logging to use
         * LOG4J as its underlying logging toolkit; log4j.properties is
         * used to configure LOG4J
         * To initialize LOG4J manually from LOG4J_CONFIG_LOCATION,
         * un-comment the following code ...
         */
        // String path = ctx.getRealPath("/");
        // String log4jCfg = ctx.getInitParameter(LOG4J_CONFIG_LOCATION);
        // // initialize Log4j
        // if (log4jCfg != null) {
        // // if no log4j properties file found, then do not try
        // // to load it (the application runs without logging)
        // PropertyConfigurator.configure(path + log4jCfg);
        // }
        // log = LogFactory.getLog(this.getClass());
        LOG.info("Starting Accada EPCIS Repository application");

        if (LOG.isDebugEnabled()) {
            LOG.debug("Logging application context init-parameters:");
            Enumeration<String> e = ctx.getInitParameterNames();
            while (e.hasMoreElements()) {
                String param = e.nextElement();
                LOG.debug(param + "=" + ctx.getInitParameter(param));
            }
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event) {
        LOG.info("Accada EPCIS Repository application shut down\n######################################");
        LogFactory.releaseAll();
    }
}