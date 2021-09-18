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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class help{
	/*
	 * method that opens links
	 */ 
	public static void openLink(String url){
        URI page = null;
        try {
            page = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            Desktop.getDesktop().browse(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static Action getStartedAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e){
			JFrame gettingStarted = new JFrame("Get started");
			gettingStarted.setLocationRelativeTo(null);
			gettingStarted.setLayout(new FlowLayout(FlowLayout.CENTER));
			gettingStarted.setSize(new Dimension(810,540));

			JTextPane title = new JTextPane();
       		title.setContentType("text/html");
        		title.setText("<html><head></head><body><div align=\"center\"><h1>Getting started</h1><h2>A few tips that will get you up and running in no time.</h2></div></body></html>");
        		title.setEditable(false);
        
			// using html to create the gettingStarted section.
			JTextPane gettingStartedSection = new JTextPane();
			gettingStartedSection.setContentType("text/html");
			gettingStartedSection.setText("<html><head></head><body><div align=\"center\"><p>• Please note that these instructions apply only to the version you are currently running.<br>The instructions will change with the final release, because ccdoom will function a bit different.</p><p>• To add source port, go to 'Options &gt; Add source port' and select one of the source ports available.<br>VERY IMPORTANT: Make sure that the source port you are choosing is added to your PATH variable.<br> If you do not know how to add a program to your PATH variable, see the link at the end of the instructions.</p><p>• To manage your added IWADS and mods, simply use the options available in the 'Options' menu.<br>They are pretty self explanatory.</p><p>• To manage your profiles, use the 'Profiles' menu in your top bar.<br>The profiles you created are stored in your user home directory, in a folder named 'ccdoom'.<br>Each profile has it's own folder that contains text files with the information your provided.</p><p>• If you encounter any issues, please go to 'Help &gt; Report issue' and write a detailed description of what is happening.</p><p>• If you want to check for updates, go to 'Help &gt; Updates'.</p><p>How to add a source port to your PATH variable: </p></div></body></html>");
			gettingStartedSection.setEditable(false);

			JButton tutorialPage = new JButton("See tutorial");
			tutorialPage.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent actionEvent){
					openLink("https://github.com/datcuandrei/ccdoom/blob/main/instructions/path_tutorial.md");	
				}
			});


			gettingStarted.add(title);
			gettingStarted.add(gettingStartedSection);
			gettingStarted.add(tutorialPage);
			
			gettingStarted.setVisible(true);
		}	
	};
	
	/*
	 * method that shows the about section of the program
	 */ 
	public static Action aboutAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e){
			JFrame about = new JFrame("About");
			about.setLocationRelativeTo(null);
			about.setLayout(new FlowLayout(FlowLayout.CENTER));
			about.setSize(new Dimension(470,500));

			// using html to create the about section.
			JTextPane aboutSection = new JTextPane();
			aboutSection.setContentType("text/html");
			aboutSection.setText("<html><head></head><body><div align=\"center\"><img src=\"https://raw.githubusercontent.com/datcuandrei/ccdoom/main/img/about.png\" /><br><h1>ccdoom</h1><h2>Technical Preview (0.3)</h2><br><p>A cross-compatible DOOM launcher.</p><br><p>© 2021 Andrei Datcu</p><br><p>This program comes with absolutely no warranty.<br>See the GNU General Public License, version 3 or later for details.</p></div></body></html>");
			aboutSection.setEditable(false);

			JButton authorPage = new JButton("See author's page");
			authorPage.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent actionEvent){
					openLink("https://datcuandrei.github.io/");	
				}
			});

			about.add(aboutSection);
			about.add(authorPage);

			about.setVisible(true);
		}	
	};
	/*
	 * these are pretty self explanatory
	 */
	public static Action updatesAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e){
			openLink("https://github.com/datcuandrei/ccdoom/releases");
		}	
	};

	public static Action issuesAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e){
			openLink("https://github.com/datcuandrei/ccdoom/issues/new");
		}	
	};
}
