package gb.saphoracle.calculator.listeners;

import android.view.View;
import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;

/**
 * <p>OnClickListener class for the clear button within the calculator UI</p>
 * <p/>
 * <p>This class contains the specific functionality for the clear button
 * within the calculator UI</p>
 *
 * @author Luke Beesley
 * @version v0.01
 * @since 29/04/2016
 */
public class ClearButtonListener extends AbstractButtonListener {

    public ClearButtonListener(Button btObject, MainActivity ref) {
        super(btObject, ref);
    }

    @Override
    public void onClick(View v) {
        ref.beforeOp = true;
        ref.number1 = new StringBuilder();
        ref.number2 = new StringBuilder();
        ref.operator = 0;

        ref.tvCount.setText("");
        ref.tvResult.setText("");
    }
}
