package absenkariawan;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Sendi_Agustian
 */
public class Utama extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    int  _nama;
    DefaultTableModel SiswaTbl;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();  
    
    //Komponen Report
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    Map<String, Object> param = new HashMap<>();
    
    public Utama() {
        initComponents();
        tanggal.setText(dateFormat.format(cal.getTime()));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                getSiswa();
                dataAbsen();
            }
        });
    }
    
    void getSiswa(){
        try {
            con = koneksi.getKoneksi();
            rs = con.createStatement().executeQuery("select * from siswa_pkl");
            while(rs.next()){
                namaSiswa.addItem(rs.getString("nama"));                                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void dataAbsen(){
        String[] kolom = {"ID","Nama Siswa","Tanggal","Sakit","Izin","Alfa","Alasan"};
        SiswaTbl = new DefaultTableModel(null, kolom);
        jTable1.setModel(SiswaTbl);
        String search = txt_src.getText();
        String sql = "select absensi.id_absen, absensi.siswa, absensi.tangal, absensi.sakit, absensi.ijin, absensi.alfa, absensi.alasan from absensi where siswa like'%"+search+"%' ";
        try {
            con = koneksi.getKoneksi();
            rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("id_absen");
                String b = rs.getString("siswa");
                String c = rs.getString("tangal");
                String d = rs.getString("sakit");
                String e = rs.getString("ijin");
                String f = rs.getString("alfa");
                String g = rs.getString("alasan");

                
                String[] data = {a,b,c,d,e,f,g};
                SiswaTbl.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        utama = new javax.swing.JPanel();
        absen = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        namaSiswa = new javax.swing.JComboBox<>();
        hadir = new javax.swing.JRadioButton();
        sakit = new javax.swing.JRadioButton();
        izin = new javax.swing.JRadioButton();
        alfa = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        alasan = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        kelola = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txt_src = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        utama.setLayout(new java.awt.CardLayout());

        absen.setBackground(new java.awt.Color(204, 204, 204));

        jPanel9.setBackground(new java.awt.Color(153, 153, 153));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Absen Siswa PKL");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        tanggal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tanggal.setText("tanggal");

        namaSiswa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Siswa" }));
        namaSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaSiswaActionPerformed(evt);
            }
        });

        hadir.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(hadir);
        hadir.setText("Hadir");

        sakit.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(sakit);
        sakit.setText("Sakit");

        izin.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(izin);
        izin.setText("Izin");

        alfa.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(alfa);
        alfa.setText("Alfa");

        alasan.setColumns(20);
        alasan.setLineWrap(true);
        alasan.setRows(5);
        jScrollPane1.setViewportView(alasan);

        jLabel3.setText("Alasan:");

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("PT. Jerbee Indonesia");

        javax.swing.GroupLayout absenLayout = new javax.swing.GroupLayout(absen);
        absen.setLayout(absenLayout);
        absenLayout.setHorizontalGroup(
            absenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, absenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tanggal)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, absenLayout.createSequentialGroup()
                .addContainerGap(161, Short.MAX_VALUE)
                .addGroup(absenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(namaSiswa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(absenLayout.createSequentialGroup()
                        .addComponent(hadir)
                        .addGap(18, 18, 18)
                        .addComponent(sakit)
                        .addGap(18, 18, 18)
                        .addComponent(izin)
                        .addGap(18, 18, 18)
                        .addComponent(alfa))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(154, 154, 154))
        );
        absenLayout.setVerticalGroup(
            absenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(absenLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(absenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tanggal)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(namaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(absenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hadir)
                    .addComponent(sakit)
                    .addComponent(izin)
                    .addComponent(alfa))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(66, 66, 66))
        );

        utama.add(absen, "card2");

        kelola.setBackground(new java.awt.Color(204, 204, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel10.setBackground(new java.awt.Color(153, 153, 153));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Kelola Absen Siswa");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jButton2.setText("Edit absen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cetak Absen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("<< Kembali");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Cari");

        javax.swing.GroupLayout kelolaLayout = new javax.swing.GroupLayout(kelola);
        kelola.setLayout(kelolaLayout);
        kelolaLayout.setHorizontalGroup(
            kelolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kelolaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kelolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kelolaLayout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(kelolaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25)
                        .addComponent(txt_src, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kelolaLayout.setVerticalGroup(
            kelolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kelolaLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kelolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_src, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(kelolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(35, 35, 35))
        );

        utama.add(kelola, "card3");

        jMenu1.setText("Menu");

        jMenuItem3.setText("Add Siswa");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Kelola Absen");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem1.setText("Close");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(utama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(utama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new AddSiswa(this, rootPaneCheckingEnabled).show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        utama.removeAll();
        utama.revalidate();
        utama.repaint();
        
        utama.add(kelola);
        utama.revalidate();
        utama.repaint();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        utama.removeAll();
        utama.revalidate();
        utama.repaint();
        
        utama.add(absen);
        utama.revalidate();
        utama.repaint();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        if(){
//            JOptionPane.showMessageDialog("", alasan);
//        }
        int i = jTable1.getSelectedRow();
        String _keterangan;
        String _alasan = jTable1.getValueAt(i, 6).toString();
        if(jTable1.getValueAt(i, 3).toString().equals("Sakit")){
            _keterangan = "Sakit";
            EditAbsen go = new EditAbsen(_keterangan, _alasan);
            go.show();
        }else if(jTable1.getValueAt(i, 4).toString().equals("Izin")){
            _keterangan = "Izin";
            EditAbsen go = new EditAbsen(_keterangan, _alasan);
            go.show();
        }else if(jTable1.getValueAt(i, 5).toString().equals("Izin")){
            _keterangan = "Alfa";
            EditAbsen go = new EditAbsen(_keterangan, _alasan);
            go.show();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            con = koneksi.getKoneksi();
            
            if(hadir.isSelected()){
                con = koneksi.getKoneksi();
                String a = "Hadir";
                int nama = _nama;
                String tgl = tanggal.getText();
                String des = alasan.getText();

                con.createStatement().executeUpdate("INSERT INTO absensi values(null, "+nama+", '"+tgl+"', '"+a+"', '-', '-', '-', '"+des+"') ");
                JOptionPane.showMessageDialog(this, "Absen Berhasil");
            }else if(sakit.isSelected()){
                con = koneksi.getKoneksi();
                String a = "Sakit";
                int nama = _nama;
                String tgl = tanggal.getText();
                String des = alasan.getText();

                con.createStatement().executeUpdate("INSERT INTO absensi values(null, "+nama+", '"+tgl+"', '-', '"+a+"', '-', '-', '"+des+"') ");
                JOptionPane.showMessageDialog(this, "Absen Berhasil");
            }else if(izin.isSelected()){
                con = koneksi.getKoneksi();
                String a = "Izin";
                int nama = _nama;
                String tgl = tanggal.getText();
                String des = alasan.getText();

                con.createStatement().executeUpdate("INSERT INTO absensi values(null, "+nama+", '"+tgl+"', '-', '-', '"+a+"', '-', '"+des+"') ");
                JOptionPane.showMessageDialog(this, "Absen Berhasil");
            }else if(alfa.isSelected()){
                con = koneksi.getKoneksi();
                String a = "Alfa";
                int nama = _nama;
                String tgl = tanggal.getText();
                String des = alasan.getText();

                con.createStatement().executeUpdate("INSERT INTO absensi values(null, "+nama+", '"+tgl+"', '-', '-', '-', '"+a+"', '"+des+"') ");
                JOptionPane.showMessageDialog(this, "Absen Berhasil");
            }else{
                JOptionPane.showMessageDialog(this, "Pilih keterangannya!!!");
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void namaSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaSiswaActionPerformed
        try {
            con = koneksi.getKoneksi();
            String cbisi = namaSiswa.getSelectedItem().toString();
            rs = con.createStatement().executeQuery("select * from siswa_pkl where nama='"+cbisi+"' ");
            while(rs.next()){
                _nama = rs.getInt("id_siswa");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_namaSiswaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            File file = new File("src/Reeport/report1.jrxml");
            jasperDesign = JRXmlLoader.load(file);            
            param.clear();
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, param, koneksi.getKoneksi());
            JasperViewer.viewReport(jasperPrint, false);
            
        } catch (JRException e) {
//            e.printStackTrace();
            System.out.println(""+e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel absen;
    private javax.swing.JTextArea alasan;
    private javax.swing.JRadioButton alfa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton hadir;
    private javax.swing.JRadioButton izin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel kelola;
    private javax.swing.JComboBox<String> namaSiswa;
    private javax.swing.JRadioButton sakit;
    private javax.swing.JLabel tanggal;
    private javax.swing.JTextField txt_src;
    private javax.swing.JPanel utama;
    // End of variables declaration//GEN-END:variables
}
