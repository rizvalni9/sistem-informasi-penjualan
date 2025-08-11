package form;

import config.rootdb;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class frlog extends javax.swing.JFrame{
    private rootdb con = new rootdb();
    private ResultSet result;
    
    private void clear(){
        txtid.setText("USERNAME");
        txtpass.setText("PASSWORD");
    }
    
    private void cekPerusahaan(){
        try{
            result = con.adapter.executeQuery("SELECT * FROM comiden");
            if(result.first()){
                new frlog().setVisible(true);
            }else{
                int sp = JOptionPane.showConfirmDialog(this, "SELAMAT DATANG DI SISTEM INFORMASI PENJUALAN...\n\n"
                                                            +"Terima kasih telah menggunakan aplikasi ini\n"
                                                            +"Apakah anda ingin menamai perusahaan anda ?","NEWER COMPANY?", JOptionPane.YES_NO_OPTION);
                if(sp==JOptionPane.YES_OPTION){
                    frlogcomA dialog = new frlogcomA(new javax.swing.JFrame(), true);
                    dialog.setVisible(true);
                }else{
                   new frlog().setVisible(true); 
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public frlog() {
        con.root();
        initComponents();
        lbackground.requestFocus();
        hide.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        lbext = new javax.swing.JLabel();
        lbmnz = new javax.swing.JLabel();
        lbtitle = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        show = new javax.swing.JLabel();
        hide = new javax.swing.JLabel();
        lbusr = new javax.swing.JLabel();
        lbpass = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        lbpictitle = new javax.swing.JLabel();
        lbtext = new javax.swing.JLabel();
        lbclickreg = new javax.swing.JLabel();
        btnlog = new javax.swing.JButton();
        lbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(51, 156, 215));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        lbext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbextMouseClicked(evt);
            }
        });
        header.add(lbext, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 0, -1, -1));

        lbmnz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize.png"))); // NOI18N
        lbmnz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbmnzMouseClicked(evt);
            }
        });
        header.add(lbmnz, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 0, -1, 30));

        lbtitle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lbtitle.setText("LOGIN");
        header.add(lbtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 60, 20));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, -1));

        body.setBackground(new java.awt.Color(69, 158, 150));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/show.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        body.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hide.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideMouseClicked(evt);
            }
        });
        body.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        lbusr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/personacc.png"))); // NOI18N
        body.add(lbusr, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 74, -1, 40));

        lbpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lock.png"))); // NOI18N
        body.add(lbpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 130, -1, 40));

        txtid.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtid.setText("USERNAME");
        txtid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtidFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtidFocusLost(evt);
            }
        });
        body.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 74, 195, 40));

        txtpass.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpass.setText("PASSWORD");
        txtpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpassFocusLost(evt);
            }
        });
        body.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 130, 195, 40));

        lbpictitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icontitle.png"))); // NOI18N
        body.add(lbpictitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        lbtext.setText("Jika belum punya akun silahkan klik.");
        body.add(lbtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        lbclickreg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbclickreg.setText("Daftar");
        lbclickreg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbclickregMouseClicked(evt);
            }
        });
        body.add(lbclickreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        btnlog.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnlog.setText("LOG IN");
        btnlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogActionPerformed(evt);
            }
        });
        body.add(btnlog, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 230, 40));

        lbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.jpg"))); // NOI18N
        lbackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbackgroundMouseClicked(evt);
            }
        });
        body.add(lbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, -1));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 264));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbextMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lbextMouseClicked

    private void lbmnzMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbmnzMouseClicked
        this.setState(this.ICONIFIED);                             
    }//GEN-LAST:event_lbmnzMouseClicked

    private void txtidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidFocusGained
        if(txtid.getText().equals("USERNAME")){
            txtid.setText("");
        }
    }//GEN-LAST:event_txtidFocusGained

    private void txtidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidFocusLost
        if(txtid.getText().equals("")){
            txtid.setText("USERNAME");
        }
    }//GEN-LAST:event_txtidFocusLost

    private void btnlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogActionPerformed
        if(txtid.getText().equals("USERNAME") || txtpass.getText().equals("PASSWORD")){
            JOptionPane.showMessageDialog(this, "USERNAME DAN PASSWORD MASIH KOSONG !","CAUTION",JOptionPane.WARNING_MESSAGE);
        }else{
            try{
                result = con.adapter.executeQuery("SELECT * FROM person WHERE id = '"+txtid.getText()+"' OR pass = '"+txtpass.getText()+"'");
                if(result.next()){
                    if(!txtid.getText().equals(result.getString("id"))){
                        JOptionPane.showMessageDialog(this,"USERNAME ANDA SALAH !","CAUTION",JOptionPane.WARNING_MESSAGE);
                        txtid.setText("");
                        txtid.requestFocus();
                    }else if(!txtpass.getText().equals(result.getString("pass"))){
                        JOptionPane.showMessageDialog(this,"PASSWORD ANDA SALAH !","CAUTION",JOptionPane.WARNING_MESSAGE);
                        txtpass.setText("");
                        txtpass.requestFocus();
                    }else{
                        new frmenu(result.getString("level"),result.getString("panggilan")).show();
                        this.dispose();
                    }
                }else{
                    JOptionPane.showMessageDialog(this,"USERNAME DAN PASSWORD TIDAK DITEMUKAN !","INFO",JOptionPane.INFORMATION_MESSAGE);
                    clear();
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(this,"DATABASE TIDAK TERKONEKSI !!!","ERROR",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }//GEN-LAST:event_btnlogActionPerformed

    private void lbclickregMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbclickregMouseClicked
        this.dispose();
        new frmregA().show();
    }//GEN-LAST:event_lbclickregMouseClicked

    private void txtpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassFocusGained
        if(txtpass.getText().equals("PASSWORD")){
            txtpass.setText("");
        }
    }//GEN-LAST:event_txtpassFocusGained

    private void txtpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassFocusLost
        if(txtpass.getText().equals("")){
            txtpass.setText("PASSWORD");
        }        
    }//GEN-LAST:event_txtpassFocusLost

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        show.setVisible(false);
        hide.setVisible(true);
        txtpass.setEchoChar((char)0);
    }//GEN-LAST:event_showMouseClicked

    private void hideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseClicked
        show.setVisible(true);
        hide.setVisible(false);
        txtpass.setEchoChar('*');
    }//GEN-LAST:event_hideMouseClicked

    private void lbackgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbackgroundMouseClicked
        lbackground.requestFocus();
    }//GEN-LAST:event_lbackgroundMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(frlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frlog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frlog().cekPerusahaan();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btnlog;
    private javax.swing.JPanel header;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel lbackground;
    private javax.swing.JLabel lbclickreg;
    private javax.swing.JLabel lbext;
    private javax.swing.JLabel lbmnz;
    private javax.swing.JLabel lbpass;
    private javax.swing.JLabel lbpictitle;
    private javax.swing.JLabel lbtext;
    private javax.swing.JLabel lbtitle;
    private javax.swing.JLabel lbusr;
    private javax.swing.JLabel show;
    private javax.swing.JTextField txtid;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
