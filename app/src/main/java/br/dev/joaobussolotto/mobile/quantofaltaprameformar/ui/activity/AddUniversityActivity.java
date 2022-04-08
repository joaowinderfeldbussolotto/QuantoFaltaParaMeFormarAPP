package br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.temporal.Temporal;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.R;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.SubjectDAO;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.Subject;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.UniversityActivity;


public class AddUniversityActivity extends Activity {
    private TextView title;

    protected EditText editTextDescription;
    protected EditText editTextYear;
    protected EditText editTextSemester;
    protected EditText editTextWorkload;

    protected UniversityActivity universityActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = findViewById(R.id.textViewAddNewSubject);
        editTextDescription = findViewById(R.id.EditTextSubjectDesc);
        editTextYear = findViewById(R.id.EditTextSubjectYear);
        editTextSemester = findViewById(R.id.EditTextSubjectSemester);
        editTextWorkload = findViewById(R.id.editTextWorkLoad);
        universityActivity = (UniversityActivity) getIntent().getSerializableExtra("selectedSubject");
        System.out.println(editTextDescription.toString());
        System.out.println(editTextYear.toString());
        System.out.println(editTextWorkload.toString());
        System.out.println(editTextSemester.toString());
        if (universityActivity != null) {
            editTextDescription.setText(universityActivity.getDescription());
            editTextYear.setText(universityActivity.getYear().toString());
            editTextSemester.setText(universityActivity.getSemester().toString());
            editTextWorkload.setText(universityActivity.getWorkload().toString());
            if (universityActivity instanceof Subject) {
                title.setText("Altere uma CCR");
            } else {
                title.setText("Altere uma Atividade");

            }
        }


    }



}