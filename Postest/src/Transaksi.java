public class Transaksi {

    String namaPemesan;
    String judulFilm;
    String nomorKursi;
    int harga;

    public Transaksi(String namaPemesan, String judulFilm, String nomorKursi, int harga) {

        this.namaPemesan = namaPemesan;
        this.judulFilm = judulFilm;
        this.nomorKursi = nomorKursi;
        this.harga = harga;
    }

    public void tampilkanTransaksi() {

        System.out.println("Nama Pemesan : " + namaPemesan);
        System.out.println("Film         : " + judulFilm);
        System.out.println("Kursi        : " + nomorKursi);
        System.out.println("Harga        : Rp " + harga);
    }
}