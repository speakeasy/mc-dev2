package net.minecraft.server;

public class InventoryLargeChest implements IInventory {

    private String a;
    private IInventory b;
    private IInventory c;

    public InventoryLargeChest(String s, IInventory iinventory, IInventory iinventory1) {
        this.a = s;
        this.b = iinventory;
        this.c = iinventory1;
    }

    public int a() {
        return this.b.a() + this.c.a();
    }

    public String b() {
        return this.a;
    }

    public ItemStack a(int i) {
        return i >= this.b.a() ? this.c.a(i - this.b.a()) : this.b.a(i);
    }

    public ItemStack a(int i, int j) {
        return i >= this.b.a() ? this.c.a(i - this.b.a(), j) : this.b.a(i, j);
    }

    public void a(int i, ItemStack itemstack) {
        if (i >= this.b.a()) {
            this.c.a(i - this.b.a(), itemstack);
        } else {
            this.b.a(i, itemstack);
        }
    }

    public int c() {
        return this.b.c();
    }

    public void d() {
        this.b.d();
        this.c.d();
    }

    public boolean a_(EntityPlayer entityplayer) {
        return this.b.a_(entityplayer) && this.c.a_(entityplayer);
    }
}
