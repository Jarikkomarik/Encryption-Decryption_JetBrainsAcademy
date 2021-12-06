package encryptdecrypt;

public class SimpleDataOutput implements DataOut {
    @Override
    public void passData(String file, String data) {
        System.out.println(data);
    }
}
