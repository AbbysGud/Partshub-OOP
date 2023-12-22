package Models;

public class JenisBarangModel {
    private int id_jenisbarang;
    private String nama_jenisbarang;
    
    public JenisBarangModel(){
    }

    public JenisBarangModel(int id_jenisbarang, String nama_jenisbarang) {
        this.id_jenisbarang = id_jenisbarang;
        this.nama_jenisbarang = nama_jenisbarang;
    }

    public int getId_jenisbarang() {
        return id_jenisbarang;
    }

    public void setId_jenisbarang(int id_jenisbarang) {
        this.id_jenisbarang = id_jenisbarang;
    }

    public String getNama_jenisbarang() {
        return nama_jenisbarang;
    }

    public void setNama_jenisbarang(String nama_jenisbarang) {
        this.nama_jenisbarang = nama_jenisbarang;
    }
    
    
}
