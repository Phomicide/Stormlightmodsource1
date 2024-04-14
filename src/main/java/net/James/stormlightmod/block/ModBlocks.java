package net.James.stormlightmod.block;

import net.James.stormlightmod.Stormlightmod;
import net.James.stormlightmod.item.StormlightItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
                DeferredRegister.create(ForgeRegistries.BLOCKS, Stormlightmod.MODID);


    public static final RegistryObject<Block> STONE_SPREN = registerBlock("stone_spren",
            ()->new DropExperienceBlock(UniformInt.of(3,6), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                                .sound(SoundType.AMETHYST).strength(2f).requiresCorrectToolForDrops()));
            //()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> SHARD_BLOCK = registerBlock("shard_block",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return StormlightItems.ITEMS.register(name, ()-> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
