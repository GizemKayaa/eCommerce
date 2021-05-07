package eCommerce.dataAccess.abstracts;



import eCommerce.entities.concretes.User;

public interface UserDao {

    void add(User user);
    boolean emailCheck(User user);
    boolean loginByCheck(String email, String password);
	
}
