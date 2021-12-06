package encryptdecrypt;

import java.io.IOException;

public interface DataOut { // interface of data output execution
    void passData(String file, String data) throws IOException;
}
