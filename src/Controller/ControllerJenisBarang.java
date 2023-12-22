package Controller;

import Connection.ConnectionManager;
import Models.JenisBarangModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerJenisBarang {
    private ConnectionManager conman;
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private int hasil = 0;
    
    public int saveJBarang(JenisBarangModel JBarang){
        conman = new ConnectionManager();
        con = conman.getConnection();        
        try {
            String query = "INSERT INTO jenis_barang(id_jenisbarang, nama_jenisbarang) "
                    + "VALUES('"+JBarang.getId_jenisbarang()+"', '"+JBarang.getNama_jenisbarang()+"')";
            stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerJenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }

    public List <JenisBarangModel> getAllJBarang() {
        conman = new ConnectionManager();
        con = conman.getConnection();
        List<JenisBarangModel> listJBarang = new ArrayList<>();
        try {
            String query = "SELECT * FROM jenis_barang";
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id_jenisbarang");
                String nama_jenisbarang = rs.getString("nama_jenisbarang");
                JenisBarangModel JBarang = new JenisBarangModel(id, nama_jenisbarang);
                listJBarang.add(JBarang);          
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerJenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return listJBarang;
    }
 
    public JenisBarangModel getId(int id){
       conman = new ConnectionManager(); 
       con = conman.getConnection();
       JenisBarangModel JBarang = null;
       try {
           String query = "SELECT * FROM jenis_barang WHERE id_jenisbarang = " + id;
           stm = con.createStatement();
           rs = stm.executeQuery(query);
           if (rs.next()){
                int id1 = rs.getInt("id_jenisbarang");
                String nama_jenisbarang = rs.getString("nama_jenisbarang");
                JBarang = new JenisBarangModel(id1, nama_jenisbarang);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerJenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return JBarang;
   }

    public  int updateJBarang(JenisBarangModel JBarang) {
        conman = new ConnectionManager();
        con = conman.getConnection();
        try {
            String query = "UPDATE jenis_barang SET nama_jenisbarang = '"+JBarang.getNama_jenisbarang()
                    +"' WHERE id_jenisbarang = "+JBarang.getId_jenisbarang();
            stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerJenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }

    public int deleteJBarang(int id){
        conman = new ConnectionManager();
        con = conman.getConnection();
        try {
            String query = "DELETE FROM jenis_barang WHERE id_jenisbarang = "+id;
            stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerJenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
   }
}
