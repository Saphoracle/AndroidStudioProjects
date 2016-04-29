package gb.saphoracle.calculator.listeners;

import android.view.View;
import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;
import gb.saphoracle.calculator.utils.Utility;

/**
 * Created by lukeb on 29/04/2016.
 */
public class DecimalButtonListener extends AbstractButtonListener {

    public DecimalButtonListener(Button btObject, MainActivity ref) {
        super(btObject, ref);

        addListener();
    }

    @Override
    protected void addListener() {
        btObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ref.beforeOp)
                    if (ref.number1.length() == 0) {
                        ref.number1.append("0.");
                        ref.tvCount.setText(ref.number1);
                    } else {
                        if (ref.number1.indexOf(".") == -1)
                            ref.number1.append('.');
                        else {
                            ref.number1 = new StringBuilder(ref.number1
                                    .substring(0, ref.number1.indexOf(".")) +
                                    ref.number1.substring(ref.number1.indexOf
                                            (".") + 1) + ".");
                        }
                        ref.tvCount.setText(ref.number1);
                    }
                else {
                    if (ref.number2.length() == 0) {
                        ref.number2.append("0.");
                    } else {
                        if (ref.number2.indexOf(".") == -1)
                            ref.number2.append('.');
                        else
                            ref.number2 = new StringBuilder(ref.number2
                                    .substring(0, ref.number2.indexOf(".")) +
                                    ref.number2.substring(ref.number2.indexOf
                                            (".") + 1) +
                                    ".");
                    }
                    ref.tvCount.setText(Utility.formatLocaleString(ref.number1 +
                            " " +
                            Utility.parseOperator(ref.operator, ref) + " " +
                            ref.number2));
                    Utility.calculate(ref.number1, ref.operator, ref.number2,
                            ref);
                }
            }
        });
    }
}
