package com.github.alexthe668.domesticationinnovation.server.enchantment;

import com.github.alexthe668.domesticationinnovation.DomesticationMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class PetEnchantment extends Enchantment {

    private int levels;
    private int minXP;

    protected PetEnchantment(String name, Rarity r, int levels, int minXP) {
        super(r, DIEnchantmentRegistry.CATEGORY, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
        this.levels = levels;
        this.minXP = minXP;
        this.setRegistryName(new ResourceLocation(DomesticationMod.MODID, name));
    }

    public int getMinCost(int i) {
        return minXP + (i - 1) * 10;
    }

    public int getMaxCost(int i) {
        return super.getMinCost(i) + 30;
    }

    public int getMaxLevel() {
        return levels;
    }


    protected boolean checkCompatibility(Enchantment enchantment) {
        return this != enchantment && DIEnchantmentRegistry.areCompatible(this, enchantment);
    }

    public boolean isTradeable() {
        return super.isTradeable() && DomesticationMod.CONFIG.isEnchantEnabled(this);
    }

    public boolean isDiscoverable() {
        return super.isDiscoverable() && DomesticationMod.CONFIG.isEnchantEnabled(this);
    }

    public boolean isAllowedOnBooks() {
        return super.isAllowedOnBooks() && DomesticationMod.CONFIG.isEnchantEnabled(this);
    }
}
