package by.Viktor.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Qwesting> qwestings;

    public Vote() {
    }

    public Vote(String name) {
        this.name = name;
    }

    public Vote(String name, List<Qwesting> qwestings) {
        this.name = name;
        this.qwestings = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Qwesting> getQwestings() {
        return qwestings;
    }

    public void setQwestings(List<Qwesting> qwestings) {
        this.qwestings = qwestings;
    }
}

