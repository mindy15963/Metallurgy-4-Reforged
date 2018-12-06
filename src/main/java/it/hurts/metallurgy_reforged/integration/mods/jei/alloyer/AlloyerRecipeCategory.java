package it.hurts.metallurgy_reforged.integration.mods.jei.alloyer;

import it.hurts.metallurgy_reforged.Metallurgy;
import it.hurts.metallurgy_reforged.block.ModBlocks;
import it.hurts.metallurgy_reforged.integration.IntegrationJEI;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.*;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 03/12/2018 / 20:27
 * Class: AlloyerRecipeCategory
 * Project: Metallurgy 4 Reforged
 * Copyright - � - Davoleo - 2018
 **************************************************/

public class AlloyerRecipeCategory implements IRecipeCategory<AlloyerRecipeWrapper> {

    //Slot IDs
    private static final int INPUT_SLOT_1 = 0;
    private static final int INPUT_SLOT_2 = 1;
    private static final int OUTPUT_SLOT = 2;

    //GUI Background
    private final IDrawableStatic background;

    //Animations
    protected final IDrawableAnimated flame;
    protected final IDrawableAnimated bar;
    protected final IDrawableAnimated moltenMetal;

    public AlloyerRecipeCategory(IGuiHelper guiHelper)
    {
        ResourceLocation texture = new ResourceLocation(Metallurgy.MODID, "textures/gui/alloyer.png");

        background = guiHelper.createDrawable(texture, 0, 0, 176, 108);

        //Burning fuel animation
        IDrawableStatic flameDrawable = guiHelper.createDrawable(texture,176, 61, 17, 17);
        flame = guiHelper.createAnimatedDrawable(flameDrawable, 200, IDrawableAnimated.StartDirection.TOP, true);

        //Molten metal flow animation
        IDrawableStatic moltenDrawable = guiHelper.createDrawable(texture, 176, 81, 10, 25);
        moltenMetal = guiHelper.createAnimatedDrawable(moltenDrawable, 80, IDrawableAnimated.StartDirection.TOP, false);

        //Process animation
        IDrawableStatic barDrawable = guiHelper.createDrawable(texture, 176, 0, 7, 33);
        bar = guiHelper.createAnimatedDrawable(barDrawable, 80, IDrawableAnimated.StartDirection.BOTTOM, false);
    }

    @Override
    public void drawExtras(Minecraft minecraft)
    {
        flame.draw(minecraft, 110, 61);
        bar.draw(minecraft, 40, 66);
        moltenMetal.draw(minecraft, 52, 32);
    }

    @Nonnull
    @Override
    public String getUid()
    {
        return IntegrationJEI.ALLOYER;
    }

    @Nonnull
    @Override
    public String getTitle()
    {
        return new ItemStack(ModBlocks.alloyer).getDisplayName();
    }

    @Nonnull
    @Override
    public String getModName()
    {
        return Metallurgy.NAME;
    }

    @Nonnull
    @Override
    public IDrawableStatic getBackground()
    {
        return background;
    }

    @Nullable
    @Override
    public IDrawable getIcon()
    {
        return null;
    }

    @SuppressWarnings({"rawtypes", "deprecation"})
    @Override
    public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull AlloyerRecipeWrapper recipeWrapper, @Nonnull IIngredients ingredients)
    {
        IGuiIngredientGroup group = recipeLayout.getItemStacks();

        group.init(INPUT_SLOT_1, true, 101, 23);
        group.init(INPUT_SLOT_2, true, 122, 23);
        group.init(OUTPUT_SLOT, false, 56, 73);

        group.set(INPUT_SLOT_1, ingredients.getInputs(ItemStack.class).get(0));
        group.set(INPUT_SLOT_2, ingredients.getInputs(ItemStack.class).get(1));
        group.set(OUTPUT_SLOT, ingredients.getOutputs(ItemStack.class).get(0));
    }
}
