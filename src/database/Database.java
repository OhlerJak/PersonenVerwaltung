package database;

import model.Person;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Database {
    private static Database instance =null;

    public static Database getInstance() {
       if(instance == null){
           instance = new Database();
       }
       return instance;
    }


    private Connection c;

    public Database()  {
        try{

        c = DriverManager.getConnection("jdbc:derby://localhost:1527/PersonDB;","app","password");
        // Create DB
        Statement s = c.createStatement();

            s.executeUpdate("CREATE TABLE Adresse(id int primary key, wohnort varchar(255))");
            s.executeUpdate("CREATE TABLE Person(id int primary key , name varchar(255), adresse int, foreign key (adresse) references Adresse(id))");
            System.out.println("Executed!");
        }catch (SQLException e){
            System.out.println("Keine neuen Tabellen erzeugt! (existieren schon)");
        }
    }

    public Connection getConnection() {
        return c;
    }

    public void insertAdresse(){
//        PreparedStatement ps = c.prepareStatement()
        // PreparedStatement ps = c.createStatement()
    }


    public List<Person> getallData() throws SQLException{
        List<Person> personen = new LinkedList<>();
        PreparedStatement ps = c.prepareStatement("SELECT p.id, p.name, a.wohnort FROM Person p INNER JOIN Adresse a ON a.id=p.adresse");
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            personen.add(new Person(rs.getString(1),rs.getString(2),rs.getString(3)));
        }

        return personen;
    }
}
