/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.views;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import programtester.controllers.*;
import programtester.models.*;

/**
 *
 * @author Luke
 */
public class StepThreePanel extends JPanel {

    private ProgramTesterCntl theProgramTesterCntl;

    private JLabel fileNameLabel = new JLabel();
    private JLabel runNumberLabel = new JLabel();
    private JTextField cmdArgsField = new JTextField();
    private JTextField scannerInputField = new JTextField();
    private JRadioButton noScannerRadioButton = new JRadioButton();

    public StepThreePanel(ProgramTesterCntl parentProgramTesterCntl) {

        this.theProgramTesterCntl = parentProgramTesterCntl;

        this.setLayout(null);

        fileNameLabel.setBounds(30, 30, 100, 20);
        fileNameLabel.setText(Run.getRunList().get(this.theProgramTesterCntl.getCurrentViewModel().getRunNumber()).getFileName());
        this.add(fileNameLabel);

        JLabel cmdArgs = new JLabel();
        cmdArgs.setBounds(100, 125, 150, 20);
        cmdArgs.setText("Command-Line Args: ");
        this.add(cmdArgs);

        JLabel scnrInput = new JLabel();
        scnrInput.setBounds(100, 150, 150, 20);
        scnrInput.setText("Scanner Input: ");
        this.add(scnrInput);

        cmdArgsField.setBounds(250, 125, 200, 20);
        cmdArgsField.setText("");
        this.add(cmdArgsField);

        scannerInputField.setBounds(200, 150, 250, 20);
        scannerInputField.setText("");
        this.add(scannerInputField);

        noScannerRadioButton.setBounds(200, 175, 100, 30);
        noScannerRadioButton.setText("None");
        this.add(noScannerRadioButton);

    }

    public void DoRuns() {
        Run.getRunList().get(this.theProgramTesterCntl.getCurrentViewModel().getRunNumber()).setCmdArgs(cmdArgsField.getText());
        if (noScannerRadioButton.isSelected()) {
            Run.getRunList().get(this.theProgramTesterCntl.getCurrentViewModel().getRunNumber()).setScannerArgs("None");
        } else {
            Run.getRunList().get(this.theProgramTesterCntl.getCurrentViewModel().getRunNumber()).setScannerArgs(scannerInputField.getText());
        }
        if (this.theProgramTesterCntl.getCurrentViewModel().getRunNumber() + 1 < Run.getRunList().size()) {
            this.theProgramTesterCntl.getCurrentViewModel().setRunNumber(this.theProgramTesterCntl.getCurrentViewModel().getRunNumber() + 1);
            theProgramTesterCntl.step(3);
        } else {
            this.theProgramTesterCntl.getCurrentViewModel().printFiles();
            //theProgramTesterCntl.runTests(); // still need to configure outputs before running the tests
            theProgramTesterCntl.step(4);
        }
    }
}
