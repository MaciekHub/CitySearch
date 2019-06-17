package pr.webapp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pr.webapp.interfaces.UserService;
import pr.webapp.model.User;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		final User user = (User) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}

		if (userService.findByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}

		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
	}

	public void isLoginCorrect(User user, Errors errors) {
		final User userFound = userService.findByUsername(user.getUsername());
		if (userFound != null) {
			if (!userFound.getPassword().equals(user.getPassword())) {
				errors.rejectValue("username", "Size.loginForm.login");
				errors.rejectValue("password", "Size.loginForm.login");
			}
		} else {
			errors.rejectValue("username", "Size.loginForm.login");
			errors.rejectValue("password", "Size.loginForm.login");
		}
	}
}
