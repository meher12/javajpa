package org.mk.jpapractice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Bank")
@Table(name = "Bank_Account")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Full_Name")
	private String name;
	
	@Column(name = "Balance")
	private double salary;
	
	public BankAccount() {
		super();
	}

	public BankAccount(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if(salary< 0) throw new RuntimeException("Bad value: must be positive");
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
	
	

}
