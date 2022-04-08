package br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper;

import android.content.ContentValues;

import java.util.List;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.UniversityActivity;

public interface IUniversityActivity
{


        public boolean save(ContentValues cv);
        public boolean update(UniversityActivity universityActivity, ContentValues cv);
        public boolean delete(UniversityActivity universityActivity);
        public List<UniversityActivity> list();

}
