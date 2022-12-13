package com.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studb")
public class Student implements Serializable {
	
	@Id
	@Column(name="sid")
	private int stdId;
	@Column(name="sname")
	private String stdName;
	private String course;
	public Student() {
		super();
	}
	public Student(int stdId, String stdName, String course) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.course = course;
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", course=" + course + "]";
	}
	
}
