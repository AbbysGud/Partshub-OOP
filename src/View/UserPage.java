package View;

import Controller.*;
import Models.*;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class UserPage extends javax.swing.JFrame {
    private final Color white = new Color(255, 255, 255);
    private final Color sageGreen = new Color(102, 255, 153);
    private final Color ijoOri = new Color(0, 102, 102);
    
    private UserModel user;
    private BarangModel brED = null;
    private CartModel cartED = null;
    
    private final ControllerUser conUser = new ControllerUser();
    private final ControllerBarang conBar = new ControllerBarang();
    private final ControllerJenisBarang conJBarang = new ControllerJenisBarang();
    private final ControllerCart conCart = new ControllerCart();
    private final ControllerTransaksi conTrans = new ControllerTransaksi();
    
    private int hasil = 0;

    public UserPage(UserModel user) {
        initComponents();
        this.user = user;
        panelProfile.setVisible(false);
        panelShop.setVisible(false);
        panelHome.setVisible(true);
        panelCart.setVisible(false);
        lblWelcome.setText("Welcome to PartsHub "+user.getFull_name());
    }
    
    private void header_tabel(JTable nama_tabel, int size){
        DefaultTableCellRenderer head_render = new DefaultTableCellRenderer(); 

        Font font = new Font("SansSerif", Font.PLAIN, size);
        head_render.setBackground(ijoOri);
        head_render.setForeground(Color.white);
        head_render.setFont(font);
        nama_tabel.getTableHeader().setDefaultRenderer(head_render);
    }

    public void visual(String panel) {
        panelProfile.setVisible(false);
        panelShop.setVisible(false);
        panelHome.setVisible(false);
        panelCart.setVisible(false);
        panelInvoice.setVisible(false);
        lblProfile.setForeground(white);
        lblCart.setForeground(white);
        lblShop.setForeground(white);
        lblHeader.setForeground(white);
        lblInvoice.setForeground(white);
        switch (panel) {
            case "profil":
                panelProfile.setVisible(true);
                lblProfile.setForeground(sageGreen);
                break;
            case "cart":
                panelCart.setVisible(true);   
                lblCart.setForeground(sageGreen);
                break;
            case "shop":
                panelShop.setVisible(true);
                lblShop.setForeground(sageGreen);
                break;
            case "home":
                panelHome.setVisible(true);
                lblHeader.setForeground(sageGreen);
                break;
            case "invoice":
                panelInvoice.setVisible(true);
                lblInvoice.setForeground(sageGreen);
                break;
            default:
                break;
        }
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
        header_tabel(tabelBarang, 18);
    }
    
    private void loadCart(){
        List <CartModel> list = conCart.getAllCart(this.user.getId());
        Object[][] obCart = new Object[list.size()][6];
        int i =0 ;
        for (CartModel cart : list) {
            obCart[i][0] = cart.getId_barang();
            BarangModel brg = conBar.getId(cart.getId_barang());
            obCart[i][1] = brg.getNama_barang();
            obCart[i][2] = cart.getNama_jenisbarang();
            obCart[i][3] = cart.getHarga_barang();
            obCart[i][4] = cart.getJumlah();
            obCart[i][5] = cart.getTotal();
            i++;
        }
        tabelCart.setModel(new javax.swing.table.DefaultTableModel(obCart, new  String[] {"Product ID", "P_Name", "P_Category", "P_Price", "P_Quantity", "Total"}));
        tabelCart.setDefaultEditor(Object.class, null);
        header_tabel(tabelCart, 18);
    }
    
    private void loadTransaksi(){
        List <TransaksiModel> list = conTrans.getTransaksi(this.user.getId());
        Object[][] obTrans = new Object[list.size()][6];
        int i =0 ;
        for (TransaksiModel trns : list) {
            obTrans[i][0] = trns.getId_transaksi();
            BarangModel brg = conBar.getId(trns.getId_barang());
            obTrans[i][1] = brg.getNama_barang();
            obTrans[i][2] = trns.getJumlah();
            obTrans[i][3] = trns.getTotal();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = trns.getWaktu().format(formatter);
            obTrans[i][4] = formattedDateTime;
            i++;
        }
        tabelInvoice.setModel(new javax.swing.table.DefaultTableModel(obTrans, new  String[] {"Transaction ID", "Product Name", "P_Quantity", "Total", "Transaction Time"}));
        tabelInvoice.setDefaultEditor(Object.class, null);
        header_tabel(tabelInvoice, 18);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        lblInvoice = new javax.swing.JLabel();
        lblHeader = new javax.swing.JLabel();
        lblShop = new javax.swing.JLabel();
        lblCart = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblProfile = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelHome = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblBawah = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        panelCart = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelCart = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lblCurrent1 = new javax.swing.JLabel();
        btnCheckout = new javax.swing.JButton();
        btnDeleteCart = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnEditCart = new javax.swing.JButton();
        lblCurrent2 = new javax.swing.JLabel();
        panelProfile = new javax.swing.JPanel();
        placeholder = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblUsername2 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        lblFullName = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        cbPassword = new javax.swing.JCheckBox();
        lblConfirmPassword = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        cbConfirmPassword = new javax.swing.JCheckBox();
        btnUpdate = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        panelShop = new javax.swing.JPanel();
        btnTambahCart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        lblUsername3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblCurrent = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelInvoice = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelInvoice = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1220, 860));
        setResizable(false);

        panelHeader.setBackground(new java.awt.Color(0, 102, 102));
        panelHeader.setMinimumSize(new java.awt.Dimension(1200, 77));
        panelHeader.setPreferredSize(new java.awt.Dimension(1200, 77));
        panelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInvoice.setBackground(new java.awt.Color(102, 102, 102));
        lblInvoice.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblInvoice.setForeground(new java.awt.Color(255, 255, 255));
        lblInvoice.setText("Invoice");
        lblInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInvoiceMouseClicked(evt);
            }
        });
        panelHeader.add(lblInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, -1, -1));

        lblHeader.setBackground(new java.awt.Color(102, 102, 102));
        lblHeader.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.png"))); // NOI18N
        lblHeader.setText("PartHubs");
        lblHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHeaderMouseClicked(evt);
            }
        });
        panelHeader.add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        lblShop.setBackground(new java.awt.Color(102, 102, 102));
        lblShop.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblShop.setForeground(new java.awt.Color(255, 255, 255));
        lblShop.setText("Shop");
        lblShop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShopMouseClicked(evt);
            }
        });
        panelHeader.add(lblShop, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        lblCart.setBackground(new java.awt.Color(102, 102, 102));
        lblCart.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblCart.setForeground(new java.awt.Color(255, 255, 255));
        lblCart.setText("Cart");
        lblCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCartMouseClicked(evt);
            }
        });
        panelHeader.add(lblCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, -1, -1));

        lblLogout.setBackground(new java.awt.Color(102, 102, 102));
        lblLogout.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });
        panelHeader.add(lblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 30, -1, -1));

        lblProfile.setBackground(new java.awt.Color(102, 102, 102));
        lblProfile.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblProfile.setText("Profile");
        lblProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProfileMouseClicked(evt);
            }
        });
        panelHeader.add(lblProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, -1, -1));

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(1200, 600));

        panelHome.setBackground(new java.awt.Color(255, 255, 255));
        panelHome.setMinimumSize(new java.awt.Dimension(1200, 700));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(0, 102, 102));
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelHome.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1200, 40));

        lblBawah.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblBawah.setForeground(new java.awt.Color(0, 102, 102));
        lblBawah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBawah.setText("The Best Spare Parts Store in Indonesia");
        panelHome.add(lblBawah, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 1200, 40));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(".");
        panelHome.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1196, 684, -1, -1));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maintenance.png"))); // NOI18N
        panelHome.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1200, 512));

        panelCart.setBackground(new java.awt.Color(255, 255, 255));
        panelCart.setMinimumSize(new java.awt.Dimension(1200, 700));
        panelCart.setPreferredSize(new java.awt.Dimension(1200, 700));
        panelCart.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cart");
        panelCart.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 680, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        tabelCart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        tabelCart.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        tabelCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelCart.setRowHeight(40);
        tabelCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelCartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelCart);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCart.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1130, 500));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel6.setText("Current Selected Item : ");
        panelCart.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, -1, 30));

        lblCurrent1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblCurrent1.setForeground(new java.awt.Color(0, 102, 102));
        panelCart.add(lblCurrent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 610, -1, 30));

        btnCheckout.setBackground(new java.awt.Color(0, 102, 102));
        btnCheckout.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnCheckout.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/online-shopping.png"))); // NOI18N
        btnCheckout.setText("Checkout");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });
        panelCart.add(btnCheckout, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 600, 200, 60));

        btnDeleteCart.setBackground(new java.awt.Color(0, 102, 102));
        btnDeleteCart.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnDeleteCart.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/bin.png"))); // NOI18N
        btnDeleteCart.setText("Delete Cart");
        btnDeleteCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCartActionPerformed(evt);
            }
        });
        panelCart.add(btnDeleteCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 600, 200, 60));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Cart Table");
        panelCart.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 30, -1, -1));

        btnEditCart.setBackground(new java.awt.Color(0, 102, 102));
        btnEditCart.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnEditCart.setForeground(new java.awt.Color(255, 255, 255));
        btnEditCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/pen.png"))); // NOI18N
        btnEditCart.setText("Edit Cart");
        btnEditCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCartActionPerformed(evt);
            }
        });
        panelCart.add(btnEditCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 600, 200, 60));

        lblCurrent2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblCurrent2.setForeground(new java.awt.Color(0, 102, 102));
        panelCart.add(lblCurrent2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 610, -1, 30));

        panelProfile.setBackground(new java.awt.Color(255, 255, 255));
        panelProfile.setMinimumSize(new java.awt.Dimension(1200, 700));
        panelProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        placeholder.setForeground(new java.awt.Color(255, 255, 255));
        placeholder.setText("Profile");
        panelProfile.add(placeholder, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 680, -1, -1));

        txtUsername.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(153, 153, 153));
        txtUsername.setText("Type your username here");
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        panelProfile.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 70, 250, 40));

        lblUsername2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblUsername2.setText("Username : ");
        panelProfile.add(lblUsername2, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 50, -1, -1));

        txtFullname.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtFullname.setForeground(new java.awt.Color(153, 153, 153));
        txtFullname.setText("Type your full name here");
        txtFullname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtFullname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFullnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFullnameFocusLost(evt);
            }
        });
        panelProfile.add(txtFullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 150, 250, 40));

        lblFullName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblFullName.setText("Full Name :");
        panelProfile.add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 130, -1, -1));

        lblAlamat.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblAlamat.setText("Address :");
        panelProfile.add(lblAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 210, -1, -1));

        txtAddress.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(153, 153, 153));
        txtAddress.setText("Type your address here");
        txtAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAddressFocusLost(evt);
            }
        });
        panelProfile.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 230, 250, 40));

        txtPhoneNumber.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPhoneNumber.setForeground(new java.awt.Color(153, 153, 153));
        txtPhoneNumber.setText("Type your phone number here");
        txtPhoneNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtPhoneNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhoneNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhoneNumberFocusLost(evt);
            }
        });
        panelProfile.add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 310, 250, 40));

        lblPhoneNumber.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPhoneNumber.setText("Phone Number :");
        panelProfile.add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 290, -1, -1));

        lblPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPassword.setText("Password :");
        panelProfile.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 370, 76, -1));

        txtPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtPassword.setText("Type your password here");
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtPassword.setEchoChar('\u0000');
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        panelProfile.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 390, 250, 40));

        cbPassword.setBackground(new java.awt.Color(255, 255, 255));
        cbPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbPassword.setText("Show Password");
        cbPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPasswordActionPerformed(evt);
            }
        });
        panelProfile.add(cbPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 440, 260, -1));

        lblConfirmPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblConfirmPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblConfirmPassword.setText("Confirm Password :");
        panelProfile.add(lblConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 490, 130, -1));

        txtConfirmPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtConfirmPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtConfirmPassword.setText("Confirm your password here");
        txtConfirmPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtConfirmPassword.setEchoChar('\u0000');
        txtConfirmPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtConfirmPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConfirmPasswordFocusLost(evt);
            }
        });
        panelProfile.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 510, 250, 40));

        cbConfirmPassword.setBackground(new java.awt.Color(255, 255, 255));
        cbConfirmPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbConfirmPassword.setText("Show Password");
        cbConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConfirmPasswordActionPerformed(evt);
            }
        });
        panelProfile.add(cbConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 560, 250, -1));

        btnUpdate.setBackground(new java.awt.Color(0, 102, 102));
        btnUpdate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Save Profile");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        panelProfile.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 610, 300, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        panelProfile.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 400, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));
        panelProfile.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 680, 400, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelProfile.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 5, 650));

        jSeparator4.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelProfile.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 10, 650));

        panelShop.setBackground(new java.awt.Color(255, 255, 255));
        panelShop.setMinimumSize(new java.awt.Dimension(1200, 700));
        panelShop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTambahCart.setBackground(new java.awt.Color(0, 102, 102));
        btnTambahCart.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnTambahCart.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/resize/add-to-cart (1).png"))); // NOI18N
        btnTambahCart.setText("Add to Cart");
        btnTambahCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahCartActionPerformed(evt);
            }
        });
        panelShop.add(btnTambahCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 610, 250, 60));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Shop");
        panelShop.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 680, -1, -1));

        txtJumlah.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        txtJumlah.setForeground(new java.awt.Color(153, 153, 153));
        txtJumlah.setText("Type how much you wanna buy here");
        txtJumlah.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtJumlah.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJumlahFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJumlahFocusLost(evt);
            }
        });
        panelShop.add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 500, 40));

        lblUsername3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblUsername3.setText("Product Quantity :");
        panelShop.add(lblUsername3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        tabelBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        tabelBarang.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelBarang.setRowHeight(40);
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelBarang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelShop.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1130, 450));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setText("Current Selected Product : ");
        panelShop.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        lblCurrent.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblCurrent.setForeground(new java.awt.Color(0, 102, 102));
        panelShop.add(lblCurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Product Table");
        panelShop.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 30, -1, -1));

        panelInvoice.setBackground(new java.awt.Color(255, 255, 255));
        panelInvoice.setMinimumSize(new java.awt.Dimension(1200, 700));
        panelInvoice.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Shop");
        panelInvoice.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 680, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        tabelInvoice.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        tabelInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelInvoice.setRowHeight(30);
        jScrollPane1.setViewportView(tabelInvoice);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelInvoice.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1130, 590));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Transaction Table");
        panelInvoice.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 30, -1, -1));

        jLayeredPane1.setLayer(panelHome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelCart, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelProfile, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelShop, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelInvoice, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelShop, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(panelProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(panelShop, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelHeader, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInvoiceMouseClicked
        visual("invoice");
        loadTransaksi();
    }//GEN-LAST:event_lblInvoiceMouseClicked

    private void lblCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCartMouseClicked
        visual("cart");
        loadCart();
    }//GEN-LAST:event_lblCartMouseClicked

    private void lblShopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShopMouseClicked
        visual("shop");
        loadBarang();
    }//GEN-LAST:event_lblShopMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        int opsi = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION) {
            new LoginPage().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblHeaderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHeaderMouseClicked
        visual("home");
        lblWelcome.setText("Welcome to PartsHub "+user.getFull_name());
    }//GEN-LAST:event_lblHeaderMouseClicked

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        if(txtUsername.getText().equals("Type your username here")){
            txtUsername.setText("");
            txtUsername.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        if(txtUsername.getText().equals("")){
            txtUsername.setText("Type your username here");
            txtUsername.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtFullnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFullnameFocusGained
        if(txtFullname.getText().equals("Type your full name here")){
            txtFullname.setText("");
            txtFullname.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtFullnameFocusGained

    private void txtFullnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFullnameFocusLost
        if(txtFullname.getText().equals("")){
            txtFullname.setText("Type your full name here");
            txtFullname.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtFullnameFocusLost

    private void txtAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusGained
        if(txtAddress.getText().equals("Type your address here")){
            txtAddress.setText("");
            txtAddress.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtAddressFocusGained

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
        if(txtAddress.getText().equals("")){
            txtAddress.setText("Type your address here");
            txtAddress.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtAddressFocusLost

    private void txtPhoneNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneNumberFocusGained
        if(txtPhoneNumber.getText().equals("Type your phone number here")){
            txtPhoneNumber.setText("");
            txtPhoneNumber.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtPhoneNumberFocusGained

    private void txtPhoneNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneNumberFocusLost
        if(txtPhoneNumber.getText().equals("")){
            txtPhoneNumber.setText("Type your phone number here");
            txtPhoneNumber.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtPhoneNumberFocusLost

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        if((String.valueOf(txtPassword.getPassword())).equals("Type your password here")){
            txtPassword.setEchoChar('*');
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        if((String.valueOf(txtPassword.getPassword())).equals("")){
            txtPassword.setEchoChar((char)0);
            txtPassword.setText("Type your password here");
            txtPassword.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void cbPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPasswordActionPerformed
        if(getFocusOwner()==txtPassword){
            if(cbPassword.isSelected()){
                txtPassword.setEchoChar((char)0);
            }else{
                txtPassword.setEchoChar('*');
            }
        }else if(!(String.valueOf(txtPassword.getPassword())).equals("Type your password here")){
            if(cbPassword.isSelected()){
                txtPassword.setEchoChar((char)0);
            }else{
                txtPassword.setEchoChar('*');
            }
        }
    }//GEN-LAST:event_cbPasswordActionPerformed

    private void txtConfirmPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmPasswordFocusGained
        if((String.valueOf(txtConfirmPassword.getPassword())).equals("Confirm your password here")){
            txtConfirmPassword.setEchoChar('*');
            txtConfirmPassword.setText("");
            txtConfirmPassword.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtConfirmPasswordFocusGained

    private void txtConfirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmPasswordFocusLost
        if((String.valueOf(txtConfirmPassword.getPassword())).equals("")){
            txtConfirmPassword.setEchoChar((char)0);
            txtConfirmPassword.setText("Confirm your password here");
            txtConfirmPassword.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtConfirmPasswordFocusLost

    private void cbConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConfirmPasswordActionPerformed
        if(getFocusOwner()==txtConfirmPassword){
            if(cbConfirmPassword.isSelected()){
                txtConfirmPassword.setEchoChar((char)0);
            }else{
                txtConfirmPassword.setEchoChar('*');
            }
        }else if(!(String.valueOf(txtConfirmPassword.getPassword())).equals("Confirm your password here")){
            if(cbConfirmPassword.isSelected()){
                txtConfirmPassword.setEchoChar((char)0);
            }else{
                txtConfirmPassword.setEchoChar('*');
            }
        }
    }//GEN-LAST:event_cbConfirmPasswordActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int id = this.user.getId();
        String username = txtUsername.getText();
        String full_name = txtFullname.getText();
        String address = txtAddress.getText();
        String phone_number = txtPhoneNumber.getText();
        String password = String.valueOf(txtPassword.getPassword());
        String confirm_password = String.valueOf(txtConfirmPassword.getPassword());

        if ((!password.equals("Type your password here")) && (!confirm_password.equals("Confirm your password here")) && !password.equals(confirm_password)) {
            JOptionPane.showMessageDialog(this, "Password doesn't match!!", "Error", JOptionPane.ERROR_MESSAGE);
            txtConfirmPassword.setEchoChar((char)0);
            txtConfirmPassword.setText("Confirm your password here");
            txtConfirmPassword.setForeground(new Color(153, 153, 153));
        } else if ((username.equals("Type your username here")) || (full_name.equals("Type your full name here"))
            || (address.equals("Type your address here")) || (phone_number.equals("Type your phone number here"))
            || (password.equals("Type your password here")) || (confirm_password.equals("Confirm your password here"))) {
            JOptionPane.showMessageDialog(this, "Please fill in all the required fields!!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            UserModel updateUser = new UserModel(id, username, full_name, address, phone_number, password);
            hasil = conUser.updateUser(updateUser);
            switch (hasil) {
                case 1:
                    this.user = updateUser;
                    JOptionPane.showMessageDialog(this, "Profile Successfuly Updated!!");
                    break;
                case -1:
                    JOptionPane.showMessageDialog(this, "Username has already been used", "Error", JOptionPane.ERROR_MESSAGE);
                    txtUsername.setText("Type your username here");
                    txtUsername.setForeground(new Color(153, 153, 153));
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Profile's failed to be updated", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void lblProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfileMouseClicked
        visual("profil");
        txtUsername.setText(this.user.getUsername());
        txtFullname.setText(this.user.getFull_name());
        txtAddress.setText(this.user.getAddress());
        txtPhoneNumber.setText(this.user.getPhone_number());
        txtPassword.setText(this.user.getPassword());
        txtPassword.setEchoChar('*');
        txtUsername.setForeground(Color.black);
        txtFullname.setForeground(Color.black);
        txtAddress.setForeground(Color.black);
        txtPhoneNumber.setForeground(Color.black);
        txtPassword.setForeground(Color.black);
    }//GEN-LAST:event_lblProfileMouseClicked

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        int row = tabelBarang.getSelectedRow();
        int id_barang = Integer.parseInt(tabelBarang.getValueAt(row, 0).toString());
        this.brED = conBar.getId(id_barang);
        lblCurrent.setText(brED.getNama_barang());
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void btnTambahCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahCartActionPerformed
        if(this.brED == null){
            JOptionPane.showMessageDialog(this, "You have to choose a product from the table before you can add to cart!!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if(txtJumlah.getText().equals("Type how much you wanna buy here")) {
            JOptionPane.showMessageDialog(this, "Please fill in how much you wanna buy first!!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if(this.brED.getStok_barang() < Integer.parseInt(txtJumlah.getText())) {
            JOptionPane.showMessageDialog(this, "Not enough product in stock", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int id_user = this.user.getId();
            int id_b = this.brED.getId_barang();
            JenisBarangModel jenis_b = conJBarang.getId(this.brED.getId_jenisbarang());
            String nama_jb = jenis_b.getNama_jenisbarang();
            int harga_b = this.brED.getHarga_barang();
            int jumlah_b = Integer.parseInt(txtJumlah.getText());
            int total = harga_b * jumlah_b;

            CartModel cart = new CartModel(id_user, id_b, nama_jb, harga_b, jumlah_b, total);
            CartModel cek = conCart.getId(id_user, id_b);
            if(cek == null){
                hasil = conCart.saveCart(cart);
                switch (hasil) {
                    case 1:
                        JOptionPane.showMessageDialog(this, "Data succesfully added to cart");
                        loadCart();
                        txtJumlah.setText("Type how much you wanna buy here");
                        txtJumlah.setForeground(new Color(153,153,153));
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Data failed to be added to cart", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }else{
                hasil = conCart.tambahCart(cek, jumlah_b+cek.getJumlah(), (jumlah_b+cek.getJumlah())*harga_b);
                switch (hasil) {
                    case 1:
                        JOptionPane.showMessageDialog(this, "Because there's already the same product in cart, the product quantity will be updated");
                        loadCart();
                        txtJumlah.setText("Type how much you wanna buy here");
                        txtJumlah.setForeground(new Color(153,153,153));
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Data failed to be added to cart", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        }
    }//GEN-LAST:event_btnTambahCartActionPerformed

    private void txtJumlahFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJumlahFocusGained
        if(txtJumlah.getText().equals("Type how much you wanna buy here")){
            txtJumlah.setText("");
            txtJumlah.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtJumlahFocusGained

    private void txtJumlahFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJumlahFocusLost
        if(txtJumlah.getText().equals("")){
            txtJumlah.setText("Type how much you wanna buy here");
            txtJumlah.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtJumlahFocusLost

    private void tabelCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelCartMouseClicked
        int row = tabelCart.getSelectedRow();
        int id_barang = Integer.parseInt(tabelCart.getValueAt(row, 0).toString());
        this.cartED = conCart.getId(this.user.getId(), id_barang);
        BarangModel barang = conBar.getId(id_barang);
        lblCurrent1.setText(barang.getId_barang()+"."+barang.getNama_barang());
    }//GEN-LAST:event_tabelCartMouseClicked

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        if(this.cartED == null){
            JOptionPane.showMessageDialog(this, "You have to choose a data from the table before you can checkout!!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int id_transaksi = 0;
            int id_user = this.cartED.getId_user();
            int id_b = this.cartED.getId_barang();
            int jumlah_b = this.cartED.getJumlah();
            int total = this.cartED.getTotal();
            LocalDateTime currentTime = LocalDateTime.now();
            BarangModel barang = conBar.getId(this.cartED.getId_barang());
            
            if (cartED.getJumlah() > barang.getStok_barang()) {
                JOptionPane.showMessageDialog(this, "Not enough product in stock. Please wait for restock. Thank you for your patience.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                 TransaksiModel trns = new TransaksiModel(id_transaksi, id_user, id_b, jumlah_b, total, currentTime);
                hasil = conTrans.saveTransaksi(trns);
                switch (hasil) {
                    case 1:
                        conCart.deleteCart(this.cartED.getId_user(), this.cartED.getId_barang());
                        loadCart();
                        JOptionPane.showMessageDialog(this, "Thank you for your order! Your checkout was successful.");
                        conBar.kurangStock(barang, barang.getStok_barang() - this.cartED.getJumlah());
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Failed to checkout!", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        }
    }//GEN-LAST:event_btnCheckoutActionPerformed

    private void btnDeleteCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCartActionPerformed
        if(this.cartED == null){
            JOptionPane.showMessageDialog(this, "You have to choose a data from the table before you can delete the cart!!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            BarangModel barang = conBar.getId(this.cartED.getId_barang());
            int opsi = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+barang.getNama_barang()+" from cart?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION) {
                hasil = conCart.deleteCart(this.cartED.getId_user(), this.cartED.getId_barang());
                if (hasil>=1){
                    JOptionPane.showMessageDialog(this, "Cart Successfuly Deleted!!");
                    loadCart();
                } else {
                    JOptionPane.showMessageDialog(this, "Cart failed to be deleted", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnDeleteCartActionPerformed

    private void btnEditCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCartActionPerformed
        if(this.cartED == null){
            JOptionPane.showMessageDialog(this, "You have to choose a data from the table before you can edit the cart!!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            String input = JOptionPane.showInputDialog("Change how much you wanna buy : ");
            int jumlah = Integer.parseInt(input);
            BarangModel barang = conBar.getId(this.cartED.getId_barang());
            int total = jumlah * barang.getHarga_barang();
            hasil = conCart.tambahCart(this.cartED, jumlah, total);
            if (hasil>=1){
                JOptionPane.showMessageDialog(this, "Cart Successfuly Updated!!");
                this.cartED = conCart.getId(this.user.getId(), cartED.getId_barang());
                loadCart();
            } else {
                JOptionPane.showMessageDialog(this, "Cart failed to be updated", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditCartActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnDeleteCart;
    private javax.swing.JButton btnEditCart;
    private javax.swing.JButton btnTambahCart;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox cbConfirmPassword;
    private javax.swing.JCheckBox cbPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblBawah;
    private javax.swing.JLabel lblCart;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblCurrent;
    private javax.swing.JLabel lblCurrent1;
    private javax.swing.JLabel lblCurrent2;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblInvoice;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblShop;
    private javax.swing.JLabel lblUsername2;
    private javax.swing.JLabel lblUsername3;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel panelCart;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelInvoice;
    private javax.swing.JPanel panelProfile;
    private javax.swing.JPanel panelShop;
    private javax.swing.JLabel placeholder;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTable tabelCart;
    private javax.swing.JTable tabelInvoice;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
