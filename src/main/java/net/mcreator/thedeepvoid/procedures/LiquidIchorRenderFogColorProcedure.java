package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class LiquidIchorRenderFogColorProcedure {
	public static ViewportEvent.ComputeFogColor provider = null;

	public static void setColor(int color) {
		provider.setRed((color >> 16 & 255) / 255.0F);
		provider.setGreen((color >> 8 & 255) / 255.0F);
		provider.setBlue((color & 255) / 255.0F);
	}

	public static void setColor(float level, int color) {
		if (level <= 0.0F)
			return;
		if (level >= 1.0F) {
			provider.setRed((color >> 16 & 255) / 255.0F);
			provider.setGreen((color >> 8 & 255) / 255.0F);
			provider.setBlue((color & 255) / 255.0F);
		} else {
			level = Mth.clamp(level, 0.0F, 1.0F);
			provider.setRed(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getRed(), 0.0F, 1.0F), (color >> 16 & 255) / 255.0F), 0.0F, 1.0F));
			provider.setGreen(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getGreen(), 0.0F, 1.0F), (color >> 8 & 255) / 255.0F), 0.0F, 1.0F));
			provider.setBlue(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getBlue(), 0.0F, 1.0F), (color & 255) / 255.0F), 0.0F, 1.0F));
		}
	}

	@SubscribeEvent
	public static void computeFogColor(ViewportEvent.ComputeFogColor event) {
		provider = event;
		ClientLevel level = Minecraft.getInstance().level;
		Entity entity = provider.getCamera().getEntity();
		if (level != null && entity != null) {
			Vec3 entPos = entity.getPosition((float) provider.getPartialTick());
			execute(provider, level, entity);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == TheDeepVoidModBlocks.LIQUID_ICHOR.get()
				&& (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1.5, entity.getZ()))).getBlock() == TheDeepVoidModBlocks.LIQUID_ICHOR.get()
				|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == TheDeepVoidModBlocks.LIQUID_ICHOR.get() && entity.isSwimming()) {
			setColor(255 << 24 | 255 << 16 | 235 << 8 | 85);
		} else if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == TheDeepVoidModBlocks.LIQUID_VOID.get()) {
			setColor(255 << 24 | 0 << 16 | 0 << 8 | 0);
		}
	}
}
