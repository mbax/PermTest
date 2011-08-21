package to.joe.permtest;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class PermTest extends JavaPlugin {

    private PluginDescriptionFile selfDescription;

    private Logger log;


    /**
     * Tag that log!
     * 
     * @param message
     */
    public void log(String message) {
        this.log.info("[PermTest] " + message);
    }

    @Override
    public void onDisable() {
        this.log("Version " + this.selfDescription.getVersion() + " disabled.");
    }

    @Override
    public void onEnable() {
        this.selfDescription = this.getDescription();

        this.log = Logger.getLogger("Minecraft");

        this.getCommand("permtest").setExecutor(new PermTestCommand());

        this.log("Version " + this.selfDescription.getVersion() + " enabled.");
    }
}