package Controllers;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController {

    @DeleteMapping("/deleteUser/{nom}")
    public boolean deleteUset(@PathVariable("nom") String nom){
        return
    }

}
