//package programtester;

/**
 * Program Tester GUI Controller
 * @author J. Barclay Walsh
 */
public final class ProgramTesterController {
    
    public ProgramTesterController() {
        this.showProgramTesterController();
    }
    
    // Open the course tester GUI
    public void showProgramTesterController() {
        ProgramTesterGUI theProgramTesterGUI = new ProgramTesterGUI();
        theProgramTesterGUI.setVisible(true);
    }
    
}
