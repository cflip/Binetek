package com.cflip.binetek.client.gui;

import com.cflip.binetek.Binetek;
import com.cflip.binetek.container.ResearchTableContainer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ResearchTableScreen extends ContainerScreen<ResearchTableContainer> {
	private static final ResourceLocation BACKGROUND_IMAGE = new ResourceLocation(Binetek.MODID, "textures/gui/research_table.png");

	public ResearchTableScreen(ResearchTableContainer screenContainer, PlayerInventory inv, ITextComponent title) {
		super(screenContainer, inv, title);
		guiLeft = 0;
		guiTop = 0;
		xSize = 176;
		ySize = 166;
	}

	@Override
	public void render(int mouseX, int mouseY, float p_render_3_) {
		renderBackground();
		super.render(mouseX, mouseY, p_render_3_);
		renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		font.drawString(title.getFormattedText(), 8, 6, 0x404040);
		font.drawString(playerInventory.getDisplayName().getFormattedText(), 8, (float)(ySize - 96 + 2), 0x404040);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		RenderSystem.color4f(1, 1, 1, 1);
		minecraft.getTextureManager().bindTexture(BACKGROUND_IMAGE);
		blit(guiLeft, (height - ySize) / 2, 0, 0, xSize, ySize);
	}
}
