package View;

import Controller.ControllerUser;
import Models.UserModel;
import java.awt.Color;
import javax.swing.JOptionPane;

public class LoginPage extends javax.swing.JFrame {
    private final ControllerUser conUser= new ControllerUser();
    private int hasil = 0;

    public LoginPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPassword = new javax.swing.JLabel();
        imgPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        garis = new javax.swing.JLabel();
        lblUsername2 = new javax.swing.JLabel();
        garis1 = new javax.swing.JLabel();
        imgUser = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        cbPassword = new javax.swing.JCheckBox();
        linkRegister = new javax.swing.JLabel();
        linkRegister1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        imgBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(600, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPassword.setText("Password :");
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 225, 76, -1));

        imgPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/padlock.png"))); // NOI18N
        jPanel1.add(imgPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 260, -1, 20));

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
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 160, 210, 40));

        garis.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        garis.setText("____");
        jPanel1.add(garis, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 270, 60, 20));

        lblUsername2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblUsername2.setText("Username : ");
        jPanel1.add(lblUsername2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 135, -1, -1));

        garis1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        garis1.setText("__________");
        jPanel1.add(garis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 181, 60, 20));

        imgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login2.png"))); // NOI18N
        jPanel1.add(imgUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 170, -1, 20));

        btnLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnLogin.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnLoginFocusLost(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, 250, 40));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PartsHub");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 200, -1));

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
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 250, 210, 40));

        cbPassword.setBackground(new java.awt.Color(255, 255, 255));
        cbPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbPassword.setText("Show Password");
        cbPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(cbPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 300, 250, -1));

        linkRegister.setBackground(new java.awt.Color(255, 255, 255));
        linkRegister.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        linkRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linkRegister.setText("<html><u>Here</u></html>");
        linkRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linkRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linkRegisterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                linkRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                linkRegisterMouseExited(evt);
            }
        });
        jPanel1.add(linkRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 410, 40, -1));

        linkRegister1.setBackground(new java.awt.Color(255, 255, 255));
        linkRegister1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        linkRegister1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linkRegister1.setText("Click Here to Register");
        jPanel1.add(linkRegister1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 410, 250, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Don't have an account?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 390, 250, -1));

        lblStatus.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 0, 0));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 400, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(100, 101, 400, 500);

        imgBackground.setIcon(new javax.swing.ImageIcon("C:\\ARIQ\\KULIAH\\SEMESTER 4\\IFB-202 Pemrograman Berorientasi Objek\\PRAKTIKUM\\P1\\PartsHub\\src\\icon\\trianglify-lowres.png")); // NOI18N
        imgBackground.setMinimumSize(new java.awt.Dimension(600, 700));
        getContentPane().add(imgBackground);
        imgBackground.setBounds(0, 0, 600, 700);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        if(txtUsername.getText().equals("Type your username here")){
            lblStatus.setText("");
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

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        if((String.valueOf(txtPassword.getPassword())).equals("Type your password here")){
            lblStatus.setText("");
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

    private void linkRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkRegisterMouseClicked
        new RegistrationPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_linkRegisterMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        Connection.ConnectionManager conman = new Connection.ConnectionManager();
        int cek = conman.checkConnection();
        if (cek == 0){
            JOptionPane.showMessageDialog(this, "Please connect to the provided database first!!\nIts located at default packages on src", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());

            if(password.equals("Type your password here")  && username.equals("Type your username here")){
                lblStatus.setText("Username and Password must be filled!!");
            } else if (password.equals("Type your password here")) {
                lblStatus.setText("Password must be filled!!");
            } else if (username.equals("Type your username here")) {
                lblStatus.setText("Username must be filled!!");
            } else if (username.equals("admin")  && password.equals("admin")) {
                JOptionPane.showMessageDialog(this, "Welcome, admin!!", "Info", JOptionPane.INFORMATION_MESSAGE);
                new AdminPage().setVisible(true);
                this.dispose();
            } else {
                UserModel cekLogin = new UserModel();
                cekLogin.setUsername(username);
                cekLogin.setPassword(password);

                hasil = conUser.Login(cekLogin);

                switch (hasil) {
                    case 1:
                        JOptionPane.showMessageDialog(this, "Welcome, " + cekLogin.getFull_name(), "Info", JOptionPane.INFORMATION_MESSAGE);
                        new UserPage(cekLogin).setVisible(true);
                        this.dispose();
                        break;
                    case -1:
                        lblStatus.setText("Wrong password, try again");
                        txtPassword.setEchoChar((char)0);
                        txtPassword.setText("Type your password here");
                        txtPassword.setForeground(new Color(153, 153, 153));
                        break;
                    default:
                        lblStatus.setText("Account not found");
                        txtUsername.setText("Type your username here");
                        txtUsername.setForeground(new Color(153, 153, 153));
                        txtPassword.setEchoChar((char)0);
                        txtPassword.setText("Type your password here");
                        txtPassword.setForeground(new Color(153, 153, 153));
                        break;
                }
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnLoginFocusLost
        lblStatus.setText("");
    }//GEN-LAST:event_btnLoginFocusLost

    private void linkRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkRegisterMouseEntered
        linkRegister.setForeground(new Color(0,153,153));
    }//GEN-LAST:event_linkRegisterMouseEntered

    private void linkRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkRegisterMouseExited
        linkRegister.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_linkRegisterMouseExited

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox cbPassword;
    private javax.swing.JLabel garis;
    private javax.swing.JLabel garis1;
    private javax.swing.JLabel imgBackground;
    private javax.swing.JLabel imgPassword;
    private javax.swing.JLabel imgUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUsername2;
    private javax.swing.JLabel linkRegister;
    private javax.swing.JLabel linkRegister1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
