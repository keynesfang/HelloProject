package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Menu;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/getallmenu", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String get_all_menu(HttpSession session) throws Exception {
		JSONObject rltDataObj = new JSONObject();
		JSONArray menuListObj = JSONArray.fromObject(menuService.getAllMenuList());
		rltDataObj.accumulate("menulist", menuListObj.toArray());
		
		return rltDataObj.toString();
	}

	@RequestMapping(value = "/setstatus", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String set_menu_status(@RequestBody String formDataStr, Menu menu, HttpSession session) throws Exception {
		JSONObject formDataObj = JSONObject.fromObject(formDataStr);
		JSONObject rltDataObj = new JSONObject();
		Integer menuid = formDataObj.getInt("menuid");
		String menustatus = formDataObj.getString("menustatus");
		menu.setMenuid(menuid);
		menu.setMenustatus(menustatus);
		menuService.updateByPrimaryKeySelective(menu);
		JSONArray menuListObj = JSONArray.fromObject(menuService.getAllMenuList());
		rltDataObj.accumulate("menulist", menuListObj.toArray());
		
		return rltDataObj.toString();
	}
}
