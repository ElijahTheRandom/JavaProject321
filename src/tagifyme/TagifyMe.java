package tagifyme;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import tagifyme.view.TagifyMeGUI;
import tagifyme.control.Controller;
import tagifyme.model.Database;
import tagifyme.dummy.DummyData;

/**
 * Main file that combines all the other files into one
 * operable unit
 * @author team 8
 */
public class TagifyMe {

  private static String filePath_folder_format = "%s/S2_T8";
  private static String filePath_format = "%s/S2_T8/tagifyme.db";
  
  public static void main(String[] args) throws ClassNotFoundException {
    TagifyMeGUI theView = new TagifyMeGUI();
    
    // Comment this out for non-debug builds.
    // Database theModel = new Database();
    Database theModel = load_db();
    if (theModel == null) {
      theModel = DummyData.init();
    }
    theModel.addObserver(theView);
    
    Controller theController = new Controller(theView, theModel);    
    theView.setVisible(true);
  }

  /**
   * Note: there's side effects to this function; if it doesn't
   * exist the function attempt to create the folder.
   */
  private static Database load_db() throws ClassNotFoundException {
    String filePath = String.format(filePath_format, System.getProperty("user.home"));
    File f = new File(filePath);

    if (!f.exists()) {
      // There's no file here -- so let's create the directory.
      File folder = new File(String.format(filePath_folder_format, System.getProperty("user.home")));
      folder.mkdir();
    } else {
      try (FileInputStream fis = new FileInputStream(filePath);
      ObjectInputStream in = new ObjectInputStream(fis))
      {
          return (Database) in.readObject();
      }
      catch (Exception e) {
          e.printStackTrace();
      }
    }
    // There's some error.
    return null;
  }
}
