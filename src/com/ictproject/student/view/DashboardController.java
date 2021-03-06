package com.ictproject.student.view;

import com.ictproject.student.MainApp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXRippler;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable{

    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane sideAnchor;

    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnView;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnExit;

    @FXML
    private AnchorPane holderPane;

    @FXML
    private VBox overflowContainer;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXButton btnLogOut2;

    @FXML
    private Label lblMenu;

    private MainApp mainApp;

    private AnchorPane home, add, list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        openMenus();
        createPages();
    }

    private void openMenus() {
        JFXPopup popup = new JFXPopup(overflowContainer);
        lblMenu.setOnMouseClicked(event -> {popup.show(lblMenu, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT, -10, 50);});
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
//        FadeTransition ft = new FadeTransition(Duration.millis(1500));
//        ft.setNode(node);
//        ft.setFromValue(0.1);
//        ft.setToValue(1);
//        ft.setCycleCount(1);
//        ft.setAutoReverse(false);
//        ft.play();
    }

    private void createPages() {
        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("modules/Overview.fxml"));
//            home = loader.load();
//
//            FXMLLoader loader1 = new FXMLLoader();
//            loader1.setLocation(getClass().getResource("modules/Profile.fxml"));
//            list = loader1.load();
//
//            FXMLLoader loader2 = new FXMLLoader();
//            loader2.setLocation(getClass().getResource("modules/Register.fxml"));
//            add = loader2.load();
            home = FXMLLoader.load(getClass().getResource("modules/Overview.fxml"));
            list = FXMLLoader.load(getClass().getResource("modules/Profile.fxml"));
            add = FXMLLoader.load(getClass().getResource("modules/Register.fxml"));

            //set up default node on page load
            setNode(home);
        } catch (IOException e) {
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            e.printStackTrace();
        }

    }

    public void logOff(ActionEvent event) {
    }

    @FXML
    private void openHome(ActionEvent event) {
        setNode(home);
    }

    @FXML
    private void openAddStudent(ActionEvent event) {
        setNode(add);
    }

    @FXML
    private void openListStudent(ActionEvent event) {
        setNode(list);
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }
}
