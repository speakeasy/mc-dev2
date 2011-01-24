package net.minecraft.server;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class EntityPlayerMP extends EntityPlayer implements ICrafting {

    public NetServerHandler a;
    public MinecraftServer b;
    public ItemInWorldManager c;
    public double d;
    public double e;
    public List f = new LinkedList();
    public Set ak = new HashSet();
    public double al;
    private int bD = -99999999;
    private int bE = 60;
    private ItemStack[] bF = new ItemStack[] { null, null, null, null, null};
    private int bG = 0;
    public boolean am;

    public EntityPlayerMP(MinecraftServer minecraftserver, World world, String s, ItemInWorldManager iteminworldmanager) {
        super(world);
        int i = world.m;
        int j = world.o;
        int k = world.n;

        if (!world.q.e) {
            i += this.W.nextInt(20) - 10;
            k = world.e(i, j);
            j += this.W.nextInt(20) - 10;
        }

        this.c((double) i + 0.5D, (double) k, (double) j + 0.5D, 0.0F, 0.0F);
        this.b = minecraftserver;
        this.S = 0.0F;
        iteminworldmanager.a = this;
        this.aw = s;
        this.c = iteminworldmanager;
        this.H = 0.0F;
    }

    public void l() {
        this.ap.a((ICrafting) this);
    }

    public ItemStack[] I() {
        return this.bF;
    }

    public void b_() {
        --this.bE;
        this.ap.a();

        for (int i = 0; i < 5; ++i) {
            ItemStack itemstack = this.a(i);

            if (itemstack != this.bF[i]) {
                this.b.k.a(this, new Packet5PlayerInventory(this.g, i, itemstack));
                this.bF[i] = itemstack;
            }
        }
    }

    public ItemStack a(int i) {
        return i == 0 ? this.an.e() : this.an.b[i - 1];
    }

    public void f(Entity entity) {
        this.an.h();
    }

    public boolean a(Entity entity, int i) {
        if (this.bE > 0) {
            return false;
        } else {
            if (!this.b.n) {
                if (entity instanceof EntityPlayer) {
                    return false;
                }

                if (entity instanceof EntityArrow) {
                    EntityArrow entityarrow = (EntityArrow) entity;

                    if (entityarrow.b instanceof EntityPlayer) {
                        return false;
                    }
                }
            }

            return super.a(entity, i);
        }
    }

    public void d(int i) {
        super.d(i);
    }

    public void n() {
        super.b_();
        ChunkCoordIntPair chunkcoordintpair = null;
        double d1 = 0.0D;

        for (int i = 0; i < this.f.size(); ++i) {
            ChunkCoordIntPair chunkcoordintpair1 = (ChunkCoordIntPair) this.f.get(i);
            double d2 = chunkcoordintpair1.a(this);

            if (i == 0 || d2 < d1) {
                chunkcoordintpair = chunkcoordintpair1;
                d1 = chunkcoordintpair1.a(this);
            }
        }

        if (chunkcoordintpair != null) {
            boolean flag = false;

            if (d1 < 1024.0D) {
                flag = true;
            }

            if (this.a.b() < 2) {
                flag = true;
            }

            if (flag) {
                this.f.remove(chunkcoordintpair);
                this.a.b((Packet) (new Packet51MapChunk(chunkcoordintpair.a * 16, 0, chunkcoordintpair.b * 16, 16, 128, 16, this.b.e)));
                List list = this.b.e.d(chunkcoordintpair.a * 16, 0, chunkcoordintpair.b * 16, chunkcoordintpair.a * 16 + 16, 128, chunkcoordintpair.b * 16 + 16);

                for (int j = 0; j < list.size(); ++j) {
                    this.a((TileEntity) list.get(j));
                }
            }
        }

        if (this.aZ != this.bD) {
            this.a.b((Packet) (new Packet8(this.aZ)));
            this.bD = this.aZ;
        }
    }

    private void a(TileEntity tileentity) {
        if (tileentity != null) {
            Packet packet = tileentity.g();

            if (packet != null) {
                this.a.b(packet);
            }
        }
    }

    public void o() {
        this.s = this.t = this.u = 0.0D;
        this.bA = false;
        super.o();
    }

    public void c(Entity entity, int i) {
        if (!entity.G) {
            if (entity instanceof EntityItem) {
                this.b.k.a(entity, new Packet22Collect(entity.g, this.g));
            }

            if (entity instanceof EntityArrow) {
                this.b.k.a(entity, new Packet22Collect(entity.g, this.g));
            }
        }

        super.c(entity, i);
        this.ap.a();
    }

    public void K() {
        if (!this.au) {
            this.av = -1;
            this.au = true;
            this.b.k.a(this, new Packet18ArmAnimation(this, 1));
        }
    }

    public float w() {
        return 1.62F;
    }

    public void e(Entity entity) {
        super.e(entity);
        this.a.b((Packet) (new Packet39(this, this.k)));
        this.a.a(this.p, this.q, this.r, this.v, this.w);
    }

    protected void a(double d1, boolean flag) {}

    public void b(double d1, boolean flag) {
        super.a(d1, flag);
    }

    private void U() {
        this.bG = this.bG % 100 + 1;
    }

    public void a(int i, int j, int k) {
        this.U();
        this.a.b((Packet) (new Packet100(this.bG, 1, "Crafting", 9)));
        this.ap = new CraftingInventoryWorkbenchCB(this.an, this.l, i, j, k);
        this.ap.f = this.bG;
        this.ap.a((ICrafting) this);
    }

    public void a(IInventory iinventory) {
        this.U();
        this.a.b((Packet) (new Packet100(this.bG, 0, iinventory.b(), iinventory.h_())));
        this.ap = new CraftingInventoryChestCB(this.an, iinventory);
        this.ap.f = this.bG;
        this.ap.a((ICrafting) this);
    }

    public void a(TileEntityFurnace tileentityfurnace) {
        this.U();
        this.a.b((Packet) (new Packet100(this.bG, 2, tileentityfurnace.b(), tileentityfurnace.h_())));
        this.ap = new CraftingInventoryFurnaceCB(this.an, tileentityfurnace);
        this.ap.f = this.bG;
        this.ap.a((ICrafting) this);
    }

    public void a(TileEntityDispenser tileentitydispenser) {
        this.U();
        this.a.b((Packet) (new Packet100(this.bG, 3, tileentitydispenser.b(), tileentitydispenser.h_())));
        this.ap = new CraftingInventoryDispenserCB(this.an, tileentitydispenser);
        this.ap.f = this.bG;
        this.ap.a((ICrafting) this);
    }

    public void a(CraftingInventoryCB craftinginventorycb, int i, ItemStack itemstack) {
        if (!(craftinginventorycb.a(i) instanceof SlotCrafting)) {
            if (!this.am) {
                this.a.b((Packet) (new Packet103(craftinginventorycb.f, i, itemstack)));
            }
        }
    }

    public void a(CraftingInventoryCB craftinginventorycb, List list) {
        this.a.b((Packet) (new Packet104(craftinginventorycb.f, list)));
        this.a.b((Packet) (new Packet103(-1, -1, this.an.i())));
    }

    public void a(CraftingInventoryCB craftinginventorycb, int i, int j) {
        this.a.b((Packet) (new Packet105(craftinginventorycb.f, i, j)));
    }

    public void a(ItemStack itemstack) {}

    public void L() {
        this.a.b((Packet) (new Packet101(this.ap.f)));
        this.N();
    }

    public void M() {
        if (!this.am) {
            this.a.b((Packet) (new Packet103(-1, -1, this.an.i())));
        }
    }

    public void N() {
        this.ap.a((EntityPlayer) this);
        this.ap = this.ao;
    }
}
