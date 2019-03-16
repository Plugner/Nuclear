package com.servidoresspace;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class FakeEnchant extends Enchantment {
    public FakeEnchant(int id) {
        super(id);
    }

    public String getName() {
        return "Nucleabilidade";
    }

    public int getMaxLevel() {
        return 1;
    }

    public int getStartLevel() {
        return 1;
    }

    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.ALL;
    }

    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    public boolean canEnchantItem(ItemStack item) {
        return false;
    }
}
