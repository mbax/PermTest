package to.joe.permtest;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermTestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((sender instanceof Player)) {
            final Player player = (Player) sender;
            if(args.length>1){
                player.sendMessage(ChatColor.DARK_AQUA+"/permtest permission");
            }
            else{
                String perm=args[0];
                if(player.hasPermission(perm)){
                    player.sendMessage(ChatColor.DARK_AQUA+"You have the permission "+perm);
                }
                else{
                    player.sendMessage(ChatColor.DARK_AQUA+"You do not have "+perm);
                }
            }
        }
        else{
            sender.sendMessage("Must be a player to run this command");
        }
        return true;
    }
}
