package org.smart4j.plugin.security;

import java.util.Set;

public interface SmartSecurity {

	public String getPassword(String username);

	public Set<String> getRoleNameSet(String username);

	public Set<String> getPermissionNameSet(String roleName);
	
}
