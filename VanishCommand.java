package me.Geistesblitz2005.customessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Geistesblitz2005.customessentials.Main;

public class VanishCommand {

Main plugin;
	
	public VanishCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("custome.vanish")) {
				if (plugin.invisible_list.contains(player)) {
					for (Player people : Bukkit.getOnlinePlayers()) {
						people.showPlayer(player);
					}
				
						plugin.invisible_list.remove(player);
						player.sendMessage("&8(&c*&8) &7You are now visible to other players!");
					}else if(!plugin.invisible_list.contains(player)) {
						for (Player people : Bukkit.getOnlinePlayers()) {
					people.hidePlayer(player);
						}
						plugin.invisible_list.add(player);
						player.sendMessage("&8(&a*&8) &7You are now invisible");
					}
			} else {
				sender.sendMessage(plugin.getConfig().getString("Messages.no_permMessage"));
			}
		} else {
			sender.sendMessage(plugin.getConfig().getString("Messages.console_errorMessage"));
		}
		
		return true;
	}
	
}
