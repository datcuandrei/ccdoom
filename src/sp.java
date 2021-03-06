/*
    CCDOOM - A cross-compatible DOOM launcher. 
    Copyright (C) 2021 Andrei Datcu.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
 
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.IOException; 
import java.util.*;
import java.lang.ProcessBuilder;

public class sp{
	public static ccdoom ccdoom = new ccdoom(); // importing the main class to get info
	public static String[] availableSourcePorts = {"Zandronum","ZDoom","GZDoom","Crispy Doom","Chocolate Doom"}; // array that contains all sourceports that ccdoom supports.
	
	/*
	 * method that starts the selected source port
	 */
	public static void runDoom(boolean multiplayer, String ipAddress){
		/*
	 	* strings that contain the required
	 	* commands to launch sourceports
		*/

		// getting the selected sourceport, iwad and pwads
		String getSP = String.valueOf(ccdoom.installedSourcePorts.getSelectedItem());
		String getIWAD = "\""+(String) ccdoom.IWADS.getSelectedValue()+"\"";	
		String getPWADs = Arrays.toString(ccdoom.pwadsList.toArray()).substring(1,Arrays.toString(ccdoom.pwadsList.toArray()).length()-1).replaceAll(",","").replaceAll(" ", "\\ ");
		// getting the additional command line arguments
		String clis = ccdoom.addcli.getText();
		// command to run doom
		String doomCMD;
		if(!multiplayer){
			doomCMD = getSP.toLowerCase().replace(" ","-") +" -iwad " + getIWAD+" -file " +getPWADs+" "+clis;
		}else{
			doomCMD = "zandronum -iwad " + getIWAD+" -file " +getPWADs+" -connect "+ipAddress+" "+clis;	
		}
		try{
			System.out.println(doomCMD);
			ProcessBuilder doom;
			// determing which os is running, so we can launch the source port accordingly.
			if(System.getProperty("os.name").toLowerCase().contains("windows")){
				doom = new ProcessBuilder("cmd","/K",doomCMD);
			}else{
				doom = new ProcessBuilder("/bin/bash","-c",doomCMD);
			}
			doom.start(); // starts doom
		}catch(IOException e){
			JOptionPane.showMessageDialog(null,getSP + " couldn't start. Please report this error to @datcuandrei on GitHub : " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
		}	
	}

}
