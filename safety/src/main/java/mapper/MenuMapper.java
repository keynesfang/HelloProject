package mapper;

import java.util.List;

import domain.Menu;
import domain.User;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuid);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> getAllMenuList();
    
    List<Menu> getAllMenuListExceptSystem();
    
    List<Menu> getAllEnableMenuList();
    
    List<Menu> getAllEnableMenuListExceptSystem();
    
    List<Menu> getAllEnableMenuListExceptSystemByUser(User user);
}