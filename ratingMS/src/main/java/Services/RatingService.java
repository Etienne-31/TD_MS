package Services;

import Models.Rating;
import Repositories.HibernateDB.RatingDBManager;

import java.lang.reflect.Array;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class RatingService {

    public RatingService(){};

    public boolean addCommentToDB(Rating rating){
        return RatingDBManager.InsertDetached(rating);
    }

    public boolean deleteCommentFromDB(long id){
        return RatingDBManager.deleteRating(id);
    }

    public Rating getCommentById(long id ){
        try {
            return RatingDBManager.getRating(id);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Rating> getAllComment(){
        return RatingDBManager.getListRating();
    }

    public ArrayList<Rating> getAllCommentFromACreator(String creatorName){
        ArrayList<Rating> allCommentsFromUser = new ArrayList<Rating>();
        List<Rating> allComments = RatingDBManager.getListRating();
        for(Rating index : allComments){
            if(index.getCreator().equals(creatorName)){
                allCommentsFromUser.add(index);
            }
        }
        return allCommentsFromUser;
    }


}
