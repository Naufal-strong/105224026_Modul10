public class Main {
    public static void main(String[] args) {
        SistemGudang gudang = new SistemGudang();

        System.out.println(" SIMULASI SISTEM MANAJEMEN GUDANG \n");
        gudang.tambahBarangBaru("G505", "HandPhone",   "Elektronik",  8);
        gudang.tambahBarangBaru("G122", "LemariBaju",    "Furnitur",   12);
        gudang.tambahBarangBaru("G696", "Laptop",  "Elektronik", 20);

        System.out.println();
        gudang.tambahStok("G505", 7);  

        System.out.println();
        gudang.kurangiStok("G696", 5);  

        System.out.println();
        gudang.kurangiStok("G122", 50); 

        gudang.cetakLaporan();
    }
}