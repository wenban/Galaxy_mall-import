package galaxy.controller;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import galaxy.security.ShiroTool;
import tool.MyMethod;

@Controller
public class UserLoginController {

	@Value("${staticServerPath}")
	private String staticServerPath;

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	/**
	 * 处理查询用户登录信息，跳转到login.jsp
	 * 
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 * @throws ParseException
	 * @throws MalformedTemplateNameException
	 * @throws TemplateNotFoundException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginUser(Model model) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, TemplateException, IOException {
		if (ShiroTool.getLoginId() != null) {
			model.addAttribute("loginId", ShiroTool.getLoginId());
			return "logout";
		}

		StringWriter out8 = new StringWriter();
		freeMarkerConfigurer.getConfiguration().getTemplate("index.ftl").process(null, out8);
		MyMethod.buildHTML("index", out8.toString());

		StringWriter out9 = new StringWriter();
		freeMarkerConfigurer.getConfiguration().getTemplate("index_vip_ad.ftl").process(null, out9);
		MyMethod.buildHTML("index_vip_ad", out9.toString());

		StringWriter out1 = new StringWriter();
		freeMarkerConfigurer.getConfiguration().getTemplate("index_right_ad.ftl").process(null, out1);
		MyMethod.buildHTML("index_right_ad", out1.toString());

		StringWriter out2 = new StringWriter();
		freeMarkerConfigurer.getConfiguration().getTemplate("index_new_model.ftl").process(null, out2);
		MyMethod.buildHTML("index_new_model", out2.toString());

		StringWriter out3 = new StringWriter();
		freeMarkerConfigurer.getConfiguration().getTemplate("index_hot_model.ftl").process(null, out3);
		MyMethod.buildHTML("index_hot_model", out3.toString());

		StringWriter out4 = new StringWriter();
		freeMarkerConfigurer.getConfiguration().getTemplate("index_hot_discount.ftl").process(null, out4);
		MyMethod.buildHTML("index_hot_discount", out4.toString());

		StringWriter out5 = new StringWriter();
		freeMarkerConfigurer.getConfiguration().getTemplate("index_hot_category.ftl").process(null, out5);
		MyMethod.buildHTML("index_hot_category", out5.toString());

		StringWriter out6 = new StringWriter();
		freeMarkerConfigurer.getConfiguration().getTemplate("index_hot_brand.ftl").process(null, out6);
		MyMethod.buildHTML("index_hot_brand", out6.toString());

		StringWriter out7 = new StringWriter();
		freeMarkerConfigurer.getConfiguration().getTemplate("index_guess_model.ftl").process(null, out7);
		MyMethod.buildHTML("index_guess_model", out7.toString());

		StringWriter out11 = new StringWriter();
		freeMarkerConfigurer.getConfiguration().getTemplate("top.ftl").process(null, out11);
		MyMethod.buildHTML("top", out11.toString());
		return "login";
	}

	/**
	 * 处理提交用户登录的信息
	 * 
	 * @param model
	 * @param session
	 * @param user
	 * @return
	 */
	// 登录失败
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model) {
		System.out.println("登录失败" + ShiroTool.getLoginId());
		if (ShiroTool.getLoginId() != null) {
			model.addAttribute("loginId", ShiroTool.getLoginId());
			return "logout";
		}
		model.addAttribute("error", "登录失败");
		return "login";
	}

	// 登录成功
	@RequestMapping(value = "/login/success", method = RequestMethod.GET)
	public String main(Model model) throws Exception {
		System.out.println("登录成功");
		System.out.println("1*****");
		System.out.println(ShiroTool.getLoginId());
		System.out.println(ShiroTool.getEmail());
		System.out.println(ShiroTool.getSessionId());
		System.out.println("1#####");
		return "redirect:" + staticServerPath + "index.html";
	}

	@RequestMapping(value = "/getLoginId", method = RequestMethod.GET)
	@ResponseBody
	public String getLoginId() {
		System.out.println("*****");
		System.out.println(ShiroTool.getLoginId());
		System.out.println(ShiroTool.getEmail());
		System.out.println(ShiroTool.getSessionId());
		System.out.println("#####");
		return "shenhaojie";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "login";
	}

}
