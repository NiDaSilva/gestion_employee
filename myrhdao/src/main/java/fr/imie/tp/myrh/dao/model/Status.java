package fr.imie.tp.myrh.dao.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ndasilva on 02/02/2017.
 */
@Entity
@Table(name = "T_STATUS")

@NamedQueries({
        @NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
})
public class Status implements Serializable{

    @Id
    @Column(name = "stat_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "stat_libelle")
    private String libelle;

    public Status(String libelle) {
        this.libelle = libelle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
