package sample;

import javafx.scene.control.TextArea;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerSecondTask {

    final static Pattern DATE = Pattern.compile("([0-2][0-9]|(3)[0-1])((.)|(\\/)|(-))(((0)[0-9])|((1)[0-2]))((.)|(\\/)|(-))(\\d{4})");
    final static String START_STRING = " ";


    public TextArea inputArea;
    public TextArea outputArea;

    public void initialize() {
        inputArea.setText(START_STRING);

        inputArea.textProperty().addListener((observable, oldValue, newValue) -> {
            outputArea.setText("");
            String text = inputArea.getText();
            Matcher matcher = DATE.matcher(text);
            while (matcher.find()) {
                outputArea.appendText(matcher.group());
                outputArea.appendText("\n");
            }
        });
    }
}
