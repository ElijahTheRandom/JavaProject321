package tagifyme.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tagifyme.model.Data;
import tagifyme.view.TagifyMeGUI;
import tagifyme.model.Database;
import tagifyme.model.Relationship;
import tagifyme.model.Tag;

/**
 * Top-level Controller for MVC.
 */
public class Controller {

    // Point to the other two objects within the MVC.
    private final TagifyMeGUI theView;
    private final Database theModel;
    
    public Controller(TagifyMeGUI theView, Database theModel) {
        this.theView = theView;
        this.theModel = theModel;
        
        // TODO: Perhaps this isn't all pointing toward a single listener,
        // but is refactored into multiple listeners/classes?
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

        // TODO: These "notifyObservers" code should be within
        // the Database; the solution is coming to pieces when
        // adding Data/Relationships seperately. I bet if you
        // extend the Database class to have a method that handles
        // both, you'll be fine.

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

            // TODO: Should this go within the model code?
            // Propagate the changes up to the model.
            theModel.notifyObservers();
        }

        /**
         * The User has selected some Data to delete, propagate
         * that downward to the model.
         */
        private void handleDELETE_DATA() {
            Data d = theView.selectedData(); // This can return null.

            if (d != null) {
                theModel.deleteData(theView.selectedData());
                // TODO: Should this go within the model code?
                // Propagate the changes up to the model.
                theModel.notifyObservers();
            }
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
            // think it should be `Strings`. ERJ - 2024/4/18
            // It shouldn't be Strings, but it's going to be Strings.
            theView.populateTagDeleteList(theModel.allTags());
                        
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

            // TODO: Should this go within the model code?
            // Propagate the changes up to the model.
            theModel.notifyObservers();
        }

        /**
         * The user has attempted to input something into the filter,
         * Attempt to filter for it.
         */
        private void handle_FILTER() {
            System.out.println("HELLO!");
            System.out.println(theView.getFilterField());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String command = e.getActionCommand();
                if (command.equals(Command.VIEW_ADD_DATA_DIALOG)) {
                    handleVIEW_ADD_DATA_DIALOG();
                } else if (command.equals(Command.DELETE_DATA)) {
                    handleDELETE_DATA();
                } else if (command.equals(Command.ADD_DATA)) {
                    handleADD_DATA();
                } else if (command.equals(Command.VIEW_ADD_TAG_DIALOG)) {
                    handleVIEW_ADD_TAG_DIALOG();
                } else if (command.equals(Command.ADD_TAG)) {
                    handleADD_TAG();
                } else if (command.equals(Command.VIEW_DELETE_TAG_DIALOG)) {
                    handleVIEW_DELETE_TAG_DIALOG();
                } else if (command.equals(Command.DELETE_TAG)) {
                    handleDELETE_TAG();
                } else if (command.equals(Command.SAVE)) {
                    // TODO: Handle Saving the Data.
                } else if (command.equals(Command.FILTER)) {
                    handle_FILTER();
                }
            } catch (Exception exm) {
                System.out.println(String.format("%d: Controller error %S", System.currentTimeMillis(), exm.getMessage()));
            }
        }
    }
}

