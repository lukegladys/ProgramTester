/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheronysp1programtester;

import java.util.ArrayList;

/**
 *
 * @author Nia
 */
public class Run {
    
    private static ArrayList<Run> theRunList = new ArrayList<Run>();
    private String fileName;
    private String cmdArgs;
    private String scannerArgs;
    
    public Run(String fileName){
        this.fileName = fileName;
        getRunList().add(this);
    }
    
    public static ArrayList<Run> getRunList(){
        return theRunList;
    }
    
    public String getFileName(){
        return fileName;
    }
    public String getCmdArgs(){
        return cmdArgs;
    }
    public String getScannerArgs(){
        return scannerArgs;
    }
    public void setCmdArgs(String cmdArgs){
        this.cmdArgs = cmdArgs;
    }
    public void setScannerArgs(String scannerArgs){
        this.scannerArgs = scannerArgs;
    }
    
    
}
