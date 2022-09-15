package view;

import javax.swing.*;
import java.awt.Image;
import java.util.ArrayList;
import controller.*;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();
    }

    /**
     * Do NOT modify the code inside this method
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        lblInstructions = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcbAgents = new javax.swing.JComboBox<>();
        lblOptions = new javax.swing.JLabel();
        btnDeleteAgent = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblDescription2 = new javax.swing.JLabel();
        btnNewAgent = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        txtaAgentList = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnAbout = new javax.swing.JButton();
        btnUpdateList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Administración de Red");
        setIconImage(ico);
        setPreferredSize(new java.awt.Dimension(720, 460));
        setResizable(false);

        lblTitle.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTitle.setText("Práctica 1");

        lblDescription.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblDescription.setText("Adquisición de información utilizando SNMP.");

        lblInstructions.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblInstructions.setText("Seleccione un agente de la lista desplegable para modificarlo, generar un reporte o eliminarlo.");

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setText("Agentes");

        lblOptions.setText("Opciones");

        btnDeleteAgent.setBackground(new java.awt.Color(255, 0, 0));
        btnDeleteAgent.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteAgent.setText("Eliminar");
        btnDeleteAgent.setMaximumSize(new java.awt.Dimension(88, 25));
        btnDeleteAgent.setMinimumSize(new java.awt.Dimension(88, 25));
        btnDeleteAgent.setPreferredSize(new java.awt.Dimension(88, 25));
        btnDeleteAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAgentActionPerformed(evt);
            }
        });

        jSeparator1.setPreferredSize(new java.awt.Dimension(55, 10));

        lblDescription2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblDescription2.setText("Agentes registrados:");

        btnNewAgent.setText("Nuevo");
        btnNewAgent.setPreferredSize(new java.awt.Dimension(88, 25));
        btnNewAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAgentActionPerformed(evt);
            }
        });

        btnReport.setText("Generar reporte PDF");
        btnReport.setMaximumSize(new java.awt.Dimension(88, 25));
        btnReport.setMinimumSize(new java.awt.Dimension(88, 25));
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        txtaAgentList.setViewportView(jTextArea1);

        btnAbout.setText("Acerca de...");
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        btnUpdateList.setText("Actualizar lista");
        btnUpdateList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle)
                            .addComponent(lblDescription)
                            .addComponent(lblInstructions))
                        .addContainerGap(61, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jcbAgents, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelMainLayout.createSequentialGroup()
                                        .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDeleteAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblOptions)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAbout))
                            .addComponent(txtaAgentList)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                                .addComponent(lblDescription2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdateList)
                                .addGap(18, 18, 18)
                                .addComponent(btnNewAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstructions, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblOptions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAgents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescription2)
                    .addComponent(btnNewAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtaAgentList, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbout)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAgentActionPerformed
        AddAgentWindow w = new AddAgentWindow();
        w.setVisible(true);
    }//GEN-LAST:event_btnNewAgentActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        AboutWindow a = new AboutWindow();
        a.setVisible(true);
    }//GEN-LAST:event_btnAboutActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        //TODO generar pdf
        if(jcbAgents.getItemCount()!=0){
            AgentManager mgr = new AgentManager();
        
            switch(mgr.generatePDF(jcbAgents.getSelectedIndex())){
                case 0:
                    //All good
                    JOptionPane.showMessageDialog(this,
                        "PDF generado con éxito en el directorio de este programa.",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1:
                    //Timeout error
                    JOptionPane.showMessageDialog(this,
                        "Error: Tiempo de espera agotado para conectar al agente.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                    break;
                case 2: 
                    //PDF creation error
                    JOptionPane.showMessageDialog(this,
                        "Error al generar el PDF.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                    break;
                default:
            }
        }else
            JOptionPane.showMessageDialog(this,
                        "Ningun agente seleccionado.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnReportActionPerformed

    private void btnUpdateListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateListActionPerformed
        updateList();
        setComboBoxItems();
    }//GEN-LAST:event_btnUpdateListActionPerformed

    private void btnDeleteAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAgentActionPerformed
        if(jcbAgents.getItemCount()!=0){
            AgentManager mgr = new AgentManager();
        
            mgr.removeAgent(jcbAgents.getSelectedIndex());

            updateList();
            setComboBoxItems();
        }else
            JOptionPane.showMessageDialog(this,
                        "Ningun agente seleccionado.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnDeleteAgentActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    void updateList(){
        AgentManager mgr = new AgentManager();
        ArrayList<SNMPAgent> retrievedAgents = mgr.getAllAgents();
        if (retrievedAgents != null) {
            jTextArea1.setText("Version\t\tComunidad\t\tIP\t\tPuerto\n");
            for(SNMPAgent agent:retrievedAgents){
                String version, community, ip, port;
                version = agent.getVersion();
                community = agent.getCommunity();
                ip = agent.getAddress();
                port = agent.getPort();
                jTextArea1.append(version+"\t\t"+community+"\t\t"+ip+"\t\t"+port+"\n");
            }
        }else
            jTextArea1.setText("Error al obtener agentes del archivo.");
    }
    
    void setComboBoxItems(){
        AgentManager mgr = new AgentManager();
        ArrayList<SNMPAgent> retrievedAgents = mgr.getAllAgents();
        
        jcbAgents.removeAllItems();
        
        if(retrievedAgents != null){
            for(SNMPAgent agent:retrievedAgents){
                jcbAgents.addItem(agent.getAddress());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnDeleteAgent;
    private javax.swing.JButton btnNewAgent;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnUpdateList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> jcbAgents;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDescription2;
    private javax.swing.JLabel lblInstructions;
    private javax.swing.JLabel lblOptions;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane txtaAgentList;
    // End of variables declaration//GEN-END:variables
    Image ico = (new ImageIcon(getClass().getResource("/img/intranet.png"))).getImage();
}
