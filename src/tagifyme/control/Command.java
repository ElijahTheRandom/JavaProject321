package tagifyme.control;

/**
 * Mapping between variable names to strings that are useful
 * when button mashing.
 */
public class Command {
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
