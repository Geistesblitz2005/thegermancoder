package me.Geistesblitz2005.customessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Geistesblitz2005.customessentials.Main;
import me.Geistesblitz2005.customessentials.utils.Utils;

public class FlyCommand implements CommandExecutor{

private Main plugin;
	
	public FlyCommand(Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("fly").setExecutor(this);
	}
	
	public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("Messages.console_errorMessage")));
			return true;
		}
		
		Player p = (Player) sender;
		
		if (p.hasPermission("custome.fly")) {
			if (p.isFlying()) {
				p.setFlying(false);
				p.setFlying(false);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.fly_disabled")));
			} else {
				p.setFlying(true);
				p.setAllowFlight(true);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.fly_enabled")));
			}
		} else {
			sender.sendMessage(plugin.getConfig().getString("Messages.no_permMessage"));
		}
		
		return false;
	}
	
}