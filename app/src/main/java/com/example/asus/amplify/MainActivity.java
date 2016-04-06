package com.example.asus.amplify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton,mButton1;
    private PopupWindow mPoupWindow;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=(Button)findViewById(R.id.button1);
        mButton.setOnClickListener(this);
        mButton1=(Button)findViewById(R.id.button2);
        mButton1.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_setting:
                Toast.makeText(MainActivity.this,"设置",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_other:
                Toast.makeText(MainActivity.this,"其他",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_more:
                Toast.makeText(MainActivity.this,"更多",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("第一个上下文菜单");
        menu.addSubMenu(0,Menu.FIRST,Menu.NONE,"第一条");
        menu.addSubMenu(0,Menu.FIRST+1,Menu.NONE,"第二条");
        menu.addSubMenu(0,Menu.FIRST+2,Menu.NONE,"第三条");
        menu.addSubMenu(0,Menu.FIRST+3,Menu.NONE,"第四条");
        super.onCreateContextMenu(menu,v,menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case Menu.FIRST:
                Toast.makeText(MainActivity.this,"第一条",Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST+1:
                Toast.makeText(MainActivity.this,"第二条",Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST+2:
                Toast.makeText(MainActivity.this,"第三条",Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST+3:
                Toast.makeText(MainActivity.this,"第四条",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
            setPop();
                break;
            case R.id.text1:
                Toast.makeText(MainActivity.this,"选项1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.text2:
                Toast.makeText(MainActivity.this,"选项2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.text3:
                mPoupWindow.dismiss();
                Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                registerForContextMenu(textView);
                break;
        }
    }

    private void setPop() {
        View view= LayoutInflater.from(MainActivity.this).
                inflate(R.layout.pop_layout,null);
         mPoupWindow=new PopupWindow();
        mPoupWindow.setContentView(view);
        mPoupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPoupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView text1=(TextView)view.findViewById(R.id.text1);
        TextView text2=(TextView)view.findViewById(R.id.text2);
        TextView text3=(TextView)view.findViewById(R.id.text3);
        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
        text3.setOnClickListener(this);
        //显示PopupWindow显示的位置
//        View root=LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main,null);
//        mPoupWindow.setAtLocation(root, Gravity.BOTTOM,0);
        mPoupWindow.showAsDropDown(mButton);
    }
}
