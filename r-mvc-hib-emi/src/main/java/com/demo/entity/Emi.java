package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="emi")
public class Emi {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="no")
	private int no;
	
	
	@Column(name="outstandingPrincipal")
	@Range(min=0)
    @NotEmpty(message="Please Enter out standing principaL")
	private String outstandingPrincipal;
	
	@Column(name="interestRate")
	@Range(min=0)
	@NotEmpty(message="Please Enter interestRate")
    private String interestRate;
	
	@Column(name="principal")
	@Range(min=0)
	@NotEmpty(message="Please Enter principle")
	private String principal;
	
	@Column(name="emi")
	@Range(min=0)
	@NotEmpty(message="Please Enter emi")
	private String emi;
	
	@Formula("outstandingPrincipal=emi")
	private String total;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getOutstandingPrincipal() {
		return outstandingPrincipal;
	}
	public void setOutstandingPrincipal(String outstandingPrincipal) {
		this.outstandingPrincipal = outstandingPrincipal;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getEmi() {
		return emi;
	}
	public void setEmi(String emi) {
		this.emi = emi;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Emi [no=" + no + ", outstandingPrincipal=" + outstandingPrincipal + ", interestRate=" + interestRate
				+ ", principal=" + principal + ", emi=" + emi + ", total=" + total + "]";
	}
}}