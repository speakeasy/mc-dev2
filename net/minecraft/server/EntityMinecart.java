package net.minecraft.server;

import java.util.List;

public class EntityMinecart extends Entity implements IInventory {

    private ItemStack[] aj;
    public int a;
    public int b;
    public int c;
    private boolean ak;
    public int d;
    public int e;
    public double f;
    public double ai;
    private static final int[][][] al = new int[][][] { { { 0, 0, -1}, { 0, 0, 1}}, { { -1, 0, 0}, { 1, 0, 0}}, { { -1, -1, 0}, { 1, 0, 0}}, { { -1, 0, 0}, { 1, -1, 0}}, { { 0, 0, -1}, { 0, -1, 1}}, { { 0, -1, -1}, { 0, 0, 1}}, { { 0, 0, 1}, { 1, 0, 0}}, { { 0, 0, 1}, { -1, 0, 0}}, { { 0, 0, -1}, { -1, 0, 0}}, { { 0, 0, -1}, { 1, 0, 0}}};
    private int am;
    private double an;
    private double ao;
    private double ap;
    private double aq;
    private double ar;

    public EntityMinecart(World world) {
        super(world);
        this.aj = new ItemStack[36];
        this.a = 0;
        this.b = 0;
        this.c = 1;
        this.ak = false;
        this.i = true;
        this.a(0.98F, 0.7F);
        this.G = this.I / 2.0F;
        this.L = false;
    }

    public AxisAlignedBB d(Entity entity) {
        return entity.z;
    }

    public AxisAlignedBB q() {
        return null;
    }

    public boolean u() {
        return true;
    }

    public EntityMinecart(World world, double d1, double d2, double d3, int i) {
        this(world);
        this.a(d1, d2 + (double) this.G, d3);
        this.s = 0.0D;
        this.t = 0.0D;
        this.u = 0.0D;
        this.m = d1;
        this.n = d2;
        this.o = d3;
        this.d = i;
    }

    public double j() {
        return (double) this.I * 0.0D - 0.30000001192092896D;
    }

    public boolean a(Entity entity, int i) {
        if (this.l.z) {
            return true;
        } else {
            this.c = -this.c;
            this.b = 10;
            this.a += i * 10;
            if (this.a > 40) {
                this.a(Item.ax.aW, 1, 0.0F);
                if (this.d == 1) {
                    this.a(Block.au.bh, 1, 0.0F);
                } else if (this.d == 2) {
                    this.a(Block.aB.bh, 1, 0.0F);
                }

                this.l();
            }

            return true;
        }
    }

    public boolean c_() {
        return !this.F;
    }

    public void l() {
        for (int i = 0; i < this.a(); ++i) {
            ItemStack itemstack = this.a(i);

            if (itemstack != null) {
                float f1 = this.V.nextFloat() * 0.8F + 0.1F;
                float f2 = this.V.nextFloat() * 0.8F + 0.1F;
                float f3 = this.V.nextFloat() * 0.8F + 0.1F;

                while (itemstack.a > 0) {
                    int j = this.V.nextInt(21) + 10;

                    if (j > itemstack.a) {
                        j = itemstack.a;
                    }

                    itemstack.a -= j;
                    EntityItem entityitem = new EntityItem(this.l, this.p + (double) f1, this.q + (double) f2, this.r + (double) f3, new ItemStack(itemstack.c, j, itemstack.d));
                    float f4 = 0.05F;

                    entityitem.s = (double) ((float) this.V.nextGaussian() * f4);
                    entityitem.t = (double) ((float) this.V.nextGaussian() * f4 + 0.2F);
                    entityitem.u = (double) ((float) this.V.nextGaussian() * f4);
                    this.l.a((Entity) entityitem);
                }
            }
        }

        super.l();
    }

    public void b_() {
        double d1;

        if (this.l.z && this.am > 0) {
            if (this.am > 0) {
                double d2 = this.p + (this.an - this.p) / (double) this.am;
                double d3 = this.q + (this.ao - this.q) / (double) this.am;
                double d4 = this.r + (this.ap - this.r) / (double) this.am;

                for (d1 = this.aq - (double) this.v; d1 < -180.0D; d1 += 360.0D) {
                    ;
                }

                while (d1 >= 180.0D) {
                    d1 -= 360.0D;
                }

                this.v = (float) ((double) this.v + d1 / (double) this.am);
                this.w = (float) ((double) this.w + (this.ar - (double) this.w) / (double) this.am);
                --this.am;
                this.a(d2, d3, d4);
                this.b(this.v, this.w);
            } else {
                this.a(this.p, this.q, this.r);
                this.b(this.v, this.w);
            }
        } else {
            if (this.b > 0) {
                --this.b;
            }

            if (this.a > 0) {
                --this.a;
            }

            this.m = this.p;
            this.n = this.q;
            this.o = this.r;
            this.t -= 0.03999999910593033D;
            int i = MathHelper.b(this.p);
            int j = MathHelper.b(this.q);
            int k = MathHelper.b(this.r);

            if (this.l.a(i, j - 1, k) == Block.aG.bh) {
                --j;
            }

            double d5 = 0.4D;
            boolean flag = false;

            d1 = 0.0078125D;
            if (this.l.a(i, j, k) == Block.aG.bh) {
                Vec3D vec3d = this.g(this.p, this.q, this.r);
                int l = this.l.b(i, j, k);

                this.q = (double) j;
                if (l >= 2 && l <= 5) {
                    this.q = (double) (j + 1);
                }

                if (l == 2) {
                    this.s -= d1;
                }

                if (l == 3) {
                    this.s += d1;
                }

                if (l == 4) {
                    this.u += d1;
                }

                if (l == 5) {
                    this.u -= d1;
                }

                int[][] aint = al[l];
                double d6 = (double) (aint[1][0] - aint[0][0]);
                double d7 = (double) (aint[1][2] - aint[0][2]);
                double d8 = Math.sqrt(d6 * d6 + d7 * d7);
                double d9 = this.s * d6 + this.u * d7;

                if (d9 < 0.0D) {
                    d6 = -d6;
                    d7 = -d7;
                }

                double d10 = Math.sqrt(this.s * this.s + this.u * this.u);

                this.s = d10 * d6 / d8;
                this.u = d10 * d7 / d8;
                double d11 = 0.0D;
                double d12 = (double) i + 0.5D + (double) aint[0][0] * 0.5D;
                double d13 = (double) k + 0.5D + (double) aint[0][2] * 0.5D;
                double d14 = (double) i + 0.5D + (double) aint[1][0] * 0.5D;
                double d15 = (double) k + 0.5D + (double) aint[1][2] * 0.5D;

                d6 = d14 - d12;
                d7 = d15 - d13;
                double d16;
                double d17;
                double d18;

                if (d6 == 0.0D) {
                    this.p = (double) i + 0.5D;
                    d11 = this.r - (double) k;
                } else if (d7 == 0.0D) {
                    this.r = (double) k + 0.5D;
                    d11 = this.p - (double) i;
                } else {
                    d16 = this.p - d12;
                    d18 = this.r - d13;
                    d17 = (d16 * d6 + d18 * d7) * 2.0D;
                    d11 = d17;
                }

                this.p = d12 + d6 * d11;
                this.r = d13 + d7 * d11;
                this.a(this.p, this.q + (double) this.G, this.r);
                d16 = this.s;
                d18 = this.u;
                if (this.j != null) {
                    d16 *= 0.75D;
                    d18 *= 0.75D;
                }

                if (d16 < -d5) {
                    d16 = -d5;
                }

                if (d16 > d5) {
                    d16 = d5;
                }

                if (d18 < -d5) {
                    d18 = -d5;
                }

                if (d18 > d5) {
                    d18 = d5;
                }

                this.c(d16, 0.0D, d18);
                if (aint[0][1] != 0 && MathHelper.b(this.p) - i == aint[0][0] && MathHelper.b(this.r) - k == aint[0][2]) {
                    this.a(this.p, this.q + (double) aint[0][1], this.r);
                } else if (aint[1][1] != 0 && MathHelper.b(this.p) - i == aint[1][0] && MathHelper.b(this.r) - k == aint[1][2]) {
                    this.a(this.p, this.q + (double) aint[1][1], this.r);
                }

                if (this.j != null) {
                    this.s *= 0.996999979019165D;
                    this.t *= 0.0D;
                    this.u *= 0.996999979019165D;
                } else {
                    if (this.d == 2) {
                        d17 = (double) MathHelper.a(this.f * this.f + this.ai * this.ai);
                        if (d17 > 0.01D) {
                            flag = true;
                            this.f /= d17;
                            this.ai /= d17;
                            double d19 = 0.04D;

                            this.s *= 0.800000011920929D;
                            this.t *= 0.0D;
                            this.u *= 0.800000011920929D;
                            this.s += this.f * d19;
                            this.u += this.ai * d19;
                        } else {
                            this.s *= 0.8999999761581421D;
                            this.t *= 0.0D;
                            this.u *= 0.8999999761581421D;
                        }
                    }

                    this.s *= 0.9599999785423279D;
                    this.t *= 0.0D;
                    this.u *= 0.9599999785423279D;
                }

                Vec3D vec3d1 = this.g(this.p, this.q, this.r);

                if (vec3d1 != null && vec3d != null) {
                    double d20 = (vec3d.b - vec3d1.b) * 0.05D;

                    d10 = Math.sqrt(this.s * this.s + this.u * this.u);
                    if (d10 > 0.0D) {
                        this.s = this.s / d10 * (d10 + d20);
                        this.u = this.u / d10 * (d10 + d20);
                    }

                    this.a(this.p, vec3d1.b, this.r);
                }

                int i1 = MathHelper.b(this.p);
                int j1 = MathHelper.b(this.r);

                if (i1 != i || j1 != k) {
                    d10 = Math.sqrt(this.s * this.s + this.u * this.u);
                    this.s = d10 * (double) (i1 - i);
                    this.u = d10 * (double) (j1 - k);
                }

                if (this.d == 2) {
                    double d21 = (double) MathHelper.a(this.f * this.f + this.ai * this.ai);

                    if (d21 > 0.01D && this.s * this.s + this.u * this.u > 0.0010D) {
                        this.f /= d21;
                        this.ai /= d21;
                        if (this.f * this.s + this.ai * this.u < 0.0D) {
                            this.f = 0.0D;
                            this.ai = 0.0D;
                        } else {
                            this.f = this.s;
                            this.ai = this.u;
                        }
                    }
                }
            } else {
                if (this.s < -d5) {
                    this.s = -d5;
                }

                if (this.s > d5) {
                    this.s = d5;
                }

                if (this.u < -d5) {
                    this.u = -d5;
                }

                if (this.u > d5) {
                    this.u = d5;
                }

                if (this.A) {
                    this.s *= 0.5D;
                    this.t *= 0.5D;
                    this.u *= 0.5D;
                }

                this.c(this.s, this.t, this.u);
                if (!this.A) {
                    this.s *= 0.949999988079071D;
                    this.t *= 0.949999988079071D;
                    this.u *= 0.949999988079071D;
                }
            }

            this.w = 0.0F;
            double d22 = this.m - this.p;
            double d23 = this.o - this.r;

            if (d22 * d22 + d23 * d23 > 0.0010D) {
                this.v = (float) (Math.atan2(d23, d22) * 180.0D / 3.141592653589793D);
                if (this.ak) {
                    this.v += 180.0F;
                }
            }

            double d24;

            for (d24 = (double) (this.v - this.x); d24 >= 180.0D; d24 -= 360.0D) {
                ;
            }

            while (d24 < -180.0D) {
                d24 += 360.0D;
            }

            if (d24 < -170.0D || d24 >= 170.0D) {
                this.v += 180.0F;
                this.ak = !this.ak;
            }

            this.b(this.v, this.w);
            List list = this.l.b((Entity) this, this.z.b(0.20000000298023224D, 0.0D, 0.20000000298023224D));

            if (list != null && list.size() > 0) {
                for (int k1 = 0; k1 < list.size(); ++k1) {
                    Entity entity = (Entity) list.get(k1);

                    if (entity != this.j && entity.u() && entity instanceof EntityMinecart) {
                        entity.c((Entity) this);
                    }
                }
            }

            if (this.j != null && this.j.F) {
                this.j = null;
            }

            if (flag && this.V.nextInt(4) == 0) {
                --this.e;
                if (this.e < 0) {
                    this.f = this.ai = 0.0D;
                }

                this.l.a("largesmoke", this.p, this.q + 0.8D, this.r, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public Vec3D g(double d1, double d2, double d3) {
        int i = MathHelper.b(d1);
        int j = MathHelper.b(d2);
        int k = MathHelper.b(d3);

        if (this.l.a(i, j - 1, k) == Block.aG.bh) {
            --j;
        }

        if (this.l.a(i, j, k) == Block.aG.bh) {
            int l = this.l.b(i, j, k);

            d2 = (double) j;
            if (l >= 2 && l <= 5) {
                d2 = (double) (j + 1);
            }

            int[][] aint = al[l];
            double d4 = 0.0D;
            double d5 = (double) i + 0.5D + (double) aint[0][0] * 0.5D;
            double d6 = (double) j + 0.5D + (double) aint[0][1] * 0.5D;
            double d7 = (double) k + 0.5D + (double) aint[0][2] * 0.5D;
            double d8 = (double) i + 0.5D + (double) aint[1][0] * 0.5D;
            double d9 = (double) j + 0.5D + (double) aint[1][1] * 0.5D;
            double d10 = (double) k + 0.5D + (double) aint[1][2] * 0.5D;
            double d11 = d8 - d5;
            double d12 = (d9 - d6) * 2.0D;
            double d13 = d10 - d7;

            if (d11 == 0.0D) {
                d1 = (double) i + 0.5D;
                d4 = d3 - (double) k;
            } else if (d13 == 0.0D) {
                d3 = (double) k + 0.5D;
                d4 = d1 - (double) i;
            } else {
                double d14 = d1 - d5;
                double d15 = d3 - d7;
                double d16 = (d14 * d11 + d15 * d13) * 2.0D;

                d4 = d16;
            }

            d1 = d5 + d11 * d4;
            d2 = d6 + d12 * d4;
            d3 = d7 + d13 * d4;
            if (d12 < 0.0D) {
                ++d2;
            }

            if (d12 > 0.0D) {
                d2 += 0.5D;
            }

            return Vec3D.b(d1, d2, d3);
        } else {
            return null;
        }
    }

    protected void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.a("Type", this.d);
        if (this.d == 2) {
            nbttagcompound.a("PushX", this.f);
            nbttagcompound.a("PushZ", this.ai);
            nbttagcompound.a("Fuel", (short) this.e);
        } else if (this.d == 1) {
            NBTTagList nbttaglist = new NBTTagList();

            for (int i = 0; i < this.aj.length; ++i) {
                if (this.aj[i] != null) {
                    NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                    nbttagcompound1.a("Slot", (byte) i);
                    this.aj[i].a(nbttagcompound1);
                    nbttaglist.a((NBTBase) nbttagcompound1);
                }
            }

            nbttagcompound.a("Items", (NBTBase) nbttaglist);
        }
    }

    protected void b(NBTTagCompound nbttagcompound) {
        this.d = nbttagcompound.d("Type");
        if (this.d == 2) {
            this.f = nbttagcompound.g("PushX");
            this.ai = nbttagcompound.g("PushZ");
            this.e = nbttagcompound.c("Fuel");
        } else if (this.d == 1) {
            NBTTagList nbttaglist = nbttagcompound.k("Items");

            this.aj = new ItemStack[this.a()];

            for (int i = 0; i < nbttaglist.b(); ++i) {
                NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.a(i);
                int j = nbttagcompound1.b("Slot") & 255;

                if (j >= 0 && j < this.aj.length) {
                    this.aj[j] = new ItemStack(nbttagcompound1);
                }
            }
        }
    }

    public void c(Entity entity) {
        if (!this.l.z) {
            if (entity != this.j) {
                if (entity instanceof EntityLiving && !(entity instanceof EntityPlayer) && this.d == 0 && this.s * this.s + this.u * this.u > 0.01D && this.j == null && entity.k == null) {
                    entity.e((Entity) this);
                }

                double d1 = entity.p - this.p;
                double d2 = entity.r - this.r;
                double d3 = d1 * d1 + d2 * d2;

                if (d3 >= 9.999999747378752E-5D) {
                    d3 = (double) MathHelper.a(d3);
                    d1 /= d3;
                    d2 /= d3;
                    double d4 = 1.0D / d3;

                    if (d4 > 1.0D) {
                        d4 = 1.0D;
                    }

                    d1 *= d4;
                    d2 *= d4;
                    d1 *= 0.10000000149011612D;
                    d2 *= 0.10000000149011612D;
                    d1 *= (double) (1.0F - this.T);
                    d2 *= (double) (1.0F - this.T);
                    d1 *= 0.5D;
                    d2 *= 0.5D;
                    if (entity instanceof EntityMinecart) {
                        double d5 = entity.s + this.s;
                        double d6 = entity.u + this.u;

                        if (((EntityMinecart) entity).d == 2 && this.d != 2) {
                            this.s *= 0.20000000298023224D;
                            this.u *= 0.20000000298023224D;
                            this.f(entity.s - d1, 0.0D, entity.u - d2);
                            entity.s *= 0.699999988079071D;
                            entity.u *= 0.699999988079071D;
                        } else if (((EntityMinecart) entity).d != 2 && this.d == 2) {
                            entity.s *= 0.20000000298023224D;
                            entity.u *= 0.20000000298023224D;
                            entity.f(this.s + d1, 0.0D, this.u + d2);
                            this.s *= 0.699999988079071D;
                            this.u *= 0.699999988079071D;
                        } else {
                            d5 /= 2.0D;
                            d6 /= 2.0D;
                            this.s *= 0.20000000298023224D;
                            this.u *= 0.20000000298023224D;
                            this.f(d5 - d1, 0.0D, d6 - d2);
                            entity.s *= 0.20000000298023224D;
                            entity.u *= 0.20000000298023224D;
                            entity.f(d5 + d1, 0.0D, d6 + d2);
                        }
                    } else {
                        this.f(-d1, 0.0D, -d2);
                        entity.f(d1 / 4.0D, 0.0D, d2 / 4.0D);
                    }
                }
            }
        }
    }

    public int a() {
        return 27;
    }

    public ItemStack a(int i) {
        return this.aj[i];
    }

    public boolean a(EntityPlayer entityplayer) {
        if (this.d == 0) {
            if (this.j != null && this.j instanceof EntityPlayer && this.j != entityplayer) {
                return true;
            }

            if (!this.l.z) {
                entityplayer.e(this);
            }
        } else if (this.d == 1) {
            entityplayer.a((IInventory) this);
        } else if (this.d == 2) {
            ItemStack itemstack = entityplayer.ak.b();

            if (itemstack != null && itemstack.c == Item.k.aW) {
                if (--itemstack.a == 0) {
                    entityplayer.ak.a(entityplayer.ak.d, (ItemStack) null);
                }

                this.e += 1200;
            }

            this.f = this.p - entityplayer.p;
            this.ai = this.r - entityplayer.r;
        }

        return true;
    }
}
