package Models;

public class BarangModel {
    int id_barang, id_jenisbarang, harga_barang, stok_barang;
    String nama_barang, merk_barang;

    public BarangModel(){
    }
    
    public BarangModel(int id_barang, int id_jenisbarang, String nama_barang, String merk_barang, int harga_barang, int stok_barang) {
        this.id_barang = id_barang;
        this.id_jenisbarang = id_jenisbarang;
        this.nama_barang = nama_barang;
        this.merk_barang = merk_barang;
        this.harga_barang = harga_barang;
        this.stok_barang = stok_barang;
    }

    public int getId_barang() {
        return id_barang;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
    }

    public int getId_jenisbarang() {
        return id_jenisbarang;
    }

    public void setId_jenisbarang(int id_jenisbarang) {
        this.id_jenisbarang = id_jenisbarang;
    }

    public int getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(int harga_barang) {
        this.harga_barang = harga_barang;
    }

    public int getStok_barang() {
        return stok_barang;
    }

    public void setStok_barang(int stok_barang) {
        this.stok_barang = stok_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getMerk_barang() {
        return merk_barang;
    }

    public void setMerk_barang(String merk_barang) {
        this.merk_barang = merk_barang;
    }
    
    
}
