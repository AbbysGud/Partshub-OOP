package View;

import Models.JenisBarangModel;
import Models.BarangModel;
import Models.UserModel;
import Models.TransaksiModel;

import Controller.ControllerJenisBarang;
import Controller.ControllerBarang;
import Controller.ControllerUser;
import Controller.ControllerTransaksi;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.*;

public class AdminPage extends javax.swing.JFrame {
    private final Color ijoOri = new Color(0, 102, 102);
    
    private final ControllerJenisBarang conJBarang = new ControllerJenisBarang();
    private final ControllerBarang conBar = new ControllerBarang();
    private final ControllerUser conUser = new ControllerUser();
    private final ControllerTransaksi conTrans = new ControllerTransaksi();
    
    private JenisBarangModel jbrED = null;
    private BarangModel brED = null;
    private UserModel user = null;
    
    private int hasil = 0;
    
    public AdminPage() {
        initComponents();
        visual("home");
        panelHome();
    }

    public void visual(String panel) {
        panelBarang.setVisible(false);
        panelJenisBarang.setVisible(false);
        panelUser.setVisible(false);
        panelHome.setVisible(false);
        panelTransaksi.setVisible(false);
        lblBarang.setForeground(ijoOri);
        lblJenisBarang.setForeground(ijoOri);
        lblUser.setForeground(ijoOri);
        lblHome.setForeground(ijoOri);       
        lblTransaksi.setForeground(ijoOri);
        switch (panel) {
            case "home":
                panelHome.setVisible(true);
                lblHome.setForeground(Color.white);
                break;
            case "barang":
                panelBarang.setVisible(true);
                lblBarang.setForeground(Color.white);
                break;
            case "jenisbarang":
                panelJenisBarang.setVisible(true);   
                lblJenisBarang.setForeground(Color.white);
                break;
            case "user":
                panelUser.setVisible(true);
                lblUser.setForeground(Color.white);
                break;
            case "transaksi":
                panelTransaksi.setVisible(true);
                lblTransaksi.setForeground(Color.white);
                break;
            default:
                break;
        }
    }
    
    private void header_tabel(JTable nama_tabel){
        DefaultTableCellRenderer head_render = new DefaultTableCellRenderer(); 

        Font font = new Font("SansSerif", Font.PLAIN, 24);
        head_render.setBackground(ijoOri);
        head_render.setForeground(Color.white);
        head_render.setFont(font);
        nama_tabel.getTableHeader().setDefaultRenderer(head_render);
    }
    
    private void loadJBarang(){
        List <JenisBarangModel> list = conJBarang.getAllJBarang();
        Object[][] obJBarang = new Object[list.size()][4];
        int i =0 ;
        for (JenisBarangModel jBarang : list) {
            obJBarang[i][0] = jBarang.getId_jenisbarang();
            obJBarang[i][1] = jBarang.getNama_jenisbarang();
            i++;
        }

        tabelJBarang.setModel(new javax.swing.table.DefaultTableModel(obJBarang, new  String[] {"ID", "Category Name"}));
        tabelJBarang.setDefaultEditor(Object.class, null);
        header_tabel(tabelJBarang);
    }
    
    private void loadBarang(){
        List <BarangModel> list = conBar.getAllBarang();
        Object[][] obBarang = new Object[list.size()][6];
        
        int i =0 ;
        for (BarangModel barang : list) {
            obBarang[i][0] = barang.getId_barang();
            JenisBarangModel jenisB = conJBarang.getId(barang.getId_jenisbarang());
            obBarang[i][1] = jenisB.getNama_jenisbarang();
            obBarang[i][2] = barang.getNama_barang();
            obBarang[i][3] = barang.getMerk_barang();
            obBarang[i][4] = barang.getHarga_barang();
            obBarang[i][5] = barang.getStok_barang();
            i++;
        }

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(obBarang, new  String[] {"Product_ID", "Category", "Name", "Brand", "Price", "Stock"}));
        tabelBarang.setDefaultEditor(Object.class, null);
        header_tabel(tabelBarang);
    }
    
    private void loadUser(){
        List <UserModel> list = conUser.getAllUser();
        Object[][] obUser = new Object[list.size()][4];
        
        int i =0 ;
        for (UserModel usr : list) {
            obUser[i][0] = usr.getId();
            obUser[i][1] = usr.getFull_name();
            obUser[i][2] = usr.getAddress();
            obUser[i][3] = usr.getPhone_number();
            i++;
        }

        tabelUser.setModel(new javax.swing.table.DefaultTableModel(obUser, new  String[] {"User ID", "Full Name", "Address", "Phone Number"}));
        tabelUser.setDefaultEditor(Object.class, null);
        header_tabel(tabelUser);   
    }
    
    private void loadTransaksi(){
        List <TransaksiModel> list = conTrans.getAllTransaksi();
        Object[][] obTrans = new Object[list.size()][6];
        
        int i =0 ;
        for (TransaksiModel trns : list) {
            obTrans[i][0] = trns.getId_transaksi();
            UserModel usr = conUser.getId(trns.getId_user());
            obTrans[i][1] = usr.getFull_name();
            BarangModel brg = conBar.getId(trns.getId_barang());
            obTrans[i][2] = brg.getNama_barang();
            obTrans[i][3] = trns.getJumlah();
            obTrans[i][4] = trns.getTotal();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = trns.getWaktu().format(formatter);
            obTrans[i][5] = formattedDateTime;
            i++;
        }

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(obTrans, new  String[] {"Transaction ID", "Buyer Name", "Product Name", "P_Quantity", "Total", "Transaction Time"}));
        tabelTransaksi.setDefaultEditor(Object.class, null);
        header_tabel(tabelTransaksi);
    }
    
    private void panelJBarang(String status){
        panelJBarang_biasa.setVisible(false);
        panelJBarang_tambah.setVisible(false);
        panelJBarang_edit.setVisible(false);
        switch(status){
            case "biasa":
                panelJBarang_biasa.setVisible(true);
                break;
            case "tambah":
                panelJBarang_tambah.setVisible(true);
                break;
            case "edit":
                panelJBarang_edit.setVisible(true);
                break;
            default:
                break;       
        }
    }
    
    private void panelBarang(String status){
        panelBarang_biasa.setVisible(false);
        panelBarang_tambah.setVisible(false);
        panelBarang_edit.setVisible(false);
        switch(status){
            case "biasa":
                panelBarang_biasa.setVisible(true);
                break;
            case "tambah":
                panelBarang_tambah.setVisible(true);
                break;
            case "edit":
                panelBarang_edit.setVisible(true);
                break;
            default:
                break;       
        }
    }
    
    private void panelHome(){
        List <BarangModel> listBarang = conBar.getAllBarang();
        List <JenisBarangModel> listJB = conJBarang.getAllJBarang();
        List <UserModel> listUser = conUser.getAllUser();
        List <TransaksiModel> listTrans = conTrans.getAllTransaksi();
        int jBar = listBarang.size();
        int jJBar = listJB.size();
        int jUser = listUser.size();
        int jTrns = listTrans.size();
        lblJUser.setText(String.valueOf(jUser));
        lblJCategory.setText(String.valueOf(jJBar));
        lblJTransaction.setText(String.valueOf(jTrns));
        lblJProduk.setText(String.valueOf(jBar));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelHome = new javax.swing.JPanel();
        placeholder4 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblJProduk = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblJCategory = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblJUser = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblJTransaction = new javax.swing.JLabel();
        lblBawah = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelBarang = new javax.swing.JPanel();
        panelBarang_biasa = new javax.swing.JPanel();
        btnRedirectEditBarang = new javax.swing.JButton();
        btnRedirectTambahBarang = new javax.swing.JButton();
        btnDeleteBarang = new javax.swing.JButton();
        scrollBarang = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        panelBarang_edit = new javax.swing.JPanel();
        lblJenisBarang_e = new javax.swing.JLabel();
        txtNamaBarang_e = new javax.swing.JTextField();
        btnCancelEditBarang = new javax.swing.JButton();
        btnEditBarang = new javax.swing.JButton();
        txtMerkBarang_e = new javax.swing.JTextField();
        lblMerkProduk = new javax.swing.JLabel();
        txtHargaBarang_e = new javax.swing.JTextField();
        lblHargaBarang = new javax.swing.JLabel();
        lblStokBarang = new javax.swing.JLabel();
        txtStokBarang_e = new javax.swing.JTextField();
        cbJenisBarang_e = new javax.swing.JComboBox<>();
        lblNamaBarang1 = new javax.swing.JLabel();
        panelBarang_tambah = new javax.swing.JPanel();
        btnCancelTambahBarang = new javax.swing.JButton();
        btnTambahBarang = new javax.swing.JButton();
        txtStokBarang_t = new javax.swing.JTextField();
        lblStokBarang1 = new javax.swing.JLabel();
        txtHargaBarang_t = new javax.swing.JTextField();
        lblHargaBarang1 = new javax.swing.JLabel();
        txtMerkBarang_t = new javax.swing.JTextField();
        lblMerkProduk1 = new javax.swing.JLabel();
        txtNamaBarang_t = new javax.swing.JTextField();
        lblNamaBarang2 = new javax.swing.JLabel();
        cbJenisBarang_t = new javax.swing.JComboBox<>();
        lblJenisBarang_e1 = new javax.swing.JLabel();
        panelJenisBarang = new javax.swing.JPanel();
        panelJBarang_biasa = new javax.swing.JPanel();
        btnRedirectEditJBarang = new javax.swing.JButton();
        btnRedirectTambahJBarang = new javax.swing.JButton();
        scrollJBarang = new javax.swing.JScrollPane();
        tabelJBarang = new javax.swing.JTable();
        btnDeleteJBarang = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        panelJBarang_tambah = new javax.swing.JPanel();
        lblFullName = new javax.swing.JLabel();
        txtNamaJBarang = new javax.swing.JTextField();
        btnCancelTambahJBarang = new javax.swing.JButton();
        btnTambahJBarang = new javax.swing.JButton();
        panelJBarang_edit = new javax.swing.JPanel();
        lblFullName1 = new javax.swing.JLabel();
        txtNamaJBarang_e = new javax.swing.JTextField();
        btnCancelEditJBarang = new javax.swing.JButton();
        btnEditJBarang = new javax.swing.JButton();
        panelUser = new javax.swing.JPanel();
        panelUser_biasa = new javax.swing.JPanel();
        btnDeleteUser = new javax.swing.JButton();
        scrollUser = new javax.swing.JScrollPane();
        tabelUser = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        panelTransaksi = new javax.swing.JPanel();
        scrollUser1 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        panelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelSidebar = new javax.swing.JPanel();
        lblBarang = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblTransaksi = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblJenisBarang = new javax.swing.JLabel();
        lblHome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1220, 810));
        setPreferredSize(new java.awt.Dimension(1220, 810));
        setResizable(false);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHome.setBackground(new java.awt.Color(255, 255, 255));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        placeholder4.setForeground(new java.awt.Color(255, 255, 255));
        placeholder4.setText(".");
        panelHome.add(placeholder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 630, 20, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel4.setText("Current Number of Products :");
        panelHome.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, -1, 30));

        lblJProduk.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblJProduk.setForeground(new java.awt.Color(0, 102, 102));
        lblJProduk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJProduk.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panelHome.add(lblJProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, 350, 30));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel6.setText("Current Number of Category :");
        panelHome.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, -1, -1));

        lblJCategory.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblJCategory.setForeground(new java.awt.Color(0, 102, 102));
        lblJCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJCategory.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panelHome.add(lblJCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 350, 30));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel9.setText("Current Number of Users :");
        panelHome.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        lblJUser.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblJUser.setForeground(new java.awt.Color(0, 102, 102));
        lblJUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panelHome.add(lblJUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 350, 30));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel5.setText("Current Number of Transaction :");
        panelHome.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, -1, 30));

        lblJTransaction.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblJTransaction.setForeground(new java.awt.Color(0, 102, 102));
        lblJTransaction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJTransaction.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panelHome.add(lblJTransaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 350, 30));

        lblBawah.setFont(new java.awt.Font("SansSerif", 1, 34)); // NOI18N
        lblBawah.setForeground(new java.awt.Color(0, 102, 102));
        lblBawah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBawah.setText("PartsHub, The Best Spare Parts Store in Indonesia");
        panelHome.add(lblBawah, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 880, 40));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/maintenance2.png"))); // NOI18N
        panelHome.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 880, 250));

        jLayeredPane1.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        panelBarang.setBackground(new java.awt.Color(255, 255, 255));
        panelBarang.setForeground(new java.awt.Color(255, 255, 255));
        panelBarang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBarang_biasa.setBackground(new java.awt.Color(255, 255, 255));
        panelBarang_biasa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRedirectEditBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnRedirectEditBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnRedirectEditBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnRedirectEditBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/edit.png"))); // NOI18N
        btnRedirectEditBarang.setText("Edit Data");
        btnRedirectEditBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedirectEditBarangActionPerformed(evt);
            }
        });
        panelBarang_biasa.add(btnRedirectEditBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 200, 60));

        btnRedirectTambahBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnRedirectTambahBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnRedirectTambahBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnRedirectTambahBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/new-document.png"))); // NOI18N
        btnRedirectTambahBarang.setText("Add Data");
        btnRedirectTambahBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedirectTambahBarangActionPerformed(evt);
            }
        });
        panelBarang_biasa.add(btnRedirectTambahBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 200, 60));

        btnDeleteBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnDeleteBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnDeleteBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/delete.png"))); // NOI18N
        btnDeleteBarang.setText("Delete Data");
        btnDeleteBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBarangActionPerformed(evt);
            }
        });
        panelBarang_biasa.add(btnDeleteBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 200, 60));

        tabelBarang.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelBarang.setGridColor(new java.awt.Color(0, 0, 0));
        tabelBarang.setRowHeight(30);
        tabelBarang.setRowMargin(5);
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        scrollBarang.setViewportView(tabelBarang);

        panelBarang_biasa.add(scrollBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 880, 440));
        panelBarang_biasa.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 880, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Product Data");
        panelBarang_biasa.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 90));

        panelBarang.add(panelBarang_biasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        panelBarang_edit.setBackground(new java.awt.Color(255, 255, 255));
        panelBarang_edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblJenisBarang_e.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblJenisBarang_e.setText("Product Category :");
        panelBarang_edit.add(lblJenisBarang_e, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        txtNamaBarang_e.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        txtNamaBarang_e.setForeground(new java.awt.Color(153, 153, 153));
        txtNamaBarang_e.setText("Type the product name here");
        txtNamaBarang_e.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtNamaBarang_e.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNamaBarang_eFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNamaBarang_eFocusLost(evt);
            }
        });
        panelBarang_edit.add(txtNamaBarang_e, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 450, 60));

        btnCancelEditBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelEditBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnCancelEditBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelEditBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/error.png"))); // NOI18N
        btnCancelEditBarang.setText("Cancel");
        btnCancelEditBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditBarangActionPerformed(evt);
            }
        });
        panelBarang_edit.add(btnCancelEditBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 200, 60));

        btnEditBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnEditBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnEditBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnEditBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/edit.png"))); // NOI18N
        btnEditBarang.setText("Edit Data");
        btnEditBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBarangActionPerformed(evt);
            }
        });
        panelBarang_edit.add(btnEditBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 200, 60));

        txtMerkBarang_e.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        txtMerkBarang_e.setForeground(new java.awt.Color(153, 153, 153));
        txtMerkBarang_e.setText("Type the product brand here");
        txtMerkBarang_e.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMerkBarang_e.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMerkBarang_eFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMerkBarang_eFocusLost(evt);
            }
        });
        panelBarang_edit.add(txtMerkBarang_e, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 450, 60));

        lblMerkProduk.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblMerkProduk.setText("Product Brand :");
        panelBarang_edit.add(lblMerkProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        txtHargaBarang_e.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        txtHargaBarang_e.setForeground(new java.awt.Color(153, 153, 153));
        txtHargaBarang_e.setText("Type the product price here");
        txtHargaBarang_e.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtHargaBarang_e.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHargaBarang_eFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHargaBarang_eFocusLost(evt);
            }
        });
        panelBarang_edit.add(txtHargaBarang_e, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 450, 60));

        lblHargaBarang.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblHargaBarang.setText("Product Price :");
        panelBarang_edit.add(lblHargaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        lblStokBarang.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblStokBarang.setText("Product Stock :");
        panelBarang_edit.add(lblStokBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, -1));

        txtStokBarang_e.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        txtStokBarang_e.setForeground(new java.awt.Color(153, 153, 153));
        txtStokBarang_e.setText("Type the product stock here");
        txtStokBarang_e.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtStokBarang_e.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStokBarang_eFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStokBarang_eFocusLost(evt);
            }
        });
        panelBarang_edit.add(txtStokBarang_e, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 450, 60));

        cbJenisBarang_e.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        cbJenisBarang_e.setMaximumRowCount(100);
        cbJenisBarang_e.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panelBarang_edit.add(cbJenisBarang_e, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 450, 60));

        lblNamaBarang1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblNamaBarang1.setText("Product Name :");
        panelBarang_edit.add(lblNamaBarang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        panelBarang.add(panelBarang_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        panelBarang_tambah.setBackground(new java.awt.Color(255, 255, 255));
        panelBarang_tambah.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelTambahBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelTambahBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnCancelTambahBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelTambahBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/error.png"))); // NOI18N
        btnCancelTambahBarang.setText("Cancel");
        btnCancelTambahBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelTambahBarangActionPerformed(evt);
            }
        });
        panelBarang_tambah.add(btnCancelTambahBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 200, 60));

        btnTambahBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnTambahBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnTambahBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/new-document.png"))); // NOI18N
        btnTambahBarang.setText("Add Data");
        btnTambahBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBarangActionPerformed(evt);
            }
        });
        panelBarang_tambah.add(btnTambahBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 200, 60));

        txtStokBarang_t.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        txtStokBarang_t.setForeground(new java.awt.Color(153, 153, 153));
        txtStokBarang_t.setText("Type the product stock here");
        txtStokBarang_t.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtStokBarang_t.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStokBarang_tFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStokBarang_tFocusLost(evt);
            }
        });
        panelBarang_tambah.add(txtStokBarang_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 450, 60));

        lblStokBarang1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblStokBarang1.setText("Product Stock :");
        panelBarang_tambah.add(lblStokBarang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, -1));

        txtHargaBarang_t.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        txtHargaBarang_t.setForeground(new java.awt.Color(153, 153, 153));
        txtHargaBarang_t.setText("Type the product price here");
        txtHargaBarang_t.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtHargaBarang_t.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHargaBarang_tFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHargaBarang_tFocusLost(evt);
            }
        });
        panelBarang_tambah.add(txtHargaBarang_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 450, 60));

        lblHargaBarang1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblHargaBarang1.setText("Product Price :");
        panelBarang_tambah.add(lblHargaBarang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        txtMerkBarang_t.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        txtMerkBarang_t.setForeground(new java.awt.Color(153, 153, 153));
        txtMerkBarang_t.setText("Type the product brand here");
        txtMerkBarang_t.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtMerkBarang_t.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMerkBarang_tFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMerkBarang_tFocusLost(evt);
            }
        });
        panelBarang_tambah.add(txtMerkBarang_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 450, 60));

        lblMerkProduk1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblMerkProduk1.setText("Product Brand :");
        panelBarang_tambah.add(lblMerkProduk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        txtNamaBarang_t.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        txtNamaBarang_t.setForeground(new java.awt.Color(153, 153, 153));
        txtNamaBarang_t.setText("Type the product name here");
        txtNamaBarang_t.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtNamaBarang_t.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNamaBarang_tFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNamaBarang_tFocusLost(evt);
            }
        });
        panelBarang_tambah.add(txtNamaBarang_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 450, 60));

        lblNamaBarang2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblNamaBarang2.setText("Product Name :");
        panelBarang_tambah.add(lblNamaBarang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        cbJenisBarang_t.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        cbJenisBarang_t.setMaximumRowCount(100);
        cbJenisBarang_t.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panelBarang_tambah.add(cbJenisBarang_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 450, 60));

        lblJenisBarang_e1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblJenisBarang_e1.setText("Product Category :");
        panelBarang_tambah.add(lblJenisBarang_e1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        panelBarang.add(panelBarang_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        jLayeredPane1.add(panelBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        panelJenisBarang.setBackground(new java.awt.Color(255, 255, 255));
        panelJenisBarang.setForeground(new java.awt.Color(255, 255, 255));
        panelJenisBarang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelJBarang_biasa.setBackground(new java.awt.Color(255, 255, 255));
        panelJBarang_biasa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRedirectEditJBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnRedirectEditJBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnRedirectEditJBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnRedirectEditJBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/edit.png"))); // NOI18N
        btnRedirectEditJBarang.setText("Edit Data");
        btnRedirectEditJBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedirectEditJBarangActionPerformed(evt);
            }
        });
        panelJBarang_biasa.add(btnRedirectEditJBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 200, 60));

        btnRedirectTambahJBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnRedirectTambahJBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnRedirectTambahJBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnRedirectTambahJBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/new-document.png"))); // NOI18N
        btnRedirectTambahJBarang.setText("Add Data");
        btnRedirectTambahJBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedirectTambahJBarangActionPerformed(evt);
            }
        });
        panelJBarang_biasa.add(btnRedirectTambahJBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 200, 60));

        tabelJBarang.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        tabelJBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelJBarang.setGridColor(new java.awt.Color(0, 0, 0));
        tabelJBarang.setRowHeight(30);
        tabelJBarang.setRowMargin(5);
        tabelJBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelJBarangMouseClicked(evt);
            }
        });
        scrollJBarang.setViewportView(tabelJBarang);

        panelJBarang_biasa.add(scrollJBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 880, 440));

        btnDeleteJBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnDeleteJBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnDeleteJBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteJBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/delete.png"))); // NOI18N
        btnDeleteJBarang.setText("Delete Data");
        btnDeleteJBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteJBarangActionPerformed(evt);
            }
        });
        panelJBarang_biasa.add(btnDeleteJBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 200, 60));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Product Category Data");
        panelJBarang_biasa.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 90));
        panelJBarang_biasa.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 880, -1));

        panelJenisBarang.add(panelJBarang_biasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        panelJBarang_tambah.setBackground(new java.awt.Color(255, 255, 255));
        panelJBarang_tambah.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFullName.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblFullName.setText("Category Name :");
        panelJBarang_tambah.add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        txtNamaJBarang.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        txtNamaJBarang.setForeground(new java.awt.Color(153, 153, 153));
        txtNamaJBarang.setText("Type the item category name here");
        txtNamaJBarang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtNamaJBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNamaJBarangFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNamaJBarangFocusLost(evt);
            }
        });
        panelJBarang_tambah.add(txtNamaJBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 450, 60));

        btnCancelTambahJBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelTambahJBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnCancelTambahJBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelTambahJBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/error.png"))); // NOI18N
        btnCancelTambahJBarang.setText("Cancel");
        btnCancelTambahJBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelTambahJBarangActionPerformed(evt);
            }
        });
        panelJBarang_tambah.add(btnCancelTambahJBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 200, 60));

        btnTambahJBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnTambahJBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnTambahJBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahJBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/new-document.png"))); // NOI18N
        btnTambahJBarang.setText("Add Data");
        btnTambahJBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahJBarangActionPerformed(evt);
            }
        });
        panelJBarang_tambah.add(btnTambahJBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 200, 60));

        panelJenisBarang.add(panelJBarang_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        panelJBarang_edit.setBackground(new java.awt.Color(255, 255, 255));
        panelJBarang_edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFullName1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblFullName1.setText("Category Name :");
        panelJBarang_edit.add(lblFullName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        txtNamaJBarang_e.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        txtNamaJBarang_e.setForeground(new java.awt.Color(153, 153, 153));
        txtNamaJBarang_e.setText("Type the item category name here");
        txtNamaJBarang_e.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtNamaJBarang_e.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNamaJBarang_eFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNamaJBarang_eFocusLost(evt);
            }
        });
        panelJBarang_edit.add(txtNamaJBarang_e, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 450, 60));

        btnCancelEditJBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelEditJBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnCancelEditJBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelEditJBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/error.png"))); // NOI18N
        btnCancelEditJBarang.setText("Cancel");
        btnCancelEditJBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditJBarangActionPerformed(evt);
            }
        });
        panelJBarang_edit.add(btnCancelEditJBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 200, 60));

        btnEditJBarang.setBackground(new java.awt.Color(0, 102, 102));
        btnEditJBarang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnEditJBarang.setForeground(new java.awt.Color(255, 255, 255));
        btnEditJBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/edit.png"))); // NOI18N
        btnEditJBarang.setText("Edit Data");
        btnEditJBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditJBarangActionPerformed(evt);
            }
        });
        panelJBarang_edit.add(btnEditJBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 200, 60));

        panelJenisBarang.add(panelJBarang_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        jLayeredPane1.add(panelJenisBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelUser.setBackground(new java.awt.Color(255, 255, 255));
        panelUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelUser_biasa.setBackground(new java.awt.Color(255, 255, 255));
        panelUser_biasa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDeleteUser.setBackground(new java.awt.Color(0, 102, 102));
        btnDeleteUser.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/delete.png"))); // NOI18N
        btnDeleteUser.setText("Delete Data");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });
        panelUser_biasa.add(btnDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 200, 60));

        tabelUser.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        tabelUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelUser.setGridColor(new java.awt.Color(0, 0, 0));
        tabelUser.setRowHeight(30);
        tabelUser.setRowMargin(5);
        tabelUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelUserMouseClicked(evt);
            }
        });
        scrollUser.setViewportView(tabelUser);

        panelUser_biasa.add(scrollUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 880, 440));
        panelUser_biasa.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 880, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("User Data");
        panelUser_biasa.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 90));

        panelUser.add(panelUser_biasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        jLayeredPane1.add(panelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        panelTransaksi.setBackground(new java.awt.Color(255, 255, 255));
        panelTransaksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelTransaksi.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelTransaksi.setGridColor(new java.awt.Color(0, 0, 0));
        tabelTransaksi.setRowHeight(30);
        tabelTransaksi.setRowMargin(5);
        scrollUser1.setViewportView(tabelTransaksi);

        panelTransaksi.add(scrollUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 880, 550));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Transaction Data");
        panelTransaksi.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 90));
        panelTransaksi.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 880, -1));

        jLayeredPane1.add(panelTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        panelHeader.setBackground(new java.awt.Color(0, 102, 102));
        panelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/maintenance.png"))); // NOI18N
        jLabel1.setText("PartHubs");
        panelHeader.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, -1, -1));

        panelSidebar.setBackground(new java.awt.Color(208, 216, 218));
        panelSidebar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        panelSidebar.setToolTipText("");
        panelSidebar.setMinimumSize(new java.awt.Dimension(250, 200));
        panelSidebar.setName(""); // NOI18N
        panelSidebar.setPreferredSize(new java.awt.Dimension(250, 700));
        panelSidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBarang.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblBarang.setForeground(new java.awt.Color(0, 102, 102));
        lblBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bulet/gear2.png"))); // NOI18N
        lblBarang.setText("Product");
        lblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBarangMouseClicked(evt);
            }
        });
        panelSidebar.add(lblBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        lblLogout.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(0, 102, 102));
        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bulet/logout2.png"))); // NOI18N
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });
        panelSidebar.add(lblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, -1));

        lblUser.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblUser.setForeground(new java.awt.Color(0, 102, 102));
        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bulet/user2.png"))); // NOI18N
        lblUser.setText("User");
        lblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserMouseClicked(evt);
            }
        });
        panelSidebar.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        lblTransaksi.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblTransaksi.setForeground(new java.awt.Color(0, 102, 102));
        lblTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bulet/clock2.png"))); // NOI18N
        lblTransaksi.setText("Transaction");
        lblTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTransaksiMouseClicked(evt);
            }
        });
        panelSidebar.add(lblTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));
        panelSidebar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 310, 20));

        lblJenisBarang.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblJenisBarang.setForeground(new java.awt.Color(0, 102, 102));
        lblJenisBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bulet/connection2.png"))); // NOI18N
        lblJenisBarang.setText("Category");
        lblJenisBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJenisBarangMouseClicked(evt);
            }
        });
        panelSidebar.add(lblJenisBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        lblHome.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblHome.setForeground(new java.awt.Color(0, 102, 102));
        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bulet/home2.png"))); // NOI18N
        lblHome.setText("Home");
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        panelSidebar.add(lblHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarangMouseClicked
        visual("barang");
        panelBarang("biasa");
        loadBarang();
    }//GEN-LAST:event_lblBarangMouseClicked

    private void lblJenisBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJenisBarangMouseClicked
        visual("jenisbarang");
        panelJBarang("biasa");
        loadJBarang();
    }//GEN-LAST:event_lblJenisBarangMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        int opsi = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION) {
            new LoginPage().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseClicked
        visual("user");
        loadUser();
    }//GEN-LAST:event_lblUserMouseClicked

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        visual("home");
        panelHome();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTransaksiMouseClicked
        visual("transaksi");
        loadTransaksi();
    }//GEN-LAST:event_lblTransaksiMouseClicked

    private void txtNamaJBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamaJBarangFocusGained
        if(txtNamaJBarang.getText().equals("Type the item category name here")){
            txtNamaJBarang.setText("");
            txtNamaJBarang.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNamaJBarangFocusGained

    private void txtNamaJBarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamaJBarangFocusLost
        if(txtNamaJBarang.getText().equals("")){
            txtNamaJBarang.setText("Type the item category name here");
            txtNamaJBarang.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtNamaJBarangFocusLost

    private void btnCancelTambahJBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelTambahJBarangActionPerformed
        panelJBarang("biasa");
    }//GEN-LAST:event_btnCancelTambahJBarangActionPerformed

    private void btnTambahJBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahJBarangActionPerformed
        int id_jenisbarang = 0;       
        String nama_jenisbarang = txtNamaJBarang.getText();

        if ((nama_jenisbarang.equals("Type the item category name here"))){
            JOptionPane.showMessageDialog(this, "Please fill in the category name first!!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JenisBarangModel jBarang = new JenisBarangModel(id_jenisbarang, nama_jenisbarang);
            hasil = conJBarang.saveJBarang(jBarang);
            switch (hasil) {
                case 1:
                    JOptionPane.showMessageDialog(this, "Data succesfully added, moving back to product category page");
                    loadJBarang();
                    panelJBarang("biasa");
                    txtNamaJBarang.setText("Type the item category name here");
                    txtNamaJBarang.setForeground(new Color(153, 153, 153));
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Data failed to be added", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }//GEN-LAST:event_btnTambahJBarangActionPerformed

    private void btnRedirectTambahJBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedirectTambahJBarangActionPerformed
        panelJBarang("tambah");
    }//GEN-LAST:event_btnRedirectTambahJBarangActionPerformed

    private void txtNamaJBarang_eFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamaJBarang_eFocusGained
        if(txtNamaJBarang_e.getText().equals("Type the item category name here")){
            txtNamaJBarang_e.setText("");
            txtNamaJBarang_e.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNamaJBarang_eFocusGained

    private void txtNamaJBarang_eFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamaJBarang_eFocusLost
        if(txtNamaJBarang_e.getText().equals("")){
            txtNamaJBarang_e.setText("Type the item category name here");
            txtNamaJBarang_e.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtNamaJBarang_eFocusLost

    private void btnCancelEditJBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEditJBarangActionPerformed
        panelJBarang("biasa");
    }//GEN-LAST:event_btnCancelEditJBarangActionPerformed

    private void btnEditJBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditJBarangActionPerformed
        JenisBarangModel editJB = this.jbrED;
        
        int id_jb = editJB.getId_jenisbarang();
        String nama_jb = txtNamaJBarang_e.getText();

        if ((nama_jb.equals("Type the item category name here"))){
            JOptionPane.showMessageDialog(this, "Please fill in the category name fields!!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JenisBarangModel updateJB = new JenisBarangModel(id_jb, nama_jb);
            hasil = conJBarang.updateJBarang(updateJB);
            switch (hasil) {
                case 1:
                    JOptionPane.showMessageDialog(this, "Category Successfuly Updated!!");
                    this.jbrED = updateJB;
                    loadJBarang();
                    panelJBarang("biasa");
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Category failed to be updated", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }//GEN-LAST:event_btnEditJBarangActionPerformed

    private void btnRedirectEditJBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedirectEditJBarangActionPerformed
        if(this.jbrED == null){
            JOptionPane.showMessageDialog(this, "You have to choose an item from the table before you can edit a data!!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            panelJBarang("edit");
            JenisBarangModel editJB = this.jbrED;
            txtNamaJBarang_e.setText(editJB.getNama_jenisbarang());
            txtNamaJBarang_e.setForeground(Color.black);
        }
    }//GEN-LAST:event_btnRedirectEditJBarangActionPerformed

    private void tabelJBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelJBarangMouseClicked
        int row = tabelJBarang.getSelectedRow();
        int id_jenisbarang = Integer.parseInt(tabelJBarang.getValueAt(row, 0).toString());
        this.jbrED = conJBarang.getId(id_jenisbarang);
    }//GEN-LAST:event_tabelJBarangMouseClicked

    private void btnDeleteJBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteJBarangActionPerformed
        if(this.jbrED == null){
            JOptionPane.showMessageDialog(this, "You have to choose an item from the table before you can delete a data!!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            int opsi = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+this.jbrED.getNama_jenisbarang()+"?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION) {
                hasil = conJBarang.deleteJBarang(this.jbrED.getId_jenisbarang());
                switch (hasil) {
                    case 1:
                        JOptionPane.showMessageDialog(this, "Category Successfuly Deleted!!");
                        loadJBarang();
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Category failed to be deleted", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        }
    }//GEN-LAST:event_btnDeleteJBarangActionPerformed

    private void txtNamaBarang_eFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamaBarang_eFocusGained
        if(txtNamaBarang_e.getText().equals("Type the product name here")){
            txtNamaBarang_e.setText("");
            txtNamaBarang_e.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNamaBarang_eFocusGained

    private void txtNamaBarang_eFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamaBarang_eFocusLost
        if(txtNamaBarang_e.getText().equals("")){
            txtNamaBarang_e.setText("Type the product name here");
            txtNamaBarang_e.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtNamaBarang_eFocusLost

    private void btnCancelEditBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEditBarangActionPerformed
        panelBarang("biasa");
    }//GEN-LAST:event_btnCancelEditBarangActionPerformed

    private void btnEditBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBarangActionPerformed
        BarangModel editB = this.brED;
        
        int id_b = editB.getId_barang();
        String input = String.valueOf(cbJenisBarang_e.getSelectedItem());
        int cariTitik = input.indexOf(".");
        String nomor = input.substring(0, cariTitik).trim();
        int id_jb = Integer.parseInt(nomor);
        String nama_b = txtNamaBarang_e.getText();
        String merk_b = txtMerkBarang_e.getText();
        int harga_b = Integer.parseInt(txtHargaBarang_e.getText());
        int stok_b = Integer.parseInt(txtStokBarang_e.getText());

        if ((nama_b.equals("Type the product name here")) || (merk_b.equals("Type the product brand here")) 
                || (txtHargaBarang_e.getText().equals("Type the product price here"))
                || (txtStokBarang_e.getText().equals("Type the product stock here"))){
            JOptionPane.showMessageDialog(this, "Please fill in all the required fields!!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            BarangModel updateB = new BarangModel(id_b, id_jb, nama_b, merk_b, harga_b, stok_b);
            hasil = conBar.updateBarang(updateB);
            switch (hasil) {
                case 1:
                    JOptionPane.showMessageDialog(this, "Product Successfuly Updated!!");
                    this.brED = updateB;
                    loadBarang();
                    panelBarang("biasa");
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Product failed to be updated", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }//GEN-LAST:event_btnEditBarangActionPerformed

    private void btnCancelTambahBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelTambahBarangActionPerformed
        panelBarang("biasa");
    }//GEN-LAST:event_btnCancelTambahBarangActionPerformed

    private void btnTambahBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBarangActionPerformed
        if ((txtNamaBarang_t.getText().equals("Type the product name here")) || (txtMerkBarang_t.equals("Type the product brand here")) 
                || (txtHargaBarang_t.getText().equals("Type the product price here"))
                || (txtStokBarang_t.getText().equals("Type the product stock here"))){
            JOptionPane.showMessageDialog(this, "Please fill in all the required fields!!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int id_b = 0;
            String input = String.valueOf(cbJenisBarang_t.getSelectedItem());
            int cariTitik = input.indexOf(".");
            String nomor = input.substring(0, cariTitik).trim();
            int id_jb = Integer.parseInt(nomor);
            String nama_b = txtNamaBarang_t.getText();
            String merk_b = txtMerkBarang_t.getText();
            int harga_b = Integer.parseInt(txtHargaBarang_t.getText());
            int stok_b = Integer.parseInt(txtStokBarang_t.getText());
            BarangModel tBarang = new BarangModel(id_b, id_jb, nama_b, merk_b, harga_b, stok_b);
            hasil = conBar.saveBarang(tBarang);
            switch (hasil) {
                case 1:
                    JOptionPane.showMessageDialog(this, "Data succesfully added, moving back to product page");
                    loadBarang();
                    panelBarang("biasa");
                    txtNamaBarang_t.setText("Type the product name here");
                    txtMerkBarang_t.setText("Type the product brand here");
                    txtHargaBarang_t.setText("Type the product price here");
                    txtStokBarang_t.setText("Type the product stock here");
                    txtNamaBarang_t.setForeground(new Color(153,153,153));
                    txtMerkBarang_t.setForeground(new Color(153,153,153));
                    txtHargaBarang_t.setForeground(new Color(153,153,153));
                    txtStokBarang_t.setForeground(new Color(153,153,153));
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Data failed to be added", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }//GEN-LAST:event_btnTambahBarangActionPerformed

    private void btnRedirectEditBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedirectEditBarangActionPerformed
        if(this.brED == null){
            JOptionPane.showMessageDialog(this, "You have to choose an item from the table before you can edit a data!!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            BarangModel editB = this.brED;
            JenisBarangModel jenisB = conJBarang.getId(editB.getId_jenisbarang());
            cbJenisBarang_e.removeAllItems();
            cbJenisBarang_e.addItem(jenisB.getId_jenisbarang()+"."+jenisB.getNama_jenisbarang());
            List <JenisBarangModel> list = conJBarang.getAllJBarang();
            for(JenisBarangModel jbList: list){
                if(jenisB.getId_jenisbarang()!=jbList.getId_jenisbarang()){
                    cbJenisBarang_e.addItem(jbList.getId_jenisbarang()+"."+jbList.getNama_jenisbarang());
                }
            }
            txtNamaBarang_e.setText(editB.getNama_barang());
            txtMerkBarang_e.setText(editB.getMerk_barang());
            txtHargaBarang_e.setText(String.valueOf(editB.getHarga_barang()));
            txtStokBarang_e.setText(String.valueOf(editB.getStok_barang()));
            txtNamaBarang_e.setForeground(Color.black);
            txtMerkBarang_e.setForeground(Color.black);
            txtHargaBarang_e.setForeground(Color.black);
            txtStokBarang_e.setForeground(Color.black);
            panelBarang("edit");
       }
    }//GEN-LAST:event_btnRedirectEditBarangActionPerformed

    private void btnRedirectTambahBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedirectTambahBarangActionPerformed
        List <JenisBarangModel> list = conJBarang.getAllJBarang();
        cbJenisBarang_t.removeAllItems();
        for(JenisBarangModel jbList: list){
            cbJenisBarang_t.addItem(jbList.getId_jenisbarang()+"."+jbList.getNama_jenisbarang());
        }
        panelBarang("tambah");
    }//GEN-LAST:event_btnRedirectTambahBarangActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        int row = tabelBarang.getSelectedRow();
        int id_barang = Integer.parseInt(tabelBarang.getValueAt(row, 0).toString());
        this.brED = conBar.getId(id_barang);
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void btnDeleteBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBarangActionPerformed
        if(this.brED == null){
            JOptionPane.showMessageDialog(this, "You have to choose an item from the table before you can delete a data!!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            int opsi = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+this.brED.getNama_barang()+"?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION) {
                hasil = conBar.deleteBarang(this.brED.getId_barang());
                switch (hasil) {
                    case 1:
                        JOptionPane.showMessageDialog(this, "Product Successfuly Deleted!!");
                        loadBarang();
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Product failed to be deleted", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        }
    }//GEN-LAST:event_btnDeleteBarangActionPerformed

    private void txtMerkBarang_eFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMerkBarang_eFocusGained
        if(txtMerkBarang_e.getText().equals("Type the product brand here")){
            txtMerkBarang_e.setText("");
            txtMerkBarang_e.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtMerkBarang_eFocusGained

    private void txtMerkBarang_eFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMerkBarang_eFocusLost
        if(txtMerkBarang_e.getText().equals("")){
            txtMerkBarang_e.setText("Type the product brand here");
            txtMerkBarang_e.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtMerkBarang_eFocusLost

    private void txtHargaBarang_eFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHargaBarang_eFocusGained
        if(txtHargaBarang_e.getText().equals("Type the product price here")){
            txtHargaBarang_e.setText("");
            txtHargaBarang_e.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtHargaBarang_eFocusGained

    private void txtHargaBarang_eFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHargaBarang_eFocusLost
        if(txtHargaBarang_e.getText().equals("")){
            txtHargaBarang_e.setText("Type the product price here");
            txtHargaBarang_e.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtHargaBarang_eFocusLost

    private void txtStokBarang_eFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStokBarang_eFocusGained
        if(txtStokBarang_e.getText().equals("Type the product stock here")){
            txtStokBarang_e.setText("");
            txtStokBarang_e.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtStokBarang_eFocusGained

    private void txtStokBarang_eFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStokBarang_eFocusLost
        if(txtStokBarang_e.getText().equals("")){
            txtStokBarang_e.setText("Type the product stock here");
            txtStokBarang_e.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtStokBarang_eFocusLost

    private void txtStokBarang_tFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStokBarang_tFocusGained
        if(txtStokBarang_t.getText().equals("Type the product stock here")){
            txtStokBarang_t.setText("");
            txtStokBarang_t.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtStokBarang_tFocusGained

    private void txtStokBarang_tFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStokBarang_tFocusLost
        if(txtStokBarang_t.getText().equals("")){
            txtStokBarang_t.setText("Type the product stock here");
            txtStokBarang_t.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtStokBarang_tFocusLost

    private void txtHargaBarang_tFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHargaBarang_tFocusGained
        if(txtHargaBarang_t.getText().equals("Type the product price here")){
            txtHargaBarang_t.setText("");
            txtHargaBarang_t.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtHargaBarang_tFocusGained

    private void txtHargaBarang_tFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHargaBarang_tFocusLost
        if(txtHargaBarang_t.getText().equals("")){
            txtHargaBarang_t.setText("Type the product price here");
            txtHargaBarang_t.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtHargaBarang_tFocusLost

    private void txtMerkBarang_tFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMerkBarang_tFocusGained
        if(txtMerkBarang_t.getText().equals("Type the product brand here")){
            txtMerkBarang_t.setText("");
            txtMerkBarang_t.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtMerkBarang_tFocusGained

    private void txtMerkBarang_tFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMerkBarang_tFocusLost
        if(txtMerkBarang_t.getText().equals("")){
            txtMerkBarang_t.setText("Type the product brand here");
            txtMerkBarang_t.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtMerkBarang_tFocusLost

    private void txtNamaBarang_tFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamaBarang_tFocusGained
        if(txtNamaBarang_t.getText().equals("Type the product name here")){
            txtNamaBarang_t.setText("");
            txtNamaBarang_t.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNamaBarang_tFocusGained

    private void txtNamaBarang_tFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamaBarang_tFocusLost
        if(txtNamaBarang_t.getText().equals("")){
            txtNamaBarang_t.setText("Type the product name here");
            txtNamaBarang_t.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtNamaBarang_tFocusLost

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        if(this.user == null){
            JOptionPane.showMessageDialog(this, "You have to choose a user from the table before you can delete the user!!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            int opsi = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+this.user.getFull_name()+"?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION) {
                hasil = conUser.deleteUser(this.user.getId());
                switch (hasil) {
                    case 1:
                        JOptionPane.showMessageDialog(this, "User Successfuly Deleted!!");
                        loadUser();
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "User failed to be deleted", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void tabelUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelUserMouseClicked
        int row = tabelUser.getSelectedRow();
        int id = Integer.parseInt(tabelUser.getValueAt(row, 0).toString());
        this.user = conUser.getId(id);
    }//GEN-LAST:event_tabelUserMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelEditBarang;
    private javax.swing.JButton btnCancelEditJBarang;
    private javax.swing.JButton btnCancelTambahBarang;
    private javax.swing.JButton btnCancelTambahJBarang;
    private javax.swing.JButton btnDeleteBarang;
    private javax.swing.JButton btnDeleteJBarang;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEditBarang;
    private javax.swing.JButton btnEditJBarang;
    private javax.swing.JButton btnRedirectEditBarang;
    private javax.swing.JButton btnRedirectEditJBarang;
    private javax.swing.JButton btnRedirectTambahBarang;
    private javax.swing.JButton btnRedirectTambahJBarang;
    private javax.swing.JButton btnTambahBarang;
    private javax.swing.JButton btnTambahJBarang;
    private javax.swing.JComboBox<String> cbJenisBarang_e;
    private javax.swing.JComboBox<String> cbJenisBarang_t;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblBarang;
    private javax.swing.JLabel lblBawah;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblFullName1;
    private javax.swing.JLabel lblHargaBarang;
    private javax.swing.JLabel lblHargaBarang1;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblJCategory;
    private javax.swing.JLabel lblJProduk;
    private javax.swing.JLabel lblJTransaction;
    private javax.swing.JLabel lblJUser;
    private javax.swing.JLabel lblJenisBarang;
    private javax.swing.JLabel lblJenisBarang_e;
    private javax.swing.JLabel lblJenisBarang_e1;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblMerkProduk;
    private javax.swing.JLabel lblMerkProduk1;
    private javax.swing.JLabel lblNamaBarang1;
    private javax.swing.JLabel lblNamaBarang2;
    private javax.swing.JLabel lblStokBarang;
    private javax.swing.JLabel lblStokBarang1;
    private javax.swing.JLabel lblTransaksi;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel panelBarang;
    private javax.swing.JPanel panelBarang_biasa;
    private javax.swing.JPanel panelBarang_edit;
    private javax.swing.JPanel panelBarang_tambah;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelJBarang_biasa;
    private javax.swing.JPanel panelJBarang_edit;
    private javax.swing.JPanel panelJBarang_tambah;
    private javax.swing.JPanel panelJenisBarang;
    private javax.swing.JPanel panelSidebar;
    private javax.swing.JPanel panelTransaksi;
    private javax.swing.JPanel panelUser;
    private javax.swing.JPanel panelUser_biasa;
    private javax.swing.JLabel placeholder4;
    private javax.swing.JScrollPane scrollBarang;
    private javax.swing.JScrollPane scrollJBarang;
    private javax.swing.JScrollPane scrollUser;
    private javax.swing.JScrollPane scrollUser1;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTable tabelJBarang;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JTable tabelUser;
    private javax.swing.JTextField txtHargaBarang_e;
    private javax.swing.JTextField txtHargaBarang_t;
    private javax.swing.JTextField txtMerkBarang_e;
    private javax.swing.JTextField txtMerkBarang_t;
    private javax.swing.JTextField txtNamaBarang_e;
    private javax.swing.JTextField txtNamaBarang_t;
    private javax.swing.JTextField txtNamaJBarang;
    private javax.swing.JTextField txtNamaJBarang_e;
    private javax.swing.JTextField txtStokBarang_e;
    private javax.swing.JTextField txtStokBarang_t;
    // End of variables declaration//GEN-END:variables
}
