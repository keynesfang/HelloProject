package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import mapper.UserMapper;
@Service
public class UserService {
	@Autowired
	private UserMapper usermapper;
	
	public User login(User u) {
		return usermapper.login(u);
	}
	
	public List<User> getAllUserList() {
		return usermapper.getAllUserList();
	}
	
	public int update(User u){
		return usermapper.updateByPrimaryKeySelective(u);
	}
}
