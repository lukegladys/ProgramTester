/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import programtester.controllers.OutputPathChooserController;
import programtester.controllers.ProgramTesterCntl;

/**
 *
 * @author Luke
 */
public class ProgramTesterViewModel{
    
    private ProgramTesterCntl theProgramTesterCntl;
    
    // <editor-fold defaultstate="collapsed" desc="Step 1: Set files-dir, files-zip and files-test folder locations">
    private File[] studentFolders;
    //private File filesDir = new File("src/files-dir/");
    private File configBatchFile = new File("configBatch.txt");
    private File srcOutputFolder = new File("/src-output/");
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 2: Flag master folder">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 3: Input names of files and the number of runs for each file">
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 4: Specify scanner and cmd inputs">
    private int runNumber = 0;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 5: Specify output folder and output file name. Specify whether student name or student handle should be used in the output file">
    OutputPathChooserController theOutputPathChooserController;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Step 6: Run and open the output file">
    // </editor-fold>

    public int getRunNumber(){
        return runNumber;
    }
    public void setRunNumber(int runNumber){
        this.runNumber = runNumber;
    }
    
    public void printFiles(){
        try{
            PrintWriter pw = new PrintWriter(new FileWriter("args.txt"));

            for(int i = 0; i < Run.getRunList().size(); i++){
                pw.println(Run.getRunList().get(i).getFileName() + " " + Run.getRunList().get(i).getCmdArgs());
            }

            pw.close();

            PrintWriter pwt = new PrintWriter(new FileWriter("TestInput.txt"));

            for(int i = 0; i < Run.getRunList().size(); i++){
                pwt.println(Run.getRunList().get(i).getScannerArgs());
            }

            pwt.close();
        }catch(IOException ex)
            {
            ex.printStackTrace();
            }
    }
    
    public ProgramTesterViewModel(ProgramTesterCntl parentProgramTesterCntl) {
        this.theProgramTesterCntl = parentProgramTesterCntl;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Step 1 accessors/mutators">
    public File[] getSelectedUnzippedFiles(){
        return this.studentFolders;
    }
    public void setSelectedUnzippedFiles(File theFiles){
        this.studentFolders = theFiles.listFiles();
    }
    
    
    public File getConfigBatchFile(){
        return this.configBatchFile;
    }
    public void setConfigBatchFile(File theFile){
        this.configBatchFile = theFile;
    }
    
    public File getSrcOutputFolder(){
        return this.srcOutputFolder;
    }
    // </editor-fold>
    
}
