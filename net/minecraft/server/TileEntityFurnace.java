package net.minecraft.server;

public class TileEntityFurnace extends TileEntity implements IInventory {

    private ItemStack[] e = new ItemStack[3];
    private int f = 0;
    private int g = 0;
    private int h = 0;

    public TileEntityFurnace() {}

    public int a() {
        return this.e.length;
    }

    public ItemStack a(int i) {
        return this.e[i];
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.k("Items");

        this.e = new ItemStack[this.a()];

        for (int i = 0; i < nbttaglist.b(); ++i) {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.a(i);
            byte b1 = nbttagcompound1.b("Slot");

            if (b1 >= 0 && b1 < this.e.length) {
                this.e[b1] = new ItemStack(nbttagcompound1);
            }
        }

        this.f = nbttagcompound.c("BurnTime");
        this.h = nbttagcompound.c("CookTime");
        this.g = this.a(this.e[1]);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("BurnTime", (short) this.f);
        nbttagcompound.a("CookTime", (short) this.h);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.e.length; ++i) {
            if (this.e[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                nbttagcompound1.a("Slot", (byte) i);
                this.e[i].a(nbttagcompound1);
                nbttaglist.a((NBTBase) nbttagcompound1);
            }
        }

        nbttagcompound.a("Items", (NBTBase) nbttaglist);
    }

    public int d() {
        return 64;
    }

    public boolean e() {
        return this.f > 0;
    }

    public void b() {
        boolean flag = this.f > 0;
        boolean flag1 = false;

        if (this.f > 0) {
            --this.f;
        }

        if (!this.a.z) {
            if (this.f == 0 && this.g()) {
                this.g = this.f = this.a(this.e[1]);
                if (this.f > 0) {
                    flag1 = true;
                    if (this.e[1] != null) {
                        --this.e[1].a;
                        if (this.e[1].a == 0) {
                            this.e[1] = null;
                        }
                    }
                }
            }

            if (this.e() && this.g()) {
                ++this.h;
                if (this.h == 200) {
                    this.h = 0;
                    this.f();
                    flag1 = true;
                }
            } else {
                this.h = 0;
            }

            if (flag != this.f > 0) {
                flag1 = true;
                BlockFurnace.a(this.f > 0, this.a, this.b, this.c, this.d);
            }
        }

        if (flag1) {
            this.c();
        }
    }

    private boolean g() {
        if (this.e[0] == null) {
            return false;
        } else {
            int i = this.b(this.e[0].a().aW);

            return i < 0 ? false : (this.e[2] == null ? true : (this.e[2].c != i ? false : (this.e[2].a < this.d() && this.e[2].a < this.e[2].b() ? true : this.e[2].a < Item.c[i].a())));
        }
    }

    public void f() {
        if (this.g()) {
            int i = this.b(this.e[0].a().aW);

            if (this.e[2] == null) {
                this.e[2] = new ItemStack(i, 1);
            } else if (this.e[2].c == i) {
                ++this.e[2].a;
            }

            --this.e[0].a;
            if (this.e[0].a <= 0) {
                this.e[0] = null;
            }
        }
    }

    private int b(int i) {
        return i == Block.H.bh ? Item.m.aW : (i == Block.G.bh ? Item.n.aW : (i == Block.aw.bh ? Item.l.aW : (i == Block.E.bh ? Block.M.bh : (i == Item.ao.aW ? Item.ap.aW : (i == Item.aS.aW ? Item.aT.aW : (i == Block.w.bh ? Block.t.bh : (i == Item.aG.aW ? Item.aF.aW : -1)))))));
    }

    private int a(ItemStack itemstack) {
        if (itemstack == null) {
            return 0;
        } else {
            int i = itemstack.a().aW;

            return i < 256 && Block.m[i].bs == Material.c ? 300 : (i == Item.B.aW ? 100 : (i == Item.k.aW ? 1600 : (i == Item.aw.aW ? 20000 : 0)));
        }
    }
}
