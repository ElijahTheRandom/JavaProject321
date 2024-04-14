/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tagifyme.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import tagifyme.model.Data;
import tagifyme.view.TagifyMeGUI;
import tagifyme.model.Database;
import tagifyme.model.Relationship;
import tagifyme.model.Tag;
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
        this.theView.confirmTagButton(new CalculateListener());
        this.theView.confirmDeleteTagButton(new CalculateListener());
    }
    
    public class CalculateListener implements ActionListener {

        /**
         * Populate the UI with dialogs that allow for the
         * addition of data.
         */
        private void handleVIEW_ADD_DATA_DIALOG() {
            // Populate the dialog with the current list of tags.
            theView.populateTagList(theModel.tags());
            // Show the dialog to the user.
            theView.showAddDataDialogBox();
        } 

        /**
         * Process the data from the Add Data Dialog
         * and place it within the model. */
        private void handleADD_DATA() {
            theView.hideAddDataDialogBox(); // Hide the UI from the User.

            // TODO: This `PATH` thing annoys me: it shouldn't be all
            // capitalized -- that's a const!
            Data d = new Data(theView.getDataName(), theView.getDataPATH());
            theModel.addData(d);
            // If we've selected a tag, add the appropriate relationship.
            Tag pT = theModel.getTag(theView.getTagName());
            if (pT != null) {
                theModel.addRelationship(new Relationship(d, pT));
                theView.addData(d.getName(), d.getPATH(), pT.getName());
            } else {
                // If there's no Tag, stick \"\" in there.
                theView.addData(d.getName(), d.getPATH(), "");
            }
        }

        private void handleDELETE_DATA() {
        }

        /**
         * Populate the UI with dialogs that allow for the
         * addition of tags.
         */
        private void handleVIEW_ADD_TAG_DIALOG() {
            theView.showAddTagDialogBox();
        }

        private void handleADD_TAG() {
            // TODO
        }

        private void handleDELETE_TAG() {
            // TODO
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            String command;

            try {
                // Get the JButton command
                command = e.getActionCommand();

                if (command.equals(Command.VIEW_ADD_DATA_DIALOG)) {
                    handleVIEW_ADD_DATA_DIALOG();
                }
                
                if(command == "Delete Data"){
                    String toDelete = theView.deleteSelectedData();
                    Data dataToDelete = theModel.getData(toDelete);
                    theModel.deleteData(dataToDelete);
                }
                
                if (command.equals(Command.ADD_DATA)) {
                    handleADD_DATA();
                }
                
                if (command.equals(Command.VIEW_ADD_TAG_DIALOG)){
                    handleVIEW_ADD_TAG_DIALOG();
                }
                
                if (command == "ADD TAG"){
                    String Name = theView.getNewTagName();
                    theModel.addTag(new Tag(Name));
                    theView.hideAddTagDialogBox();
                }
                if (command == "Delete Tag"){
                    theView.showDeleteTagDialogBox();
                    ArrayList myStrings = new ArrayList<String>();
                    int i = 0;
                    for (Tag tags : theModel.tags() ){
                        i++;
                        if(tags.getName().equals("Undefined")){
                            continue;
                        }
                        myStrings.add(tags.getName());
                    }
                    String[] strings = new String[myStrings.size()];
                    myStrings.toArray(strings);
                    theView.populateTagDeleteList(strings);
                }
                if (command == "DELETE TAG"){
                    String Name = theView.getDeletedTagName();
                    Tag toDelete = theModel.getTag(Name);
                    //theModel.deleteTag(toDelete); broken?
                    theView.deleteSelectedTag(Name);
                    theView.hideDeleteTagDialogBox();
                }

            } catch (Exception exm) {
                System.out.println(exm.getMessage());
            }
        }
    }
}

