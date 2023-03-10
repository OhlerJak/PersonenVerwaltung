package model;

import database.Database;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.PersonController;

import java.sql.SQLException;
import java.util.List;

public class Person {
    private final StringProperty vorname = new SimpleStringProperty();
    private final StringProperty wohnort = new SimpleStringProperty();
    private final StringProperty id = new SimpleStringProperty();
    public Person(){
        this("","","");
    }

    public Person(String id, String vorname, String wohnort){
        setWohnort(wohnort);
        setVorname(vorname);
        setId(id);
    }

    public String getVorname() {
        return vorname.get();
    }

    public StringProperty vornameProperty() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname.set(vorname);
    }

    public String getWohnort() {
        return wohnort.get();
    }

    public StringProperty wohnortProperty() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort.set(wohnort);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public ObservableList<Person> getPersonList() throws SQLException{
        List<Person> data = Database.getInstance().getallData();

        if(data!=null)
        return FXCollections.observableList(data);
        return null;
    }


    public int getIDasInt() throws PersonException {
        try {
            return Integer.parseInt(id.get());
        }catch (NumberFormatException e){
            throw new PersonException("ID is not a Number");
        }
    }
    public void setIDasInt(int id){
        setId(id+"");
    }

    public void save() throws SQLException, PersonException {
        checkInputs();
        Database.getInstance().savePerson(this);
    }
    private void checkInputs() throws PersonException {
        if(getWohnort().length()<3)throw new PersonException("Wohnort muss mindestens drei Zeichen haben");
        if (getVorname().length()<3)throw new PersonException("Name muss mindestens drei Zeichen haben");
    }

    @Override
    public String toString() {
        return getId()+" "+getVorname()+" "+getWohnort();
    }
}
