package Controller;

import Connection.ConnectionManager;
import Models.UserModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerUser {
    private ConnectionManager conman;
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private int hasil = 0;
    
    public int saveUser(UserModel user){
        conman = new ConnectionManager();
        con = conman.getConnection();        
        try {
            String query = "INSERT INTO user(id, username, full_name, address, phone_number, password) "
                    + "VALUES('"+user.getId()+"', '"+user.getUsername()+"', '"+user.getFull_name()+"', '"
                    +user.getAddress()+"', '"+user.getPhone_number()+"', '"+user.getPassword()+"')";
            String sama = "SELECT * FROM user WHERE username = '"+user.getUsername()+"'";
            stm = con.createStatement();
            rs = stm.executeQuery(sama);
            if(rs.next() == true){
                hasil = -1;
            }else{
                hasil = stm.executeUpdate(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }

    public List <UserModel> getAllUser() {
        conman = new ConnectionManager();
        con = conman.getConnection();
        List<UserModel> listUser = new ArrayList<>();
        try {
            String query = "SELECT * FROM user";
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String full_name = rs.getString("full_name");
                String address = rs.getString("address");
                String phone_number = rs.getString("phone_number");
                String password = rs.getString("password");
                UserModel user = new UserModel(id, username, full_name, address, phone_number, password);
                listUser.add(user);       
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return listUser;
    }
 
    public UserModel getId(int id){
       conman = new ConnectionManager(); 
       con = conman.getConnection();
       UserModel user = null;
       try {
           String query = "SELECT * FROM user WHERE id = " + id;
           stm = con.createStatement();
           rs = stm.executeQuery(query);
           if (rs.next()){
                int id1 = rs.getInt("id");
                String username = rs.getString("username");
                String full_name = rs.getString("full_name");
                String address = rs.getString("address");
                String phone_number = rs.getString("phone_number");
                String password = rs.getString("password");
                user = new UserModel(id1,username,full_name,address,phone_number,password);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return user;
   }

    public  int updateUser(UserModel user) {
        conman = new ConnectionManager();
        con = conman.getConnection();
        try {
            String query = "UPDATE user SET username = '"+user.getUsername()+"', full_name = '"
                    +user.getFull_name()+"', address = '"+user.getAddress()+"', phone_number = '"
                    +user.getPhone_number()+"', password = '"+user.getPassword()+"' WHERE id = "+user.getId();
            String sama = "SELECT * FROM user WHERE username = '"+user.getUsername()+"'";
            String cek = "SELECT * FROM user WHERE id = '"+user.getId()+"'";
            stm = con.createStatement();
            rs = stm.executeQuery(sama);
            if (rs.next() == true) {
                ResultSet r = stm.executeQuery(cek);
                if (r.next()) {
                    if (!(r.getString("username")).equals(user.getUsername())) {  
                        hasil=-1;
                    } else {
                        hasil = stm.executeUpdate(query);
                    } 
                } 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }

    public int deleteUser(int id){
        conman = new ConnectionManager();
        con = conman.getConnection();
        try {
            String query = "DELETE FROM user WHERE id = "+id;
            stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
   }
    
    public int Login(UserModel user) {
        conman = new ConnectionManager();
        con = conman.getConnection();
        try {
            String query = "SELECT * FROM user WHERE username = '" + user.getUsername() + "'";
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                if (!rs.getString("password").equals(user.getPassword())) {
                    hasil = -1;
                } else if (rs.getString("password").equals(user.getPassword())) {
                    user.setId(rs.getInt("id"));
                    user.setFull_name(rs.getString("full_name"));
                    user.setAddress(rs.getString("address"));
                    user.setPhone_number(rs.getString("phone_number"));
                    user.setPassword(rs.getString("password"));
                    hasil = 1;                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }
}
