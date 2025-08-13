package JDBC_conn;

/*
Question:
2. Create procedure or functions for Hospital table:
   1) Print avg patient count on daily basis.
   2) Print all the patients whose belong to same ward.
   3) Arrange the patients list according their admission date.
*/

import java.sql.*;

public class Hospital {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "798167";

        Connection con = DriverManager.getConnection(url, user, password);

        CallableStatement cs1 = con.prepareCall("{CALL avgpatientcount()}");
        ResultSet rs1 = cs1.executeQuery();
        System.out.println("Average Patient Count Per Day:");
        while (rs1.next()) {
            System.out.println(rs1.getDate("admitted_date") + "  " + rs1.getInt("patient_count"));
        }
        
        CallableStatement cs2 = con.prepareCall("{CALL samewardpatients()}");
        ResultSet rs2 = cs2.executeQuery();
        System.out.println("\nPatients in Same Ward:");
        while (rs2.next()) {
            System.out.println(rs2.getInt("id") + "  " + rs2.getString("name") + "  " + rs2.getString("ward"));
        }

       
        CallableStatement cs3 = con.prepareCall("{CALL getpatients()}");
        ResultSet rs3 = cs3.executeQuery();
        System.out.println("\nPatients Ordered by Admitted Date:");
        while (rs3.next()) {
            System.out.println(rs3.getInt("id") + "  " + rs3.getString("name") + "  " + rs3.getDate("admitted_date"));
        }

        con.close();
    }
}
