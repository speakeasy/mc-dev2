package net.minecraft.server;

import java.util.Random;

public class BlockDoor extends Block {

    protected BlockDoor(int i, Material material) {
        super(i, material);
        this.bh = 97;
        if (material == Material.e) {
            ++this.bh;
        }

        float f1 = 0.5F;
        float f2 = 1.0F;

        this.a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f2, 0.5F + f1);
    }

    public boolean a() {
        return false;
    }

    public AxisAlignedBB d(World world, int i, int j, int k) {
        this.a((IBlockAccess) world, i, j, k);
        return super.d(world, i, j, k);
    }

    public void a(IBlockAccess iblockaccess, int i, int j, int k) {
        this.c(this.d(iblockaccess.b(i, j, k)));
    }

    public void c(int i) {
        float f1 = 0.1875F;

        this.a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        if (i == 0) {
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f1);
        }

        if (i == 1) {
            this.a(1.0F - f1, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        if (i == 2) {
            this.a(0.0F, 0.0F, 1.0F - f1, 1.0F, 1.0F, 1.0F);
        }

        if (i == 3) {
            this.a(0.0F, 0.0F, 0.0F, f1, 1.0F, 1.0F);
        }
    }

    public void b(World world, int i, int j, int k, EntityPlayer entityplayer) {
        this.a(world, i, j, k, entityplayer);
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        if (this.bt == Material.e) {
            return true;
        } else {
            int l = world.b(i, j, k);

            if ((l & 8) != 0) {
                if (world.a(i, j - 1, k) == this.bi) {
                    this.a(world, i, j - 1, k, entityplayer);
                }

                return true;
            } else {
                if (world.a(i, j + 1, k) == this.bi) {
                    world.c(i, j + 1, k, (l ^ 4) + 8);
                }

                world.c(i, j, k, l ^ 4);
                world.b(i, j - 1, k, i, j, k);
                if (Math.random() < 0.5D) {
                    world.a((double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, "random.door_open", 1.0F, world.l.nextFloat() * 0.1F + 0.9F);
                } else {
                    world.a((double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, "random.door_close", 1.0F, world.l.nextFloat() * 0.1F + 0.9F);
                }

                return true;
            }
        }
    }

    public void a(World world, int i, int j, int k, boolean flag) {
        int l = world.b(i, j, k);

        if ((l & 8) != 0) {
            if (world.a(i, j - 1, k) == this.bi) {
                this.a(world, i, j - 1, k, flag);
            }
        } else {
            boolean flag1 = (world.b(i, j, k) & 4) > 0;

            if (flag1 != flag) {
                if (world.a(i, j + 1, k) == this.bi) {
                    world.c(i, j + 1, k, (l ^ 4) + 8);
                }

                world.c(i, j, k, l ^ 4);
                world.b(i, j - 1, k, i, j, k);
                if (Math.random() < 0.5D) {
                    world.a((double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, "random.door_open", 1.0F, world.l.nextFloat() * 0.1F + 0.9F);
                } else {
                    world.a((double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, "random.door_close", 1.0F, world.l.nextFloat() * 0.1F + 0.9F);
                }
            }
        }
    }

    public void b(World world, int i, int j, int k, int l) {
        int i1 = world.b(i, j, k);

        if ((i1 & 8) != 0) {
            if (world.a(i, j - 1, k) != this.bi) {
                world.e(i, j, k, 0);
            }

            if (l > 0 && Block.m[l].c()) {
                this.b(world, i, j - 1, k, l);
            }
        } else {
            boolean flag = false;

            if (world.a(i, j + 1, k) != this.bi) {
                world.e(i, j, k, 0);
                flag = true;
            }

            if (!world.d(i, j - 1, k)) {
                world.e(i, j, k, 0);
                flag = true;
                if (world.a(i, j + 1, k) == this.bi) {
                    world.e(i, j + 1, k, 0);
                }
            }

            if (flag) {
                this.a_(world, i, j, k, i1);
            } else if (l > 0 && Block.m[l].c()) {
                boolean flag1 = world.p(i, j, k) || world.p(i, j + 1, k);

                this.a(world, i, j, k, flag1);
            }
        }
    }

    public int a(int i, Random random) {
        return (i & 8) != 0 ? 0 : (this.bt == Material.e ? Item.az.ba : Item.at.ba);
    }

    public MovingObjectPosition a(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1) {
        this.a((IBlockAccess) world, i, j, k);
        return super.a(world, i, j, k, vec3d, vec3d1);
    }

    public int d(int i) {
        return (i & 4) == 0 ? i - 1 & 3 : i & 3;
    }

    public boolean a(World world, int i, int j, int k) {
        return j >= 127 ? false : world.d(i, j - 1, k) && super.a(world, i, j, k) && super.a(world, i, j + 1, k);
    }
}
