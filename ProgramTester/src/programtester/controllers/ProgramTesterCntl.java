/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import programtester.models.ProgramTesterViewModel;
import programtester.views.*;

public class ProgramTesterCntl {

    private ProgramTesterViewModel currentViewModel;
    private ProgramTesterUI theProgramTesterUI;

    public ProgramTesterCntl() {
        this.startProgramTesterWizard();
    }

    public void startProgramTesterWizard() {
        currentViewModel = new ProgramTesterViewModel(this);
        theProgramTesterUI = new ProgramTesterUI(this);
        theProgramTesterUI.setVisible(true);
    }

    public ProgramTesterViewModel getCurrentViewModel() {
        return currentViewModel;
    }
    
    public StepOnePanel getStepOnePanel(){
        return this.theProgramTesterUI.stepOnePanel;
    }
    
    public StepTwoPanel getStepTwoPanel(){
        return this.theProgramTesterUI.stepTwoPanel;
    }
    
    public StepThreePanel getStepThreePanel(){
        return this.theProgramTesterUI.stepThreePanel;
    }
    
    public StepFourPanel getStepFourPanel(){
        return this.theProgramTesterUI.stepFourPanel;
    }
    
//    public StepFourPanel getStepFourPanel(){
//        return this.stepFourPanel;
//    }

    public void step(int stepNumber) {
        theProgramTesterUI.renderComponents(stepNumber);
    }

    public void createConfigBatchFile() {
        int testHandle = 111111;
        try {
            PrintWriter writer = new PrintWriter(this.currentViewModel.getConfigBatchFile());
            writer.print("");

            String temp;
            for (File f : this.currentViewModel.getSelectedZippedFiles()) {
                temp = f.getName().split("test1-")[1];
                writer.println(temp.split(".zip")[0] + "\t" + testHandle);
                testHandle += 111111;
            }

            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProgramTesterViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void runTests(String outputPath, String outputFilename) {
        String[] args = {outputPath, outputFilename};
        programtester.BatchTester.main(args);
    }

}
