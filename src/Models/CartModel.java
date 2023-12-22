package Models;

public class CartModel {
    int id_user, id_barang, harga_barang, jumlah, total;
    String nama_jenisbarang;
    
    public CartModel(){
    }

    public CartModel(int id_user, int id_barang, String nama_jenisbarang, int harga_barang, int jumlah, int total) {
        this.id_user = id_user;
        this.id_barang = id_barang;
        this.nama_jenisbarang = nama_jenisbarang;
        this.harga_barang = harga_barang;
        this.jumlah = jumlah;
        this.total = total;
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

    public int getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(int harga_barang) {
        this.harga_barang = harga_barang;
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

    public String getNama_jenisbarang() {
        return nama_jenisbarang;
    }

    public void setNama_jenisbarang(String nama_jenisbarang) {
        this.nama_jenisbarang = nama_jenisbarang;
    }
    
    
}
