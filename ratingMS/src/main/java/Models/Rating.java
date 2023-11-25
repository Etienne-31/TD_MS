package Models;


import Models.Exceptions.RatingToHighException;
import jakarta.persistence.*;

@Entity
@Table(name="Rating")
public class Rating {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int notation;

    private String comment;

    private String creator;

    public Rating(Long id, int notation, String comment, String creator) throws RatingToHighException {

        if(notation > 20){
            throw new RatingToHighException("La note est trop haute");
        }
        this.id = id;
        this.notation = notation;
        this.comment = comment;
        this.creator = creator;

    }

    public Rating() {

    }


    @Column(name = "Comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Column(name = "Creator")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String byWho) {
        this.creator = byWho;
    }


    @Column(name = "Notation")
    public int getNotation() {
        return notation;
    }

    public void setNotation(int notation) {
        this.notation = notation;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "Id")
    public Long getId() {
        return id;
    }
}
