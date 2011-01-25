package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet102WindowClick extends Packet {

    public int a;
    public int b;
    public int c;
    public short d;
    public ItemStack e;

    public Packet102WindowClick() {}

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public void a(DataInputStream datainputstream) {
        this.a = datainputstream.readByte();
        this.b = datainputstream.readShort();
        this.c = datainputstream.readByte();
        this.d = datainputstream.readShort();
        short short1 = datainputstream.readShort();

        if (short1 >= 0) {
            byte b1 = datainputstream.readByte();
            short short2 = datainputstream.readShort();

            this.e = new ItemStack(short1, b1, short2);
        } else {
            this.e = null;
        }
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeByte(this.a);
        dataoutputstream.writeShort(this.b);
        dataoutputstream.writeByte(this.c);
        dataoutputstream.writeShort(this.d);
        if (this.e == null) {
            dataoutputstream.writeShort(-1);
        } else {
            dataoutputstream.writeShort(this.e.c);
            dataoutputstream.writeByte(this.e.a);
            dataoutputstream.writeShort(this.e.h());
        }
    }

    public int a() {
        return 11;
    }
}
