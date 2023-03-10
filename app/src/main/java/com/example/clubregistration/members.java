package com.example.clubregistration;

public class Members {
    String firstName;
    String lastName;
    String email;
    String club;
    int id;
    public Members(){}

    public Members(String firstName, String lastName, String email, String club, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.club = club;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Members{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", club='" + club + '\'' +
                '}';
    }
}
