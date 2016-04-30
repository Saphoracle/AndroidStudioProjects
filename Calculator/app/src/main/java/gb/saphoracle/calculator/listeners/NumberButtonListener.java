package gb.saphoracle.calculator.listeners;

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
public class NumberButtonListener extends AbstractButtonListener {

    private int number;

    public NumberButtonListener(Button btObject, MainActivity ref, int number) {
        super(btObject, ref);
        this.number = number;
    }

    @Override
    public void onClick(View v) {
        Utility.updateValue(number, ref);

        Utility.calculate(ref.number1, ref.operator, ref.number2, ref);
    }
}
