package org.smart4j.plugin.security;

import java.util.Set;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.shiro.web.env.EnvironmentLoaderListener;

public class SmartSecurityPlugin implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> handleTypes, ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("shiroConfigLocations", "classpath:smart-security.ini");
		servletContext.addListener(EnvironmentLoaderListener.class);

		FilterRegistration.Dynamic smartSecurityFilter = servletContext.addFilter("SmartSecurityFilter", SmartSecurityFilter.class);
		smartSecurityFilter.addMappingForUrlPatterns(null, false, "/*");
	}

}
