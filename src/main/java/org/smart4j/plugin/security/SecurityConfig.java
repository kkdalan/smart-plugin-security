package org.smart4j.plugin.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.helper.ConfigHelper;
import org.smart4j.framework.util.PropsUtil;
import org.smart4j.framework.util.ReflectionUtil;

public final class SecurityConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

	public static String getRealms() {
		return ConfigHelper.getString(SecurityConstant.REALMS);
	}

	public static SmartSecurity getSmartSecurity() {
		String className = ConfigHelper.getString(SecurityConstant.SMART_SECURITY);
		Class<?> clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			LOGGER.error("get SmartSecurity instance failure: " + className, e);
		}
		return (SmartSecurity) ReflectionUtil.newInstance(clazz);
	}

	public static String getJdbcAuthcQuery() {
		return ConfigHelper.getString(SecurityConstant.JDBC_AUTHC_QUERY);
	}

	public static String getJdbcRolesQuery() {
		return ConfigHelper.getString(SecurityConstant.JDBC_ROLES_QUERY);
	}

	public static String getJdbcPermissionsQuery() {
		return ConfigHelper.getString(SecurityConstant.JDBC_PERMISSIONS_QUERY);
	}

	public static boolean isCacheable() {
		return ConfigHelper.getBoolean(SecurityConstant.CACHE);
	}

}
