package mysticgemstones.mysticgemstones.item;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RawStarstone extends Item {

    public RawStarstone(Settings settings) {
        super(settings);
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if (world.getTimeOfDay() > 22350 || world.getTimeOfDay() < 21980) {
            setItemModel(0.0F);
            stack.setCount(stack.getCount() - 1);
            BlockPos pos = entity.getBlockPos();
            Block.dropStack(world, pos, new ItemStack(MysticGemstonesItem.STARSTONE_DUST));
        }
        else {
            setItemModel(1.0F);
        }
    }

    public void setItemModel(float number) {
        FabricModelPredicateProviderRegistry.register(MysticGemstonesItem.RAW_STARSTONE,
                new Identifier("shining"), (itemStack, clientWorld, livingEntity, hmmmm) -> number);
    }
}
