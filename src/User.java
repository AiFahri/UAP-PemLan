import java.util.HashMap;
import java.util.Map;

public class User {
    private static final Map<String, User> users = new HashMap<>();
    private final String username;
    private final String password;
    private final boolean isAdmin;
    private static double saldo;
    private final static Map<String, Pesanan> pesanan = new HashMap<>();

    public User(String username, String password, boolean isAdmin, double saldo) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        User.saldo = saldo;
    }
    public static void setSaldo(double newSaldo) {
        User.saldo = newSaldo;
    }

    public static double getSaldo() {
        return User.saldo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public static void addUser(String username, String password, boolean isAdmin, double saldo) {
        if (!users.containsKey(username)) {
            User newUser = new User(username, password, isAdmin, saldo);
            users.put(username, newUser);
        }
    }

    public static Map<String, User> getUsers() {
        return users;
    }

    public static void addPesanan(Film film, int kuantitas) {
        if (pesanan.containsKey(film.getName())) {
            Pesanan existingPesanan = pesanan.get(film.getName());
            existingPesanan.setKuantitas(existingPesanan.getKuantitas() + kuantitas);
        } else {
            Pesanan newPesanan = new Pesanan(film, kuantitas);
            pesanan.put(film.getName(), newPesanan);
        }
    }

    public Map<String, Pesanan> getPesanan() {
        return pesanan;
    }
}

