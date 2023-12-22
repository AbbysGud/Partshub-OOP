package Controller;

import Connection.ConnectionManager;
import Models.CartModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerCart {
    private ConnectionManager conman;
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private int hasil = 0;
    
    public int saveCart(CartModel cart){
        conman = new ConnectionManager();
        con = conman.getConnection();        
        try {
            String query = "INSERT INTO cart(id_user,id_barang, nama_jenisbarang, harga_barang, jumlah, total) "
                    + "VALUES('"+cart.getId_user()+"', '"+cart.getId_barang()+"', '"+cart.getNama_jenisbarang()
                    +"', '"+cart.getHarga_barang()+"', '"+cart.getJumlah()+"', '"+cart.getTotal()+"')";
            stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }

    public List <CartModel> getAllCart(int id) {
        conman = new ConnectionManager();
        con = conman.getConnection();
        List<CartModel> listCart = new ArrayList<>();
        try {
            String query = "SELECT * FROM cart WHERE id_user = "+id;
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while(rs.next()){
                int id_user = rs.getInt("id_user");
                int id_barang = rs.getInt("id_barang");
                String nama_jenisbarang = rs.getString("nama_jenisbarang");
                int harga_barang = rs.getInt("harga_barang");
                int jumlah = rs.getInt("jumlah");
                int total = rs.getInt("total");
                CartModel cart = new CartModel(id_user, id_barang, nama_jenisbarang, harga_barang, jumlah, total);
                listCart.add(cart);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return listCart;
    }

    public CartModel getId(int id, int id_b){
       conman = new ConnectionManager(); 
       con = conman.getConnection();
       CartModel cart = null;
       try {
           String query = "SELECT * FROM cart WHERE id_user = "+id+" AND id_barang = "+id_b;
           stm = con.createStatement();
           rs = stm.executeQuery(query);
           if (rs.next()){
                int id_user = rs.getInt("id_user");
                int id_barang = rs.getInt("id_barang");
                String nama_jenisbarang = rs.getString("nama_jenisbarang");
                int harga_barang = rs.getInt("harga_barang");
                int jumlah = rs.getInt("jumlah");
                int total = rs.getInt("total");
                cart = new CartModel(id_user, id_barang, nama_jenisbarang, harga_barang, jumlah, total);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return cart;
    }
    
    public int deleteCart(int id, int id_b){
        conman = new ConnectionManager();
        con = conman.getConnection();
        try {
            String query = "DELETE FROM cart WHERE id_user = "+id+" AND id_barang = "+id_b;
            stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }
    
    public int tambahCart(CartModel cart, int jumlah, int total){
        conman = new ConnectionManager();
        con = conman.getConnection();
        try {
            String query = "UPDATE cart SET jumlah = '"+jumlah+"', total = '"+total+
                    "' WHERE id_user = "+cart.getId_user()+" AND id_barang = "+cart.getId_barang();
            stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }
}
