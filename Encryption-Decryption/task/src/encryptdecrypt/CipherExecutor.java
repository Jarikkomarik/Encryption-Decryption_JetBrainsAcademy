package encryptdecrypt;

import java.io.IOException;

public class CipherExecutor { //class that takes main execution of Encryption
    private Mode mode;
    private Algorithm alg;
    private int key = 0;
    private String data = "";
    private String in = "";
    private String out = "";
    private String inputData = "";
    private DataIn DataIn;
    private DataOut DataOut;
    private CipherAlgorithm CipherAlgorithm;

    CipherExecutor(String[] args) { //constructor that initializing fields and executors
        initializeVariables(args); // converting String[] into fields
        initializeExecutors();  // creating instances of classes based on fields content
    }

    private void initializeExecutors() { //creating class instance based on fields logic
        DataIn = in.equals("") ? new SimpleDataInput() : new FileDataInput();
        CipherAlgorithm = getAlgorithm();
        DataOut = out.equals("") ? new SimpleDataOutput() : new FileDataOutput();
    }

    private CipherAlgorithm getAlgorithm() { //returns instance of CipherAlgorithm based on fields logic
        if (mode == Mode.encrypt && alg == Algorithm.unicode) {
            return new UnicodeEncode();
        } else if (mode == Mode.decrypt && alg == Algorithm.unicode) {
            return new UnicodeDecode();
        } else if (mode == Mode.encrypt && alg == Algorithm.shift) {
            return new ShiftEncode();
        } else if (mode == Mode.decrypt && alg == Algorithm.shift) {
            return new ShiftDecode();
        } else {
            throw new RuntimeException("Wrong -mode or -alg");
        }
    }

    public void execute() { // calling execute methods of created classes

        try {
            inputData = DataIn.getData(in, data);
        } catch (IOException e) {
            System.out.println("Execution interrupted: Exception in getData()");
            return;
        }
        inputData = CipherAlgorithm.executeCipher(inputData, key);
        try {
            DataOut.passData(out, inputData);
        } catch (IOException e) {
            System.out.println("Execution interrupted:  Exception in passData()");
            return;
        }


    }


    private void initializeVariables(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {

                case "-mode":
                    if (args[i + 1].equals("enc")) {
                        mode = Mode.encrypt;
                    } else {
                        mode = Mode.decrypt;
                    }
                    break;

                case "-key":
                    key = Integer.valueOf(args[i + 1]);
                    break;

                case "-data":
                    data = args[i + 1];
                    break;

                case "-in":
                    in = args[i + 1];
                    break;

                case "-out":
                    out = args[i + 1];
                    break;
                case "-alg":
                    if (args[i + 1].equals("unicode")) {
                        alg = Algorithm.unicode;
                    } else {
                        alg = Algorithm.shift;
                    }
                    break;
            }
        }
    }
}
