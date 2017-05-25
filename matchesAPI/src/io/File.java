package io;

import data.Game;

import java.util.Iterator;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public interface File {
    Iterator<Game> getRows();
}
