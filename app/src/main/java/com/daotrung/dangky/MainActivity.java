package com.daotrung.dangky;

import static android.graphics.Color.RED;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText edtName , edtPass , edtRePass;
    TextView txtNote , txtWarning ;
    Button btnTiepTuc ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtUserName);
        edtPass = findViewById(R.id.edtPassword);
        edtRePass = findViewById(R.id.edtRePassword);
        txtNote = findViewById(R.id.txtNote);
        txtWarning = findViewById(R.id.txtWarning);
        btnTiepTuc = findViewById(R.id.btnLogup);

        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtName.getText().toString();
                String pass = edtPass.getText().toString();
                String repass = edtRePass.getText().toString();

                Pattern pUser = Pattern.compile("^[\\S]{6,}$");
                Pattern pPass = Pattern.compile("^.{8,}$");

                if(pUser.matcher(user).find()){
                     txtNote.setVisibility(View.INVISIBLE);
                }else{
                    txtNote.setVisibility(View.VISIBLE);
                    edtName.setBackgroundColor(RED);
                }
                if(pPass.matcher(pass).find()){
                    txtWarning.setVisibility(View.INVISIBLE);
                }else{
                    txtWarning.setVisibility(View.VISIBLE);
                    edtPass.setBackgroundColor(RED);
                }
                if(repass.equals(pass)){
                    txtWarning.setVisibility(View.INVISIBLE);
                }else{
                    txtWarning.setVisibility(View.VISIBLE);
                    edtRePass.setBackgroundColor(RED);
                }
            }
        });




    }
}