package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
public class appController {
	@RequestMapping(value = "/app", method = RequestMethod.GET)
	public String App(HttpSession session) throws Exception {
		if(session.getAttribute("username") == null) {
			return "redirect:user/login";
		}
		return "module/app";
	}
}