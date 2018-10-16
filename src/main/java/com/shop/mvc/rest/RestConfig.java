package com.shop.mvc.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Bhautik Bhanani
 *
 */
@ApplicationPath("/rest")
public class RestConfig extends ResourceConfig {
	/**
	 * 
	 */
	public RestConfig() {
		register(ProductRestHadler.class);
	}
}
// public class RestConfig extends Application {
//
// /**
// *
// */
// private Set<Class<?>> restClasses = new HashSet<Class<?>>();
//
// /**
// * constructor
// */
// public RestConfig() {
// restClasses.add(ProductRestHadler.class);
// }
//
// @Override
// public Set<Class<?>> getClasses() {
// return this.restClasses;
// }
// }
