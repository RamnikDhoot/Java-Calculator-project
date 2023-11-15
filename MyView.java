package calculator;

import java.io.IOException;
import java.util.function.Consumer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This class is the JavaFX view that contains the data for the GUI. It is filled by the fxml loader
 * at runtime.
 * 
 * @author zkac269
 *
 */
public class MyView extends Application implements ViewInterface {
  ///////////////////////////////////////////////////////////////////////////////// taken from MVC
  ///////////////////////////////////////////////////////////////////////////////// separated
  ///////////////////////////////////////////////////////////////////////////////// example to try
  ///////////////////////////////////////////////////////////////////////////////// and ix my GUI
  ///////////////////////////////////////////////////////////////////////////////// but still didn't
  ///////////////////////////////////////////////////////////////////////////////// work
  // Block for creating an instance variable for others to use.
  //
  // Make it a JavaFX singleton. Instance is set by the javafx "initialise" method
  private volatile static MyView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * This method is used so that there is only one instance of MyView at any time.
   * 
   * @return instance of this view.
   */
  public synchronized static MyView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(MyView.class)).start();
      // Wait until the instance is ready since initialise has executed.
      while (instance == null) {// empty body
      }
    }

    return instance;
  }

  // End of special block
  /////////////////////////////////////////////////////////////////////////////////
  /**
   * The expression to be resolved.
   */
  @FXML
  // fx:id="expression"
  private Label expression;

  @FXML
  private TextField fieldE;

  @FXML
  private TextField fieldR;

  /**
   * One of a pair of buttons to change calculation mode.
   */
  @FXML
  // fx:id="infix"
  private RadioButton infix = null;

  /**
   * The place where the answer is displayed.
   */
  @FXML
  // fx:id="result"
  private Label result;

  /**
   * One of a pair of buttons to change calculation mode.
   */
  @FXML
  // fx:id="reversePolish"
  private RadioButton reversePolish = null;

  /**
   * The calculator button on the screen.
   */
  @FXML
  // fx:id="calculate"
  private Button calculate = null;

  /**
   * the object that links the two radio buttons.
   */
  @FXML
  // fx:id="type"
  private ToggleGroup type;
  //// All values above were injected by FXMLLoader



  @Override
  public void start(Stage primaryStage) throws IOException {
    GridPane page = (GridPane) FXMLLoader.load(MyView.class.getResource("myView.fxml"));
    Scene scene = new Scene(page);
    scene.getStylesheets().add(getClass().getResource("myView.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setTitle("fxml");
    primaryStage.show();
  }

  /**
   * This adds an observer for the calculation.
   * 
   * @param f the calculation.
   */
  public void addCalcObserver(Runnable f) {
    calculate.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        ((Observer) f).notifyObservers();
      }
    });
  }

  /**
   * This adds an observer for the type of calculation being done (Infix/Reverse polish).
   * 
   * @param l the type of the calculation
   */
  public void addTypeObserver(Consumer<OpType> l) {
    type.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> observable, Toggle from, Toggle to) {
        l.accept(to == infix ? OpType.INFIX : OpType.POSTFIX);
      }
    });
  }

  /**
   * A hook to expose the question to another class.
   * 
   * @return the expression
   */
  public String getExpression() {
    return fieldE.getText();

  }

  /**
   * A hook to allow the answer to be displayed.
   * 
   * @param answer the answer to an expression
   */
  public void setAnswer(String answer) {
    fieldR.setText(answer);
  }

  /**
   * Menu to start the GUI.
   */
  public void menu() {
    calculate.setDisable(false);
  }
}
// This code is from the MVC-separated example code


