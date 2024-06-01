public class Pesanan {
    private final Film film;
    private int kuantitas;

    public Pesanan(Film film, int kuantitas) {
        this.film = film;
        this.kuantitas = kuantitas;
    }

    public Film getFilm() {
        return film;
    }

    public int getKuantitas() {
        return kuantitas;
    }
    public double getTotalHarga() {
        return film.getPrice() * kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }
}
