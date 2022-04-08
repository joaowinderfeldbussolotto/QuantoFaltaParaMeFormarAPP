package br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.R;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.ComplementarActivityDAO;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.SubjectDAO;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.ComplementarActivity;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.Subject;

public class AddComplementarActivity extends AddUniversityActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_add_complementar);

        super.onCreate(savedInstanceState);

    }

    public void onClickSave(View view) {
        try {
            ComplementarActivity newAct = ComplementarActivity.getComplementarActivityFromEditText(editTextDescription, editTextYear, editTextSemester, editTextWorkload);
            ComplementarActivityDAO activityDAO = new ComplementarActivityDAO(this);

            if(universityActivity!=null){
                newAct.setId(universityActivity.getId());
                if(activityDAO.update(newAct)){
                    Toast.makeText(this, "Atualizado com sucesso!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(this, "Erro ao atualizar", Toast.LENGTH_LONG).show();
                }
            }
            if(universityActivity == null){
                if(activityDAO.save(newAct)){
                    Toast.makeText(this, "Adicionado com sucesso!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(this, "Erro ao adicionar!", Toast.LENGTH_LONG).show();

                }
            }
            finish();
        } catch (NullPointerException ne) {
            Toast.makeText(this, ne.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}