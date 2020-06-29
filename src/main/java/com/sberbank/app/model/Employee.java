package com.sberbank.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "given_name")
    private String givenName;
    @Column(name = "position")
    private String position;
    @Column(name = "age")
    private int age;
    @Column(name = "team_id")
    private int teamId;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName,
                    String givenName, String position, int age, int teamId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.givenName = givenName;
        this.position = position;
        this.age = age;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", teamId=" + teamId +
                '}';
    }
}
