package me.iHDeveloper.commands;

import me.iHDeveloper.command.Command;
import me.iHDeveloper.command.CommandInfo;
import me.iHDeveloper.player.Player;
import me.iHDeveloper.player.PlayerChat;
import me.iHDeveloper.tools.TempleteData;

@CommandInfo(command = "settings", description = "set the settings", isOp = true)
public class SettingsCommand extends Command{

	@Override
	public boolean onCommand(Player player, String[] args) {
		PlayerChat messager = player.getMessager();
		if(args.length == 1){
			if(args[0].equalsIgnoreCase("wait")){
				TempleteData.setWaitSpawn(player.getLocation());
			}else if(args[0].equalsIgnoreCase("spactate")){
				TempleteData.setSpactateSpawn(player.getLocation());
			}else{
				messager.send("&cError on set setting");
				return true;
			}
			messager.send("&aComplete set setting");
			return true;
		}
		messager.sendSub();
		messager.send("&9/settings &ewait");
		messager.send("&9/settings &espactate");
		messager.sendSub();
		return true;
	}

}
