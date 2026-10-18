package ma.youcode.click.dto;

public class ClickDto{
    private int id;
    private String urlDestination;
    private Long cliks;
    private String publisher;
    private String urlGenere;
    
    public ClickDto(int id, String urlDestination, Long cliks, String publisher, String urlGenere) {
        this.id = id;
        this.urlDestination = urlDestination;
        this.cliks = cliks;
        this.publisher = publisher;
        this.urlGenere = urlGenere;
    }

    public int getId() {return id;}
    public String getUrlDestination() {return urlDestination;}
    public Long getCliks() {return cliks;}
    public String getPublisher() {return publisher;}
    public String getUrlGenere() {return urlGenere;}

}