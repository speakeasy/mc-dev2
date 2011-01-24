package net.minecraft.server;

public class ItemSnowball extends Item {

    public ItemSnowball(int i) {
        super(i);
        this.bb = 16;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        --itemstack.a;
        world.a(entityplayer, "random.bow", 0.5F, 0.4F / (b.nextFloat() * 0.4F + 0.8F));
        if (!world.z) {
            world.a((Entity) (new EntitySnowball(world, entityplayer)));
        }

        return itemstack;
    }
}
