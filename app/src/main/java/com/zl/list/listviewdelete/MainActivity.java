package com.zl.list.listviewdelete;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.ListView;
import android.widget.Toast;

import com.zl.list.listviewdelete.swipemenulistview.SwipeMenu;
import com.zl.list.listviewdelete.swipemenulistview.SwipeMenuCreator;
import com.zl.list.listviewdelete.swipemenulistview.SwipeMenuItem;
import com.zl.list.listviewdelete.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    SwipeMenuListView listview;
    ListAdapter adapter;
    List<String> listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (SwipeMenuListView) findViewById(R.id.listview);
        initMenu();
        listData = new ArrayList<>();
        for (int i = 0;i<10;i++){
            listData.add("测试数据"+i);
        }
        adapter = new ListAdapter(this,listData);
        listview.setAdapter(adapter);
    }

    /**
     * 侧滑删除历史消息
     */
    private void initMenu() {
        // TODO Auto-generated method stub
        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(getApplicationContext());
                // set item background
                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.mipmap.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        // set creator
        listview.setMenuCreator(creator);

        listview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                // ApplicationInfo item = mAppList.get(position);
                switch (index) {
                    case 0:
                        listData.remove(position);
                        adapter = new ListAdapter(MainActivity.this,listData);
                        listview.setAdapter(adapter);
                    case 1:
                        break;
                }
                return false;
            }
        });
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }
}
