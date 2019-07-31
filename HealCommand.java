package me.Geistesblitz2005.customessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Geistesblitz2005.customessentials.Main;
import me.Geistesblitz2005.customessentials.utils.Utils;

public class HealCommand {

private Main plugin;
	
	public HealCommand (Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat("&8(&c*&8) &7Only players may execute this command!"));
			return true;
		}
		
		Player p = (Player) sender;
		if (p.hasPermission("custome.heal")) {
			if (cmd.getName().equalsIgnoreCase("heal")) {
				if (args.length == 0) {
					p.setHealth(20);
					p.setFoodLevel(20);
					p.sendMessage("&8(&a*&8) &7You have been healed!");
				}
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target == null) {
					p.sendMessage("&8(&c*&8) &7Could not find Player!");
					return true;
				}
				target.setHealth(20);
				target.setFoodLevel(20);
				target.sendMessage("&8(&a*&8) &7You have been healed!");
				p.sendMessage("&8(&a*&8) &7You have healed " + target.getName() + "!");
			}
		} else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("Messages.no_permMessage")));
		}
		if (p.hasPermission("custome.hunger")) {
			if(cmd.getName().equalsIgnoreCase("hunger")) {
				p.setFoodLevel(1);
				return true;
			}
		} else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("Messages.no_permMessage")));
		}
		return false;
	}
	
}
