/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import programtester.controllers.ProgramTesterCntl;
import programtester.models.Run;

/**
 *
 * @author Luke
 */
public class StepTwoPanel extends JPanel {

    private ProgramTesterCntl theProgramTesterCntl;
    private JPanel panel;
    private JScrollPane scroll;
    private ArrayList<JSpinner> spinnerList = new ArrayList<JSpinner>();

    public StepTwoPanel(ProgramTesterCntl parentProgramTesterCntl) {
        this.theProgramTesterCntl = parentProgramTesterCntl;
        this.setLayout(new BorderLayout());
        
        String instructions = "The program has looked through each student's "
                + "folder and aggregated a list of all .java file names in "
                + "the students' folders. For each file name, use the spinner "
                + "to select the number of runs for each file. If you don't "
                + "want to run a file, leave the spinner at \"0\".";
        LabelArea instructionsLabel = new LabelArea(instructions);
        this.add(instructionsLabel, BorderLayout.NORTH);
        
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new GridLayout(0,2));
        innerPanel.add(new JLabel("File Name"));
        innerPanel.add(new JLabel("Runs"));
        for(int i = 0; i<theProgramTesterCntl.getPossibleTestFiles().size(); i++){
            innerPanel.add(new JLabel(theProgramTesterCntl.getPossibleTestFiles().get(i)));
            JSpinner j = new JSpinner();
            innerPanel.add(j);
            spinnerList.add(j);
        }
        
        this.add(innerPanel, BorderLayout.CENTER);

    }
    
    public ArrayList<JSpinner> getSpinnerList(){
        return spinnerList;
    }

    // Changed to boolean – theProgramTesterCntl is never set, so you get a null pointer exception trying to call the next step from this class
    public boolean CreateRuns() {
        for(int i = 0; i<theProgramTesterCntl.getPossibleTestFiles().size(); i++){
            if((int)spinnerList.get(i).getValue() != 0){
                int tempInt = (int)spinnerList.get(i).getValue();
                for(int j = 0; j<tempInt; j++){
                    String tempString = theProgramTesterCntl.getPossibleTestFiles().get(i);
                    tempString = tempString.replace(".java", "");
                    //System.out.println(tempString);
                    Run r = new Run(tempString);
                }
            }
        }
        return true;
    }
    
}

