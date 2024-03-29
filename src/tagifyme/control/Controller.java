/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tagifyme.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tagifyme.model.Data;
import tagifyme.view.TagifyMeGUI;
import tagifyme.model.Database;
/**
 *
 * @author pople
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Controller {

    private final TagifyMeGUI theView;
    private final Database theModel;

    
    public Controller(TagifyMeGUI theView, Database theModel) {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addDataButton(new CalculateListener());
        this.theView.addTagButton(new CalculateListener());
        this.theView.deleteTagButton(new CalculateListener());
        this.theView.deleteDataButton(new CalculateListener());
        this.theView.sortButton(new CalculateListener());
        this.theView.fileDialogButton(new CalculateListener());

    }

    
    public class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String command;

            try {
                // Get the JButton command
                command = e.getActionCommand();
                
                if(command == "Add Data"){
                    theView.addData("Test", "Test2", "Test3");
                    theView.addData("Test4", "Test5", "Test6");
                    theView.addData("Test7", "Test8", "Test9");

                }
                
                if(command == "Delete Data"){
                    theView.removeData("Test2");
                }
                
                if(command == "Complete"){
                    String Name = theView.getDataName();
                    String PATH = theView.getDataPATH();
                    theModel.addData(new Data(Name, PATH));
                    theView.addData(Name, PATH, "test");
                }

            } catch (Exception exm) {
                System.out.println(exm.getMessage());
            }

        }

    }

    
}

