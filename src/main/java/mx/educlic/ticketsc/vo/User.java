/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.educlic.ticketsc.vo;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Leo
 */
@Entity
@Table(name="Users")
public class User implements Serializable{
    private Long id;
    private String name;
    private String firstName;
    private String secondName;
    private Date birthDate;
    private Long birthTown;
    private String bloodFactor;
    private String gender;
    private String curp;
    private Byte status;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="user_idUser")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column (name="firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column (name="secondName")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Column (name="birthDate")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column (name="birthTown")
    public Long getBirthTown() {
        return birthTown;
    }

    public void setBirthTown(Long birthTown) {
        this.birthTown = birthTown;
    }

    @Column (name="boodFactor")
    public String getBloodFactor() {
        return bloodFactor;
    }

    public void setBloodFactor(String bloodFactor) {
        this.bloodFactor = bloodFactor;
    }

    @Column (name="gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column (name="curp")
    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Column (name="status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
