/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codewritten;

import bluejnetbeans.PanelsWindow;
import bluejnetbeans.MainApplicationWindow;
import bluejnetbeans.ClassInformationPanel;
import bluejnetbeans.ProjectInformationPanel;
import bluejnetbeans.ClassCreationWindow;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Paul
 */
public class BlueJNetBeansMyCode {
    /*
	NOTE: Class created with the purpose of not interfering with the code produced by
	the GUI designers and NOT for creating extensible and/or easily maintainable software.  
    */
    private javax.swing.JPanel jPanel1;
    private ClassWidget firstClass;
    private static int newWindowX = 275;
    private final int newWindowY=100;
    
    //Panels Window fields
    private static int tabIndex, docPanelCounter;
    private final ArrayList<String> appWindowNames = new ArrayList<>();
    private JTabbedPane jTabbedPane1;
    
    PanelsWindow newAppWindow = new PanelsWindow(this);
    
    public BlueJNetBeansMyCode(MainApplicationWindow mainFrame) {
        initializeVariables();
        addFirstClass();
    }
    
    private void addFirstClass() {
        ImageIcon img7 = new javax.swing.ImageIcon(getClass().getResource("/img/ClassNull.png"));
        ClassWidget firstClass = new ClassWidget("FirstClass", img7, newAppWindow);
        this.firstClass = firstClass;
    }
    
    public void setPanel(JPanel jPanel1){
        this.jPanel1 = jPanel1;
    }
    
    public PanelsWindow getAppWindow(){
        return newAppWindow;
    }
    
    public void addMouseActionLitener(){
        if (!firstClass.getDragged()) {
            addClassPanelIfPossible("FirstClass", newAppWindow);
            newAppWindow.setVisible(true);
        }
        firstClass.setDragged(false);
    }
    
    public void addMouseMotionListener(java.awt.event.MouseEvent evt, JButton jButton12) {
        jButton12.setBounds(evt.getX() + jButton12.getX() - 10,evt.getY() + jButton12.getY() - 10, 89, 58);
        firstClass.setDragged(true);
    }
    
    public void setKeyTypedListenerNewClass(JTextField jTextField1, JButton jButton1) {
        if (jTextField1.getText().equals("")) {
            jButton1.setEnabled(false);
        } else {
            jButton1.setEnabled(true);
        }
    }
    
    public void createNewClassWindow() {
        ClassCreationWindow newClass = new ClassCreationWindow(this);
        newClass.setVisible(true);
    }
    
    public void createClassIcon(String className, BlueJNetBeansMyCode newReference) {
        ImageIcon img7 = new 
            javax.swing.ImageIcon(getClass().getResource("/img/ClassNull.png"));
        ClassWidget newClass = new ClassWidget(className,
                img7, newReference.getAppWindow());
        
        setWindowVariables(newClass);
        createNewClassBtn(newClass);
        
        refreshJPanel();
    }
    
    private void setWindowVariables(ClassWidget newClass) {
        newClass.setWindowX(newWindowX);
        newClass.setWindowY(newWindowY);
    }
    
    public void createNewClassBtn(ClassWidget newClass) {
        JButton newClassBtn = new javax.swing.JButton();
        
        setAppearanceOfNewBtn(newClassBtn, newClass);
        jPanel1.add(newClassBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(newClass.getWindowX(), 
                newClass.getWindowY(), 89, 58));
        
        addListenersToBtn(newClassBtn,  newClass);
        newClassBtn.setVisible(true);
        
    }
    
    private void setAppearanceOfNewBtn(JButton newClassBtn, ClassWidget newClass) {
        JLabel label = new JLabel(newClass.getName());
        newClassBtn.add( label );
        
        newClassBtn.setBounds(newClass.getWindowX(), newClass.getWindowY(), 89, 58);
        newClassBtn.setIcon(newClass.getImageIcon());
        newClassBtn.setLayout( new GridLayout(2,1) );
    }
    
    private void addListenersToBtn(JButton newClassBtn, ClassWidget newClass) {
        addActionListenerToBtn(newClassBtn, newClass);
        addMouseMotionListenerToBtn(newClassBtn, newClass);
    }
    
    private void addActionListenerToBtn(JButton newClassBtn, ClassWidget newClass) {
        newClassBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            if (!newClass.getDragged()) {
                addClassPanelIfPossible(newClass.getName(), newAppWindow);
                newAppWindow.setVisible(true);
            }
            newClass.setDragged(false);
        });
    }
    
    private void addMouseMotionListenerToBtn(JButton newClassBtn, ClassWidget newClass) {
        newClassBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                newClassBtn.setBounds(calculateNewBoundsX(evt, newClassBtn),
                        calculateNewBoundsY(evt, newClassBtn), 89, 58);
                newClass.setDragged(true);
            }
        });
    }
    
    private int calculateNewBoundsX(java.awt.event.MouseEvent evt, JButton newClassBtn){
        return evt.getX() + newClassBtn.getX() - 10;
    }
    
    private int calculateNewBoundsY(java.awt.event.MouseEvent evt, JButton newClassBtn){
        return evt.getY()+newClassBtn.getY() - 10;
    }
    
    private void refreshJPanel(){
        newWindowX += 100;
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    
    //Panels Window Code
    public void setTabbedPane(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }
    
    public void beginAddDocumentPanelProcedure() {
        addDocumentPanelIfPossible();
        newAppWindow.setVisible(true);
    }
    
    private void addDocumentPanelIfPossible() {
	if (docPanelCounter == 0) {
            addDocumentPanel();
            jTabbedPane1.setSelectedIndex(tabIndex);
        }	
    }
   
    private void addDocumentPanel() {
        increaseCounters();
        ProjectInformationPanel newDoc = new ProjectInformationPanel(this);
        jTabbedPane1.addTab("README.TXT", newDoc);
        jTabbedPane1.setTabComponentAt(tabIndex, addPanelTab("README.TXT"));
    }
    
    private void increaseCounters(){
        tabIndex++;
        docPanelCounter++;
    }
    
    public void addClassPanelIfPossible(String name, PanelsWindow frame) {
	if (checkIfNameEligible(name)) {
            addClassPanel(name);
            jTabbedPane1.setSelectedIndex(tabIndex);
	}
    }
    
    private boolean checkIfNameEligible(String newName) {
	for (int i = 0; i < appWindowNames.size(); i++) {
            if (appWindowNames.get(i).equals(newName)){
                return false;
            }
	}
	return true;
    }
    
    public void addClassPanel(String className) {
        tabIndex++;
        ClassInformationPanel newClass = new ClassInformationPanel(className, this);
        jTabbedPane1.addTab(className,newClass);
        jTabbedPane1.setTabComponentAt(tabIndex, addPanelTab(className));
        
        appWindowNames.add(className);
    }
    
    private JPanel addPanelTab(String tabName){
        JPanel pnlTab = new JPanel(new GridBagLayout());
	JLabel lblTitle = new JLabel(tabName);
	JButton btnClose = new JButton("x");
		
	GridBagConstraints gbc = new GridBagConstraints();
	setConstraintsForTabTitle(gbc, tabName);
	pnlTab.add(lblTitle, gbc);
		
	setConstraintsForTabCloseBtn(gbc);
	pnlTab.add(btnClose, gbc);
        addActionListenerToBtn(btnClose, tabName);
        
        return pnlTab;
    }
    
    private void setConstraintsForTabTitle(GridBagConstraints gbc, String tabName){
        gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.weightx = 1;
    }
    
    private void setConstraintsForTabCloseBtn(GridBagConstraints gbc){
        gbc.gridx++;
	gbc.weightx = 0;
    }
    
    private void addActionListenerToBtn(JButton btnClose, String tabName){
        btnClose.addActionListener((ActionEvent e) -> {
            closeTab(tabName);
        });
    }
    
    public void closeTab(String tabName) {	
	jTabbedPane1.remove(jTabbedPane1.indexOfTab(tabName));
	tabIndex--;
	removeNameIfClassRemoved(tabName);
	reduceCounterIfDocRemoved(tabName);
	disposeIfTabIndexZero();
    }
    
    private void reduceCounterIfDocRemoved(String tabName) {
	if (tabName.equals("README.TXT")) {
            docPanelCounter--;
        }	
    }
    
    private void disposeIfTabIndexZero() {
	if (tabIndex == -1) {
            newAppWindow.dispose();
	}
    }
    
    private void removeNameIfClassRemoved(String tabName) {
	if (!tabName.equals("README.TXT")) {
            appWindowNames.remove(appWindowNames.indexOf(tabName));		
        }
    }
    
    public void clearAppWindow() {
	removeDocPanelIfExists();
	removeAllClassPanels();
    }
    
    private void removeDocPanelIfExists() {
	if (docPanelCounter == 1){
            closeTab("README.TXT");
        }
	docPanelCounter = 0;
    }
	
    private void removeAllClassPanels() {
	for (int i = 0; i < appWindowNames.size(); i++) {
            jTabbedPane1.remove(jTabbedPane1.indexOfTab(appWindowNames.get(i)));
            tabIndex--;
	}
	appWindowNames.clear();
    }
    
    private void initializeVariables(){
        tabIndex = -1;
        docPanelCounter = 0;
    }
    
}
