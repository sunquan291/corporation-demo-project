package com.zte.sunquan.demo;

import sun.net.www.protocol.file.FileURLConnection;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by 10184538 on 2017/7/7.
 */
public class JarFileUtilsTemp {
    public static void main(String[] args) throws IOException {

        JarFileUtilsTemp jarFileUtils=new JarFileUtilsTemp();
        jarFileUtils.loadRecourseFromJarByFolder("E:/zzz/shade-plugin-1.0-SNAPSHOT.jar");
//        jarFileUtils.fileCopy(".\\META-INF\\maven\\com.zte.sunquan.demo\\shade-plugin\\pom.xml","E:/my/my.xml");
    }

    public void loadRecourseFromJarByFolder(String folderPath) throws IOException {
        URL url = getClass().getResource(folderPath);
        URLConnection urlConnection = url.openConnection();
        if (urlConnection instanceof FileURLConnection) {
            copyFileResources(url, folderPath);
        } else if (urlConnection instanceof JarURLConnection) {
            copyJarResources((JarURLConnection) urlConnection);
        }
    }

    private void copyFileResources(URL url, String folderPath) throws IOException {
        File root = new File(url.getPath());
        if (root.isDirectory()) {
            File[] files = root.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    loadRecourseFromJarByFolder(folderPath + "/" + file.getName());
                } else {
                    loadRecourseFromJar(folderPath + "/" + file.getName());
                }
            }
        }
    }

    private void copyJarResources(JarURLConnection jarURLConnection) throws IOException {
        JarFile jarFile = jarURLConnection.getJarFile();
        Enumeration<JarEntry> entrys = jarFile.entries();
        while (entrys.hasMoreElements()) {
            JarEntry entry = entrys.nextElement();
            if (entry.getName().startsWith(jarURLConnection.getEntryName()) && !entry.getName().endsWith("/")) {
                loadRecourseFromJar("/" + entry.getName());
            }
        }
        jarFile.close();
    }
    public void loadRecourseFromJar(String path) throws IOException {
        if (!path.startsWith("/")) {
            throw new IllegalArgumentException("The path has to be absolute (start with '/').");
        }

        if(path.endsWith("/")){
            throw new IllegalArgumentException("The path has to be absolute (cat not end with '/').");
        }

        int index = path.lastIndexOf('/');

        String filename = path.substring(index + 1);
        String folderPath = "E:/" + path.substring(0, index + 1);

        // If the folder does not exist yet, it will be created. If the folder
        // exists already, it will be ignored
        File dir = new File(folderPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // If the file does not exist yet, it will be created. If the file
        // exists already, it will be ignored
        filename = folderPath + filename;
        File file = new File(filename);

        if (!file.exists() && !file.createNewFile()) {
//            log.error("create file :{} failed", filename);
            return;
        }

        // Prepare buffer for data copying
        byte[] buffer = new byte[1024];
        int readBytes;

        // Open and check input stream
        URL url = getClass().getResource(path);
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();

        if (is == null) {
            throw new FileNotFoundException("File " + path + " was not found inside JAR.");
        }

        // Open output stream and copy data between source file in JAR and the
        // temporary file
        OutputStream os = new FileOutputStream(file);
        try {
            while ((readBytes = is.read(buffer)) != -1) {
                os.write(buffer, 0, readBytes);
            }
        } finally {
            // If read/write fails, close streams safely before throwing an
            // exception
            os.close();
            is.close();
        }

    }

    public  int fileCopy(String srcFilePath, String destFilePath){
        int flag = 0;
        File destFile = new File(destFilePath);
        try {
            BufferedInputStream fis = new BufferedInputStream(ClassLoader.getSystemResourceAsStream(srcFilePath));
            FileOutputStream fos = new FileOutputStream(destFile);
            byte[] buf = new byte[1024];
            int c = 0;
            while ((c = fis.read(buf)) != -1) {
                fos.write(buf, 0, c);
            }
            fis.close();
            fos.close();
            flag = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

//    protected void copyFileFromJar(String fileRegex, String strDestFileName) {
//        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
//        String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + fileRegex;
//
//        try {
//            Resource[] resources = resourcePatternResolver.getResources(pattern);
//
//            if(resources!=null && resources.length>0) {
//                Resource res = resources[0];
//                InputStream fis = res.getInputStream();
//                OutputStream fos = new FileOutputStream(strDestFileName);
//                byte[] bArrBuffer = new byte[BUFFER_SIZE];
//                int iCount = 0;
//
//                while ((iCount = fis.read(bArrBuffer, 0, bArrBuffer.length)) != -1) {
//                    fos.write(bArrBuffer, 0, iCount);
//                }
//
//                fis.close();
//                fos.close();
//            }
//        } catch (IOException e) {
//        }
//    }
}
