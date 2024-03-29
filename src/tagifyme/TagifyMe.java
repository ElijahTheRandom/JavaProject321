package tagifyme;

import tagifyme.view.TagifyMeGUI;
import tagifyme.control.Controller;
import tagifyme.model.Database;
import tagifyme.dummy.DummyData;

public class TagifyMe {
  public static void main(String[] args) {
    TagifyMeGUI theView = new TagifyMeGUI();
    
    // Comment this out for non-debug builds.
    // Database theModel = new Database();
    Database theModel = DummyData.init();
    theModel.addObserver(theView);
    
    Controller theController = new Controller(theView, theModel);
    theModel.notifyObservers();
    
    theView.setVisible(true);
  }
}
