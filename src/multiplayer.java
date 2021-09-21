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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class multiplayer{
		public static sp sourcePorts = new sp(); // class that contains the method for launching doom

		/*
		 * method that displays a list of servers
		 * the server list is from doomlist.net
		 * huge thanks to https://gitlab.com/jan_k/
		 * for creating this website.
		 */
		public static Action browseServersAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e){
					try{
						// main frame
						JFrame servers = new JFrame("Server Browser");
						servers.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
						servers.setLocationRelativeTo(null);
						servers.setSize(960,500);
						servers.setLayout(new BorderLayout());
						
						// using a jeditorpane to display the website.
						// just found out that jeditorpane can display basic html websites,lol.
						JEditorPane doomlist = new JEditorPane("https://doomlist.net/full");
						doomlist.setEditable(false);

						// panel that will contain the server list
						JPanel serversPanel = new JPanel();
						// putting the server list in a scroll pane
						JScrollPane serversPane = new JScrollPane(doomlist);
						// some preferences
						serversPane.setPreferredSize(new Dimension(servers.getWidth(),500));
						serversPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
						//serversPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						serversPanel.add(serversPane);

						// bottom bar
						JToolBar botBar = new JToolBar();
						botBar.setLayout(new FlowLayout(FlowLayout.TRAILING));
						botBar.setSize(new Dimension(botBar.getWidth(),20));
						botBar.setFloatable(false);

						JTextField ipField = new JTextField(20); // field from which we will obtain the ip address
						JButton connectBtn = new JButton("Connect");
						connectBtn.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
									String ipAddress = ipField.getText();
									sourcePorts.runDoom(true, ipAddress); // launching doom in zandronum in the server
								}
							});

						botBar.add(new JLabel("Enter server address: "));
						botBar.add(ipField);
						botBar.add(connectBtn);

						// adding items to the frame
						servers.add(new JToolBar().add(new JLabel("Server list retrieved from doomlist.net; ccdoom will launch Zandronum with the configuration found in the main menu.")), BorderLayout.PAGE_START);
						servers.add(serversPanel,BorderLayout.CENTER);
						servers.add(botBar, BorderLayout.PAGE_END);

						// updating the gui
						SwingUtilities.updateComponentTreeUI(serversPanel);
						SwingUtilities.updateComponentTreeUI(servers);

						// showing the frame
						servers.setVisible(true);
					}catch(IOException e1){
						JOptionPane.showMessageDialog(null,"Cannot retrieve servers. Please report this error to @datcuandrei on GitHub : " + e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
					}
				}
		};
	}
