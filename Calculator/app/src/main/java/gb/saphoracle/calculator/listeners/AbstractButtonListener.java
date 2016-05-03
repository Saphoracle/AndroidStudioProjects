package gb.saphoracle.calculator.listeners;

import android.view.View;
import android.widget.Button;

import gb.saphoracle.calculator.MainActivity;

/**
 * <p>Contains the constructor and protected attributes for usage by the
 * subclasses</p>
 *
 * <p>This class implements the View.OnClickListener meaning that all
 * subclasses will also need to implement the inherited methods.</p>
 *
 * @author Luke Beesley
 * @version v0.01
 * @since 30/04/2016
 */
public abstract class AbstractButtonListener implements View.OnClickListener {

    protected MainActivity ref;
    protected Button btObject;

    public AbstractButtonListener(Button btObject, MainActivity ref) {
        this.ref = ref;
        this.btObject = btObject;
    }
}
