package net.minecraft.server;

public class MCHashTable {

    private transient HashEntry[] a = new HashEntry[16];
    private transient int b;
    private int c = 12;
    private final float d = 0.75F;
    private transient volatile int e;

    public MCHashTable() {}

    private static int g(int i) {
        i ^= i >>> 20 ^ i >>> 12;
        return i ^ i >>> 7 ^ i >>> 4;
    }

    private static int a(int i, int j) {
        return i & j - 1;
    }

    public Object a(int i) {
        int j = g(i);

        for (HashEntry hashentry = this.a[a(j, this.a.length)]; hashentry != null; hashentry = hashentry.c) {
            if (hashentry.a == i) {
                return hashentry.b;
            }
        }

        return null;
    }

    public boolean b(int i) {
        return this.c(i) != null;
    }

    final HashEntry c(int i) {
        int j = g(i);

        for (HashEntry hashentry = this.a[a(j, this.a.length)]; hashentry != null; hashentry = hashentry.c) {
            if (hashentry.a == i) {
                return hashentry;
            }
        }

        return null;
    }

    public void a(int i, Object object) {
        int j = g(i);
        int k = a(j, this.a.length);

        for (HashEntry hashentry = this.a[k]; hashentry != null; hashentry = hashentry.c) {
            if (hashentry.a == i) {
                hashentry.b = object;
            }
        }

        ++this.e;
        this.a(j, i, object, k);
    }

    private void h(int i) {
        HashEntry[] ahashentry = this.a;
        int j = ahashentry.length;

        if (j == 1073741824) {
            this.c = Integer.MAX_VALUE;
        } else {
            HashEntry[] ahashentry1 = new HashEntry[i];

            this.a(ahashentry1);
            this.a = ahashentry1;
            this.c = (int) ((float) i * this.d);
        }
    }

    private void a(HashEntry[] ahashentry) {
        HashEntry[] ahashentry1 = this.a;
        int i = ahashentry.length;

        for (int j = 0; j < ahashentry1.length; ++j) {
            HashEntry hashentry = ahashentry1[j];

            if (hashentry != null) {
                ahashentry1[j] = null;

                HashEntry hashentry1;

                do {
                    hashentry1 = hashentry.c;
                    int k = a(hashentry.d, i);

                    hashentry.c = ahashentry[k];
                    ahashentry[k] = hashentry;
                    hashentry = hashentry1;
                } while (hashentry1 != null);
            }
        }
    }

    public Object d(int i) {
        HashEntry hashentry = this.e(i);

        return hashentry == null ? null : hashentry.b;
    }

    final HashEntry e(int i) {
        int j = g(i);
        int k = a(j, this.a.length);
        HashEntry hashentry = this.a[k];

        HashEntry hashentry1;
        HashEntry hashentry2;

        for (hashentry1 = hashentry; hashentry1 != null; hashentry1 = hashentry2) {
            hashentry2 = hashentry1.c;
            if (hashentry1.a == i) {
                ++this.e;
                --this.b;
                if (hashentry == hashentry1) {
                    this.a[k] = hashentry2;
                } else {
                    hashentry.c = hashentry2;
                }

                return hashentry1;
            }

            hashentry = hashentry1;
        }

        return hashentry1;
    }

    public void a() {
        ++this.e;
        HashEntry[] ahashentry = this.a;

        for (int i = 0; i < ahashentry.length; ++i) {
            ahashentry[i] = null;
        }

        this.b = 0;
    }

    private void a(int i, int j, Object object, int k) {
        HashEntry hashentry = this.a[k];

        this.a[k] = new HashEntry(i, j, object, hashentry);
        if (this.b++ >= this.c) {
            this.h(2 * this.a.length);
        }
    }

    static int f(int i) {
        return g(i);
    }
}
