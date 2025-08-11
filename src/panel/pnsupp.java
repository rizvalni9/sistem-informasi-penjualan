package panel;

import config.rootdb;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;//Fungsi kelas ListSelectionModel fungsi/kegunaanyo untuak ma'agiah pilihan bantuak data yang diseleksi (single/mutliple/interval_multiple). 
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class pnsupp extends javax.swing.JPanel {
    
    private rootdb con = new rootdb(); 
    private ResultSet rs;
    private DefaultTableModel dtm;
    private DefaultListModel list = new DefaultListModel();
    private DefaultTableCellRenderer Tengah = new DefaultTableCellRenderer();
    private String jdlTable [] = {"ID Supplier","Nama","Alamat","No.Telp"};
    private Date sekarang = new Date();
    private SimpleDateFormat tgl = new SimpleDateFormat("yyMMdd");
    
    private void autoKd(){
        try{
            rs=con.adapter.executeQuery("SELECT * FROM supplier ORDER BY id_supp DESC");
            if(rs.next()){
                String kdsp = rs.getString("id_supp").substring(8);
                int nosp = (Integer.valueOf(kdsp)+1);
                txtKdsupp.setText("S" + tgl.format(sekarang) + "N" +nosp);
            }else{
                txtKdsupp.setText("S" + tgl.format(sekarang) + "N1");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "KODE SUPPLIER GAGAL TAMPIL !!!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void tableTampil(){
        DefaultTableModel dtm = new DefaultTableModel(null,jdlTable);
        showData.setModel(dtm);
        try{
            rs=con.adapter.executeQuery("SELECT * FROM supplier");
            while(rs.next()){ 
                Object [] rows = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                dtm.addRow(rows);
            }
            Tengah.setHorizontalAlignment(SwingConstants.CENTER);
            showData.getColumnModel().getColumn(0).setCellRenderer(Tengah);
            showData.getColumnModel().getColumn(3).setCellRenderer(Tengah);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"GAGAL TAMPIL","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void clear(){
        txtKdsupp.setText("");
        txtNmsupp.setText("");
        txtAltsupp.setText("");
        txtNosupp.setText("");
        txtTypebrg.setText("");
        list.removeAllElements();
        txtNmsupp.setEnabled(true);
        txtAltsupp.setEnabled(true);
        txtNosupp.setEnabled(true);
        txtTypebrg.setEnabled(true);
    }
    
    private void cbxKd(){
        boxKdsupp.addItem("--------PILIH SALAH SATU KODE--------");
        try{
            rs = con.adapter.executeQuery("SELECT * FROM supplier");
            while(rs.next()){
                boxKdsupp.addItem(rs.getString("id_supp"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"GAGAL TAMPIL !!!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public pnsupp() {
        con.root();
        initComponents();
        txtSearch.setBackground(new java.awt.Color(0,0,0,1));
        tableTampil();
        cbxKd();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        mns_content = new javax.swing.JPanel();
        pn_listSupp = new javax.swing.JPanel();
        lb_jdlList = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        showData = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        };
        txtSearch = new javax.swing.JTextField();
        lb_logo = new javax.swing.JLabel();
        manageBtn = new javax.swing.JButton();
        pn_addSupp = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        lb_jdlAdd = new javax.swing.JLabel();
        lb_kdsupp = new javax.swing.JLabel();
        lb_nmsupp = new javax.swing.JLabel();
        lb_brand = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_hrgp = new javax.swing.JLabel();
        txtKdsupp = new javax.swing.JTextField();
        txtNmsupp = new javax.swing.JTextField();
        txtNosupp = new javax.swing.JTextField();
        txtAltsupp = new javax.swing.JTextField();
        txtTypebrg = new javax.swing.JTextField();
        clearBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listType = new javax.swing.JList<>();
        boxKdsupp = new javax.swing.JComboBox<>();

        jLabel1.setText("jLabel1");

        setLayout(new java.awt.CardLayout());

        mns_content.setLayout(new java.awt.CardLayout());

        pn_listSupp.setBackground(new java.awt.Color(204, 204, 204));
        pn_listSupp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_listSuppMouseClicked(evt);
            }
        });

        lb_jdlList.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lb_jdlList.setText("TABEL DAFTAR SUPPLIER");

        showData.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
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
        jScrollPane.setViewportView(showData);

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSearch.setText("Cari Supplier...");
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

        manageBtn.setBackground(new java.awt.Color(51, 102, 255));
        manageBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        manageBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/management.png"))); // NOI18N
        manageBtn.setText("KELOLA DATA SUPPLIER");
        manageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_listSuppLayout = new javax.swing.GroupLayout(pn_listSupp);
        pn_listSupp.setLayout(pn_listSuppLayout);
        pn_listSuppLayout.setHorizontalGroup(
            pn_listSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_listSuppLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_listSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_listSuppLayout.createSequentialGroup()
                        .addComponent(lb_jdlList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(lb_logo)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(manageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_listSuppLayout.setVerticalGroup(
            pn_listSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_listSuppLayout.createSequentialGroup()
                .addGroup(pn_listSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_listSuppLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_jdlList))
                    .addGroup(pn_listSuppLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_listSuppLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lb_logo)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mns_content.add(pn_listSupp, "card2");

        pn_addSupp.setBackground(new java.awt.Color(204, 204, 204));

        backBtn.setBackground(new java.awt.Color(51, 102, 255));
        backBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/view.png"))); // NOI18N
        backBtn.setText("KEMBALI");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(51, 102, 255));
        addBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        addBtn.setText("TAMBAH");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        delBtn.setBackground(new java.awt.Color(51, 102, 255));
        delBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        delBtn.setForeground(new java.awt.Color(255, 255, 255));
        delBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        delBtn.setText("HAPUS");
        delBtn.setEnabled(false);
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        lb_jdlAdd.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lb_jdlAdd.setText("KELOLA DATA SUPPLIER");

        lb_kdsupp.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_kdsupp.setText("Kode Supplier");

        lb_nmsupp.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_nmsupp.setText("Nama");

        lb_brand.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_brand.setText("Alamat");

        lb_name.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_name.setText("No. Telepon");

        lb_hrgp.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_hrgp.setText("Jenis Barang");

        txtKdsupp.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtKdsupp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtKdsupp.setEnabled(false);

        txtNmsupp.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtNmsupp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNmsuppKeyReleased(evt);
            }
        });

        txtNosupp.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtNosupp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNosuppKeyTyped(evt);
            }
        });

        txtAltsupp.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N

        txtTypebrg.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtTypebrg.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTypebrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTypebrgKeyPressed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(51, 102, 255));
        clearBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/erase.png"))); // NOI18N
        clearBtn.setText("BERSIHKAN");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        listType.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listType.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        listType.setVisibleRowCount(7);
        listType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listTypeKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(listType);

        boxKdsupp.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        boxKdsupp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxKdsuppItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pn_addSuppLayout = new javax.swing.GroupLayout(pn_addSupp);
        pn_addSupp.setLayout(pn_addSuppLayout);
        pn_addSuppLayout.setHorizontalGroup(
            pn_addSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_addSuppLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pn_addSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_addSuppLayout.createSequentialGroup()
                        .addGroup(pn_addSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_addSuppLayout.createSequentialGroup()
                                .addComponent(lb_jdlAdd)
                                .addGap(0, 259, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_addSuppLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_addSuppLayout.createSequentialGroup()
                                .addGroup(pn_addSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_nmsupp)
                                    .addComponent(lb_brand)
                                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKdsupp, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addComponent(boxKdsupp, 0, 338, Short.MAX_VALUE))
                            .addGroup(pn_addSuppLayout.createSequentialGroup()
                                .addGroup(pn_addSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_name)
                                    .addComponent(lb_hrgp)
                                    .addGroup(pn_addSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtTypebrg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(lb_kdsupp, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNosupp, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))
                    .addGroup(pn_addSuppLayout.createSequentialGroup()
                        .addComponent(txtNmsupp)
                        .addContainerGap())))
            .addGroup(pn_addSuppLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_addSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAltsupp))
                .addContainerGap())
        );
        pn_addSuppLayout.setVerticalGroup(
            pn_addSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_addSuppLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lb_jdlAdd)
                .addGap(12, 12, 12)
                .addGroup(pn_addSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(lb_kdsupp)
                .addGap(12, 12, 12)
                .addGroup(pn_addSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKdsupp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxKdsupp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(lb_nmsupp)
                .addGap(12, 12, 12)
                .addComponent(txtNmsupp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lb_brand)
                .addGroup(pn_addSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_addSuppLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtAltsupp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lb_name)
                        .addGap(12, 12, 12)
                        .addComponent(txtNosupp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lb_hrgp)
                        .addGap(12, 12, 12)
                        .addComponent(txtTypebrg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_addSuppLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mns_content.add(pn_addSupp, "card2");

        add(mns_content, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if(txtSearch.getText().equals("Cari Supplier...")){
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if(txtSearch.getText().equals("")||txtSearch.getText().equals("Cari Supplier...")){
            txtSearch.setText("Cari Supplier...");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try{
            dtm = new DefaultTableModel(null,jdlTable);
            showData.setModel(dtm);
            rs=con.adapter.executeQuery("SELECT * FROM supplier WHERE nm_supp LIKE '%"+txtSearch.getText()+"%'");
            while(rs.next()){
                Object [] row = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                dtm.addRow(row);
            }
            Tengah.setHorizontalAlignment(SwingConstants.CENTER);
            showData.getColumnModel().getColumn(0).setCellRenderer(Tengah);
            showData.getColumnModel().getColumn(3).setCellRenderer(Tengah);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "GAGAL TAMPIL !!!", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void manageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageBtnActionPerformed
        mns_content.removeAll();
        mns_content.add(pn_addSupp);
        mns_content.repaint();
        mns_content.revalidate();
        txtNmsupp.requestFocus();
    }//GEN-LAST:event_manageBtnActionPerformed

    private void pn_listSuppMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_listSuppMouseClicked
        this.requestFocus();
        showData.clearSelection();
    }//GEN-LAST:event_pn_listSuppMouseClicked

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        clear();
        boxKdsupp.removeAllItems();
        cbxKd();
        addBtn.setVisible(true);
        delBtn.setEnabled(false);
        txtNmsupp.setEnabled(true);
        mns_content.removeAll();
        mns_content.add(pn_listSupp);
        mns_content.repaint();
        mns_content.revalidate();
    }//GEN-LAST:event_backBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        if(txtKdsupp.getText().equals("")||txtNmsupp.getText().equals("")||txtAltsupp.getText().equals("")||txtNosupp.getText().equals("")){
            JOptionPane.showMessageDialog(this, "PASTIKAN SEMUA TERISI !!","CAUTION",JOptionPane.WARNING_MESSAGE);
        }else{
            int sp = JOptionPane.showConfirmDialog(this, "APAKAH ANDA YAKIN MENYIMPAN DATA INI ?","QUESTION", JOptionPane.YES_NO_OPTION);
            if(sp==JOptionPane.YES_OPTION){
                try{
                    con.adapter.executeUpdate("INSERT INTO supplier VALUES ('"+txtKdsupp.getText()+"','"+txtNmsupp.getText()+"',"
                        +"'"+txtAltsupp.getText()+"','"+txtNosupp.getText()+"')");
                    for(int i=0;i<list.getSize();i++){
                        con.adapter.executeUpdate("INSERT INTO tyitem VALUES ('"+txtKdsupp.getText()+"','"+list.get(i)+"')");
                    }
                    JOptionPane.showMessageDialog(this, "DATA BERHASIL DISIMPAN !","INFO",JOptionPane.INFORMATION_MESSAGE);
                    clear();
                    txtNmsupp.requestFocus();
                    boxKdsupp.removeAllItems();
                    cbxKd();
                    tableTampil();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "DATA TIDAK TERSIMPAN !!!","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        int sp = JOptionPane.showConfirmDialog(this, "APAKAH ANDA YAKIN MENGHAPUS DATA INI ?", "QUESTION", JOptionPane.YES_NO_OPTION);
        if(sp==JOptionPane.YES_OPTION){
            try{
                con.adapter.executeUpdate("DELETE FROM supplier WHERE id_supp ='"+boxKdsupp.getSelectedItem()+"'");
                
                con.adapter.executeUpdate("DELETE FROM tyitem WHERE id_supp ='"+boxKdsupp.getSelectedItem()+"'");
                JOptionPane.showMessageDialog(this, "DATA BERHASIL DIHAPUS !","INFO",JOptionPane.INFORMATION_MESSAGE);
                clear();
                boxKdsupp.removeAllItems();
                cbxKd();
                tableTampil();
                addBtn.setVisible(true);
                delBtn.setEnabled(false);
                txtNmsupp.setEnabled(true);
            }catch (Exception e){
                JOptionPane.showMessageDialog(this, "DATA TIDAK TERHAPUS !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_delBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        clear();
        boxKdsupp.removeAllItems();
        cbxKd();
        addBtn.setVisible(true);
        delBtn.setEnabled(false);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void txtTypebrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTypebrgKeyPressed
        int press = evt.getKeyCode();
        if(press==10){
            if(txtTypebrg.getText().equals("")){
                evt.consume();
            }else{
                list.addElement(txtTypebrg.getText());
                txtTypebrg.setText("");
                listType.setModel(list);
            }
        }
    }//GEN-LAST:event_txtTypebrgKeyPressed

    private void listTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listTypeKeyPressed
        int press = evt.getKeyCode();
        if(press==127){//Angko 127 adolah kode tombol fungsi keyboard 'DELETE'
            int remove = listType.getSelectedIndex();
            if(listType.getSelectedIndex()==-1){
                txtTypebrg.requestFocus();
            }else{
                list.removeElementAt(remove);
                listType.requestFocus();
                listType.setSelectedIndex(remove-1);
                if(listType.isSelectionEmpty()){
                    listType.setSelectedIndex(0);
                }
            }
        }
    }//GEN-LAST:event_listTypeKeyPressed

    private void txtNosuppKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNosuppKeyTyped
        char press = evt.getKeyChar();
        if(!Character.isDigit(press)){
            evt.consume();
        }
    }//GEN-LAST:event_txtNosuppKeyTyped

    private void boxKdsuppItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxKdsuppItemStateChanged
        try{
            rs=con.adapter.executeQuery("SELECT * FROM supplier WHERE id_supp ='"+boxKdsupp.getSelectedItem()+"'");
            if(rs.next()){
                addBtn.setVisible(false);
                delBtn.setEnabled(true);
                listType.setEnabled(false);
                txtKdsupp.setText(rs.getString("id_supp"));
                txtNmsupp.setText(rs.getString("nm_supp"));
                txtAltsupp.setText(rs.getString("adrs_supp"));
                txtNosupp.setText(rs.getString("nuphn_supp"));
                txtNmsupp.setEnabled(false);
                txtAltsupp.setEnabled(false);
                txtNosupp.setEnabled(false);
                txtTypebrg.setEnabled(false);
            }else{
                addBtn.setVisible(true);
                delBtn.setEnabled(false);
                listType.setEnabled(true);
                clear();
                autoKd();
            }
            
            list.removeAllElements();
            rs=con.adapter.executeQuery("SELECT * FROM tyitem WHERE id_supp ='"+boxKdsupp.getSelectedItem()+"'");
            while(rs.next()){
                list.addElement(rs.getString("type_brg"));
            }
            listType.setModel(list);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"GAGAL TAMPIL !!!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_boxKdsuppItemStateChanged

    private void txtNmsuppKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNmsuppKeyReleased
        int press = evt.getKeyCode();
        if(press==10){
            txtAltsupp.requestFocus();
        }
        
        if(press==9){
            evt.consume();
        }
    }//GEN-LAST:event_txtNmsuppKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> boxKdsupp;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton delBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_brand;
    private javax.swing.JLabel lb_hrgp;
    private javax.swing.JLabel lb_jdlAdd;
    private javax.swing.JLabel lb_jdlList;
    private javax.swing.JLabel lb_kdsupp;
    private javax.swing.JLabel lb_logo;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_nmsupp;
    private javax.swing.JList<String> listType;
    private javax.swing.JButton manageBtn;
    private javax.swing.JPanel mns_content;
    private javax.swing.JPanel pn_addSupp;
    private javax.swing.JPanel pn_listSupp;
    private javax.swing.JTable showData;
    private javax.swing.JTextField txtAltsupp;
    private javax.swing.JTextField txtKdsupp;
    private javax.swing.JTextField txtNmsupp;
    private javax.swing.JTextField txtNosupp;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTypebrg;
    // End of variables declaration//GEN-END:variables
}
