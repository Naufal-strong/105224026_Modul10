import java.util.Objects;

class Anggota {

    String idAnggota;
    String nama;
    String tipe;

    public Anggota(String idAnggota, String nama, String tipe) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.tipe = tipe;
    }

    // Override equals()
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Anggota anggota = (Anggota) obj;

        return Objects.equals(idAnggota, anggota.idAnggota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnggota);
    }

    public void tampilkanInfo() {
        System.out.println(idAnggota + " - " + nama + " (" + tipe + ")");
    }
}