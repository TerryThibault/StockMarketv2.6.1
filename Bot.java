package badidea;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Bot {
    
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("helloooo");
//        ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//        System.out.println("Test output");
//        System.err.println("Out was: " + out.toString());
        String data = "jeff\rget GOOG\rbuy 10\ryes\rsell 10\ryes\rexit\r";
        InputStream testInput = new ByteArrayInputStream( data.getBytes("UTF-8") );
        System.setIn(testInput);
        BadIdea.main(args);
    }
}
