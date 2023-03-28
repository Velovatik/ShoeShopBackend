package com.velov.shoeshop.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Salary")
    private int salary;

    @Column(name = "Passport")
    private String passport;

    @Enumerated(EnumType.STRING)
    private salaryType salaryType;

    public Employee() {

    }

    public Employee(String firstName, String lastName, int salary, String passport, com.velov.shoeshop.entities.salaryType salaryType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.passport = passport;
        this.salaryType = salaryType;
    }

    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public com.velov.shoeshop.entities.salaryType getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(com.velov.shoeshop.entities.salaryType salaryType) {
        this.salaryType = salaryType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", passport='" + passport + '\'' +
                ", salaryType=" + salaryType +
                '}';
    }
}
