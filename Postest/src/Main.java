import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Film> daftarFilm = new HashMap<>();

        daftarFilm.put("E01",
                new Film("F01", "1 kakak 7 Ponakan", 35000));

        daftarFilm.put("F02",
                new Film("F02", "The Batman ", 50000));

        daftarFilm.put("D03",
                new Film("F03", "Her", 45000));
        Set<String> kursiTerpesan = new HashSet<>();
        List<Transaksi> riwayatTransaksi = new ArrayList<>();

        prosesPemesanan(
                "Iman ",
                "E01",
                "A1",
                daftarFilm,
                kursiTerpesan,
                riwayatTransaksi
        );

        prosesPemesanan(
                "Jaylaine",
                "F02",
                "B4",
                daftarFilm,
                kursiTerpesan,
                riwayatTransaksi
        );

        prosesPemesanan(
                "Ulus",
                "D03",
                "C2",
                daftarFilm,
                kursiTerpesan,
                riwayatTransaksi
        );
        prosesPemesanan(
                "Abo",
                "F01",
                "A1",
                daftarFilm,
                kursiTerpesan,
                riwayatTransaksi
        );
        System.out.println("\nRIWAYAT TRANSAKSI");

        for (Transaksi transaksi : riwayatTransaksi) {

            transaksi.tampilkanTransaksi();
        }
    }
    public static void prosesPemesanan( String namaPemesan, String kodeFilm, String nomorKursi,
    Map<String, Film> daftarFilm, Set<String> kursiTerpesan,
    List<Transaksi> riwayatTransaksi

    ) {

        System.out.println("\nMemproses Pesanan.");
        System.out.println("Nama  : " + namaPemesan);
        System.out.println("Film  : " + kodeFilm);
        System.out.println("Kursi : " + nomorKursi);
        if (!daftarFilm.containsKey(kodeFilm)) {

            System.out.println("GAGAL: Kode film tidak ditemukan!");
            return;
        }
        if (kursiTerpesan.contains(nomorKursi)) {

            System.out.println("GAGAL: Kursi sudah dipesan!");
            return;
        }
        Film filmDipilih = daftarFilm.get(kodeFilm);
        kursiTerpesan.add(nomorKursi);
        riwayatTransaksi.add(

                new Transaksi(
                        namaPemesan,
                        filmDipilih.judulFilm,
                        nomorKursi,
                        filmDipilih.hargaTiket
                )
        );

        System.out.println("PEMESANAN BERHASIL!");
    }
}