package pr.webapp.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pr.webapp.interfaces.UserService;
import pr.webapp.model.User;
import pr.webapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public boolean doesUserExist(User user) {
		if (userRepository.findByUsername(user.getUsername()) != null)
			return true;
		else
			return false;
	}

}
