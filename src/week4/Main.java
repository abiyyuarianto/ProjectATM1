package week4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        int menu;
        Keranjang keranjang = new Keranjang();
        try {
            Scanner input = new Scanner(System.in);
            do {
                System.out.println("---Menu---");
                System.out.println("1.Tambah Produk");
                System.out.println("2.Hapus Produk");
                System.out.println("3.Ubah Produk");
                System.out.println("4.Lihat Produk");
                System.out.println("5.Keluar");
                System.out.print("Pilihan Menu:");
                menu = input.nextInt();

                String nama;
                int jumlah;
                Produk p = new Produk();
                switch (menu) {
                    case 1:
                        System.out.print("Input nama produk yang akan di-TAMBAH: ");
                        nama = input.next(); //inputan nama produk
                        //pengecekan kondisi apakah produk sudah pernah ada dikeranjang
                        if(keranjang.findProductByName(nama)==null){ //kondisi produk belum ada di keranjang
                            System.out.print("Input jumlah: ");
                            jumlah = input.nextInt(); //inputan jumlah produk
                            p.setNama(nama);
                            p.setJumlah(jumlah);
                            keranjang.tambahProduk(p); //panggil method tambah produk
                            System.out.println("Produk berhasil ditambah");
                        }else{ //kondisi produk sudah ada di keranjang
                            System.out.println("Produk sudah ada, silahkan gunakan menu [Ubah Produk] jika ingin mengubah jumlah produk");
                        }
                        break;
                    case 2:
                        System.out.print("Input nama produk yang akan di-HAPUS: ");
                        nama = input.next();//inputan nama produk
                        p = keranjang.findProductByName(nama);
                        //pengecekan kondisi apakah produk ada dikeranjang
                        if(p==null){ //kondisi produk tidak ada di keranjang
                            System.out.println("Produk yang dicari tidak ada");
                        }else{ //kondisi produk ada di keranjang
                            System.out.println("Apakah Anda yakin mau menghapus produk ini dari keranjang Anda? [Ya | Tidak]");
                            System.out.print("Jawab: ");
                            String jawab = input.next();
                            if (jawab.equalsIgnoreCase("Ya")) {
                                keranjang.hapusProduk(p); //panggil method hapus produk
                                System.out.println("Produk berhasil dihapus");
                            }else if (jawab.equalsIgnoreCase("Tidak")){
                                break;
                            }else {
                                System.out.println("Jawaban tidak valid");
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Input nama produk yang akan di-UBAH:");
                        nama = input.next();//inputan nama produk
                        p = keranjang.findProductByName(nama);
                        //pengecekan kondisi apakah produk ada dikeranjang
                        if(p==null){
                            System.out.println("Produk yang dicari tidak ada");
                        }else{
                            System.out.print("Input jumlah baru: ");
                            jumlah = input.nextInt(); //inputan jumlah produk
                            System.out.println("Apakah Anda yakin dengan jumlah produk saat ini? [Ya | Tidak]");
                            System.out.print("Jawab: ");
                            String jawab = input.next();
                            if (jawab.equalsIgnoreCase("Ya")) {
                                keranjang.ubahProduk(p,jumlah); //panggil method ubah produk
                                System.out.println("Jumlah berhasil diubah");
                            }else if (jawab.equalsIgnoreCase("Tidak")){
                                break;
                            }else {
                                System.out.println("Jawaban tidak valid");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Daftar Produk di Keranjang:");
                        if(keranjang.listProduk.isEmpty()){
                            System.out.println("Keranjang Kosong");
                        }else {
                            keranjang.lihatDaftarProduk(); //panggil method print list produk
                        }
                        break;
                    case 5:
                        break;
                }
            }while (menu!=5);
        }catch (InputMismatchException e){
            System.out.println("Input Invalid");
        }
    }
}

