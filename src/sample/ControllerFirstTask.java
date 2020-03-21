package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ControllerFirstTask {
    private final static Pattern EMAIL = Pattern.compile("[a-z]([._]?[a-z]+)*[@][a-z][a-z]*[.]((org)|(net)|(ru)|(com)|(by))", Pattern.CASE_INSENSITIVE);

    private final static Pattern N = Pattern.compile("([0-9]*)([1-9])([0-9]*)");
    private final static Pattern Z = Pattern.compile("[-+]?([0-9]*)([0-9])([0-9]*)");
    private final static Pattern R = Pattern.compile("[-+]?(([0-9]*[.]?[0-9]+)|([0-9]+[.]?[0-9]*))([eE][-+]?[0-9]+)?");
    private final static Pattern DATE = Pattern.compile("([0-2][0-9]|(3)[0-1])((.)|(/)|(-))(((0)[0-9])|((1)[0-2]))((.)|(/)|(-))(\\d{4})");
    private final static Pattern TIME = Pattern.compile("(([0-1][0-9])|([2][0-3])):([0-5][0-9])");
    private final static String[] ELEMENTS = {"Natural", "Date", "E-Mail", "Time", "Real", "Integer"};


    @FXML
    private TextField usernameTextField;

    @FXML
    private ComboBox<String> userComboBox;

    @FXML
    private Circle userCircle;


    public void initialize() {

        userComboBox.setItems(FXCollections.observableArrayList(ELEMENTS));
        userComboBox.setValue("Integer");

        usernameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            Matcher m;
            switch (userComboBox.getValue()) {
                case "Natural":
                    m = N.matcher(newValue);
                    if (m.matches())
                        userCircle.setFill(Color.GREEN);
                    else
                        userCircle.setFill(Color.RED);
                    break;

                case "Date":
                    m = DATE.matcher(newValue);

                    if (m.matches())
                        userCircle.setFill(Color.GREEN);
                    else
                        userCircle.setFill(Color.RED);
                    break;

                case "Integer":
                    m = Z.matcher(newValue);
                    if (m.matches())
                        userCircle.setFill(Color.GREEN);
                    else
                        userCircle.setFill(Color.RED);
                    break;
                case "E-Mail":
                    m = EMAIL.matcher(newValue);
                    if (m.matches())
                        userCircle.setFill(Color.GREEN);
                    else
                        userCircle.setFill(Color.RED);
                    break;

                case "Time":
                    m = TIME.matcher(newValue);
                    if (m.matches())
                        userCircle.setFill(Color.GREEN);
                    else
                        userCircle.setFill(Color.RED);
                    break;

                case "Real":
                    m = R.matcher(newValue);
                    if (m.matches())
                        userCircle.setFill(Color.GREEN);
                    else
                        userCircle.setFill(Color.RED);
                    break;
            }
        });
    }
}

