package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import mapper.UserMapper;
@Service
public class userService {
	@Autowired
	private UserMapper usermapper;
	
	public User login(User u) {
		return usermapper.login(u);
	}
}
