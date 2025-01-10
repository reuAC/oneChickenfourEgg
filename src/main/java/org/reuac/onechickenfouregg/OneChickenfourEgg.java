package org.reuac.onechickenfouregg;

import org.bukkit.Bukkit;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class OneChickenfourEgg extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this,this);

    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntityType() == EntityType.EGG) {
            event.getEntity().remove();

            for (int i = 0; i < 4; i++) {
                Chicken chicken = (Chicken) event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), EntityType.CHICKEN);
                chicken.setBaby();
            }
        }
    }
}
