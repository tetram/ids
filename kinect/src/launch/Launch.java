package launch;

import gesture.GestureDetect;


public class Launch {

	/**
	 * @param args	-b si changement de Bureau
	 */
	public static void main(String[] args) {
		if (args.length>=1 && args[0].equals("-b")) { 
			System.out.println("Detection Droite Gauche + Changement Bureau Haut Bas");
			new GestureDetect(true);
		} else {
			System.out.println("Detection Droite Gauche");
			new GestureDetect(false);
		}
	}

}
