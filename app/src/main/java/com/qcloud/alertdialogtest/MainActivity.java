package com.qcloud.alertdialogtest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{

    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.btn_5)
    Button btn5;
    @BindView(R.id.btn_6)
    Button btn6;
    @BindView(R.id.btn_7)
    Button btn7;

    @OnClick(R.id.btn_1)
    public void setBtn1(){
        show1();
    }
    @OnClick(R.id.btn_2)
    public void setBtn2(){
        show2();
    }
    @OnClick(R.id.btn_3)
    public void setBtn3(){
        show3();
    }
    @OnClick(R.id.btn_4)
    public void setBtn4(){
        show4();
    }
    @OnClick(R.id.btn_5)
    public void setBtn5(){
        show5();
    }
    @OnClick(R.id.btn_6)
    public void setBtn6(){
        show6();
    }
    @OnClick(R.id.btn_7)
    public void setBtn7(){
        show7();
    }

    private  List<String> items;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void show1() {
        // 创建数据
        final String[] items = new String[] { "北京", "上海", "广州", "深圳" };
        // 创建对话框构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 设置参数
        builder.setIcon(R.drawable.icon).setTitle("提示")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn1.setText(items[which]);
                    }
                });
        builder.show();
    }

    private void show2(){
        LayoutInflater factory = LayoutInflater.from(this);
        final View textEntryView = factory.inflate(R.layout.dialog_addmembers, null);
        final ImageView imageView = textEntryView.findViewById(R.id.iv_dialog_membersicon);
        final EditText etdialogposition =  textEntryView.findViewById(R.id.et_dialog_position);
        final EditText etdialogmembersname = textEntryView.findViewById(R.id.et_dialog_membersname);
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("企业成员:")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setView(textEntryView)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        btn2.setText("职位: "+etdialogposition.getText().toString()+" 名字: "+etdialogmembersname.getText().toString());
                    }
                });
        builder.show();// 显示对话框
    }

    public void show3() {
        final EditText inputServer = new EditText(this);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("按钮名称")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setView(inputServer)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        btn3.setText( inputServer.getText().toString());
                    }
                });
        builder.show();
    }

    private void show4() {
        // 创建数据
        final String[] items = new String[] { "北京", "上海", "广州", "深圳" };
        // 创建对话框构建器
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 设置参数
        builder.setIcon(R.drawable.icon).setTitle("提示")
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn4.setText(items[which]);
                    }
                });
        builder.show();
    }

    private void show5() {
        // 创建数据
        final String[] items = new String[] { "北京", "上海", "广州", "深圳" };
        // 创建对话框构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.icon)
                .setTitle("提示")
                .setMultiChoiceItems(items,
                        new boolean[] { true, true, false, false, false },
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which, boolean isChecked) {
                                if (isChecked) {
                                    Toast.makeText(MainActivity.this,
                                            items[which], Toast.LENGTH_SHORT).show();
                                    btn5.setText(items[which]);
                                }
                            }
                        });
        builder.show();
    }

    private void show6() {
        // 创建数据
        final String[] items = new String[] { "北京", "上海", "广州", "深圳",
                "北京", "上海", "广州", "深圳",
                "北京", "上海", "广州", "深圳",
                "北京", "上海", "广州", "深圳",
                "北京", "上海", "广州", "深圳",
                "北京", "上海", "广州", "深圳",
                "北京", "上海", "广州", "深圳",
                "北京", "上海", "广州", "深圳",
                "北京", "上海", "广州", "深圳",
                "北京", "上海", "广州", "深圳",
                "北京", "上海", "广州", "深圳"
        };
        // 创建对话框构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示")
                .setIcon(R.drawable.icon)
                .setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                R.layout.item_of_citys, R.id.tv_city, items),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                btn6.setText(items[which]);
                            }
                        });
        builder.show();
    }

    private void show7() {
        // 创建数据
        items = new ArrayList<>();
        for (int i = 0; i<10; i++ ){
            items.add("北京");
            items.add("上海");
            items.add("广州");
            items.add("深圳");
        }
        final View view = LayoutInflater.from(this).inflate(R.layout.recyclerview,null);
        final RecyclerView recyclerView = view.findViewById(R.id.list_item);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,items,this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        // 创建对话框构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示")
                .setIcon(R.drawable.icon)
                .setView(view);
        dialog = builder.show();
    }

    @Override
    public void onItemClick(int position) {
        btn7.setText(items.get(position));
        dialog.dismiss();
    }
}
