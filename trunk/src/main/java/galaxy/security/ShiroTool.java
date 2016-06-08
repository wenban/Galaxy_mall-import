package galaxy.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import galaxy.model.User;

public class ShiroTool {

	/**
	 * 获取Session,不存在时创建新的Session
	 *
	 */
	public static Session getSession() {
		return SecurityUtils.getSubject().getSession(true);
	}

	/**
	 * 向session中保存信息
	 *
	 */
	public static void setAttribute(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	/**
	 * 根据Key在Shiro的Session中取得对应的值.
	 *
	 * <pre>
	 * 无需类型转换: TestType testType = getSessionVal("key");
	 * 但getSessionVal("key")无法直接使用TestType的方法
	 * 无法直接使用getSessionVal("key").testTypeFunction()
	 * 需要按如下方法使用:
	 * TestType testType = getSessionVal("key");
	 * testType.testTypeFunction();
	 * </pre>
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getAttribute(String key) {
		return (T) getSession().getAttribute(key);
	}

	/**
	 * 根据Key在Shiro的Session中取得对应的值,根据传入类型自动转换至该类型..
	 *
	 * <pre>
	 * 本方法同getSessionVal(String key)区别在于根据参数类型直接转换为对应的类型.
	 * 可以直接使用: getSessionVal("key").testTypeFunction();
	 * </pre>
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getAttribute(String key, Class<T> T) {
		Object v = getSession().getAttribute(key);
		return v == null ? null : (T) v;
	}

	/**
	 * 根据KEY删除Session中对应的值
	 */
	public static void removeAttribute(String key) {
		getSession().removeAttribute(key);
	}

	/**
	 * 判断当前Session是否存在该属性
	 *
	 */
	public static boolean hasAttribute(String key) {
		return getAttribute(key) != null;
	}

	/**
	 * 判断当前Session是否存在该属性且属性值是否为指定字符串
	 *
	 */
	public static boolean hasAttribute(String key, String value) {
		Object obj = getAttribute(key);
		return obj != null && value.equals(obj);
	}

	/**
	 * 取得当前登录用户的对象
	 *
	 */
	public static User getLoginUser() {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		return user == null ? new User() : user;
	}

	/**
	 * 取得当前登录用户的用户ID.无用户登录信息时返回空对象
	 */
	public static Integer getUserId() {
		return getLoginUser().getId();
	}

	/**
	 * 取得当前登录用户的登录ID.无用户登录信息时返回空对象
	 *
	 */
	public static String getLoginId() {
		return getLoginUser().getLoginId();
	}

	/**
	 * 取得当前登录用户的用户名称.无用户登录信息时返回空对象
	 *
	 */
	public static String getUserName() {
		return getLoginUser().getUserName();
	}

	/**
	 * 取得当前登录用户所属店铺的storeId,非必须项.为适应特殊系统.无用户登录信息时返回空对象
	 *
	 */
	public static Integer getStoreId() {
		return getLoginUser().getStoreId();
	}
	
	public static String getEmail() {
		return getLoginUser().getUserEmail();
	}

}
