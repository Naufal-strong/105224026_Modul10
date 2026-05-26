import java.util.*;
import java.util.HashMap;
import java.util.Map;

class Buku {

    String isbn;
    String judul;

    public Buku(String isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
    }

    public void tampilkanInfo() {
        System.out.println(isbn + " - " + judul);
    }
}