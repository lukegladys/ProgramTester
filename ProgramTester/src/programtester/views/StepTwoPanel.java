/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.views;

import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import programtester.controllers.ProgramTesterCntl;
import programtester.models.Run;

/**
 *
 * @author Luke
 */
public class StepTwoPanel extends JPanel {

    //private ProgramTesterCntl theProgramTesterCntl; // NEVER GETS SET?

    private JTextField fileNameField1;
    private JTextField fileNameField2;
    private JComboBox box1;
    private JComboBox box2;

    public StepTwoPanel(ProgramTesterCntl parentProgramTesterCntl) {
        this.setLayout(null);

        JLabel filenamePrompt = new JLabel("Filename");
        filenamePrompt.setBounds(100, 150, 250, 50);
        this.add(filenamePrompt);

        fileNameField1 = new JTextField();
        fileNameField1.setBounds(100, 200, 200, 25);
        this.add(fileNameField1);

        fileNameField2 = new JTextField();
        fileNameField2.setBounds(100, 250, 200, 25);
        this.add(fileNameField2);

        JLabel numberOfRunsPrompt = new JLabel("Number of runs");
        numberOfRunsPrompt.setBounds(350, 150, 250, 50);
        this.add(numberOfRunsPrompt);

        String[] runOptions = {"1", "2", "3", "4", "5"};
        box1 = new JComboBox(runOptions);
        box1.setBounds(350, 200, 150, 25);
        this.add(box1);

        box2 = new JComboBox(runOptions);
        box2.setBounds(350, 250, 150, 25);
        this.add(box2);
    }

    // Changed to boolean – theProgramTesterCntl is never set, so you get a null pointer exception trying to call the next step from this class
    public boolean CreateRuns() {
        String fileName1 = fileNameField1.getText();
        String fileName2 = fileNameField2.getText();
        String run1 = (String) box1.getSelectedItem();
        int runs1 = Integer.parseInt(run1);
        String run2 = (String) box2.getSelectedItem();
        int runs2 = Integer.parseInt(run2);

        // Create/add runs for the first file
        if (!fileName1.equals("")) {
            for (int i = 0; i < runs1; i++) {
                Run r = new Run(fileName1);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(),
                    "File name 1 empty",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        // Create/add runs for the second file (if applicable)
        if (!fileName2.equals("")) {
            for (int i = 0; i < runs2; i++) {
                Run r = new Run(fileName2);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(),
                    "File name 2 empty",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        // Changed if -> call step(4) to return true/false if it validated/failed
        return !fileName1.equals("") && !fileName2.equals("");
    }
}
