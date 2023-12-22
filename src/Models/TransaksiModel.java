package Models;

import java.time.LocalDateTime;

public class TransaksiModel {
    int id_transaksi, id_user, id_barang, jumlah, total;
    LocalDateTime waktu;
    
    public TransaksiModel(){
    }

    public TransaksiModel(int id_transaksi, int id_user, int id_barang, int jumlah, int total, LocalDateTime waktu) {
        this.id_transaksi = id_transaksi;
        this.id_user = id_user;
        this.id_barang = id_barang;
        this.jumlah = jumlah;
        this.total = total;
        this.waktu = waktu;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_barang() {
        return id_barang;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public LocalDateTime getWaktu() {
        return waktu;
    }

    public void setWaktu(LocalDateTime waktu) {
        this.waktu = waktu;
    }
    
    
}
