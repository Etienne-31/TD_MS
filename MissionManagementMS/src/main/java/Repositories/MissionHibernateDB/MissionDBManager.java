package Repositories.MissionHibernateDB;


import Models.Mission;
import Repositories.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;
import java.util.List;


@Repository
public class MissionDBManager {
    public static boolean UpdtateDetached(Mission mission){
        boolean update = false;
        SessionFactory factory = Hibernate.getSessionFactory();
        Session session2 = factory.openSession();

        try{

            session2.getTransaction().begin();
            session2.merge(mission);

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

    public static boolean InsertDetached(Mission mission){
        SessionFactory factory = Hibernate.getSessionFactory();
        Session session2 = factory.openSession();
        boolean toReturn = false;

        try{

            session2.getTransaction().begin();
            session2.save(mission);

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



    public static List<Mission> getListMission() {
        Session session = Hibernate.getSessionFactory().openSession();
        String hql = "SELECT e FROM Mission e ";

        // String hql = "SELECT u FROM "+Utilisateur.class.getName()+ " u WHERE u.idUser = :id";
        Query query = session.createQuery(hql);

        List<Mission> missions = query.list();
        session.close();
        return missions;
    }

    public static boolean deleteMission(long missionId){
        boolean userDeleted = false;
        Session session = Hibernate.getSessionFactory().openSession();
        String hql = "DELETE FROM Mission WHERE missionId = :missionId";

        try {
            session.getTransaction().begin();
            Query query = session.createQuery(hql);
            query.setParameter("missionId",missionId);
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

    public static Mission getMission(long id) throws UnknownHostException {
        SessionFactory factory = Hibernate.getSessionFactory();
        //System.out.println("Factory crée");
        Session session = factory.openSession();
        // System.out.println("Session crée");
        Mission missionFromDB = new Mission();
        List<Mission> list = null;

        String hql = " FROM  Mission WHERE missionId = :id";

        try {
            session.getTransaction().begin();
            Query query = session.createQuery(hql);
            query.setParameter("missionId", id);
            list = query.list();
            session.getTransaction().commit();
            Hibernate.shutdown();
        }
        catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        for(Mission ite : list){
            if(ite.getMissionId().equals(id)){
                missionFromDB.setIntituleMission(ite.getIntituleMission());
                missionFromDB.setCommentaire(ite.getCommentaire());
                missionFromDB.setMissionId(ite.getMissionId());
                missionFromDB.setAccepteur(ite.getAccepteur());
                missionFromDB.setEmetteur(ite.getEmetteur());
                missionFromDB.setStatut(ite.getStatut());
                missionFromDB.setLocation(ite.getLocation());


            }
        }
        return  missionFromDB;
    }




}
