package com;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Administrator on 2018/1/26.
 */
public class GzipUtils {

    /**
     * 使用gzip进行压缩
     * @param primStr
     * @return
     */
    public static String gzip(String primStr) {
        if (primStr == null || primStr.length() == 0) {
            return primStr;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(primStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gzip != null) {
                try{
                    gzip.close();
                    return new sun.misc.BASE64Encoder().encode(out.toByteArray());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
    /**
    * 使用zip进行压缩
    * @param str 压缩前的文本
    * @return 返回压缩后的文本
     */
    public static final String zip(String str) {
        if (str == null){
            return null;
        }
        byte[] compressed;
        ByteArrayOutputStream out = null;
        ZipOutputStream zout = null;
        String compressedStr = null;
        out = new ByteArrayOutputStream();
        zout = new ZipOutputStream(out);
        try{
            zout.putNextEntry(new ZipEntry("0"));
            zout.write(str.getBytes());
            zout.closeEntry();
            compressed = out.toByteArray();
            compressedStr = new sun.misc.BASE64Encoder()
                    .encodeBuffer(compressed);
            compressed = null;
            if (zout != null) {
                zout.close();
                if (out != null) {
                    out.close();
                    return compressedStr;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return "";
    }

    /*
    * 使用gzip进行解压缩
    * @param compressedStr*/
//    public static String gunzip(String compressedStr) {
//        if (compressedStr != null) {
//            ByteArrayInputStream in = null;
//            GZIPInputStream ginzip = null;
//            byte[] compressed = null;
//            String decompressed = null;
//            compressed = new sun.misc.BASE64Decoder()
//                    .decodeBuffer(compressedStr);
//            in = new ByteArrayInputStream(compressed);
//            ginzip = new GZIPInputStream(in);
//            byte[] buffer = new byte[1024];
//            int offset = -1;
//            while ((offset = ginzip.read(buffer)) != -1) {
//                out.write(buffer, 0, offset);
//                decompressed = out.toString();
//                if (ginzip != null) {
//                    ginzip.close();
//                    if (in != null) {
//                        in.close();
//                        return decompressed;
//                    }
//                }
//            }
//        }
//    }

    /*
                        * 使用zip进行解压缩
                                * @param compressed 压缩后的文本
                                * @return 解压后的字符串
                                */
//    public static final String unzip(String compressedStr) {
//        ZipInputStream zin = null;
//        byte[] compressed = new sun.misc.BASE64Decoder()
//                try{
//                    zin = new ZipInputStream();
//                    zin.getNextEntry();
//                    while ((offset = zin.read(buffer)) != -1) {
//                        decompressed = null;
//                        if (zin != null) {
//
//                        }       zin.close();
//                        }
//                    }
//                }catch(IOException e){


//    }

}
