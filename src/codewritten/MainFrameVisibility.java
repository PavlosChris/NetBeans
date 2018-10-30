/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codewritten;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Pavlos
 */
public class MainFrameVisibility {
    private JButton jButton4, jButton5, jButton6, jButton7, jButton8, jButton10,
            jButton13, jButton14, jButton12;
    private JLabel jLabel1, jLabel2, jLabel4;
    private JRadioButton jRadioButton1;
    private JPanel jPanel3;
    
    
    public MainFrameVisibility(JButton jButton4,JButton jButton5, JButton jButton6,
            JButton jButton7,JButton jButton8,JButton jButton10, JButton jButton12, 
            JButton jButton13, JButton jButton14, JLabel jLabel1, JLabel jLabel2, 
            JLabel jLabel4, JRadioButton jRadioButton1, JPanel jPanel3){
            this.jButton4 = jButton4; this.jButton5 = jButton5; this.jButton6 = jButton6;
            this.jButton7 = jButton7; this.jButton8 = jButton8; this.jButton10 = jButton10;
            this.jButton13 = jButton13; this.jButton14 = jButton14; this.jLabel1 = jLabel1;
            this.jLabel2 = jLabel2; this.jRadioButton1 = jRadioButton1;
            this.jPanel3 = jPanel3; this.jButton12 = jButton12; this.jLabel4 = jLabel4;
            setVisibility();
            constructButton12();
    }
    
    public final void constructButton12() {
        jButton12.setLayout(new GridLayout(2, 1));
        jButton12.add(jLabel4);
    }
    
    public final void setVisibility() {
        jButton4.setVisible(false);
        jButton5.setVisible(false);
        jLabel2.setVisible(false);
        jButton6.setVisible(false);
        jRadioButton1.setVisible(false);
        jButton7.setVisible(false);
        jButton8.setVisible(false);
        jButton14.setVisible(false);
        jPanel3.setVisible(false);
    }
    
    public void setVisibilityUpArrow() {
        setVisibilityUpDownArrows(true);
    }
    
    public void setVisibilityDownArrow() {
        setVisibilityUpDownArrows(false);
    }
    
    private void setVisibilityUpDownArrows(boolean visibilityValue) {
        jButton4.setVisible(visibilityValue);
        jLabel1.setVisible(visibilityValue);
        jButton5.setVisible(visibilityValue);
        jLabel2.setVisible(visibilityValue);
        jButton6.setVisible(visibilityValue);
        jRadioButton1.setVisible(visibilityValue);
        jButton7.setVisible(visibilityValue);
        jButton8.setVisible(visibilityValue);
        jButton10.setVisible(!visibilityValue);
    }
    
    public void setVisibilityLeftArrow() {
        setVisibilityRightLeftArrows(true);
    }
    
    public void setVisibilityRightArrow() {
        setVisibilityRightLeftArrows(false);
    }
    
    private void setVisibilityRightLeftArrows(boolean visibilityValue) {
        jButton14.setVisible(visibilityValue);
        jButton13.setVisible(!visibilityValue);
        jPanel3.setVisible(visibilityValue);
    }
}
