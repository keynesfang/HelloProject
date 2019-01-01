package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.User;
import net.sf.json.JSONObject;
import service.userService;

@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	private userService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login() throws Exception {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String Login(@RequestBody String formDataStr, User user, HttpSession session) throws Exception {
		JSONObject formDataObj = JSONObject.fromObject(formDataStr);
		JSONObject rltDataObj = new JSONObject();
		String username = formDataObj.getString("username");
		user.setName(username);
		user.setPassword(formDataObj.getString("password"));
		if(userService.login(user) != null) {
			session.setAttribute("username", username);
			rltDataObj.accumulate("result", "success");
			rltDataObj.accumulate("url", "/safety/app");
			System.out.println(session.getAttribute("username").toString());
		} else {
			rltDataObj.accumulate("result", "fail");
			System.out.println("login error!");
		}
		return rltDataObj.toString();
	}
}
