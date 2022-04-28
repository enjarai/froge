package nl.enjarai.froge.blocks;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import nl.enjarai.froge.FrogeMod;

import static net.devtech.arrp.json.blockstate.JState.*;

public class ModBlocks {
    private static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(FrogeMod.id("froge"));

    public static final Block FROGE = registerFroge("froge");

    public static void register() {
        RRPCallback.AFTER_VANILLA.register(a -> a.add(RESOURCE_PACK));
    }

    private static Block registerFroge(String name) {
        Identifier id = FrogeMod.id(name);
        Identifier modelId = FrogeMod.id("block/" + name);

        RESOURCE_PACK.addBlockState(state(
                variant()
                        .put(HorizontalFacingBlock.FACING.getName(), Direction.NORTH, model(modelId).y(0))
                        .put(HorizontalFacingBlock.FACING.getName(), Direction.EAST, model(modelId).y(90))
                        .put(HorizontalFacingBlock.FACING.getName(), Direction.SOUTH, model(modelId).y(180))
                        .put(HorizontalFacingBlock.FACING.getName(), Direction.WEST, model(modelId).y(270))
        ), id);

        Block block = Registry.register(Registry.BLOCK, id, new FrogeBlock(
                FabricBlockSettings.of(Material.WOOL).strength(0.25F).nonOpaque()));
        Registry.register(Registry.ITEM, id, new BlockItem(block,
                new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        return block;
    }
}
