package br.dev.joaobussolotto.mobile.quantofaltaprameformar.model;

import android.widget.EditText;

import java.io.Serializable;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.Util;

public class UniversityActivity implements Serializable {

    private Long id;
    private String description;
    private Integer year;
    private Integer semester;
    private Integer workload;

    public UniversityActivity() {
    }

    public UniversityActivity(String description, Integer year, Integer semester, Integer workload) {
        this.description = description;
        this.year = year;
        this.semester = semester;
        this.workload = workload;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getWorkload() {
        return this.workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String dateFormated() {
        return this.year + "." + this.semester;
    }

    public static void checkIfEmptyorNull(EditText editTextDescription, EditText editTextSemester, EditText editTextYear,
                                          EditText editTextFinalGrade, EditText editTextWorkload) throws NullPointerException{
        if (Util.isEditTextEmpty(editTextDescription) || Util.isEditTextEmpty(editTextSemester)
                || Util.isEditTextEmpty(editTextYear) || Util.isEditTextEmpty(editTextFinalGrade)
                || Util.isEditTextEmpty(editTextWorkload)) {
            System.out.println("Vasco");
            throw new NullPointerException("Preencha todos os campos");
        }

    }
}


