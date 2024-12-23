package com.example.wcd_t2305m.database;

import java.sql.*;

public class Database {
    private  final String connectionString ="jdbc:mysql://localhost:3306/wcd_t2305m";
    private final String user = "root";
    private final String password ="";

    private final String driver = "com.mysql.cj.jdbc.Driver";

    private static Database _instance;

    private Connection conn;

    private Database(){
        try{

            Class.forName(driver);
            conn = DriverManager.getConnection(connectionString,user,password);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Database createInstance(){
        if(_instance == null)
            _instance = new Database();
        return _instance;
    }

    public Statement getStatement() throws SQLException {
        return conn.createStatement();
    }

    public PreparedStatement getpreparedStatement(String sql) throws SQLException{

        return conn.prepareStatement(sql);
    }
}
