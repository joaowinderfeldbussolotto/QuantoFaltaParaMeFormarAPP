package br.dev.joaobussolotto.mobile.quantofaltaprameformar.model;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.ui.fragment.ProgressBarFragment;

public class ProgressBarModel
{
    private double progress;
    public int  TOTAL_HOURS_REQUIRED_FOR_SUBJECTS;
    public int TOTAL_HOURS_REQUIRED_FOR_ACTIVITIES;


    public ProgressBarModel(Context context){
        setTotalHours(context);
    }
    public double setProgress(ArrayList<UniversityActivity> activities){
        int totalWorkLoad = 0;
        for(UniversityActivity activity: activities ){
            totalWorkLoad +=activity.getWorkload();
        }
        if(totalWorkLoad == 0){
            return 0.0;
        }
        if(activities.get(0) != null && activities.get(0) instanceof Subject){
            progress =totalWorkLoad/Double.valueOf(TOTAL_HOURS_REQUIRED_FOR_SUBJECTS);
        }
        else{
            progress =totalWorkLoad/Double.valueOf(TOTAL_HOURS_REQUIRED_FOR_ACTIVITIES);
        }
        return progress;
    }

    private void setTotalHours(Context context){
        SharedPreferences preferences = context.getSharedPreferences("ArquivoPreferencias",0);
        TOTAL_HOURS_REQUIRED_FOR_SUBJECTS = preferences.getInt("CCR",3210);
        TOTAL_HOURS_REQUIRED_FOR_ACTIVITIES = preferences.getInt("ACC", 300);
    }


}
