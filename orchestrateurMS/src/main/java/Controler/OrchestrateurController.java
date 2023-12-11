package Controler;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrchestrateurController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping(name = "/addBenevole/{nom}")
    public boolean addBenevole(@PathVariable(name = "nom")String id){
        boolean response = restTemplate.getForObject("http://addUserMS/addBenevole/"+id,boolean.class);
        return response;
    }
    @GetMapping(name = "/addValideur/{nom}")
    public boolean addValideur(@PathVariable(name = "nom")String id){
        boolean response = restTemplate.getForObject("http://addUserMS/addValideur/"+id,boolean.class);
        return response;
    }
    @GetMapping(name = "/addDemandeur/{nom}")
    public boolean addDemandeur(@PathVariable(name = "nom")String id){
        boolean response = restTemplate.getForObject("http://addUserMS/addDemandeur/"+id,boolean.class);
        return response;
    }

    @GetMapping(name ="/deleteUser/{nom}" )
    public boolean deleteUser(@PathVariable(name = "nom") long nom){
      return   restTemplate.getForObject("https://userManagement/deleteUser/"+nom,boolean.class);
    }

    @GetMapping(name = "/updateUser/{nom}/{role}")
    public boolean updateUser(@PathVariable("nom") String nom,@PathVariable("role") String role){
        if(role.equals("1")||role.equals("2")||role.equals("3")) {
            return restTemplate.getForObject("https://userManagement/updateUser/" + nom + "/" + role, boolean.class);
        }
        else{
            return false;
        }
    }


    //Demander pour la
    @GetMapping(name = "/getUser/{nom}")
    public Object getUser(@PathVariable("nom") String nom) {
        return  restTemplate.getForObject("https://userManagement/getUser/"+nom,Object.class);
    }

    @GetMapping(name = "getAllUser" )
    public List<String> getAllUsername(){
        return restTemplate.getForObject("/https://userManagement/getAllUser",List.class);
    }







}
