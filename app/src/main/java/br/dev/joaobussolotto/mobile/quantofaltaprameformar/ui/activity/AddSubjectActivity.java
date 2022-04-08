package br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.acl.AclEntry;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.R;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.SubjectDAO;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.Subject;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.UniversityActivity;

public class AddSubjectActivity extends AddUniversityActivity {

    protected EditText editTextFinalGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_add_subject);
        super.onCreate(savedInstanceState);
        editTextFinalGrade = findViewById(R.id.editTextFinalGrade);
        if(universityActivity !=null) {
            editTextFinalGrade.setText(String.valueOf(((Subject) universityActivity).getFinalGrade()));
        }

    }

    public void onClickSave(View view) {

            try {
                Subject newSubject = Subject.getSubjectFromEditText(super.editTextDescription, editTextYear,
                        editTextSemester, editTextWorkload, editTextFinalGrade);
                SubjectDAO subjectDAO = new SubjectDAO(this);
                if(universityActivity!=null){
                    newSubject.setId(universityActivity.getId());
                    if(subjectDAO.update(newSubject)){
                        Toast.makeText(this, "Atualizado com sucesso!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(this, "Erro ao atualizar", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    if(subjectDAO.save(newSubject)){
                        Toast.makeText(this, "Adicionado com sucesso!", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(this, "Erro ao adicionar!", Toast.LENGTH_LONG).show();

                    }
                }
                finish();

            }catch(NullPointerException ne){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
            }
            catch(Exception e){
                Toast.makeText(this, "Erro no banco de dados ", Toast.LENGTH_LONG).show();

            }

    }
}
