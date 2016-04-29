package gb.saphoracle.calculator.listeners;

import android.view.View;
import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;
import gb.saphoracle.calculator.utils.Utility;

/**
 * Created by lukeb on 29/04/2016.
 */
public class EqualsButtonListener extends AbstractButtonListener {

    public EqualsButtonListener(Button btObject, MainActivity ref) {
        super(btObject, ref);

        addListener();
    }

    @Override
    protected void addListener() {
        btObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.equals = true;

                if (ref.beforeOp && ref.number2.equals("")) {
                    return;
                } else {
                    ref.beforeOp = true;
                    ref.number1.replace(0, ref.number1.length(), Double
                            .toString(ref.result));

                    ref.tvCount.setText(Utility.formatLocaleString(ref.number1 +
                            " " +
                            Utility.parseOperator(ref.operator, ref) + "" +
                            " " +
                            ref.number2));
                    Utility.calculate(ref.number1, ref.operator, ref.number2,
                            ref);
                }
            }
        });
    }
}
