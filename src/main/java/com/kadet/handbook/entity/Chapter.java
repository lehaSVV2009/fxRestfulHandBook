package com.kadet.handbook.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Date: 22.12.13
 * Time: 6:21
 *
 * @author Кадет
 */
@XmlRootElement
public class Chapter implements Serializable, Entity<Integer> {

    private Integer id;
    private String title;
    private String text;

    public Chapter () {
    }

    public Chapter (String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getText () {
        return text;
    }

    public void setText (String text) {
        this.text = text;
    }
}
