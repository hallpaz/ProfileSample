package br.edu.infnet.profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {

    private final int REQUEST_EDIT_CODE = 55;
    HashMap<String, Integer> idDict;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        idDict = new HashMap<>();
        //idDict.put(Integer.toString(R.id.edit_image), R.id.imageView);
        idDict.put(Integer.toString(R.id.edit_email), R.id.email);
        idDict.put(Integer.toString(R.id.edit_phone), R.id.course);
        idDict.put(Integer.toString(R.id.edit_course), R.id.course);
        idDict.put(Integer.toString(R.id.edit_discipline), R.id.discipline);
    }


    public void editFields(View v){
        Intent intent = new Intent(this, EditActivity.class);
        startActivityForResult(intent, REQUEST_EDIT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_EDIT_CODE && resultCode == RESULT_OK){
            for (int id:EditActivity.elementsId){
                String idString = Integer.toString(id);
                String newValue = data.getStringExtra(idString);
                if (newValue != null && !newValue.isEmpty()){
                    TextView textView = findViewById(idDict.get(idString));
                    textView.setText(newValue);
                }
            }
        }
    }
}
