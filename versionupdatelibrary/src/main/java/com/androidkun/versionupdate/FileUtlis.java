package com.androidkun.versionupdate;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by 坤 on 2016/8/15.
 */
public class FileUtlis {
    /**
     * 获取文件大小
     * @param path
     * @return
     */
    public static long getFileSize(String path) {
        File file = new File(path);
        return (file.exists() && file.isFile() ? file.length() : -1);
    }
    /**
     * 清空文件夹
     */
    public static void cleanFile(String path){
        File file = new File(path);
        if(!file.exists()) return;

        if(file.isFile()){
            file.delete();
            return;
        }
        if(file.isDirectory()){
            File[] childFile = file.listFiles();
            if(childFile == null || childFile.length == 0){
                file.delete();
                return;
            }
            for(File f : childFile){
                cleanFile(f.getPath());
            }
            file.delete();
        }
    }

    public static boolean isSDcardExist() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    public static File getDiskCacheDir(Context context, String uniqueName) {
        final String cachePath = isSDcardExist() ? getExternalCacheDir(context).getPath() : context.getCacheDir().getPath();
        return new File(cachePath + File.separator + uniqueName);
    }

    public static File getExternalCacheDir(Context context) {
        if (context == null) {
            return new File( Environment.getExternalStorageDirectory().getPath() + "/apk/");
        }
        final String cacheDir = "/Android/data/" + context.getPackageName() + "/cache/";
        return new File(Environment.getExternalStorageDirectory().getPath() + cacheDir);
    }
}
