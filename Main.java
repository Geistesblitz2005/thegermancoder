package me.Geistesblitz2005.customessentials;

import java.util.ArrayList;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.Geistesblitz2005.customessentials.commands.FlyCommand;
import me.Geistesblitz2005.customessentials.commands.HealCommand;
import me.Geistesblitz2005.customessentials.commands.VanishCommand;
import me.Geistesblitz2005.customessentials.listeners.JoinEvent;

public class Main extends JavaPlugin {
	
	public ArrayList<Player> invisible_list = new ArrayList<>();
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		new FlyCommand(this);
		new HealCommand(this);
		
		//VanishCommand
		getCommand("vanish").setExecutor((CommandExecutor) new VanishCommand(this));
		getServer().getPluginManager().registerEvents((Listener) new JoinEvent(this), this);
	}
	
}
