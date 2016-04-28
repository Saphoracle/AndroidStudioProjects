package gb.saphoracle.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btZero;
    private Button btOne;
    private Button btTwo;
    private Button btThree;
    private Button btFour;
    private Button btFive;
    private Button btSix;
    private Button btSeven;
    private Button btEight;
    private Button btNine;
    private Button btDivide;
    private Button btMultiply;
    private Button btSubtract;
    private Button btAdd;
    private Button btEquals;
    private Button btDecimal;
    private Button btClear;

    private TextView tvCount;
    private TextView tvResult;

    private StringBuilder number1 = new StringBuilder();
    private StringBuilder number2 = new StringBuilder();
    private double result;
    private int operator;

    private boolean beforeOp = true;

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
        btZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (beforeOp)
                    if (number1.length() == 0)
                        return;
                    else {
                        number1.append('0');
                        tvCount.setText(number1);
                    }
                else {
                    if (number2.length() == 0)
                        return;
                    else {
                        number2.append('0');
                        tvCount.setText(number1 + " " + parseOperator
                                (operator) + " " + number2);
                    }
                    calculate(number1, operator, number2);
                }
            }
        });

        btOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(1);
                calculate(number1, operator, number2);
            }
        });

        btTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(2);
                calculate(number1, operator, number2);
            }
        });

        btThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(3);
                calculate(number1, operator, number2);
            }
        });

        btFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(4);
                calculate(number1, operator, number2);
            }
        });

        btFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(5);
                calculate(number1, operator, number2);
            }
        });

        btSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(6);
                calculate(number1, operator, number2);
            }
        });

        btSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(7);
                calculate(number1, operator, number2);
            }
        });

        btEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(8);
                calculate(number1, operator, number2);
            }
        });

        btNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(9);
                calculate(number1, operator, number2);
            }
        });

        btDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = 4;
                beforeOp = false;
                tvCount.setText(number1 + " " + parseOperator
                        (operator) + " " + number2);
            }
        });

        btMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = 3;
                beforeOp = false;
                tvCount.setText(number1 + " " + parseOperator
                        (operator) + " " + number2);
            }
        });

        btSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = 2;
                beforeOp = false;
                tvCount.setText(number1 + " " + parseOperator
                        (operator) + " " + number2);
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = 1;
                beforeOp = false;
                tvCount.setText(number1 + " " + parseOperator
                        (operator) + " " + number2);
            }
        });

        btEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beforeOp = true;
                number1.replace(0, number1.length(), Double.toString(result));
                tvCount.setText(number1 + " " + parseOperator
                        (operator) + " " + number2);
                calculate(number1, operator, number2);

            }
        });

        btDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (beforeOp)
                    if (number1.length() == 0) {
                        number1.append("0.");
                    } else {
                        if (number1.indexOf(".") == -1)
                            number1.append('.');
                        else
                            number1 = new StringBuilder(number1.substring(0,
                                    number1.indexOf(".")) + number1
                                    .substring(number1.indexOf(".") +
                                            1) + ".");
                        tvCount.setText(number1);
                    }
                else {
                    if (number2.length() == 0) {
                        number2.append("0.");
                    } else {
                        if (number2.indexOf(".") == -1)
                            number2.append('.');
                        else
                        number2 = new StringBuilder(number2.substring(0,
                                number2.indexOf(".")) +
                                number2.substring(number2.indexOf(".") + 1) +
                                ".");
                        tvCount.setText(number1 + " " + parseOperator
                                (operator) + " " + number2);
                    }
                    calculate(number1, operator, number2);
                }
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beforeOp = true;
                number1 = new StringBuilder();
                number2 = new StringBuilder();
                operator = 0;

                tvCount.setText("");
                tvResult.setText("");
            }
        });
    }

    private void updateValue(int value) {
        if (beforeOp) {
            number1.append(value);
            tvCount.setText(number1);
        } else {
            number2.append(value);
            tvCount.setText(number1 + " " + parseOperator
                    (operator) + " " + number2);
        }
    }

    private char parseOperator(int operator) {
        switch (operator) {
            // ADD
            case 1:
                return '+';
            // SUBTRACT
            case 2:
                return '-';
            // MULTIPLY
            case 3:
                return '*';
            // DIVIDE
            case 4:
                return '/';
            // DEFAULT - This should be impossible to execute
            default:
                tvResult.setText("#ERROR");
                return '#';
        }
    }


    private void calculate(StringBuilder string1, int operator, StringBuilder
            string2) {
        if (beforeOp && number2.toString() == "")
            return;
        double number1 = Double.parseDouble(string1.toString());
        double number2 = Double.parseDouble(string2.toString());
        switch (operator) {
            // ADD
            case 1:
                result = number1 + number2;
                break;
            // SUBTRACT
            case 2:
                result = number1 - number2;
                break;
            // MULTIPLY
            case 3:
                result = number1 * number2;
                break;
            // DIVIDE
            case 4:
                result = number1 / number2;
                break;
            // DEFAULT - This should be impossible to execute
            default:
                tvResult.setText("#ERROR");
                return;
        }
        tvResult.setText(Double.toString(result));
    }


}
