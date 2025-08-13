package JDBC_conn;

import java.sql.*;

/*
Question:
1. Create procedure or functions for employee table:
   1) Add 5000 bonus to all employees.
   2) Print same name employees.
   3) Print highest and lowest salary from employee table.
*/

public class Employee {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "798167";

        Connection con = DriverManager.getConnection(url, user, password);

       
        CallableStatement cs1 = con.prepareCall("{CALL addbonus()}");
        cs1.execute();
        System.out.println("Bonus added to all employees.\n");

        
        Statement st = con.createStatement();
        ResultSet rsAll = st.executeQuery("SELECT * FROM emp");
        System.out.println("Employee Table:\n");
        System.out.println("ID Name Salary");
        while (rsAll.next()) {
            System.out.println(rsAll.getInt("id") + "  " + rsAll.getString("name") + "  " + rsAll.getInt("salary"));
        }

        
        CallableStatement cs2 = con.prepareCall("{CALL getsameemp()}");
        ResultSet rs2 = cs2.executeQuery();
        System.out.println("\nSame Name Employees:\n");
        System.out.println("ID Name Salary");
        while (rs2.next()) {
            System.out.println(rs2.getInt("id") + "  " + rs2.getString("name") + "  " + rs2.getInt("salary"));
        }

        
        CallableStatement cs = con.prepareCall("{CALL gethighandlowsal()}");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            int maxSalary = rs.getInt("max_sal"); 
            int minSalary = rs.getInt("min_sal"); 
            System.out.println("\nMax Salary: " + maxSalary);
            System.out.println("Min Salary: " + minSalary);
        }

        con.close();
    }
}
