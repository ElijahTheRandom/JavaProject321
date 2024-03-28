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

    }

}

