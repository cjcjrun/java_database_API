package edu.easternct.CSC342.sample;

import java.util.*;

@SuppressWarnings("rawtypes")
public class WorkCenter implements Comparable {

	public String workCenterID;
	public String wcCity;
	public String wcState;	
	
	public WorkCenter() {
		
	}
	public WorkCenter(String workCenterID, String city, String state) {
			this.workCenterID = workCenterID;
			this.wcCity = city;
			this.wcState = state;
	}
	public String getWorkCenterID() {
		return workCenterID;
	}
	public void setWorkCenterID(String workCenterID) {
		this.workCenterID = workCenterID;
	}
	public String getCity() {
		return wcCity;
	}
	public void setCity(String city) {
		this.wcCity = city;
	}
	public String getState() {
		return wcState;
	}
	public void setState(String state) {
		this.wcState = state;
	}
	public String toString() {
		return this.workCenterID + ", " + this.wcCity + ", " + this.wcState + ".";
	}
	
	public int compareTo(Object o) {
		WorkCenter other = (WorkCenter) o;
		
		//int center = this.workCenterID.compareTo(other.workCenterID);
		//return center == 0 ? this.workCenterID.compareTo(other.workCenterID) : center;
		return this.workCenterID.compareTo(other.getWorkCenterID());
	}
	
}
