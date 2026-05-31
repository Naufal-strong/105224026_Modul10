import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class SistemGudang {
    private Map<String, Barang> databaseBarang;
    private Set<String> kategoriUnik;
    private List<String> riwayatAktivitas;

    public SistemGudang() {
        databaseBarang   = new HashMap<>();
        kategoriUnik     = new HashSet<>();
        riwayatAktivitas = new ArrayList<>();
    }
    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {
        if (databaseBarang.containsKey(id)) {
            String log = "[GAGAL] Daftar Barang: ID '" + id + "' sudah ada di sistem.";
            riwayatAktivitas.add(log);
            System.out.println(log);
            return;
        }
        Barang barangBaru = new Barang(id, nama, kategori, stok);
        databaseBarang.put(id, barangBaru);
        kategoriUnik.add(kategori);
        String log = "(BARU) Barang Baru Terdaftar: " + nama + " (ID: " + id + ", Kategori: " + kategori + ", Stok Awal: " + stok + " unit)";
        riwayatAktivitas.add(log);
        System.out.println(log);
    }
    public void tambahStok(String id, int jumlah) {
        Barang barang = databaseBarang.get(id);
        if (barang != null) {
            int stokLama = barang.getStok();
            barang.setStok(stokLama + jumlah);
            String log = "(MASUK)Tambah Stok: " + barang.getNamaBarang() + " (ID: " + id + ") +" + jumlah + " unit -> Total: " + barang.getStok() + " unit";
            riwayatAktivitas.add(log);
            System.out.println(log);
        } else {
            String log = "(GAGAL)Tambah Stok: ID '" + id + "' tidak ditemukan.";
            riwayatAktivitas.add(log);
            System.out.println(log);
        }
    }
    public void kurangiStok(String id, int jumlah) {
        Barang barang = databaseBarang.get(id);
        if (barang == null) {
            String log = "[GAGAL] Kurangi Stok: ID '" + id + "' tidak ditemukan.";
            riwayatAktivitas.add(log);
            System.out.println(log);
            return;
        }
        if (barang.getStok() >= jumlah) {
            barang.setStok(barang.getStok() - jumlah);
            String log = "[OK]    Kurangi Stok: " + barang.getNamaBarang() + " (ID: " + id + ") -" + jumlah + " unit -> Sisa: " + barang.getStok() + " unit";
            riwayatAktivitas.add(log);
            System.out.println(log);
        } else {
            String log = "[GAGAL] Kurangi Stok: " + barang.getNamaBarang() + " (ID: " + id + ") stok tidak mencukupi. Diminta: " + jumlah + " unit, Tersedia: " + barang.getStok() + " unit";
            riwayatAktivitas.add(log);
            System.out.println(log);
        }
    }
    public void cetakLaporan() {
        System.out.println("LAPORAN AKHIR SISTEM GUDANG");

        System.out.println("\nDAFTAR KATEGORI UNIK");
        for (String kat : kategoriUnik) {
            System.out.println("  * " + kat);
        }

        System.out.println("\n SISA STOK SELURUH BARANG DI GUDANG");
        System.out.printf("  %-6s %-15s %-12s %s%n", "ID", "Nama", "Kategori", "Stok");
        System.out.println("  " + "-".repeat(45));
        for (Barang b : databaseBarang.values()) {
            System.out.printf("  %-6s %-15s %-12s %d unit%n",
                b.getIdBarang(), b.getNamaBarang(), b.getKategori(), b.getStok());
        }

        System.out.println("\n RIWAYAT AKTIVITAS TRANSAKSI");
        int urutan = 1;
        for (String riwayat : riwayatAktivitas) {
            System.out.println("  " + urutan + ". " + riwayat);
            urutan++;
        }
    }
}