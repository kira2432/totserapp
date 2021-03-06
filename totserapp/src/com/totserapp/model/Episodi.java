package com.totserapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Episodi {
    private ArrayList<Valoracio> valoracions = new ArrayList<>();
    
    private String title, idioma, description, data, duration, numTemporada, serie;
    int numEpisodi, visualitzacions;

    public Episodi(String title, String idioma, String description, String data, String duration, String numTemporada, int numEpisodi, String serie) {
        this.title = title;
        this.idioma = idioma;
        this.description = description;
        this.data = data;
        this.duration = duration;
        this.numTemporada = numTemporada;
        this.numEpisodi = numEpisodi;
        this.serie = serie;
        
        Random random = new Random();
        
        int num = random.nextInt(100) + 1;
        
        for(int i = 0; i < num; i++){
            int valor = random.nextInt(6) + 1;
            valoracions.add(new Valoracio(valor, null));
        }
        
        visualitzacions = random.nextInt(10000) + 1000;
    }
    
    public String toShortString(){
        String episodi = numEpisodi < 10 ? "0" + numEpisodi : "" + numEpisodi;
        String out = "";
        out += "(" + numTemporada + "x" + episodi + ") " + title;
        return out;
    }
    
    
    
    @Override
    public String toString(){
//        System.out.println("\nTitol: " + title);
//        System.out.println("--------------------------------------------------");
//        System.out.println("Duració; " + duration);
//        System.out.println("Data d'estrena: " + data);
//        System.out.println("Idioma: " + idioma);
//        System.out.println(description);
        return "Episodi";
    }
    
    public void valorar(Usuari usuari, int valor){
        valoracions.add(new Valoracio(valor, null));
    }
    
    public int getMitjanaValoracions(){
        int sum = 0;
        for(int i = 0; i < valoracions.size(); i++){
            sum += valoracions.get(i).getValor();
        }
        return sum / valoracions.size();
    }

    public ArrayList<Valoracio> getValoracions() {
        return valoracions;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumTemporada() {
        return numTemporada;
    }

    public int getVisualitzacions() {
        return visualitzacions;
    }

    public void setVisualitzacions(int visualitzacions) {
        this.visualitzacions = visualitzacions;
    }
    
    public void addVisualitzacions() {
        visualitzacions += 1;
    }
    
    
}
