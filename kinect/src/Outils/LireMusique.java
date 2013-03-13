/**
 * 
 */
package Outils;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 * @author Sim
 *
 */
public class LireMusique {
	
	private static final int	EXTERNAL_BUFFER_SIZE = 128000;
	
	
	private boolean _stop = false;
	
	/**
	 * Constructeur
	 * @param chemin
	 */
	public LireMusique(String chemin) {

		
		//on construit le fichier son
		String	strFilename = chemin;
		File	soundFile = new File(strFilename);	
		
		AudioInputStream	audioInputStream = null;
		
		try {
			//on recupere le flux audio du fichier
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e) { e.printStackTrace(); System.exit(1);}
		
		//on recupere le format du son
		AudioFormat	audioFormat = audioInputStream.getFormat();
		
		//on déclare le "pointeur" qui va suivre le fichier audio
		SourceDataLine	line = null;
		
		//on recupere les informations du fichier (format)
		DataLine.Info	info = new DataLine.Info(SourceDataLine.class, audioFormat);
		
		int	nBytesRead;
		byte[]	abData;
		
		line = null;
		nBytesRead = 0;
		abData = new byte[EXTERNAL_BUFFER_SIZE];
		
		try {
			//on initialise le pointeur au debut du son
			line = (SourceDataLine) AudioSystem.getLine(info);
			//on specifie au pointeur le format lu
			line.open(audioFormat);
		} catch (LineUnavailableException e) { e.printStackTrace(); System.exit(1);	} 
		catch (Exception e)	{ e.printStackTrace();	System.exit(1);	}
		
		//on commence a lire le flux
		line.start();
	


		while (nBytesRead != -1) {
			try {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
			}
			catch (IOException e){e.printStackTrace();}
			
			if (nBytesRead >= 0) {
				@SuppressWarnings("unused")
				int	nBytesWritten = line.write(abData, 0, nBytesRead);
			}//fin si 
		}//finpour

	
		line.drain();
		
		line.close();

		
		
	}//fin Constructeur
		
	@SuppressWarnings("unused")
	private static void printUsageAndExit()
	{
		out("SimpleAudioPlayer: usage:");
		out("\tjava SimpleAudioPlayer <soundfile>");
		System.exit(1);
	}


	private static void out(String strMessage)
	{
		System.out.println(strMessage);
	}
		
	/**
	 * Destructeur.
	 */
	public void finalize() {
		try {
			super.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//fin descructeur

	/**
	 * @param _stop the _stop to set
	 */
	public void setStop(boolean _stop) {
		this._stop = _stop;
	}

	/**
	 * @return the _stop
	 */
	public boolean estStop() {
		return _stop;
	}

}//fin LireMusique
