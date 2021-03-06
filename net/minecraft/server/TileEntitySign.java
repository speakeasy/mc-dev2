package net.minecraft.server;

public class TileEntitySign extends TileEntity {

    public String[] e = new String[] { "", "", "", ""};
    public int f = -1;

    public TileEntitySign() {}

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("Text1", this.e[0]);
        nbttagcompound.a("Text2", this.e[1]);
        nbttagcompound.a("Text3", this.e[2]);
        nbttagcompound.a("Text4", this.e[3]);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);

        for (int i = 0; i < 4; ++i) {
            this.e[i] = nbttagcompound.h("Text" + (i + 1));
            if (this.e[i].length() > 15) {
                this.e[i] = this.e[i].substring(0, 15);
            }
        }
    }

    public Packet g() {
        String[] astring = new String[4];

        for (int i = 0; i < 4; ++i) {
            astring[i] = this.e[i];
        }

        return new Packet130UpdateSign(this.b, this.c, this.d, astring);
    }
}
