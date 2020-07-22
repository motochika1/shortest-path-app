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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //main.xml内のLinerLayout
        final LinearLayout layout1 = findViewById(R.id.main_layout);
        EditText width = findViewById(R.id.width);
        EditText height = findViewById(R.id.height);
        EditText itemsAm = findViewById(R.id.items);
        Button setButton = findViewById(R.id.set_button);



        //int width_size = Integer.parseInt(width.getText().toString()); 　　この辺は関係なし
        //int height_size = Integer.parseInt(height.getText().toString());

        final int items_size = 4; //とりあえず商品4つ
        final ArrayList<ArrayList<EditText>> items = new ArrayList();

        //与えられた商品数に応じてEditTextをタグ付きで二次元リストitemsに追加　
        //小課題3~6の入力部分Qの手前まで
        //edittextごとにidを付与したいけどよくわからない
        for (int i = 0; i < items_size;i++){
            ArrayList<EditText> row = new ArrayList();

                EditText cell_1 = new EditText(this);// Xn の入力
                row.add(cell_1);
                EditText cell_2 = new EditText(this);// Yn の入力
                row.add(cell_2);
                EditText cell_3 = new EditText(this);// Pn(商品名) の入力
                row.add(cell_3);
                EditText cell_4 = new EditText(this);//Dn(商品の向いてる方向)の入力
                row.add(cell_4);


                items.add(row);//一行ごとに追加
        }

        setButton.setOnClickListener(  //ボタンを押すと入力フォームが出現するようにしたい
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        makeCells(items, items_size, layout1);
                    }
                }
        );

        layout1.setBackgroundColor(0xffddffee);



    }
    //入力フォームを作る関数
    //ボタンを押しても何もでてこない
    //2回以上押すとTwitterで言ったようなエラーが出てアプリが終了する
    //おそらく同じプロパティに対してaddView()を何度も呼び出していることが原因かもしれないけどはっきりとわからない
    public void makeCells(ArrayList<ArrayList<EditText>> items, int item_size, LinearLayout layout) {

        //新しく作る要素の縦横の設定
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        //TableLayout作成
        final TableLayout table = new TableLayout(this);
        table.setLayoutParams(params);


        for (int i = 0; i < item_size; i++) {
            //引数で渡した商品数ぶんTableRowを作成
            TableRow row = new TableRow(this);

            for (int j = 0; j < 4; j++) {
                //itemsの中にあるEditTextを一個づつrowの子要素に追加
                EditText cell = items.get(i).get(j);
                cell.setLayoutParams(params);

                row.addView(cell);
            }
            // TableLayoutの子要素にrowを追加
            table.addView(row);
        }

        //引数でとったlayoutに上で作ったTableLayoutを追加
        layout.addView(table);
    }
}