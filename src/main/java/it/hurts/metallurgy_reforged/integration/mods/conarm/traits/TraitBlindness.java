/*
 * -------------------------------------------------------------------------------------------------------
 * Class: TraitBlindness
 * This class is part of Metallurgy 4 Reforged
 * Complete source code is available at: https://github.com/Davoleo/Metallurgy-4-Reforged
 * This code is licensed under GNU GPLv3
 * Authors: ItHurtsLikeHell & Davoleo
 * Copyright (c) 2019.
 * --------------------------------------------------------------------------------------------------------
 */

package it.hurts.metallurgy_reforged.integration.mods.conarm.traits;

import c4.conarm.lib.traits.AbstractArmorTrait;
import it.hurts.metallurgy_reforged.integration.mods.conarm.MetallurgyConArmorStats;
import net.minecraft.init.MobEffects;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class TraitBlindness extends AbstractArmorTrait implements IConarmMetallurgyTrait {

	public TraitBlindness()
	{
		super("blindness", TextFormatting.BLACK);
	}

	@SubscribeEvent
	public void onArmorTick(PlayerTickEvent event)
	{
		if (MetallurgyConArmorStats.isArmorTrait(event.player, "blindness"))
		{
			event.player.removePotionEffect(MobEffects.BLINDNESS);
		}
	}

}
