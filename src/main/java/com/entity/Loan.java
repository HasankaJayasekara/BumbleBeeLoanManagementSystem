/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

public class Loan{    
    private int id;
    private String fullName;
    private String dob;
    private String address;
    private String phonenumber;
    private String email;
    private String password;
    private double loanAmount;
    private int repaymentPeriod;
    

    public Loan() {
        super();
    }

    public Loan(String fullName, String dob, String address, String phonenumber, String email,String password,double loanAmount, int repaymentPeriod) {
        super();
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
        this.phonenumber= phonenumber;
        this.email = email;
        this.password= password;
        this.loanAmount = loanAmount;
        this.repaymentPeriod = repaymentPeriod;
    }

    public Loan(int id, String fullName, String dob, String address, String phonenumber, String email,String password,double loanAmount, int repaymentPeriod) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
        this.phonenumber= phonenumber;
        this.email = email;
        this.password= password;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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
    public double getLoanAmount() {
    return loanAmount;
}

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(int repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }


    @Override
    public String toString() {
        return "Loan{" + "id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", address=" + address + ", phonenumber=" + phonenumber +", email=" + email+ ", password=" + password  + ", loanAmount=" + loanAmount + ", repaymentPeriod=" + repaymentPeriod + '}';
    }
    
    
    
}
