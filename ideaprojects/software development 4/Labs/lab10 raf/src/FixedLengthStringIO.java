import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by DL on 21/03/2015.
 */
public class FixedLengthStringIO {
    //Read fixed number of characters from a DataInput stream
    public static String readFixedLengthString(int size, DataInput in)throws IOException{

        //declares an array of the size sent in
        char[] chars = new char[size];

        // read that amount in to the array
        for (int i = 0; i < size; i++) {
            chars[i] = in.readChar();
        }

        return new String(chars);
    }

    //Write fixed number of characters in to a DataInput stream
    public static String padString(String s, int size)throws IOException{
        int endIndex = 0;
        if (s.length() > size)
            s = s.substring(0, (size-1));
        else {
            endIndex = size;
            for (int i = s.length(); i < size; i++) {
                s += "_";
            }
        }

        return s;
    }
}

