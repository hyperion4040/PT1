package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "UPRAWNIENIA", schema = "MSU_STUD")
public class Uprawnienia {

    private short idUprawnienia;
    private String nazwa;
    private String opis;


    private Uzytkownicy uzytkownicy;

    @ManyToOne
    @JoinColumn(name = "id_uzytkownika", referencedColumnName = "id_uzytkownika")
    public Uzytkownicy getUzytkownicy() {
        return uzytkownicy;
    }

    public void setUzytkownicy(Uzytkownicy uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
    }

    @Id
    @Column(name = "id_uprawnienia")
    public short getIdUprawnienia() {
        return idUprawnienia;
    }

    public void setIdUprawnienia(short idUprawnienia) {
        this.idUprawnienia = idUprawnienia;
    }

    @Basic
    @Column(name = "nazwa_uprawnienia")
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "opis")
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
