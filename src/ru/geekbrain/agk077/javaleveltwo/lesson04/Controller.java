package ru.geekbrain.agk077.javaleveltwo.lesson04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;

public class Controller {
    @FXML
    TextArea chatTextArea;

    @FXML
    TextField chatMessageBox;

    @FXML
    Label lbUser1;


    public void btnSendClickAction(ActionEvent actionEvent) {
        if (!chatMessageBox.getText().isEmpty()) {
            chatTextArea.appendText(chatMessageBox.getText() + "\n");
            chatMessageBox.setText("");
        }

    }

    public void labelClick(MouseEvent mouseEvent) {
        Object label = mouseEvent.getSource();
        chatMessageBox.setText("@" + ((Label)label).getText() + " ");
        chatMessageBox.requestFocus();
        chatMessageBox.selectEnd();
    }
}
