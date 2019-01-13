package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Menu;
import domain.User;
import mapper.MenuMapper;
@Service
public class MenuService {
	@Autowired
	private MenuMapper menumapper;
	
	public List<Menu> getAllMenuList() {
		return menumapper.getAllMenuList();
	}
	
	public List<Menu> getAllMenuListExceptSystem() {
		return menumapper.getAllMenuListExceptSystem();
	}
	
	public List<Menu> getAllEnableMenuList() {
		return menumapper.getAllEnableMenuList();
	}
	
	public List<Menu> getAllEnableMenuListExceptSystem() {
		return menumapper.getAllEnableMenuListExceptSystem();
	}
	
	public int updateByPrimaryKeySelective(Menu record) {
		return menumapper.updateByPrimaryKeySelective(record);
	}
	
	public List<Menu> getAllEnableMenuListExceptSystemByUser(User user) {
		return menumapper.getAllEnableMenuListExceptSystemByUser(user);
	}
}
