package to.joe.permtest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PermTest extends JavaPlugin {

    @Override
    public void onDisable() {
        this.getLogger().info("Version " + this.getDescription().getVersion() + " disabled.");
    }

    @Override
    public void onEnable() {
        this.getLogger().info("Version " + this.getDescription().getVersion() + " enabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        final StringBuilder message = new StringBuilder();
        String permission;
        message.append(ChatColor.DARK_AQUA);
        if (args.length == 1) {
            permission = args[0];
            message.append("You");
            if (!sender.hasPermission(permission)) {
                message.append(" do not");
            }
            message.append(" have ");
        } else if (args.length > 1) {
            final Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                message.append("Cannot find player: " + ChatColor.AQUA + args[1]);
                sender.sendMessage(message.toString());
                return true;
            }
            message.append("Player " + ChatColor.AQUA + target.getName() + ChatColor.DARK_AQUA);
            permission = args[1];
            if (!target.hasPermission(permission)) {
                message.append(" does not have ");
            } else {
                message.append(" has ");
            }
        } else {
            return false;
        }
        message.append(ChatColor.AQUA + permission);
        sender.sendMessage(message.toString());
        return true;
    }
}