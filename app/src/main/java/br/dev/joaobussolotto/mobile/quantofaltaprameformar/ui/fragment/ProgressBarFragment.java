package br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.fragment;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.R;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.ComplementarActivityDAO;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.SubjectDAO;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.UniversityActivityDAO;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.ProgressBarModel;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.Subject;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.UniversityActivity;

public class ProgressBarFragment extends Fragment {


    private ProgressBar progressBarSubject;
    private ProgressBar progressBarCompAct;
    private TextView textViewSubject;
    private TextView textViewComAct;
    private FloatingActionButton fabSettings;
    private static final String PREFERENCES_FILE = "ArquivoPreferencias";

    public ProgressBarFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_progress_bar, container, false);
        fabSettings = view.findViewById(R.id.fabSettings);

        progressBarSubject = (ProgressBar) view.findViewById(R.id.progressBarCCR);
        progressBarCompAct = (ProgressBar) view.findViewById(R.id.progressBarACC);
        textViewSubject = view.findViewById(R.id.textViewProgressCCR);
        textViewComAct = view.findViewById(R.id.textViewProgressACC);
        fabSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPreferencesDialog();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        SubjectDAO subjectDAO = new SubjectDAO(getActivity());
        ComplementarActivityDAO activityDAO = new ComplementarActivityDAO(getActivity());
        ProgressBarModel pBar = new ProgressBarModel(getContext());

        double progressSubjects = pBar.setProgress((ArrayList<UniversityActivity>) subjectDAO.list()) * 100;
        String stringProgressSubject = String.format("%.2f", progressSubjects) + "%";

        double progressCompActs = pBar.setProgress((ArrayList<UniversityActivity>) activityDAO.list()) * 100;
        String stringProgressCompActs = String.format("%.2f", progressCompActs) + "%";

        textViewSubject.setText(stringProgressSubject);
        progressBarSubject.setProgress((int) Math.round(progressSubjects));
        textViewComAct.setText(stringProgressCompActs);
        progressBarCompAct.setProgress((int) Math.round(progressCompActs));
    }

    public void showPreferencesDialog() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.preferences_dialog);
        dialog.show();
        ProgressBarModel pBar = new ProgressBarModel(getContext());
        final EditText subjectTotal = dialog.findViewById(R.id.ccr_et);
        final EditText actTotal = dialog.findViewById(R.id.acc_et);
        subjectTotal.setHint("CCR: Atual: "+ pBar.TOTAL_HOURS_REQUIRED_FOR_SUBJECTS);
        actTotal.setHint("ACCs. Atual: "+ pBar.TOTAL_HOURS_REQUIRED_FOR_ACTIVITIES);
        Button submitButton = dialog.findViewById(R.id.submit_preferences_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getActivity().getSharedPreferences(PREFERENCES_FILE, 0);
                SharedPreferences.Editor editor = preferences.edit();

                try {


                    editor.putInt("CCR", Integer.valueOf(subjectTotal.getText().toString()));
                    editor.putInt("ACC", Integer.valueOf(actTotal.getText().toString()));
                    editor.commit();
                    Toast.makeText(getActivity(), "Salvo com sucesso!", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                    onStart();

                }
                catch(NumberFormatException e) {
                    Toast.makeText(getActivity(), "Preencha os dois campos por favor", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        ProgressBarModel pBar = new ProgressBarModel(getContext());

    }
}
