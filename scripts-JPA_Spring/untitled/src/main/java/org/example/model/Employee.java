package org.example.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="EMP")
public class Employee {
    @Id
    private int id;




    @OneToOne
    @JoinColumn(name="P_SPACE")
    private ParkingSpace space;

    @ManyToOne
    @JoinColumn(name="DEPT_ID")
    public Department dep;

    @ManyToMany
    @JoinTable(name = "EMP_PROJ",
            joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="PROJ_ID",referencedColumnName = "id"))
    private Collection<Project> p;

    public int getId() {
        return id;
    }

    public Collection<Project> getP() {
        return p;
    }

    public void setP(Collection<Project> p) {
        this.p = p;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingSpace getSpace() {
        return space;
    }

    public void setSpace(ParkingSpace space) {
        this.space = space;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

}
