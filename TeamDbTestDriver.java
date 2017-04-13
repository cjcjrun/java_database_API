package edu.easternct.CSC342.sample;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class TeamDbTestDriver {
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private List<WorkCenter> centerList = new ArrayList<WorkCenter>();
	private ArrayList<Employee> employeeList;
	String hostname;
	String port;
	String sid;
	String id;
	String pwrd;

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String inHostname) {
		this.hostname = inHostname;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String inPort) {
		this.port = inPort;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String inSid) {
		this.sid = inSid;
	}

	public String getId() {
		return id;
	}

	public void setId(String inId) {
		this.id = inId;
	}

	public String getPwrd() {
		return pwrd;
	}

	public void setPwrd(String inPwrd) {
		this.pwrd = inPwrd;
	}

	public void workCenterTestCreate() throws SQLException, Exception {

		Connection conn;
		conn = DBConnect.getConnection(hostname, port, sid, id, pwrd);
		WorkCenterDAO workCenterDAO = new WorkCenterDAO();
		WorkCenter wcID = new WorkCenter();
		wcID.setWorkCenterID("EG");
		wcID.setCity("Portland");
		wcID.setState("Maine");
		centerList.add(wcID);
		// workCenterDAO.countWorkCenter();

		WorkCenter wcID1 = new WorkCenter();
		wcID1.setWorkCenterID("ZR");
		wcID1.setCity("Chicago");
		wcID1.setState("Illinois");
		centerList.add(wcID1);
		// workCenterDAO.countWorkCenter();

		WorkCenter wcID2 = new WorkCenter();
		wcID2.setWorkCenterID("DA");
		wcID2.setCity("Orlando");
		wcID2.setState("Florida");
		centerList.add(wcID2);

		System.out.println("TEST");
		workCenterDAO.checkWorkCenter(centerList);
		System.out.println("TEST");

	}

	@SuppressWarnings("unchecked")
	public void printWorkCenters() throws Exception {
		Collections.sort(centerList);
		Iterator<WorkCenter> iter = centerList.iterator();
		// int centerID = 0;
		while (iter.hasNext()) {
			// centerID++;
			WorkCenter stress = (WorkCenter) iter.next();
			System.out.println("WorkCenterID = " + stress.toString());
		}
	}

	public void addCustomer(BigDecimal d) {
		Customer cus = new Customer();
		cus.setCustomerId(d);
		customerList.add(cus);
	}

	public void testCustomer() throws SQLException, Exception {
		addCustomer(BigDecimal.valueOf(1));
		addCustomer(BigDecimal.valueOf(2));
		addCustomer(BigDecimal.valueOf(3));
		for (int x = 0; x < customerList.size(); x++) {
			System.out.println(customerList.get(x));
		}
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

	public static void main(String[] args) {
		TeamDbTestDriver testDriver = new TeamDbTestDriver();

		System.out.println("CUSTOMER");

		CustomerTestDriver t = new CustomerTestDriver();
		try {
			t.setHostname(args[0]);
			t.setPort(args[1]);
			t.setSid(args[2]);
			t.setId(args[3]);
			t.setPwrd(args[4]);
			t.testCustomer();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// TODO: customer_ID is primary key and cannot be set explicitly
		Customer cusOne = new Customer();
		cusOne.setCustomerId(BigDecimal.valueOf(1));
		CustomerDAO cusDao = new CustomerDAO();
		try {
			cusDao.createCustomer(cusOne);
			cusOne = cusDao.findCustomer(BigDecimal.valueOf(1));
			cusDao.deleteCustomer(cusOne);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			testDriver.setHostname(args[0]);
			testDriver.setPort(args[1]);
			testDriver.setSid(args[2]);
			testDriver.setId(args[3]);
			testDriver.setPwrd(args[4]);
			testDriver.workCenterTestCreate();
			testDriver.printWorkCenters();
		} catch (Exception ex) {
			System.out.println("Error in Work Center testing");
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			System.exit(1);
		}

		try {
			testDriver.setHostname(args[0]);
			testDriver.setPort(args[1]);
			testDriver.setSid(args[2]);
			testDriver.setId(args[3]);
			testDriver.setPwrd(args[4]);
			
			Employee myEmployee = new Employee();
			EmployeeDAO myEmpD = new EmployeeDAO();
			myEmployee.setEmployeeSupervisor("Dave");
			myEmployee.setWorkCenterId("Enfield");
			myEmpD.createEmployee(myEmployee);
			
		} catch (Exception ex) {
			System.out.println("Error in Employee testing");
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			System.exit(1);
		} 

	}

}