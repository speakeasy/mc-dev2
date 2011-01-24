package net.minecraft.server;

public class BlockNote extends BlockContainer {

    public BlockNote(int i) {
        super(i, 74, Material.c);
    }

    public int a(int i) {
        return this.bh;
    }

    public void b(World world, int i, int j, int k, int l) {
        if (l > 0 && Block.m[l].c()) {
            boolean flag = world.o(i, j, k);
            TileEntityNote tileentitynote = (TileEntityNote) world.m(i, j, k);

            if (tileentitynote.f != flag) {
                if (flag) {
                    tileentitynote.a(world, i, j, k);
                }

                tileentitynote.f = flag;
            }
        }
    }

    public boolean a(World world, int i, int j, int k, EntityPlayer entityplayer) {
        if (world.z) {
            return true;
        } else {
            TileEntityNote tileentitynote = (TileEntityNote) world.m(i, j, k);

            tileentitynote.a();
            tileentitynote.a(world, i, j, k);
            return true;
        }
    }

    public void b(World world, int i, int j, int k, EntityPlayer entityplayer) {
        if (!world.z) {
            TileEntityNote tileentitynote = (TileEntityNote) world.m(i, j, k);

            tileentitynote.a(world, i, j, k);
        }
    }

    protected TileEntity a_() {
        return new TileEntityNote();
    }

    public void a(World world, int i, int j, int k, int l, int i1) {
        float f1 = (float) Math.pow(2.0D, (double) (i1 - 12) / 12.0D);
        String s = "harp";

        if (l == 1) {
            s = "bd";
        }

        if (l == 2) {
            s = "snare";
        }

        if (l == 3) {
            s = "hat";
        }

        if (l == 4) {
            s = "bassattack";
        }

        world.a((double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, "note." + s, 3.0F, f1);
        world.a("note", (double) i + 0.5D, (double) j + 1.2D, (double) k + 0.5D, (double) i1 / 24.0D, 0.0D, 0.0D);
    }
}
