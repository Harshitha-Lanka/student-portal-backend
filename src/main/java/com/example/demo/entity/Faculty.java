package com.example.demo.entity;
import jakarta.persistence.*;


import lombok.AllArgsConstructor;


@Entity

@AllArgsConstructor

@Table(name="faculty")
public class Faculty {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id; 

	    @Column(name = "faculty_id", unique = true)
	    private String facultyId;
	
	@Column(name="faculty_name")
	private String facultyName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="department")
	private String department;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="phone_number")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="joining_date")
	private String joiningdate;
	
	@Column(name="profile_picture")
	private String profile;
	 @ManyToOne
	 @JoinColumn(name = "user_id")
	    private Users user;
	 public Faculty() {
		   
		}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String  getFacultyId() {
		return facultyId;
	}
	 
	public Faculty(String facultyId) {
	    this.facultyId = facultyId;
	}
	
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(String joiningdate) {
		this.joiningdate = joiningdate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile += profile;
	}
	public Users getUser() {
	    return user;
	}

	public void setUser(Users user) {
	    this.user = user;
	}
	

}
