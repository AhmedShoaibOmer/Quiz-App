package com.ahmed.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.submit_button);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showResult(getResult());
            }
        });
    }

    private int getResult() {
        int score = 0;

        // getting and checking user answers

        boolean firstCorrectAnswer = ((RadioButton) findViewById(R.id.radio_first_C)).isChecked();
        if (firstCorrectAnswer) {
            score++;
        }

        String secondCorrectAnswer = ((EditText) findViewById(R.id.editText_second)).getText().toString();
        if (secondCorrectAnswer.equals("Linux Kernel")) {
            score++;
        }

        boolean firstPartialThirdAnswer = ((CheckBox) findViewById(R.id.checkbox_thrid_B)).isChecked();
        boolean secondPartialThirdAnswer = ((CheckBox) findViewById(R.id.checkbox_thrid_C)).isChecked();
        boolean thirdPartialThirdAnswer = ((CheckBox) findViewById(R.id.checkbox_thrid_A)).isChecked();
        boolean fourthPartialThirdAnswer = ((CheckBox) findViewById(R.id.checkbox_thrid_D)).isChecked();
        if (firstPartialThirdAnswer && secondPartialThirdAnswer && thirdPartialThirdAnswer && fourthPartialThirdAnswer) {
            score++;
        }

        boolean fourthCorrectAnswer = ((RadioButton) findViewById(R.id.radio_fourth_B)).isChecked();
        if (fourthCorrectAnswer) {
            score++;
        }

        boolean firstPartialFifthAnswer = ((CheckBox) findViewById(R.id.checkbox_fifth_A)).isChecked();
        boolean secondPartialFifthAnswer = ((CheckBox) findViewById(R.id.checkbox_fifth_B)).isChecked();
        boolean thirdPartialFifthAnswer = ((CheckBox) findViewById(R.id.checkbox_fifth_C)).isChecked();
        boolean fourthPartialFifthAnswer = ((CheckBox) findViewById(R.id.checkbox_fifth_D)).isChecked();


        if (firstPartialFifthAnswer && !secondPartialFifthAnswer && thirdPartialFifthAnswer && !fourthPartialFifthAnswer) {
            score++;
        }

        return score;
    }

    private void showResult(int points) {
        final String text = "Your score: " + points + "/5";

        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
