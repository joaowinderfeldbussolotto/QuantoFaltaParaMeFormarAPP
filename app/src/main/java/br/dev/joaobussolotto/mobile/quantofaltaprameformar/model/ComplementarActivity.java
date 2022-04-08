package br.dev.joaobussolotto.mobile.quantofaltaprameformar.model;

import android.widget.EditText;

public class ComplementarActivity extends UniversityActivity{

    public ComplementarActivity(){

    }
    public ComplementarActivity(String desc, int year, int semester, int workload ){
        super(desc, year, semester, workload);
    }


    public static ComplementarActivity getComplementarActivityFromEditText(EditText desc, EditText year, EditText semester, EditText workload)
   throws NullPointerException {
        UniversityActivity.checkIfEmptyorNull(desc, year, semester, workload, workload);
        return new ComplementarActivity(desc.getText().toString(), Integer.valueOf(year.getText().toString()), Integer.valueOf(semester.getText().toString()),
                Integer.valueOf(workload.getText().toString()));
    }
}
