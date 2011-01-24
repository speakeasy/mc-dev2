package net.minecraft.server;

class HashEntry {

    final int a;
    Object b;
    HashEntry c;
    final int d;

    HashEntry(int i, int j, Object object, HashEntry hashentry) {
        this.b = object;
        this.c = hashentry;
        this.a = j;
        this.d = i;
    }

    public final int a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof HashEntry)) {
            return false;
        } else {
            HashEntry hashentry = (HashEntry) object;
            Integer integer = Integer.valueOf(this.a());
            Integer integer1 = Integer.valueOf(hashentry.a());

            if (integer == integer1 || integer != null && integer.equals(integer1)) {
                Object object1 = this.b();
                Object object2 = hashentry.b();

                if (object1 == object2 || object1 != null && object1.equals(object2)) {
                    return true;
                }
            }

            return false;
        }
    }

    public final int hashCode() {
        return MCHashTable.f(this.a);
    }

    public final String toString() {
        return this.a() + "=" + this.b();
    }
}
