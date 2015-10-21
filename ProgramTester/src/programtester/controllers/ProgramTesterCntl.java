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
import programtester.views.ProgramTesterUI;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.core.ZipFile;

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

    public void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    public void moveAndUnzipFiles() {
        deleteFolder(this.currentViewModel.getSrcOutputFolder());
        ArrayList<String> source = new ArrayList();
        String destination = this.currentViewModel.getSrcOutputFolder().toString();
        ZipFile zipFile;

        for (File f : this.currentViewModel.getSelectedZippedFiles()) {
            source.add(f.getPath());
        }

        for (String s : source) {
            try {
                zipFile = new ZipFile(s);
                zipFile.extractAll(destination);
            } catch (ZipException e) {
                e.printStackTrace();
            }
        }

    }

    public void runTests() {
        String[] args = {};
        programtester.BatchTester.main(args);
    }

}
