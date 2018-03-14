package sdu.cs58.watanyu.animalapp;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.media.Image;
        import android.media.MediaPlayer;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ImageView;

        import java.util.ArrayList;
        import java.util.Collections;

public class GameActivity extends AppCompatActivity {
    ///Explicit
    Button btn1,btn2,btn3, btn4;
    ImageView questionImageView;
    ImageButton volumnImageButton;
    MediaPlayer mediaPlayer;
    int questionCount = 1;///เก็บข้อคำถาม

    ArrayList<Integer> qID = new ArrayList<Integer>();
    String answer;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ///initial view
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        questionImageView = findViewById(R.id.imvQuestion);
        volumnImageButton = findViewById(R.id.imbVolumn);
        ///เเสดงคำถามบนหน้าจอ
        for (int i =1;i<=questionCount; i++) {
            qID.add(i);
        }
        Collections.shuffle(qID);///กำหนดสุ่มคำถาม
        setQuestion(qID.remove(0));
        

    }///end oncreate

    private void setQuestion(int qID) {  ///กำหนดข้อคำถามเเละเฉลย
        if (qID == 1) {
            answer = "นก";
            questionImageView.setImageResource(R.drawable.bird);
            mediaPlayer = MediaPlayer.create(this, R.raw.bird);

            ArrayList<String> choice = new ArrayList<String>(); ///กำหนดการสุ่มคำตอบ
            choice.add("นก");
            choice.add("วัว");
            choice.add("หมา");
            choice.add("หมู");
            Collections.shuffle(choice);///กำหมดสุ่มลำกับคำตอบ
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));

        }
    }///end setQ

        public void choiceAns(View view) {///ตรวจคำตอบ

            Button button = (Button) view;
            String buttonString = button.getText().toString();///เอาขอความบนปุ่มมาเก็บใน buttonstring
            if (buttonString.equals(answer)) {
                score++;


            }
            if (qID.isEmpty()) {///ถ้าทำครบทุกข้อ นั่นคือ qidเป้นค่าว่างให้เเสดงคะเเนน
                dialogboxScore();/// เmethod เสดงคะเเนนรวม

            } else {////ถ้ายังทำไม่ครบ
                setQuestion(qID.remove(0));///เรียก setQusrtion เเสดงงคำถามถักไป

            }

        }///end choiceAns

         private void dialogboxScore() {///method สำหรับเเสดงคะเเเนนน
             AlertDialog.Builder builder = new AlertDialog.Builder(this);
             builder.setTitle("สรุปคะเเนน");
             builder.setMessage("ได้คะะเนน" + score + "คะเเนน")
                .setCancelable(false)
                .setPositiveButton("ออกจากเกม", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
             .setNegativeButton("เล่นอีกครั้ง", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                     Intent intent = getIntent();
                     finish();
                     startActivity(intent);
                 }
             });
             AlertDialog alertDialog = builder.create();
             alertDialog.show();
         }


    public void playSound (View view){
        mediaPlayer.start();



    }
}///end class
