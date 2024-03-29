/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tagifyme.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    }

    
    public class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String command;

            try {
                // Get the JButton command
                command = e.getActionCommand();
                
                if(command == "Add Data"){
                    theView.addData("Test", "Test2");
                    theModel.notifyObservers();
                }
                
                if(command == "Delete Data"){
                    theView.removeData("Test2");
                }

            } catch (Exception exm) {
                System.out.println(exm.getMessage());
            }

        }

    }

    
}
