package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    TextView result , processingCal;
    Button buttonC, buttonbrackOpen, buttonbrackclose, buttondivde, buttonMulti, buttonAdd,
            buttonMinus, buttonEqual, buttonDot, buttonAc, button1 , button2, button3, button4,
            button5, button6, button7, button8, button9, button0;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.resultTV);
        processingCal = findViewById(R.id.processingCal);

        getId(button0,R.id.button_Zero);
        getId(button1,R.id.button_one);
        getId(button2,R.id.button_two);
        getId(button3,R.id.button_Three);
        getId(button4,R.id.button_Four);
        getId(button5,R.id.button_Five);
        getId(button6,R.id.button_six);
        getId(button7,R.id.button_Seven);
        getId(button8,R.id.button_Eight);
        getId(button9,R.id.button_Nine);
        getId(buttonC,R.id.button_c);
        getId(buttonbrackOpen,R.id.button_brackOpen);
        getId(buttonbrackclose,R.id.button_brackClose);
        getId(buttondivde,R.id.button_Divide);
        getId(buttonMulti,R.id.button_Multi);
        getId(buttonAdd,R.id.button_Add);
        getId(buttonMinus,R.id.button_Minus);
        getId(buttonEqual,R.id.button_Equal);
        getId(buttonDot,R.id.button_Dot);
        getId(buttonAc,R.id.button_AC);

    }

    void getId(Button btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String buttonText  = button.getText().toString();
        String dataToCalculate = processingCal.getText().toString();

        if(buttonText.equals("AC")){
            processingCal.setText("");
            result.setText("0");
            return;
        }
        else if(buttonText.equals("=")){
            //processingCal.setText(resultTV.getText());
            String finalResult = processingCal.getText().toString();
            ClaculatorData data = new ClaculatorData();
            result.setText(data.calculatedResult(finalResult));
        }
        else if(buttonText.equals("C")){
            if(dataToCalculate.equals("0") || dataToCalculate.equals("") ){
                    return;
            }else {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
        }
        else{
            dataToCalculate = dataToCalculate + buttonText ;
        }

        processingCal.setText(dataToCalculate);

    }

}