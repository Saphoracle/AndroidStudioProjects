package gb.saphoracle.calculator.utils;

import java.util.Locale;

import gb.saphoracle.calculator.MainActivity;

/**
 * Created by lukeb on 29/04/2016.
 */
public class Utility {

    /**
     * Format the string to be compatible with Android setText methods
     * allowing the text to be translated to different languages
     *
     * @param value String Object to convert
     * @return Converted String Object with the formatting of a string and
     * using the Locale version English
     */
    public static String formatLocaleString(String value) {
        return String.format(Locale.ENGLISH, "%s", value);
    }

    public static char parseOperator(int operator, MainActivity ref) {
        switch (operator) {
            // ADD
            case 1:
                return '+';
            // SUBTRACT
            case 2:
                return '-';
            // MULTIPLY
            case 3:
                return '*';
            // DIVIDE
            case 4:
                return '/';
            // DEFAULT - This should be impossible to execute
            default:
                ref.tvResult.setText(formatLocaleString("#ERROR"));
                return '#';
        }
    }


    public static void calculate(StringBuilder string1, int operator,
                                 StringBuilder string2, MainActivity ref) {
        if (ref.beforeOp && string2.toString().equals(""))
            return;
        double number1 = Double.parseDouble(string1.toString());
        double number2 = Double.parseDouble(string2.toString());

        switch (operator) {
            // ADD
            case 1:
                ref.result = number1 + number2;
                break;
            // SUBTRACT
            case 2:
                ref.result = number1 - number2;
                break;
            // MULTIPLY
            case 3:
                ref.result = number1 * number2;
                break;
            // DIVIDE
            case 4:
                ref.result = number1 / number2;
                break;
            // DEFAULT - This should be impossible to execute
            default:
                ref.tvResult.setText(formatLocaleString("#ERROR"));
                return;
        }
        ref.tvResult.setText(formatLocaleString(Double.toString(ref.result)));


    }

    public static void updateValue(int value, MainActivity ref) {
        if (ref.beforeOp) {
            ref.number1.append(value);
            ref.tvCount.setText(ref.number1);
        } else {
            ref.number2.append(value);
            ref.tvCount.setText(Utility.formatLocaleString(ref.number1 +
                    " " +
                    Utility.parseOperator(ref.operator, ref) + "" +
                    " " +
                    ref.number2));
        }
    }


}
