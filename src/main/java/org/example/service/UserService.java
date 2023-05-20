package org.example.service;

import org.example.db.ConnectMysqlExample;
import org.example.main.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserService {
    public static UserService instance;

    public UserService() {

    }

    private List<User> alluser;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public User login(String email, String pass) {

        {
            try {
                Connection conn = ConnectMysqlExample.getConnection(ConnectMysqlExample.getDbUrl(), ConnectMysqlExample.getUserName(), ConnectMysqlExample.getPASSWORD());
                PreparedStatement ps = conn.prepareStatement(
                        "SELECT user_id, email, pass, role FROM account WHERE email = ? and pass = ?");
                ps.setString(1, email);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getString(1));
                    user.setEmail(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    user.setRole(rs.getInt(4));
                    return user;
                }
                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
        return null;
    }


    public User getIF(String Uid) {
        User user = new User();
        {
            try {
                Connection conn = ConnectMysqlExample.getConnection(ConnectMysqlExample.getDbUrl(), ConnectMysqlExample.getUserName(), ConnectMysqlExample.getPASSWORD());
                PreparedStatement a = conn.prepareStatement(
                        "SELECT ID_USer, Age , USER_NAME ,Gioi_Tinh,HEIGHT,WEIGHT FROM User WHERE ID_USer = ?");
                a.setString(1,Uid);
                ResultSet rs = a.executeQuery();
                while (rs.next()) {
                    user.setId(rs.getString(1));
                    user.setAge(rs.getInt(2));
                    user.setUserName(rs.getString(3));
                    user.setGioiTinh(rs.getInt(4));
                    user.setHeight(rs.getInt(5));
                    user.setWeight(rs.getInt(6));
                }
                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
        return user;
    }
    public String  updateIF(String uid, String userName, String email, int height, int weight,int Age) {
        String rs="";
        try {
            Connection conn = ConnectMysqlExample.getConnection(ConnectMysqlExample.getDbUrl(), ConnectMysqlExample.getUserName(), ConnectMysqlExample.getPASSWORD());
            PreparedStatement stmt = conn.prepareStatement("UPDATE User SET USER_NAMES = ? , Height= ? , Weight =?, EMAIL = ?,Age=? WHERE ID_USER = ?");
            stmt.setString(1, userName);
            stmt.setInt(2, weight);
            stmt.setInt(3, height);
            stmt.setString(4, email);
            stmt.setInt(5, Age);
            stmt.setString(6, uid);
            stmt.execute();
            conn.close();
            rs="Chinh sua thanh cong";
        } catch (Exception e) {
            e.printStackTrace();
        }return rs;
    }

}
