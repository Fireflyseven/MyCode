package web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService ls;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/index")
	public String index1() {
		return "index";
	}

	@RequestMapping("/login")
	public String login(int type, String username, String password, HttpSession session) {
		if (ls.checkLogin(type, username, password)) {
			session.setAttribute("usr", username);
			session.setAttribute("type", this.ls.getType(username));
			return type == 1 ? "redirect:/t_list" : "redirect:/s_list";
		} else {
			return "index";
		}

	}
}
