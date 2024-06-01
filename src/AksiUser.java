import java.util.Map;
import java.util.Scanner;

public class AksiUser extends Aksi {
    @Override
    public void tampilanAksi() {
        System.out.println("Aksi User:");
        System.out.println("1. Pesan Film");
        System.out.println("2. Lihat Saldo");
        System.out.println("3. Lihat List Film");
        System.out.println("4. Lihat Pesanan");
        System.out.println("5. Logout");
        System.out.println("6. Tutup Aplikasi");
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

    public void lihatSaldo() {
        double saldo = User.getSaldo(); // Asumsi method getSaldo() ada di class Akun
        System.out.println("Saldo anda: " + saldo);
    }

    public void pesanFilm() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama Film yang ingin dipesan: ");
        String namaFilm = scanner.nextLine();

        Map<String, Film> films = Film.getFilms();
        if (!films.containsKey(namaFilm)) {
            System.out.println("Film yang dicari tidak ditemukan.");
            return;
        }

        Film film = films.get(namaFilm);

        System.out.print("Jumlah tiket yang ingin dipesan: ");
        int jumlahTiket = scanner.nextInt();

        if (jumlahTiket > film.getStock()) {
            System.out.println("Stok tiket tidak mencukupi.");
            return;
        }

        double totalHarga = jumlahTiket * film.getPrice();
        double saldo = User.getSaldo();

        if (totalHarga > saldo) {
            System.out.println("Saldo tidak mencukupi, saldo yang dimiliki " + saldo + ".");
            return;
        }

        // Update saldo dan stok
        User.setSaldo(saldo - totalHarga);
        film.setStock(film.getStock() - jumlahTiket);

        // Tambahkan pesanan ke daftar pesanan user
        User.addPesanan(film, jumlahTiket);

        System.out.println("Harga satuan tiket " + film.getPrice());
        System.out.println("Total harga " + totalHarga);
        System.out.println("Tiket berhasil dipesan.");
    }
    public void lihatPesanan(User user) {
        Map<String, Pesanan> pesananList = user.getPesanan();
        if (pesananList.isEmpty()) {
            System.out.println("Kamu belum pernah melakukan pemesanan.");
        } else {
            for (Pesanan pesanan : pesananList.values()) {
                System.out.println("Film: " + pesanan.getFilm().getName() + " - Jumlah: " + pesanan.getKuantitas() + " - Total Harga: " + pesanan.getTotalHarga());
            }
        }
    }
}
