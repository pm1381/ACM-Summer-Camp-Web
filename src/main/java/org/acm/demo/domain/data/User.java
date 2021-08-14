package org.acm.demo.domain.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author : Bahar Zolfaghari
 **/
public class User {
    @JsonIgnore
    private Integer id;
    private String name;
    private String family;
    private String phone;
    private String email;
    private String password;
    private Role role;

    public User(String name, String family, String phone, String email, String password) {
        this.name = name;
        this.family = family;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
