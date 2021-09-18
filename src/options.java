import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class options{

	public static sp sPorts = new sp(); // contains the available source ports
	public static conf config = new conf(); // has the methods for managing configurations
	public static ccdoom mainClass = new ccdoom(); // for adding the source port to the `addedSourcePorts` combobox.
	public static help helpClass = new help(); // to use the method for opening links.
	
	/*
	 * method for adding sourceports to ccdoom
	 */
	public static Action sourcePortAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e){
					JFrame spframe = new JFrame("Add source ports");

					FlowLayout spLayout = new FlowLayout(FlowLayout.CENTER);
					spLayout.setHgap(10000);
					spframe.setLayout(spLayout);
					spframe.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
					spframe.setLocationRelativeTo(null);
					spframe.setSize(new Dimension(530,230));

					JLabel spExplanation = new JLabel("Choose the source port that you have installed.");
					JComboBox chooseSourcePort = new JComboBox(sPorts.availableSourcePorts);

					JTextArea pathExplanation = new JTextArea("Make sure that the source port you choose is added to your PATH variable.\n See the tutorial below on how to do it.");
					pathExplanation.setEditable(false);
					JButton pathTut = new JButton("Path Tutorial");

					pathTut.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent actionEvent){
								helpClass.openLink("https://github.com/datcuandrei/ccdoom/blob/main/instructions/path_tutorial.md");	
							}
						});

					JButton addSourcePort = new JButton("Add");

					addSourcePort.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent actionEvent){
								mainClass.installedSourcePorts.addItem(String.valueOf(chooseSourcePort.getSelectedItem()));
								JOptionPane.showMessageDialog(null,"Source port added!","Added",JOptionPane.INFORMATION_MESSAGE);	
							}
						});

					
					spframe.add(spExplanation);
					spframe.add(chooseSourcePort);
					spframe.add(pathExplanation);
					spframe.add(pathTut);
					spframe.add(addSourcePort);
					
					spframe.setVisible(true);
				}
		};

	/*
	 * method for deleting source ports from ccdoom
	 */
	public static Action delSourcePortAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e){
					JFrame dspframe = new JFrame("Remove added source port");

					FlowLayout dspLayout = new FlowLayout(FlowLayout.CENTER);
					dspLayout.setHgap(10000);
					dspframe.setLayout(dspLayout);
					dspframe.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
					dspframe.setLocationRelativeTo(null);
					dspframe.setSize(new Dimension(500,200));

					JLabel dspExplanation = new JLabel("Choose the source port that you want to remove.");
					
					JComboBox chooseSourcePortToDel = new JComboBox(); // creating a new combo box that holds the items of installedSourcePorts in main.java

					// iterating through each item and adding them to chooseSourcePortToDel
					// we use this to transfer the source ports from the installedSourcePorts.
					for(int i=0; i < mainClass.installedSourcePorts.getItemCount(); i++){
						chooseSourcePortToDel.addItem(String.valueOf(mainClass.installedSourcePorts.getItemAt(i)));
					}

					JButton delete = new JButton("Remove");

					delete.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent actionEvent){
								mainClass.installedSourcePorts.removeItem(chooseSourcePortToDel.getSelectedItem());
								chooseSourcePortToDel.removeItem(chooseSourcePortToDel.getSelectedItem());

								SwingUtilities.updateComponentTreeUI(mainClass.installedSourcePorts);
								SwingUtilities.updateComponentTreeUI(chooseSourcePortToDel);

								JOptionPane.showMessageDialog(null,"Source port removed!","Removed",JOptionPane.INFORMATION_MESSAGE);	
							}
						});
					
					dspframe.add(dspExplanation);
					dspframe.add(chooseSourcePortToDel);
					dspframe.add(delete);
					
					dspframe.setVisible(true);
				}
		};

	/*
	 * method responsible for adding iwads
	 */
	public static Action addIWADS = new AbstractAction() {
			public void actionPerformed(ActionEvent e){
				JFileChooser browse = new JFileChooser();
				browse.setFileHidingEnabled(false);
				browse.showOpenDialog(browse);
				String iwad = browse.getSelectedFile().getAbsolutePath();
				mainClass.iwadsList.addElement(iwad);
				SwingUtilities.updateComponentTreeUI(mainClass.IWADS);
			}
		};

	public static Action rmIWADS = new AbstractAction() {
			public void actionPerformed(ActionEvent e){
				String iwad = (String)JOptionPane.showInputDialog(null,"Choose an IWAD :","Remove IWAD",JOptionPane.PLAIN_MESSAGE,null,mainClass.iwadsList.toArray(),null);
				mainClass.iwadsList.removeElement(iwad);
				SwingUtilities.updateComponentTreeUI(mainClass.IWADS);
			}
		};
		
	public static Action addPWADS = new AbstractAction() {
			public void actionPerformed(ActionEvent e){
				JFileChooser browse = new JFileChooser();
				browse.setFileHidingEnabled(false);
				browse.showOpenDialog(browse);
				String pwad = browse.getSelectedFile().getAbsolutePath();
				mainClass.pwadsList.addElement(pwad);
				SwingUtilities.updateComponentTreeUI(mainClass.PWADS);
			}
		};
		
	public static Action rmPWADS = new AbstractAction() {
			public void actionPerformed(ActionEvent e){
				String pwad = (String)JOptionPane.showInputDialog(null,"Choose an PWAD :","Remove PWAD",JOptionPane.PLAIN_MESSAGE,null,mainClass.pwadsList.toArray(),null);
				mainClass.pwadsList.removeElement(pwad);
				SwingUtilities.updateComponentTreeUI(mainClass.PWADS);
			}
		};
}
