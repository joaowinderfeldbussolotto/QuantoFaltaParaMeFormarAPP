package br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.ComplementarActivityDAO;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.SubjectDAO;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.Subject;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.UniversityActivityDAO;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.UniversityActivity;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.activity.AddComplementarActivity;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.activity.AddSubjectActivity;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.activity.AddUniversityActivity;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.activity.MainActivity;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.R;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.RecyclerItemClickListener;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.adapter.AdapterSubjectList;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    protected RecyclerView recyclerView;
    private AdapterSubjectList subjectListAdapter;
    protected List<UniversityActivity> universityActivities = new ArrayList<UniversityActivity>();
    protected FloatingActionButton fab;
    private UniversityActivity selectedActivity;


    public ListFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewSubjectList);
        onTouchItem(recyclerView, view);
        fab = (FloatingActionButton) view.findViewById(R.id.fabAdd);


        return view;
    }

    public void onTouchItem(RecyclerView recyclerView, View view){
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        view.getContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }

                            @Override
                            public void onItemClick(View view, int position) {
                                selectedActivity = universityActivities.get( position );
                                Intent intent;
                                //Envia aticidade para tela adicionar tarefa
                                if(selectedActivity instanceof Subject){
                                    intent = new Intent(getActivity(), AddSubjectActivity.class );
                                }
                                else{
                                    intent = new Intent(getActivity(), AddComplementarActivity.class);
                                }
                                intent.putExtra("selectedSubject", selectedActivity );

                                startActivity( intent );

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                //Recupera CCR para deletar
                                selectedActivity = universityActivities.get( position );


                                AlertDialog.Builder dialog = new AlertDialog.Builder(view.getContext());

                                //Configura título e mensagem
                                dialog.setTitle("Confirmar exclusão");
                                dialog.setMessage("Deseja excluir Item: " + selectedActivity.getDescription() + " ?");

                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        UniversityActivityDAO activityDAO;
                                        if(selectedActivity instanceof Subject){
                                            activityDAO = new SubjectDAO(getContext());
                                        }
                                        else{
                                           activityDAO = new ComplementarActivityDAO(getContext());
                                        }
                                        if ( activityDAO.delete(selectedActivity) ){


                                            Toast.makeText(getContext(),
                                                    "Sucesso ao excluir Item!",
                                                    Toast.LENGTH_SHORT).show();
                                            onResume();

                                        }else {
                                            Toast.makeText(getContext(),
                                                    "Erro ao excluir Item!",
                                                    Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });
                                dialog.setNegativeButton("Não", null);

                                //Exibir dialog
                                dialog.create();
                                dialog.show();

                            }

                        }
                ));
    }

    public void addNewSubject(View view){
        Intent intent = new Intent(getActivity(),MainActivity.class);
        ((MainActivity) getActivity()).startActivity(intent);

    }


}