package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataOutput implements DataOut {
    @Override
    public void passData(String file, String data) throws IOException {
        File out = new File(file);
        out.createNewFile();

        try (FileWriter w = new FileWriter(out)) {
            w.write(data);
        }
    }
}
