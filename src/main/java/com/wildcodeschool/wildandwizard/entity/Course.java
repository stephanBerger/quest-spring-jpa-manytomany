package com.wildcodeschool.wildandwizard.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "wizard_course",
    		joinColumns = @JoinColumn(name = "course_id"),
    		inverseJoinColumns = @JoinColumn(name = "wizard_id"))
    private List<Wizard> wizards;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {	
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public List<Wizard> getWizards() {
		return wizards;
	}

	public void setWizards(List<Wizard> wizards) {
		this.wizards = wizards;
	}
    
}	