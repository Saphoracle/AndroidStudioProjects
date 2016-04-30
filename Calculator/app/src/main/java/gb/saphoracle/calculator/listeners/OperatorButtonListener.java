package gb.saphoracle.calculator.listeners;

import android.view.View;
import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;
import gb.saphoracle.calculator.utils.Utility;

/**
 * <p>Contains the functionality for either the /, -, = or * mathematical
 * operations</p>
 * <p/>
 * <p>This class was designed for the calculator application to dynamically
 * create a listener for either of the /, -, = or * mathematical
 * operations that can be performed by the calculator</p>
 *
 * @author Luke Beesley
 * @version v0.01
 * @since 29/04/2016
 */
public class OperatorButtonListener extends AbstractButtonListener {

    private int opID;

    public OperatorButtonListener(Button btObject, MainActivity ref, int opID) {
        super(btObject, ref);
        this.opID = opID;
    }

    @Override
    public void onClick(View v) {
        if (ref.number1.toString().equals("") && ref.number2.toString()
                .equals(""))
            return;

        ref.operator = opID;
        if (!ref.beforeOp) {
            ref.tvCount.setText(Utility.formatLocaleString(ref.number1 +
                    " " +
                    Utility.parseOperator(ref.operator, ref) + "" +
                    " " +
                    ref.number2));
            if (ref.number2.toString().equals(""))
                return;
            Utility.calculate(ref.number1, ref.operator, ref.number2, ref);
        }

        ref.beforeOp = false;
        ref.tvCount.setText(Utility.formatLocaleString(ref.number1 +
                " " +
                Utility.parseOperator(ref.operator, ref) + "" +
                " " +
                ref.number2));

        if (!ref.beforeOp) {
            if (ref.number2.length() > 0) {
     //           ref.number2 = new StringBuilder();

                ref.tvCount.setText(Utility.formatLocaleString(ref.number1 +
                        " " +
                        Utility.parseOperator(ref.operator, ref) + "" +
                        " " +
                        ref.number2));
            }
        }
    }
}
