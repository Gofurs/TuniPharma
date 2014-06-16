/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tunipharma.gui;

import java.io.File;
import java.nio.channels.FileChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import tunipharma.DAO.PharmacieDAO;
import tunipharma.DAO.PharmacienDAO;
import tunipharma.entities.Pharmacie;
import tunipharma.entities.Pharmacien;

/**
 *
 * @author houssem_tmn
 */
public class PharmacienModification extends javax.swing.JFrame {

    /**
     * Creates new form PharmacienModification
     */
    public PharmacienModification() {
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

        mdpText = new javax.swing.JPasswordField();
        loginText = new javax.swing.JTextField();
        nomText = new javax.swing.JTextField();
        photo = new javax.swing.JTextField();
        prenomText = new javax.swing.JTextField();
        telText = new javax.swing.JTextField();
        jButton_photo_pharmacien = new javax.swing.JButton();
        emailText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 590));
        setMinimumSize(new java.awt.Dimension(600, 590));
        setPreferredSize(new java.awt.Dimension(600, 590));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(mdpText);
        mdpText.setBounds(220, 380, 132, 30);

        loginText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginTextActionPerformed(evt);
            }
        });
        getContentPane().add(loginText);
        loginText.setBounds(220, 340, 132, 30);

        nomText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomTextActionPerformed(evt);
            }
        });
        getContentPane().add(nomText);
        nomText.setBounds(220, 180, 132, 30);

        photo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoActionPerformed(evt);
            }
        });
        getContentPane().add(photo);
        photo.setBounds(290, 420, 100, 20);

        prenomText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomTextActionPerformed(evt);
            }
        });
        getContentPane().add(prenomText);
        prenomText.setBounds(220, 220, 132, 30);

        telText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telTextActionPerformed(evt);
            }
        });
        getContentPane().add(telText);
        telText.setBounds(220, 260, 132, 30);

        jButton_photo_pharmacien.setAlignmentX(0.5F);
        jButton_photo_pharmacien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_photo_pharmacienActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_photo_pharmacien);
        jButton_photo_pharmacien.setBounds(415, 393, 110, 40);
        getContentPane().add(emailText);
        emailText.setBounds(220, 300, 132, 30);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(220, 470, 110, 40);

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(390, 10, 210, 50);

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(443, 510, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tunipharma/image/Pharmacien compte.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -200, 700, 960);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

   jButton3.setBorderPainted(false); 
jButton3.setContentAreaFilled(false); 
jButton3.setFocusPainted(false); 
jButton3.setOpaque(false);
                                            
        
jButton2.setBorderPainted(false); 
jButton2.setContentAreaFilled(false); 
jButton2.setFocusPainted(false); 
jButton2.setOpaque(false);
                      
        
jButton_photo_pharmacien.setBorderPainted(false); 
jButton_photo_pharmacien.setContentAreaFilled(false); 
jButton_photo_pharmacien.setFocusPainted(false); 
jButton_photo_pharmacien.setOpaque(false);


    
                      
        
jButton1.setBorderPainted(false); 
jButton1.setContentAreaFilled(false); 
jButton1.setFocusPainted(false); 
jButton1.setOpaque(false);

 



        
        
        
        
        
        
        
        
        
        
        
        PharmacieDAO pharmacieDAO =new  PharmacieDAO();
        Pharmacien p=new Pharmacien();
        
        p=pharmacieDAO.chercherPharmacien(p.getLogin(),p.getPwd());
        
       loginText.setText(p.getLogin());
        nomText.setText(p.getNom());
        prenomText.setText(p.getPrenom());
        telText.setText(p.getTel());
        emailText.setText(p.getEmail());
        mdpText.setText(p.getPwd());
        
        
        
                


// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void loginTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginTextActionPerformed

    private void nomTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomTextActionPerformed

    private void photoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_photoActionPerformed

    private void prenomTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomTextActionPerformed

    private void telTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telTextActionPerformed

    private void jButton_photo_pharmacienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_photo_pharmacienActionPerformed
        // TODO add your handling code here:
        //création dun nouveau filechosser
        String name1;
        JFileChooser chooser = new JFileChooser();

        //intitulé du bouton
        chooser.setApproveButtonText("Choix du fichier");
        //affiche la boite de dialogue
        chooser.showOpenDialog(null);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            photo.setText(chooser.getSelectedFile().getAbsolutePath());
            name1 = new File(photo.getText()).getName();
            System.out.println(name1);

        }

        //panel.add(new JLabel(new ImageIcon(getClass().getResource(".//dm.jpg"))));
    }//GEN-LAST:event_jButton_photo_pharmacienActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
         
        //controle du nom
        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(nomText.getText());
        
        
        
          //telephone
        Pattern patternPhone = Pattern.compile("^[0-9]{6,12}$");
        Matcher matcherPhone = patternPhone.matcher(telText.getText());

        //email
        Pattern patternMail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        );
        Matcher matcherMail = patternMail.matcher(emailText.getText());
        
        
        
        
        
        
        if (matcherMail.matches()) {

            if (matcherPhone.matches()) {

              
               

          
               

                //pharmacien
                PharmacienDAO pharmacienDAO = new PharmacienDAO();
                Pharmacien pharmacien = new Pharmacien();
               

                pharmacien.setNom(nomText.getText());
                pharmacien.setPrenom(prenomText.getText());
                pharmacien.setEmail(emailText.getText());
                pharmacien.setTel(telText.getText());
                pharmacien.setLogin(loginText.getText());
                pharmacien.setPwd(mdpText.getText());
                pharmacien.setPhoto(Math.random() + nomText.getText());

                pharmacienDAO.ModifierPharmacien(pharmacien);

             
                
            
            
            
             JOptionPane.showMessageDialog(this, "Modification effectué avec succès");
              this.setVisible(false);
             Pharmacien_Menu  ac =new   Pharmacien_Menu();
             ac.setVisible(true);
            
            
            } else {
                JOptionPane.showMessageDialog(this, "Numero de telephone invalide");

            }

        } else {
            JOptionPane.showMessageDialog(this, "adresse mail invalide");
        }
        
        
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.setVisible(false);
Admin_Connexion ac = new Admin_Connexion();
ac.setVisible(true);
        

// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

this.setVisible(false);
        Pharmacien_Menu menu =new Pharmacien_Menu();
        menu.setVisible(true);

// TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(PharmacienModification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PharmacienModification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PharmacienModification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PharmacienModification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PharmacienModification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton_photo_pharmacien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField loginText;
    private javax.swing.JPasswordField mdpText;
    private javax.swing.JTextField nomText;
    private javax.swing.JTextField photo;
    private javax.swing.JTextField prenomText;
    private javax.swing.JTextField telText;
    // End of variables declaration//GEN-END:variables
}
