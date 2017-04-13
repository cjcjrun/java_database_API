 import java.math.BigDecimal;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;

public class CustomerDAO {

    public void createCustomer(Customer customer) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        System.out.println("Customer to be Inserted \n");
        System.out.println(customer.toString());

        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement("insert into CSC342.customer (Customer_id) values(?)");
            ps.setBigDecimal(1, customer.getCustomerId());

            ps.executeUpdate();
            System.out.println("Addition Success");

        } catch (SQLException e) {
            System.out.println("Error in Create Customer" + e.getSQLState());
            System.out.println("/nError Code: " + e.getErrorCode());
            System.out.println("/nMessage: " + e.getMessage());

            System.exit(1);
        } catch (Exception e) {
            System.out.println("unknown Error in Create Customer");
            System.out.println("/nMessage: " + e.getMessage());
            System.exit(1);
        } finally {
            if (con != null)
                System.out.println("closing Customer create statement");
            ps.close();

        }

    }

    public Customer findCustomer(BigDecimal customerId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        Customer outCustomer = new Customer();
        ResultSet rs = null;

        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement("select Customer_id from CSC342.customer where Customer_id = ?");
            ps.setBigDecimal(1, customerId);
            rs = ps.executeQuery();
            rs.next();
            outCustomer.setCustomerId(rs.getBigDecimal(1));
            System.out.println("Find customer success");

        } catch (SQLException e) {
            System.out.println("Error in find Customer" + e.getSQLState());
            System.out.println("/nError Code: " + e.getErrorCode());
            System.out.println("/nMessage: " + e.getMessage());

            System.exit(1);
        } catch (Exception e) {
            System.out.println("unknown Error in find Customer");
            System.out.println("/nMessage: " + e.getMessage());
            System.exit(1);
        } finally {
            if (con != null)
                System.out.println("closing Customer create statement");
            ps.close();

        }
        return outCustomer;
    }

    public void deleteCustomer(Customer customer) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        System.out.println("Customer to be Deleted \n");
        System.out.println(customer.toString());

        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement("delete CSC342.customer where customer_id = ?");
            ps.setBigDecimal(1, customer.getCustomerId());

            ps.executeUpdate();
            System.out.println("Delete Success");

        } catch (SQLException e) {
            System.out.println("Error in Delete Customer" + e.getSQLState());
            System.out.println("/nError Code: " + e.getErrorCode());
            System.out.println("/nMessage: " + e.getMessage());

            System.exit(1);
        } catch (Exception e) {
            System.out.println("unknown Error in Delete Customer");
            System.out.println("/nMessage: " + e.getMessage());
            System.exit(1);
        } finally {
            if (con != null)
                System.out.println("closing Customer Delete statement \n");
            ps.close();

        }

    }
}
