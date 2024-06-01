import java.util.Map;
import java.util.Scanner;

public class AksiAdmin extends Aksi {
    @Override
    public void tampilanAksi() {
        System.out.println("Aksi Admin:");
        System.out.println("1. Tambah Film");
        System.out.println("2. Lihat List Film");
        System.out.println("3. Logout");
        System.out.println("4. Tutup Aplikasi");
    }

    @Override
    public void keluar() {
        Akun.logout();
        System.out.println("Anda telah logout.");
    }

    @Override
    public void tutupAplikasi() {
        System.out.println("Aplikasi ditutup.");
        System.exit(0);
    }

    @Override
    public void lihatListFilm() {
        
        Map<String, Film> films = Film.getFilms();
        for (Film film : films.values()) {
            System.out.println(film.getName() + " - " + film.getDescription() + " - Harga: " + film.getPrice() + " - Stok: " + film.getStock());
        }
    }

    public void tambahFilm() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama Film: ");
        String namaFilm = scanner.nextLine();

        System.out.print("Deskripsi Film: ");
        String deskripsiFilm = scanner.nextLine();

        System.out.print("Harga Tiket: ");
        double hargaTiket = scanner.nextDouble();

        System.out.print("Stok Tiket: ");
        int stokTiket = scanner.nextInt();

        Map<String, Film> films = Film.getFilms();
        if (films.containsKey(namaFilm)) {
            System.out.println("Film " + namaFilm + " sudah ada.");
        } else {
            Film.addFilm(namaFilm, deskripsiFilm, hargaTiket, stokTiket);
            System.out.println("Film " + namaFilm + " berhasil ditambahkan.");
        }
    }
}
