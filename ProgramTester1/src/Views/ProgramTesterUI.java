/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import javax.swing.JFrame;
import controllers.ProgramTesterCntl;
import programtester.models.ProgramTesterViewModel;

/**
 *
 * @author Luke
 */
public class ProgramTesterUI extends JFrame{
    
    ProgramTesterCntl theProgramTesterCntl;
    
    public ProgramTesterUI(ProgramTesterCntl parentProgramTesterCntl){
        theProgramTesterCntl = parentProgramTesterCntl; 
        initComponents(parentProgramTesterCntl.getCurrentViewModel()); 
    }
    public void initComponents(ProgramTesterViewModel theProgramTesterViewModel){
        
    }
}
