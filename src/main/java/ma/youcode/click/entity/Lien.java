package ma.youcode.click.entity;

public class Lien {
    private int id;
    private String offre;
    private String urlDestination;
    private int clicks;
    private Publisher publisherId;

    public int getId() {return id;}
    public String getOffre() {return offre;}
    public String getUrlDestination() {return urlDestination;}
    public int getClicks() {return clicks;}
    public Publisher getPublisherId() {return publisherId;}

    public void setId(int id) {this.id = id;}
    public void setOffre(String offre) {this.offre = offre;}
    public void setUrlDestination(String urlDestination) {this.urlDestination = urlDestination;}
    public void setClicks(int clicks) {this.clicks = clicks;}
    public void setPublisherId(Publisher publisherId) {this.publisherId = publisherId;}

}
