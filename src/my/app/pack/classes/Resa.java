package my.app.pack.classes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Resa {
    private String title;
    private LocalDate date;
    private LocalTime heure;
    private double duree;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getHeure() {
        return heure;
    }
    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }
    public double getDuree() {
        return duree;
    }
    public void setDuree(double duree) {
        this.duree = duree;
    }
    public Resa(String title, LocalDate date, LocalTime heure, double duree) {
        this.title = title;
        this.date = date;
        this.heure = heure;
        this.duree = duree;
    }
    
}
