package io.github.KacyBiscuit.better_curses.Enchantments;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;

public class BetterCursesEnchantmentHelper extends EnchantmentHelper {
	public static int getMisfortuneCurse(LivingEntity entity) {
		return getEquipmentLevel(BetterCursesEnchantments.MISFORTUNE_CURSE, entity);
	}
}
