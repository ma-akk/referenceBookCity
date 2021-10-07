package com.example.referencebookcity.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "City")
public class City {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "region")
    private String region;

    @Column(name = "district")
    private String district;

    @Column(name = "population")
    private int population;

    @DateTimeFormat(pattern = "yyyy")
    @Column(name = "foundation")
    private Date foundation;

    /**
     * Constructors
     */

    public City() {
    }

    public City(Long id, String name, String region, String district, int population, Date foundation) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    /**
     * Getters
     */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public Date getFoundation() {
        return foundation;
    }

    /**
     * Setters
     */

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setFoundation(Date foundation) {
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return  "City{name='" + name +
                "', region='" + region +
                "', district='" + district +
                "', population=" + population +
                ", foundation='" + foundation + "'}";
    }
}
