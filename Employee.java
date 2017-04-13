package edu.easternct.CSC342.sample;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Employee {
	private BigDecimal employeeId;
	private Timestamp employeeHiredDate;
	private String employeeSupervisor;
	private String workCenterId;

	public Employee() {
	}

	public Employee(BigDecimal employeeId, Timestamp employeeHiredDate, String employeeSupervisor,
			String workCenterId) {
		this.employeeId = employeeId;
		this.employeeHiredDate = employeeHiredDate;
		this.employeeSupervisor = employeeSupervisor;
		this.workCenterId = workCenterId;
	}

	public BigDecimal getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(BigDecimal employeeId) {
		this.employeeId = employeeId;
	}

	public Timestamp getEmployeeHiredDate() {
		return employeeHiredDate;
	}

	public void setEmployeeHiredDate(Timestamp employeeHiredDate) {
		this.employeeHiredDate = employeeHiredDate;
	}

	public String getEmployeeSupervisor() {
		return employeeSupervisor;
	}

	public void setEmployeeSupervisor(String employeeSupervisor) {
		this.employeeSupervisor = employeeSupervisor;
	}

	public String getWorkCenterId() {
		return workCenterId;
	}

	public void setWorkCenterId(String workCenterId) {
		this.workCenterId = workCenterId;
	}

	public int compareTo(Employee employee) {
		if (this.employeeId.compareTo(employee.getEmployeeId()) == 0) {
			if (this.employeeHiredDate.compareTo(employee.getEmployeeHiredDate()) == 0) {
				return 0;
			} else {
				return this.employeeHiredDate.compareTo(employee.getEmployeeHiredDate());
			}
		} else {
			return this.employeeId.compareTo(employee.getEmployeeId());
		}
	}

	@Override
	public String toString() {
		return employeeId + "," + employeeHiredDate + "," + employeeSupervisor + "," + workCenterId;
	}
}
