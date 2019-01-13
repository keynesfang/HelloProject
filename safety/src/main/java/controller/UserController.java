package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.MenuService;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	
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
			session.setAttribute("userid", dbUser.getUserid());
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
	
	@RequestMapping(value = "/getrightinfo", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String get_user_right_info() throws Exception {
		JSONObject rltDataObj = new JSONObject();
		JSONArray userListObj = JSONArray.fromObject(userService.getAllUserList());
		rltDataObj.accumulate("userlist", userListObj.toArray());
		JSONArray menuListObj = JSONArray.fromObject(menuService.getAllMenuListExceptSystem());
		rltDataObj.accumulate("menulist", menuListObj.toArray());
		System.out.println(rltDataObj.toString());
		return rltDataObj.toString();
	}
	
	@RequestMapping(value = "/setrightinfo", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String set_user_right(@RequestBody String formDataStr, User user) throws Exception {
		JSONObject formDataObj = JSONObject.fromObject(formDataStr);
		JSONObject rltDataObj = new JSONObject();
		Integer userid = formDataObj.getInt("userid");
		String userright = formDataObj.getString("userright");
		user.setUserid(userid);
		user.setUserright(userright);
		int rlt = userService.update(user);
		if(rlt != 0) {
			rltDataObj.accumulate("result", "success");
		} else {
			rltDataObj.accumulate("result", "fail");
		}
		JSONArray userListObj = JSONArray.fromObject(userService.getAllUserList());
		rltDataObj.accumulate("userlist", userListObj.toArray());
		System.out.println(rltDataObj.toString());
		return rltDataObj.toString();
	}
}
