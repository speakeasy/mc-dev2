package net.minecraft.server;

public class ItemSnowball extends Item {

    public ItemSnowball(int i) {
        super(i);
        this.aX = 16;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        --itemstack.a;
        world.a(entityplayer, "random.bow", 0.5F, 0.4F / (b.nextFloat() * 0.4F + 0.8F));
        world.a((Entity) (new EntitySnowball(world, entityplayer)));
        return itemstack;
    }
}
