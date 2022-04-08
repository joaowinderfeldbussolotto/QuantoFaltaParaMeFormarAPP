package br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.Subject;
import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.UniversityActivity;

public class SubjectDAO extends UniversityActivityDAO {


    public SubjectDAO(Context context) {
        super(context);
        DbHelper dbHelper = new DbHelper(context);
        super.TABLE = dbHelper.CCR_TABLE;
    }

    public boolean save(Subject subject) {
        ContentValues cv = new ContentValues();
        cv.put("descricao", subject.getDescription());
        cv.put("ano", subject.getYear());
        cv.put("semestre", subject.getSemester());
        cv.put("carga_horaria", subject.getWorkload());
        cv.put("media", subject.getFinalGrade());

        return super.save(cv);
    }

    public boolean update(Subject subject) {
        ContentValues cv = new ContentValues();
        cv.put("descricao", subject.getDescription());
        cv.put("ano", subject.getYear());
        cv.put("semestre", subject.getSemester());
        cv.put("carga_horaria", subject.getWorkload());
        cv.put("media", subject.getFinalGrade());

        return super.update(subject, cv);
    }


    public List<UniversityActivity> list() {
        List<UniversityActivity> subjects = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE
                + ";";
        Cursor c = super.read.rawQuery(sql, null);

        while (c.moveToNext()) {

            Subject subject = new Subject();
            Long id = c.getLong(0);
            subject.setId(c.getLong(0));
            subject.setDescription(c.getString(1));
            subject.setSemester(c.getInt(2));
            subject.setYear(c.getInt(3));
            subject.setFinalGrade((float) c.getDouble(4));
            subject.setWorkload(c.getInt(5));
            subjects.add(subject);
        }
        return subjects;
    }
}
