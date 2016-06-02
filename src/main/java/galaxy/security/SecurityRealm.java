package galaxy.security;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.stereotype.Component;

import galaxy.model.User;
import galaxy.service.UserService;

/**
 * 工具类使用了 各种方法
 * 
 * @author Administrator
 * 
 */
@Component
public class SecurityRealm extends AuthenticatingRealm {

	@Resource
	private UserService UserService;

	public SecurityRealm() {
		super();
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = UserService.login(token.getUsername());
		System.out.println("Get from token  "+token.getUsername());
		if (user == null) {
			return null;
		}
		System.out.println("Get from DB   "+user.getUserName());
		System.out.println("Get from DB   "+user.getLoginPassWord());

		return new SimpleAuthenticationInfo(user, user.getLoginPassWord(), getName());

	}


}
