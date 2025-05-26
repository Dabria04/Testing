package com.db_test;
import de.vandermeer.asciitable.AsciiTable;

import java.sql.*;
import java.util.ArrayList;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private String ip = "db";
    private String port = "3306";
    private String dbname = "test_db";
    private String username = "root";
    private String password = "root";

    private Connection db_connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        int attempt = 1;

        while(true) {
            try {
                Thread.sleep(5000);
                con = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + dbname +
                        "?useSSL=false&allowPublicKeyRetrieval=true", username, password);
                System.out.println("Successful connected.");
                break;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Fail to connect, attempt = " + attempt);
                attempt++;
            }
        }

        return con;
    }

    private ArrayList<Office> report1(Connection conn){
        ArrayList<Office> al = new ArrayList<>();
        try {
            PreparedStatement stmt =conn.prepareStatement("SELECT officeCode, state, city FROM offices"); //Database ko sql language a pyit poe pay
            ResultSet rs =  stmt.executeQuery();
            while (rs.next()){
                Office of = new Office(rs.getInt(1), rs.getString(2) != null ? rs.getString(2) : "N/A",rs.getString(3));
                al.add(of);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  al;
    }
    private void display_report1(ArrayList<Office> al){
        AsciiTable at = new AsciiTable();
        System.out.println("Office Report");
        at.addRule();
        at.addRow(new Object[]{"No.","Office Code", "State", "City"});
        at.addRule();
        int no = 1;
        for (Office of :al){
            at.addRow(new Object[]{no,of.getOfficeCode(),of.getState(),of.getCity()});
            no++;
        }
        at.addRule();
        System.out.println(at.render());
    }

    public static void main(String[] args) {
        Main main = new Main();
        Connection con = main.db_connect();
        ArrayList<Office> al = main.report1(con);
        main.display_report1(al);
        try {
            if (con != null)
                con.close();
            System.out.println("Connection closed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}