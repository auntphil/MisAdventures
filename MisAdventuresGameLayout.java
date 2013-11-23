import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MisAdventuresGameLayout extends JFrame {
	
	private int WeaponSelected, PlayerDamage, EnemyDamage;
	private boolean inCombat = false;
	private boolean Alive = true;

	public boolean isAlive() {
		return Alive;
	}

	public void setAlive(boolean alive) {
		Alive = alive;
	}

	public boolean isInCombat() {
		return inCombat;
	}

	public void setInCombat(boolean inCombat) {
		this.inCombat = inCombat;
	}

	public int getPlayerDamage() {
		return PlayerDamage;
	}

	public void setPlayerDamage(int playerDamage) {
		PlayerDamage = playerDamage;
	}

	public int getEnemyDamage() {
		return EnemyDamage;
	}

	public void setEnemyDamage(int enemyDamage) {
		EnemyDamage = enemyDamage;
	}



	int phealth = 100;
	int phmax = 100;
	int parmour = 50;
	int pamax = 50;
	int pamstr = 11;

	//constructors
	Player p1 = new Player(phealth, phmax, parmour, pamax, pamstr);
	Location Loc = new Location();
	Weapon Weapon = new Weapon();
	Enemy Enemy = new Enemy();
	Attack Attack = new Attack();
	Story Story = new Story();
	
	// General Game Layout
	private JFrame game = new JFrame("The Misfortunate Adventures of Joe");
	private JPanel parent = new JPanel();
	private static Dimension size = new Dimension(800, 500);

	// PlayerStat Panel Setup
	private JPanel PlayerInfo = new JPanel();
	private JLabel Health, Armour, PlayerStatTitle, WeaponName;

	// Location Panel Setup
	private JPanel location = new JPanel();
	private JLabel Region, Location, Room;

	// EncounterParent Panel Setup
	private JPanel EncounterParent = new JPanel();

	// EncounterHealth Panel Setup
	private JPanel EncounterHealth = new JPanel();
	private JLabel EncHealth, EncArmour, EncWeapon;

	// Encounter Info Panel Setup
	private JPanel Encounter = new JPanel();
	private JLabel EncounterTitle, EncounterType, EncounterName,
			EncounterHeight, EncounterWeight, EncHBar, EncABar;
	
	// ActionWindow Panel Setup
	private JPanel ActionWindow = new JPanel();
	private JButton AttackButton;
	private AttackButtonHandler abHandler;
	
	// StoryWindow Panel Setup
	private JPanel StoryWindow = new JPanel();
	private JLabel StoryTitle;
	private JTextArea StoryText;
	
	// Change Weapons Panel Setup
	private JPanel WeaponSwap = new JPanel();
	private JLabel Weapons;
	private JButton ChFist, ChFSword;
	private WeaponSelectHandler WeaponSelect;


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
		UpdateStoryWindow();
		UpdateActionWindow();
		UpdateWeaponSwap();
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
		
		// Story Panel Construction
		StoryWindow.setLayout(new BoxLayout(StoryWindow, BoxLayout.Y_AXIS));
		StoryWindow.setBorder(BorderFactory.createLineBorder(Color.black));
		StoryWindow.setBounds(255, 91, 400, 150);

		// ActionWindow Panel Construction
		ActionWindow.setLayout(new BoxLayout(ActionWindow, BoxLayout.X_AXIS));
		ActionWindow.setBorder(BorderFactory.createLineBorder(Color.black));
		ActionWindow.setBounds(255, 246, 400, 65);
		
		// Weapon Swap Page
		WeaponSwap.setLayout(null);
		WeaponSwap.setBorder(BorderFactory.createLineBorder(Color.black));
		WeaponSwap.setBounds(0, 246, 250, 225);
		
		// Adding Panels to the Game Frame
		game.setContentPane(parent);
		parent.add(location);
		parent.add(PlayerInfo);
		parent.add(Encounter);
		parent.add(EncounterHealth);
		parent.add(EncounterParent);
		parent.add(StoryWindow);
		parent.add(ActionWindow);
		parent.add(WeaponSwap);
		
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
		EncWeapon = new JLabel("");

		EncounterParent.add(EncounterTitle);
		Encounter.add(EncounterType);
		Encounter.add(EncounterName);
		Encounter.add(EncounterHeight);
		Encounter.add(EncounterWeight);
		EncounterHealth.add(EncHealth);
		EncounterHealth.add(EncHBar);
		EncounterHealth.add(EncArmour);
		EncounterHealth.add(EncABar);
		EncounterHealth.add(EncWeapon);

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
		WeaponName = new JLabel(" ");

		PlayerInfo.add(PlayerStatTitle);
		PlayerInfo.add(Health);
		PlayerInfo.add(Armour);
		PlayerInfo.add(WeaponName);
		
		// ActionWindow Initialization

		// StoryWindow Initialization
		StoryTitle = new JLabel("The Story");
		StoryText = new JTextArea("Here is where the story will go");

		
		// WeaponSwap Initialization
		Weapons = new JLabel("All Your Weapons!");
		Weapons.setBounds(67, 0, 115, 25);
		
		WeaponSwap.add(Weapons);
	}

	// Encounter Panel Update
	public void UpdateEncounter() {
		
		// get Health Bars
		String ABar = Enemy.ArmourBar();
		String HBar = Enemy.HealthBar();



		// Remove Old Elements
		EncounterParent.remove(EncounterTitle);
		Encounter.remove(EncounterType);
		Encounter.remove(EncounterName);
		Encounter.remove(EncounterHeight);
		Encounter.remove(EncounterWeight);
		//EncounterHealth.remove(EncHealth);
		//EncounterHealth.remove(EncArmour);
		EncounterHealth.remove(EncHBar);
		EncounterHealth.remove(EncABar);
		EncounterHealth.remove(EncWeapon);

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
		EncHBar = new JLabel("Health    " + HBar + "|");
		EncArmour = new JLabel("  Armour: " + Enemy.getArmour() + "/" + Enemy.getMaxArmour());
		EncABar = new JLabel("Armour  " + ABar + "|");
		EncWeapon = new JLabel("Weapon: " + Enemy.getWeapon());

		// Add to Panel
		EncounterParent.add(EncounterTitle);
		Encounter.add(EncounterType);
		Encounter.add(EncounterName);
		Encounter.add(EncounterHeight);
		Encounter.add(EncounterWeight);
		//EncounterHealth.add(EncHealth);
		EncounterHealth.add(EncHBar);
		//EncounterHealth.add(EncArmour);
		EncounterHealth.add(EncABar);
		EncounterHealth.add(EncWeapon);

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
		PlayerInfo.remove(WeaponName);

		// Set Values
		Weapon.setID(p1.getPlayerWeapon());
		Weapon.DifferentWeapons();
		WeaponName = new JLabel(Weapon.getName() + " (+" + Weapon.getDamage() + " Damage)");
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
		PlayerInfo.add(WeaponName);

		PlayerInfo.revalidate();
		PlayerInfo.repaint();
	}
	
	public void UpdateStoryWindow(){
		StoryWindow.remove(StoryTitle);
		StoryWindow.remove(StoryText);
		if(!Loc.isEmpty()){
			if(isInCombat())
				StoryText = new JTextArea(Story.PlayerAttack(Attack.getGlance(), getPlayerDamage(), Enemy.getType()));
			else
				StoryText = new JTextArea("You enter the " + Loc.getRoom() + " and see a menacing " + Enemy.getType() + "! What do you want to do?");
			if(!isAlive())
				StoryText = new JTextArea(Story.Death(Enemy.getType()));
		}
		else
		{
			StoryText = new JTextArea(Story.SecEntry(Enemy.getType()));
		}
		
			
		StoryWindow.add(StoryTitle);
		StoryWindow.add(StoryText);
		
		StoryText.setLineWrap(true);
		StoryText.setWrapStyleWord(true);
		StoryWindow.revalidate();
		StoryWindow.repaint();
	}
	
	public void UpdateActionWindow(){
		
		// Action Button
		if(isInCombat() || !Loc.isEmpty()){
			AttackButton = new JButton("Attack " + Enemy.getName() + " " + Enemy.getType());
			abHandler = new AttackButtonHandler();
			AttackButton.addActionListener(abHandler);
			AttackButton.setAlignmentX(CENTER_ALIGNMENT);
			ActionWindow.add(AttackButton);
		}
		
		
		
		ActionWindow.revalidate();
		ActionWindow.repaint();
	}

	public void UpdateWeaponSwap(){
		//WeaponSwap.remove(ChFist);
		//WeaponSwap.remove(ChFSword);
		
		if(p1.getPlayerWeapon()==0)
			ChFist = new JButton("Selected");
		else{
			ChFist = new JButton("Fists");
			WeaponSelect = new WeaponSelectHandler();
			ChFist.addActionListener(WeaponSelect);
			WeaponSelected = 0;
			
		}
		ChFist.setBounds(0, 0, 25, 100);
		
		if(p1.getPlayerWeapon()==1)
			ChFSword = new JButton("Selected");
		else{
			ChFSword = new JButton("Fire Sword");
			WeaponSelect = new WeaponSelectHandler();
			ChFSword.addActionListener(WeaponSelect);
			WeaponSelected = 1;
			
		}
		
		
		ChFist.setBounds(5, 30, 100, 25);
		ChFSword.setBounds(110, 30, 100, 25);
		
		WeaponSwap.add(ChFist);
		WeaponSwap.add(ChFSword);
		
		WeaponSwap.revalidate();
		WeaponSwap.repaint();
		
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
	private class AttackButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int ArmourDurability = 11;
			setInCombat(true);
			setPlayerDamage(Attack.PlayerAttack(Weapon.getSpeed(), Weapon.getDamage(), Enemy.getSpeed()));
			Enemy.AttackEnemyHealth(getPlayerDamage());
			Enemy.AttackEnemyArmour(getPlayerDamage());
			setEnemyDamage(Attack.EnemyAttack(Enemy.getDamage(), Enemy.getSpeed()));
			p1.DamagePlayerHealth(getEnemyDamage());
			p1.DamagePlayerArmour(getEnemyDamage(), ArmourDurability, Attack.isEvade());
			ActionWindow.remove(AttackButton);
			if(Enemy.getHealth()==0){
				setInCombat(false);
				Loc.setEmpty(true);
				Enemy.setArmour(0);
			}
			if(p1.getPlayerHealth()==0)
				setAlive(false);
			UpdatePlayerStats();
			UpdateEncounter();
			UpdateStoryWindow();
			UpdateActionWindow();

		}
	}
	
	// Weapon Swap Class
	private class WeaponSelectHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			p1.setPlayerWeapon(WeaponSelected);
			Weapon.setID(p1.getPlayerWeapon());
			WeaponSwap.remove(ChFist);
			WeaponSwap.remove(ChFSword);
			UpdateWeaponSwap();
			UpdatePlayerStats();
		}
	}
}
