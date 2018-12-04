package by.Viktor.Model;

import javax.persistence.*;

@Entity
@Table(name = "qwesting")
public class Qwesting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String qname;
    private  Long numberOfVotes;

    public Qwesting(String qname) {
        this.qname = qname;
        this.numberOfVotes=0l;

    }

    public Qwesting() {
        this.numberOfVotes= 0l;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public Long getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(Long numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

}
