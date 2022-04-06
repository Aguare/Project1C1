package Front;

import Back.Analizers.DEF.LexerDEF;
import Back.Analizers.DEF.SintacticDEF;
import Back.Analizers.ErrorLP;
import Back.Analizers.JSON.ChargeJSON;
import Back.Analizers.RecordJSON;
import java.io.Reader;
import java.io.StringReader;
import javax.swing.JOptionPane;

/**
 *
 * @author aguare
 */
public class Main extends javax.swing.JFrame {

    private LineNumber line1, line2, line3;
    private ChargeJSON charge;
    private RecordJSON recordJSON = null;

    /**
     * Creates new form Principal
     */
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        line1 = new LineNumber(reportDefTab);
        line2 = new LineNumber(jsonTab);
        line3 = new LineNumber(consoleText);
        scrollDef.setRowHeaderView(line1);
        scrollJSON.setRowHeaderView(line2);
        scrollConsole.setRowHeaderView(line3);
        insertHTML();
    }

    private void insertHTML() {
        reportsPane.setContentType("text/html");
        this.reportDefTab.setText("</iniciare a definir de alguna manera/>\n"
                + "Integer max, i, Max;\n"
                + "Max = 2;\n"
                + "i=0;\n"
                + "max = 0;\n"
                + "String texto = \"Su score fue de: \"+RESULT.Score;\n"
                + "String n1 = RESULT.Variables[i].Nombre;\n"
                + "String n2 = RESULT.Variables[Max].Nombre;\n"
                + "\n"
                + "</aqui defino el HTML/>\n"
                + "<html>\n"
                + "    <h1>$$(texto)$$</h1>\n"
                + "    <table>\n"
                + "        <tr>\n"
                + "            <th>Numero</th>\n"
                + "            <th>Variable</th>\n"
                + "            <th>Tipo</th>\n"
                + "            <th>Función</th>\n"
                + "        </tr>\n"
                + "        <for iterador:i hasta:Max;>\n"
                + "            <tr>\n"
                + "                <td>$$(i)$$</td>\n"
                + "                <td>$$(RESULT.Variables[i].Nombre)$$</td>\n"
                + "                <td>$$(RESULT.Variables[i].Tipo)$$</td>\n"
                + "                <td>$$(RESULT.Variables[i].Funcion)$$</td>\n"
                + "            </tr>\n"
                + "        </for>\n"
                + "    </table>\n"
                + "	<h1>\"Segundo for\"</h1>\n"
                + "	<for iterador:max hasta:2;>\n"
                + "		<h1>Hola$$(max)$$</h1>\n"
                + "	</for>\n"
                + "</html>");
        this.jsonTab.setText("{\n"
                + "Score: \"0.26\",\n"
                + "Clases:[\n"
                + "],\n"
                + "Variables:[\n"
                + "	{Nombre: \"args\", Tipo:\"STRING\", Funcion: \"main, main\"},\n"
                + "	{Nombre: \"variable1\", Tipo:\"STRING\", Funcion: \"metodo1, metodo11\"},\n"
                + "	{Nombre: \"cadena1\", Tipo:\"STRING\", Funcion: \"main, metodo3\"},\n"
                + "	{Nombre: \"objeto\", Tipo:\"OBJECT\", Funcion: \"main, metodo11\"},\n"
                + "	{Nombre: \"entero2\", Tipo:\"INTEGER\", Funcion: \"metodo2, metodo22\"},\n"
                + "	{Nombre: \"objeto\", Tipo:\"OBJECT\", Funcion: \"metodo1, metodo11\"},\n"
                + "	{Nombre: \"objeto\", Tipo:\"OBJECT\", Funcion: \"metodo1, metodo11\"},\n"
                + "	{Nombre: \"cadena1\", Tipo:\"STRING\", Funcion: \"metodo3, metodo3\"},\n"
                + "	{Nombre: \"cadena2\", Tipo:\"STRING\", Funcion: \"metodo3, metodo3\"},\n"
                + "	{Nombre: \"c\", Tipo:\"STRING\", Funcion: \"metodo3, metodo3\"}\n"
                + "],\n"
                + "Metodos:[\n"
                + "	{Nombre: \"main\", Tipo: \"void\", Parametros: 1},\n"
                + "	{Nombre: \"metodo3\", Tipo: \"void\", Parametros: 3}\n"
                + "],\n"
                + "Comentarios:[\n"
                + "	{Texto: \"// metodo3(\"Cadena\");\"},\n"
                + "	{Texto: \"/*\n"
                + "        	comentario1\n"
                + "        	asdf\n"
                + "        */\"},\n"
                + "	{Texto: \"/* este es el primer comentario */\"},\n"
                + "	{Texto: \"// Este es el segundo comentario\"},\n"
                + "	{Texto: \"// Este es el tercer comentario\"}\n"
                + "]\n"
                + "}");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabbedPaneMain = new javax.swing.JTabbedPane();
        scrollDef = new javax.swing.JScrollPane();
        reportDefTab = new javax.swing.JTextArea();
        scrollJSON = new javax.swing.JScrollPane();
        jsonTab = new javax.swing.JTextArea();
        scrollPane = new javax.swing.JScrollPane();
        reportsPane = new javax.swing.JEditorPane();
        executeBtn = new javax.swing.JButton();
        consoleLabel = new javax.swing.JLabel();
        scrollConsole = new javax.swing.JScrollPane();
        consoleText = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        archiveMenu = new javax.swing.JMenu();
        openProject = new javax.swing.JMenuItem();
        newProject = new javax.swing.JMenuItem();
        saveProject = new javax.swing.JMenuItem();
        archiveMenu1 = new javax.swing.JMenu();
        chargerJSON = new javax.swing.JMenuItem();
        chargeDEF = new javax.swing.JMenuItem();
        showHTML = new javax.swing.JMenuItem();
        clearConsole = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Detector de Plagio");
        setBackground(new java.awt.Color(69, 72, 85));

        jPanel1.setToolTipText("");

        tabbedPaneMain.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tabbedPaneMain.setOpaque(true);

        reportDefTab.setColumns(20);
        reportDefTab.setRows(5);
        reportDefTab.setMinimumSize(new java.awt.Dimension(729, 203));
        scrollDef.setViewportView(reportDefTab);

        tabbedPaneMain.addTab("reportes.def", scrollDef);

        jsonTab.setColumns(20);
        jsonTab.setRows(5);
        scrollJSON.setViewportView(jsonTab);

        tabbedPaneMain.addTab("resultado.json", scrollJSON);

        reportsPane.setEditable(false);
        scrollPane.setViewportView(reportsPane);

        tabbedPaneMain.addTab("Reportes", scrollPane);

        executeBtn.setText("Ejecutar");
        executeBtn.setEnabled(false);

        consoleLabel.setBackground(new java.awt.Color(21, 29, 69));
        consoleLabel.setFont(new java.awt.Font("Ubuntu Mono", 1, 15)); // NOI18N
        consoleLabel.setForeground(new java.awt.Color(254, 254, 254));
        consoleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        consoleLabel.setText("Consola");
        consoleLabel.setOpaque(true);

        consoleText.setEditable(false);
        consoleText.setColumns(20);
        consoleText.setRows(5);
        consoleText.setBorder(null);
        consoleText.setMinimumSize(new java.awt.Dimension(729, 203));
        scrollConsole.setViewportView(consoleText);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(executeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tabbedPaneMain, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                    .addComponent(scrollConsole, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consoleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(executeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollConsole, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        archiveMenu.setText("Proyecto");

        openProject.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openProject.setText("Abrir");
        archiveMenu.add(openProject);

        newProject.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newProject.setText("Crear");
        newProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectActionPerformed(evt);
            }
        });
        archiveMenu.add(newProject);

        saveProject.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveProject.setText("Guardar");
        archiveMenu.add(saveProject);

        jMenuBar1.add(archiveMenu);

        archiveMenu1.setText("Archivos");

        chargerJSON.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        chargerJSON.setText("Cargar JSON");
        chargerJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chargerJSONActionPerformed(evt);
            }
        });
        archiveMenu1.add(chargerJSON);

        chargeDEF.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        chargeDEF.setText("Ejecutar DEF");
        chargeDEF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chargeDEFActionPerformed(evt);
            }
        });
        archiveMenu1.add(chargeDEF);

        showHTML.setText("Mostrar HTML");
        archiveMenu1.add(showHTML);

        clearConsole.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        clearConsole.setText("Limpiar Consola");
        clearConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearConsoleActionPerformed(evt);
            }
        });
        archiveMenu1.add(clearConsole);

        jMenuBar1.add(archiveMenu1);

        jMenu1.setText("Acerca de");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectActionPerformed
        Archives arch = new Archives(this, true, consoleText);
        arch.setVisible(true);
        String response = arch.getJSON();
        if (response.equalsIgnoreCase("NO HAY RESPUESTA")) {
            JOptionPane.showMessageDialog(this, "No hay respuesta del Servidor", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            this.jsonTab.setText(arch.getJSON());
            tabbedPaneMain.setSelectedIndex(1);
            Reader reader = new StringReader(jsonTab.getText());
            charge = new ChargeJSON(consoleText, reader);
            charge.chargeJSON();
            JOptionPane.showMessageDialog(this, "Se analizaron los proyectos", "EXITO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_newProjectActionPerformed

    private void chargeDEFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chargeDEFActionPerformed
        try {
            if (recordJSON != null) {
                tabbedPaneMain.setSelectedIndex(0);
                LexerDEF lexer = new LexerDEF(new StringReader(reportDefTab.getText()));
                SintacticDEF sintac = new SintacticDEF(lexer, recordJSON);
                sintac.parse();
                for (ErrorLP error : sintac.getErrors()) {
                    consoleText.append(error.toString() + "\n");
                }
                String html = sintac.getRecord().getHTML();
                reportsPane.setText(html);
            } else {
                JOptionPane.showMessageDialog(this, "Debe cargar el archivo JSON", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_chargeDEFActionPerformed

    private void chargerJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chargerJSONActionPerformed
        tabbedPaneMain.setSelectedIndex(1);
        if (!jsonTab.getText().isBlank()) {
            Reader reader = new StringReader(jsonTab.getText());
            charge = new ChargeJSON(consoleText, reader);
            recordJSON = charge.chargeJSON();
        } else {
            JOptionPane.showMessageDialog(this, "Está vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_chargerJSONActionPerformed

    private void clearConsoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearConsoleActionPerformed
        consoleText.setText("");
    }//GEN-LAST:event_clearConsoleActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu archiveMenu;
    private javax.swing.JMenu archiveMenu1;
    private javax.swing.JMenuItem chargeDEF;
    private javax.swing.JMenuItem chargerJSON;
    private javax.swing.JMenuItem clearConsole;
    private javax.swing.JLabel consoleLabel;
    private javax.swing.JTextArea consoleText;
    private javax.swing.JButton executeBtn;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextArea jsonTab;
    private javax.swing.JMenuItem newProject;
    private javax.swing.JMenuItem openProject;
    private javax.swing.JTextArea reportDefTab;
    private javax.swing.JEditorPane reportsPane;
    private javax.swing.JMenuItem saveProject;
    private javax.swing.JScrollPane scrollConsole;
    private javax.swing.JScrollPane scrollDef;
    private javax.swing.JScrollPane scrollJSON;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JMenuItem showHTML;
    private javax.swing.JTabbedPane tabbedPaneMain;
    // End of variables declaration//GEN-END:variables
}
