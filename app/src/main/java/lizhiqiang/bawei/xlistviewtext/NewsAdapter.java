package lizhiqiang.bawei.xlistviewtext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import static android.R.attr.id;
import static android.media.CamcorderProfile.get;

/**
 * date: 2017/4/29
 * author: 李志强
 * function:
 */

public class NewsAdapter extends BaseAdapter {

    private List<News.ListBean> list ;
    private Context context ;
    public NewsAdapter(List<News.ListBean> list , Context context){

        this.list = list ;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    // 返回的视图类型
    @Override
    public int getItemViewType(int position) {
        if(1 == list.get(position).getType()){
            return  0 ;
        } else {
            return  1 ;
        }
    }


    // 设置listview 有多少种 类型的item
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolderFirst viewHolderFirst = null;
        ViewHolderSecond viewHolderSecond = null ;


        int type =  getItemViewType(position);


        if(convertView == null){

            if(type == 0){
                // 一张图片的item

                viewHolderFirst = new ViewHolderFirst();
                convertView = LayoutInflater.from(context).inflate(R.layout.first_image,null);
                viewHolderFirst.textViewTitle = (TextView) convertView.findViewById(R.id.firstimage_title);
                viewHolderFirst.textViewDate = (TextView) convertView.findViewById(R.id.firstimage_date);
                viewHolderFirst.imageView = (ImageView) convertView.findViewById(R.id.firstimage_image);
                convertView.setTag(viewHolderFirst);
            }else {
                // 三张图片的item
                viewHolderSecond = new ViewHolderSecond();
                convertView = LayoutInflater.from(context).inflate(R.layout.second_image,null);
                viewHolderSecond.textViewTitle = (TextView) convertView.findViewById(R.id.secondimage_title);
                viewHolderSecond.textViewDate = (TextView) convertView.findViewById(R.id.secondimage_date);
                viewHolderSecond.imageViewLeft = (ImageView) convertView.findViewById(R.id.secondimage_image_left);
                viewHolderSecond.imageViewMiddle = (ImageView) convertView.findViewById(R.id.secondimage_image_middle);
                viewHolderSecond.imageViewright = (ImageView) convertView.findViewById(R.id.secondimage_image_right);
                convertView.setTag(viewHolderSecond);
            }

        } else {
            if(type == 0){
                // 一张图片的item
                viewHolderFirst = (ViewHolderFirst)convertView.getTag() ;
            }else {
                // 三张图片的item
                viewHolderSecond = (ViewHolderSecond)convertView.getTag() ;
            }
        }
        if(type == 0){
            // 一张图片的item
            viewHolderFirst.textViewTitle.setText(list.get(position).getTitle());
            viewHolderFirst.textViewDate.setText(list.get(position).getDate());


            ImageLoader.getInstance().displayImage(list.get(position).getPic(),viewHolderFirst.imageView,IApplication.getOption());






        }else {
            // 三张图片的item


            viewHolderSecond.textViewTitle.setText(list.get(position).getTitle());
            viewHolderSecond.textViewDate.setText(list.get(position).getDate());


            String [] arr =  list.get(position).getPic().split("\\|");
            ImageLoader.getInstance().displayImage(arr[0],viewHolderSecond.imageViewLeft,IApplication.getOption());
            ImageLoader.getInstance().displayImage(arr[1],viewHolderSecond.imageViewMiddle,IApplication.getOption());
            ImageLoader.getInstance().displayImage(arr[2],viewHolderSecond.imageViewright,IApplication.getOption());

        }







        return convertView;
    }



    static class ViewHolderFirst {

        TextView textViewTitle ;
        TextView textViewDate ;
        ImageView imageView;

    }


    static class ViewHolderSecond {

        TextView textViewTitle ;
        TextView textViewDate ;
        ImageView imageViewLeft;
        ImageView imageViewMiddle;
        ImageView imageViewright;


    }

}
