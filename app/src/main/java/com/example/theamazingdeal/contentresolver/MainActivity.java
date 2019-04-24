package com.example.theamazingdeal.contentresolver;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText name;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==submit)
                {
                    if(TextUtils.isEmpty(name.getText().toString())||TextUtils.isEmpty(pass.getText().toString()))
                    {
                        Toast.makeText(MainActivity.this,"Field is Blanks",Toast.LENGTH_LONG).show();
                    }
                    else {
                        ContentValues cv =new ContentValues();
                        //cv.put("NAME",name.getText().toString(),);
                        //cv.put("PASS",pass.getText().toString());
                        cv.put(contentPro.NAME,name.getText().toString());
                        cv.put(contentPro.PASS,pass.getText().toString());
                        Uri uri= getContentResolver().insert(contentPro.CONTENT_URI,cv);
                    }
                }
            }
        });
    }
}
