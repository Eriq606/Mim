package my.app.pack.classes;

public class User {
    private String nom;
    private String motDePasse;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    public User(String nom, String motDePasse) {
        this.nom = nom;
        this.motDePasse = motDePasse;
    }
    
    
}
