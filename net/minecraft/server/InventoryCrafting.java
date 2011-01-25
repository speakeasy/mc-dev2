package net.minecraft.server;

public class InventoryCrafting implements IInventory {

    private ItemStack[] a;
    private int b;
    private Container c;

    public InventoryCrafting(Container container, int i, int j) {
        int k = i * j;

        this.a = new ItemStack[k];
        this.c = container;
        this.b = i;
    }

    public int h_() {
        return this.a.length;
    }

    public ItemStack a(int i) {
        return i >= this.h_() ? null : this.a[i];
    }

    public ItemStack a(int i, int j) {
        if (i >= 0 && i < this.b) {
            int k = i + j * this.b;

            return this.a(k);
        } else {
            return null;
        }
    }

    public String b() {
        return "Crafting";
    }

    public ItemStack b(int i, int j) {
        if (this.a[i] != null) {
            ItemStack itemstack;

            if (this.a[i].a <= j) {
                itemstack = this.a[i];
                this.a[i] = null;
                this.c.a((IInventory) this);
                return itemstack;
            } else {
                itemstack = this.a[i].a(j);
                if (this.a[i].a == 0) {
                    this.a[i] = null;
                }

                this.c.a((IInventory) this);
                return itemstack;
            }
        } else {
            return null;
        }
    }

    public void a(int i, ItemStack itemstack) {
        this.a[i] = itemstack;
        this.c.a((IInventory) this);
    }

    public int c() {
        return 64;
    }

    public void d() {}

    public boolean a_(EntityPlayer entityplayer) {
        return true;
    }
}
