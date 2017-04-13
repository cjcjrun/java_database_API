package edu.easternct.CSC342.sample;
import java.sql.*;
import java.util.*;

public class EmployeeTestDriver {
	
private ArrayList<Employee> employeeList;
	
	public void addEmployee(Timestamp t, String s, String w) {
		Employee myEmployee = new Employee();
		myEmployee.setEmployeeHiredDate(t);
		myEmployee.setEmployeeSupervisor(s);
		myEmployee.setWorkCenterId(w);
		employeeList.add(myEmployee);
	}

	public void addEmployee(Employee e) {
		employeeList.add(e);
	}

	public void viewEmployeeArrayList() {
		for (int x = 0; x < employeeList.size(); x++) {
			Employee e = employeeList.get(x);
			System.out.print(e.getEmployeeId() + ",");
			System.out.print(e.getEmployeeHiredDate() + ",");
			System.out.print(e.getEmployeeSupervisor() + ",");
			System.out.println(e.getWorkCenterId() + ",");
		}
	}

	public void employeeTestArray() {

		Timestamp tOne = makeTime(22, 10, 1979);
		String sOne = "Jack";
		String wOne = "100";

		Timestamp tTwo = makeTime(23, 11, 1980);
		String sTwo = "Jill";
		String wTwo = "99";

		Timestamp tThree = makeTime(24, 12, 1982);
		String sThree = "Harry";
		String wThree = "98";

		Timestamp tFour = makeTime(25, 13, 1985);
		String sFour = "Sally";
		String wFour = "97";

		Timestamp tFive = makeTime(26, 14, 1989);
		String sFive = "Martha";
		String wFive = "96";

		Timestamp tSix = makeTime(27, 15, 1994);
		String sSix = "Washington";
		String wSix = "95";

		this.addEmployee(tOne, sOne, wOne);
		this.addEmployee(tTwo, sTwo, wTwo);
		this.addEmployee(tThree, sThree, wThree);
		this.addEmployee(tFour, sFour, wFour);
		this.addEmployee(tFive, sFive, wFive);
		this.addEmployee(tSix, sSix, wSix);
		this.viewEmployeeArrayList();

		System.out.println(this.employeeList.get(5).compareTo(this.employeeList.get(1)));
		System.out.println(this.employeeList.get(0).compareTo(this.employeeList.get(0)));

	}

	static Timestamp makeTime(int m, int d, int y) {
		Calendar tempCalendar = GregorianCalendar.getInstance();
		tempCalendar.set(Calendar.DAY_OF_MONTH, m);
		tempCalendar.set(Calendar.MONTH, d);
		tempCalendar.set(Calendar.YEAR, y);
		Timestamp myTime = new Timestamp(tempCalendar.getTimeInMillis());
		return myTime;
	}

	public void setEmployeeList(ArrayList a) {
		this.employeeList = a;
	}

	public ArrayList getEmployeeList() {
		return this.employeeList;
	}
}