package pl.edu.agh.omdmb.component.jpa.dao;

import javax.persistence.*;

@Entity
public class FirstDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String stringField;

    public void setStringField(String aStringField) {
        stringField = aStringField;
    }

    public String getStringField() {
        return stringField;
    }
}
