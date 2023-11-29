package Controlers;


import Models.Mission;
import Services.MissionManagementService;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MissionManagementControler {

    private MissionManagementService service = new MissionManagementService();

    @PostMapping(name = "/PostMission")
    public boolean postMission(@RequestBody Mission mission){
        return service.postMission(mission);
    }

    @PutMapping(name = "/updateMission")
    public boolean updateMission(@RequestBody Mission mission){
        return service.updateMission(mission);
    }

    @DeleteMapping(name = "/deleteMissionById/{id}")
    public boolean deleteMissionById(@PathVariable("id") long id){
        return service.deleteMission(id);
    }

    @GetMapping(name = "/getAllMission")
    public List<Mission> getAllMission(){
        return service.getAllMission();
    }

    @GetMapping(name = "/getAllMappingFromEmetteur/{emetteur}")
    public ArrayList<Mission> getAllMissionFromEmetteur(@PathVariable("emetteur") String emetteur){
        return service.getAllMissionFromEmetteur(emetteur);
    }


    @GetMapping(name = "/getAllMappingFromAccepteur/{accepteur}")
    public ArrayList<Mission> getAllMissionFromAccepteur(@PathVariable("accepteur") String accepteur){
        return service.getAllMissionFromAccepteur(accepteur);
    }

    @GetMapping(name = "/getMissionById/{id}")
    public Mission getMissionById(@PathVariable("id") long id) {
        try {
            return service.getMissionByID(id);
        }
        catch (UnknownHostException e){
            e.printStackTrace();
            Mission errorMission = new Mission();
            errorMission.setIntituleMission("error");
            return errorMission ;
        }

    }

    @GetMapping(name = "/getAllMissionByStatus/{status}")
    public ArrayList<Mission> getAllMissionByStatus(@PathVariable("status")String status){
        return service.getAllMissionByStatus(status);
    }
}
