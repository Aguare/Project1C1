package Front;

import Back.Archives.ClassCompare;
import Back.Archives.Read;
import Back.Conecction.SendArchives;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author aguare
 */
public class Archives extends javax.swing.JDialog {

    private ArrayList<File> p1, p2;
    private Read read = new Read();
    private SendArchives send;
    private String JSON = "";

    /**
     * Creates new form Archives
     */
    public Archives(java.awt.Frame parent, boolean modal, JTextArea console) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        send = new SendArchives(console);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pathP1 = new javax.swing.JTextField();
        pathP2 = new javax.swing.JTextField();
        p1Btn = new javax.swing.JButton();
        p2Btn = new javax.swing.JButton();
        analizeBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(44, 52, 90));
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione las carpetas de los proyectos a analizar");
        jLabel1.setOpaque(true);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Proyecto 1");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Proyecto 2");

        pathP1.setEditable(false);

        pathP2.setEditable(false);

        p1Btn.setText("Seleccionar");
        p1Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        p1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1BtnActionPerformed(evt);
            }
        });

        p2Btn.setText("Seleccionar");
        p2Btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        p2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p2BtnActionPerformed(evt);
            }
        });

        analizeBtn.setText("Analizar");
        analizeBtn.setEnabled(false);
        analizeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        analizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizeBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Prueba");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(pathP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pathP2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(analizeBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(p1Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(p2Btn)))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pathP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p1Btn)
                    .addComponent(p2Btn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analizeBtn)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void p1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1BtnActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int respuesta = fc.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (file != null) {
                this.p1 = read.inputDirectory(file);
                pathP1.setText(file.getAbsolutePath());
                verifyProjects();
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una carpeta de archivos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_p1BtnActionPerformed

    private void p2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p2BtnActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int respuesta = fc.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (file != null) {
                this.p2 = read.inputDirectory(file);
                pathP2.setText(file.getAbsolutePath());
                verifyProjects();
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una carpeta de archivos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_p2BtnActionPerformed

    private void analizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizeBtnActionPerformed
        this.JSON = send.createSocket(new ClassCompare(p1, p2));
        this.setVisible(false);
    }//GEN-LAST:event_analizeBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        p1 = read.inputDirectory(new File("/home/aguare/Downloads/CarpetaPruebas/Proyecto1"));
        p2 = read.inputDirectory(new File("/home/aguare/Downloads/CarpetaPruebas/Proyecto2"));
        this.JSON = send.createSocket(new ClassCompare(p1, p2));
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void verifyProjects() {
        if (p1 != null && p2 != null) {
            if (!pathP1.getText().equals(pathP2.getText())) {
                this.analizeBtn.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "No puede comparar la misma carpeta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String getJSON() {
        return JSON;
    }

    public void setJSON(String JSON) {
        this.JSON = JSON;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analizeBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton p1Btn;
    private javax.swing.JButton p2Btn;
    private javax.swing.JTextField pathP1;
    private javax.swing.JTextField pathP2;
    // End of variables declaration//GEN-END:variables

}
