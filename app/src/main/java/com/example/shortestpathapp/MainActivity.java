package com.example.shortestpathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //main.xml内のLinerLayout
        final LinearLayout layout1 = findViewById(R.id.main_layout);
        final Button set2Bt = new Button(this);
        final EditText custm = new EditText(this);
        final HashMap<Integer, EditText> itemsInfo = new HashMap<>();
        final HashMap<Integer, EditText> customsInfo = new HashMap<>();
        final
        set2Bt.setText("set customer");
        set2Bt.setText("set customer");
        custm.setHint("customers");
        EditText width = findViewById(R.id.width);
        EditText height = findViewById(R.id.height);

        Button setButton = findViewById(R.id.set_button);



        //int width_size = Integer.parseInt(width.getText().toString()); 　　この辺は関係なし
        //int height_size = Integer.parseInt(height.getText().toString());

        //とりあえず商品4つ
        final ArrayList<ArrayList<EditText>> items = new ArrayList();

        setButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText itemsAm = findViewById(R.id.items);
                        final int items_size = Integer.parseInt(itemsAm.getText().toString());
                        layout1.addView(makeCells(items_size, 4));
                        layout1.addView(custm);
                        layout1.addView(set2Bt);

                    }
                }
        );

        set2Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int customerAm = Integer.parseInt(custm.getText().toString());
                layout1.addView(makeCells(customerAm, 2));
            }
        });

        layout1.setBackgroundColor(0xffddffee);



    }

    public TableLayout makeCells(int item_size, int columns) {

        //tablelayoutについての縦横の設定
        TableLayout.LayoutParams params = new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        //TableLayout作成
        final TableLayout table = new TableLayout(this);
        HashMap<Integer, EditText> texts = new HashMap<>();
        int c = 1;

        table.setLayoutParams(params);


        final ArrayList<TableRow> rows = new ArrayList<>();

        for (int i = 0; i < item_size; i++) {
            TableRow row = new TableRow(this);
            for (int j = 0; j < columns; j++) {
                EditText text = new EditText(this);
                texts.put(c,text);
                row.addView(text);
                c++;
            }
            rows.add(row);
            table.addView(row);
        }

        table.setHorizontalGravity(View.TEXT_ALIGNMENT_CENTER);

        return table;

    }



}