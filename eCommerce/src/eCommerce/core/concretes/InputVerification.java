package eCommerce.core.concretes;

import java.util.regex.Pattern;

import eCommerce.core.abstracts.VerificationService;
import eCommerce.entities.concretes.User;

public class InputVerification implements VerificationService {


	public boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
	}
	
	public boolean isValidPassword(String password) {
		if(password == null || password.length()< 6) {
			return false;
		}
		return true;
	}
	
	public boolean isValidString(String name) {
		if(name == null || name.length()<2) {
			return false;
		}
		
		return true;
		
	}

	@Override
	public boolean isValid(User user) {
		if(!isValidEmail(user.geteMail())) {
			System.out.println("Hatalý email ! ");
			return false;
		}
		if(!isValidString(user.getFirstName())) {
			System.out.println("Hatalý isim en az iki karakter giriniz !");
		}
		if(!isValidString(user.getPassword())) {
			System.out.println("Hatalý parola en az 6 karakter giriniz !");
			return false;
		}
		
		return true;
	}

}
