/*
 * Copyright 2008 Jeff Dwyer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.apress.progwt.server.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * HostPrecedingPropertyPlaceholderConfigurer
 * 
 * Extends PropertyPlaceholderConfigurer to insert $hostname.property
 * 
 * sample properties file:
 * 
 * jdbc.user=live_user
 * server.jdbc.url=jdbc:postgresql://db.host.com:5432/db
 * server.magic.file.location=/var/magic_file
 * 
 * jdbc.user=devel_user
 * devel.jdbc.url=jdbc:postgresql://devel-db.host.com:5432/db
 * devel.magic.file.location=c:\\var\magic_file
 * 
 * my.property=a property referenced through a method besides
 * HostPrecedingPropertyPlaceholderConfigurer
 * 
 * <bean id="propertyConfigurer"
 * class="com.util.spring.HostPrecedingPropertyPlaceholderConfigurer">
 * <property name="location" value="classpath:config.properties" />
 * </bean>
 * 
 * <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
 * destroy-method="close"> <property name="driverClass"
 * value="${jdbc.driverClass}" /> <property name="jdbcUrl"
 * value="${HOST.jdbc.url}" /> <property name="user" value="${jdbc.user}" />
 * <property name="password" value="${jdbc.password}" /> </bean>
 * 
 * 
 * @author Jeff Dwyer (blog) http://jdwyah.blogspot.com
 * 
 */
public class HostPrecedingPropertyPlaceholderConfigurer extends
        PropertyPlaceholderConfigurer {

    private static Logger log = Logger
            .getLogger(HostPrecedingPropertyPlaceholderConfigurer.class);

    public String resolvePlaceholder(String placeholder, Properties props) {

        try {
            if (placeholder.startsWith("HOST.")) {
                log.debug("Host: "
                        + InetAddress.getLocalHost().getHostName()
                        + " for property " + placeholder);
                String replace = placeholder.replaceFirst("HOST",
                        InetAddress.getLocalHost().getHostName());

                String prop = props.getProperty(replace);
                if (prop == null) {
                    log.warn("Please define property: " + replace);
                }
                return prop;

            } else {
                log.debug("reg");
                return props.getProperty(placeholder);
            }
        } catch (UnknownHostException e) {
            log.warn(e);
            return null;
        }
    }
}
