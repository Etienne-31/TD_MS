package Repositories.HibernateDB;

import Models.User;
import Repositories.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;
import java.util.List;


@Repository
public class UserDBManager {
    public static void UpdtateDetached(User utilisateur){
        SessionFactory factory = Hibernate.getSessionFactory();
        Session session2 = factory.openSession();

        try{

            session2.getTransaction().begin();
            session2.merge(utilisateur);

            session2.flush();
            session2.getTransaction().commit();
            Hibernate.shutdown();

        }
        catch(Exception e){
            e.printStackTrace();
            session2.getTransaction().rollback();
        }


    }

    public static boolean InsertDetached(User utilisateur){
        SessionFactory factory = Hibernate.getSessionFactory();
        Session session2 = factory.openSession();
        boolean toReturn = false;

        try{

            session2.getTransaction().begin();
            session2.save(utilisateur);

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



    public static List<String> getListUser() {
        Session session = Hibernate.getSessionFactory().openSession();
        String hql = "SELECT name FROM User ";

        // String hql = "SELECT u FROM "+Utilisateur.class.getName()+ " u WHERE u.idUser = :id";
        Query query = session.createQuery(hql);

        List<String> utilisateurs = query.list();
        session.close();
        return utilisateurs;
    }

    public static boolean deleteUser(String name){
        boolean userDeleted = false;
        Session session = Hibernate.getSessionFactory().openSession();
        String hql = "DELETE FROM User WHERE name = :name";

        try {
            session.getTransaction().begin();
            Query query = session.createQuery(hql);
            query.setParameter("name",name);
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

    public static User getUtilisateur(String name) throws UnknownHostException {
        SessionFactory factory = Hibernate.getSessionFactory();
        //System.out.println("Factory crée");
        Session session = factory.openSession();
        // System.out.println("Session crée");
        User userFromDB = new User();
        List<User> list = null;

        String hql = " FROM  User WHERE name = :name";

        try {
            session.getTransaction().begin();
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            list = query.list();
            session.getTransaction().commit();
            Hibernate.shutdown();
        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        for(User ite : list){
            if(ite.getName().equals(name)){
                userFromDB.setName(ite.getName());
                userFromDB.setRole(ite.getRole());
            }
        }
        return  userFromDB;
    }




}
