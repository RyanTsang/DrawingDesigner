/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pers.ryan.drawingdesigner.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import pers.ryan.drawingdesigner.service.ArrayService;

/**
 *  This class contain 
 * @author Ryan Tsang
 */
public class DrawDesigner extends javax.swing.JFrame {
    
    DrawPanel drawPanel = new DrawPanel();
    String fileName = "";
    
    public DrawDesigner() {
        initComponents();
        addButtonActionListener(btnBlack);
        addButtonActionListener(btnWhite);
        addButtonActionListener(btnRed);
        addButtonActionListener(btnYellow);
        addButtonActionListener(btnBlue);
        addButtonActionListener(btnGreen);
        drawPanel.setSize(drawPanelContainer.getSize());
        drawPanelContainer.add(drawPanel, BorderLayout.CENTER);
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
        jLabel1 = new javax.swing.JLabel();
        btnBlack = new javax.swing.JButton();
        btnWhite = new javax.swing.JButton();
        btnRed = new javax.swing.JButton();
        btnYellow = new javax.swing.JButton();
        btnBlue = new javax.swing.JButton();
        btnGreen = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnSelectedColor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        chkShowGrid = new javax.swing.JCheckBox();
        btnClear = new javax.swing.JButton();
        btnRotate = new javax.swing.JButton();
        btnFlipH = new javax.swing.JButton();
        btnFlipV = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSaveRAF = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        drawPanelContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Draw Designer");
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Select Colour");

        btnBlack.setBackground(new java.awt.Color(0, 0, 0));

        btnWhite.setBackground(new java.awt.Color(255, 255, 255));

        btnRed.setBackground(new java.awt.Color(255, 0, 0));

        btnYellow.setBackground(new java.awt.Color(255, 255, 0));

        btnBlue.setBackground(new java.awt.Color(0, 0, 255));

        btnGreen.setBackground(new java.awt.Color(0, 255, 0));

        jLabel2.setText("Selected Color");

        btnSelectedColor.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSelectedColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBlack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnWhite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnYellow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBlue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnBlack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRed, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnSelectedColor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        chkShowGrid.setText("Grid");
        chkShowGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowGridActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnRotate.setText("Rotate 90");
        btnRotate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRotateActionPerformed(evt);
            }
        });

        btnFlipH.setText("Flip Horizontally");
        btnFlipH.setToolTipText("");
        btnFlipH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlipHActionPerformed(evt);
            }
        });

        btnFlipV.setText("Flip Vertically");
        btnFlipV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlipVActionPerformed(evt);
            }
        });

        btnSave.setText("Save Image");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnSaveRAF.setText("Save RAF");
        btnSaveRAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRAFActionPerformed(evt);
            }
        });

        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(chkShowGrid)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addGap(41, 41, 41)
                .addComponent(btnRotate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFlipH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFlipV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOpen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveRAF)
                .addGap(26, 26, 26)
                .addComponent(btnQuit)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkShowGrid)
                    .addComponent(btnClear)
                    .addComponent(btnRotate)
                    .addComponent(btnFlipH)
                    .addComponent(btnFlipV)
                    .addComponent(btnSave)
                    .addComponent(btnSaveRAF)
                    .addComponent(btnQuit)
                    .addComponent(btnOpen))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        drawPanelContainer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        drawPanelContainer.setPreferredSize(new java.awt.Dimension(820, 480));

        javax.swing.GroupLayout drawPanelContainerLayout = new javax.swing.GroupLayout(drawPanelContainer);
        drawPanelContainer.setLayout(drawPanelContainerLayout);
        drawPanelContainerLayout.setHorizontalGroup(
            drawPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        drawPanelContainerLayout.setVerticalGroup(
            drawPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(drawPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drawPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void chkShowGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowGridActionPerformed
        drawPanel.setIsShowGrid(chkShowGrid.isSelected());
    }//GEN-LAST:event_chkShowGridActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        if(!fileName.equals("")){
            File file = new File(fileName);
            fileChooser.setSelectedFile(file);
        }
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter( "CSV files (*.csv)", "csv"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter( "Text files (*.txt)", "txt"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter( "ABC files (*.abc)", "abc"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter( "RAF files (*.raf)", "raf"));
        if(fileChooser.showDialog(this, null) == JFileChooser.APPROVE_OPTION) {
            fileName = fileChooser.getSelectedFile().getPath();
            ArrayService as = new ArrayService(fileName);
            drawPanel.setStringArray(as.findArray());
        }
    }//GEN-LAST:event_btnOpenActionPerformed
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        List<FileNameExtensionFilter> args = new ArrayList<FileNameExtensionFilter>();
        args.add(new FileNameExtensionFilter( "CSV files (*.csv)", "csv"));
        args.add(new FileNameExtensionFilter( "Text files (*.txt)", "txt"));
        args.add(new FileNameExtensionFilter( "ABC files (*.abc)", "abc"));
        saveToFile(args.toArray(new FileNameExtensionFilter[args.size()]));
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        drawPanel.clearImage();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSaveRAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRAFActionPerformed
        saveToFile(new FileNameExtensionFilter( "RAF files (*.raf)", "raf"));
    }//GEN-LAST:event_btnSaveRAFActionPerformed

    private void btnFlipHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlipHActionPerformed
        drawPanel.flipHorizontally();
    }//GEN-LAST:event_btnFlipHActionPerformed

    private void btnFlipVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlipVActionPerformed
        drawPanel.flipVertically();
    }//GEN-LAST:event_btnFlipVActionPerformed

    private void btnRotateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRotateActionPerformed
        drawPanel.rotate();
    }//GEN-LAST:event_btnRotateActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        drawPanel.myPaint();
    }//GEN-LAST:event_formWindowActivated

    private void addButtonActionListener(JButton button){
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Color currentColor = button.getBackground();
                drawPanel.setCurrentColor(currentColor);
                btnSelectedColor.setBackground(currentColor);
            }
        });
    }
    
    private void saveToFile(FileNameExtensionFilter... filters){
        JFileChooser fileChooser = new JFileChooser();
        if(!fileName.equals("")){
            File file = new File(fileName);
            fileChooser.setSelectedFile(file);
        }
        fileChooser.setAcceptAllFileFilterUsed(false);
        for(FileNameExtensionFilter filter: filters){
                fileChooser.addChoosableFileFilter(filter);
        }
        while(fileChooser.showDialog(this, "Save") == JFileChooser.APPROVE_OPTION) {
            fileName = fileChooser.getSelectedFile().getPath();
            String extension= "";
            int i = fileName.lastIndexOf('.');
            if (i > 0) {
            extension = fileName.substring(i+1);
            }
            if(extension.equals("")){
                //If the file name dose not include extension, ask user to input extension
                JOptionPane.showMessageDialog(this, "The flie need to include an extension.");
                continue;
            }
            ArrayService as = null;
            try{
                as = new ArrayService(fileName);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
                continue;
            }
            as.saveArray(drawPanel.getStringArray());
            JOptionPane.showMessageDialog(this, "Image has been saved to selected file");
            break;
	}
    }
             
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
            java.util.logging.Logger.getLogger(DrawDesigner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DrawDesigner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DrawDesigner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DrawDesigner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrawDesigner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlack;
    private javax.swing.JButton btnBlue;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFlipH;
    private javax.swing.JButton btnFlipV;
    private javax.swing.JButton btnGreen;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnRed;
    private javax.swing.JButton btnRotate;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveRAF;
    private javax.swing.JButton btnSelectedColor;
    private javax.swing.JButton btnWhite;
    private javax.swing.JButton btnYellow;
    private javax.swing.JCheckBox chkShowGrid;
    private javax.swing.JPanel drawPanelContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
