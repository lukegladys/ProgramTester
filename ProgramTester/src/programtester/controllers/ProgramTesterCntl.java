/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.controllers;

import programtester.models.ProgramTesterViewModel;
import programtester.views.ProgramTesterUI;

/**
 *
 * @author Luke
 */
public class ProgramTesterCntl {
    
    ProgramTesterViewModel currentViewModel;
    
    public ProgramTesterCntl(){
        this.showProgramTesterUI();
    }
    
    public void showProgramTesterUI(){
        ProgramTesterUI theProgramTesterUI = new ProgramTesterUI(this);
        theProgramTesterUI.setVisible(true);
    }
    
    public ProgramTesterViewModel getCurrentViewModel(){
        return currentViewModel;
    }
    
}
