package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataWatcher {

    private static final HashMap a = new HashMap();
    private final Map b = new HashMap();
    private boolean c;

    public DataWatcher() {}

    public void a(int i, Object object) {
        Integer integer = (Integer) a.get(object.getClass());

        if (integer == null) {
            throw new IllegalArgumentException("Unknown data type: " + object.getClass());
        } else if (i > 31) {
            throw new IllegalArgumentException("Data value id is too big with " + i + "! (Max is " + 31 + ")");
        } else if (this.b.containsKey(Integer.valueOf(i))) {
            throw new IllegalArgumentException("Duplicate id value for " + i + "!");
        } else {
            WatchableObject watchableobject = new WatchableObject(integer.intValue(), i, object);

            this.b.put(Integer.valueOf(i), watchableobject);
        }
    }

    public byte a(int i) {
        return ((Byte) ((WatchableObject) this.b.get(Integer.valueOf(i))).b()).byteValue();
    }

    public void b(int i, Object object) {
        WatchableObject watchableobject = (WatchableObject) this.b.get(Integer.valueOf(i));

        if (!object.equals(watchableobject.b())) {
            watchableobject.a(object);
            watchableobject.a(true);
            this.c = true;
        }
    }

    public boolean a() {
        return this.c;
    }

    public static void a(List list, DataOutputStream dataoutputstream) {
        if (list != null) {
            Iterator iterator = list.iterator();

            while (iterator.hasNext()) {
                WatchableObject watchableobject = (WatchableObject) iterator.next();

                a(dataoutputstream, watchableobject);
            }
        }

        dataoutputstream.writeByte(127);
    }

    public ArrayList b() {
        ArrayList arraylist = null;

        if (this.c) {
            Iterator iterator = this.b.values().iterator();

            while (iterator.hasNext()) {
                WatchableObject watchableobject = (WatchableObject) iterator.next();

                if (watchableobject.d()) {
                    watchableobject.a(false);
                    if (arraylist == null) {
                        arraylist = new ArrayList();
                    }

                    arraylist.add(watchableobject);
                }
            }
        }

        this.c = false;
        return arraylist;
    }

    public void a(DataOutputStream dataoutputstream) {
        Iterator iterator = this.b.values().iterator();

        while (iterator.hasNext()) {
            WatchableObject watchableobject = (WatchableObject) iterator.next();

            a(dataoutputstream, watchableobject);
        }

        dataoutputstream.writeByte(127);
    }

    private static void a(DataOutputStream dataoutputstream, WatchableObject watchableobject) {
        int i = (watchableobject.c() << 5 | watchableobject.a() & 31) & 255;

        dataoutputstream.writeByte(i);
        switch (watchableobject.c()) {
        case 0:
            dataoutputstream.writeByte(((Byte) watchableobject.b()).byteValue());
            break;

        case 1:
            dataoutputstream.writeShort(((Short) watchableobject.b()).shortValue());
            break;

        case 2:
            dataoutputstream.writeInt(((Integer) watchableobject.b()).intValue());
            break;

        case 3:
            dataoutputstream.writeFloat(((Float) watchableobject.b()).floatValue());
            break;

        case 4:
            dataoutputstream.writeUTF((String) watchableobject.b());
            break;

        case 5:
            ItemStack itemstack = (ItemStack) watchableobject.b();

            dataoutputstream.writeShort(itemstack.a().ba);
            dataoutputstream.writeByte(itemstack.a);
            dataoutputstream.writeShort(itemstack.h());
        }
    }

    public static List a(DataInputStream datainputstream) {
        ArrayList arraylist = null;

        for (byte b1 = datainputstream.readByte(); b1 != 127; b1 = datainputstream.readByte()) {
            if (arraylist == null) {
                arraylist = new ArrayList();
            }

            int i = (b1 & 224) >> 5;
            int j = b1 & 31;
            WatchableObject watchableobject = null;

            switch (i) {
            case 0:
                watchableobject = new WatchableObject(i, j, Byte.valueOf(datainputstream.readByte()));
                break;

            case 1:
                watchableobject = new WatchableObject(i, j, Short.valueOf(datainputstream.readShort()));
                break;

            case 2:
                watchableobject = new WatchableObject(i, j, Integer.valueOf(datainputstream.readInt()));
                break;

            case 3:
                watchableobject = new WatchableObject(i, j, Float.valueOf(datainputstream.readFloat()));
                break;

            case 4:
                watchableobject = new WatchableObject(i, j, datainputstream.readUTF());
                break;

            case 5:
                short short1 = datainputstream.readShort();
                byte b2 = datainputstream.readByte();
                short short2 = datainputstream.readShort();

                watchableobject = new WatchableObject(i, j, new ItemStack(short1, b2, short2));
            }

            arraylist.add(watchableobject);
        }

        return arraylist;
    }

    static {
        a.put(Byte.class, Integer.valueOf(0));
        a.put(Short.class, Integer.valueOf(1));
        a.put(Integer.class, Integer.valueOf(2));
        a.put(Float.class, Integer.valueOf(3));
        a.put(String.class, Integer.valueOf(4));
        a.put(ItemStack.class, Integer.valueOf(5));
    }
}
