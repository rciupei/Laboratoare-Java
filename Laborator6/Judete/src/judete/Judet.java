package judete;

public class Judet {

    private String Nume;
    private int supraf;
    private int locuitori;
    private String capitala;

    public Judet(String Nume, int supraf, int locuitori, String capitala) {
        this.Nume = Nume;
        this.supraf = supraf;
        this.locuitori = locuitori;
        this.capitala = capitala;
    }

    public String getNume() {
        return Nume;
    }

    public int getSupraf() {
        return supraf;
    }

    public int getLocuitori() {
        return locuitori;
    }

    public String getCapitala() {
        return capitala;
    }
}
