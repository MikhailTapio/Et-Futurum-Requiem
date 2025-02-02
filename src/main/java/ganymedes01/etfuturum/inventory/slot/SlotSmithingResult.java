package ganymedes01.etfuturum.inventory.slot;

import ganymedes01.etfuturum.core.utils.Utils;
import ganymedes01.etfuturum.inventory.ContainerSmithingTable;
import ganymedes01.etfuturum.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotSmithingResult extends Slot {
    private final ContainerSmithingTable container;
    public SlotSmithingResult(ContainerSmithingTable container, IInventory inv, int index, int x, int y) {
        super(inv, index, x, y);
        this.container = container;
    }

    @Override
    public boolean isItemValid(ItemStack s) {
        return false;
    }

    @Override
    public boolean canTakeStack(EntityPlayer player) {
        return getHasStack();
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
        final ItemStack applicant = container.inputSlots.getStackInSlot(0);
        applicant.stackSize--;
        container.inputSlots.setInventorySlotContents(0,(applicant.stackSize > 0) ? applicant : null);
        final ItemStack ingot = container.inputSlots.getStackInSlot(1);
        ingot.stackSize--;
        container.inputSlots.setInventorySlotContents(1, (ingot.stackSize > 0) ? ingot : null);
        player.playSound(Reference.MOD_ID + ":use.smithingTable", 1F, 1F);
    }
}
