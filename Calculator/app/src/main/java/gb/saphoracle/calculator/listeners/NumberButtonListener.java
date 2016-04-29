package gb.saphoracle.calculator.listeners;

import android.view.View;
import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;
import gb.saphoracle.calculator.utils.Utility;

/**
 * Created by lukeb on 29/04/2016.
 */
public class NumberButtonListener extends AbstractButtonListener {

    private int number;

    public NumberButtonListener(Button btObject, MainActivity ref, int number) {
        super(btObject, ref);
        this.number = number;

        addListener();
    }

    @Override
    protected void addListener() {

        btObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.updateValue(number, ref);

                Utility.calculate(ref.number1, ref.operator, ref.number2, ref);
            }
        });

    }

}
