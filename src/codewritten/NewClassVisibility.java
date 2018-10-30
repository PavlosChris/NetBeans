/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codewritten;

import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

/**
 *
 * @author Pavlos
 */
public class NewClassVisibility {
    
    private JToggleButton jToggleButton1, jToggleButton2;
    private JRadioButton jRadioButton1, jRadioButton2, jRadioButton3,
            jRadioButton4, jRadioButton5, jRadioButton6;
    private JRadioButton[] radioButtons;
    
    public NewClassVisibility(JToggleButton jToggleButton1, 
            JToggleButton jToggleButton2, JRadioButton jRadioButton1, JRadioButton 
            jRadioButton2, JRadioButton jRadioButton3, JRadioButton jRadioButton4,
            JRadioButton jRadioButton5, JRadioButton jRadioButton6){
        this.jToggleButton1 = jToggleButton1;
        this.jToggleButton2 = jToggleButton2;
        this.jRadioButton1 = jRadioButton1;
        this.jRadioButton2 = jRadioButton2;
        this.jRadioButton3 = jRadioButton3;
        this.jRadioButton4 = jRadioButton4;
        this.jRadioButton5 = jRadioButton5;
        this.jRadioButton6 = jRadioButton6;
        radioButtons = new JRadioButton[]{jRadioButton1, jRadioButton2, 
            jRadioButton3, jRadioButton4, jRadioButton5, jRadioButton6};
    }
    
    public void setToggleButton1Visibility() {
        jToggleButton2.setSelected(false);
        setToggleBtnVisibility(true);
    }
    
    public void setToggleButton2Visibility() {
        jToggleButton1.setSelected(false);
        setToggleBtnVisibility(false);
    }
    
    private void setToggleBtnVisibility(boolean visibilityValue) {
        jRadioButton4.setVisible(visibilityValue);
        jRadioButton5.setVisible(visibilityValue);
        jRadioButton6.setVisible(visibilityValue);
    }
    
    public void setRadioButton1Visibility() {
        setRdButtonSelected(jRadioButton1);
    }
    
    public void setRadioButton2Visibility() {
        setRdButtonSelected(jRadioButton2);
    }
    
    public void setRadioButton3Visibility() {
        setRdButtonSelected(jRadioButton3);
    }
    
    public void setRadioButton4Visibility() {
        setRdButtonSelected(jRadioButton4);
    }
    
    public void setRadioButton5Visibility() {
        setRdButtonSelected(jRadioButton5);
    }
    
    public void setRadioButton6Visibility() {
        setRdButtonSelected(jRadioButton6);
    }
    
    private void setRdButtonSelected(JRadioButton buttonSelected) {
	for (int i = 0; i < 6; i++) {
            if (buttonSelected != radioButtons[i]) {
                radioButtons[i].setSelected(false);
            }
	}
    }
    
}
