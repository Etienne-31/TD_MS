package Controlers;

import Models.Rating;
import Services.RatingService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controllers {

    RatingService service= new RatingService();
    @PostMapping("/sendComment")
    public boolean postComment(@RequestBody Rating newRating){
        service.addCommentToDB(newRating);

    }

    @GetMapping("/getCommentById/{id}")
    public Rating getCommentById(@PathVariable("id") long id){
        return service.getCommentById(id);
    }

    @GetMapping("/getAllComments")
    public List<Rating> getAllComments(){
        return service.getAllComment();
    }

    @GetMapping("/getAllCommentsFromUser/{username}")
    public ArrayList<Rating> getAllCommentsFromUser(@PathVariable("username") String username){
        return service.getAllCommentFromACreator(username);
    }

    @DeleteMapping("/deletCommentById/{id}")
    public boolean deleteCommentById(@PathVariable("id") long id){
        return service.deleteCommentFromDB(id);
    }

}
