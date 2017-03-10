package me.iHDeveloper.command;

import me.iHDeveloper.player.Player;

@CommandInfo(command = "help", description = "Show the information about game.", isOp = false)
public class HelpCommand extends Command{

    @Override
    public boolean onCommand(Player player, String[] args) {
        CommandManager.showhelp(player);
        return true;
    }
    
}
