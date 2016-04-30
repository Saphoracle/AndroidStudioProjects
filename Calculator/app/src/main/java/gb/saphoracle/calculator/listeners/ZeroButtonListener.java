package gb.saphoracle.calculator.listeners;

import android.view.View;
import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;
import gb.saphoracle.calculator.utils.Utility;

/**
 * <p>Adds the functionality for the zero button of the calculator
 * application</p>
 * <p/>
 * <p>This class was designed for the calculator application to perform the
 * functionality needed for the zero button of the UI</p>
 *
 * @author Luke Beesley
 * @version v0.01
 * @since 29/04/2016
 */
public class ZeroButtonListener extends AbstractButtonListener {

    public ZeroButtonListener(Button btObject, MainActivity ref) {
        super(btObject, ref);
    }

    @Override
    public void onClick(View v) {
        if (ref.beforeOp) {
            ref.number1.append('0');
            ref.tvCount.setText(ref.number1);
        } else {
            ref.number2.append('0');

            ref.tvCount.setText(Utility.formatLocaleString(ref.number1 +
                    " " +
                    Utility.parseOperator(ref.operator, ref) +
                    " " + ref.number2));
        }
        Utility.calculate(ref.number1, ref.operator, ref.number2, ref);
    }
}
