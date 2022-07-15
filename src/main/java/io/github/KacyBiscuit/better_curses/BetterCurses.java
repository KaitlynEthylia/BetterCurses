package io.github.KacyBiscuit.better_curses;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.KacyBiscuit.better_curses.Enchantments.BetterCursesEnchantments;
import net.minecraft.command.CommandBuildContext;
import net.minecraft.command.CommandSource;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.command.api.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterCurses implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Example Mod");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());
		new BetterCursesEnchantments();
		CommandRegistrationCallback.EVENT.register(this::register);
	}

	private void register(CommandDispatcher<ServerCommandSource> serverCommandSourceCommandDispatcher, CommandBuildContext commandBuildContext, CommandManager.RegistrationEnvironment registrationEnvironment) {
		serverCommandSourceCommandDispatcher.register(CommandManager.literal("getLuck").executes(this::run));
	}

	private int run(CommandContext<ServerCommandSource> serverCommandSourceCommandContext) throws CommandSyntaxException {
			serverCommandSourceCommandContext.getSource().sendFeedback(Text.of(Float.toString(serverCommandSourceCommandContext.getSource().getPlayer().getLuck())), false);
		return 1;
	}
}
