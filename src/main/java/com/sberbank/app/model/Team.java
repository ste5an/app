package com.sberbank.app.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "squad_type")
    private String type;
    @Column(name = "tag")
    private String tag;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private List<Employee> employees;


    public Team() {
    }

    public Team(int id, String name, String type, String tag) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.tag = tag;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", tag='" + tag + '\'' +
                ", employees=" + employees +
                '}';
    }
}
