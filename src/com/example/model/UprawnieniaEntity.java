package com.example.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UPRAWNIENIA", schema = "MSU_STUD")
public class UprawnieniaEntity {
    private String nazwaUprawnienia;
    private String opis;
    private short idUprawnienia;


    private Short idUzytkownika;

    @Basic
    @Column(name = "nazwa_uprawnienia")
    public String getNazwaUprawnienia() {
        return nazwaUprawnienia;
    }

    public void setNazwaUprawnienia(String nazwaUprawnienia) {
        this.nazwaUprawnienia = nazwaUprawnienia;
    }

    @Basic
    @Column(name = "opis")
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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
    @Column(name = "id_uzytkownika")
    public Short getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Short idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UprawnieniaEntity that = (UprawnieniaEntity) o;
        return idUprawnienia == that.idUprawnienia &&
                Objects.equals(nazwaUprawnienia, that.nazwaUprawnienia) &&
                Objects.equals(opis, that.opis) &&
                Objects.equals(idUzytkownika, that.idUzytkownika);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwaUprawnienia, opis, idUprawnienia, idUzytkownika);
    }
}
