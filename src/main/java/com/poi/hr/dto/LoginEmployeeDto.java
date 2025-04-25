package com.poi.hr.dto;


import com.poi.hr.domain.common.Role;

public class LoginEmployeeDto {

    private String employeeNumber;
    private String password;
    private Role employeeRole;

    public LoginEmployeeDto() {
    }

    public LoginEmployeeDto(String employeeNumber, String password, Role role) {
        this.employeeNumber = employeeNumber;
        this.password = password;
        this.employeeRole = role;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(Role employeeRole) {
        this.employeeRole = employeeRole;
    }

    @Override
    public String toString() {
        return "LoginEmployeeDto{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", password='" + password + '\'' +
                ", employeeRole=" + employeeRole +
                '}';
    }
}

