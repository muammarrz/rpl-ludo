/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package setup_game;

import authentication.Controller;
import authentication.Login;
import authentication.View;
import javax.swing.JDialog;


/**
 *
 * @author Azeren
 */
public class Homepage extends javax.swing.JFrame {

    /**
     * Creates new form StartMenu
     */
    public Homepage() {
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        ludo = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        game = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        play = new javax.swing.JButton();
        setting = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1600, 900));

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1600, 900));

        jPanel1.setBackground(new java.awt.Color(43, 52, 103));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 900));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 95));

        ludo.setFont(new java.awt.Font("Segoe UI", 1, 72)); // NOI18N
        ludo.setForeground(java.awt.Color.orange);
        ludo.setText("LUDO");
        jPanel1.add(ludo);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jPanel1.add(logo);

        game.setFont(new java.awt.Font("Segoe UI", 1, 72)); // NOI18N
        game.setForeground(java.awt.Color.orange);
        game.setText("GAME");
        jPanel1.add(game);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 0));

        play.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        play.setForeground(new java.awt.Color(255, 255, 255));
        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button1.png"))); // NOI18N
        play.setText("PLAY");
        play.setBorder(null);
        play.setContentAreaFilled(false);
        play.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        play.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playMouseExited(evt);
            }
        });
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        jPanel2.add(play);

        setting.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        setting.setForeground(new java.awt.Color(255, 255, 255));
        setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button1.png"))); // NOI18N
        setting.setText("SETTING");
        setting.setBorder(null);
        setting.setContentAreaFilled(false);
        setting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setting.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingMouseExited(evt);
            }
        });
        setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingActionPerformed(evt);
            }
        });
        jPanel2.add(setting);

        exit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button1.png"))); // NOI18N
        exit.setText("EXIT");
        exit.setBorder(null);
        exit.setContentAreaFilled(false);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel2.add(exit);

        jPanel1.add(jPanel2);

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        Controller.view(this, "Login");
        Controller.StopMusic();
    }//GEN-LAST:event_exitActionPerformed

    private void playMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseEntered
        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button2.png")));
    }//GEN-LAST:event_playMouseEntered

    private void playMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseExited
        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button1.png")));
    }//GEN-LAST:event_playMouseExited

    private void settingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseEntered
        setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button2.png")));
    }//GEN-LAST:event_settingMouseEntered

    private void settingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseExited
        setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button1.png")));
    }//GEN-LAST:event_settingMouseExited

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button2.png")));
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button1.png")));
    }//GEN-LAST:event_exitMouseExited

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        Controller.view(this, "Popup");
        
    }//GEN-LAST:event_playActionPerformed

    private void settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingActionPerformed
        Controller.view(this, "Setting");
    }//GEN-LAST:event_settingActionPerformed

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
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel game;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel ludo;
    private javax.swing.JButton play;
    private javax.swing.JButton setting;
    // End of variables declaration//GEN-END:variables
}
