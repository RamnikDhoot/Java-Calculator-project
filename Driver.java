package calculator;

/**
 * This class starts the GUI.
 * 
 * @author zkac269
 *
 */
public class Driver {
  /**
   * This is the main method to start the calculator and bring up the GUI.
   * 
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    ViewInterface view = new AsciiView();

    CalcModel model = new CalcModel();
    System.out.println("hello");
    
    // Decide which view to build.
    if (System.console() == null) {
      System.out.println("hello");
      view = MyView.getInstance();
    }
    new CalcController(model, view);
    view.menu();
  } // This code is from the example code MVC separated

  
}
