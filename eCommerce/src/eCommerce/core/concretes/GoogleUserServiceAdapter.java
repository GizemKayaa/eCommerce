package eCommerce.core.concretes;

import eCommerce.GoogleUser.GoogleUserService;
import eCommerce.core.abstracts.VerificationService;
import eCommerce.entities.concretes.User;

public class GoogleUserServiceAdapter implements VerificationService {

	@Override
	public boolean isValid(User user) {
		GoogleUserService googleUserValid = new GoogleUserService();
		
		return googleUserValid.isValid();
	}

}
