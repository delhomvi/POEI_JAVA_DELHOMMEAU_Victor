package org.example;

import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.ParkingSpace;
import org.example.model.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;

public class DemoLiaison {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();

        // Employée
        transac.begin();
        Employee employee = new Employee();
        employee.setId(5);
        em.persist(employee);
        transac.commit();


        // Parking space
        transac.begin();
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setId(6);
        parkingSpace.setLocation("emplacement 6");
        parkingSpace.setEmp(employee);
        employee.setSpace(parkingSpace);
        em.persist(parkingSpace);
        transac.commit();

        //recup des info
        Employee employee1 = em.find(Employee.class,5);
        System.out.println("Employé avec l'ID: "+employee1.getId()+" et à la palce de parking d'ID: "+employee1.getSpace().getId());

        // many to many
        transac.begin();
        Employee employee2 = new Employee();
        employee2.setId(6);
        em.persist(employee2);
        transac.commit();

        Department department= new Department();
        department.setId(1);
        department.setDname("sciences");
        Collection<Employee> list = new ArrayList<>();
        list.add(employee2);
        list.add(employee);

        department.setEmps(list);
        transac.begin();

        employee.setDep(department);
        employee2.setDep(department);

        em.persist(department);
        em.persist(employee);
        em.persist(employee2);

        transac.commit();

        Employee employee3 = em.find(Employee.class,5);
        Employee employee4 = em.find(Employee.class,6);
        System.out.println(String.format("Employé avec id %s travail au departement %s",employee3.getId(),employee3.getDep().getDname()));
        System.out.println(String.format("Employé avec id %s travail au departement %s",employee4.getId(),employee4.getDep().getDname()));


        // Many to many
        transac.begin();
        Project project = new Project();
        project.setId(1);
        project.setName("A");
        em.persist(project);

        Project project1 = new Project();
        project1.setId(2);
        project1.setName("B");
        em.persist(project1);

        Collection<Project> projs = new ArrayList<>();
        projs.add(project);
        projs.add(project1);

        Employee employee5 = em.find(Employee.class,5);
        Employee employee6 = em.find(Employee.class,6);
        Collection<Employee> emps = new ArrayList<>();
        emps.add(employee5);
        emps.add(employee6);

        employee5.setP(projs);
        employee6.setP(projs);

        em.persist(employee5);
        em.persist(employee6);

        project.setEmps(emps);
        project1.setEmps(emps);

        transac.commit();

        transac.begin();
        Employee employee7 = em.find(Employee.class,5);
        Employee employee8 = em.find(Employee.class,6);
        Project project2 = em.find(Project.class,1);
        Project project3 = em.find(Project.class,2);

        System.out.println(String.format("Liste des projets de l'employé avec l'id %s",employee7.getId()));
        for(Project p: employee7.getP()){
            System.out.println(p.getName());
        }

        System.out.println(String.format("Liste des projets de l'employé avec l'id %s",employee8.getId()));
        for(Project p: employee8.getP()){
            System.out.println(p.getName());
        }

        transac.commit();
        em.close();
        emf.close();



    }
}




