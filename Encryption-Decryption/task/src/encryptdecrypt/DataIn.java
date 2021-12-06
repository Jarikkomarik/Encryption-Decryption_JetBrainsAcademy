package encryptdecrypt;

import java.io.IOException;

public interface DataIn { // interface of data input execution
    String getData(String file, String data) throws IOException;
}
