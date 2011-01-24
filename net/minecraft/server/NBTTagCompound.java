package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NBTTagCompound extends NBTBase {

    private Map a = new HashMap();

    public NBTTagCompound() {}

    void a(DataOutput dataoutput) {
        Iterator iterator = this.a.values().iterator();

        while (iterator.hasNext()) {
            NBTBase nbtbase = (NBTBase) iterator.next();

            NBTBase.a(nbtbase, dataoutput);
        }

        dataoutput.writeByte(0);
    }

    void a(DataInput datainput) {
        this.a.clear();

        NBTBase nbtbase;

        while ((nbtbase = NBTBase.b(datainput)).a() != 0) {
            this.a.put(nbtbase.c(), nbtbase);
        }
    }

    public byte a() {
        return (byte) 10;
    }

    public void a(String s, NBTBase nbtbase) {
        this.a.put(s, nbtbase.m(s));
    }

    public void a(String s, byte b1) {
        this.a.put(s, (new NBTTagByte(b1)).m(s));
    }

    public void a(String s, short short1) {
        this.a.put(s, (new NBTTagShort(short1)).m(s));
    }

    public void a(String s, int i) {
        this.a.put(s, (new NBTTagInt(i)).m(s));
    }

    public void a(String s, long i) {
        this.a.put(s, (new NBTTagLong(i)).m(s));
    }

    public void a(String s, float f1) {
        this.a.put(s, (new NBTTagFloat(f1)).m(s));
    }

    public void a(String s, double d1) {
        this.a.put(s, (new NBTTagDouble(d1)).m(s));
    }

    public void a(String s, String s1) {
        this.a.put(s, (new NBTTagString(s1)).m(s));
    }

    public void a(String s, byte[] abyte) {
        this.a.put(s, (new NBTTagByteArray(abyte)).m(s));
    }

    public void a(String s, NBTTagCompound nbttagcompound) {
        this.a.put(s, nbttagcompound.m(s));
    }

    public void a(String s, boolean flag) {
        this.a(s, (byte) (flag ? 1 : 0));
    }

    public boolean a(String s) {
        return this.a.containsKey(s);
    }

    public byte b(String s) {
        return !this.a.containsKey(s) ? 0 : ((NBTTagByte) this.a.get(s)).a;
    }

    public short c(String s) {
        return !this.a.containsKey(s) ? 0 : ((NBTTagShort) this.a.get(s)).a;
    }

    public int d(String s) {
        return !this.a.containsKey(s) ? 0 : ((NBTTagInt) this.a.get(s)).a;
    }

    public long e(String s) {
        return !this.a.containsKey(s) ? 0L : ((NBTTagLong) this.a.get(s)).a;
    }

    public float f(String s) {
        return !this.a.containsKey(s) ? 0.0F : ((NBTTagFloat) this.a.get(s)).a;
    }

    public double g(String s) {
        return !this.a.containsKey(s) ? 0.0D : ((NBTTagDouble) this.a.get(s)).a;
    }

    public String h(String s) {
        return !this.a.containsKey(s) ? "" : ((NBTTagString) this.a.get(s)).a;
    }

    public byte[] i(String s) {
        return !this.a.containsKey(s) ? new byte[0] : ((NBTTagByteArray) this.a.get(s)).a;
    }

    public NBTTagCompound j(String s) {
        return !this.a.containsKey(s) ? new NBTTagCompound() : (NBTTagCompound) this.a.get(s);
    }

    public NBTTagList k(String s) {
        return !this.a.containsKey(s) ? new NBTTagList() : (NBTTagList) this.a.get(s);
    }

    public boolean l(String s) {
        return this.b(s) != 0;
    }

    public String toString() {
        return "" + this.a.size() + " entries";
    }
}
