package io.input.documentReader;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Dror Nir on 26/05/2017.
 */
public interface DocumentReader {
    Iterator<Map<String, String>> getRows() throws Exception;
}
