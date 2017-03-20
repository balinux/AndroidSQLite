package com.example.balinux.crudsqlite;

/**
 * Created by balinux on 19/03/17.
 */


//public class ModalMahasiswa {
//
//    private String _id, _nama, _kelas;
//
//    public ModalMahasiswa (String id, String nama, String kelas) {
//        this._id = id;
//        this._nama = nama;
//        this._kelas = kelas;
//    }
//
//    public ModalMahasiswa () {
//
//    }
//
//    public void set_id (String id) {
//        this._id = id;
//    }
//
//    public String get_id () {
//        return this._id;
//    }
//
//    public void set_nama (String nama) {
//        this._nama = nama;
//    }
//
//    public String get_nama () {
//        return this._nama;
//    }
//
//    public void set_kelas (String kelas) {
//        this._kelas = kelas;
//    }
//
//    public String get_kelas () {
//        return this._kelas;
//    }
//
//}

public class ModalMahasiswa {
    private String _id, _nama, _kelas;

    public ModalMahasiswa(String id, String nama, String kelas){
        this._id = id;
        this._nama = nama;
        this._kelas = kelas;
    }

    public ModalMahasiswa () {

    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_nama() {
        return this._nama;
    }

    public void set_nama(String _nama) {
        this._nama = _nama;
    }

    public String get_kelas() {
        return this._kelas;
    }

    public void set_kelas(String _kelas) {
        this._kelas = _kelas;
    }
}
