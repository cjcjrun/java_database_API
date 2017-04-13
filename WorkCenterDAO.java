package edu.easternct.CSC342.sample;

//import java.math.BigDecimal;
//import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class WorkCenterDAO {

	public void createWorkCenter(WorkCenter workCenter) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		System.out.println("Work Center to be inserted \n");
		System.out.println(workCenter.toString());

		try {
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement("Insert into CSC342.Work_Center (Work_Center_ID, City, State) values(?,?,?)");
			ps.setString(1, workCenter.getWorkCenterID());
			ps.setString(2, workCenter.getCity());
			ps.setString(3, workCenter.getState());

			ps.executeUpdate();
			System.out.println("Work Center addition successful");
		} catch (SQLException e) {
			System.out.println("Error in creating a Work Center" + e.getSQLState());
			System.out.println("/nError Code: " + e.getErrorCode());
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} catch (Exception e) {
			System.out.println("Unknown Error in creating a Work Center");
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} finally {
			if (conn != null)
				System.out.println("Closing Work Center insert statement");
			ps.close();
		}
	}

	public void updateWorkCenter(WorkCenter wcUp) throws SQLException {
		System.out.println("Work Center to be updated \n");
		System.out.println(wcUp.toString());

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(
					"Update CSC342.Work_Center wc set wc.City = ?, wc.State = ?, " + "where wc.Work_Center_ID = ?");
			ps.setString(1, wcUp.getCity());
			ps.setString(2, wcUp.getState());
			ps.setString(3, wcUp.getWorkCenterID());

			ps.executeQuery();
			System.out.println("Updated Work Center");
		} catch (SQLException e) {
			System.out.println("Error in updating a Work Center" + e.getSQLState());
			System.out.println("/nError Code: " + e.getErrorCode());
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} catch (Exception e) {
			System.out.println("Unknown Error in updating a Work Center");
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} finally {
			if (conn != null)
				System.out.println("Closing Work Center update statement");
			ps.close();
		}
	}

	public void deleteWorkCenter(String workCenterID) throws SQLException {
		System.out.println("Work Center to be deleted\n");
		System.out.println("Work Center ID = " + workCenterID + "\n");

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement("Delete CSC342.Work_Center where Work_Center_ID = ?");
			ps.setString(1, workCenterID);
			ps.executeQuery();
			System.out.println("Work Center Deleted");
		} catch (SQLException e) {
			System.out.println("Error in deleting a Work Center" + e.getSQLState());
			System.out.println("/nError Code: " + e.getErrorCode());
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} catch (Exception e) {
			System.out.println("Unknown Error in deleting a Work Center");
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} finally {
			if (conn != null)
				System.out.println("Closing Work Center delete statement");
			ps.close();
		}
	}

	public void countWorkCenter() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBConnect.getConnection();
			ps = conn.prepareStatement(
					"SELECT wc.Work_Center_ID, count(*)" + "FROM CSC342.Work_Center wc, CSC342.Employee e"
							+ "WHERE wc.Work_CENTER_ID = e.Work_Center_ID" + "GROUP BY wc.Work_Center_ID");
			rs = ps.executeQuery();
			System.out.println("countWorkCenter success " + rs);
		} catch (SQLException e) {
			System.out.println("Error in counting the Employees in Work Center" + e.getSQLState());
			System.out.println("/nError Code: " + e.getErrorCode());
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} catch (Exception e) {
			System.out.println("Unknown Error in counting the Employees in Work Center");
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} finally {
			if (conn != null)
				System.out.println("Closing Work Center Employee count statement");
			rs.close();
			ps.close();
		}
	}

	public void checkWorkCenter(List<WorkCenter> centers) throws SQLException {

		Connection con = null;

		String sql1 = "Select count(*) as Work_Center_Count from CSC342.Work_Center wc WHERE wc.Work_Center_ID = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = DBConnect.getConnection();
			ps = con.prepareStatement(sql1);

			for (Iterator<WorkCenter> it = centers.iterator(); it.hasNext();) {
				WorkCenter testCenter = it.next();
				ps.setString(1, testCenter.getWorkCenterID());
				rs = ps.executeQuery();
				while (rs.next()) {
					if (rs.getInt(1) == 1)
						updateWorkCenter(testCenter);
					else if (rs.getInt(1) == 0)
						createWorkCenter(testCenter);
					else
						throw new RuntimeException("More than one Work Center has this ID");
				}
			}

		} catch (SQLException e) {
			System.out.println("Error in wcExists" + e.getSQLState());
			System.out.println("/nError Code: " + e.getErrorCode());
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} catch (Exception e) {
			System.out.println("unknown Error in wcExists");
			System.out.println("/nMessage: " + e.getMessage());
			System.exit(1);
		} finally {
			rs.close();
			ps.close();
		}

	}
}