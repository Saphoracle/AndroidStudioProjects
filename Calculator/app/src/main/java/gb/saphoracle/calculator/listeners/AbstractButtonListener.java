package gb.saphoracle.calculator.listeners;

import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;

/**
 * Created by lukeb on 29/04/2016.
 */
public abstract class AbstractButtonListener {

    protected MainActivity ref;
    protected Button btObject;

    public AbstractButtonListener(Button btObject, MainActivity ref) {
        this.ref = ref;
        this.btObject = btObject;
    }

    protected abstract void addListener();

}
