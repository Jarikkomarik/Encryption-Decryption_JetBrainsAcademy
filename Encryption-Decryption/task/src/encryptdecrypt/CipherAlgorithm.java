package encryptdecrypt;

public interface CipherAlgorithm { // interface of cipher execution
    int FIRST_LETTER_OF_ALPHABET = 97;
    int LAST_LETTER_OF_ALPHABET = 122;
    int FIRST_CAPS_LETTER_OF_ALPHABET = 65;
    int LAST_CAPS_LETTER_OF_ALPHABET = 90;

    String executeCipher(String data, int key);
}
