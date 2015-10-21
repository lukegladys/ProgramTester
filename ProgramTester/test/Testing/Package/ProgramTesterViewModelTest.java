/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.Package;

import org.junit.*;
import java.io.*;
import static org.junit.Assert.*;
import programtester.models.*;
import programtester.controllers.*;

/**
 *
 * @author Nia
 */
public class ProgramTesterViewModelTest {
  @BeforeClass
  public static void setupTests()
  {
    System.out.println("Starting Tests of ProgramTesterViewModel Class");
  }
  
  @Before
  public void setupTest()
  {
    ProgramTesterCntl theProgramTesterCntl = new ProgramTesterCntl();  
    for (int i = 0; i<=10; i++){
        Run theRun = new Run("thefilename_"+i);
        theRun.setCmdArgs("CmdArg" + i);
        theRun.setScannerArgs("ScannerArg" + i);
    }
    theProgramTesterCntl.getCurrentViewModel().printFiles();
  }
  
  @Test
  public void testPrintFiles(){
      testCmdArgs();
      testScannerArgs();
  }
  
  public void testCmdArgs(){
    //Some code in this test based on Cave Of Programming's Java Reading and Writing Files tutorial
      String fileName = "args.txt";
      String line = null;
      int counter = 0;
      boolean resultsAreEqual = false;
      try {
          FileReader fileReader = 
              new FileReader(fileName);
          BufferedReader bufferedReader = 
              new BufferedReader(fileReader);
          while((line = bufferedReader.readLine()) != null) {
              System.out.println(line + " --> " + "thefilename_" + counter + " CmdArg" + counter);
              if(!line.equals("thefilename_" + counter + " CmdArg" + counter)){
                  resultsAreEqual = false;
                  break;
              } else{
                  resultsAreEqual = true;
                  counter++;
              }
          }   
          bufferedReader.close();
          if(resultsAreEqual){
              System.out.println("CmdArgs are functioning properly.");
          } else{
              System.out.println("CmdArgs are not functioning properly.");
          }
          assertTrue(resultsAreEqual);
      }
      catch(FileNotFoundException ex) {
          System.out.println(
              "Unable to open the following file: " + fileName);                
      }
      catch(IOException ex) {
          System.out.println(
              "Error reading the following file: " + fileName);                  
      }
  }
  
  public void testScannerArgs(){
    //Some code in this test based on Cave Of Programming's Java Reading and Writing Files tutorial
      String fileName = "TestInput.txt";
      String line = null;
      int counter = 0;
      boolean resultsAreEqual = false;
      try {
          FileReader fileReader = 
              new FileReader(fileName);
          BufferedReader bufferedReader = 
              new BufferedReader(fileReader);
          while((line = bufferedReader.readLine()) != null) {
              System.out.println(line + " --> " + "ScannerArg" + counter);
              if(!line.equals("ScannerArg" + counter)){
                  resultsAreEqual = false;
                  break;
              } else{
                  resultsAreEqual = true;
                  counter++;
              }
          }   
          bufferedReader.close();
          if(resultsAreEqual){
              System.out.println("ScannerArgs are functioning properly.");
          } else{
              System.out.println("ScannerArgs are not functioning properly.");
          }
          assertTrue(resultsAreEqual);
      }
      catch(FileNotFoundException ex) {
          System.out.println(
              "Unable to open the following file: " + fileName);                
      }
      catch(IOException ex) {
          System.out.println(
              "Error reading the following file: " + fileName);                  
      }  
  }
  
  @After
  public void teardownTest()
  {
    for(int i = 0; i<=10; i++){
        Run.getRunList().remove(10-i);
    }
    System.out.println("Run List Size: " + Run.getRunList().size());
    if(Run.getRunList().size() == 0 ){
        System.out.println("Runs removed");
    }
    else{
        System.out.println("Runs not removed");
    }
  }
  
  @AfterClass
  public static void teardownTests()
  {
    System.out.println("All ProgramTesterViewModel Tests Finished");
  }
}
