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
            theView.populateTagList(theModel.allTags());
            // Show the dialog to the user.
            theView.showAddDataDialogBox();
        } 

        /**
         * Process the data from the Add Data Dialog
         * and place it within the model.
         */
        private void handleADD_DATA() {
            theView.hideAddDataDialogBox(); // Hide the UI from the User.

            // TODO: This `PATH` thing annoys me: it shouldn't be all
            // capitalized -- that's a const!
            Data d = new Data(theView.getDataName(), theView.getDataPATH());
            theModel.addData(d);
            // If we've selected a tag, add the appropriate relationship.
            Tag pT = theModel.getTag(theView.getTagName());
            String pTName = "";
            if (pT != null) {
                theModel.addRelationship(new Relationship(d, pT));
                pTName = pT.getName();
            }

            // Propagate the changes to the model.
            theView.addData(d.getName(), d.getPATH(), pTName);
        }

        /**
         * The User has selected some Data to delete, propagate
         * that downward to the model.
         */
        private void handleDELETE_DATA() {
            // TODO: It's likely that this should be renamed
            // as a getter.
            String nameToDelete = theView.deleteSelectedData();
            theModel.deleteDataByPATH(nameToDelete);
        }

        /**
         * Populate the UI with dialogs that allow for the
         * addition of tags.
         */
        private void handleVIEW_ADD_TAG_DIALOG() {
            theView.showAddTagDialogBox();
        }

        /**
         * Populate the UI with dialogs that allow for the
         * deletion of Tags.
         */
        private void handleVIEW_DELETE_TAG_DIALOG() {
            // TODO: What to populate the list with? I don't
            // think it should be `Strings`.
            // theView.populateTagDeleteList(theModel.allTags());
                        
            // Show the UI to the user.
            theView.showDeleteTagDialogBox();
        }

        /**
         * The User has requested to add some Tag, propagate
         * that down to the model.
         */
        private void handleADD_TAG() {
            // Hide the dialog from the User, then fetch the new Tag name
            // from the view, then push to the model.
            theView.hideAddTagDialogBox();
            theModel.addTag(new Tag(theView.getNewTagName()));
        }

        /**
         * The user has requested to delete some Tag, propagate
         * that down to the model.
         */
        private void handleDELETE_TAG() {
            theView.hideDeleteTagDialogBox();
            theModel.deleteTag(new Tag(theView.getDeletedTagName()));
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
                
                if (command.equals(Command.DELETE_DATA)) {
                    handleDELETE_DATA();
                }
                
                if (command.equals(Command.ADD_DATA)) {
                    handleADD_DATA();
                }
                
                if (command.equals(Command.VIEW_ADD_TAG_DIALOG)){
                    handleVIEW_ADD_TAG_DIALOG();
                }
                
                if (command.equals(Command.ADD_TAG)){
                    handleADD_TAG();
                }

                if (command.equals(Command.VIEW_ADD_TAG_DIALOG)){
                    handleVIEW_DELETE_TAG_DIALOG();
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

