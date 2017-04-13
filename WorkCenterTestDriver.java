package edu.easternct.CSC342.sample;

import java.sql.*;
import java.util.*;

public class WorkCenterTestDriver {

	List<WorkCenter> centerList = new ArrayList<WorkCenter>();
	String hostname;
	String port;
	String sid;
	String id;
	String pwrd;
	
	
	/*public WorkCenterTestDriver() {
		
	}*/	
	
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

	public void testCreate() throws SQLException, Exception {
		
		Connection conn;
		
		
		conn = DBConnect.getConnection(hostname, port, sid, id ,pwrd);
		WorkCenterDAO workCenterDAO = new WorkCenterDAO();
		WorkCenter wcID = new WorkCenter();		
		wcID.setWorkCenterID("EG");
		wcID.setCity("Portland");
		wcID.setState("Maine");
		centerList.add(wcID);
		//workCenterDAO.countWorkCenter();
		
		WorkCenter wcID1 = new WorkCenter();
		wcID1.setWorkCenterID("ZR");		
		wcID1.setCity("Chicago");
		wcID1.setState("Illinois");
		centerList.add(wcID1);
		//workCenterDAO.countWorkCenter();
		
		WorkCenter wcID2 = new WorkCenter();
		wcID2.setWorkCenterID("DA");
		wcID2.setCity("Orlando");
		wcID2.setState("Florida");		
		centerList.add(wcID2);		
		
		workCenterDAO.checkWorkCenter(centerList);
		//conn.commit();
	}
	
	@SuppressWarnings("unchecked")
	public void printWorkCenters() throws Exception{
		Collections.sort(centerList);
		Iterator<WorkCenter> iter = centerList.iterator();
		//int centerID = 0;
		while (iter.hasNext())
		{			
			//centerID++;
			WorkCenter stress = (WorkCenter) iter.next();
			System.out.println("WorkCenterID = " + stress.toString());
		}
	}
	
	public static void main(String[] args) 
	{
		
		WorkCenterTestDriver testWC = new WorkCenterTestDriver();
		
	try
	{	
		
		testWC.setHostname(args[0]);
		testWC.setPort(args[1]);
		testWC.setSid(args[2]);	
		testWC.setId(args[3]);
		testWC.setPwrd(args[4]);
		
		testWC.testCreate();		
		testWC.printWorkCenters();
	}
	catch (Exception ex)
	{
		System.out.println("Error in testing");
		System.out.println(ex.getMessage());
		ex.printStackTrace();
		System.exit(1);
		
	}	
		
	}
	
}