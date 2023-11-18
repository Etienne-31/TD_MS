package Services;


import Models.User;
import Repositories.HibernateDB.UserDBManager;
import org.springframework.stereotype.Service;


@Service
public class AddUser {

    public boolean addUser(String name,String role){
        User newUser = new User(name,role);
        return UserDBManager.InsertDetached(newUser);
    }
}
