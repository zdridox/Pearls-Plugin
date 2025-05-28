package dev.mateuszzdr.pearls;

import dev.mateuszzdr.pearls.commands.howManyEnderPearls;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public final class Pearls extends JavaPlugin {

    private static Pearls instance;

    public static Pearls getInstance() {return instance;}

    @Override
    public void onEnable() {
        instance = this;
        getCommand("Pearls").setExecutor(new howManyEnderPearls());
        Bukkit.getConsoleSender().sendMessage("Pearls by zdridox");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public int getPearls(String name) {
        int count = 0;
        for(World w : Bukkit.getWorlds()) {
            for(Entity e : w.getEntities()) {
                if(e instanceof EnderPearl) {
                    if(Bukkit.getPlayer(((EnderPearl) e).getOwnerUniqueId()).getName().equals(name)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
