package com.alonlavie.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtCalculations,txtCurrentNumber;
    ImageButton btnZero,btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnseven,btnEight,btnNine;
    ImageButton btnEquals,btnDivide,btnSubtract,btnMultiply,btnClear,btnAdd;
    float currentNumber=0;
    float resultNumber=0;
    Boolean isStillWritingOneNumber=true;
    String copyOfLastCalculation;
    Boolean isStillCalculating=false;

    String whatToDo="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCalculations = findViewById(R.id.txtCalculation);
        txtCurrentNumber = findViewById(R.id.txtCurrentNumber);

        btnZero = findViewById(R.id.btnZero);
        btnZero.setOnClickListener(this);

        btnOne = findViewById(R.id.btnOne);
        btnOne.setOnClickListener(this);

        btnTwo= findViewById(R.id.btnTwo);
        btnTwo.setOnClickListener(this);

        btnThree = findViewById(R.id.btnThree);
        btnThree.setOnClickListener(this);

        btnFour = findViewById(R.id.btnFour);
        btnFour.setOnClickListener(this);

        btnFive = findViewById(R.id.btnFive);
        btnFive.setOnClickListener(this);

        btnSix = findViewById(R.id.btnSix);
        btnSix.setOnClickListener(this);

        btnseven = findViewById(R.id.btnSeven);
        btnseven.setOnClickListener(this);

        btnEight = findViewById(R.id.btnEight);
        btnEight.setOnClickListener(this);

        btnNine = findViewById(R.id.btnNine);
        btnNine.setOnClickListener(this);

        btnEquals = findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(this);

        btnDivide = findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(this);

        btnSubtract = findViewById(R.id.btnSubtract);
        btnSubtract.setOnClickListener(this);


        btnMultiply = findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(this);

        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        txtCurrentNumber.setText("0");
        currentNumber=0;

        txtCalculations.setText("");
        resultNumber=0;




    }

    @Override
    public void onClick(View v) {



        switch (v.getId()){
            case R.id.btnZero:
                currentNumber = currentNumber*10;
                logicOutputOfCalc();


                break;
            case R.id.btnOne:


                    currentNumber = currentNumber*10+1;
                logicOutputOfCalc();


                break;
            case R.id.btnTwo:

                currentNumber = currentNumber*10+2;
                logicOutputOfCalc();
                break;
            case R.id.btnThree:

                currentNumber = currentNumber*10+3;
                logicOutputOfCalc();
                break;
            case R.id.btnFour:
                currentNumber = currentNumber*10+4;
                logicOutputOfCalc();
                break;
            case R.id.btnFive:
                currentNumber = currentNumber*10+5;
                logicOutputOfCalc();
                break;


            case R.id.btnSix:
                currentNumber = currentNumber*10+6;
                logicOutputOfCalc();
                break;
            case  R.id.btnSeven:
                currentNumber = currentNumber*10+7;
                logicOutputOfCalc();
                break;
            case R.id.btnEight:
                currentNumber = currentNumber*10+8;
                logicOutputOfCalc();
                break;
            case R.id.btnNine:
                currentNumber = currentNumber*10+9;
                logicOutputOfCalc();
                break;





            case R.id.btnClear:
                currentNumber=0;
                txtCurrentNumber.setText("0");
                txtCalculations.setText("");
                resultNumber=0;
                isStillCalculating=false;

                break;

            case R.id.btnAdd:

                setOutputForCalculations("+");

                if(whatToDo == "") {
                    whatToDo = "add";
                }


                doCalculation();

                currentNumber=0;
                whatToDo="add";





                break;

            case R.id.btnSubtract:

                setOutputForCalculations("-");

                if(whatToDo != ""){
                    doCalculation();

                } else {


                    if (resultNumber == 0) {
                        resultNumber = currentNumber;
                    } else {
                        resultNumber = resultNumber - currentNumber;
                    }
                }
                currentNumber=0;

                whatToDo="sub";


                break;

            case R.id.btnDivide:

                setOutputForCalculations("/");

                if(whatToDo != ""){
                    doCalculation();

                } else {


                    if (currentNumber == 0) {

                        txtCalculations.setText("Error cannot divide 0");
                        break;

                    } else if (resultNumber == 0) {

                        resultNumber = currentNumber;

                    } else {

                        resultNumber = resultNumber / currentNumber;

                    }
                }
                currentNumber=0;
                whatToDo="div";

                break;

            case R.id.btnMultiply:

                setOutputForCalculations("*");

                if(whatToDo != ""){
                    doCalculation();

                } else {


                      if (resultNumber == 0) {


                        resultNumber = currentNumber;

                    } else {
                        resultNumber = resultNumber * currentNumber;
                    }
                }
                currentNumber=0;
                whatToDo="mul";

                break;

            case R.id.btnEquals:

                doCalculation();
                if(resultNumber==0){
                    resultNumber=currentNumber;
                }

                txtCurrentNumber.setText(Float.toString(resultNumber));
                isStillCalculating=false;
                isStillWritingOneNumber=true;


                currentNumber=resultNumber;
                resultNumber=0;

                whatToDo="";
                break;

        }

    }

    public  void logicOutputOfCalc(){
        txtCurrentNumber.setText(Float.toString(currentNumber));

        if(isStillCalculating && isStillWritingOneNumber){
            txtCalculations.setText(copyOfLastCalculation+Float.toString(currentNumber));




        }else if(isStillWritingOneNumber && !isStillCalculating){

            txtCalculations.setText(Float.toString(currentNumber));






        }


    }
    public void setOutputForCalculations(String sign){
        isStillWritingOneNumber=false;
        copyOfLastCalculation=txtCalculations.getText().toString();
        if(isStillCalculating) {
            txtCalculations.setText(copyOfLastCalculation+" "+sign+" ");
        }else {
            txtCalculations.setText(currentNumber + " "+sign+" ");


        }
        copyOfLastCalculation=txtCalculations.getText().toString();

        txtCurrentNumber.setText("");
        isStillCalculating=true;
        isStillWritingOneNumber=true;
    }
    public void doCalculation(){
        if (whatToDo.equals("add")) {

            resultNumber = resultNumber + currentNumber;

        } else if (whatToDo.equals("sub")) {

            resultNumber = resultNumber - currentNumber;

        } else if (whatToDo.equals("div")) {

            resultNumber = resultNumber / currentNumber;

        } else if (whatToDo.equals("mul")) {

            resultNumber = resultNumber * currentNumber;
        } else {

            Toast.makeText(this,"nothing",Toast.LENGTH_SHORT).show();



        }
    }
}