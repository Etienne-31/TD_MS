package Controllers;


import Models.User;
import Repositories.HibernateDB.UserDBManager;
import Services.UserManagementService;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserManagementController {


    UserManagementService service = new UserManagementService();
    @DeleteMapping("/deleteUser/{nom}")
    public boolean deleteUser(@PathVariable("nom") String nom){
        return service.deleteUser(nom);
    }

    @PutMapping("/updateUser/{nom}/{role}")
    public boolean updateUser(@PathVariable("nom") String nom,@PathVariable("role") String role){
        boolean update = false;
        if(role.equals("1") || role.equals("2") || role.equals("3")){
            User updateUser = new User(nom,role);
            update = UserDBManager.UpdtateDetached(updateUser);
        }
        else{
            return false;
        }
        return update;
    }

    @GetMapping("/getUser/{nom}")
    public User getUser(@PathVariable("nom") String nom) {
        try{
            return UserDBManager.getUtilisateur(nom);
        }
        catch (UnknownHostException e){
            e.printStackTrace();
            return new User("","");
        }

    }

    @GetMapping("/getAllUser")
    public List<String> getAllUsername(){
        return  UserDBManager.getListUser();
    }






}
