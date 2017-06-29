package com.example.sargento.homework10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

// Input: this program will take in the user 10-number combination
// Output: If user's 10-number combination matches, then the label changes to "You won:)". If not matching, then the user will be prompted to enter a new 10-number combination

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Declare the variables we are manipulating
    TextView textView1;
    TextView textView2;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;

    //create our counter for amount of buttons pressed
    int buttonsPressed = 0;

    //create our empty array for entries
    int [] entries = new int[10];

    //create an array for our password sequence
    int [] password = new int[]{1,2,3,4,5,6,7,8,9,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        button1 = (Button)findViewById(R.id.buttonOne);
        button2 = (Button)findViewById(R.id.buttonTwo);
        button3 = (Button)findViewById(R.id.buttonThree);
        button4 = (Button)findViewById(R.id.buttonFour);
        button5 = (Button)findViewById(R.id.buttonFive);
        button6 = (Button)findViewById(R.id.buttonSix);
        button7 = (Button)findViewById(R.id.buttonSeven);
        button8 = (Button)findViewById(R.id.buttonEight);
        button9 = (Button)findViewById(R.id.buttonNine);
        button0 = (Button)findViewById(R.id.buttonZero);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
    }

    /*
        The following action function does the following:
        Based on the corresponding button, it will add an element to the entries array
        If the counter is 10, then that means the user entered their 10-number combination and compareArrays() will be called to determine if the combination is correct.
        If the combination is correct then change the label to "You won:)" and open the box; else send a prompt to have the user try again.
        After each 10-number combination, the counter will be reset to 0 and the entry array will be empty for another attempt.
        If the counter is less than 10, then textView1 says "Result"
    */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonOne: {
                entries[buttonsPressed] = 1;
                textView1.setText("One");
                break;
            }
            case R.id.buttonTwo: {
                entries[buttonsPressed] = 2;
                textView1.setText("Two");
                break;
            }
            case R.id.buttonThree: {
                entries[buttonsPressed] = 3;
                textView1.setText("Three");
                break;
            }
            case R.id.buttonFour: {
                entries[buttonsPressed] = 4;
                textView1.setText("Four");
                break;
            }
            case R.id.buttonFive: {
                entries[buttonsPressed] = 5;
                textView1.setText("Five");
                break;
            }
            case R.id.buttonSix: {
                entries[buttonsPressed] = 6;
                textView1.setText("Six");
                break;
            }
            case R.id.buttonSeven: {
                entries[buttonsPressed] = 7;
                textView1.setText("Seven");
                break;
            }
            case R.id.buttonEight: {
                entries[buttonsPressed] = 8;
                textView1.setText("Eight");
                break;
            }
            case R.id.buttonNine: {
                entries[buttonsPressed] = 9;
                textView1.setText("Nine");
                break;
            }
            case R.id.buttonZero: {
                entries[buttonsPressed] = 0;
                textView1.setText("Zero");
                break;
            }
            default:
                break;
        }
        buttonsPressed += 1;
        if (buttonsPressed == 10) {
            if (!compareArrays()) {
                textView2.setText("You Lost. Try again.");
            } else {
                textView2.setText("You Won:)");
                textView1.setText("One Two Three Four Five Six Seven Eight Nine Zero.");
            }
            buttonsPressed = 0;
            Arrays.fill(entries, 0);
        } else {
            textView2.setText("Result");
        }
    }

    /*
        When called this Boolean-returning function will compare the user's entry with the hard-coded secret combination, one element a time.
        A false is returned for mis-match; a true is returned for matching combination
    */
    public Boolean compareArrays() {
        Boolean check = true;
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != password[i]) {
                check = false;
                break;
            } else {
                check = true;
            }
        }
        return check;
    }
}
