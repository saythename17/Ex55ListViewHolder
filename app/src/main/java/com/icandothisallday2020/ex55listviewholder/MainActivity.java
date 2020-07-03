package com.icandothisallday2020.ex55listviewholder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //1. listView 에 보여줄 대량의 data 생산
    ArrayList<String> items=new ArrayList<>();
    //2.대량의 데이터를 View 객체로 만들어주는 아답터객체 참조변수
    MyAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.-2대량의 데이터 추가
        items.add(new String("aaa"));
        items.add(new String("bbb"));
        items.add(new String("ccc"));

        //2.-2아답터 생성
        adapter=new MyAdapter(items,this);

        //3. listView 에 아답터 설정
        listView=findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}
