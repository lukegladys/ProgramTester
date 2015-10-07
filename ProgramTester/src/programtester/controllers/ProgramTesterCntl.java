/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import programtester.models.ProgramTesterViewModel;
import programtester.views.ProgramTesterUI;

/**
 *
 * @author Luke
 */
public class ProgramTesterCntl {

    ProgramTesterViewModel currentViewModel;
    ProgramTesterUI theProgramTesterUI;

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

    /*public void moveAndUnzipFiles() throws FileNotFoundException, IOException {
     byte[] buffer = new byte[1024];
     ZipInputStream zis;
     for (File f : this.currentViewModel.getSelectedZippedFiles()) {
     zis = new ZipInputStream(new FileInputStream(f));
     ZipEntry ze = zis.getNextEntry();
            
     while(ze!=null){
     String fileName = ze.getName();
     File newFile = new File(this.currentViewModel.getSrcOutputFolder() + File.separator + fileName);
                
     new File(newFile.getParent()).mkdirs();
                
     FileOutputStream fos = new FileOutputStream(newFile);
                
     int len;
     while((len = zis.read(buffer))>0){
     fos.write(buffer, 0, len);
     }
                
     fos.close();
     zis.closeEntry();
     ze = zis.getNextEntry();
     }
            
     zis.close();
     }

     }*/
    public void runTests() {
        String[] args = {};
        programtester.BatchTester.main(args);
    }

}
