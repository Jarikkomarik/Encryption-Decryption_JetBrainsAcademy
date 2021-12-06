package encryptdecrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDataInput implements DataIn {
    @Override
    public String getData(String file, String data) throws IOException {
        String fileData = "";
        fileData = new String(Files.readAllBytes(Paths.get(file)));
        return fileData;
    }
}
