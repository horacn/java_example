package com.hz.example.pojo;

import com.hz.example.util.DateAdapter;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author Unmi
 * CreateTime: Apr 21, 2011
 */
public class User {
    private int id;
    private String type;
    private String name;
    private Date date;
 
    @XmlElement(name = "id")
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @XmlElement(name = "time")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getDate() {
        return date;
    }
 
    public void setDate(Date date) {
        this.date = date;
    }
 
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/2001/XMLSchema-instance")
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
 
    public String toString() {
        return id + ":" + name + ":" + type + ":" + date;
    }
}