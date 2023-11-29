package Repositories.HibernateDB;


import Models.Rating;
import Repositories.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;
import java.util.List;


@Repository
public class RatingDBManager {
    public static boolean UpdtateDetached(Rating rating){
        boolean update = false;
        SessionFactory factory = Hibernate.getSessionFactory();
        Session session2 = factory.openSession();

        try{

            session2.getTransaction().begin();
            session2.merge(rating);

            session2.flush();
            session2.getTransaction().commit();
            Hibernate.shutdown();
            update = true;

        }
        catch(Exception e){
            e.printStackTrace();
            session2.getTransaction().rollback();
            return false;
        }
        return update;


    }

    public static boolean InsertDetached(Rating rating){
        SessionFactory factory = Hibernate.getSessionFactory();
        Session session2 = factory.openSession();
        boolean toReturn = false;

        try{

            session2.getTransaction().begin();
            session2.save(rating);

            session2.flush();
            session2.getTransaction().commit();
            Hibernate.shutdown();
            toReturn = true;

        }
        catch(Exception e){
            e.printStackTrace();
            session2.getTransaction().rollback();
            return false;
        }
        return toReturn;


    }



    public static List<Rating> getListRating() {
        Session session = Hibernate.getSessionFactory().openSession();
        String hql = "SELECT e FROM Rating e ";

        // String hql = "SELECT u FROM "+Utilisateur.class.getName()+ " u WHERE u.idUser = :id";
        Query query = session.createQuery(hql);

        List<Rating> ratings = query.list();
        session.close();
        return ratings;
    }

    public static boolean deleteRating(long id){
        boolean userDeleted = false;
        Session session = Hibernate.getSessionFactory().openSession();
        String hql = "DELETE FROM Rating WHERE id = :id";

        try {
            session.getTransaction().begin();
            Query query = session.createQuery(hql);
            query.setParameter("id",id);
            query.executeUpdate();
            session.getTransaction().commit();
            Hibernate.shutdown();
            userDeleted = true;

        }
        catch (Exception e ){
            e.printStackTrace();
            return false;
        }
        return userDeleted;
    }

    public static Rating getRating(Long id) throws UnknownHostException {
        SessionFactory factory = Hibernate.getSessionFactory();
        //System.out.println("Factory crée");
        Session session = factory.openSession();
        // System.out.println("Session crée");
        Rating ratingFromDB = new Rating();
        List<Rating> list = null;

        String hql = " FROM  Rating WHERE id = :id";

        try {
            session.getTransaction().begin();
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            list = query.list();
            session.getTransaction().commit();
            Hibernate.shutdown();
        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        for(Rating ite : list){
            if(ite.getId().equals(id)){
                ratingFromDB.setComment(ite.getComment());
                ratingFromDB.setId(ite.getId());
                ratingFromDB.setCreator(ite.getCreator());
                ratingFromDB.setNotation(ite.getNotation());

            }
        }
        return  ratingFromDB;
    }




}
