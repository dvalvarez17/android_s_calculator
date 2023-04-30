package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String operation;
    float num1;
    float num2;
    Button ac;
    EditText inputOperations;
    Button numEight;
    Button numFive;
    Button numFour;
    Button numNine;
    Button numOne;
    Button numSeven;
    Button numSix;
    Button numTree;
    Button numTwo;
    Button numZero;
    Button signAddition;
    Button signDeleteLast;
    Button signDivision;
    Button signEquals;
    Button signMultiplication;
    Button signPersentage;
    Button signPlusMinus;
    Button signSubtraction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ac = findViewById(R.id.btn_AC);
        inputOperations = findViewById(R.id.inputOperations);
        numEight = findViewById(R.id.btn_num_8);
        numFive = findViewById(R.id.btn_num_5);
        numFour = findViewById(R.id.btn_num_4);
        numNine = findViewById(R.id.btn_num_9);
        numOne = findViewById(R.id.btn_num_1);
        numSeven = findViewById(R.id.btn_num_7);
        numSix = findViewById(R.id.btn_num_6);
        numTree = findViewById(R.id.btn_num_3);
        numTwo = findViewById(R.id.btn_num_2);
        numZero = findViewById(R.id.btn_num_0);
        signAddition = findViewById(R.id.btn_addition);
        signDeleteLast = findViewById(R.id.btn_delete);
        signDivision = findViewById(R.id.btn_div);
        signEquals = findViewById(R.id.btn_equals);
        signMultiplication = findViewById(R.id.btn_multiply);
        signPersentage = findViewById(R.id.btn_percentage);
        signPlusMinus = findViewById(R.id.btn_plus_minus);
        signSubtraction = findViewById(R.id.btn_subs);

        ac.setOnClickListener(this);
        inputOperations.setOnClickListener(this);
        numEight.setOnClickListener(this);
        numFive.setOnClickListener(this);
        numFour.setOnClickListener(this);
        numNine.setOnClickListener(this);
        numOne.setOnClickListener(this);
        numSeven.setOnClickListener(this);
        numSix.setOnClickListener(this);
        numTree.setOnClickListener(this);
        numTwo.setOnClickListener(this);
        numZero.setOnClickListener(this);
        signAddition.setOnClickListener(this);
        signDeleteLast.setOnClickListener(this);
        signDivision.setOnClickListener(this);
        signEquals.setOnClickListener(this);
        signMultiplication.setOnClickListener(this);
        signPersentage.setOnClickListener(this);
        signPlusMinus.setOnClickListener(this);
        signSubtraction.setOnClickListener(this);
        signEquals.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_AC:
                cleanAll();
                break;
            case R.id.btn_delete:
                inputOperations.setText(deleteLastCharacter());
                break;
            case R.id.btn_num_9:
                assignToInputOperations("9");
                break;
            case R.id.btn_num_8:
                assignToInputOperations("8");
                break;
            case R.id.btn_num_7:
                assignToInputOperations("7");
                break;
            case R.id.btn_num_6:
                assignToInputOperations("6");
                break;
            case R.id.btn_num_5:
                assignToInputOperations("5");
                break;
            case R.id.btn_num_4:
                assignToInputOperations("4");
                break;
            case R.id.btn_num_3:
                assignToInputOperations("3");
                break;
            case R.id.btn_num_2:
                assignToInputOperations("2");
                break;
            case R.id.btn_num_1:
                assignToInputOperations("1");
                break;
            case R.id.btn_num_0:
                assignToInputOperations("0");
                break;
            case R.id.btn_plus_minus:

                break;
            case R.id.btn_addition:
                num1 = Float.parseFloat(inputOperations.getText().toString());
                // assignToInputOperations("+");
                operation = "+";
                cleanAll();
                break;
            case R.id.btn_div:
                num1 = Float.parseFloat(inputOperations.getText().toString());
                // assignToInputOperations("/");
                operation = "/";
                cleanAll();
                break;
            case R.id.btn_multiply:
                num1 = Float.parseFloat(inputOperations.getText().toString());
                // assignToInputOperations("x");
                operation = "*";
                cleanAll();
                break;
            case R.id.btn_percentage:
                assignToInputOperations("%");
                operation += "%";
                break;
            case R.id.btn_subs:
                num1 = Float.parseFloat(inputOperations.getText().toString());
                // assignToInputOperations("-");
                operation = "-";
                cleanAll();
                break;
            case R.id.btn_equals:
                String txtVal = inputOperations.getText().toString();
                if (operation.equals("*%")) {
                    txtVal = deleteLastCharacter(txtVal);
                }
                num2 = Float.parseFloat(txtVal);
                getCalculation();
                break;
        }
    }

    public void assignToInputOperations(String newText) {
        String chainTxt = inputOperations.getText().toString();
        chainTxt += newText;
        inputOperations.setText(chainTxt);
    }

    public void getCalculation() {
        switch (operation) {
            case "+":
                inputOperations.setText(String.valueOf(getAddition(num1, num2)));
                break;
            case "-":
                inputOperations.setText(String.valueOf(getSubtraction(num1, num2)));
                break;
            case "*":
                inputOperations.setText(String.valueOf(getMultiplication(num1, num2)));
                break;
            case "/":
                inputOperations.setText(String.valueOf(getDivision(num1, num2)));
                break;
            case "*%":
                System.out.println("operation = " + operation);
                inputOperations.setText(String.valueOf(getPercentage(num1, num2)));
                break;
        }
    }

    public float getAddition(float num1, float num2) {
        return num1 + num2;
    }

    public float getSubtraction(float num1, float num2) {

        return num1 - num2;
    }

    public float getMultiplication(float num1, float num2) {
        return num1 * num2;
    }

    public float getDivision(float num1, float num2) {
        return num1 / num2;
    }

    public float getPercentage(float num1, float num2) {
        num2 = getDivision(num2, 100);
        return getMultiplication(num1, num2);
    }

    /*public void setPlusMinusSign() {
        String txt = inputOperations.getText().toString();
        if (txt.contains("-")) {
            int len = txt.length();
            txt = txt.substring(1, len - 1);
        } else {
            txt = txt.
        }

    }*/

    public void cleanAll() {
        inputOperations.setText("");
    }

    public String deleteLastCharacter() {
        String chainTxt = inputOperations.getText().toString();
        int length = chainTxt.length();
        return chainTxt.substring(0, length - 1);
    }

    public String deleteLastCharacter(String txt) {
        int length = txt.length();
        return txt.substring(0, length - 1);
    }
}