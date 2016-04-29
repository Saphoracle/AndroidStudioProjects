package gb.saphoracle.calculator.listeners;

import android.view.View;
import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;
import gb.saphoracle.calculator.utils.Utility;

/**
 * Created by lukeb on 29/04/2016.
 */
public class ZeroButtonListener extends AbstractButtonListener {

    public ZeroButtonListener(Button btObject, MainActivity ref) {
        super(btObject, ref);

        addListener();
    }

    protected void addListener() {
        btObject.setOnClickListener(new View.OnClickListener() {
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
        });
    }


}
