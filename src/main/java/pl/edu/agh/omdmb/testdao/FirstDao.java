package pl.edu.agh.omdmb.testdao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public int getId() {
        return id;
    }
}
