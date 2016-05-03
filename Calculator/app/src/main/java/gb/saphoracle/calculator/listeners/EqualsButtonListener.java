package gb.saphoracle.calculator.listeners;

import android.view.View;
import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;
import gb.saphoracle.calculator.utils.Utility;

/**
 * <p></p>
 * <p/>
 * <p></p>
 *
 * @author Luke Beesley
 * @version v0.02
 * @since 29/04/2016
 */
public class EqualsButtonListener extends AbstractButtonListener {

    public EqualsButtonListener(Button btObject, MainActivity ref) {
        super(btObject, ref);
    }

    @Override
    public void onClick(View v) {
        if (ref.number1.toString().equals("") && ref.number2.toString()
                .equals(""))
            return;

        ref.equals = true;

        if (ref.beforeOp || ref.number2.toString().equals("")) {
            return;
        } else {
            //            ref.beforeOp = true;
            ref.number1 = new StringBuilder(Double.toString(ref.result));

            ref.tvCount.setText(Utility.formatLocaleString(ref.number1 +
                    " " +
                    Utility.parseOperator(ref.operator, ref) + "" +
                    " " +
                    ref.number2));
            Utility.calculate(ref.number1, ref.operator, ref.number2, ref);
        }
    }
}
