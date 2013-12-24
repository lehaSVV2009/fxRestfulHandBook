package com.kadet.handbook.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Date: 22.12.13
 * Time: 6:23
 *
 * @author Кадет
 */
@XmlRootElement
public class ChapterWrapper implements Serializable {

    private List<Chapter> chapters;

    public ChapterWrapper () {
    }

    public ChapterWrapper (List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public List<Chapter> getChapters () {
        return chapters;
    }

    public void setChapters (List<Chapter> chapters) {
        this.chapters = chapters;
    }
}
