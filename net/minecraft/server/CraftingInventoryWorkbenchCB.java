package net.minecraft.server;

public class CraftingInventoryWorkbenchCB extends CraftingInventoryCB {

    public InventoryCrafting a = new InventoryCrafting(this, 3, 3);
    public IInventory b = new InventoryCraftResult();
    private World c;
    private int h;
    private int i;
    private int j;

    public CraftingInventoryWorkbenchCB(InventoryPlayer inventoryplayer, World world, int i, int j, int k) {
        this.c = world;
        this.h = i;
        this.i = j;
        this.j = k;
        this.a((Slot) (new SlotCrafting(this.a, this.b, 0, 124, 35)));

        int l;
        int i1;

        for (l = 0; l < 3; ++l) {
            for (i1 = 0; i1 < 3; ++i1) {
                this.a(new Slot(this.a, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
            }
        }

        for (l = 0; l < 3; ++l) {
            for (i1 = 0; i1 < 9; ++i1) {
                this.a(new Slot(inventoryplayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
            }
        }

        for (l = 0; l < 9; ++l) {
            this.a(new Slot(inventoryplayer, l, 8 + l * 18, 142));
        }

        this.a((IInventory) this.a);
    }

    public void a(IInventory iinventory) {
        int[] aint = new int[9];

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int k = i + j * 3;
                ItemStack itemstack = this.a.a(k);

                if (itemstack == null) {
                    aint[k] = -1;
                } else {
                    aint[k] = itemstack.c;
                }
            }
        }

        this.b.a(0, CraftingManager.a().a(aint));
    }

    public void a(EntityPlayer entityplayer) {
        super.a(entityplayer);

        for (int i = 0; i < 9; ++i) {
            ItemStack itemstack = this.a.a(i);

            if (itemstack != null) {
                entityplayer.b(itemstack);
            }
        }
    }

    public boolean b(EntityPlayer entityplayer) {
        return this.c.a(this.h, this.i, this.j) != Block.ay.bh ? false : entityplayer.d((double) this.h + 0.5D, (double) this.i + 0.5D, (double) this.j + 0.5D) <= 64.0D;
    }
}
