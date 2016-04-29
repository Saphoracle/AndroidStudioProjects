package gb.saphoracle.calculator.listeners;

import android.view.View;
import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;

/**
 * Created by lukeb on 29/04/2016.
 */
public class ClearButtonListener extends AbstractButtonListener {

    public ClearButtonListener(Button btObject, MainActivity ref) {
        super(btObject, ref);

        addListener();
    }

    @Override
    protected void addListener() {
        btObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.beforeOp = true;
                ref.number1 = new StringBuilder();
                ref.number2 = new StringBuilder();
                ref.operator = 0;

                ref.tvCount.setText("");
                ref.tvResult.setText("");
            }
        });
    }
}
