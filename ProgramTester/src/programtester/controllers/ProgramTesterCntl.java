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
    ProgramTesterUI theProgramTesterUI;
    
    public ProgramTesterCntl(){
        this.startProgramTesterWizard();
    }
    
    public void startProgramTesterWizard(){
        currentViewModel = new ProgramTesterViewModel(this);
        theProgramTesterUI = new ProgramTesterUI(this);
        theProgramTesterUI.setVisible(true);
    }
    
    public ProgramTesterViewModel getCurrentViewModel(){
        return currentViewModel;
    }
    
    public void step(int stepNumber){
        theProgramTesterUI.renderComponents(stepNumber);
    }
    
}
