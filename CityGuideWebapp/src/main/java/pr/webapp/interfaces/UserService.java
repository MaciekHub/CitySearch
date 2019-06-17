package pr.webapp.interfaces;

import pr.webapp.model.User;

public interface UserService {

	public void save(User user);

	public User findByUsername(String username);

	public boolean doesUserExist(User user);

}
