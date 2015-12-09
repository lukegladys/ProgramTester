/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.Package;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import programtester.views.StepTwoPanel;
import programtester.controllers.ProgramTesterCntl;
import programtester.models.Run;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 *
 * @author Nia
 */
public class StepTwoPanelTest {
    
    public static String sampleText1 = "sampletext1";
    public static String sampleText2 = "sampletext2";
    public static int selectedIndex1 = 0;
    //index 0 corresponds to int 1
    public static int selectedIndex2 = 4;
    //index 4 corresponds to int 5
    ProgramTesterCntl theProgramTesterCntl = new ProgramTesterCntl();
    StepTwoPanel theStepTwoPanel = new StepTwoPanel (theProgramTesterCntl);
    
    public StepTwoPanelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Panel 2");
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("End Testing Panel 2");
    }
    
    @Before
    public void setUp() {
//        theStepTwoPanel.getFileNameField1().setText(sampleText1);
//        theStepTwoPanel.getFileNameField2().setText(sampleText2);
//        theStepTwoPanel.getBox1().setSelectedIndex(selectedIndex1);
//        theStepTwoPanel.getBox2().setSelectedIndex(selectedIndex2);
    }
    
    @After
    public void tearDown() {
        for(int i = 0; i<=5; i++){
        Run.getRunList().remove(5-i);
        //System.out.println("Run List Size: " + Run.getRunList().size());
    }
    if(Run.getRunList().size() == 0 ){
        System.out.println("Runs removed");
    }
    else{
        System.out.println("Runs not removed");
    }
    }

    /**
     * Test of CreateRuns method, of class StepTwoPanel.
     */
    @Test
    public void testCreateRuns() {
        System.out.println("CreateRuns");   
        theStepTwoPanel.CreateRuns();
        assertEquals(Run.getRunList().get(0).getFileName(), sampleText1);
        assertEquals(Run.getRunList().get(1).getFileName(), sampleText2);
        assertEquals(Run.getRunList().get(2).getFileName(), sampleText2);
        assertEquals(Run.getRunList().get(3).getFileName(), sampleText2);
        assertEquals(Run.getRunList().get(4).getFileName(), sampleText2);
        assertEquals(Run.getRunList().get(5).getFileName(), sampleText2);
    }
    
}
