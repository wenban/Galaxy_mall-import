package galaxy.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import galaxy.dao.UserDAO;
import galaxy.model.User;
import tool.MyMethod;

@Service
public class UserService {
	@Autowired
	private UserDAO UserDAO;

	// 判断邮箱是否被注册
	public Integer emailIsExist(String userEmail, HttpSession session) {
		User user = new User();
		user.setUserEmail(userEmail);
		List<User> userList = UserDAO.selectUser(user);
		if (userList.size() > 0) {
			return 1;// 邮箱已在数据库中，无法再次注册
		} else {
			try {
				session.setAttribute(userEmail, emailConfirm(userEmail));
			} catch (MessagingException e) {
				return 1;
			}// 发送验证码邮件
			return 0;// 该邮箱可被注册
		}
	}

	// 生成随机数发送邮件
	public String emailConfirm(String userEmail) throws MessagingException {
		// 获取随机数验证码
		String captcha = String.valueOf((int) (Math.random() * 9000 + 1000));
		System.out.println(captcha);
		MyMethod.sendEmail(userEmail, String.valueOf(captcha));

		return captcha;
	}

	// 判断验证码是否正确
	public int captchaConfirm(String userEmail, String captcha, HttpSession session) {
		if ((String) session.getAttribute(userEmail)==null) {
			return 2;
		}
		String code = (String) session.getAttribute(userEmail);
		if (code.equals(captcha)) {
			return 1;
		} else {
			return 0;
		}
	}

}
