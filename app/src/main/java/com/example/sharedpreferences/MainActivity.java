package com.example.sharedpreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private EditText editData;
    private Button btnSave, btndelete;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editData = findViewById(R.id.Data);
        btnSave = findViewById(R.id.btn_Save);
        btndelete = findViewById(R.id.btn_delete);
        sharedPreferences = getSharedPreferences("myapp-data",
                MODE_PRIVATE);
        if (sharedPreferences.getString("title", null) !=
                null){

            editData.setText(sharedPreferences.getString("title", null));
        }
        btnSave.setOnClickListener(v ->{
            @SuppressLint("CommitPrefEdits")
            SharedPreferences.Editor editor =
                    sharedPreferences.edit();
            editor.putString("title",
                    editData.getText().toString());
            editor.apply();
            Toast.makeText(getApplicationContext(), "Data tersimpan!", Toast.LENGTH_SHORT).show();
        });
        btndelete.setOnClickListener(v -> {
            @SuppressLint("CommitPrefEdits")
            SharedPreferences.Editor editor =
                    sharedPreferences.edit();
            //menghapus semua data
            editor.clear().apply();
            //mengapus sebagian
            editor.putString("title", null);
            editor.apply();
        });
    }
}