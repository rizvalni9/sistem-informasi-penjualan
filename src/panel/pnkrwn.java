package panel;

import config.rootdb;
import form.frmregB;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class pnkrwn extends javax.swing.JPanel {
    
    private rootdb con = new rootdb(); 
    private ResultSet rs;
    private DefaultTableModel dtm;
    private String jdlTable [] = {"Nama","Panggilan","Kelamin","Domilisi","Email"};
    
    private void tableTampil(){
        DefaultTableModel dtm = new DefaultTableModel(null,jdlTable);
        showData.setModel(dtm);
        try{
            rs=con.adapter.executeQuery("SELECT nama,panggilan,Kelamin,tmp_lr,email FROM person");
            while(rs.next()){ 
                Object [] rows = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
                dtm.addRow(rows);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"GAGAL TAMPIL");
        }
    }
    
    public pnkrwn() {
        con.root();
        initComponents();
        txtSearch.setBackground(new java.awt.Color(0,0,0,1));
        tableTampil();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        mnk_content = new javax.swing.JPanel();
        pn_listKrwn = new javax.swing.JPanel();
        lb_jdlKrwn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showData = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        };
        txtSearch = new javax.swing.JTextField();
        lb_logo = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setLayout(new java.awt.CardLayout());

        mnk_content.setLayout(new java.awt.CardLayout());

        pn_listKrwn.setBackground(new java.awt.Color(204, 204, 204));
        pn_listKrwn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_listKrwnMouseClicked(evt);
            }
        });

        lb_jdlKrwn.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lb_jdlKrwn.setText("DATA KARYAWAN");

        showData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(showData);

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSearch.setText("Cari Karyawan...");
        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lb_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N

        btnAdd.setBackground(new java.awt.Color(51, 102, 255));
        btnAdd.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnAdd.setText("TAMBAH");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(51, 102, 255));
        btnDel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnDel.setForeground(new java.awt.Color(255, 255, 255));
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDel.setText("HAPUS");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_listKrwnLayout = new javax.swing.GroupLayout(pn_listKrwn);
        pn_listKrwn.setLayout(pn_listKrwnLayout);
        pn_listKrwnLayout.setHorizontalGroup(
            pn_listKrwnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_listKrwnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_listKrwnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addGroup(pn_listKrwnLayout.createSequentialGroup()
                        .addGroup(pn_listKrwnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pn_listKrwnLayout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addComponent(lb_jdlKrwn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_logo)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pn_listKrwnLayout.setVerticalGroup(
            pn_listKrwnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_listKrwnLayout.createSequentialGroup()
                .addGroup(pn_listKrwnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_listKrwnLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_jdlKrwn))
                    .addGroup(pn_listKrwnLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_listKrwnLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lb_logo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_listKrwnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );

        mnk_content.add(pn_listKrwn, "card2");

        add(mnk_content, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new frmregB(null,true).show();
        tableTampil();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        dtm = (DefaultTableModel)showData.getModel();
        int row = showData.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(this, "PILIH KARYAWAN DAHULU !!","CAUTION",JOptionPane.WARNING_MESSAGE);
        }else if(row>=0){
            String nama = dtm.getValueAt(row, 1).toString();
            int message = JOptionPane.showConfirmDialog(this, "APAKAH ANDA YAKIN MENGHAPUS KARYAWAN INI ?","QUESTION", JOptionPane.YES_NO_OPTION);
            if(message==JOptionPane.YES_OPTION){
                try{
                    con.adapter.executeUpdate("DELETE FROM person WHERE panggilan = '"+nama+"'");
                    JOptionPane.showMessageDialog(this, "DATA BERHASIL DIHAPUS !","INFO",JOptionPane.INFORMATION_MESSAGE);
                    tableTampil();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(this, "DATA TIDAK TERHAPUS !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                
            }else{
                showData.clearSelection();
            }
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if(txtSearch.getText().equals("Cari Karyawan...")){
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if(txtSearch.getText().equals("")){
            txtSearch.setText("Cari Karyawan...");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void pn_listKrwnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_listKrwnMouseClicked
        this.requestFocus();
        showData.clearSelection();
    }//GEN-LAST:event_pn_listKrwnMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try{
            dtm = new DefaultTableModel(null,jdlTable);
            showData.setModel(dtm);
            rs=con.adapter.executeQuery("SELECT nama,panggilan,Kelamin,tmp_lr,email FROM person WHERE nama LIKE '%"+txtSearch.getText()+"%' OR panggilan LIKE '%"+txtSearch.getText()+"%'");
            while(rs.next()){
                Object [] rows = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
                dtm.addRow(rows);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "GAGAL TAMPIL !!!", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_jdlKrwn;
    private javax.swing.JLabel lb_logo;
    private javax.swing.JPanel mnk_content;
    private javax.swing.JPanel pn_listKrwn;
    private javax.swing.JTable showData;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
