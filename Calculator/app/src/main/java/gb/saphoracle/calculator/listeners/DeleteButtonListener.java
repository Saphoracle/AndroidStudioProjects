package gb.saphoracle.calculator.listeners;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;
import gb.saphoracle.calculator.utils.Utility;

/**
 * <p></p>
 *
 * <p></p>
 *
 * @author Luke Beesley
 * @version v0.01
 * @since 29/04/2016
 */
public class DeleteButtonListener extends AbstractButtonListener {

    public DeleteButtonListener(Button btObject, MainActivity ref) {
        super(btObject, ref);
    }

    @Override
    public void onClick(View v) {
        if (ref.beforeOp) {
            Log.println(Log.ASSERT, "DEBUG", "beforeOp = true");
            if (ref.number1.toString().length() > 0) {
                Log.println(Log.ASSERT, "DEBUG", "number1.length() > " +
                        "" + "0");
                ref.number1 = new StringBuilder(ref.number1.substring(0, ref
                        .number1.length() - 1));
                ref.tvCount.setText(Utility.formatLocaleString(ref.number1
                        .toString()));
            }

        } else {
            if (ref.number2.toString().length() > 0) {
                ref.number2 = new StringBuilder(ref.number2.substring(0, ref
                        .number2.length() - 1));
                ref.tvCount.setText(Utility.formatLocaleString(ref.number1 +
                        " " +
                        Utility.parseOperator(ref.operator, ref) + "" +
                        " " +
                        ref.number2));
            } else {
                ref.operator = 0;
                ref.beforeOp = true;
                ref.tvCount.setText(Utility.formatLocaleString(ref.number1
                        .toString()));
            }
        }

        if (!ref.beforeOp) {
            if (ref.number2.toString().equals("")) {
                ref.tvResult.setText(Utility.formatLocaleString(""));
            } else {
                Utility.calculate(ref.number1, ref.operator, ref.number2, ref);

            }
        }
    }
}
