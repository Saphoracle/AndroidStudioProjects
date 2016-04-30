package gb.saphoracle.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import gb.saphoracle.calculator.listeners.ClearButtonListener;
import gb.saphoracle.calculator.listeners.DecimalButtonListener;
import gb.saphoracle.calculator.listeners.DeleteButtonListener;
import gb.saphoracle.calculator.listeners.EqualsButtonListener;
import gb.saphoracle.calculator.listeners.NumberButtonListener;
import gb.saphoracle.calculator.listeners.OperatorButtonListener;
import gb.saphoracle.calculator.listeners.ZeroButtonListener;

public class MainActivity extends AppCompatActivity {

    /*
    Create references to the UI objects within the .xml file
     */
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
    public Button btDelete;

    public TextView tvCount;
    public TextView tvResult;

    /*
    Store the values for the inputs, operator and product of the calculation
    performed
     */
    public StringBuilder number1 = new StringBuilder();
    public StringBuilder number2 = new StringBuilder();
    public double result;
    public int operator;

    /*
    Check values to determine what part of the calculation we are currently in
     */
    public boolean beforeOp = true;
    public boolean equals = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        We need to find and assign the .xml UI objects to the java objects to
         allow functionality to be performed with them.
         */
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
        btDelete = (Button) findViewById(R.id.btDelete);

        tvCount = (TextView) findViewById(R.id.tvCount);
        tvResult = (TextView) findViewById(R.id.tvResult);

        /*
        Add the listeners to the buttons used in the UI
         */
        addButtonListeners();
    }

    private void addButtonListeners() {
        final int DIVIDE = 4;
        final int MULTIPLY = 3;
        final int SUBTRACT = 2;
        final int ADD = 1;

        btZero.setOnClickListener(new ZeroButtonListener(btZero, this));

        btOne.setOnClickListener(new NumberButtonListener(btOne, this, 1));

        btTwo.setOnClickListener(new NumberButtonListener(btTwo, this, 2));

        btThree.setOnClickListener(new NumberButtonListener(btThree, this, 3));

        btFour.setOnClickListener(new NumberButtonListener(btFour, this, 4));

        btFive.setOnClickListener(new NumberButtonListener(btFive, this, 5));

        btSix.setOnClickListener(new NumberButtonListener(btSix, this, 6));

        btSeven.setOnClickListener(new NumberButtonListener(btSeven, this, 7));

        btEight.setOnClickListener(new NumberButtonListener(btEight, this, 8));

        btNine.setOnClickListener(new NumberButtonListener(btNine, this, 9));

        btDivide.setOnClickListener(new OperatorButtonListener(btDivide,
                this, DIVIDE));

        btMultiply.setOnClickListener(new OperatorButtonListener(btMultiply,
                this, MULTIPLY));

        btSubtract.setOnClickListener(new OperatorButtonListener(btSubtract,
                this, SUBTRACT));

        btAdd.setOnClickListener(new OperatorButtonListener(btAdd, this, ADD));

        btEquals.setOnClickListener(new EqualsButtonListener(btEquals, this));

        btDecimal.setOnClickListener(new DecimalButtonListener(btDecimal,
                this));

        btClear.setOnClickListener(new ClearButtonListener(btClear, this));

        btDelete.setOnClickListener(new DeleteButtonListener(btDelete, this));
    }

}
