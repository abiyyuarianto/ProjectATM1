package week4;

import java.util.ArrayList;

public class Keranjang {
    ArrayList<Produk> listProduk;

    //konstruktor
    public Keranjang() {
        this.listProduk = new ArrayList<Produk>();
    }

    //Menambah produk ke dalam array list
    public void tambahProduk(Produk p){
        this.listProduk.add(p);
    }

    //Mencari produk menggunakan nama produk
    public Produk findProductByName(String name){
        return listProduk.stream().filter(produk -> name.equals(produk.getNama())).findFirst().orElse(null);
    }

    //Menghapus produk tertentu menggunakan nama produk
    public void hapusProduk(Produk p){
        listProduk.remove(p);
    }

    //mengubah jumlah produk tertentu
    public void ubahProduk(Produk p, int jumlah){
        p.setJumlah(jumlah);
    }

    //lihat semua produk yang ada di list
    public void lihatDaftarProduk(){
        listProduk.stream().forEach(System.out::println);
    }
}
