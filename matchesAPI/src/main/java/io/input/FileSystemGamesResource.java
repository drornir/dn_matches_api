package io.input;

import config.Config;
import data.Game;
import io.FileFormat;
import io.input.documentReader.DocumentReaderAdapter;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Dror Nir on 26/05/2017.
 */
public abstract class FileSystemGamesResource implements GamesResource {
    final String directory;
    String inputFormat;
    String filename;

    public FileSystemGamesResource() {
        directory = Config.get().getString("input.fs.resourcesdir");
    }

    Path getFilepath() {
        assert filename != null;
        assert inputFormat != null;
        return FileSystems.getDefault().getPath(directory, filename+ "."+ inputFormat);
    }

    FileFormat getInputFormatEnum() {
        for (FileFormat fileFormat : FileFormat.values()) {
            if (fileFormat.stringExt.equals(inputFormat)) {
                return fileFormat;
            }
        }
        throw new Error("Got bad file format from config: " + inputFormat);
    }

    public Iterator<Game> getGames() throws Exception {
        DocumentReaderAdapter adapter = new DocumentReaderAdapter(getInputFormatEnum(), getFilepath());
        Iterator<Map<String, String>> rows = adapter.getRows();
        return new Iterator<Game>() {
            @Override
            public boolean hasNext() {
                return rows.hasNext();
            }

            @Override
            public Game next() {
                return convertRowToGame(rows.next());
            }
        };
    }

    abstract Game convertRowToGame(Map<String,String> row);


}
