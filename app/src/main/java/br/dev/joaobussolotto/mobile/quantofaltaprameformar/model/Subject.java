package br.dev.joaobussolotto.mobile.quantofaltaprameformar.model;

import android.widget.EditText;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.Util;

public class Subject extends UniversityActivity{
    private double finalGrade;
    public Subject(String description, int year, int semester, int workload, double finalGrade){
        super(description, year, semester, workload);
        this.finalGrade = finalGrade;
    }

    public Subject(){}

    public Subject(String description, String year, String semester, String workload, String finalGrade){
        super(description, Integer.valueOf(year), Integer.valueOf(semester), Integer.valueOf(workload));
        this.finalGrade = Double.valueOf(finalGrade);
    }

    public double getFinalGrade(){
        return this.finalGrade;
    }
    public void setFinalGrade(float fg){this.finalGrade = fg;}

    public static Subject getSubjectFromEditText(EditText desc, EditText year, EditText semester, EditText workload, EditText finalGrade
    ) throws  NullPointerException{
        UniversityActivity.checkIfEmptyorNull(desc,year,semester, workload, finalGrade);
        return new Subject(desc.getText().toString(), year.getText().toString(), semester.getText().toString(), workload.getText().toString(), finalGrade.getText().toString());
    }


}
