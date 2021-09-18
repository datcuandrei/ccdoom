import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Properties;
import java.util.Enumeration;

public class conf{
	public static ccdoom mainClass = new ccdoom(); // importing the main class to access gui elements.

	/*
	 * method that writes files
	 */
	public static void writeFile(String filePath, String fileType) throws IOException{
			File newFile = new File(filePath);// creating a new file
			// the following is easy to understand
			// this method will only be for iwads and pwads, as no other files will be used with it.
			if(fileType.equals("iwad")){
				for (int i=0; i < mainClass.iwadsList.getSize(); i++){
						FileWriter writer = new FileWriter(newFile, true); // opening a new writer
						writer.write(mainClass.iwadsList.getElementAt(i) + "\n");
						writer.close();
					}	
			}else if(fileType.equals("pwad")){
				for (int i=0; i < mainClass.pwadsList.getSize(); i++){
						FileWriter writer = new FileWriter(newFile, true); // opening a new writer
						writer.write(mainClass.pwadsList.getElementAt(i) + "\n");
						writer.close();
					}
			}else if(fileType.equals("sp")){
				for (int i=0; i < mainClass.installedSourcePorts.getItemCount(); i++){
						FileWriter writer = new FileWriter(newFile, true); // opening a new writer
						writer.write(mainClass.installedSourcePorts.getItemAt(i) + "\n");
						writer.close();
					}	
			}
		}

	/*
	 * method that reads files and adds
	 * them to the according list.
	 */
	public static void readFile(String filePath, String fileType) throws FileNotFoundException, IOException{
			File fileToRead = new File(filePath); // declaring said file
			FileReader reader = new FileReader(fileToRead); // opening a reader
			BufferedReader buffer = new BufferedReader(reader); // passing the data read in a buffer
			String line;
			while ((line = buffer.readLine())!=null){
				// this method will only be for iwads and pwads, as no other files will be used with it.
               	if(fileType.equals("iwad")){
               		mainClass.iwadsList.addElement(line);
               	}else if(fileType.equals("pwad")){
               		mainClass.pwadsList.addElement(line);
               	}else if(fileType.equals("sp")){
               		mainClass.installedSourcePorts.addItem(line);
               	}
               }
		}
}
	//
