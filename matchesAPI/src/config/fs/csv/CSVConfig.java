package config.fs.csv;

import config.fs.FileSystemConfig;
import config.fs.Resource;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class CSVConfig implements FileSystemConfig {

    public static String getFileName(Resource resource) {
        switch (resource) {
            case UPCOMING:
                return FileName.UPCOMING.getName();
            case PLAYED:
                return FileName.PLAYED.getName();
        }
        throw new Error("Can't find resource");
    }
}
