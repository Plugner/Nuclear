package com.servidoresspace;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Functions implements Listener {
    public static void giveNuke(Player p, int quantia) {
        ItemStack is = new ItemStack(Material.TNT);
        is.setAmount(quantia);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("§cTnt Nuclear");
        im.addEnchant(new FakeEnchant(101), 1,true);
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§7Nucleabilidade I");
        lore.add("");
        lore.add("§cItem perigoso!");
        im.setLore(lore);
        is.setItemMeta(im);
        p.getInventory().addItem(is);

    }
    @EventHandler
    public void onPutBlock(BlockPlaceEvent e) {
        Block b =e.getBlockPlaced();
        if(b.getType() == Material.TNT) {

            if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cTnt Nuclear")) {
                b.setMetadata("nuke",new FixedMetadataValue(Bukkit.getPluginManager().getPlugin("TntNuke"),"1"));
            }else{
                return;
            }

        }else{
            return;
        }
    }
    public int sec = 0;
    @EventHandler
    public void onIgnite(PlayerInteractEvent e) {
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if(e.getClickedBlock().hasMetadata("nuke")) {
                    Location loc = e.getClickedBlock().getLocation();
                    loc.getBlock().setType(Material.AIR);
                    loc.getWorld().createExplosion(loc,30f,true);
                }
            }

    }

}
