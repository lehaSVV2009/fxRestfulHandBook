package com.kadet.handbook.client.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Date: 22.12.13
 * Time: 2:44
 *
 * @author Кадет
 */
public interface FXMLController {

    void remove (ActionEvent actionEvent);
    void save (ActionEvent actionEvent);
    void list (ActionEvent actionEvent);

}
