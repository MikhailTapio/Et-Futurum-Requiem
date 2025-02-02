package ganymedes01.etfuturum.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.configuration.configs.ConfigFunctions;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockSilkedMushroom extends Block implements IConfigurable {

	private final Block block;

	public BlockSilkedMushroom(Block block, String str) {
		super(Material.wood);
		this.block = block;
		setHardness(0.2F);
		setStepSound(soundTypeWood);
		setBlockName(Utils.getUnlocalisedName(str + "_mushroom"));
		setCreativeTab(isEnabled() ? EtFuturum.creativeTabBlocks : null);
	}

	@Override
	protected boolean canSilkHarvest() {
		return true;
	}

	@Override
	public int quantityDropped(Random rand) {
		return Math.max(0, rand.nextInt(10) - 7);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return block.getItemDropped(meta, rand, fortune);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return block.getIcon(side, 14);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		// Icons taken from original Block
	}

	@Override
	public boolean isEnabled() {
		return ConfigFunctions.enableSilkTouchingMushrooms;
	}
}