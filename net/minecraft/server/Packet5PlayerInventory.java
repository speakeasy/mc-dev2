package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet5PlayerInventory extends Packet {

    public int a;
    public int b;
    public int c;
    public int d;

    public Packet5PlayerInventory() {}

    public Packet5PlayerInventory(int i, int j, ItemStack itemstack) {
        this.a = i;
        this.b = j;
        if (itemstack == null) {
            this.c = -1;
            this.d = 0;
        } else {
            this.c = itemstack.c;
            this.d = itemstack.h();
        }
    }

    public void a(DataInputStream datainputstream) {
        this.a = datainputstream.readInt();
        this.b = datainputstream.readShort();
        this.c = datainputstream.readShort();
        this.d = datainputstream.readShort();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(this.a);
        dataoutputstream.writeShort(this.b);
        dataoutputstream.writeShort(this.c);
        dataoutputstream.writeShort(this.d);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 8;
    }
}
