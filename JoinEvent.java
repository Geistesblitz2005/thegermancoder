package me.Geistesblitz2005.customessentials.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Geistesblitz2005.customessentials.Main;

public class JoinEvent {

Main plugin;
	
	public JoinEvent(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		for (int i = 0; i < plugin.invisible_list.size(); i++) {
			player.hidePlayer(plugin.invisible_list.get(i));
		}
	}
	
}
