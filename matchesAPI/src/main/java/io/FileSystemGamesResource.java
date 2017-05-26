package io;

import config.Config;

import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by Dror Nir on 26/05/2017.
 */
public abstract class FileSystemGamesResource {
    final String directory = Config.get().getString("fs.input.resourcesdir");
    final String inputFormat = Config.get().getString("fs.input.format");
    String filename;

    Path getFilepath(){
        return FileSystems.getDefault().getPath (directory,filename,".", inputFormat);
    }



}
