package org.smart4j.plugin.security.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.plugin.security.SecurityConstant;
import org.smart4j.plugin.security.SmartSecurity;
import org.smart4j.plugin.security.password.EasyCredentialsMatcher;

public class SmartCustomRealm extends AuthorizingRealm {

	private final SmartSecurity smartSecurity;

	public SmartCustomRealm(SmartSecurity smartSecurity) {
		this.smartSecurity = smartSecurity;
		super.setName(SecurityConstant.REALMS_CUSTOM);
//		super.setCredentialsMatcher(new Md5CredentialsMatcher());
		super.setCredentialsMatcher(new EasyCredentialsMatcher());
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		if (token == null) {
			throw new AuthenticationException("parameter token is null");
		}
		String username = ((UsernamePasswordToken) token).getUsername();
		String password = smartSecurity.getPassword(username);

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
		authenticationInfo.setPrincipals(new SimplePrincipalCollection(username, super.getName()));
		authenticationInfo.setCredentials(password);
		return authenticationInfo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) {
			throw new AuthorizationException("parameter principals is null");
		}
		String username = (String) super.getAvailablePrincipal(principals);
		Set<String> roleNameSet = smartSecurity.getRoleNameSet(username);

		Set<String> permissionNameSet = new HashSet<String>();
		if (CollectionUtil.isNotEmpty(roleNameSet)) {
			for (String roleName : roleNameSet) {
				Set<String> currentPermissionNameSet = smartSecurity.getPermissionNameSet(roleName);
				permissionNameSet.addAll(currentPermissionNameSet);
			}
		}

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(roleNameSet);
		authorizationInfo.setStringPermissions(permissionNameSet);
		return authorizationInfo;
	}

}
