package com.db_test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    private String ip = "localhost";
    private String port = "3306";
    private String dbname = "test_db";
    private String username = "root";
    private String password = "";

    protected Connection get_Db_Connection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+ ip +":"+ port +"/"+ dbname ,username,password);
            System.out.println("Successful Connection");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
    public static void main(String[] args) {
        Main m = new Main();
        Connection con = m.get_Db_Connection();
        try {
            if(con != null) {
                con.close();
                System.out.println("Connection is closed");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}