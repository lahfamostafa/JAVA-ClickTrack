package ma.youcode.click.model;

public class Publisher {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private Categorie categorie;

    public int getId() {return id;}
    public String getNom() {return nom;}
    public String getPrenom() {return prenom;}
    public String getEmail() {return email;}
    public Categorie getCategorie() {return categorie;}

    public void setId(int id) {this.id = id;}
    public void setNom(String nom) {this.nom = nom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public void setEmail(String email) {this.email = email;}
    public void setCategorie(Categorie categorie) {this.categorie = categorie;}
}
