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
public class RunTest {
    
  @BeforeClass
  public static void setupTests()
  {
    System.out.println("Starting Tests of Run Class");
  }
  
  @Before
  public void setupTest()
  {
	for (int i = 0; i<=10; i++){
            Run theRun = new Run("thefilename_"+i);
        }
  }
  
  @Test
  public void testRunList() 
  {
    boolean resultsAreEqual = false;
    for(int i = 0; i<Run.getRunList().size(); i++){
        if(!Run.getRunList().get(i).getFileName().equals("thefilename_"+i)){
            resultsAreEqual = false;
            break;
        }
        else{
            resultsAreEqual = true;
        }
    }
    assertTrue(resultsAreEqual);
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
    System.out.println("All Run Tests Finished");
  }
}
