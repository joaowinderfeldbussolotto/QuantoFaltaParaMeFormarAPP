package br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.R;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.ComplementarActivityDAO;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper.SubjectDAO;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.activity.AddComplementarActivity;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.activity.AddSubjectActivity;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.adapter.AdapterSubjectList;

public class ComplementarActListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        super.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddComplementarActivity.class);
                startActivity( intent );
            }
        });
        return view;
    }

    public void loadList(){

        ComplementarActivityDAO activitiesDAO = new ComplementarActivityDAO(getActivity());
        super.universityActivities = activitiesDAO.list();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        super.recyclerView.setLayoutManager(layoutManager);
        super.recyclerView.setHasFixedSize(true);
        super.recyclerView.setAdapter(new AdapterSubjectList(universityActivities));
        super.recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.HORIZONTAL));
    }

    @Override
    public void onStart() {
        super.onStart();
        loadList();

    }

    @Override
    public void onResume() {
        super.onResume();
        loadList();
    }
}