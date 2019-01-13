package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import domain.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.MenuService;
import service.UserService;

@Controller
public class AppController {
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/app", method = RequestMethod.GET)
	public String App(HttpSession session) throws Exception {
		if(session.getAttribute("username") == null) {
			return "redirect:user/login";
		}
		return "module/app";
	}
	
	@RequestMapping(value = "/app", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String AppData(User user, HttpSession session) throws Exception {
		JSONObject rltDataObj = new JSONObject();
		if(session.getAttribute("username") == null) {
			rltDataObj.accumulate("url", "/user/login");
		} else {
			String username = session.getAttribute("username").toString();
			rltDataObj.accumulate("username", username);
			if(username.equals("admin")) {
				JSONArray menuListObj = JSONArray.fromObject(menuService.getAllEnableMenuList());
				rltDataObj.accumulate("menulist", menuListObj.toArray());
				JSONArray userListObj = JSONArray.fromObject(userService.getAllUserList());
				rltDataObj.accumulate("userlist", userListObj.toArray());
			} else {
				Integer userid = Integer.parseInt(session.getAttribute("userid").toString());
				user.setUserid(userid);
				JSONArray menuListObj = JSONArray.fromObject(menuService.getAllEnableMenuListExceptSystemByUser(user));
				rltDataObj.accumulate("menulist", menuListObj.toArray());
			}
		}
		// Thread.sleep(2000);
		System.out.println(rltDataObj.toString());
		return rltDataObj.toString();
	}
}
