import java.sql.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

import java.math.*;

public class labupdate {
    static {
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        } catch (Exception e) {
            System.out.println("\n  Error loading DB2 Driver...\n");
            System.out.println(e);
            System.exit(1);
        }
    }

    public static void main(String args[]) throws Exception {
        String name = "";
        java.lang.String deptno = "";
        short id = 0;
        double salary = 0;
        String job = "";
        short NumEmp = 0;
        String sqlstmt = "UPDATE STAFF SET SALARY = SALARY * 1.05 WHERE DEPT = ?";
        String s = " ";
        int mydeptno = 0;
        int SQLCode = 0;
        String SQLState = "     ";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Connect statement follows:");
        Connection sample = DriverManager.getConnection("jdbc:db2:sample", "db2admin", "db2admin");
        System.out.println("Connect completed");
        sample.setAutoCommit(false);
        s = JOptionPane.showInputDialog(null, "Please enter a department number:", "Title",
                JOptionPane.QUESTION_MESSAGE);
        deptno = s.substring(0, 2);
        mydeptno = Integer.parseInt(deptno);
        System.out.println("Statement stmt follows");
        try {
            PreparedStatement pstmt = sample.prepareStatement(sqlstmt);
            pstmt.setInt(1, mydeptno);
            int updateCount = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Number of rows updated:" + updateCount, "title",
                    JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException x) {
            SQLCode = x.getErrorCode();
            SQLState = x.getSQLState();
            String Message = x.getMessage();
            System.out.println("\nSQLCODE:  " + SQLCode);
            System.out.println("\nSQLSTATE: " + SQLState);
            System.out.println("\nSQLERRM:  " + Message);
        }
        System.exit(0);
    }
}