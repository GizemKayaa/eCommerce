package eCommerce;



import eCommerce.business.abstracts.UserService;
import eCommerce.business.concretes.UserManager;
import eCommerce.core.concretes.EmailValidatorManager;
import eCommerce.core.concretes.GoogleUserServiceAdapter;
import eCommerce.core.concretes.InputVerification;
import eCommerce.dataAccess.concretes.InMemoryUserDao;
import eCommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User("Gizem","Kaya","kayagizem2301@gmail.com","123456");
		
		UserService userService1 = new UserManager(new InMemoryUserDao(), new InputVerification(), new EmailValidatorManager());
		
		
     
		userService1.register(user1);
		
		
		
		User user2 = new User("Engin","Demiroð","engindemirog@gmail.com","121212");
		
		System.out.println("--------------------");
		
		UserService userService2 = new UserManager(new InMemoryUserDao(), new GoogleUserServiceAdapter(), new EmailValidatorManager());
		
		
		
		userService2.register(user2);
		
		System.out.println("--------------------");
		
		userService1.login("kayagizem2301@gmail.com", "123456738393020");
		
		System.out.println("--------------------");
		
        userService1.login("kayagizem2301@gmail.com", "123456");
        
        System.out.println("--------------------");
        
        userService2.login("engindemirog@gmail.com", "121212");
        
        
	}

}
