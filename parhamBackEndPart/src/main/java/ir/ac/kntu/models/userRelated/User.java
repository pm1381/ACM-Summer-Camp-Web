package ir.ac.kntu.models.userRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public abstract class User {
    @JsonIgnore
    private int id;
    private String name;
    private String familyName;
    private String phoneNumber;
    private String email;
    private String password;

    public User(String name, String familyName, String phoneNumber, String email, String password) {
        this.name = name;
        this.familyName = familyName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && Objects.equals(getName(), user.getName()) &&
                Objects.equals(getFamilyName(), user.getFamilyName()) &&
                Objects.equals(getPhoneNumber(), user.getPhoneNumber()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getFamilyName(), getPhoneNumber(), getEmail(), getPassword());
    }
}
