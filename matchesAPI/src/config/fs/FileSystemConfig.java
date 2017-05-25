package config.fs;

import config.fs.csv.CSVConfig;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public interface FileSystemConfig {
    static String getFilePath(FileFormat format, Resource resource){
        String filename;
        switch (format) {
            case CSV:
                filename = CSVConfig.getFileName(resource);
        }

    }
}
