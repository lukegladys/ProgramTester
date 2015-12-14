/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.views;

import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 *
 * @author Nia
 */
public class LabelArea extends JTextArea{
    LabelArea (String text){
    this.setText(text);
    this.setWrapStyleWord(true);
    this.setLineWrap(true);
    this.setOpaque(false);
    this.setEditable(false);
    this.setFocusable(false);
    this.setBackground(UIManager.getColor("Label.background"));
    this.setFont(UIManager.getFont("Label.font"));
    this.setBorder(UIManager.getBorder("Label.border"));
    }
}
