package com.example.balinux.crudsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by balinux on 19/03/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static int DATABASE_VERSION=1;
    private static final String DATABASE_NAME = "db_kampus2";
    private static final String tb_mahasiswa = "tb_mahasiswa";
    private static final String tb_mahasiswa_id = "id";
    private static final String tb_mahasiswa_nama = "nama";
    private static final String tb_mahasiswa_kelas = "kelas";

    private static final String CREATE_TABLE_MAHASISWA = "CREATE TABLE "+ tb_mahasiswa +"("
            + tb_mahasiswa_id + "  INTEGER PRIMARY KEY AUTOINCREMENT,"
            + tb_mahasiswa_nama + " TEXT,"
            + tb_mahasiswa_kelas + " TEXT " + ")";


    public DatabaseHandler(Context context){
     super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MAHASISWA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateMahasiswa(ModalMahasiswa modl){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_mahasiswa_id, modl.get_id());
        values.put(tb_mahasiswa_nama, modl.get_nama());
        values.put(tb_mahasiswa_kelas, modl.get_kelas());
        db.insert(tb_mahasiswa,null,values);
        db.close();
    }

    public List<ModalMahasiswa> ReadMahasiswa() {
        List<ModalMahasiswa> judulModelList = new ArrayList<ModalMahasiswa>();
        String selectQuery = "SELECT  * FROM " + tb_mahasiswa;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModalMahasiswa mdKontak = new ModalMahasiswa();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_kelas(cursor.getString(2));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }


    public int UpdateMahasiswa (ModalMahasiswa mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tb_mahasiswa_nama, mdNotif.get_nama());
        values.put(tb_mahasiswa_kelas, mdNotif.get_kelas());

        return db.update(tb_mahasiswa, values, tb_mahasiswa_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }

    public void DeleteMahasiswa (ModalMahasiswa mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_mahasiswa, tb_mahasiswa_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
