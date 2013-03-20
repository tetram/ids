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
    public int taille;
    private int x;
    private int y;
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
        if(taille==0)
            return 50;
        else
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
        if(taille==0)
            return Color.red;
        else
            return Color.BLUE;
    }
    
    
    public void drawMe(Graphics g){
        int tailleLettre = 9;
        int nbLettre = this.affichage.length();
        int retraitX = (nbLettre*tailleLettre)/2;
        Color prov = g.getColor();
        g.setColor(this.getColor());
        g.fillOval(x, y, getTaille(), getTaille());
        g.setColor(Color.black);
        g.drawOval(x, y, getTaille(), getTaille());
        g.drawString(this.affichage, (x-retraitX)+(getTaille()/2), (y+(tailleLettre/2))+(getTaille()/2));
        g.setColor(prov);
    }
    
    public boolean seTouche(Client c){
        if(((this.x<=c.getX() && (this.x+this.getTaille())>=c.getX()) || 
            (this.x<=(c.getX()+c.getTaille()) && (this.x+this.getTaille())>=(c.getX()+c.getTaille())) ||
            (this.x>=c.getX() && (this.x+this.getTaille())<=(c.getX()+c.getTaille()))) &&  
           ((this.y<=c.getY() && (this.y+this.getTaille())>=c.getY()) || 
            (this.y<=(c.getY()+c.getTaille()) && (this.y+this.getTaille())>=(c.getY()+c.getTaille())) ||
            (this.y>=c.getY() && (this.y+this.getTaille())<=(c.getY()+c.getTaille())))){
            return true;
        }else{
            return false;
        }
    }
    
}
