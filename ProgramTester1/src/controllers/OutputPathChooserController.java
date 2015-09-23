/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Andrew
 */
public final class OutputPathChooserController {
    
    private String fileName;
    private String outputPath;
    private boolean nameSelected;
    private boolean handleSelected;
    
    public OutputPathChooserController() {
        //this.showOutputPathChoserGUI();
    }
    
    /*public void showOutputPathChoserGUI() {
        this.theOutputPathChooserGUI = new OutputPathChooserGUI(this);
        this.theOutputPathChooserGUI.setVisible(true);
    }
    
    public void showOutputTitleChooserGUI() {
        this.theOutputTitleChooserGUI = new OutputTitleChooserGUI(this);
        this.theOutputTitleChooserGUI.setVisible(true);
    }*/
    
    public void setFileName(String newFileName) {
        this.fileName = newFileName;
        System.out.println(fileName);
    }
    
    public String getFileName() {
        return this.fileName;
    }
    
    public void setOutputPath(String newOutputPath) {
        this.outputPath = newOutputPath;
        System.out.println(outputPath);
    }
    
    public String getOutputPath() {
        return this.outputPath;
    }
    
    public void setSelectedTitle(boolean name, boolean handle) {
        nameSelected = name;
        handleSelected = handle;
    }
    
    public boolean getSelectedtitle(){
        if(nameSelected){
            //System.out.println("Name");
            return nameSelected;     
        }
        else {
            //System.out.println("Handle");
            return handleSelected;
        }
    }
        
}

