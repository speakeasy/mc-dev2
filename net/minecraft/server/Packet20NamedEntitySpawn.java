package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet20NamedEntitySpawn extends Packet {

    public int a;
    public String b;
    public int c;
    public int d;
    public int e;
    public byte f;
    public byte g;
    public int h;

    public Packet20NamedEntitySpawn() {}

    public Packet20NamedEntitySpawn(EntityPlayer entityplayer) {
        this.a = entityplayer.c;
        this.b = entityplayer.aq;
        this.c = MathHelper.b(entityplayer.l * 32.0D);
        this.d = MathHelper.b(entityplayer.m * 32.0D);
        this.e = MathHelper.b(entityplayer.n * 32.0D);
        this.f = (byte) ((int) (entityplayer.r * 256.0F / 360.0F));
        this.g = (byte) ((int) (entityplayer.s * 256.0F / 360.0F));
        ItemStack itemstack = entityplayer.aj.b();

        this.h = itemstack == null ? 0 : itemstack.c;
    }

    public void a(DataInputStream datainputstream) {
        this.a = datainputstream.readInt();
        this.b = datainputstream.readUTF();
        this.c = datainputstream.readInt();
        this.d = datainputstream.readInt();
        this.e = datainputstream.readInt();
        this.f = datainputstream.readByte();
        this.g = datainputstream.readByte();
        this.h = datainputstream.readShort();
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeInt(this.a);
        dataoutputstream.writeUTF(this.b);
        dataoutputstream.writeInt(this.c);
        dataoutputstream.writeInt(this.d);
        dataoutputstream.writeInt(this.e);
        dataoutputstream.writeByte(this.f);
        dataoutputstream.writeByte(this.g);
        dataoutputstream.writeShort(this.h);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 28;
    }
}
