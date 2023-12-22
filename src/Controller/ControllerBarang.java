package Controller;

import Connection.ConnectionManager;
import Models.BarangModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerBarang {
    private ConnectionManager conman;
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private int hasil = 0;
    
    public int saveBarang(BarangModel barang){
        conman = new ConnectionManager();
        con = conman.getConnection();        
        try {
            String query = "INSERT INTO barang(id_barang, id_jenisbarang, nama_barang, merk_barang, harga_barang, stok_barang) "
                    + "VALUES('"+barang.getId_barang()+"', '"+barang.getId_jenisbarang()+"', '"+barang.getNama_barang()+"', '"
                    +barang.getMerk_barang()+"', '"+barang.getHarga_barang()+"', '"+barang.getStok_barang()+"')";
            stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }

    public List <BarangModel> getAllBarang() {
        conman = new ConnectionManager();
        con = conman.getConnection();
        List<BarangModel> listBarang = new ArrayList<>();
        try {
            String query = "SELECT * FROM barang";
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while(rs.next()){
                int id_barang = rs.getInt("id_barang");
                int id_jenisbarang = rs.getInt("id_jenisbarang");
                String nama_barang = rs.getString("nama_barang");
                String merk_barang = rs.getString("merk_barang");
                int harga_barang = rs.getInt("harga_barang");
                int stok_barang = rs.getInt("stok_barang");
                BarangModel Barang = new BarangModel(id_barang, id_jenisbarang, nama_barang, merk_barang, harga_barang, stok_barang);
                listBarang.add(Barang);          
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return listBarang;
    }
 
    public BarangModel getId(int id){
       conman = new ConnectionManager(); 
       con = conman.getConnection();
       BarangModel barang = null;
       try {
           String query = "SELECT * FROM barang WHERE id_barang = "+id;
           stm = con.createStatement();
           rs = stm.executeQuery(query);
           if (rs.next()){
                int id_barang = rs.getInt("id_barang");
                int id_jenisbarang = rs.getInt("id_jenisbarang");
                String nama_barang = rs.getString("nama_barang");
                String merk_barang = rs.getString("merk_barang");
                int harga_barang = rs.getInt("harga_barang");
                int stok_barang = rs.getInt("stok_barang");
                barang = new BarangModel(id_barang, id_jenisbarang, nama_barang, merk_barang, harga_barang, stok_barang);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return barang;
    }

    public  int updateBarang(BarangModel barang) {
        conman = new ConnectionManager();
        con = conman.getConnection();
        try {
            String query = "UPDATE barang SET id_jenisbarang = '"+barang.getId_jenisbarang()+"', nama_barang = '"
                    +barang.getNama_barang()+"', merk_barang = '"+barang.getMerk_barang()+"', harga_barang = '"
                    +barang.getHarga_barang()+"', stok_barang = '"+barang.getStok_barang()+"' WHERE id_barang = "+barang.getId_barang();
            stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }

    public int deleteBarang(int id){
        conman = new ConnectionManager();
        con = conman.getConnection();
        try {
            String query = "DELETE FROM barang WHERE id_barang = "+id;
            stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }
    
    public int kurangStock(BarangModel barang, int stok){
        conman = new ConnectionManager();
        con = conman.getConnection();
        try {
            String query = "UPDATE barang SET stok_barang = '"+stok+"' WHERE id_barang = "+barang.getId_barang();
            stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }
}
