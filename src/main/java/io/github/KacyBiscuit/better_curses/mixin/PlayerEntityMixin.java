package io.github.KacyBiscuit.better_curses.mixin;

import io.github.KacyBiscuit.better_curses.Enchantments.BetterCursesEnchantmentHelper;
import io.github.KacyBiscuit.better_curses.Enchantments.BetterCursesEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity{

	protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(method = "getLuck()F", at = @At("HEAD"), cancellable = true)
	public void getLuck(CallbackInfoReturnable<Float> cir)
	{
		float subtractor = 0F;
		for(ItemStack i: this.getItemsEquipped()) {
			if (EnchantmentHelper.getLevel(BetterCursesEnchantments.MISFORTUNE_CURSE, i) > 0) {
				subtractor += 2F;
			}
		}

		float multiplier = 1F;
		for(int i = 1; i < BetterCursesEnchantmentHelper.getMisfortuneCurse(this); i++){
			multiplier += 2F;
		}

		cir.setReturnValue((float)this.getAttributeValue(EntityAttributes.GENERIC_LUCK) - (subtractor * multiplier));
	}

}
