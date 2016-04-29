package gb.saphoracle.calculator.listeners;

import android.view.View;
import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;
import gb.saphoracle.calculator.utils.Utility;

/**
 * Created by lukeb on 29/04/2016.
 */
public class OperatorButtonListener extends AbstractButtonListener {

    private int opID;

    public OperatorButtonListener(Button btObject, MainActivity ref, int opID) {
        super(btObject, ref);
        this.opID = opID;

        addListener();
    }


    @Override
    protected void addListener() {
        btObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ref.number1.toString().equals("") && ref.number2.toString
                        ().equals(""))
                    return;

                ref.operator = opID;
                if (!ref.beforeOp) {
                    if (ref.number2.toString().equals(""))
                        return;
                    Utility.calculate(ref.number1, ref.operator, ref.number2,
                            ref);
                }

                ref.beforeOp = false;
                ref.tvCount.setText(Utility.formatLocaleString(ref.number1 +
                        " " +
                        Utility.parseOperator(ref.operator, ref) + "" +
                        " " +
                        ref.number2));

                /*
                Trial code
                 */
                if (!ref.beforeOp) {
                    if (ref.number2.length() > 0) {
/*
                       This code changes whether or not the pre-calculated
                       value before pressing equals is added into the
                       equation as number1 this function is currently
                       disabled as it is not the preferred functionality.
*/
                        //                        ref.number1.replace(0, ref
                        // .number1.length(), Double
                        //                                .toString(ref
                        // .result));
                        ref.number2 = new StringBuilder();

                        ref.tvCount.setText(Utility.formatLocaleString(ref
                                .number1 +
                                " " +
                                Utility.parseOperator(ref.operator, ref) + "" +
                                " " +
                                ref.number2));
                    }
                }
            }
        });
    }
}
