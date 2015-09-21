/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import programtester.models.Run;

/**
 *
 * @author Nia
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class InputsCntl {    
    
    public InputsCntl(){
        Run newRun1 = new Run ("Factorial");
        Run newRun2 = new Run ("Factorial");
        Run newRun3 = new Run ("ArraySearcher");
        Run newRun4 = new Run ("ArraySearcher");
        Run newRun5 = new Run ("TestProgram");
        int counter = 0;
        //ScannerInputs newScannerInput = new ScannerInputs(Run.getRunList().get(counter).getFileName(), counter, Run.getRunList().size(), this);
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
    
    
}
