package org.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Calendar;
import java.util.Collection;

@Entity
public class Project {
    @Id
    private int id;

    private String name;

    @ManyToMany(mappedBy = "p")
    private Collection<Employee> emps;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Employee> getEmps() {
        return emps;
    }

    public void setEmps(Collection<Employee> emps) {
        this.emps = emps;
    }
}
