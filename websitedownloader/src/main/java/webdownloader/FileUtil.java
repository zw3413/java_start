package webdownloader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Dajavu on 20/04/2017.
 */

public class FileUtil {
    public static boolean unpackZip(String path, String zipName) {
        InputStream is;
        ZipInputStream zis;
        try {
            String filename;
            is = new FileInputStream(path + zipName);
            zis = new ZipInputStream(new BufferedInputStream(is));
            ZipEntry ze;
            byte[] buffer = new byte[1024];
            int count;

            while ((ze = zis.getNextEntry()) != null) {
                filename = ze.getName();

                // Need to create directories if not exists, or
                // it will generate an Exception...
                if (ze.isDirectory()) {
                    File fmd = new File(path, filename);
                    fmd.mkdirs();
                    continue;
                }

                FileOutputStream fOut = new FileOutputStream(path + filename);

                while ((count = zis.read(buffer)) != -1) {
                    fOut.write(buffer, 0, count);
                }

                fOut.close();
                zis.closeEntry();
            }

            zis.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static List<File> getAllFiles(String parentDir) {
        File parentFile = new File(parentDir);
        ArrayList<File> inFiles = new ArrayList<File>();
        File[] files = parentFile.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory()) {
                    inFiles.add(file);
                }
            }
        }
        return inFiles;
    }

    public static List<File> getAllDirectory(String parentDir, ArrayList<File> inFiles) {
        File parentFile = new File(parentDir);
        File[] files = parentFile.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    inFiles.add(file);
                    getAllDirectory(file.getPath(), inFiles);
                }
            }
        }
        return inFiles;
    }

    public static void replaceFile(File target, File src) {
        if (target.exists()) {
            target.delete();
        }
        src.renameTo(target);
    }
}
