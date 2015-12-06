/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.Package;

import org.junit.*;
import static org.junit.Assert.*;
import programtester.models.*;
/**
 *
 * @author Nia
 */
public class ProgramTesterUITest {
  @BeforeClass
  public static void setupTests()
  {
    System.out.println("Starting Tests of ProgramTesterUI Class");
  }
  
  @Before
  public void setupTest()
  {
	System.out.println("Test setup complete.");
  }
  
  private void buildRuns(String fileNameField1, int numberRuns1, String fileNameField2, int numberRuns2) {
        //runList = new ArrayList();
        String fileName1 = fileNameField1;
        String fileName2 = fileNameField2;
        int runs1 = numberRuns1;
        int runs2 = numberRuns2;

        // Create/add runs for the first file
        if (!fileName1.equals("")) {
            for (int i = 0; i < runs1; i++) {
                Run r = new Run(fileName1);
            }
        } else {
            System.out.println("File name 1 empty");
        }

        // Create/add runs for the second file (if applicable)
        if (!fileName2.equals("")) {
            for (int i = 0; i < runs2; i++) {
                Run r = new Run(fileName2);
            }
        } else {
            System.out.println("File name 2 empty");
        }
    }
  
  @Test
  public void testBuildRuns() 
  {
    buildRuns("This is the first run", 2, "This is the second run", 3);
    for(int i = 0; i<Run.getRunList().size(); i++){
        if(i == 0 || i == 1){
            assertTrue(Run.getRunList().get(i).getFileName().equals("This is the first run"));
        }
        else{
            assertTrue(Run.getRunList().get(i).getFileName().equals("This is the second run"));
        }
    }
  }
  
  @After
  public void teardownTest()
  {
    for (int i = 4; i>=0; i--){
            Run.getRunList().remove(i);
    }
  }
  
  @AfterClass
  public static void teardownTests()
  {
      System.out.println("Runs: " + Run.getRunList().size());
    System.out.println("All ProgramTesterUI Tests Finished");
  }
}
