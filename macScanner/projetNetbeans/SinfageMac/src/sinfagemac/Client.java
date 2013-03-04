/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sinfagemac;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author florianfourure
 */
public class Client {
    public static int tailleMax = 100;
    
    private String id;
    private String affichage;
    private int taille;
    private int x;
    private int y;
    private Color[] couleurs = {Color.WHITE,Color.BLUE,Color.GREEN,Color.YELLOW,Color.RED};
    public Client(String id,String affichage,int taille){
        this.id=id;
        this.affichage=affichage;
        if(taille>tailleMax){
            this.taille=tailleMax;
        }else{
            this.taille=taille;
        }
    }
    public Client(String id,int taille){
        this.id=id;
        this.affichage=id;
        if(taille>tailleMax){
            this.taille=tailleMax;
        }else{
            this.taille=taille;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAffichage() {
        return affichage;
    }

    public void setAffichage(String affichage) {
        this.affichage = affichage;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        if(taille>tailleMax){
            this.taille=tailleMax;
        }else{
            this.taille = taille;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public Color getColor(){
        return couleurs[(int)getTaille()/((tailleMax+20)/5)];
    }
    public void drawMe(Graphics g){
        int tailleLettre = 9;
        int nbLettre = this.affichage.length();
        int retraitX = (nbLettre*tailleLettre)/2;
        Color prov = g.getColor();
        g.setColor(getColor());
        g.fillOval(x, y, taille, taille);
        g.setColor(Color.black);
        g.drawOval(x, y, taille, taille);
        g.drawString(this.affichage, (x-retraitX)+(taille/2), (y+(tailleLettre/2))+(taille/2));
        g.setColor(prov);
    }
    
    public boolean seTouche(Client c){
        if(((this.x<=c.getX() && (this.x+this.taille)>=c.getX()) || 
            (this.x<=(c.getX()+c.getTaille()) && (this.x+this.taille)>=(c.getX()+c.getTaille())) ||
            (this.x>=c.getX() && (this.x+this.taille)<=(c.getX()+c.getTaille()))) &&  
           ((this.y<=c.getY() && (this.y+this.taille)>=c.getY()) || 
            (this.y<=(c.getY()+c.getTaille()) && (this.y+this.taille)>=(c.getY()+c.getTaille())) ||
            (this.y>=c.getY() && (this.y+this.taille)<=(c.getY()+c.getTaille())))){
            return true;
        }else{
            return false;
        }
    }
    
}
