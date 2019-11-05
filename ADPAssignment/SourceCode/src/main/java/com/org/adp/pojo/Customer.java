package com.org.adp.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CUSTOMER", uniqueConstraints = {@UniqueConstraint(columnNames = "CUSTID")})
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CUSTID", unique = true, nullable = false)
	private int custId;
	
	@Column(name = "CUST_NAME", unique = false, nullable = false)
	private String custName;
	
	public Customer(){
		
	}
	public Customer(int custId, String custName) {
		super();
		this.custId = custId;
		this.custName = custName;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public boolean equals(Object cust){
		if(cust == null)
			return false;
		if(cust instanceof Customer ){
			if(this.custId == (((Customer) cust).getCustId())
					&& this.custName.equals(((Customer) cust).getCustName()))
				return true;
			else
				return false;
		}
		return false;
	}
	public int hashCode(){
		int result = 17;
        result = 31 * result + custName.hashCode();
        return result;
	}
	
}
