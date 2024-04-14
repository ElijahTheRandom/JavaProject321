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
         * Mapping between variable names to strings that are useful
         * when button mashing.
         */
        public static class Command {
            // TODO: I'd prefer to use an Enum, but see
            // https://docs.oracle.com/javase/8/docs/api/java/awt/event/ActionEvent.html
            // It's passing a `String`!
            
            public static String VIEW_ADD_DATA_DIALOG = "VIEW_ADD_DATA_DIALOG";
            public static String ADD_DATA = "ADD_DATA";
            public static String DELETE_DATA = "DELETE_DATA";
            public static String VIEW_ADD_TAG_DIALOG = "VIEW_ADD_TAG_DIALOG";
            public static String ADD_TAG = "ADD_TAG";
            public static String DELETE_TAG = "DELETE_TAG";
        };

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

        private void handleADD_DATA() {
            // TODO
        }

        private void handleDELETE_DATA() {
            // TODO
        }

        private void handleVIEW_ADD_TAG_DIALOG() {
            // TODO
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
                
                if(command == Command.VIEW_ADD_DATA_DIALOG){
                    handleVIEW_ADD_DATA_DIALOG();
                }
                
                if(command == "Delete Data"){
                    String toDelete = theView.deleteSelectedData();
                    Data dataToDelete = theModel.getData(toDelete);
                    theModel.deleteData(dataToDelete);
                }
                
                if(command == "Complete"){
                    String Name = theView.getDataName();
                    String PATH = theView.getDataPATH();
                    String tagName = theView.getTagName();
                    Data newData = new Data(Name, PATH);
                    theModel.addData(newData);
                    Tag correspondingTag = theModel.getTag(tagName);
                    theModel.addRelationship(new Relationship(newData, correspondingTag));
                    theView.addData(Name, PATH, tagName);
                    theView.hideAddDataDialogBox();
                }
                
                if (command == "Add Tag"){
                    theView.showAddTagDialogBox();
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

