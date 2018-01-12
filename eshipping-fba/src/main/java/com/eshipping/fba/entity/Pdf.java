package com.eshipping.fba.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pdf implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String    UniqueRef;
	private String  jboNumber;
	private String servicecode;
	private String ServiceCentre;
	private String TourId;
	private String RoutingCode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUniqueRef() {
		return UniqueRef;
	}
	public void setUniqueRef(String uniqueRef) {
		UniqueRef = uniqueRef;
	}
	public String getJboNumber() {
		return jboNumber;
	}
	public void setJboNumber(String jboNumber) {
		this.jboNumber = jboNumber;
	}
	public String getServicecode() {
		return servicecode;
	}
	public void setServicecode(String servicecode) {
		this.servicecode = servicecode;
	}
	public String getServiceCentre() {
		return ServiceCentre;
	}
	public void setServiceCentre(String serviceCentre) {
		ServiceCentre = serviceCentre;
	}
	public String getTourId() {
		return TourId;
	}
	public void setTourId(String tourId) {
		TourId = tourId;
	}
	public String getRoutingCode() {
		return RoutingCode;
	}
	public void setRoutingCode(String routingCode) {
		RoutingCode = routingCode;
	}
	@Override
	public String toString() {
		return "Pdf [id=" + id + ", UniqueRef=" + UniqueRef + ", jboNumber=" + jboNumber + ", servicecode="
				+ servicecode + ", ServiceCentre=" + ServiceCentre + ", TourId=" + TourId + ", RoutingCode="
				+ RoutingCode + "]";
	}
	
	
	

	

}
