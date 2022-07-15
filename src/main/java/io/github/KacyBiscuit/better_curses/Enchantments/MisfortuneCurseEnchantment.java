package io.github.KacyBiscuit.better_curses.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class MisfortuneCurseEnchantment extends Enchantment {
	protected MisfortuneCurseEnchantment(Rarity rarity, EquipmentSlot[] equipmentSlots) {
		super(rarity, EnchantmentTarget.WEARABLE, equipmentSlots);
	}

	public int getMinPower(int level) {
		return 25;
	}

	public int getMaxPower(int level) {
		return 50;
	}

	public int getMaxLevel() {
		return 3;
	}

	public boolean isTreasure() {
		return true;
	}

	public boolean isCursed() {
		return true;
	}
}
