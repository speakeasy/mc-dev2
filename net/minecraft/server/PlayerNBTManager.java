package net.minecraft.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

public class PlayerNBTManager {

    public static Logger a = Logger.getLogger("Minecraft");
    private File b;

    public PlayerNBTManager(File file1) {
        this.b = file1;
        file1.mkdir();
    }

    public void a(EntityPlayerMP entityplayermp) {
        try {
            NBTTagCompound nbttagcompound = new NBTTagCompound();

            entityplayermp.d(nbttagcompound);
            File file1 = new File(this.b, "_tmp_.dat");
            File file2 = new File(this.b, entityplayermp.aw + ".dat");

            CompressedStreamTools.a(nbttagcompound, (OutputStream) (new FileOutputStream(file1)));
            if (file2.exists()) {
                file2.delete();
            }

            file1.renameTo(file2);
        } catch (Exception exception) {
            a.warning("Failed to save player data for " + entityplayermp.aw);
        }
    }

    public void b(EntityPlayerMP entityplayermp) {
        try {
            File file1 = new File(this.b, entityplayermp.aw + ".dat");

            if (file1.exists()) {
                NBTTagCompound nbttagcompound = CompressedStreamTools.a((InputStream) (new FileInputStream(file1)));

                if (nbttagcompound != null) {
                    entityplayermp.e(nbttagcompound);
                }
            }
        } catch (Exception exception) {
            a.warning("Failed to load player data for " + entityplayermp.aw);
        }
    }
}
