package br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.ComplementarActivity;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.UniversityActivity;

public class ComplementarActivityDAO extends UniversityActivityDAO{
    public ComplementarActivityDAO(Context context) {
        super(context);
        DbHelper dbHelper = new DbHelper(context);
        super.TABLE = dbHelper.ACC_TABLE;
    }

    public boolean save(ComplementarActivity act) {
        ContentValues cv = new ContentValues();
        cv.put("descricao", act.getDescription());
        cv.put("ano", act.getYear());
        cv.put("semestre", act.getSemester());
        cv.put("carga_horaria", act.getWorkload());

        return super.save(cv);
    }

    public boolean update(ComplementarActivity acc) {

        ContentValues cv = new ContentValues();
        cv.put("descricao", acc.getDescription());
        cv.put("ano", acc.getYear());
        cv.put("semestre", acc.getSemester());
        cv.put("carga_horaria", acc.getWorkload());

        return super.update(acc, cv);
    }


    @SuppressLint("Range")
    public List<UniversityActivity> list() {
        List<UniversityActivity> complementarActs = new ArrayList<>();
        String sql = "SELECT * FROM " + DbHelper.ACC_TABLE + ";";
        Cursor c = super.read.rawQuery(sql, null);

        while (c.moveToNext()) {

            ComplementarActivity acc = new ComplementarActivity();
            acc.setId(c.getLong(c.getColumnIndex("id")));
            acc.setDescription(c.getString(c.getColumnIndex("descricao")));
            acc.setSemester(c.getInt(c.getColumnIndex("semestre")));
            acc.setYear(c.getInt(c.getColumnIndex("ano")));
            acc.setWorkload(c.getInt(c.getColumnIndex("carga_horaria")));
            complementarActs.add(acc);
        }
        return complementarActs;
    }
}
