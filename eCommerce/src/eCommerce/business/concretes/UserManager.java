package eCommerce.business.concretes;

import eCommerce.business.abstracts.UserService;
import eCommerce.core.abstracts.ValidatorService;
import eCommerce.core.abstracts.VerificationService;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private VerificationService verificationservice;
	private ValidatorService validatorService;
	
	public UserManager(UserDao userDao,VerificationService verificationService,ValidatorService validatorService) {
		
		this.userDao = userDao;
		this.verificationservice = verificationService;
		this.validatorService = validatorService;
	}

	@Override
	public void register(User user) {
		
		if(!verificationservice.isValid(user)) {
			System.out.println("Kay�t Ba�ar�s�z !");
		}
		else if(!userDao.emailCheck(user)) {
			System.out.println("Bu e mail adresi daha �nce al�nm��!");
		}
		else {
			userDao.add(user);
			validatorService.sendVerificationMail();
		}
	}


	@Override
	public void login(String email, String password) {
		if(userDao.loginByCheck(email, password)) {
			System.out.println("Giri� Ba�ar�l�");
		}
		else {
			System.out.println("Hatal� Bilgi Giri�i!");
		}
		
	}

}
