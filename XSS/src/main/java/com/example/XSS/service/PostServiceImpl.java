package com.example.XSS.service;

import com.example.XSS.XssApplication;
import com.example.XSS.model.Post;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private static String DB_URL = "jdbc:mysql://51.20.128.84:3306/Xss_db";
    private static String USER = "springuser";
    private static String PASSWORD = "springuser";

    @Override
    public List<Post> findAll() {

        String sql = "SELECT * FROM POST";
        List<Post> posts = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);){

            while(rs.next()){

                int post_id = rs.getInt("post_id");
                String title = rs.getString("title");
                String user_name = rs.getString("user_name");
                String content = rs.getString("content");

                System.out.println(post_id + title + user_name + content);

                posts.add(new Post(post_id, title, user_name, content));

            }

        } catch (SQLException exception){
            throw new RuntimeException(exception);
        }

        return posts;
    }

    @Override
    public void save(Post post) {
//        String user_name = "Hackerman";
//        String title = "Hacked";
//        String content = ")'<script> alert(1) </script><p>(";

        String sql = "INSERT INTO POST(title, user_name, content)" +
                    "VALUES('%s','%s', '%s')".formatted(post.getTitle(),post.getUserName(),post.getContent());

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();){
            stmt.executeUpdate(sql);

        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }

    }
}
