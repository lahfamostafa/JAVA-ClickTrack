package ma.youcode.click.entity;

public class Lien {
    private int id;
    private String offre;
    private String urlDestination;
    private int clicks;
    private Publisher publisher;

    public Lien(String offre, String urlDestination, Publisher publisher) {
        this.offre = offre;
        this.urlDestination = urlDestination;
        this.publisher = publisher;
    }

    public int getId() {return id;}
    public String getOffre() {return offre;}
    public String getUrlDestination() {return urlDestination;}
    public int getClicks() {return clicks;}
    public Publisher getPublisher() {return publisher;}

    public void setId(int id) {this.id = id;}
    public void setOffre(String offre) {this.offre = offre;}
    public void setUrlDestination(String urlDestination) {this.urlDestination = urlDestination;}
    public void setClicks(int clicks) {this.clicks = clicks;}
    public void setPublisher(Publisher publisher) {this.publisher = publisher;}

}
