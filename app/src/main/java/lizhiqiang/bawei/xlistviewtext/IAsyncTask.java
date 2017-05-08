package lizhiqiang.bawei.xlistviewtext;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;


/**
 * date: 2017/4/26
 * author: 李志强
 * function:
 */

// 1.参数 2.进度条  3.结果
public class IAsyncTask extends AsyncTask<Object,Void,String> {

    Handler handler ;
    Map params ;

//    List<News.ListBean> list = new ArrayList<News.ListBean>();

    public IAsyncTask(Handler handler){

        this.handler = handler ;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    protected String doInBackground(Object... params) {
        Map map = (Map) params[0] ;
        this.params = map ;
//        int page = (int) map.get("page");
        String path = "http://qhb.2dyt.com/Bwei/news";
//        String postkey = (String) map.get("postkey");

        try {
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection() ;
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);


            //拼接参数
            StringBuilder stringBuilder = new StringBuilder();
            Set<String> set =  map.keySet() ;
            for(String key : set) {
                stringBuilder.append(key);
                stringBuilder.append("=");
                stringBuilder.append(map.get(key));
                stringBuilder.append("&");
            }



//            page=1&postkey=1503d


            // 发送参数
            stringBuilder =  stringBuilder.deleteCharAt(stringBuilder.length()-1);
            OutputStream outputStream =  httpURLConnection.getOutputStream() ;
            outputStream.write(stringBuilder.toString().getBytes());
            outputStream.flush();


            //
            if(httpURLConnection.getResponseCode() == 200){

                InputStream inputStream =  httpURLConnection.getInputStream() ;

                String result =  StringUtils.inputStreamToString(inputStream);
                return result ;
            }







        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Gson gson = new Gson();
        News news =  gson.fromJson(result,News.class);


        Message message = Message.obtain();

        int page = (int) params.get("page");

        message.what = page == 1 ? 1 : 2 ;
        message.obj = news.getList() ;
        handler.sendMessage(message);

    }
}
