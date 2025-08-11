package panel;

import config.rootdb;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.NumberFormatter;
                                        
public class pndata extends javax.swing.JPanel {
    private rootdb con = new rootdb();
    private DefaultTableModel dtm;
    private DefaultListModel dlm;
    private ResultSet rs;
    private String Supp,Type,Nmbrg,kdSupp;
    private long Hrgbrg,Hrgj;
    private int Qty;
    private double HrgbrgKR;
    private String [] jdlTable ={"Kode Barang","Tipe Persediaan Barang","Nama / Merek dan Tipe Barang","Jumlah Barang (Qty)","Harga (Rp)"};
    private DefaultTableCellRenderer Tengah = new DefaultTableCellRenderer();
    private DefaultTableCellRenderer Kanan = new DefaultTableCellRenderer();
    private DecimalFormat koma = new DecimalFormat("#,##,###");
    private DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    private DecimalFormatSymbols RpIndo = new DecimalFormatSymbols();
    
    private void boxsTampil(){
        cbxSupp.addItem("----------PILIH SALAH SATU NAMA SUPPLIER----------");
        try{
            rs = con.adapter.executeQuery("SELECT * FROM supplier");
            while(rs.next()){
                cbxSupp.addItem(rs.getString("nm_supp"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"NAMA SUPPLIER GAGAL TAMPIL !!!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
    private void clear(){
        cbxSupp.removeAllItems();
        boxsTampil();
        cbxType.removeAllItems();
        txtKdbrg.setText("");
        txtNmbrg.setText("");
        txtHrgbrg.setText("");
        txtQty.setText("");
        discBrg.setText("");
        txtHrgj.setText("Rp. 0.00");
        Supp=null;Type=null;Nmbrg=null;Hrgbrg=0;Qty=0;Hrgj=0;
    }
    private void listTampil(){
        dlm = new DefaultListModel();
        showList.setModel(dlm);
        try{
            rs=con.adapter.executeQuery("SELECT kdbrg FROM data");
            while(rs.next()){
                Object reg = rs.getString(1);
                dlm.addElement(reg);
            }
        }catch(Exception e){
            e.getMessage();
        }
        
    }
    private void tableTampil(){
        dtm = new DefaultTableModel(null,jdlTable);
        showData.setModel(dtm);
        double HrgjTB;
        try{
            rs=con.adapter.executeQuery("SELECT kdbrg,tybrg,nmbrg,qty,sell FROM data");
            while(rs.next()){
                HrgjTB = Double.parseDouble(rs.getString(5));
                Object [] row = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),koma.format(HrgjTB)};
                dtm.addRow(row);
            }
            Tengah.setHorizontalAlignment(SwingConstants.CENTER);
            Kanan.setHorizontalAlignment(SwingConstants.RIGHT);
            showData.getColumnModel().getColumn(0).setCellRenderer(Tengah);
            showData.getColumnModel().getColumn(3).setCellRenderer(Tengah);
            showData.getColumnModel().getColumn(4).setCellRenderer(Kanan);
        }catch(Exception e){
            e.getMessage();
        }
        
    }
    
    public pndata() {
        con.root();
        initComponents();
        txtSearch.setBackground(new java.awt.Color(0,0,0,1));
        boxsTampil();
        tableTampil();
        listTampil();

        RpIndo.setCurrencySymbol("Rp. ");
        RpIndo.setMonetaryDecimalSeparator('.');
        RpIndo.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(RpIndo);
        
        txtHrgj.setText("Rp. 0.00");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnd_content = new javax.swing.JPanel();
        pn_listBrg = new javax.swing.JPanel();
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
        pn_addBrg = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        updBtn = new javax.swing.JButton();
        lb_jdlAdd = new javax.swing.JLabel();
        lb_supp = new javax.swing.JLabel();
        lb_kdbrg = new javax.swing.JLabel();
        lb_listkdbrg = new javax.swing.JLabel();
        lb_brand = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_hrgp = new javax.swing.JLabel();
        lb_hrgj = new javax.swing.JLabel();
        lb_qty = new javax.swing.JLabel();
        lb_percent = new javax.swing.JLabel();
        lb_note = new javax.swing.JLabel();
        txtKdbrg = new javax.swing.JTextField();
        txtNmbrg = new javax.swing.JTextField();
        txtHrgbrg = new javax.swing.JTextField();
        txtHrgj = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        showList = new javax.swing.JList<>();
        clearBtn = new javax.swing.JButton();
        discBrg = new javax.swing.JTextField();
        cbxSupp = new javax.swing.JComboBox<>();
        cbxType = new javax.swing.JComboBox<>();

        setLayout(new java.awt.CardLayout());

        mnd_content.setBackground(new java.awt.Color(204, 204, 204));
        mnd_content.setLayout(new java.awt.CardLayout());

        pn_listBrg.setBackground(new java.awt.Color(204, 204, 204));
        pn_listBrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_listBrgMouseClicked(evt);
            }
        });

        lb_jdlList.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lb_jdlList.setText("TABEL DAFTAR BARANG");

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
        txtSearch.setText("Cari Data...");
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
        manageBtn.setText("KELOLA DATA BARANG");
        manageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_listBrgLayout = new javax.swing.GroupLayout(pn_listBrg);
        pn_listBrg.setLayout(pn_listBrgLayout);
        pn_listBrgLayout.setHorizontalGroup(
            pn_listBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_listBrgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_listBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_listBrgLayout.createSequentialGroup()
                        .addComponent(lb_jdlList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(lb_logo)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(manageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_listBrgLayout.setVerticalGroup(
            pn_listBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_listBrgLayout.createSequentialGroup()
                .addGroup(pn_listBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_listBrgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_jdlList))
                    .addGroup(pn_listBrgLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_listBrgLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lb_logo)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mnd_content.add(pn_listBrg, "card2");

        pn_addBrg.setBackground(new java.awt.Color(204, 204, 204));

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

        updBtn.setBackground(new java.awt.Color(51, 102, 255));
        updBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        updBtn.setForeground(new java.awt.Color(255, 255, 255));
        updBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        updBtn.setText("PERBAHARUI");
        updBtn.setEnabled(false);
        updBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updBtnActionPerformed(evt);
            }
        });

        lb_jdlAdd.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lb_jdlAdd.setText("KELOLA BARANG");

        lb_supp.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_supp.setText("Nama Supplier");

        lb_kdbrg.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_kdbrg.setText("Kode Barang");

        lb_listkdbrg.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_listkdbrg.setText("Daftar Kode Barang");

        lb_brand.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_brand.setText("Tipe Persediaan Barang");

        lb_name.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_name.setText("Nama dan Tipe Barang");

        lb_hrgp.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_hrgp.setText("Harga Beli (Satuan)");

        lb_hrgj.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_hrgj.setText("Harga Jual (Satuan)");

        lb_qty.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_qty.setText("Quatity");

        lb_percent.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lb_percent.setText("Persentase");

        lb_note.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        lb_note.setForeground(new java.awt.Color(255, 0, 51));
        lb_note.setText("* CATATAN : Harga jual berdasarkan persentase yang diberikan");

        txtKdbrg.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N

        txtNmbrg.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N

        txtHrgbrg.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtHrgbrg.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtHrgbrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHrgbrgKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHrgbrgKeyTyped(evt);
            }
        });

        txtHrgj.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtHrgj.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtHrgj.setEnabled(false);

        txtQty.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        txtQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtyKeyTyped(evt);
            }
        });

        showList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        showList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        showList.setVisibleRowCount(18);
        showList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(showList);

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

        discBrg.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        discBrg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        discBrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discBrgKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                discBrgKeyTyped(evt);
            }
        });

        cbxSupp.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        cbxSupp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxSuppItemStateChanged(evt);
            }
        });

        cbxType.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        cbxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbxType.setEnabled(false);

        javax.swing.GroupLayout pn_addBrgLayout = new javax.swing.GroupLayout(pn_addBrg);
        pn_addBrg.setLayout(pn_addBrgLayout);
        pn_addBrgLayout.setHorizontalGroup(
            pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_addBrgLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_addBrgLayout.createSequentialGroup()
                        .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHrgj, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtKdbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_addBrgLayout.createSequentialGroup()
                                    .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lb_hrgp)
                                        .addComponent(txtHrgbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb_supp)
                                        .addComponent(lb_brand)
                                        .addComponent(lb_name)
                                        .addComponent(lb_hrgj))
                                    .addGap(75, 75, 75)
                                    .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lb_percent)
                                        .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb_qty)
                                        .addComponent(discBrg, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_addBrgLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pn_addBrgLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updBtn))))
                    .addGroup(pn_addBrgLayout.createSequentialGroup()
                        .addComponent(lb_kdbrg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_listkdbrg))
                    .addGroup(pn_addBrgLayout.createSequentialGroup()
                        .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_note, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_jdlAdd))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_addBrgLayout.setVerticalGroup(
            pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_addBrgLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lb_jdlAdd)
                .addGap(12, 12, 12)
                .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_kdbrg)
                    .addComponent(lb_listkdbrg))
                .addGap(12, 12, 12)
                .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_addBrgLayout.createSequentialGroup()
                        .addComponent(txtKdbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(lb_supp)
                        .addGap(12, 12, 12)
                        .addComponent(cbxSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lb_brand)
                        .addGap(18, 18, 18)
                        .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lb_name)
                        .addGap(12, 12, 12)
                        .addComponent(txtNmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_hrgp)
                            .addComponent(lb_qty))
                        .addGap(12, 12, 12)
                        .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHrgbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_hrgj)
                            .addComponent(lb_percent))
                        .addGap(13, 13, 13)
                        .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_addBrgLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(pn_addBrgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHrgj, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(discBrg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addComponent(lb_note))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        mnd_content.add(pn_addBrg, "card2");

        add(mnd_content, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void manageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageBtnActionPerformed
        mnd_content.removeAll();
        mnd_content.add(pn_addBrg);
        mnd_content.repaint();
        mnd_content.revalidate();
    }//GEN-LAST:event_manageBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        clear();
        showList.setSelectedValue(null, false);
        addBtn.setVisible(true);
        delBtn.setEnabled(false);
        updBtn.setEnabled(false);
        txtKdbrg.setEnabled(true);
        mnd_content.removeAll();
        mnd_content.add(pn_listBrg);
        mnd_content.repaint();
        mnd_content.revalidate();
    }//GEN-LAST:event_backBtnActionPerformed

    private void txtHrgbrgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHrgbrgKeyTyped
        char typed = evt.getKeyChar();
        int cek = txtHrgbrg.getText().length();
        if(cek>=0 && cek<=20){
            if(!Character.isDigit(typed)){
                evt.consume();
            }
        }else if (cek>=20){
            if(Character.isDigit(typed) || !Character.isDigit(typed)){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtHrgbrgKeyTyped

    private void txtQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyTyped
        char typed = evt.getKeyChar();
        if(!Character.isDigit(typed)){
            evt.consume();
        }
    }//GEN-LAST:event_txtQtyKeyTyped

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        if(cbxSupp.getSelectedItem().equals("")||txtKdbrg.getText().equals("")||cbxType.getSelectedItem().equals("")||txtNmbrg.getText().equals("")||
           txtHrgbrg.getText().equals("")||txtQty.getText().equals("")||discBrg.getText().equals("")){
            JOptionPane.showMessageDialog(this, "PASTIKAN SEMUA TERISI !!","CAUTION",JOptionPane.WARNING_MESSAGE);
        }else{
           int sp = JOptionPane.showConfirmDialog(this, "APAKAH ANDA YAKIN MENYIMPAN DATA INI ?","QUESTION", JOptionPane.YES_NO_OPTION);
            if(sp==JOptionPane.YES_OPTION){
                try{
                    con.adapter.executeUpdate("INSERT INTO data VALUES ('"+cbxSupp.getSelectedItem()+"','"+txtKdbrg.getText()+"',"
                                             +"'"+cbxType.getSelectedItem()+"','"+txtNmbrg.getText()+"','"+txtHrgbrg.getText().replace(",", "")+"',"
                                             +"'"+txtQty.getText()+"','"+txtHrgj.getText().replace("Rp. ", "").replace(",", "").replace(".00", "")+"')");
                    JOptionPane.showMessageDialog(this, "DATA BERHASIL DISIMPAN !","INFO",JOptionPane.INFORMATION_MESSAGE);
                    clear();
                    listTampil();
                    tableTampil();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "DATA TIDAK TERSIMPAN !!!","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        // TODO add your handling code here:
        int sp = JOptionPane.showConfirmDialog(this, "APAKAH ANDA YAKIN MENGHAPUS DATA INI ?", "QUESTION", JOptionPane.YES_NO_OPTION);
        if(sp==JOptionPane.YES_OPTION){
            try{
                con.adapter.executeUpdate("DELETE FROM data WHERE kdbrg='"+txtKdbrg.getText()+"'");
                JOptionPane.showMessageDialog(this, "DATA BERHASIL DIHAPUS !","INFO",JOptionPane.INFORMATION_MESSAGE);
                clear();
                listTampil();
                tableTampil();
                addBtn.setVisible(true);
                delBtn.setEnabled(false);
                updBtn.setEnabled(false);
                txtKdbrg.setEnabled(true);
            }catch (Exception e){
                JOptionPane.showMessageDialog(this, "DATA TIDAK TERHAPUS !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_delBtnActionPerformed

    private void updBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updBtnActionPerformed
        if(cbxSupp.getSelectedItem().equals(Supp)&&cbxType.getSelectedItem().equals(Type)&&txtNmbrg.getText().equals(Nmbrg)&&
           txtHrgbrg.getText().replace(",","").equals(String.valueOf(Hrgbrg))&&txtQty.getText().equals(String.valueOf(Qty))&&
           txtHrgj.getText().replace("Rp. ", "").replace(",", "").replace(".00", "").equals(String.valueOf(Hrgj))){
            JOptionPane.showMessageDialog(this, "DATA MASIH SAMA !!!","CAUTION",JOptionPane.WARNING_MESSAGE);
        }else{
            int sp = JOptionPane.showConfirmDialog(this, "APAKAH ANDA YAKIN MEMPERBAHARUI DATA INI ?", "QUESTION",JOptionPane.YES_NO_OPTION);
            if(sp==JOptionPane.YES_OPTION){
                try{
                    con.adapter.executeUpdate("UPDATE data SET nm_supp='"+cbxSupp.getSelectedItem()+"', tybrg='"+cbxType.getSelectedItem()+"', nmbrg='"+txtNmbrg.getText()+"'"
                                             +", price='"+txtHrgbrg.getText().replace(",","")+"', sell='"+txtHrgj.getText().replace("Rp. ", "").replace(",", "").replace(".00", "")+"'"
                                             +", qty='"+txtQty.getText()+"' WHERE kdbrg ='"+txtKdbrg.getText()+"'");
                    JOptionPane.showMessageDialog(this, "DATA TEREDIT !","INFO",JOptionPane.INFORMATION_MESSAGE);
                    clear();
                    listTampil();
                    tableTampil();
                    addBtn.setVisible(true);
                    delBtn.setEnabled(false);
                    updBtn.setEnabled(false);
                    txtKdbrg.setEnabled(true);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "DATA TIDAK TEREDIT !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }  
        }
    }//GEN-LAST:event_updBtnActionPerformed

    private void showListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showListMouseClicked
        try{
            if(showList.getSelectedIndex()==-1){
                showList.requestFocus();
            }else{
                clear();
                rs=con.adapter.executeQuery("SELECT * FROM data WHERE kdbrg='"+showList.getSelectedValue()+"'");
                if(rs.next()){
                    Supp = rs.getString(1);
                    txtKdbrg.setText(rs.getString(2));
                    Type = rs.getString(3);
                    txtNmbrg.setText(rs.getString(4));
                    Hrgbrg = Long.valueOf(rs.getString(5));
                    txtHrgbrg.setText(koma.format(Hrgbrg));                
                    txtQty.setText(rs.getString(6));
                    Hrgj = Long.valueOf(rs.getString(7));
                    txtHrgj.setText(kursIndonesia.format(Hrgj));
                
                    Nmbrg = String.valueOf(txtNmbrg.getText());
                    Qty = Integer.valueOf(txtQty.getText());
                }
                cbxSupp.setSelectedItem(Supp);
                cbxType.setSelectedItem(Type);
                addBtn.setVisible(false);
                delBtn.setEnabled(true);
                updBtn.setEnabled(true);
                txtKdbrg.setEnabled(false);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "DATABASE TIDAK TERKONEKSI !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_showListMouseClicked

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        clear();
        cbxType.removeAllItems();
        cbxType.setEnabled(false);
        showList.setSelectedValue(null,false);
        addBtn.setVisible(true);
        delBtn.setEnabled(false);
        updBtn.setEnabled(false);
        txtKdbrg.setEnabled(true);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void discBrgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discBrgKeyTyped
        char typed = evt.getKeyChar();
        if(!Character.isDigit(typed)){
            evt.consume();
        }
        try{
            byte d = Byte.valueOf(discBrg.getText());
            if(d>10||d==0){
                evt.consume();
            }
        }catch(Exception e){     
        }
    }//GEN-LAST:event_discBrgKeyTyped

    private void txtHrgbrgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHrgbrgKeyReleased
        try{
            HrgbrgKR = Double.parseDouble(txtHrgbrg.getText().replaceAll("\\,",""));
            txtHrgbrg.setText(koma.format(HrgbrgKR));
        }catch(Exception e){
            txtHrgj.setText("Rp. 0.00");
        }
    }//GEN-LAST:event_txtHrgbrgKeyReleased

    private void discBrgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discBrgKeyReleased
        try{
            byte Disc = Byte.valueOf(discBrg.getText());
            long HrgbrgD = Long.valueOf(txtHrgbrg.getText().replace(",", ""));
            long c =((HrgbrgD*Disc)/100)+HrgbrgD;
            txtHrgj.setText(kursIndonesia.format(c));
        }catch (Exception e){
            txtHrgj.setText("Rp. 0.00");
        }
    }//GEN-LAST:event_discBrgKeyReleased

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if(txtSearch.getText().equals("Cari Data...")){
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if(txtSearch.getText().equals("")||txtSearch.getText().equals("Cari Data...")){
            txtSearch.setText("Cari Data...");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try{
            dtm = new DefaultTableModel(null,jdlTable);
            showData.setModel(dtm);
            double HrgjTBS;
            rs=con.adapter.executeQuery("SELECT kdbrg,tybrg,nmbrg,qty,sell FROM data WHERE nmbrg LIKE '%"+txtSearch.getText()+"%' OR tybrg LIKE '%"+txtSearch.getText()+"%'");
            while(rs.next()){
                HrgjTBS = Double.parseDouble(rs.getString(5));
                Object [] row = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),koma.format(HrgjTBS)};
                dtm.addRow(row);
            }
            Tengah.setHorizontalAlignment(SwingConstants.CENTER);
            Kanan.setHorizontalAlignment(SwingConstants.RIGHT);
            showData.getColumnModel().getColumn(0).setCellRenderer(Tengah);
            showData.getColumnModel().getColumn(3).setCellRenderer(Tengah);
            showData.getColumnModel().getColumn(4).setCellRenderer(Kanan);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "GAGAL TAMPIL !!!", "WARNING", JOptionPane.WARNING_MESSAGE);
        }   
    }//GEN-LAST:event_txtSearchKeyReleased

    private void pn_listBrgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_listBrgMouseClicked
        this.requestFocus();
        showData.clearSelection();
    }//GEN-LAST:event_pn_listBrgMouseClicked

    private void cbxSuppItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSuppItemStateChanged
        try{
            rs=con.adapter.executeQuery("SELECT * FROM supplier WHERE nm_supp='"+cbxSupp.getSelectedItem()+"'");
            if(rs.next()){
                kdSupp=rs.getString("id_supp");
                cbxType.removeAllItems();
                cbxType.setEnabled(true);
                rs=con.adapter.executeQuery("SELECT * FROM tyitem WHERE id_supp='"+kdSupp+"'");
                while(rs.next()){
                    cbxType.addItem(rs.getString("type_brg"));
                }
            }else{
                cbxType.removeAllItems();
                cbxType.setEnabled(false);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"TIPE BARANG GAGAL TAMPIL !!!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cbxSuppItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> cbxSupp;
    private javax.swing.JComboBox<String> cbxType;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton delBtn;
    private javax.swing.JTextField discBrg;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_brand;
    private javax.swing.JLabel lb_hrgj;
    private javax.swing.JLabel lb_hrgp;
    private javax.swing.JLabel lb_jdlAdd;
    private javax.swing.JLabel lb_jdlList;
    private javax.swing.JLabel lb_kdbrg;
    private javax.swing.JLabel lb_listkdbrg;
    private javax.swing.JLabel lb_logo;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_note;
    private javax.swing.JLabel lb_percent;
    private javax.swing.JLabel lb_qty;
    private javax.swing.JLabel lb_supp;
    private javax.swing.JButton manageBtn;
    private javax.swing.JPanel mnd_content;
    private javax.swing.JPanel pn_addBrg;
    private javax.swing.JPanel pn_listBrg;
    private javax.swing.JTable showData;
    private javax.swing.JList<String> showList;
    private javax.swing.JTextField txtHrgbrg;
    private javax.swing.JTextField txtHrgj;
    private javax.swing.JTextField txtKdbrg;
    private javax.swing.JTextField txtNmbrg;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JButton updBtn;
    // End of variables declaration//GEN-END:variables
}
