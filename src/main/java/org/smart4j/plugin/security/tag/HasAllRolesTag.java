package org.smart4j.plugin.security.tag;

import java.util.Arrays;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.RoleTag;

public class HasAllRolesTag extends RoleTag {

	private static final String ROLE_NAMES_DELIMITER = ",";

	@Override
	protected boolean showTagBody(String roleNames) {
		boolean hasAllRole = false;
		Subject subject = getSubject();
		if (subject != null) {
			if (subject != null) {
				if (subject.hasAllRoles(Arrays.asList(roleNames.split(ROLE_NAMES_DELIMITER)))) {
					hasAllRole = true;
				}
			}
		}
		return hasAllRole;
	}

}
