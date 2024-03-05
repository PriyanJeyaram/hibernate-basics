package com.bootcamp;

import com.bootcamp.model.Employee;
import com.bootcamp.util.HibernateUtil;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Employee employee = new Employee();

        employee.setEmployeeName("Priyan");
        employee.setEmployeeRole("Admin");
        employee.setEmployeeId(String.valueOf(UUID.randomUUID()));

        var session = HibernateUtil.getSessionFactory().getCurrentSession();

//        Start Transaction
        session.beginTransaction();
//        Save
        session.save(employee);
//        Commit
        session.getTransaction().commit();

//        Terminate session
        HibernateUtil.getSessionFactory().close();
    }
}