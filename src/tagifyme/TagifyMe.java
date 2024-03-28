package tagifyme;

import tagifyme.view.TagifyMeGUI;
import tagifyme.control.Controller;
import tagifyme.model.Database;

public class TagifyMe {
  public static void main(String[] args) {
    TagifyMeGUI theView = new TagifyMeGUI();
    
    Database theModel = new Database();
    
    Controller theController = new Controller(theView, theModel);
    
    theView.setVisible(true);
  }
}
