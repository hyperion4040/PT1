package com.example.web;

import com.example.model.UprawnieniaKontroler;
import com.example.model.Uprawnienia;
import com.example.model.Uzytkownicy;
import com.example.model.UzytkownikKontroler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ArrayDataModel;

@ManagedBean(name = "komponentSesyjny")
@SessionScoped
public class KomponentSesyjny {
    private ArrayDataModel<Uzytkownicy> uzytkownicy;
    private ArrayDataModel<Uprawnienia> uprawnienia;

    public KomponentSesyjny() {
        updateUzytkownicy();
        updateUprawnienia();
    }

    public final void updateUprawnienia(){
        UprawnieniaKontroler uprawnieniaKontroler = new UprawnieniaKontroler();
        uprawnienia = new ArrayDataModel<Uprawnienia>(uprawnieniaKontroler.getUprawnienia());
    }

    public final void updateUzytkownicy()
    {
        UzytkownikKontroler uzytkownicyKontroler =
                new UzytkownikKontroler();
        uzytkownicy = new ArrayDataModel <Uzytkownicy>
                (uzytkownicyKontroler.getUzytkownicy());
    }

    public ArrayDataModel<Uprawnienia> getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(ArrayDataModel<Uprawnienia> uprawnienia) {
        this.uprawnienia = uprawnienia;
    }

    public ArrayDataModel<Uzytkownicy> getUzytkownicy() {
        return uzytkownicy;
    }

    public void setUzytkownicy(ArrayDataModel<Uzytkownicy> uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
    }

    public void deleteUser() {
        Uzytkownicy u = uzytkownicy.getRowData();
        UzytkownikKontroler uzytkownicyKontroler =
                new UzytkownikKontroler();
        uzytkownicyKontroler.usunUzytkownika(u);
        updateUzytkownicy();
    }

    public void deleteUprawnienia() {
        Uprawnienia u = uprawnienia.getRowData();
        UprawnieniaKontroler uprawnieniaKontroler =
                new UprawnieniaKontroler();
        uprawnieniaKontroler.usunUprawnienie(u);
        updateUprawnienia();
    }

    private Uprawnienia uprawn;
    boolean uprEdycja;

    public String editUprawnienia() {
        uprEdycja = true;
        uprawn = uprawnienia.getRowData();

        return "uprawnieniaEdycja";
    }
    public String addUprawnienia() {
        uprEdycja = false;
        uprawn = new Uprawnienia();
        return "uprawnieniaEdycja";
    }

    public Uprawnienia getUprawn() {
        return uprawn;
    }

    public void setUprawn(Uprawnienia uprawn) {
        this.uprawn = uprawn;
    }

    public boolean isUprEdycja() {
        return uprEdycja;
    }

    public void setUprEdycja(boolean uprEdycja) {
        this.uprEdycja = uprEdycja;
    }

    public boolean isEdycja() {
        return edycja;
    }

    public void setEdycja(boolean edycja) {
        this.edycja = edycja;
    }

    public String saveUpr() {
        UprawnieniaKontroler uprawnieniaKontroler = new UprawnieniaKontroler();
        if (uprEdycja)
        {
            uprawnieniaKontroler.aktualizujUprawnienie(uprawn);
        }
        else
        {
            uprawnieniaKontroler.dodajUprawnienie(uprawn);
        }
        updateUprawnienia();
        return "uprawnienia";
    }

    private Uzytkownicy uzytkk;
    boolean edycja;
    public String editUser() {
        edycja = true;
        uzytkk = uzytkownicy.getRowData();

        return "edycja";
    }
    public String addUser() {
        edycja = false;
        uzytkk = new Uzytkownicy();
        return "edycja";
    }
    public Uzytkownicy getUzytkk () {
        return uzytkk;
    }
    public void setUzytkk (Uzytkownicy uzytkk) {
        this. uzytkk = uzytkk;
    }

    public String save() {
        UzytkownikKontroler uzytkownicyKontroler =
                new UzytkownikKontroler();
        if (edycja)
        {
            uzytkownicyKontroler.aktualizujUzytkownika(uzytkk);
        }
        else
        {
            uzytkownicyKontroler.dodajUzytkownika(uzytkk);
        }
        updateUzytkownicy();
        return "index";
    }


}
