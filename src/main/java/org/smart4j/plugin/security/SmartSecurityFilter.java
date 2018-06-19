package org.smart4j.plugin.security;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.smart4j.plugin.security.realm.SmartJdbcRealm;

public class SmartSecurityFilter extends ShiroFilter {

	@Override
	public void init() throws Exception {
		super.init();
		WebSecurityManager webSecurityManager = super.getSecurityManager();

	}

	private void setRealms(WebSecurityManager webSecurityManager) {
		String securityRealms = SecurityConfig.getRealms();
		if (securityRealms != null) {
			String[] securityRealmArray = securityRealms.split(",");
			if(securityRealmArray.length > 0) {
				Set<Realm> realms = new LinkedHashSet<Realm>();
				for(String securityRealm : securityRealmArray) {
					if(securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_JDBC)) {
						addJdbcRealm(realms);
					}else if(securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_CUSTOM)){
						//TODO
					}
				}
				RealmSecurityManager realmSecurityManager = (RealmSecurityManager) webSecurityManager;
				realmSecurityManager.setRealms(realms);
			}
		}
	}

	private void addJdbcRealm(Set<Realm> realms) {
		SmartJdbcRealm smartJdbcRealm = new SmartJdbcRealm();
		realms.add(smartJdbcRealm);
	}
}
