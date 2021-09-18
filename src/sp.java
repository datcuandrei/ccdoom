import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.IOException; 
import java.util.*;
import java.lang.ProcessBuilder;

public class sp{
	public static ccdoom ccdoom = new ccdoom(); // importing the main class to get info
	public static String[] availableSourcePorts = {"Zandronum","ZDoom","GZDoom","CrispyDoom","ChocolateDoom"}; // array that contains all sourceports that ccdoom supports.
	
	/*
	 * method that starts the selected source port
	 */
	public static void runDoom(){
		/*
	 	* strings that contain the required
	 	* commands to launch sourceports
		*/

		// getting the selected iwad and pwads
		String getIWAD = "\""+(String) ccdoom.IWADS.getSelectedValue()+"\"";	
		String getPWADs = Arrays.toString(ccdoom.pwadsList.toArray()).substring(1,Arrays.toString(ccdoom.pwadsList.toArray()).length()-1).replaceAll(",","").replaceAll(" ", "\\ ");
		// getting the additional command line arguments
		String clis = ccdoom.addcli.getText();
		String zandronum = "command" + ccdoom.iwadsList.toArray() + ccdoom.pwadsList.toArray();
		String zdoom = "zdoom -iwad " + getIWAD + " -file " +getPWADs+" "+clis;
		String gzdoom = "gzdoom -iwad " + getIWAD + " -file " +getPWADs+" "+clis;
		String crispydoom = "crispy-doom -iwad " + getIWAD+" "+clis;
		String chocodoom = "chocolate-doom -iwad " + getIWAD+" "+clis;
	
		// determing which source port the user wants to launch.
		String selectedSP = String.valueOf(ccdoom.installedSourcePorts.getSelectedItem());
		String spToUse = null;
		
		switch(selectedSP){
			case "ZDoom" -> spToUse = zdoom;
			case "GZDoom" -> spToUse = gzdoom;
			case "CrispyDoom" -> spToUse = crispydoom;
			case "ChocolateDoom" -> spToUse = chocodoom;
			case "Zandronum" -> spToUse = zandronum;
		}
		// determing which os is running, so we can launch the source port accordingly.
		if(System.getProperty("os.name").toLowerCase().contains("windows")){
			try{
				String processToRun = spToUse;
				System.out.println(spToUse);
				ProcessBuilder doom = new ProcessBuilder("cmd","/K",spToUse);
				doom.start();
			}catch(IOException e){
				JOptionPane.showMessageDialog(null,selectedSP + " couldn't start. Please report this error to @datcuandrei on GitHub : " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
			}
		}else{
			try{
				String processToRun = spToUse;
				System.out.println(spToUse);
				ProcessBuilder doom = new ProcessBuilder("/bin/bash","-c",spToUse);
				doom.start();
			}catch(IOException e){
				JOptionPane.showMessageDialog(null,selectedSP + " couldn't start. Please report this error to @datcuandrei on GitHub : " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
			}	
		}	
	}

}
