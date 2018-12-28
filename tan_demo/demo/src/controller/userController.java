package controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.User;
import net.sf.json.JSONObject;
import service.userService;
import util.ResponseUtil;

@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	private userService userService;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	 public String Login(@RequestParam(value="username") String name,@RequestParam(value="password") String pass,User user,HttpServletResponse res,HttpSession session) throws Exception{
        user.setName(name);
        user.setPassword(pass);
        User userinfo=userService.login(user);
        session.setAttribute("user",userinfo);
        JSONObject result=new JSONObject();
        result.put("userInfo", userinfo);
        ResponseUtil.write(res, result);
        return null;
    }
}
