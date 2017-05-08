package lizhiqiang.bawei.xlistviewtext;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lizhiqiang.bawei.xlistview.XListView;


public class MainActivity extends Activity implements XListView.IXListViewListener{
    private XListView xListView;

    private int page = 1 ;

    MyHandler handler = new MyHandler(this);


    private  NewsAdapter adapter ;

    private List<News.ListBean> list = new ArrayList<News.ListBean>();


    static class MyHandler extends Handler {

        WeakReference<MainActivity> weakReference ;
        public MyHandler(MainActivity activity){
            weakReference = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            MainActivity activity =   weakReference.get() ;

            if(activity == null){
                return;
            }

            switch (msg.what) {
                case 1:

                    List<News.ListBean>  listBeen = (List<News.ListBean>) msg.obj ;
                    activity.update(listBeen,1);



                    break;
                case 2:
                    activity.update((List<News.ListBean>) msg.obj,2);
                    break;
            }

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        xListView = (XListView) findViewById(R.id.xlistview);
        xListView.setXListViewListener(this);
        xListView.setPullLoadEnable(true);
        xListView.setPullRefreshEnable(true);

        adapter = new NewsAdapter(list,this);
        xListView.setAdapter(adapter);

        getData(page);

    }


    /**
     * 1
     * @param data
     * @param type 1  下拉 2 上啦
     */
    private void update(List<News.ListBean>  data,int type){


        if(type == 1){
            list.clear();
            list.addAll(data);
            adapter.notifyDataSetChanged();

            xListView.stopRefresh();
            xListView.setRefreshTime("刚刚");
        } else {
            list.addAll(data);
            adapter.notifyDataSetChanged();

            xListView.stopLoadMore();
        }
    }


    // 请求数据
    private void getData(int page){

        Map map = new HashMap();
        map.put("page",page);
        map.put("postkey","1503d");

        new IAsyncTask(handler).execute(map);


    }


    // 下拉
    @Override
    public void onRefresh() {

        page = 1 ;
        getData(1);


    }

    // 上啦
    @Override
    public void onLoadMore() {

        page = page + 1;
        getData(page);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}