package com.revature.dao;

import com.revature.config.ConnectionUtil;
import com.revature.model.Role;
import com.revature.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserRepository implements CrudRepository<User>{

    @Override
    public User save(User o) {
        return null;
    }

    @Override
    public Set<User> findAll() throws SQLException {
        ConnectionUtil util = ConnectionUtil.getInstance();
        Connection c = util.connect();

        Set<User> output = new HashSet<User>();
        String sql = "select * from app_user";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            User u = new User();
            u.setId(rs.getInt("user_id"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setFirstName(rs.getString("first_name"));
            u.setLastName(rs.getString("last_name"));

            output.add(u);
        }
        return output;
    }

    @Override
    public User findById(int id) throws SQLException {
        ConnectionUtil util = ConnectionUtil.getInstance();
        Connection c = util.connect();

        User output = null;
        String sql = "select * from app_user where user_id=?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            output = new User();
            output.setId(rs.getInt("user_id"));
            output.setUsername(rs.getString("username"));
            output.setPassword(rs.getString("password"));
            output.setFirstName(rs.getString("first_name"));
            output.setLastName(rs.getString("last_name"));


        }
        return output;

    }

    @Override
    public boolean update(User o) throws SQLException {
        ConnectionUtil util = ConnectionUtil.getInstance();
        Connection c = util.connect();



        String sql = "update app_user set username=?,password=?,first_name=?,last_name=?  where user_id=?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1,o.getUsername());
        ps.setString(2,o.getPassword());
        ps.setString(3,o.getFirstName());
        ps.setString(4,o.getLastName());
        ps.setInt(5,o.getId());
        int check=-1;
        check = ps.executeUpdate();
        if(check==-1){
            return false;
        }
        return true;

    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        ConnectionUtil util = ConnectionUtil.getInstance();
        Connection c = util.connect();


        String sql = "delete from app_user where user_id=id";
        PreparedStatement ps = c.prepareStatement(sql);
        int check=-1;
        check = ps.executeUpdate();
        if(check==-1){
            return false;
        }
        return true;
    }
}