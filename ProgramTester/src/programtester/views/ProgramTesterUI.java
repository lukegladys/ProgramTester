/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.views;

import javax.swing.JFrame;
import programtester.controllers.ProgramTesterCntl;
import programtester.models.ProgramTesterViewModel;

/**
 *
 * @author Luke
 */
public class ProgramTesterUI extends JFrame {

    ProgramTesterCntl theProgramTesterCntl;

    public ProgramTesterUI(ProgramTesterCntl parentProgramTesterCntl) {
        theProgramTesterCntl = parentProgramTesterCntl;
        initComponents(parentProgramTesterCntl.getCurrentViewModel());

        this.setSize(650, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void initComponents(ProgramTesterViewModel theProgramTesterViewModel) {
        this.getContentPane().add(theProgramTesterViewModel);
    }
}
