package Services;

import Repositories.HibernateDB.UserDBManager;

public class UserManagementService {

    public  boolean deleteUser(String nom){
        return UserDBManager.deleteUser(nom);
    }
}
