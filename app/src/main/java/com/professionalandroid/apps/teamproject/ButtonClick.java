package com.professionalandroid.apps.teamproject;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ButtonClick extends AppCompatActivity {
    private TextView textQuiz;
    private EditText editAnswer;
    private Button btnSubmit;
    private Button btnLater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);

        textQuiz = findViewById(R.id.textQuiz);
        editAnswer = findViewById(R.id.editAnswer);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnLater = findViewById(R.id.btnLater);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAnswer = editAnswer.getText().toString().trim();
                String correctAnswer = "3"; // 퀴즈의 정답을 지정하세요.

                String message;
                if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                    message = "정답입니다!";
                } else {
                    message = "틀렸습니다!";
                }

                AlertDialog.Builder resultBuilder = new AlertDialog.Builder(ButtonClick.this);
                resultBuilder.setTitle("결과"); // 알람 제목
                resultBuilder.setMessage(message);
                resultBuilder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog resultDialog = resultBuilder.create();
                resultDialog.show();
            }
        });
        btnLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 현재 액티비티를 종료하여 메인 액티비티로 돌아갑니다.
            }
        });
    }
}