package Controller;

import Connection.ConnectionManager;
import Models.TransaksiModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerTransaksi {
    private ConnectionManager conman;
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private int hasil = 0;
    
    public int saveTransaksi(TransaksiModel trns){
        conman = new ConnectionManager();
        con = conman.getConnection();        
        try {
            String query = "INSERT INTO transaksi(id_transaksi, id_user, id_barang, jumlah, total, waktu_transaksi) "
                    + "VALUES('"+trns.getId_transaksi()+"', '"+trns.getId_user()+"', '"+trns.getId_barang()
                    +"', '"+trns.getJumlah()+"', '"+trns.getTotal()+"', '"+trns.getWaktu()+"')";
            stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }

    public List <TransaksiModel> getTransaksi(int id) {
        conman = new ConnectionManager();
        List<TransaksiModel> listTransaksi = new ArrayList<>();
        con = conman.getConnection();
        try {
            String query = "SELECT * FROM transaksi WHERE id_user = "+id;
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while(rs.next()){
                int id_transaksi = rs.getInt("id_transaksi");
                int id_user = rs.getInt("id_user");
                int id_barang = rs.getInt("id_barang");
                int jumlah = rs.getInt("jumlah");
                int total = rs.getInt("total");
                Timestamp timestamp = rs.getTimestamp("waktu_transaksi");
                LocalDateTime waktu_transaksi = timestamp.toLocalDateTime();
                TransaksiModel trns = new TransaksiModel(id_transaksi, id_user, id_barang, jumlah, total, waktu_transaksi);
                listTransaksi.add(trns);         
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return listTransaksi;
    }
    
    public List <TransaksiModel> getAllTransaksi() {
        conman = new ConnectionManager();
        con = conman.getConnection();
        List<TransaksiModel> listTransaksi = new ArrayList<>();
        try {
            String query = "SELECT * FROM transaksi";
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            while(rs.next()){
                int id_transaksi = rs.getInt("id_transaksi");
                int id_user = rs.getInt("id_user");
                int id_barang = rs.getInt("id_barang");
                int jumlah = rs.getInt("jumlah");
                int total = rs.getInt("total");
                Timestamp timestamp = rs.getTimestamp("waktu_transaksi");
                LocalDateTime waktu_transaksi = timestamp.toLocalDateTime();
                TransaksiModel trns = new TransaksiModel(id_transaksi, id_user, id_barang, jumlah, total, waktu_transaksi);
                listTransaksi.add(trns);         
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return listTransaksi;
    }
}
