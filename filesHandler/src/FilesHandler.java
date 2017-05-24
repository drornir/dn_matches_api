

public class FilesHandler {
    public DataTable read(String filePath, FormatEnum format){
        switch (format) {
            case CSV:

                break;
            default: throw new Error("Unsupported file format");
        }
    }
}
