package service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepository;

	public boolean checkLogin(int type, String username, String password) {
		User user = userRepository.findAUser(username);
		if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	public int getType(String username) {
		User user = userRepository.findAUser(username);
		return user.getUsertypeid();
	}

}
