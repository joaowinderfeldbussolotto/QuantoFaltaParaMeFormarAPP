package br.dev.joaobussolotto.mobile.quantofaltaprameformar.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static int VERSION = 4;
    public static String DB_NAME = "DB_ATIVIDADES";
    public static String CCR_TABLE = "CCR";
    public static String ACC_TABLE = "ACC";


    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TABLE_CCR = "CREATE TABLE IF NOT EXISTS " + CCR_TABLE
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " descricao VARCHAR(50) NOT NULL," +
                "semestre INT(1)," +
                "ano INT(1)," +
                "media DECIMAL," +
                "carga_horaria int not null);";
        String TABLE_ACC = "CREATE TABLE IF NOT EXISTS " + ACC_TABLE
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " descricao VARCHAR(50) NOT NULL," +
                "semestre INT(1)," +
                "ano INT(1)," +
                "carga_horaria int not null);";
            try {
                sqLiteDatabase.execSQL(TABLE_CCR);
                sqLiteDatabase.execSQL(TABLE_ACC);
                Log.i("INFO DB", "Sucesso ao criar a tabela");
            }
            catch (SQLException e){
                Log.e("INFO", "erro ao criar tabela");
            }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String TABLE_CCR = "CREATE TABLE IF NOT EXISTS " + CCR_TABLE
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " descricao VARCHAR(50) NOT NULL," +
                "semestre INT(1)," +
                "ano INT(1)," +
                "media DECIMAL," +
                "carga_horaria int not null);";
        String TABLE_ACC = "CREATE TABLE IF NOT EXISTS " + ACC_TABLE
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " descricao VARCHAR(50) NOT NULL," +
                "semestre INT(1)," +
                "ano INT(1)," +
                "carga_horaria int not null);";
        try {
            sqLiteDatabase.execSQL(TABLE_CCR);
            sqLiteDatabase.execSQL(TABLE_ACC);
            Log.i("INFO DB", "Sucesso ao criar a tabela");
        }
        catch (SQLException e){
            Log.e("INFO", "erro ao criar tabela");
        }

    }
}
