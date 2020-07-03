package com.icandothisallday2020.ex55listviewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<String> items;
    Context context;
    //constructor 단축기: [Alt]+[Insert]
    public MyAdapter(ArrayList<String> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {return items.size();}

    @Override
    public Object getItem(int position) {return items.get(position);}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1.재활용할 뷰가 있는가?
        if(convertView==null) {
            //없으면 만들어라
            LayoutInflater inflater=LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.listview_item,parent,false);
            //parent: cardView(listview_item.xml) 가 붙을 listView
            //false:지금당장 붙이지않고 리턴만 해주면 아답터에서 붙여줌(지금 붙이면 이중,에러)

            //참조변수를 멤버로 가진 객체(ViewHolder) 생성
            ViewHolder holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        //뷰에 저장되어 있는 tag 객체(ViewHolder) 얻기
        ViewHolder holder=(ViewHolder)convertView.getTag();
        //3. 현재 position 의 TextView 에 넣을 data
        String s=items.get(position);
        holder.tv.setText(s);
        return convertView;
    }
    //2.만들어져있는 뷰객체에 값들을 연결(Bind View)
    //Inner Class
    class ViewHolder{
        TextView tv;

        public ViewHolder(View itemView) {
            tv=itemView.findViewById(R.id.tv);
        }
    }
}
