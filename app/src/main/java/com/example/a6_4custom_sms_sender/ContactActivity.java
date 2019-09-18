package com.example.a6_4custom_sms_sender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 双双 on 2018/6/24.
 */

public class ContactActivity extends Activity{
    public List<ContactBean> contactLists;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //加载布局
        setContentView(R.layout.activity_contact);
        //找到lv控件
        ListView lv_contact = findViewById(R.id.lv_contact);
        //我想把手机当中 联系人的数据展示到listview上  等讲内容提供者在去获取真实数据
        contactLists = new ArrayList<ContactBean>();
        for (int i = 0; i < 10; i++) {
            ContactBean contact = new ContactBean();
            contact.setName("zhangsan"+i);
            contact.setPhone("1388900"+i);
            contactLists.add(contact);
        }

        //[3]展示数据  设置数据适配器
        lv_contact.setAdapter(new MyAdapter());

        //[4]给listview的条目设置点击事件
        lv_contact.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //[5]取出我们点中条目的数据
                String phone = contactLists.get(position).getPhone();
                System.out.println("phone:"+phone);
                //[6]把phone 返回给第一个页面(通过意图传递数据)
                Intent intent = new Intent();
                intent.putExtra("name", phone);
                //[7]把数据返回给调用者 Call this to set the result that your activity will return to its caller.
                setResult(10, intent);
                //[8]关闭当前Activity mainActivity的onActivityResult方法就会执行
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //创建数据适配器
    private class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return contactLists.size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null ){
                view = View.inflate(getApplicationContext(), R.layout.contact_item, null);
            }else{
                //复用历史缓存对象
                view = convertView;
            }

            //找到我们关心控件
            TextView tv_name = view.findViewById(R.id.tv_name);
            TextView tv_phone = view.findViewById(R.id.tv_phone);

            //设置数据
            tv_name.setText(contactLists.get(position).getName());
            tv_phone.setText(contactLists.get(position).getPhone());

            return view;
        }
    }
}

