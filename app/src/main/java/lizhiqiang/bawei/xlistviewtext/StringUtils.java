package lizhiqiang.bawei.xlistviewtext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * date: 2017/4/29
 * author: 李志强
 * function:
 */

public class StringUtils {

    public static String inputStreamToString(InputStream inputStream) {

        ByteArrayOutputStream   byteArrayOutputStream = new ByteArrayOutputStream();

        byte [] buf = new byte[1024] ;
        int length = 0 ;

        try {
            while ((length = inputStream.read(buf)) != -1) {
                byteArrayOutputStream.write(buf,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  byteArrayOutputStream.toString() ;
    }
}
