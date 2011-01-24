package net.minecraft.server;

public class ItemFishingRod extends Item {

    public ItemFishingRod(int i) {
        super(i);
        this.bc = 64;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        if (entityplayer.aE != null) {
            int i = entityplayer.aE.d();

            itemstack.b(i);
            entityplayer.K();
        } else {
            world.a(entityplayer, "random.bow", 0.5F, 0.4F / (b.nextFloat() * 0.4F + 0.8F));
            if (!world.z) {
                world.a((Entity) (new EntityFish(world, entityplayer)));
            }

            entityplayer.K();
        }

        return itemstack;
    }
}
