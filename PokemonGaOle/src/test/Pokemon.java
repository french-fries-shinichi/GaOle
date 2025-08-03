package test1;
public class Pokemon {
    private String name;
    private int starRating;

    public Pokemon(String name, int starRating) {
        this.name = name;
        this.starRating = starRating;
    }

    public String getName() {
        return name;
    }

    public int getStarRating() {
        return starRating;
    }

    @Override
    public String toString() {
        return name + " (★" + starRating + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pokemon)) return false;
        Pokemon p = (Pokemon) o;
        return name.equals(p.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
