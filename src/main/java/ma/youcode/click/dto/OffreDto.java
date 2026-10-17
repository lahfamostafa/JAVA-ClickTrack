package ma.youcode.click.dto;

public class OffreDto {
    private String offre;
    private Long nombreLiens;
    private int clicks;
    
    public OffreDto(String offre, Long nombreLiens, int clicks) {
        this.offre = offre;
        this.nombreLiens = nombreLiens;
        this.clicks = clicks;
    }

    public String getOffre() {return offre;}

    public void setOffre(String offre) {this.offre = offre;}

    public Long getNombreLiens() {return nombreLiens;}

    public void setNombreLiens(Long nombreLiens) {this.nombreLiens = nombreLiens;}

    public int getClicks() {return clicks;}

    public void setClicks(int clicks) {this.clicks = clicks;}
}
