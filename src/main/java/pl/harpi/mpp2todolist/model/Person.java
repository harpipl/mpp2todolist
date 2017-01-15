package pl.harpi.mpp2todolist.model;

import javax.xml.bind.annotation.XmlValue;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @XmlValue
    public void setName(String name) {
        this.name = name;
    }
}
