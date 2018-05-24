package br.edu.infnet.profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class EditActivity extends AppCompatActivity {

    static final int[] elementsId = {R.id.edit_email,
            R.id.edit_phone, R.id.edit_course, R.id.edit_discipline};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }

    public void updateProfile(View v){
        Intent intent = new Intent();

        HashMap<Integer, String> fieldDict = new HashMap<>();


        for (int key:elementsId){
            EditText field = findViewById(key);
            String newValue = field.getText().toString();
            if (newValue != null && !newValue.isEmpty()){
                intent.putExtra(Integer.toString(key), newValue);
            }
        }

        setResult(RESULT_OK, intent);
        finish();
    }
}
