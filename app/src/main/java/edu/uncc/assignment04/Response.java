package edu.uncc.assignment04;

import java.io.Serializable;

public class Response implements Serializable {
    private String name;
    private String email;
    private String role;

    private String education;
    private String maritalStatus;
    private String livingStatus;
    private String income;

    public Response(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public Response(String name, String email, String role, String education, String maritalStatus, String livingStatus, String income) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.education = education;
        this.maritalStatus = maritalStatus;
        this.livingStatus = livingStatus;
        this.income = income;
    }


    //Getters

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getEducation() {
        return education;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getLivingStatus() {
        return livingStatus;
    }

    public String getIncome() {
        return income;
    }


    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setLivingStatus(String livingStatus) {
        this.livingStatus = livingStatus;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Response{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", education='" + education + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", livingStatus='" + livingStatus + '\'' +
                ", income='" + income + '\'' +
                '}';
    }
}
