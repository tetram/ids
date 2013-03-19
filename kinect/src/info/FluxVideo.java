package info;

import javax.swing.JFrame;

import org.OpenNI.Samples.SimpleRead.SimpleRead;

import com.sun.tools.javac.util.Context;

public class FluxVideo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Context contexte;
	
	public FluxVideo(Context contexte) {
		this.contexte=contexte;
		new SimpleRead();
	}
	
	

}
