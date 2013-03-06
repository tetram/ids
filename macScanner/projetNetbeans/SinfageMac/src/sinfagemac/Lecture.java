/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sinfagemac;

import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author florianfourure
 */
public class Lecture extends Thread{

    private SnifageMac sm;
    
    public Lecture(SnifageMac sm){
        this.sm=sm;
    }
    @Override
    public void run() {
                Scanner lecture2=new Scanner(System.in); 
                
                while(true){  
                    String line = lecture2.nextLine();
                    if(line.equals("start")){
                        HashSet<Client> listeClientTest = new HashSet<>();
                        while(true){
                            line = lecture2.nextLine();
                            if(!line.equals("end")){
                                listeClientTest.add(getClient(line));
                            }else{
                                break;
                            }
                        }
                        sm.newListe(listeClientTest);
                    }
                }
    }
 
        
    public Client getClient(String s){
        String[] tab = s.split(";");
        return new Client(tab[0], Integer.parseInt(tab[1].trim()));
    }
}
