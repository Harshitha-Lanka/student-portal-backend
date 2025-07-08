package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student_information")
public class Student {

	@Id
	@Column(name = "student_id", nullable = false, unique = true)
	private String studentId;

  
    @Column(name="full_name")
    private String name;
    
    @Column(name="father_name")
    private String father;
    
    @Column(name="mother_name")
    private String mother;
    
    @Column(name="date_of_birth")
    private String dob;
    
    @Column(name="gender")
    private String gender;
    
    
    @Column(name="tenth_marks")
    private Double tenth;
    
    @Column(name="twelfth_marks")
    private Double twelfth;
    
    @Column(name="address")
    private String address;
    
    @Column(name="email")
    private String email;
    
    
    @Column(name="phone_number")
    private String phone;
 

    
   
    
    @Column(name="department")
    private String department;
    
    @Column(name="admission_year")
    private int admissionYear;
    
    @Column(name="profile_picture")
    private String profilepath;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Double getTenth() {
		return tenth;
	}
	public void setTenth(Double tenth) {
		this.tenth = tenth;
	}
	public Double getTwelfth() {
		return twelfth;
	}
	public void setTwelfth(Double twelfth) {
		this.twelfth = twelfth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAdmissionYear() {
		return admissionYear;
	}
	public void setAdmissionYear(int admissionYear) {
		this.admissionYear = admissionYear;
	}
	public String getProfilepath() {
		return profilepath;
	}
	public void setProfilepath(String profilepath) {
		this.profilepath = profilepath;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
    
}
