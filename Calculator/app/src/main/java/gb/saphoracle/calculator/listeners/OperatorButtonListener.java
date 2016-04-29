package gb.saphoracle.calculator.listeners;

import android.view.View;
import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;
import gb.saphoracle.calculator.utils.Utility;

/**
 * Created by lukeb on 29/04/2016.
 */
public class OperatorButtonListener extends AbstractButtonListener {

    private int opID;

    public OperatorButtonListener(Button btObject, MainActivity ref, int opID) {
        super(btObject, ref);
        this.opID = opID;

        addListener();
    }


    @Override
    protected void addListener() {
        btObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.operator = opID;
                ref.beforeOp = false;
                ref.tvCount.setText(Utility.formatLocaleString(ref.number1 +
                        " " +
                        Utility.parseOperator(ref.operator, ref) + "" +
                        " " +
                        ref.number2));
            }
        });
    }
}
