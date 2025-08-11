package form;

import config.rootdb;
import java.awt.Dimension;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;

import javax.swing.JOptionPane;

public class frlogcomB extends javax.swing.JDialog {
    
    private rootdb con = new rootdb();
    private JFileChooser slFile = new JFileChooser();
    private File selectedFile;
    private FileNameExtensionFilter ekstensi = new FileNameExtensionFilter("IMAGES", "jpg","png","ico");
    private ResultSet rs;
    private PreparedStatement st;
    private byte [] imgconvert;
    
    private void centerFrm(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2,(screenSize.height - frameSize.height) / 2);
    }
    
    private void cekData(){
        try{
            rs = con.adapter.executeQuery("SELECT * FROM comiden");
            if(rs.first()){
                nmComp.setText(rs.getString(1));
                altComp.setText(rs.getString(2));
                phComp.setText(rs.getString(3));
                imgconvert = rs.getBytes("image");
                BufferedImage file = ImageIO.read(new ByteArrayInputStream(imgconvert));
                ImageIcon preGambar = new ImageIcon(file);
                Image resfitGambar = preGambar.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                ImageIcon fixGambar = new ImageIcon(resfitGambar);
                lbPicture.setIcon(fixGambar);
                lbHolNam.setText(null);
                lbHolAdd.setText(null);
                lbPhone.setText(null);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public frlogcomB(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        con.root();
        initComponents();
        cekData();
        centerFrm();
        body.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        lbtitle = new javax.swing.JLabel();
        lbext = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        lbHolNam = new javax.swing.JLabel();
        nmComp = new javax.swing.JTextField();
        lbHolAdd = new javax.swing.JLabel();
        altComp = new javax.swing.JTextField();
        lbPicture = new javax.swing.JLabel();
        pathFile = new javax.swing.JTextField();
        lbPhone = new javax.swing.JLabel();
        phComp = new javax.swing.JTextField();
        btnChoice = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(51, 156, 215));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbtitle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lbtitle.setText("PROFILE SET COMPANY");
        lbtitle.setPreferredSize(new java.awt.Dimension(81, 25));
        header.add(lbtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 30));

        lbext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        lbext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbextMouseClicked(evt);
            }
        });
        header.add(lbext, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, -1));

        body.setBackground(new java.awt.Color(204, 204, 255));
        body.setPreferredSize(new java.awt.Dimension(350, 153));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbHolNam.setForeground(new java.awt.Color(204, 204, 204));
        lbHolNam.setText("Company Name...");
        body.add(lbHolNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 225, 30));

        nmComp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nmCompKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nmCompKeyTyped(evt);
            }
        });
        body.add(nmComp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 30));

        lbHolAdd.setForeground(new java.awt.Color(204, 204, 204));
        lbHolAdd.setText("Company Address...");
        body.add(lbHolAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 225, 30));

        altComp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                altCompKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                altCompKeyTyped(evt);
            }
        });
        body.add(altComp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 230, 30));

        lbPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        body.add(lbPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 80, 80));

        pathFile.setEditable(false);
        body.add(pathFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 230, 30));

        lbPhone.setForeground(new java.awt.Color(204, 204, 204));
        lbPhone.setText("Company Phone...");
        body.add(lbPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, 225, 30));

        phComp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phCompKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phCompKeyTyped(evt);
            }
        });
        body.add(phComp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 230, 30));

        btnChoice.setText("Select...");
        btnChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoiceActionPerformed(evt);
            }
        });
        body.add(btnChoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 110, -1, -1));

        btnSave.setText("TERAPKAN");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        body.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 230, -1));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 340, 205));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoiceActionPerformed
       int pilGambar = slFile.showOpenDialog(null);
       slFile.addChoosableFileFilter(ekstensi);
       if(pilGambar == JFileChooser.APPROVE_OPTION){
           selectedFile = slFile.getSelectedFile();
           String jlGambar = selectedFile.getAbsolutePath();
           pathFile.setText(String.valueOf(jlGambar));
           ImageIcon preGambar = new ImageIcon(jlGambar);
           Image resfitGambar = preGambar.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
           ImageIcon fixGambar = new ImageIcon(resfitGambar);
           lbPicture.setIcon(fixGambar);
       }
    }//GEN-LAST:event_btnChoiceActionPerformed

    private void nmCompKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nmCompKeyTyped
        if(lbHolNam.getText().equals("Company Name...")){
            lbHolNam.setText("");
        }else if(nmComp.getText().isEmpty()){
            lbHolNam.setText("Company Name...");
        }
    }//GEN-LAST:event_nmCompKeyTyped

    private void altCompKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altCompKeyTyped
        if(lbHolAdd.getText().equals("Company Address...")){
            lbHolAdd.setText("");
        }else if(altComp.getText().isEmpty()){
            lbHolAdd.setText("Company Address...");
        }
    }//GEN-LAST:event_altCompKeyTyped

    private void nmCompKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nmCompKeyPressed
        int keyTyped = evt.getKeyCode();
        if(keyTyped==8){
            lbHolNam.setText("");
        }
    }//GEN-LAST:event_nmCompKeyPressed

    private void altCompKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_altCompKeyPressed
        int keyTyped = evt.getKeyCode();
        if(keyTyped==8){
            lbHolAdd.setText("");
        }
    }//GEN-LAST:event_altCompKeyPressed

    private void phCompKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phCompKeyTyped
        char keys = evt.getKeyChar();
        int cek = phComp.getText().length();
        if(cek>=0 && cek<=13){
            if(!Character.isDigit(keys)){
                evt.consume();
                lbPhone.setText("");
            }
            if(lbPhone.getText().equals("Company Phone...")){
                lbPhone.setText("");
            }else if(phComp.getText().isEmpty()){
                lbPhone.setText("Company Phone...");
            }
        }else if(cek>=13){
            if(Character.isDigit(keys) || !Character.isDigit(keys)){
                evt.consume();
            }
        }
    }//GEN-LAST:event_phCompKeyTyped

    private void phCompKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phCompKeyPressed
        int keyTyped = evt.getKeyCode();
        if(keyTyped==8){
            lbPhone.setText("");
        }
    }//GEN-LAST:event_phCompKeyPressed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(nmComp.getText().equals("") || altComp.getText().equals("") || phComp.getText().equals("") || pathFile.getText().equals("")){
            JOptionPane.showMessageDialog(this, "FORM MASIH KOSONG SILAHKAN LENGKAPI !","WARNING",JOptionPane.WARNING_MESSAGE);
        }else{
            try{
                FileInputStream fin = new FileInputStream(selectedFile);
                int len = (int) selectedFile.length();
                Class.forName("com.mysql.jdbc.Driver");
                Connection jembatan = (Connection) con.ctrldb.getConnection("jdbc:mysql://localhost/db02_23si11","root","");
                
                rs = con.adapter.executeQuery("SELECT * FROM comiden");
                if(rs.first()){
                    int sp = JOptionPane.showConfirmDialog(this, "APAKAH ANDA YAKIN MENERAPKAN PERUBAHAN DATA INI ?","QUESTION", JOptionPane.YES_NO_OPTION);
                    if(sp==JOptionPane.YES_OPTION){
                        st = jembatan.prepareStatement("UPDATE comiden SET company=?,address=?,phone=?,image=?");
                        st.setString(1, nmComp.getText());
                        st.setString(2, altComp.getText());
                        st.setString(3, phComp.getText());
                        st.setBinaryStream(4, fin, len);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(this, "DATA BERHASIL DIPERBAHARUI !","INFO",JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    st = jembatan.prepareStatement("INSERT INTO comiden VALUES (?,?,?,?)");
                    st.setString(1, nmComp.getText());
                    st.setString(2, altComp.getText());
                    st.setString(3, phComp.getText());
                    st.setBinaryStream(4, fin, len);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(this, "DATA BERHASIL DITERAPKAN !","INFO",JOptionPane.INFORMATION_MESSAGE);
                }
            }catch (Exception e){
               JOptionPane.showMessageDialog(this, "DATA TIDAK TERSIMPAN !!!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void lbextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbextMouseClicked
        this.dispose();
    }//GEN-LAST:event_lbextMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frlogcomB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frlogcomB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frlogcomB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frlogcomB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frlogcomB dialog = new frlogcomB(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField altComp;
    private javax.swing.JPanel body;
    private javax.swing.JButton btnChoice;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lbHolAdd;
    private javax.swing.JLabel lbHolNam;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbPicture;
    private javax.swing.JLabel lbext;
    private javax.swing.JLabel lbtitle;
    private javax.swing.JTextField nmComp;
    private javax.swing.JTextField pathFile;
    private javax.swing.JTextField phComp;
    // End of variables declaration//GEN-END:variables
}
