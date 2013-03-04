/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sinfagemac;

import java.util.HashSet;

/**
 *
 * @author florianfourure
 */
public class SnifageMac implements Runnable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SnifageMac();
    }
    
    public SnifageMac(){
        java.awt.EventQueue.invokeLater(this);
    }

    @Override
    public void run() {
                MyFrame mf = new MyFrame();
                mf.setVisible(true);
                
                //Test ^^
                HashSet<Client> listeClientTest = new HashSet<>();
                for(int i=1;i<=5;i++){
                    listeClientTest.add(new Client("TOTO "+i, 20*i));
                    mf.getMyPanel().gererListClient(listeClientTest);
                }
    }
}
