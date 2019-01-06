package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Menu;
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
	
	public int updateByPrimaryKeySelective(Menu record) {
		return menumapper.updateByPrimaryKeySelective(record);
	}
}