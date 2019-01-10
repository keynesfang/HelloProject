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
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login() throws Exception {
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String Login(@RequestBody String formDataStr, User user, HttpSession session) throws Exception {
		JSONObject formDataObj = JSONObject.fromObject(formDataStr);
		JSONObject rltDataObj = new JSONObject();
		String username = formDataObj.getString("username");
		user.setUsername(username);
		user.setUserpass(formDataObj.getString("password"));
		User dbUser = userService.login(user);
		if(dbUser != null) {
			session.setAttribute("username", dbUser.getUsername());
			session.setAttribute("userright", dbUser.getUserright());
			rltDataObj.accumulate("result", "success");
			rltDataObj.accumulate("url", "/safety/app");
		} else {
			rltDataObj.accumulate("result", "fail");
			System.out.println("login error!");
		}
		return rltDataObj.toString();
	}
	
	@RequestMapping(value = "/modifyPassWord", method = RequestMethod.POST)
	@ResponseBody
	public String ModifyPassWord(@RequestBody String formDataStr, User user) throws Exception {
		JSONObject formDataObj = JSONObject.fromObject(formDataStr);
		JSONObject rltDataObj = new JSONObject();
		
		user.setUserid(Integer.parseInt(formDataObj.getString("id")));
		user.setUsername(formDataObj.getString("name"));
		user.setUserpass(formDataObj.getString("pass"));
		
		int dbUser = userService.update(user);
		if(dbUser != 0) {
			rltDataObj.accumulate("result", "success");
			rltDataObj.accumulate("url", "/safety/user/login");
		} else {
			rltDataObj.accumulate("result", "fail");
			System.out.println("modifyPassWord error!");
		}
		return rltDataObj.toString();
	}
}
