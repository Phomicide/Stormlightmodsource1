package net.James.stormlightmod.item;

import net.James.stormlightmod.Stormlightmod;
import net.James.stormlightmod.item.custom.ShardDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StormlightItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Stormlightmod.MODID);


    public static final RegistryObject<Item> SprenShard = ITEMS.register("sprenshard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SprenInRock = ITEMS.register("rock_spren",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ShardDetector = ITEMS.register("shard_detector",
            ()-> new ShardDetectorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
