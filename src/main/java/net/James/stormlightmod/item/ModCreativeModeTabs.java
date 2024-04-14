package net.James.stormlightmod.item;

import net.James.stormlightmod.Stormlightmod;
import net.James.stormlightmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS=
                DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Stormlightmod.MODID);

    public static final RegistryObject<CreativeModeTab> STORMLIGHTMOD_TAB = CREATIVE_MODE_TABS.register("stormlightmod_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(StormlightItems.SprenShard.get()))
                    .title(Component.translatable("creativetab.stormlightmod_tab"))
                    .displayItems((pParameters, pOutput) -> { //below is manual code for each item. I don't entirely understand the code here
                        for(RegistryObject<net.minecraft.world.item.Item> Item : StormlightItems.ITEMS.getEntries()) {
                            pOutput.accept(Item.get());
                        }
                        pOutput.accept(ModBlocks.STONE_SPREN.get());
                        pOutput.accept(ModBlocks.SHARD_BLOCK.get());
                        pOutput.accept(StormlightItems.SprenShard.get());
                        pOutput.accept(StormlightItems.SprenInRock.get());
                        pOutput.accept(StormlightItems.ShardDetector.get());
                    })
                    .build());
                /*.displayItems((pParameters, pOutput) ->{
                        pOutput.accept(StormlightItems.SprenShard.get());
                        pOutput.accept(StormlightItems.SprenInRock.get());
                    })
                    .build());
                    */
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
