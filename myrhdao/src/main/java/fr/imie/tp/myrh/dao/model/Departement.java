package fr.imie.tp.myrh.dao.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ndasilva on 31/01/2017.
 */
@Entity
@Table(name = "T_DEPARTEMENT")
public class Departement implements Serializable {

    @Id
    @Column(name = "dep_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "dep_code")
    private String code;

    @Column(name = "dep_description")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
