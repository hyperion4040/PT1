package com.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "UZYTKOWNICY", schema = "MSU_STUD")
public class Uzytkownicy {
    private String nazwaUzytkownika;
    private String haslo;
    private String adresEmail;
    private short idUzytkownika;



    private List<Uprawnienia> uprawnienia;

    @OneToMany(mappedBy = "idUprawnienia", fetch = FetchType.EAGER)
    public List<Uprawnienia> getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(List<Uprawnienia> uprawnienia) {
        this.uprawnienia = uprawnienia;
    }

    @Basic
    @Column(name = "nazwaUzytkownika")
    public String getNazwaUzytkownika() {
        return nazwaUzytkownika;
    }

    public void setNazwaUzytkownika(String nazwaUzytkownika) {
        this.nazwaUzytkownika = nazwaUzytkownika;
    }

    @Basic
    @Column(name = "haslo")
    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    @Basic
    @Column(name = "adres_email")
    public String getAdresEmail() {
        return adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }

    @Id
    @Column(name = "id_uzytkownika")
    public short getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(short idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uzytkownicy that = (Uzytkownicy) o;
        return idUzytkownika == that.idUzytkownika &&
                Objects.equals(nazwaUzytkownika, that.nazwaUzytkownika) &&
                Objects.equals(haslo, that.haslo) &&
                Objects.equals(adresEmail, that.adresEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwaUzytkownika, haslo, adresEmail, idUzytkownika);
    }
}
