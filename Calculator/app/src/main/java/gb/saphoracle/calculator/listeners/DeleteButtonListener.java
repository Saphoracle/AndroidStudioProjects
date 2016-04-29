package gb.saphoracle.calculator.listeners;

import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;

/**
 * Created by lukeb on 29/04/2016.
 */
public class DeleteButtonListener extends AbstractButtonListener {

    public DeleteButtonListener(Button btObject, MainActivity ref) {
        super(btObject, ref);
    }

    @Override
    protected void addListener() {
        if (ref.beforeOp) {
            if (ref.number1.length() > 0)
                ref.number1.replace(0, ref.number1.length() - 1, ref.number1
                        .substring(0, ref.number1.length() - 1));

        } else {
            if (ref.number2.length() > 0)
                ref.number2.replace(0, ref.number2.length() - 1, ref.number2
                        .substring(0, ref.number2.length() - 1));
        }
    }
}
