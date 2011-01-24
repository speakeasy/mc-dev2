package net.minecraft.server;

public class EntityCow extends EntityAnimals {

    public boolean a = false;

    public EntityCow(World world) {
        super(world);
        this.aQ = "/mob/cow.png";
        this.a(0.9F, 1.3F);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    protected String d() {
        return "mob.cow";
    }

    protected String e() {
        return "mob.cowhurt";
    }

    protected String f() {
        return "mob.cowhurt";
    }

    protected float h() {
        return 0.4F;
    }

    protected int g() {
        return Item.aD.aW;
    }

    public boolean a(EntityPlayer entityplayer) {
        ItemStack itemstack = entityplayer.an.e();

        if (itemstack != null && itemstack.c == Item.au.aW) {
            entityplayer.an.a(entityplayer.an.c, new ItemStack(Item.aE));
            return true;
        } else {
            return false;
        }
    }
}
