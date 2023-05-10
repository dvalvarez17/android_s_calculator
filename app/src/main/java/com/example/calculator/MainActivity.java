package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final String ADDITION_SIGN = "+";
    final String SUBSTRAC_SIGN = "-";
    final String MULT_SIGN = "x";
    final String DIV_SIGN = "/";
    final String PERSEN_SIGN = "%";
    boolean isANegNum;
    List<String> operationsList = new ArrayList<>();
    Button ac;
    EditText inputOperations;
    EditText strSentence;
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
        strSentence = findViewById(R.id.inputSentence);

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
        String valInput;
        switch (view.getId()) {
            case R.id.btn_AC:
                cleanAll();
                break;
            case R.id.btn_delete:
                strSentence.setText(deleteLastCharacter());
                break;
            case R.id.btn_num_9:
                assignToInputOperation("9");
                break;
            case R.id.btn_num_8:
                assignToInputOperation("8");
                break;
            case R.id.btn_num_7:
                assignToInputOperation("7");
                break;
            case R.id.btn_num_6:
                assignToInputOperation("6");
                break;
            case R.id.btn_num_5:
                assignToInputOperation("5");
                break;
            case R.id.btn_num_4:
                assignToInputOperation("4");
                break;
            case R.id.btn_num_3:
                assignToInputOperation("3");
                break;
            case R.id.btn_num_2:
                assignToInputOperation("2");
                break;
            case R.id.btn_num_1:
                assignToInputOperation("1");
                break;
            case R.id.btn_num_0:
                assignToInputOperation("0");
                break;
            case R.id.btn_plus_minus:
                String value = inputOperations.getText().toString();
                value = changeNumberSign(value);
                inputOperations.setText(value);
                break;
            case R.id.btn_addition:
                valInput = inputOperations.getText().toString();
                if (isANegNum) {
                    valInput = changeNumberSign(valInput);
                    isANegNum = false;
                }
                assignToInputSentence(this.ADDITION_SIGN, valInput);
                addNewValueIntoOperationList(valInput, "");
                clean();
                break;
            case R.id.btn_div:
                valInput = inputOperations.getText().toString();
                if (isANegNum) {
                    valInput = changeNumberSign(valInput);
                    isANegNum = false;
                }
                assignToInputSentence(this.DIV_SIGN, valInput);
                addNewValueIntoOperationList(valInput, this.DIV_SIGN);
                clean();
                break;
            case R.id.btn_multiply:
                valInput = inputOperations.getText().toString();
                if (isANegNum) {
                    valInput = changeNumberSign(valInput);
                    isANegNum = false;
                }
                assignToInputSentence(this.MULT_SIGN, valInput);
                addNewValueIntoOperationList(valInput, this.MULT_SIGN);
                clean();
                break;
            case R.id.btn_percentage:
                valInput = inputOperations.getText().toString();
                if (isANegNum) {
                    valInput = changeNumberSign(valInput);
                    isANegNum = false;
                }
                assignToInputSentence(this.PERSEN_SIGN, valInput);
                addNewValueIntoOperationList(valInput, this.PERSEN_SIGN);
                clean();
                break;
            case R.id.btn_subs:
                valInput = inputOperations.getText().toString();
                assignToInputSentence("", valInput);
                addNewValueIntoOperationList(valInput, "");
                isANegNum = true;
                clean();
                break;
            case R.id.btn_equals:
                List<String> result;
                valInput = this.inputOperations.getText().toString();
                if (this.isANegNum) {
                    valInput = changeNumberSign(valInput);
                    this.isANegNum = false;
                }
                assignToInputSentence("", valInput);
                addNewValueIntoOperationList(valInput, "");
                result = solveSentence(this.operationsList);
                inputOperations.setText(result.get(0));
                break;
        }
    }

    public void assignToInputSentence(String operator, String value) {
        String chainTxt = strSentence.getText().toString();
        chainTxt += value;
        if (operator != null) {
            chainTxt += operator;
        }
        strSentence.setText(chainTxt);
    }

    public void assignToInputOperation(String newText) {
        String chainTxt = inputOperations.getText().toString();
        chainTxt += newText;
        inputOperations.setText(chainTxt);
    }

    /**
     * @param operator, always empty as long as the operator isn't multiplication or division.
     */
    public void addNewValueIntoOperationList(String newVal, String operator) {
        if (!operator.isEmpty()) {
            operationsList.add(newVal);
            operationsList.add(operator);
        } else if (!newVal.isEmpty()) {
            operationsList.add(newVal);
        }
    }

    public List<String> solveSentence(List<String> operationList) {
        List<String> resultLst = new ArrayList<>();
        int operatorIndex = 0,
                indexNum1 = 0,
                indexNum2 = 0;
        float num1 = 0F,
              num2 = 0F;
        String result = "";
        if (operationList.contains(this.MULT_SIGN)) {
            if (operationList.contains(this.PERSEN_SIGN)) {
                operatorIndex = operationList.indexOf(this.PERSEN_SIGN);
                indexNum1 = operationList.indexOf(this.MULT_SIGN) - 1;
                indexNum2 = operatorIndex - 1;
                num1 = Float.parseFloat(operationList.get(indexNum1));
                num2 = Float.parseFloat(operationList.get(indexNum2));
                result = String.valueOf(getPercentage(num1, num2));
            } else {
                operatorIndex = operationList.indexOf(MULT_SIGN);
                indexNum1 = operatorIndex - 1;
                indexNum2 = operatorIndex + 1;
                num1 = Float.parseFloat(operationList.get(indexNum1));
                num2 = Float.parseFloat(operationList.get(indexNum2));
                result = String.valueOf(getMultiplication(num1, num2));
            }
        } else if (operationList.contains(DIV_SIGN)) {
            operatorIndex = operationList.indexOf(this.DIV_SIGN);
            indexNum1 = operatorIndex - 1;
            indexNum2 = operatorIndex + 1;
            num1 = Float.parseFloat(operationList.get(indexNum1));
            num2 = Float.parseFloat(operationList.get(indexNum2));
            result = String.valueOf(getDivision(num1, num2));
        }  else {
            if (operationList.size() > 1) {
                String restSum = String.valueOf(getAddition(operationList));
                return getListWithNewResult(restSum);
            }
            return operationList;
        }
        resultLst = solveSentence(getListWithNewResult(operationList, indexNum1, indexNum2, result));
        return resultLst;
    }


    public List<String> getListWithNewResult(List<String> list, int indexStart, int indexEnd, String result) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(this.PERSEN_SIGN)) {
                if (i < indexStart || i > indexEnd) {
                    resultList.add(list.get(i));
                } else if (i == indexStart) {
                    resultList.add(result);
                }
            }
        }
        return resultList;
    }

    public List<String> getListWithNewResult(String result) {
        List<String> newList = new ArrayList<>();
        newList.add(result);
        return newList;
    }

    public float getAddition(List<String> numbers) {
        float total = 0F;
        for(String num: numbers) {
            total += Float.parseFloat(num);
        }
        return total;
    }

    /*public float getSubtraction(float num1, float num2) {
        return num1 - num2;
    }*/

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

    public void clean(){
        inputOperations.setText("");
    }

    public void cleanAll() {
        inputOperations.setText("");
        strSentence.setText("");
        operationsList.clear();
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

    public String changeNumberSign(String value) {
        int num = Integer.parseInt(value);
        num *= -1;
        return String.valueOf(num);
    }
}