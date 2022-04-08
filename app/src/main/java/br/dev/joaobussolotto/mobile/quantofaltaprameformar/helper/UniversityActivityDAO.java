package br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.dev.joaobussolotto.mobile.quantofaltaprameformar.model.UniversityActivity;

public abstract class UniversityActivityDAO  implements IUniversityActivity{
    protected SQLiteDatabase save;
    protected SQLiteDatabase read;
    protected String TABLE;

    public UniversityActivityDAO(Context context){
        DbHelper dbHelper = new DbHelper(context);
        save = dbHelper.getReadableDatabase();
        read = dbHelper.getWritableDatabase();
    }

    @Override
    public boolean save(ContentValues cv) {

        try{
            save.insert(TABLE, null, cv);
            Log.i("Info", "Td certo");
        }
        catch(Exception e){
            Log.e("Info","erro" + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean update(UniversityActivity universityActivity, ContentValues cv) {

        System.out.println("na dao:" + universityActivity.getId());
        try {
            String[] args = {universityActivity.getId().toString()};
            save.update(TABLE, cv, "id=?", args );
            Log.i("INFO", "CCR atualizada com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "eror ao atualizada   ccr " + e.getMessage() );
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(UniversityActivity universityActivity) {
        try {
            String[] args = { universityActivity.getId().toString() };
            save.delete(TABLE, "id=?", args );
            Log.i("INFO", "CCR removida com sucesso!");
        }catch (Exception e){
            Log.e("INFO", "Erro ao remover CCR " + e.getMessage() );
            return false;
        }

        return true;
    }



}
