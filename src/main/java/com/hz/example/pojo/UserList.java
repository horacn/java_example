package com.hz.example.pojo;

import java.util.List;
 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
/**
 * @author Unmi CreateTime: Apr 21, 2011
 */
@XmlRootElement(name = "users")
public class UserList {
    List<User> users;
 
    @XmlElement(name = "user")
    public List<User> getUsers() {
        return users;
    }
 
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
