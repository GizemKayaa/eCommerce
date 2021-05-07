package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class InMemoryUserDao implements UserDao {

    List<User> users = new ArrayList<>();
	
	@Override
	public void add(User user) {
		 users.add(user);
	        System.out.println(user.getFirstName() + "inMemory ile eklendi");
		
	}

	@Override
	public boolean emailCheck(User user) {
        for (User x : users
        )
            if (x.geteMail() == user.geteMail()) {
                return false;
            }
        return true;
	}

	@Override
	public boolean loginByCheck(String email, String password) {
        for (User y : users) {
            if (y.geteMail() == email && y.getPassword() == password)
                return true;
        }
        return false;
    
	}

	


}
