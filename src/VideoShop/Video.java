package VideoShop;

/**
 * Created by francis on 2017-02-14.
 */
public class Video {
    enum VideoType {MOVIE, SPORTS, DOCUMENTARY}

    ;

    public VideoType type;
    public String title;
    public int priceOfRental;
    public int salesOfRental;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Video video = (Video) o;

        if (priceOfRental != video.priceOfRental) return false;
        if (salesOfRental != video.salesOfRental) return false;
        if (type != video.type) return false;
        return title.equals(video.title);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + priceOfRental;
        result = 31 * result + salesOfRental;
        return result;
    }
}
