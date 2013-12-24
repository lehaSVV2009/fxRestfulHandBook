package com.kadet.handbook.client.util;

import java.util.Random;

/**
 * Date: 24.12.13
 * Time: 3:11
 *
 * @author Кадет
 */
public final class IDGenerator {

    private final static Random random = new Random();

    private final static Integer MAX_ID = 100000;

    private IDGenerator () {}

    public static final Integer geneateId () {
        return random.nextInt(MAX_ID);
    }

}
