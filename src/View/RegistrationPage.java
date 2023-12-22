package View;

import Controller.ControllerUser;
import Models.UserModel;
import java.awt.Color;
import javax.swing.JOptionPane;

public class RegistrationPage extends javax.swing.JFrame {
    private final ControllerUser conUser = new ControllerUser();
    private int hasil = 0;
    
    public RegistrationPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblUsername2 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        cbPassword = new javax.swing.JCheckBox();
        linkLogin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        linkRegister1 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        lblFullName = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        lblConfirmPassword = new javax.swing.JLabel();
        cbConfirmPassword = new javax.swing.JCheckBox();
        lblAlamat = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        imgBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(600, 840));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPassword.setText("Password :");
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 420, 76, -1));

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
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 120, 250, 40));

        lblUsername2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblUsername2.setText("Username : ");
        jPanel1.add(lblUsername2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 100, -1, -1));

        btnRegister.setBackground(new java.awt.Color(0, 0, 0));
        btnRegister.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 640, 300, 40));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign Up");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 200, -1));

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
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 440, 250, 40));

        cbPassword.setBackground(new java.awt.Color(255, 255, 255));
        cbPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbPassword.setText("Show Password");
        cbPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(cbPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 485, 260, -1));

        linkLogin.setBackground(new java.awt.Color(255, 255, 255));
        linkLogin.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        linkLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linkLogin.setText("<html><u>Here</u></html>");
        linkLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        linkLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linkLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                linkLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                linkLoginMouseExited(evt);
            }
        });
        jPanel1.add(linkLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 710, 40, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Already have an account?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 400, -1));

        linkRegister1.setBackground(new java.awt.Color(255, 255, 255));
        linkRegister1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        linkRegister1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linkRegister1.setText("Click Here to Login");
        jPanel1.add(linkRegister1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 710, 400, -1));

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
        jPanel1.add(txtFullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 200, 250, 40));

        lblFullName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblFullName.setText("Full Name :");
        jPanel1.add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 180, -1, -1));

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
        jPanel1.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 545, 250, 40));

        lblConfirmPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblConfirmPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblConfirmPassword.setText("Confirm Password :");
        jPanel1.add(lblConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 525, 130, -1));

        cbConfirmPassword.setBackground(new java.awt.Color(255, 255, 255));
        cbConfirmPassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbConfirmPassword.setText("Show Password");
        cbConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConfirmPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(cbConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 590, 250, -1));

        lblAlamat.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblAlamat.setText("Address :");
        jPanel1.add(lblAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 260, -1, -1));

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
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 280, 250, 40));

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
        jPanel1.add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 360, 250, 40));

        lblPhoneNumber.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblPhoneNumber.setText("Phone Number :");
        jPanel1.add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(100, 25, 400, 750);

        imgBackground.setIcon(new javax.swing.ImageIcon("C:\\ARIQ\\KULIAH\\SEMESTER 4\\IFB-202 Pemrograman Berorientasi Objek\\PRAKTIKUM\\P1\\PartsHub\\src\\icon\\Register.png")); // NOI18N
        getContentPane().add(imgBackground);
        imgBackground.setBounds(0, 0, 600, 800);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void linkLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkLoginMouseClicked
        new LoginPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_linkLoginMouseClicked

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        Connection.ConnectionManager conman = new Connection.ConnectionManager();
        int cek = conman.checkConnection();
        if (cek == 0) {
            JOptionPane.showMessageDialog(this, "Please connect to the provided database first!!\nIts located at default packages on src", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = 0;
            String username = txtUsername.getText();
            String full_name = txtFullname.getText();
            String address = txtAddress.getText();
            String phone_number = txtPhoneNumber.getText();
            String password = String.valueOf(txtPassword.getPassword());
            String confirm_password = String.valueOf(txtConfirmPassword.getPassword());

            if ((!password.equals("Type your password here")) && (!confirm_password.equals("Confirm your password here")) && !password.equals(confirm_password)) {
                JOptionPane.showMessageDialog(this, "Password Doesn't Match!!", "Error", JOptionPane.ERROR_MESSAGE);
                txtConfirmPassword.setEchoChar((char)0);
                txtConfirmPassword.setText("Confirm your password here");
                txtConfirmPassword.setForeground(new Color(153, 153, 153));
            } else if ((username.equals("Type your username here")) || (full_name.equals("Type your full name here"))
                    || (address.equals("Type your address here")) || (phone_number.equals("Type your phone number here"))
                    || (password.equals("Type your password here")) || (confirm_password.equals("Confirm your password here"))) {
                JOptionPane.showMessageDialog(this, "Please fill in all the required fields!!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                UserModel user = new UserModel(id, username, full_name, address, phone_number, password);
                hasil = conUser.saveUser(user);
                switch (hasil) {
                    case 1:
                        JOptionPane.showMessageDialog(this, "Account succesfully created, moving to login page");
                        new LoginPage().setVisible(true);
                        this.dispose();
                        break;
                    case -1:
                        JOptionPane.showMessageDialog(this, "Username has already been used", "Error", JOptionPane.ERROR_MESSAGE);
                        txtUsername.setText("Type your username here");
                        txtUsername.setForeground(new Color(153, 153, 153));
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Account's failed to be created", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

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

    private void linkLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkLoginMouseEntered
        linkLogin.setForeground(new Color(0,153,153));
    }//GEN-LAST:event_linkLoginMouseEntered

    private void linkLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkLoginMouseExited
        linkLogin.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_linkLoginMouseExited
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JCheckBox cbConfirmPassword;
    private javax.swing.JCheckBox cbPassword;
    private javax.swing.JLabel imgBackground;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblUsername2;
    private javax.swing.JLabel linkLogin;
    private javax.swing.JLabel linkRegister1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
