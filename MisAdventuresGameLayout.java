import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MisAdventuresGameLayout extends JFrame {

	int phealth = 65;
	int phmax = 100;
	int parmour = 8;
	int pamax = 50;
	int pamstr = 11;
	Player p1 = new Player(phealth, phmax, parmour, pamax, pamstr);
	Location Loc = new Location();
	
	Enemy Enemy = new Enemy();
	// General Game Layout
	private JFrame game = new JFrame("The Misfortunate Adventures of Joe");
	private JPanel parent = new JPanel();
	private static Dimension size = new Dimension(800, 500);

	// PlayerStat Panel Setup
	private JPanel PlayerInfo = new JPanel();
	private JLabel Health, Armour, PlayerStatTitle;

	// Location Panel Setup
	private JPanel location = new JPanel();
	private JLabel Region, Location, Room;

	// EncounterParent Panel Setup
	private JPanel EncounterParent = new JPanel();

	// EncounterHealth Panel Setup
	private JPanel EncounterHealth = new JPanel();
	private JLabel EncHealth, EncArmour;

	// Encounter Info Panel Setup
	private JPanel Encounter = new JPanel();
	private JLabel EncounterTitle, EncounterType, EncounterName,
			EncounterHeight, EncounterWeight, EncHBar, EncABar;
	
	// Action Panel Setup
	private JPanel ActionWindow = new JPanel();
	private JButton ActionButton;
	private ActionButtonHandler abHandler;


	public MisAdventuresGameLayout() {
	}

	public void StartGame() {
		
		//Player.setPlayerHealth(25);
		String title = "The Misfortunate Adventures of Joe";
		Enemy.getEnemy();

		init();
		gameLayout();
		UpdatePlayerStats();
		UpdateLocation();
		UpdateEncounter();
		UpdateActionWindow();
	}

	public void gameLayout() {
		// main panel that covers all
		// Uses direct locations
		parent.setLayout(null);

		// Location Panel Construction
		location.setLayout(new BoxLayout(location, BoxLayout.Y_AXIS));
		location.setBorder(BorderFactory.createLineBorder(Color.black));
		location.setBounds(0, 0, 250, 84);

		// PlayerStat Panel Construction
		PlayerInfo.setLayout(new BoxLayout(PlayerInfo, BoxLayout.Y_AXIS));
		PlayerInfo.setBorder(BorderFactory.createLineBorder(Color.black));
		PlayerInfo.setBounds(0, 91, 250, 150);

		// EncounterParent Panel Construction
		EncounterParent.setLayout(new BoxLayout(EncounterParent,
				BoxLayout.Y_AXIS));
		EncounterParent.setBorder(BorderFactory.createLineBorder(Color.black));
		EncounterParent.setBounds(255, 0, 400, 84);

		// Encounter Info Panel Construction
		Encounter.setLayout(new BoxLayout(Encounter, BoxLayout.Y_AXIS));
		Encounter.setBorder(BorderFactory.createLineBorder(Color.black));
		Encounter.setBounds(257, 17, 197, 65);

		// Encounter Health Panel Construction
		EncounterHealth.setLayout(new BoxLayout(EncounterHealth,
				BoxLayout.Y_AXIS));
		EncounterHealth.setBorder(BorderFactory.createLineBorder(Color.black));
		EncounterHealth.setBounds(456, 17, 197, 65);

		// ActionWindow Panel Construction
		ActionWindow.setLayout(new BoxLayout(ActionWindow, BoxLayout.X_AXIS));
		ActionWindow.setBorder(BorderFactory.createLineBorder(Color.black));
		ActionWindow.setBounds(255, 89, 400, 65);
		
		// Adding Panels to the Game Frame
		game.setContentPane(parent);
		parent.add(location);
		parent.add(PlayerInfo);
		parent.add(Encounter);
		parent.add(EncounterHealth);
		parent.add(EncounterParent);
		parent.add(ActionWindow);
		
		// Encounter Stats Initialization
		EncounterTitle = new JLabel("");
		EncounterType = new JLabel("");
		EncounterName = new JLabel("");
		EncounterHeight = new JLabel("");
		EncounterWeight = new JLabel("");

		// Encounter Health Initialization
		EncHealth = new JLabel("");
		EncArmour = new JLabel("");
		EncHBar = new JLabel("");
		EncABar = new JLabel("");

		EncounterParent.add(EncounterTitle);
		Encounter.add(EncounterType);
		Encounter.add(EncounterName);
		Encounter.add(EncounterHeight);
		Encounter.add(EncounterWeight);
		EncounterHealth.add(EncHealth);
		EncounterHealth.add(EncHBar);
		EncounterHealth.add(EncArmour);
		EncounterHealth.add(EncABar);

		// Location Initialization
		Region = new JLabel(" ");
		Location = new JLabel(" ");
		Room = new JLabel(" ");

		location.add(Region);
		location.add(Location);
		location.add(Room);

		// PlayerStat Initialization
		PlayerStatTitle = new JLabel("Player Stats");
		Health = new JLabel(" ");
		Armour = new JLabel(" ");

		PlayerInfo.add(PlayerStatTitle);
		PlayerInfo.add(Health);
		PlayerInfo.add(Armour);
		
		// ActionWindow Initialization

	}

	// Encounter Panel Update
	public void UpdateEncounter() {
		
		// get Health Bars
		String HBar = Enemy.HealthBar(0);
		String ABar = Enemy.HealthBar(1);

		// Remove Old Elements
		EncounterParent.remove(EncounterTitle);
		Encounter.remove(EncounterType);
		Encounter.remove(EncounterName);
		Encounter.remove(EncounterHeight);
		Encounter.remove(EncounterWeight);
		EncounterHealth.remove(EncHealth);
		EncounterHealth.remove(EncArmour);
		EncounterHealth.remove(EncHBar);
		EncounterHealth.remove(EncABar);

		// Set Values
		EncounterTitle = new JLabel("Enemy Information");
		EncounterTitle.setAlignmentX(CENTER_ALIGNMENT);
		EncounterType = new JLabel("Creature Type: " + Enemy.getType());
		EncounterType.setAlignmentX(CENTER_ALIGNMENT);
		EncounterName = new JLabel("Creature Class: " + Enemy.getName());
		EncounterName.setAlignmentX(CENTER_ALIGNMENT);
		EncounterHeight = new JLabel("Height: " + Enemy.getHeight() + " inches");
		EncounterHeight.setAlignmentX(CENTER_ALIGNMENT);
		EncounterWeight = new JLabel("Weight: " + Enemy.getWeight() + " pounds");
		EncounterWeight.setAlignmentX(CENTER_ALIGNMENT);
		EncHealth = new JLabel("  Health: " + Enemy.getHealth() + "/" + Enemy.getMaxHealth());
		EncHBar = new JLabel("    " + HBar + "|");
		EncArmour = new JLabel("  Armour: " + Enemy.getArmour() + "/" + Enemy.getMaxArmour());
		EncABar = new JLabel("    " + ABar + "|");

		// Add to Panel
		EncounterParent.add(EncounterTitle);
		Encounter.add(EncounterType);
		Encounter.add(EncounterName);
		Encounter.add(EncounterHeight);
		Encounter.add(EncounterWeight);
		EncounterHealth.add(EncHealth);
		EncounterHealth.add(EncHBar);
		EncounterHealth.add(EncArmour);
		EncounterHealth.add(EncABar);

	}

	// Location Panel Update
	public void UpdateLocation() {
		// Remove Old Elements
		location.remove(Region);
		location.remove(Location);
		location.remove(Room);

		// Set Values
		Region = new JLabel("Region: " + Loc.getRegion());
		Region.setAlignmentX(CENTER_ALIGNMENT);
		Location = new JLabel("Location: " + Loc.getLocation());
		Location.setAlignmentX(CENTER_ALIGNMENT);
		Room = new JLabel("Room: " + Loc.getRoom());
		Room.setAlignmentX(CENTER_ALIGNMENT);

		// Add to Panel
		location.add(Region);
		location.add(Location);
		location.add(Room);
	}

	// PlayerStat Panel Update
	public void UpdatePlayerStats() {

		// Remove Old Elements
		PlayerInfo.remove(Health);
		PlayerInfo.remove(Armour);

		// Set Values
		if (p1.getPlayerHealth() == 0)
			Health = new JLabel("Health: Dead :(");
		else
			Health = new JLabel("Health: " + p1.getPlayerHealth() + "/"
					+ p1.getPlayerMaxHealth());
		Health.setAlignmentX(CENTER_ALIGNMENT);
		if (p1.getPlayerArmour() == 0)
			Armour = new JLabel("Armour: None");
		else
			Armour = new JLabel("Armour: " + p1.getPlayerArmour() + "/"
					+ p1.getPlayerMaxArmour());
		Armour.setAlignmentX(CENTER_ALIGNMENT);

		// Add to Panel
		PlayerInfo.add(Health);
		PlayerInfo.add(Armour);

		PlayerInfo.revalidate();
		PlayerInfo.repaint();
	}
	
	public void UpdateActionWindow(){
		
		// Action Button
		ActionButton = new JButton("Attack " + Enemy.getName() + " " + Enemy.getType());
		abHandler = new ActionButtonHandler();
		ActionButton.addActionListener(abHandler);
		ActionButton.setAlignmentX(CENTER_ALIGNMENT);
		
		ActionWindow.add(ActionButton);
		
		ActionWindow.revalidate();
		ActionWindow.repaint();
	}

	// Make Window Visible and initialize it
	public void init() {
		game.setVisible(true);
		game.setSize(size);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setLocationRelativeTo(null);
		game.setResizable(false);
	}

	// Start Button Action
	private class ActionButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int ArmourDurability = 11;
			p1.DamagePlayerHealth(Enemy.getDamage());
			p1.DamagePlayerArmour(Enemy.getDamage(), ArmourDurability);
			PlayerInfo.remove(ActionButton);
			UpdatePlayerStats();

		}
	}
}
