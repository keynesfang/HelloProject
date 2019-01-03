package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.UserService;

@Controller
public class AppController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/app", method = RequestMethod.GET)
	public String App(HttpSession session) throws Exception {
		if(session.getAttribute("username") == null) {
			return "redirect:user/login";
		}
		return "module/app";
	}
	
	@RequestMapping(value = "/app", method = RequestMethod.POST)
	@ResponseBody
	public String AppData(HttpSession session) throws Exception {
		JSONObject rltDataObj = new JSONObject();
		if(session.getAttribute("username") == null) {
			rltDataObj.accumulate("url", "/user/login");
		} else {
			rltDataObj.accumulate("username", session.getAttribute("username"));
			JSONArray userListObj = JSONArray.fromObject(userService.getAllUserList());
			System.out.println(userListObj.toString());
		}
		Thread.sleep(2000);
		return rltDataObj.toString();
	}
}
