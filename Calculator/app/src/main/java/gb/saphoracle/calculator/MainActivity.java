package gb.saphoracle.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import gb.saphoracle.calculator.listeners.ClearButtonListener;
import gb.saphoracle.calculator.listeners.DecimalButtonListener;
import gb.saphoracle.calculator.listeners.EqualsButtonListener;
import gb.saphoracle.calculator.listeners.NumberButtonListener;
import gb.saphoracle.calculator.listeners.OperatorButtonListener;
import gb.saphoracle.calculator.listeners.ZeroButtonListener;

public class MainActivity extends AppCompatActivity {

    private final int DIVIDE = 4;
    private final int MULTIPLY = 3;
    private final int SUBTRACT = 2;
    private final int ADD = 1;

    public Button btZero;
    public Button btOne;
    public Button btTwo;
    public Button btThree;
    public Button btFour;
    public Button btFive;
    public Button btSix;
    public Button btSeven;
    public Button btEight;
    public Button btNine;
    public Button btDivide;
    public Button btMultiply;
    public Button btSubtract;
    public Button btAdd;
    public Button btEquals;
    public Button btDecimal;
    public Button btClear;

    public TextView tvCount;
    public TextView tvResult;

    public StringBuilder number1 = new StringBuilder();
    public StringBuilder number2 = new StringBuilder();
    public double result;
    public int operator;

    public boolean beforeOp = true;
    public boolean equals = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btZero = (Button) findViewById(R.id.btZero);
        btOne = (Button) findViewById(R.id.btOne);
        btTwo = (Button) findViewById(R.id.btTwo);
        btThree = (Button) findViewById(R.id.btThree);
        btFour = (Button) findViewById(R.id.btFour);
        btFive = (Button) findViewById(R.id.btFive);
        btSix = (Button) findViewById(R.id.btSix);
        btSeven = (Button) findViewById(R.id.btSeven);
        btEight = (Button) findViewById(R.id.btEight);
        btNine = (Button) findViewById(R.id.btNine);
        btDivide = (Button) findViewById(R.id.btDivide);
        btMultiply = (Button) findViewById(R.id.btMultiply);
        btSubtract = (Button) findViewById(R.id.btSubtract);
        btAdd = (Button) findViewById(R.id.btAdd);
        btEquals = (Button) findViewById(R.id.btEquals);
        btDecimal = (Button) findViewById(R.id.btDecimal);
        btClear = (Button) findViewById(R.id.btClear);

        tvCount = (TextView) findViewById(R.id.tvCount);
        tvResult = (TextView) findViewById(R.id.tvResult);

        addButtonListeners();
    }

    private void addButtonListeners() {

        new ZeroButtonListener(btZero, this);

        new NumberButtonListener(btOne, this, 1);

        new NumberButtonListener(btTwo, this, 2);

        new NumberButtonListener(btThree, this, 3);

        new NumberButtonListener(btFour, this, 4);

        new NumberButtonListener(btFive, this, 5);

        new NumberButtonListener(btSix, this, 6);

        new NumberButtonListener(btSeven, this, 7);

        new NumberButtonListener(btEight, this, 8);

        new NumberButtonListener(btNine, this, 9);

        new OperatorButtonListener(btDivide, this, DIVIDE);

        new OperatorButtonListener(btMultiply, this, MULTIPLY);

        new OperatorButtonListener(btSubtract, this, SUBTRACT);

        new OperatorButtonListener(btAdd, this, ADD);

        new EqualsButtonListener(btEquals, this);

        new DecimalButtonListener(btDecimal, this);

        new ClearButtonListener(btClear, this);
    }

}
