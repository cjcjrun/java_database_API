package edu.easternct.CSC342.sample;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

	public void createEmployee(Employee employee) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		System.out.print("\nEmployee to be Inserted: \n");
		System.out.println(employee.toString());

		try {

			con = DBConnect.getConnection();
			ps = con.prepareStatement("insert into CSC342.employee (EMPLOYEE_HIRED_DATE,"
					+ " EMPLOYEE_SUPERVISOR, WORK_CENTER_ID) values(?,?,?)");
			ps.setTimestamp(1, employee.getEmployeeHiredDate());
			ps.setString(2, employee.getEmployeeSupervisor());
			ps.setString(3, employee.getWorkCenterId());

			ps.executeUpdate();
			System.out.println("Addition Success");

		} catch (SQLException e) {
			System.out.println("Error in Create Employee" + e.getSQLState());
			System.out.println("/nError Code: " + e.getErrorCode());
			System.out.println("/nMessage: " + e.getMessage());

			System.exit(1);
		} catch (Exception e) {
			System.out.println("unknown Error in Create Employee");
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} finally {
			if (con != null)
				System.out.println("closing Ecreate statement");
			ps.close();

		}

	}

	public Employee findEmployee(BigDecimal employeeId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		Employee outEmployee = new Employee();
		ResultSet rs = null;

		try {

			con = DBConnect.getConnection();
			ps = con.prepareStatement("select EMPLOYEE_ID from CSC342.EMPLOYEE where EMPLOYEE_ID= ?");
			ps.setBigDecimal(1, employeeId);
			rs = ps.executeQuery();
			rs.next();
			outEmployee.setEmployeeId(rs.getBigDecimal(1));
			System.out.println("Find Employee success");

		} catch (SQLException e) {
			System.out.println("Error in find Employee" + e.getSQLState());
			System.out.println("/nError Code: " + e.getErrorCode());
			System.out.println("/nMessage: " + e.getMessage());

			System.exit(1);
		} catch (Exception e) {
			System.out.println("unknown Error in find Employee");
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} finally {
			if (con != null)
				System.out.println("closing Employee create statement");
			ps.close();

		}
		return outEmployee;
	}

	public void updateEmployee(Employee employee) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		System.out.println("Employee to be updated");
		System.out.println(employee.toString());

		try {

			con = DBConnect.getConnection();
			ps = con.prepareStatement("update CSC342.EMPLOYEE set (EMPLOYEE_HIRED_DATE,"
					+ " EMPLOYEE_SUPERVISOR, WORK_CENTER_ID) values(?,?,?)");
			ps.setTimestamp(1, employee.getEmployeeHiredDate());
			ps.setString(2, employee.getEmployeeSupervisor());
			ps.setString(3, employee.getWorkCenterId());
			ps.executeUpdate();
			System.out.println("Update Success");

		} catch (SQLException e) {
			System.out.println("Error in Update Employee" + e.getSQLState());
			System.out.println("/nError Code: " + e.getErrorCode());
			System.out.println("/nMessage: " + e.getMessage());

			System.exit(1);
		} catch (Exception e) {
			System.out.println("unknown Error in Update Employee");
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} finally {
			if (con != null)
				System.out.println("closing Employee update statement \n");
			ps.close();

		}

	}

	public void deleteEmployee(Employee employee) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		System.out.println("Employee to be Deleted \n");
		System.out.println(employee.toString());

		try {

			con = DBConnect.getConnection();
			ps = con.prepareStatement("delete CSC342.Employee where employee_id = ?");
			ps.setBigDecimal(1, employee.getEmployeeId());

			ps.executeUpdate();
			System.out.println("Delete Success");

		} catch (SQLException e) {
			System.out.println("Error in Delete Employee" + e.getSQLState());
			System.out.println("/nError Code: " + e.getErrorCode());
			System.out.println("/nMessage: " + e.getMessage());

			System.exit(1);
		} catch (Exception e) {
			System.out.println("unknown Error in Delete Employee");
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} finally {
			if (con != null)
				System.out.println("closing Employee Delete statement \n");
			ps.close();
		}
	}
}
