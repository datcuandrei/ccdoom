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
import java.util.Properties;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class profiles{
	public static ccdoom mainClass = new ccdoom(); // importing the main class to access gui elements.
	public static conf config = new conf(); // to get access to configuration methods
	
	public static String profilesPath = System.getProperty("user.home") + File.separator + "ccdoom" + File.separator + "profiles"; // path to the profiles folder
	
	/*
	 * the method responsible for saving
	 * profiles
	 */
	public static void saveProfile(String profileName){
		/*
		 * when saving a profile, the first thing ccdoom
		 * does is to check if the config folder exists.
		 * If not, it creates it.
		 */
		String configFolderPath = System.getProperty("user.home") + File.separator + "ccdoom" + File.separator + "profiles"; // path to the config folder and profiles folder
		File configFolder = new File(configFolderPath);
		if(!configFolder.exists()){
			configFolder.mkdirs();
		}
		String profileDir = profilesPath + File.separator + profileName;
		File createDir = new File(profileDir);
		createDir.mkdir();
		File iwadsF = new File(profileDir + File.separator + "iwads.txt"); // contains all iwads added
		File pwadsF = new File(profileDir + File.separator + "pwads.txt"); // contains all pwads added.
		File spF = new File(profileDir + File.separator + "sp.txt"); // contains all sourceports added.
		File argF = new File(profileDir + File.separator + "arg.txt"); // contains the additional arguments

		// creating the files
		try{
			iwadsF.createNewFile();
			pwadsF.createNewFile();
			spF.createNewFile();
			argF.createNewFile();
		}catch(IOException e){
			JOptionPane.showMessageDialog(null,"Couldn't write files. Please report this error to @datcuandrei on GitHub : " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
		}

		// writing the files
		try{
			config.writeFile(spF.getAbsolutePath(), "sp"); // creates the sp.txt file with all the sourceports found inside mainClass.installedSourcePorts
			config.writeFile(iwadsF.getAbsolutePath(), "iwad"); // creates the iwads.txt file with all the iwads found inside mainClass.iwadsList
			config.writeFile(pwadsF.getAbsolutePath(), "pwad"); // creates the pwads.txt file with all the iwads found inside mainClass.pwadsList
			config.writeFile(argF.getAbsolutePath(), "arg"); // creates the arg.txt file with the additional arguments found in mainClass.addcli
		}catch(IOException e){
			JOptionPane.showMessageDialog(null,"Couldn't write files. Please report this error to @datcuandrei on GitHub : " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
		}
	}
	 
	/*
	 * method that is responsible for
	 * opening the profile
	 */
	public static void openProfile(String profileName){
		String profileDir = profilesPath + File.separator + profileName;

		// first clearing the gui elements
		mainClass.installedSourcePorts.removeAllItems();
		mainClass.iwadsList.removeAllElements();
		mainClass.pwadsList.removeAllElements();
		mainClass.addcli.setText("");

		// updating the gui
		SwingUtilities.updateComponentTreeUI(mainClass.installedSourcePorts);
		SwingUtilities.updateComponentTreeUI(mainClass.IWADS);
		SwingUtilities.updateComponentTreeUI(mainClass.PWADS);
		SwingUtilities.updateComponentTreeUI(mainClass.addcli);

		// finally, reading the files
		try{
			config.readFile(profileDir + File.separator + "sp.txt", "sp"); // reading the sourceports file
			config.readFile(profileDir + File.separator + "iwads.txt", "iwad"); // reading the iwads file
			config.readFile(profileDir + File.separator + "pwads.txt", "pwad"); // reading the pwads file
			config.readFile(profileDir + File.separator + "arg.txt", "arg"); // reading the arguments file
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null,"Couldn't read files. Please report this error to @datcuandrei on GitHub : " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
		}catch(IOException e){
			JOptionPane.showMessageDialog(null,"Couldn't read files. Please report this error to @datcuandrei on GitHub : " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
		}
	}

	/*
	 * method responsible for deleting
	 * the desired profile.
	 */
	public static void deleteProfile(String profileName){
		/*
		 * in order to delete a whole folder,
		 * we first need to delete it's contents
		 * and then finally, delete the folder.
		 * 
		 * that's the way java works.
		 */
		File profileDir = new File(profilesPath + File.separator + profileName);
		File[] profileFiles = profileDir.listFiles(); // array that contains the paths to all files inside
		// iterating through each file and deleting it.
		for(int i=0; i < profileFiles.length; i++){
			File toDel = new File(profileFiles[i].getPath());
			toDel.delete();
		}
		// finally deleting the folder itself
		profileDir.delete();
	}
	/*
	 * the method that overwrites a saved 
	 * profile
	 */
	 public static void overwriteProfile(String profileName){
	 	// first we delete that profile and recreate it.
		deleteProfile(profileName);
		saveProfile(profileName); 	
	 }

	 /*
	  * GUI ELEMENTS START HERE
	  */
	  public static Action saveProfileAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e){
				// input box from which we get the profile name
				Object profileName = JOptionPane.showInputDialog(null,"Enter the name you want for your profile :","Create profile",JOptionPane.PLAIN_MESSAGE,null,null,null);
				saveProfile(String.valueOf(profileName));
			}
		};
	  public static Action openProfileAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e){
				// getting only the directories
				String[] profiles = new File(profilesPath).list(new FilenameFilter() {
  					@Override
  					public boolean accept(File current, String name) {
    						return new File(current, name).isDirectory();
  					}
				});
				Object profileName = JOptionPane.showInputDialog(null,"Choose a profile :","Open profile",JOptionPane.PLAIN_MESSAGE,null,profiles,null);
				openProfile(String.valueOf(profileName));
			}
		};

	  public static Action overwriteProfileAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e){
				// getting only the directories
				String[] profiles = new File(profilesPath).list(new FilenameFilter() {
  					@Override
  					public boolean accept(File current, String name) {
    						return new File(current, name).isDirectory();
  					}
				});
				Object profileName = JOptionPane.showInputDialog(null,"Choose a profile :","Update profile",JOptionPane.PLAIN_MESSAGE,null,profiles,null);
				overwriteProfile(String.valueOf(profileName));
			}
		};

	public static Action deleteProfileAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e){
				// getting only the directories
				String[] profiles = new File(profilesPath).list(new FilenameFilter() {
  					@Override
  					public boolean accept(File current, String name) {
    						return new File(current, name).isDirectory();
  					}
				});
				Object profileName = JOptionPane.showInputDialog(null,"Choose a profile :","Delete profile",JOptionPane.PLAIN_MESSAGE,null,profiles,null);
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this profile?","Delete profile",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					deleteProfile(String.valueOf(profileName));
				}
			}
		};
}
