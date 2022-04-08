package br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper;

import android.widget.EditText;

public class Util {
    public static String doubleValueToString(double value) {
        return String.format("%.2f", value);
    }

    public static boolean isEditTextEmpty(EditText editText)

    {
        return (editText.getText().toString().equals("") || editText.getText().toString() == null);
    }
}
