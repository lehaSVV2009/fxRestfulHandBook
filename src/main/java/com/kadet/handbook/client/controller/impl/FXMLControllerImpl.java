package com.kadet.handbook.client.controller.impl;

import com.kadet.handbook.client.controller.FXMLController;
import com.kadet.handbook.client.service.RestService;
import com.kadet.handbook.client.service.impl.RestServiceImpl;
import com.kadet.handbook.client.util.IDGenerator;
import com.kadet.handbook.client.view.FXChapter;
import com.kadet.handbook.entity.Chapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Date: 22.12.13
 * Time: 6:07
 *
 * @author Кадет
 */
public class FXMLControllerImpl implements FXMLController, Initializable {

    private RestService restService = new RestServiceImpl();

    private List<FXChapter> fxChapters;

    private ObservableList<FXChapter> fxChaptersObserver;

    /**
     *  Table fx component
     */
    @FXML
    private TableView chapterTable;

    /**
     *  Column "id" component
     */
    @FXML
    private TableColumn idColumn;

    /**
     *  Column "title" fx component
     */
    @FXML
    private TableColumn titleColumn;

    /**
     *  Column "text" fx component
     */
    @FXML
    private TableColumn textColumn;

    /**
     *  Input field "title"
     */
    @FXML
    private TextField titleField;

    /**
     *  Input field "text"
     */
    @FXML
    private TextField textField;

    private final static String EMPTY_STRING = "";


    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        chapterTable.setEditable(true);

        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());


        //  Listener to update "title" column
        titleColumn.setOnEditCommit(
            new EventHandler<TableColumn.CellEditEvent<FXChapter, String>>() {

                @Override
                public void handle (TableColumn.CellEditEvent<FXChapter, String> fxChapterStringCellEditEvent) {

                    ObservableList<FXChapter> observableList
                            = fxChapterStringCellEditEvent.getTableView().getItems();
                    FXChapter fxChapter = observableList.get(
                            fxChapterStringCellEditEvent.getTablePosition().getRow());
                    fxChapter.setTitle(
                            fxChapterStringCellEditEvent.getNewValue()
                    );
                    restService.update(
                            fxChapter.getChapter()
                    );
                }
            }
        );

        textColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //  Listener to update "text" column
        textColumn.setOnEditCommit(
            new EventHandler<TableColumn.CellEditEvent<FXChapter, String>>(){

                @Override
                public void handle (TableColumn.CellEditEvent<FXChapter, String> fxChapterStringCellEditEvent) {

                    ObservableList<FXChapter> observableList
                            = fxChapterStringCellEditEvent.getTableView().getItems();
                    FXChapter fxChapter = observableList.get(
                            fxChapterStringCellEditEvent.getTablePosition().getRow());
                    fxChapter.setText(
                            fxChapterStringCellEditEvent.getNewValue()
                    );
                    restService.update(
                            fxChapter.getChapter()
                    );

                }

            }
        );

        idColumn.setCellValueFactory(
                new PropertyValueFactory<FXChapter, Integer> ("id")
        );

        titleColumn.setCellValueFactory(
                new PropertyValueFactory<FXChapter, String> ("title")
        );

        textColumn.setCellValueFactory(
                new PropertyValueFactory<FXChapter, String> ("text")
        );

        updateFrame();

    }

    /**
     *  Pressing button "Remove"
     *
     * @param actionEvent
     */
    @FXML
    @Override
    public void remove (ActionEvent actionEvent) {

        FXChapter fxChapter
                = (FXChapter) chapterTable.getSelectionModel().getSelectedItem();

        restService.remove(
                fxChapter.getId());

        fxChaptersObserver.remove(fxChapter);

    }

    /**
     *  Pressing button "Save"
     *
     * @param actionEvent
     */
    @FXML
    @Override
    public void save (ActionEvent actionEvent) {

        Chapter chapter = new Chapter(
                titleField.getText(),
                textField.getText()
        );
        chapter.setId(
                IDGenerator.geneateId());

        restService.save(chapter);

        clearTextFields();
        updateFrame();
    }

    /**
     *  Pressing button "List"
     *
     * @param actionEvent
     */
    @FXML
    @Override
    public void list (ActionEvent actionEvent) {

        fxChapters = new ArrayList<FXChapter>();
        for (Chapter chapter : restService.getAll()) {
            fxChapters.add(
                    new FXChapter(chapter)
            );
        }
        fxChaptersObserver = FXCollections.observableList(fxChapters);
        chapterTable.setItems(fxChaptersObserver);

    }


    /**
     *  Clear title and text input textFields
     */
    public void clearTextFields () {
        titleField.setText(EMPTY_STRING);
        textField.setText(EMPTY_STRING);
    }

    /**
     *  Update values in frame and repaint frame
     */
    public void updateFrame () {
        list(null);
    }
}
