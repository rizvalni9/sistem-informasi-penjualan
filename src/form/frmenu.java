package form;

import config.rootdb;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import panel.menuItem;
import panel.pndata;
import panel.pnkrwn;
import panel.pnsupp;
import panel.pntrans;
import panel.pnreport;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.Timer;
import java.util.Locale;
import java.sql.ResultSet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;

public class frmenu extends javax.swing.JFrame {
    
    public String lvmen,nmmen;
    private rootdb con = new rootdb();
    private ResultSet rs;
    private Timer time;
    
    private void addMenu(menuItem...menu){
        for(int i=0;i<menu.length;i++){
            mn_side.add(menu[i]);
            ArrayList<menuItem> subMenu = menu[i].getSubMenu(); 
            for(menuItem m : subMenu){
                addMenu(m);
            }
        }
        mn_side.revalidate();
    }
    
    private void homebc(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/bchome.jpg"));
        Image imgScale = icon.getImage().getScaledInstance(lbground.getWidth(), lbground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconScaled = new ImageIcon(imgScale);
        lbground.setIcon(iconScaled);
    }
    
    private void setTimer(){
        Date now = new Date();
        SimpleDateFormat days = new SimpleDateFormat("EEEE",new Locale("in","ID"));
        SimpleDateFormat tg = new SimpleDateFormat("dd MMMM yyyy");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
        String hari = days.format(now);
        String tgl = tg.format(now);
        String jam = hour.format(now);
        lbdate.setText(hari+", "+tgl);
        lbtimer.setText(jam);
    }
    
    private void company(){
        try{
        rs = con.adapter.executeQuery("SELECT * FROM comiden");
            if(rs.first()){
                lbcompany.setText(rs.getString(1));
                lbaddress.setText(rs.getString(2));
                byte imgconvert [] = rs.getBytes("image");
                BufferedImage file = ImageIO.read(new ByteArrayInputStream(imgconvert));
                ImageIcon preGambar = new ImageIcon(file);
                Image resfitGambar = preGambar.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                ImageIcon fixGambar = new ImageIcon(resfitGambar);
                lblogo.setIcon(fixGambar);
            }else{
                lbcompany.setText("Company Name");
                lbaddress.setText("Company Address");
                ImageIcon pathLogo = new ImageIcon(getClass().getResource("/img/logodef.png"));
                Image fitImage = pathLogo.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                ImageIcon fixLogo = new ImageIcon(fitImage);
                lblogo.setIcon(fixLogo);
            }
        }catch(Exception e){
            System.out.println(e);
        }    
    }
    
    private void startup(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/bchome.jpg"));
        Image imgScale = icon.getImage().getScaledInstance(1336, 794, Image.SCALE_SMOOTH);
        ImageIcon iconScaled = new ImageIcon(imgScale);
        lbground.setIcon(iconScaled);
    }
    
    private void execute(){
        //Untuk list menu
        ImageIcon imgmas = new ImageIcon(getClass().getResource("/img/folder.png"));
        ImageIcon imgtrans = new ImageIcon(getClass().getResource("/img/cart.png"));
        ImageIcon imgrep = new ImageIcon(getClass().getResource("/img/doc.png"));
        ImageIcon imgoutlog = new  ImageIcon(getClass().getResource("/img/logout.png"));
        ImageIcon imghome = new ImageIcon(getClass().getResource("/img/home.png"));
        
        //Untuk sub list menu
        ImageIcon imgmas1 = new ImageIcon(getClass().getResource("/img/database.png"));
        ImageIcon imgmas2 = new ImageIcon(getClass().getResource("/img/people.png"));
        ImageIcon imgmas3 = new ImageIcon(getClass().getResource("/img/absen.png"));
        ImageIcon imgrep1 = new ImageIcon(getClass().getResource("/img/docheck.png"));

        menuItem home = new menuItem(imghome,false,null,"HOME", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mn_content.removeAll();
                mn_content.add(lbground);
                homebc();
                mn_content.repaint();
                mn_content.revalidate();
            }
        });
        menuItem barang = new menuItem(null,true,imgmas1,"BARANG", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mn_content.removeAll();
                mn_content.add(new pndata());
                mn_content.repaint();
                mn_content.revalidate();
            }
        });
        menuItem user = new menuItem(null,true,imgmas2,"KARYAWAN",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mn_content.removeAll();
                mn_content.add(new pnkrwn());
                mn_content.repaint();
                mn_content.revalidate();
            }
        });
        menuItem absen = new menuItem(null,true,imgmas3,"SUPPLIER",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mn_content.removeAll();
                mn_content.add(new pnsupp());
                mn_content.repaint();
                mn_content.validate();
            }
        });
        menuItem laphari = new menuItem(null,true,imgrep1,"LAPORAN HARIAN", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mn_content.removeAll();
                mn_content.add(new pnreport(1));
                mn_content.repaint();
                mn_content.validate();
                
                //new frdatein(null,true).show();
            }
        });
        menuItem lapbulan = new menuItem(null,true,imgrep1,"LAPORAN BULANAN", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mn_content.removeAll();
                mn_content.add(new pnreport(2));
                mn_content.repaint();
                mn_content.revalidate();
            }
        });
        menuItem laptahun = new  menuItem(null,true,imgrep1,"LAPORAN TAHUNAN", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mn_content.removeAll();
                mn_content.add(new pnreport(3));
                mn_content.repaint();
                mn_content.revalidate();
            }
        });
        
        menuItem master = new menuItem(imgmas,false,null,"MASTER",null,barang,user,absen);
        menuItem transaksi = new menuItem(imgtrans,false,null,"TRANSAKSI",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mn_content.removeAll();
                mn_content.add(new pntrans(nmmen));
                mn_content.repaint();
                mn_content.validate();
            }
        });
        menuItem laporan = new menuItem(imgrep,false,null,"REPORT",null,laphari,lapbulan,laptahun);
        menuItem logout = new menuItem(imgoutlog,false,null,"LOG OUT",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int mssglog = JOptionPane.showConfirmDialog(rootPane, "APAKAH ANDA INGIN LOG OUT ???","QUESTION",JOptionPane.YES_NO_OPTION);
                if(mssglog==JOptionPane.YES_OPTION){
                    mn_content.removeAll();
                    new frlog().show();
                    dispose();
                }
            }
        });
        
        if(this.lvmen.equals("Admin")){
            addMenu(home,master,transaksi,laporan,logout);
            btnsetting.setVisible(true);
        }else{
            addMenu(home,transaksi,logout);
            btnsetting.setVisible(false);
        }
    }
    
    public frmenu(String lvmen, String nmmen) {
        this.lvmen = lvmen;
        this.nmmen = nmmen;
        con.root();
        initComponents();
        this.setMinimumSize(new Dimension (800,600));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        execute();
        startup();
        company();
        time = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                setTimer();
            }
        });
        time.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        lblogo = new javax.swing.JLabel();
        lbcompany = new javax.swing.JLabel();
        lbaddress = new javax.swing.JLabel();
        lbdate = new javax.swing.JLabel();
        lbtimer = new javax.swing.JLabel();
        btnsetting = new javax.swing.JButton();
        side = new javax.swing.JPanel();
        slmenu = new javax.swing.JScrollPane();
        mn_side = new javax.swing.JPanel();
        pncp = new javax.swing.JPanel();
        lbcopyright = new javax.swing.JLabel();
        slcontent = new javax.swing.JScrollPane();
        mn_content = new javax.swing.JPanel();
        lbground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        header.setBackground(new java.awt.Color(0, 153, 255));
        header.setPreferredSize(new java.awt.Dimension(100, 70));

        lblogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logodef.png"))); // NOI18N

        lbcompany.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 16)); // NOI18N
        lbcompany.setForeground(new java.awt.Color(255, 255, 255));
        lbcompany.setText("Company Name");

        lbaddress.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbaddress.setForeground(new java.awt.Color(255, 255, 255));
        lbaddress.setText("Company Address");

        lbdate.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbdate.setForeground(new java.awt.Color(255, 255, 255));
        lbdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbdate.setText("TANGGAL DAN BULAN");

        lbtimer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbtimer.setForeground(new java.awt.Color(255, 255, 255));
        lbtimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtimer.setText("JAM");

        btnsetting.setBackground(new java.awt.Color(204, 204, 204));
        btnsetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/setting.png"))); // NOI18N
        btnsetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsettingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(lblogo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbaddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbcompany, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbtimer, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsetting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblogo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbcompany)
                    .addComponent(lbdate))
                .addGap(2, 2, 2)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbaddress)
                    .addComponent(lbtimer)))
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnsetting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        side.setPreferredSize(new java.awt.Dimension(200, 100));
        side.setLayout(new java.awt.BorderLayout());

        slmenu.setBorder(null);

        mn_side.setBackground(new java.awt.Color(255, 255, 255));
        mn_side.setLayout(new javax.swing.BoxLayout(mn_side, javax.swing.BoxLayout.Y_AXIS));
        slmenu.setViewportView(mn_side);

        side.add(slmenu, java.awt.BorderLayout.CENTER);

        pncp.setBackground(new java.awt.Color(0, 255, 255));
        pncp.setPreferredSize(new java.awt.Dimension(100, 40));
        pncp.setLayout(new java.awt.CardLayout());

        lbcopyright.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        lbcopyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcopyright.setText("Project by @Rizvalni Dev, 2025");
        pncp.add(lbcopyright, "card2");

        side.add(pncp, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(side, java.awt.BorderLayout.LINE_START);

        slcontent.setBorder(null);

        mn_content.setBackground(new java.awt.Color(255, 255, 255));
        mn_content.setLayout(new java.awt.BorderLayout());
        mn_content.add(lbground, java.awt.BorderLayout.CENTER);

        slcontent.setViewportView(mn_content);

        getContentPane().add(slcontent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsettingActionPerformed
        new frlogcomB(null,true).setVisible(true);
    }//GEN-LAST:event_btnsettingActionPerformed

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
            java.util.logging.Logger.getLogger(frmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmenu("Admin","Nama Anda").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsetting;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lbaddress;
    private javax.swing.JLabel lbcompany;
    private javax.swing.JLabel lbcopyright;
    private javax.swing.JLabel lbdate;
    private javax.swing.JLabel lbground;
    private javax.swing.JLabel lblogo;
    private javax.swing.JLabel lbtimer;
    private javax.swing.JPanel mn_content;
    private javax.swing.JPanel mn_side;
    private javax.swing.JPanel pncp;
    private javax.swing.JPanel side;
    private javax.swing.JScrollPane slcontent;
    private javax.swing.JScrollPane slmenu;
    // End of variables declaration//GEN-END:variables
}
