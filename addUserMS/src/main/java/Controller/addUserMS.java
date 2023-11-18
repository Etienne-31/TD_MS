package Controller;


import Services.AddUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class addUserMS {

    AddUser service = new AddUser();

    @PostMapping("/addBenevole/{nom}")
    public boolean addBenevole(@PathVariable String nom){
        return service.addUser(nom,"1");
    }

    @PostMapping("/addValideur/{nom}")
    public boolean addValideur(@PathVariable String nom){
        return service.addUser(nom,"2");
    }

    @PostMapping("/addDemandeur/{nom}")
    public boolean addDemandeur(@PathVariable String nom){
        return service.addUser(nom,"3");
    }


}
