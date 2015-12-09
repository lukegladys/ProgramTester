/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.views;

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
        GridLayout experimentLayout = new GridLayout(0,2);
        this.setLayout(experimentLayout);
        this.add(new JLabel("File Name"));
        this.add(new JLabel("Runs"));
        for(int i = 0; i<theProgramTesterCntl.getPossibleTestFiles().size(); i++){
            this.add(new JLabel(theProgramTesterCntl.getPossibleTestFiles().get(i)));
            JSpinner j = new JSpinner();
            this.add(j);
            spinnerList.add(j);
        }

    }
   

    // Changed to boolean – theProgramTesterCntl is never set, so you get a null pointer exception trying to call the next step from this class
    public boolean CreateRuns() {
        for(int i = 0; i<theProgramTesterCntl.getPossibleTestFiles().size(); i++){
            if((int)spinnerList.get(i).getValue() != 0){
                int tempInt = (int)spinnerList.get(i).getValue();
                for(int j = 0; j<tempInt; j++){
                    String tempString = theProgramTesterCntl.getPossibleTestFiles().get(i);
                    tempString = tempString.replace(".java", "");
                    System.out.println(tempString);
                    Run r = new Run(tempString);
                }
            }
        }
        return true;
    }
    
}

