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
			System.out.println("Kayýt Baþarýsýz !");
		}
		else if(!userDao.emailCheck(user)) {
			System.out.println("Bu e mail adresi daha önce alýnmýþ!");
		}
		else {
			userDao.add(user);
			validatorService.sendVerificationMail();
		}
	}


	@Override
	public void login(String email, String password) {
		if(userDao.loginByCheck(email, password)) {
			System.out.println("Giriþ Baþarýlý");
		}
		else {
			System.out.println("Hatalý Bilgi Giriþi!");
		}
		
	}

}
