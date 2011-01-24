package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Packet60 extends Packet {

    public double a;
    public double b;
    public double c;
    public float d;
    public Set e;

    public Packet60() {}

    public Packet60(double d1, double d2, double d3, float f1, Set set) {
        this.a = d1;
        this.b = d2;
        this.c = d3;
        this.d = f1;
        this.e = new HashSet(set);
    }

    public void a(DataInputStream datainputstream) {
        this.a = datainputstream.readDouble();
        this.b = datainputstream.readDouble();
        this.c = datainputstream.readDouble();
        this.d = datainputstream.readFloat();
        int i = datainputstream.readInt();

        this.e = new HashSet();
        int j = (int) this.a;
        int k = (int) this.b;
        int l = (int) this.c;

        for (int i1 = 0; i1 < i; ++i1) {
            int j1 = datainputstream.readByte() + j;
            int k1 = datainputstream.readByte() + k;
            int l1 = datainputstream.readByte() + l;

            this.e.add(new ChunkPosition(j1, k1, l1));
        }
    }

    public void a(DataOutputStream dataoutputstream) {
        dataoutputstream.writeDouble(this.a);
        dataoutputstream.writeDouble(this.b);
        dataoutputstream.writeDouble(this.c);
        dataoutputstream.writeFloat(this.d);
        dataoutputstream.writeInt(this.e.size());
        int i = (int) this.a;
        int j = (int) this.b;
        int k = (int) this.c;
        Iterator iterator = this.e.iterator();

        while (iterator.hasNext()) {
            ChunkPosition chunkposition = (ChunkPosition) iterator.next();
            int l = chunkposition.a - i;
            int i1 = chunkposition.b - j;
            int j1 = chunkposition.c - k;

            dataoutputstream.writeByte(l);
            dataoutputstream.writeByte(i1);
            dataoutputstream.writeByte(j1);
        }
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 32 + this.e.size() * 3;
    }
}
