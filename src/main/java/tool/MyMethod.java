package tool;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.commons.lang3.StringUtils;

public class MyMethod {
	public static void main(String[] args) {
	}

	public static void buildHTML(String fileName, String fileContent) {
		FileOutputStream foOutputStream = null;
		try {
			foOutputStream = new FileOutputStream(new java.io.File("D:/GalaxyMall-Static/html/", fileName + ".html"));
			foOutputStream.write(fileContent.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				foOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除List集合中重复元素
	 * @param <T>
	 * @param <T>
	 * @param list
	 */
	public static List<String> removeDuplicate(List<String> list) {
		HashSet<String> h = new HashSet<String>(list);
		list.clear();
		list.addAll(h);
		return list;
	}
	

	public static void sendEmail(String receiverEmail, String content) throws MessagingException {
		// 配置发送邮件的环境属性
		final Properties props = new Properties();
		// 表示SMTP发送邮件，需要进行身份验证
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.qq.com");
		// 发件人的账号
		props.put("mail.user", "499074931@qq.com");
		// 访问SMTP服务时需要提供的密码
		props.put("mail.password", "s68890030");

		// 构建授权信息，用于进行SMTP进行身份验证
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名、密码
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};

		// 使用环境属性和授权信息，创建邮件会话
		Session mailSession = Session.getInstance(props, authenticator);
		// 创建邮件消息
		MimeMessage message = new MimeMessage(mailSession);
		// 设置发件人
		InternetAddress from = new InternetAddress(props.getProperty("mail.user"));
		message.setFrom(from);
		// 设置收件人
		InternetAddress to = new InternetAddress(receiverEmail);
		message.setRecipient(RecipientType.TO, to);
		// 设置邮件标题
		message.setSubject("GalaxyMall注册验证");
		// 设置邮件的内容体
		message.setContent(content, "text/plain");
		// 发送邮件
		Transport.send(message);

	}

	public static String date(Date date) {
		if (date==null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd HH:mm");
		return sdf.format(date);
	}

	public static String dateS(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd");
		return sdf.format(date);
	}

}
