package io.github.KacyBiscuit.better_curses.Enchantments;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class BetterCursesEnchantmentHelper extends EnchantmentHelper {
	public static int getMisfortuneCurse(LivingEntity entity) {
		return getEquipmentLevel(BetterCursesEnchantments.MISFORTUNE_CURSE, entity);
	}

	public static int getFragilityCurse(ItemStack itemStack) {
		return getLevel(BetterCursesEnchantments.FRAGILITY_CURSE, itemStack);
	}
}
