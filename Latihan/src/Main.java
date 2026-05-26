import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Buku> katalogBuku = new HashMap<>();

        katalogBuku.put("ISBN001", new Buku("ISBN001", "Laskar Pelangi"));
        katalogBuku.put("ISBN002", new Buku("ISBN002", "Bumi Manusia"));
        katalogBuku.put("ISBN003", new Buku("ISBN003", "Atomic Habits"));

        Set<Anggota> daftarAnggota = new HashSet<>();

        daftarAnggota.add(new Anggota("A01", "Ruswan", "Mahasiswa"));
        daftarAnggota.add(new Anggota("A02", "Sangaji", "Dosen"));
        daftarAnggota.add(new Anggota("A03", "Aldo", "Mahasiswa"));

        daftarAnggota.add(new Anggota("A01", "Ruswan Duplicate", "Mahasiswa"));

        LinkedList<String> antrean = new LinkedList<>();

        antrean.addLast("A01#ISBN001"); 
        antrean.addFirst("A02#ISBN002"); 
        antrean.addLast("A03#ISBN003"); 
        antrean.addFirst("A04#ISBN001"); 

        Set<String> bukuDipinjam = new HashSet<>();

        System.out.println(" PROSES PEMINJAMAN ");

        while (!antrean.isEmpty()) {

            String data = antrean.removeFirst();

            String[] pecah = data.split("#");

            String idAnggota = pecah[0];
            String isbn = pecah[1];

            boolean anggotaValid = false;

            for (Anggota anggota : daftarAnggota) {

                if (anggota.idAnggota.equals(idAnggota)) {
                    anggotaValid = true;
                    break;
                }
            }

            System.out.println("\nMemproses: " + data);

            if (!anggotaValid) {

                System.out.println("GAGAL: Anggota tidak terdaftar.");
                continue;
            }
            if (!katalogBuku.containsKey(isbn)) {

                System.out.println("GAGAL: Buku tidak ditemukan.");
                continue;
            }

            if (bukuDipinjam.contains(isbn)) {

                System.out.println("GAGAL: Buku sedang dipinjam.");
                continue;
            }
            bukuDipinjam.add(isbn);

            System.out.println("PEMINJAMAN BERHASIL");
            System.out.println("Buku: ");
            katalogBuku.get(isbn).tampilkanInfo();
        }

        System.out.println("\nBUKU SEDANG DIPINJAM");

        for (String isbn : bukuDipinjam) {

            katalogBuku.get(isbn).tampilkanInfo();
        }
    }
}