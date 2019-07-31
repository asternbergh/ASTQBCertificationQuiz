package com.example.android.astqbcertificationquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int question1Score() {
        int q1score = 0;

        CheckBox q1A1 = findViewById(R.id.q1a1);
        boolean q1A1State = q1A1.isChecked();

        CheckBox q1A2 = findViewById(R.id.q1a2);
        boolean q1A2State = q1A2.isChecked();

        CheckBox q1A3 = findViewById(R.id.q1a3);
        boolean q1A3State = q1A3.isChecked();

        CheckBox q1A4 = findViewById(R.id.q1a4);
        boolean q1A4State = q1A4.isChecked();

        if (q1A1State & q1A2State & !q1A3State & q1A4State) {
            q1score++;
        }
        return q1score;
    }

    public int question2Score() {
        int q2score = 0;

        RadioButton q2A1 = findViewById(R.id.q2a1);
        boolean q2A1State = q2A1.isChecked();

        RadioButton q2A2 = findViewById(R.id.q2a2);
        boolean q2A2State = q2A2.isChecked();

        //if answer is correct, add 1 to score
        if (!q2A1State & q2A2State) {
            q2score++;
        }
        return q2score;
    }

    public int question3Score() {
        int q3score = 0;
        EditText answer3 = findViewById(R.id.q3);
        String q3 = answer3.getText().toString().trim();
        if (q3.equalsIgnoreCase("pesticide paradox")) {
            q3score++;
        }
        return q3score;
    }

    public int question4Score() {
        int q4score = 0;

        RadioButton q4A1 = findViewById(R.id.q4a1);
        boolean q4A1State = q4A1.isChecked();

        RadioButton q4A2 = findViewById(R.id.q4a2);
        boolean q4A2State = q4A2.isChecked();

        RadioButton q4A3 = findViewById(R.id.q4a3);
        boolean q4A3State = q4A3.isChecked();

        RadioButton q4A4 = findViewById(R.id.q4a4);
        boolean q4A4State = q4A4.isChecked();

        if (!q4A1State & q4A2State & !q4A3State & !q4A4State) {
            q4score++;
        }
        return q4score;
    }

    public void submitAnswers (View view) {
        //Calculates total score and gives user toast with their results
        int totalScore = question1Score() + question2Score() + question3Score() + question4Score();
        Toast.makeText(this, "Your score is " + totalScore + " out of 4", Toast.LENGTH_LONG).show();
    }
}
