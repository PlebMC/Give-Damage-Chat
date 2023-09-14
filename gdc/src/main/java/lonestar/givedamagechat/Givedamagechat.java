package lonestar.givedamagechat;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.*;
import org.bukkit.potion.*;

import static org.bukkit.potion.PotionEffectType.*;

public final class Givedamagechat extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("GDCPlugin is enabled!");
        getCommand("gdc").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("GDCPlugin is disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            Inventory inventory = player.getInventory();
            ItemStack instanthealpotion2 = new ItemStack(Material.SPLASH_POTION, 1);
            PotionMeta potionMetaHeal = (PotionMeta) instanthealpotion2.getItemMeta();
            PotionData instantheal = new PotionData(PotionType.INSTANT_HEAL, false, true);
            potionMetaHeal.setBasePotionData(instantheal);
            potionMetaHeal.setDisplayName(ChatColor.RESET + "Splash Potion of Healing");
            instanthealpotion2.setItemMeta(potionMetaHeal);

            if (command.getName().equalsIgnoreCase("gdc")) {
                inventory.addItem(instanthealpotion2);
                player.damage(4.0, player);
                player.sendMessage("You need to heal up!");
                return true;
            }
        }
        else
            sender.sendMessage("You are a console silly!");
        return false;
    }

}
