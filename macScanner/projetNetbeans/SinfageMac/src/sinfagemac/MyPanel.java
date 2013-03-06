/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sinfagemac;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JPanel;

/**
 *
 * @author florianfourure
 */
public class MyPanel extends JPanel{
    
    private HashMap<String,Client> mesClients = new HashMap<>();
    private Dimension myDim;
    
    public MyPanel(){
        this.myDim=this.getSize();
    }
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(Client c : mesClients.values()){
            c.drawMe(g);
        }
    }
    
    public void gererListClient(HashSet<Client> newListe){
        
        HashMap<String,Client> prov = new HashMap<>();
        for(Client c : newListe){
            if(mesClients.containsKey(c.getId())){
                Client c2 = mesClients.get(c.getId());
                c2.setTaille(c.taille);
                prov.put(c.getId(), c2);
            }
        }
        for(Client c : newListe){
            if(!mesClients.containsKey(c.getId())){
                findCoordonee(c,prov);
                prov.put(c.getId(), c);
            }
        }
        this.mesClients=prov;
        repaint();
    }

    private void findCoordonee(Client c, HashMap<String,Client> listeDejaPresent) {
        int nbTentative=0;
        do{
            c.setX((int)(Math.random()*(this.getSize().width-c.getTaille()))); 
            c.setY((int)(Math.random()*(this.getSize().height-c.getTaille())));
            nbTentative++;
        }while(onOtherClient(c,listeDejaPresent) && nbTentative<1000);
    }
    
    private boolean onOtherClient(Client c,HashMap<String,Client> listeDejaPresent){
        for(Client c2 : listeDejaPresent.values()){
            if(c2.seTouche(c)){
                return true;
            }
        }
        return false;
    }
 
    
}
