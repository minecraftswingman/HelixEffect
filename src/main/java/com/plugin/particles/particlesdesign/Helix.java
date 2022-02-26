package com.plugin.particles.particlesdesign;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Helix extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void CreateShape(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            System.out.println("Debug");
            Location loc = e.getPlayer().getLocation();

            new BukkitRunnable() {
                double t = 0;


                @Override
                public void run() {
                    t += Math.PI/8;
                    double x = 2*Math.cos(t);
                    double y = t;
                    double z = 2*Math.sin(t);
                    loc.add(x, y, z);
                    e.getPlayer().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
                    loc.subtract(x, y, z);

                    if (t > Math.PI*4) cancel();
                }




            }.runTaskTimer(this, 0, 1L);









        }

    }

}