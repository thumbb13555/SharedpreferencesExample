package com.jetec.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btGoSave,btDisplay,btClear;
        btGoSave = findViewById(R.id.button_GoSave);
        btDisplay = findViewById(R.id.button_Display);
        btClear = findViewById(R.id.button_Clear);
        TextView tvDisplay = findViewById(R.id.textView_Display);

        btGoSave.setOnClickListener(v->{
            Intent intent = new Intent(this,SaveDataActivity.class);
            startActivity(intent);
        });
        btClear.setOnClickListener(v -> {
            clear();
        });
        btDisplay.setOnClickListener(v -> {
            tvDisplay.setText(read());
        });
    }
    private String read(){
        /**創建SharedPreferences，索引為"Data"*/
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        /**回傳在"Saved"索引之下的資料；若無儲存則回傳"未存任何資料"*/
        return sharedPreferences.getString("Saved","未存任何資料");
    }
    private void clear(){
        /**創建SharedPreferences*/
        SharedPreferences sharedPreferences = getSharedPreferences("Data",Context.MODE_PRIVATE);
        /**取得SharedPreferences.Editor*/
        SharedPreferences.Editor editor = sharedPreferences.edit();
        /**利用clear清除掉所有資料*/
        editor.clear();
        /**不返回結果的提交*/
        /**若需要提交結果，則可使用.commit()*/
        editor.apply();

    }
}