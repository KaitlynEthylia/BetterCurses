package io.github.KacyBiscuit.better_curses.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BetterCursesEnchantments {
	private static final EquipmentSlot[] ALL_ARMOR = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
	public static final Enchantment MISFORTUNE_CURSE = register("misfortune_curse", new MisfortuneCurseEnchantment(Enchantment.Rarity.VERY_RARE, ALL_ARMOR));
	private static Enchantment register(String name, Enchantment enchantment) {
		return Registry.register(Registry.ENCHANTMENT, new Identifier("better_curses", name), enchantment);
	}
}
