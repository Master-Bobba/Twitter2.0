package com.example.XSS.util;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class Populator {

    private static String DB_URL = "jdbc:mysql://db:3306/Xss_db";
    private static String USER = "springuser";
    private static String PASSWORD = "springuser";

    @PostConstruct
    public void init(){
        System.out.println("RUNNING POPULATOR.INIT()");

        List<String> queries = new ArrayList<>();
        queries.add("CREATE TABLE IF NOT EXISTS POST(\n" +
                "    post_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    title VARCHAR (255) NOT NULL,\n" +
                "    user_name VARCHAR (255) NOT NULL,\n" +
                "    content VARCHAR (255) NOT NULL\n" +
                ");");
        queries.add("INSERT INTO POST(TITLE, USER_NAME, CONTENT)\n" +
                "VALUES\n" +
                "    ('AWS', 'Master_bobba', 'This actually works');");

        for (String sql : queries){
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();){
                stmt.executeUpdate(sql);

            }catch(SQLException ex){
                throw new RuntimeException(ex);
            }
        }


    }
}
