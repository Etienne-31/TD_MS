package Services;

import Repositories.HibernateDB.UserDBManager;

public class userManagementService {

    public static boolean deleteUser(String nom){
        return UserDBManager.deleteUser(nom);
    }
}
