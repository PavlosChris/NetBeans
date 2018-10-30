/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codewritten;

import bluejnetbeans.PanelsWindow;
import bluejnetbeans.ClassInformationPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Paul
 */
public class ClassWidget extends JFrame{
	private final String name;
	private int windowX, windowY;
	private final ImageIcon img;
        private boolean dragged;
        private ClassInformationPanel classPanel;
	
	public ClassWidget(final String name, final ImageIcon img, 
                final PanelsWindow appWindow) {
            this.name = name;
            this.img = img;
            dragged = false;
	}
        
        public void setDragged(boolean dragged) {
            this.dragged = dragged;
	}
	
	public boolean getDragged() {
            return dragged;
	}
	
	public void setWindowX(int winX) {
            windowX=winX;
	}
	
	public void setWindowY(int winY) {
            windowY=winY;
	}
	
        @Override
	public String getName() {
            return name;
	}
	
	public int getWindowX() {
            return windowX;
	}
	
	public int getWindowY() {
            return windowY;
	}
	
	public ImageIcon getImageIcon() {
            return img;
		
	}
	
}

