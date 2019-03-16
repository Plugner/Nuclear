package com.servidoresspace;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

        

public final class TntNuke extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new Functions(),this);

    }

    @Override
    public void onDisable() {
        // Pl
        // ugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("tntnuke.admin")) {
            if (args.length == 0) {
                Functions.giveNuke((Player) sender, 1);
                sender.sendMessage("§aVocê deu 1 TNT Nuclear para " + sender.getName() + ".");
            } else {
                if (args.length == 1) {
                    sender.sendMessage("§cUse: /tntnuke (jogador) (quantia)");
                } else {
                    Player p = (Player) sender;
                    int quantia = 0;
                    try {
                        quantia = Integer.valueOf(args[1]);
                    } catch (Exception e) {
                        p.sendMessage("§cQuantia inválida!");
                        return true;
                    }
                    if (Bukkit.getPlayer(args[0]) == null) {
                        p.sendMessage("§cJogador offline.");
                        return true;
                    }
                    Functions.giveNuke(Bukkit.getPlayer(args[0]), quantia);

                    sender.sendMessage("§aVocê deu " + quantia + " TNT Nuclear para " + Bukkit.getPlayer(args[0]).getName() + ".");
                    Bukkit.getPlayer(args[0]).sendMessage("§eVocê recebeu " + quantia + " tnt's");


                }
            }
        } else {
            sender.sendMessage("§cVocê não tem permissão.");
        }
    return false;
    }
}

