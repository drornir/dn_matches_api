package io.documentReader;

import com.opencsv.CSVReader;
import io.FileFormat;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by Dror Nir on 26/05/2017.
 */
public class DocumentReaderAdapter implements DocumentReader {
    final Path sourcePath;
    final FileFormat fileFormat;

    public DocumentReaderAdapter(Path sourcePath, FileFormat fileFormat) {
        this.sourcePath = sourcePath;
        this.fileFormat = fileFormat;
    }

    @Override
    public Iterator<Map<String, String>> getRows() throws Exception {
        switch (fileFormat) {
            case CSV:
                return new CSVRowsIterator(new FileReader(this.sourcePath.toFile()));
            default:
                throw new Exception("Unsupported format " + fileFormat);
        }
    }

    /**
     * Adapter for http://opencsv.sourceforge.net
     */
    class CSVRowsIterator implements Iterator<Map<String, String>> {
        String[] headers;
        String[] nextLine;
        CSVReader reader;

        public CSVRowsIterator(FileReader fileReader) throws IOException {
            reader = new CSVReader(fileReader);
            if ((headers = reader.readNext()) == null) {
                throw new RuntimeException("No lines in CSV");
            }
            nextLine = reader.readNext();
        }

        @Override
        public boolean hasNext() {
            return nextLine != null;
        }

        @Override
        public Map<String, String> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Map<String, String> map = createMap(headers, nextLine);
            try {
                nextLine = reader.readNext();
            } catch (IOException e) {
                throw new RuntimeException("Sudden Error while reading csv file", e);
            }
            return map;
        }

        private Map<String, String> createMap(String[] headers, String[] line) {
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < headers.length; i++) {
                map.put(headers[i], line[i]);
            }
            return map;
        }

    }
}
