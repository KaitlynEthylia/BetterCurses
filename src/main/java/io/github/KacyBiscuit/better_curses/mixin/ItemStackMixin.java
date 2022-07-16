package io.github.KacyBiscuit.better_curses.mixin;

import io.github.KacyBiscuit.better_curses.Enchantments.BetterCursesEnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	@ModifyVariable(method = "damage(ILnet/minecraft/util/random/RandomGenerator;Lnet/minecraft/server/network/ServerPlayerEntity;)Z",
	at = @At(value = "LOAD", ordinal = 6),
	ordinal = 0)
	public int damage(int x) {
		return x + BetterCursesEnchantmentHelper.getFragilityCurse((ItemStack)(Object)this);
	}
}
