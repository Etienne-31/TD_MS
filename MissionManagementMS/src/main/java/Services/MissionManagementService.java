package Services;

import Models.Mission;
import Repositories.MissionHibernateDB.MissionDBManager;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MissionManagementService {

    public boolean postMission(Mission mission){
        return MissionDBManager.InsertDetached(mission);
    }

    public boolean updateMission(Mission mission){
        return MissionDBManager.UpdtateDetached(mission);
    }

    public boolean deleteMission(Long id){
        return MissionDBManager.deleteMission(id);
    }

    public List<Mission> getAllMission(){
        return MissionDBManager.getListMission();
    }

    public ArrayList<Mission> getAllMissionFromEmetteur(String emetteurName){
        List<Mission> allMission = MissionDBManager.getListMission();
        ArrayList<Mission> allMissionFromEmetteur = new ArrayList<Mission>();

        for(Mission ite : allMission){
            if(ite.getEmetteur().equals(emetteurName)){
                allMissionFromEmetteur.add(ite);
            }
        }

        return allMissionFromEmetteur;
    }

    public ArrayList<Mission> getAllMissionFromAccepteur(String accepteurName){
        List<Mission> allMission = MissionDBManager.getListMission();
        ArrayList<Mission> allMissionFromAccepteur = new ArrayList<Mission>();

        for(Mission ite : allMission){
            if(ite.getAccepteur().equals(accepteurName)){
                allMissionFromAccepteur.add(ite);
            }
        }

        return allMissionFromAccepteur;
    }

    public Mission getMissionByID(long id) throws UnknownHostException {
        return MissionDBManager.getMission(id);
    }

    public ArrayList<Mission> getAllMissionByStatus(String status){
        List<Mission> allMission = MissionDBManager.getListMission();
        ArrayList<Mission> allMissionByStatus = new ArrayList<Mission>();

        for(Mission ite : allMission){
            if(ite.getStatut().equals(status)){
                allMissionByStatus.add(ite);
            }
        }

        return allMissionByStatus;
    }

}
