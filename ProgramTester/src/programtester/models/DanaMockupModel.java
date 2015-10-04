/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programtester.models;

import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import programtester.models.Run;

/**
 *
 * @author dqc5226
 */
public class DanaMockupModel implements ActionListener
{
    JFrame frame;
    JPanel panel;
    
    JLabel filenamePrompt;
    JLabel numberOfRunsPrompt;
    
    JTextField fileNameField1;
    JTextField fileNameField2;
    
    JComboBox runsBox1;
    JComboBox runsBox2;
    
    JButton next;
    
    // Outputs
    String fileName1 = "";
    String fileName2 = "";
    int runs1 = 0;
    int runs2 = 0;
    ArrayList<Run> runList;
    
    public DanaMockupModel()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 500);
        frame.setLayout(null);
        panel = new JPanel();
        panel.setSize(650, 500);
        panel.setLayout(null);
        
        frame.add(panel);
        
        filenamePrompt = new JLabel("Filename");
        filenamePrompt.setBounds(100, 150, 250, 50);
        panel.add(filenamePrompt);
        
        fileNameField1 = new JTextField();
        fileNameField1.setBounds(100, 200, 200, 25);
        panel.add(fileNameField1);
        fileNameField2 = new JTextField();
        fileNameField2.setBounds(100, 250, 200, 25);
        panel.add(fileNameField2);
        
        
        numberOfRunsPrompt = new JLabel("Number of runs");
        numberOfRunsPrompt.setBounds(350, 150, 250, 50);
        panel.add(numberOfRunsPrompt);
        
        String[] runOptions = {"1", "2", "3", "4", "5"};
        runsBox1 = new JComboBox(runOptions);
        runsBox1.setBounds(350, 200, 150, 25);
        runsBox1.addActionListener(this);
        panel.add(runsBox1);
        
        runsBox2 = new JComboBox(runOptions);
        runsBox2.setBounds(350, 250, 150, 25);
        runsBox2.addActionListener(this);
        panel.add(runsBox2);
        
        next = new JButton("Next");
        next.setBounds(300, 425, 325, 25);
        next.addActionListener(this);
        panel.add(next);
        
        frame.setVisible(true);
        panel.setVisible(true);
    }
    
    public void buildRunList()
    {
        //runList = new ArrayList();
        fileName1 = fileNameField1.getText();
        fileName2 = fileNameField2.getText();
        
        // Create/add runs for the first file
        if (!fileName1.equals(""))
        {
            for (int i = 0; i < runs1; i++)
            {
                Run r = new Run(fileName1);
                //runList.add(r);
            }
        }
        else
            System.out.println("File name 1 empty");
        
        // Create/add runs for the second file (if applicable)
        if (!fileName2.equals(""))
        {
            for (int i = 0; i < runs2; i++)
            {
                Run r = new Run(fileName2);
                //runList.add(r);
            }
        }
        else
            System.out.println("File name 2 empty");
        
        
        // Debugging - print the content of the run list
        System.out.println("Content of runList: ");
        for (Run r : Run.getRunList())
        {
            System.out.println(r.getFileName());
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Object o = e.getSource();
        
        if (o == next)
        {
            buildRunList();
        }
        
        if (o == runsBox1 || o == runsBox2)
        {
            JComboBox cb = (JComboBox) o;
            String numRuns = (String) cb.getSelectedItem();
            if (o == runsBox1)
            {
                runs1 = Integer.parseInt(numRuns);
            }
            else
            {
                runs2 = Integer.parseInt(numRuns);
            }
        }
        
        
    }
    
}
