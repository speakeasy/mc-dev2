package net.minecraft.server;

public class CraftingInventoryPlayerCB extends CraftingInventoryCB {

    public InventoryCrafting a;
    public IInventory b;
    public boolean c;

    public CraftingInventoryPlayerCB(InventoryPlayer inventoryplayer) {
        this(inventoryplayer, true);
    }

    public CraftingInventoryPlayerCB(InventoryPlayer inventoryplayer, boolean flag) {
        this.a = new InventoryCrafting(this, 2, 2);
        this.b = new InventoryCraftResult();
        this.c = false;
        this.c = flag;
        this.a((Slot) (new SlotCrafting(this.a, this.b, 0, 144, 36)));

        int i;
        int j;

        for (i = 0; i < 2; ++i) {
            for (j = 0; j < 2; ++j) {
                this.a(new Slot(this.a, j + i * 2, 88 + j * 18, 26 + i * 18));
            }
        }

        for (i = 0; i < 4; ++i) {
            this.a((Slot) (new SlotArmor(this, inventoryplayer, inventoryplayer.a() - 1 - i, 8, 8 + i * 18, i)));
        }

        for (i = 0; i < 3; ++i) {
            for (j = 0; j < 9; ++j) {
                this.a(new Slot(inventoryplayer, j + (i + 1) * 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.a(new Slot(inventoryplayer, i, 8 + i * 18, 142));
        }

        this.a((IInventory) this.a);
    }

    public void a(IInventory iinventory) {
        int[] aint = new int[9];

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int k = -1;

                if (i < 2 && j < 2) {
                    ItemStack itemstack = this.a.a(i + j * 2);

                    if (itemstack != null) {
                        k = itemstack.c;
                    }
                }

                aint[i + j * 3] = k;
            }
        }

        this.b.a(0, CraftingManager.a().a(aint));
    }

    public void a(EntityPlayer entityplayer) {
        super.a(entityplayer);

        for (int i = 0; i < 4; ++i) {
            ItemStack itemstack = this.a.a(i);

            if (itemstack != null) {
                entityplayer.b(itemstack);
                this.a.a(i, (ItemStack) null);
            }
        }
    }

    public boolean b(EntityPlayer entityplayer) {
        return true;
    }
}
