package kr.ac.ssu.artistum.testPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

// final의 의미는 무엇일까?
public final class testPlugin extends JavaPlugin{

	@Override
    public void onEnable() {
        // TODO Insert logic to be performed when the plugin is enabled
		getLogger().info("onEnable has been invoked!");
		// This will throw a NullPointerException if you don't have the command defined in your plugin.yml file!
		this.getCommand("basic").setExecutor(new testPluginCommandExecutor(this));
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    	getLogger().info("onDesiable has been invoked!");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("basic")) { // If the player typed /basic then do the following...
    		// do something...
    		return true;
    	} else if (cmd.getName().equalsIgnoreCase("basic2")) {
    		if (!(sender instanceof Player)) {
    			sender.sendMessage("This command can only be run by a player.");
    		} else {
    			Player player = (Player) sender;
    			// do something
    		}
    		return true;
    	}
    	return false;
    }
}
