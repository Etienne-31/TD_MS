package Models;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missionId;

    private String intituleMission;

    private String statut;
    private String emetteur;

    private String accepteur;

    private String location;

    private String commentaire;


    public Mission() {}
    public Mission(long missionId, String intituleMission, String statut, String emetteur, String accepteur, String location, String commentaire) {
        this.missionId = missionId;
        this.intituleMission = intituleMission;
        this.statut = statut;
        this.emetteur = emetteur;
        this.accepteur = accepteur;
        this.location = location;
        this.commentaire = commentaire;
    }

    public Mission(long missionId, String intituleMission, String statut, String emetteur, String location) {
        this.missionId = missionId;
        this.intituleMission = intituleMission;
        this.statut = statut;
        this.emetteur = emetteur;
        this.location = location;
    }

    public Mission(String intituleMission, String emetteur, String location) {
        this.intituleMission = intituleMission;
        this.emetteur = emetteur;
        this.location = location;
    }

    @Column(name = "MissionId")
    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(long missionId) {
        this.missionId = missionId;
    }


    @Column(name = "IntituleMission")
    public String getIntituleMission() {
        return intituleMission;
    }

    public void setIntituleMission(String intituleMission) {
        this.intituleMission = intituleMission;
    }


    @Column(name = "Statut")
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }


    @Column(name = "Emetteur")
    public String getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(String emetteur) {
        this.emetteur = emetteur;
    }

    @Column(name="Accepteur")
    public String getAccepteur() {
        return accepteur;
    }

    public void setAccepteur(String accepteur) {
        this.accepteur = accepteur;
    }


    @Column(name = "Location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "Commentaire")
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
