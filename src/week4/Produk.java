package week4;

import java.util.Objects;

public class Produk {
    private String nama;
    private int jumlah;

    //konstruktor
    public Produk() {
    }

    //getter
    public String getNama() {
        return nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    //setter
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Produk{" +
                "nama='" + nama + '\'' +
                ", jumlah=" + jumlah +
                '}';
    }
}
