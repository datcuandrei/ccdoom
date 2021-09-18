import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ccdoom{
	// declaring variables

	// import classes
	public static options optionsMenu = new options(); // class that contains the methods required for the options submenus functionality
	public static conf config = new conf(); // class that contains the methods for managing the config file
	public static sp sourcePorts = new sp(); // class that contains the method for running DOOM.
	public static profiles profilesClass = new profiles(); // class that contains the methods for managing profiles.
	public static help helpClass = new help(); // class that contains the methods required for the help submenus functionality.

	// gui elements
	public static JMenuBar menuBar = new JMenuBar(); // top bar
	public static JToolBar downBar = new JToolBar(); // bottom bar
	public static JMenu options = new JMenu("Options"); // menu that contains options for user to configure
	public static JMenu profiles = new JMenu("Profiles"); // menu that contains options for the user to configure their profiles.
	public static JMenu help = new JMenu("Help"); // menu that contains the about section, as well as the updates button.

	public static JPanel midPanel = new JPanel(); // panel that contains the elements found in the center of the layout.
	// midPanel components -->
	public static JComboBox installedSourcePorts = new JComboBox(); // combo box that will contain user added source ports
	public static 	DefaultListModel iwadsList = new DefaultListModel(); // list that will contain user added IWADs
	public static 	DefaultListModel pwadsList = new DefaultListModel(); // list that will contain user added PWADs
	
	public static JList IWADS = new JList(iwadsList); // JList that will display user added IWADs
	public static JList PWADS = new JList(pwadsList); // JList that will display user added PWADs
	
	public static JScrollPane IWADSpane;
	public static JScrollPane PWADSpane;
	
	/*
	 * setting the combobox's width
	 * to look good.
	 */
	public static void adjWidth(){
		installedSourcePorts.setPreferredSize(new Dimension(350, 30));
		IWADS.setPreferredSize(new Dimension(600, 200));
		IWADS.setMaximumSize(new Dimension(600, 200));
		PWADS.setPreferredSize(new Dimension(600, 200));
		PWADS.setMaximumSize(new Dimension(600, 200));
	}
	
	public static JLabel ispLabel = new JLabel("Select a Source Port:");
	public static JLabel iwadsLabel = new JLabel("Select an IWAD:");
	public static JLabel pwadsLabel = new JLabel("List of added mods:");

	public static JScrollPane getIWADSpane(){
		IWADSpane = new JScrollPane(IWADS);
		IWADSpane.setPreferredSize(new Dimension(350,200));
		IWADSpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		IWADSpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		return IWADSpane;
		}
	public static JScrollPane getPWADSpane(){
		PWADSpane = new JScrollPane(PWADS);
		PWADSpane.setPreferredSize(new Dimension(350,200));
		PWADSpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		PWADSpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		return PWADSpane;
		}
	// <--

	
	public static JTextField addcli = new JTextField(20); // text field in case user wants to add other paramenters
	public static JButton launch = new JButton("Launch"); // button that starts the game with the options the user added

	public static JMenu getOptions(){
		JMenuItem addSourcePorts = new JMenuItem("Add source ports");
		JMenuItem rmSourcePorts = new JMenuItem("Remove added source port");
		JMenuItem addIWADS = new JMenuItem("Add IWADS");
		JMenuItem rmIWADS = new JMenuItem("Remove IWADS");
		JMenuItem addPWADS = new JMenuItem("Add PWADS");
		JMenuItem rmPWADS = new JMenuItem("Remove PWADS");
		JMenuItem quit = new JMenuItem("Quit");

		// adding the functionality to every button
		addSourcePorts.addActionListener(optionsMenu.sourcePortAction);
		rmSourcePorts.addActionListener(optionsMenu.delSourcePortAction);		
		addIWADS.addActionListener(optionsMenu.addIWADS);
		addPWADS.addActionListener(optionsMenu.addPWADS);
		rmIWADS.addActionListener(optionsMenu.rmIWADS);
		rmPWADS.addActionListener(optionsMenu.rmPWADS);
		
		options.add(addSourcePorts);
		options.add(rmSourcePorts);
		options.add(new JSeparator());
		options.add(addIWADS);
		options.add(rmIWADS);
		options.add(new JSeparator());
		options.add(addPWADS);
		options.add(rmPWADS);
		options.add(new JSeparator());
		options.add(quit);
		return options;
		}

	public static JMenu getProfiles(){
		JMenuItem saveProfile = new JMenuItem("Save profile");
		JMenuItem loadProfile = new JMenuItem("Load profile");
		JMenuItem updateProfile = new JMenuItem("Update profile");
		JMenuItem deleteProfile = new JMenuItem("Delete profile");

		// adding the functionality to every button
		saveProfile.addActionListener(profilesClass.saveProfileAction);
		loadProfile.addActionListener(profilesClass.openProfileAction);
		updateProfile.addActionListener(profilesClass.overwriteProfileAction);
		deleteProfile.addActionListener(profilesClass.deleteProfileAction);


		profiles.add(saveProfile);
		profiles.add(loadProfile);
		profiles.add(updateProfile);
		profiles.add(deleteProfile);
		return profiles;
		}
	public static JMenu getHelp(){
		JMenuItem gettingStarted = new JMenuItem("Get started with ccdoom");
		JMenuItem updates = new JMenuItem("Updates");
		JMenuItem issues = new JMenuItem("Report issue");
		JSeparator separator = new JSeparator();
		JMenuItem about = new JMenuItem("About");

		about.addActionListener(helpClass.aboutAction);
		issues.addActionListener(helpClass.issuesAction);
		updates.addActionListener(helpClass.updatesAction);
		gettingStarted.addActionListener(helpClass.getStartedAction);

		help.add(gettingStarted);
		help.add(issues);
		help.add(updates);
		help.add(separator);
		help.add(about);
		return help;
		}

	public static JMenuBar getMenuBar(){
		menuBar = new JMenuBar();

		menuBar.add(getOptions());
		menuBar.add(getProfiles());
		menuBar.add(getHelp());

		return menuBar;
		}
		
	/*
	 * button that launches doom
	 */
	public static JButton getLaunch(){
		launch.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent actionEvent){
					sourcePorts.runDoom();	
				}
			});
		return launch;
		}
	public static JToolBar getDownBar(){
		FlowLayout downLayout = new FlowLayout(FlowLayout.LEADING);
		downBar.setLayout(downLayout);
		downBar.setSize(new Dimension(downBar.getWidth(),20));
		downBar.setFloatable(false);

		downBar.add(new JLabel("Add arguments:"));
		downBar.add(addcli);
		downBar.add(getLaunch());
		return downBar;
		}

		
	public static JPanel getMidPanel(){
		FlowLayout midLayout = new FlowLayout();
		midLayout.setAlignment(FlowLayout.CENTER);
		midLayout.setHgap(10000);
		midPanel.setLayout(midLayout);
		midPanel.add(ispLabel);
		midPanel.add(installedSourcePorts);
		midPanel.add(iwadsLabel);
		midPanel.add(getIWADSpane());
		midPanel.add(pwadsLabel);
		midPanel.add(getPWADSpane());
		return midPanel;
		}
	public static void main(String[] args)throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
			// setting the look and feel of the app
			if(System.getProperty("os.name").toLowerCase().contains("linux")){
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			}else{
        			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			// informational message about technical preview
			JOptionPane.showMessageDialog(null,"Welcome to ccdoom!\n\nPlease note that this is a technical preview of ccdoom, not a finished product.\nIf you encounter any bugs or issues, go to 'Help > Report issue'\n and write a detailed description of what problems you have noticed.\nAgain, this is not the finished product and as a result, things might be much more \nunstable than anticipated.\nThe finished product will be polished, fully working and will include new exciting features.\n\nIt is recommended that you see 'Help > Get started with ccdoom' to learn how to use ccdoom. \n\nI hope you will enjoy ccdoom as much as I enjoy working on it!\n\n Regards,\n Andrei Datcu.","Welcome!",JOptionPane.INFORMATION_MESSAGE);
			// building the main frame
			JFrame mainFrame = new JFrame("ccdoom for "+System.getProperty("os.name")+": 18 Sep 2021");
		
			mainFrame.setLayout(new BorderLayout());
			mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			mainFrame.setLocationRelativeTo(null);
			mainFrame.setSize(new Dimension(450,650));

			mainFrame.add(getMenuBar(), BorderLayout.PAGE_START);
			mainFrame.add(getMidPanel(),BorderLayout.CENTER);
			mainFrame.add(getDownBar(), BorderLayout.PAGE_END);

			adjWidth();
			SwingUtilities.updateComponentTreeUI(mainFrame);

			// finally showing the end result
			mainFrame.setVisible(true);
		}
}
