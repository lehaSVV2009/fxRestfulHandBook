package com.kadet.handbook.client.service;

import com.kadet.handbook.entity.Chapter;
import com.kadet.handbook.entity.ChapterWrapper;

import java.util.List;

/**
 * Date: 22.12.13
 * Time: 6:07
 *
 * @author Кадет
 */
public interface RestService {

    void save (Chapter chapter);
    void update (Chapter chapter);
    void remove (Integer id);
    Chapter get (Integer id);
    List<Chapter> getAll ();

}
