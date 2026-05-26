public class Film {

    String kodeFilm;
    String judulFilm;
    int hargaTiket;

    public Film(String kodeFilm, String judulFilm, int hargaTiket) {
        this.kodeFilm = kodeFilm;
        this.judulFilm = judulFilm;
        this.hargaTiket = hargaTiket;
    }

    public void tampilkanFilm() {

        System.out.println("Kode Film  : " + kodeFilm);
        System.out.println("Judul Film : " + judulFilm);
        System.out.println("Harga      : Rp " + hargaTiket);
    }
}