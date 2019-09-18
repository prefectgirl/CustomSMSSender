package com.example.a6_4custom_sms_sender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by 双双 on 2018/6/24.
 */

public class SmsTemplateActivity extends Activity{
    String objects[] = {"我在开会,请稍后联系","我在吃饭,请稍后联系",
            "我在写代码,请稍后联系","我在开车,请稍后联系",
            "我在约会,请稍后联系"};

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        //[1]找到lv控件
        ListView lv = (ListView) findViewById(R.id.lv);
        //[2]创建数据适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item, objects);
        //[3]把数据展示到listview上
        lv.setAdapter(adapter);
        //[4]给lv设置点击事件
        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //[5]获取我们点中条目的数据
                String smscontent = objects[position];
                System.out.print(smscontent);
                //[6]把这个数据返回给调用者
                Intent intent = new Intent();
                intent.putExtra("smscontent", smscontent);
                //[7]通过这个方法把数据返回给调用者
                setResult(20,intent);
                //[8]要记得调用finish
                finish();
            }
        });
    }
}
