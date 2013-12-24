package com.kadet.handbook.client.view;

import com.kadet.handbook.entity.Chapter;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 * Date: 22.12.13
 * Time: 6:19
 *
 * @author Кадет
 */
public class FXChapter {

    protected SimpleIntegerProperty id;
    protected SimpleStringProperty title;
    protected SimpleStringProperty text;

    protected Chapter chapter;

    public FXChapter (Chapter chapter) {
        this.chapter = chapter;
        this.id = new SimpleIntegerProperty(
                chapter.getId()
        );
        this.title = new SimpleStringProperty(
                chapter.getTitle()
        );
        this.text = new SimpleStringProperty(
                chapter.getText()
        );
    }


    public Integer getId () {
        return id.get();
    }

    public void setId (Integer id) {
        this.id.set(id);
        chapter.setId(id);
    }

    public String getTitle () {
        return title.get();
    }

    public void setTitle (String title) {
        this.title.set(title);
        chapter.setTitle(title);
    }

    public String getText () {
        return text.get();
    }

    public void setText (String text) {
        this.text.set(text);
        chapter.setText(text);
    }

    public Chapter getChapter () {
        return chapter;
    }

}
