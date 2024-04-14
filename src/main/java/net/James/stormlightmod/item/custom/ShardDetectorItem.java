package net.James.stormlightmod.item.custom;

import net.James.stormlightmod.block.ModBlocks;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class ShardDetectorItem extends Item {
    public ShardDetectorItem(Properties pProperties){
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            Boolean foundBlock = false;
            for (int i = 0; i<= positionClicked.getY()+64;i++){
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));
                if(isStoneSpren(state)){
                    outputStoneSprenCoordinates(positionClicked.below(i),player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock){
                player.sendSystemMessage(Component.literal("No Shards found"));
            }
        }
        pContext.getItemInHand().hurtAndBreak(1,pContext.getPlayer(),player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputStoneSprenCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found "+ I18n.get(block.getDescriptionId())+" at "+
                    "("+blockPos.getX()+", "+blockPos.getY()+", "+blockPos.getZ()+")"));
    }

    private boolean isStoneSpren(BlockState state) {
        return state.is(ModBlocks.STONE_SPREN.getKey())|| state.is(Blocks.DIAMOND_ORE);
    }
}
