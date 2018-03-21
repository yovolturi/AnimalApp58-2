package sdu.cs58.watanyu.animalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ///exp
    EditText nameEditText;
    Button startButton;
    String nameString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///intaial view
        nameEditText = findViewById(R.id.edtName);
        startButton = findViewById(R.id.btnStart);

        startButton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameString = nameEditText.getText().toString().trim();///การเอาข้อมุลในedtมาเก็บในnamestring
                if (nameString.length() == 0) {
                    Toast.makeText(getApplicationContext(), "กรุณาใส่ชื่อ", Toast.LENGTH_SHORT).show();

                } else {
                    //เปิดหน้า game
                    Intent startIntent = new Intent(MainActivity.this, GameActivity.class);
                    startIntent.putExtra("Name", nameString);
                    startActivity(startIntent);
                }


            }
        });

    }///end on Cre
}///end class
