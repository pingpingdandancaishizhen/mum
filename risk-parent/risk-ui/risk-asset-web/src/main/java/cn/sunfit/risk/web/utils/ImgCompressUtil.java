package cn.sunfit.risk.web.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@SuppressWarnings("restriction")
public class ImgCompressUtil {

    /**
     * 等比例压缩算法： 
     * 算法思想：根据压缩基数和压缩比来压缩原图，生产一张图片效果最接近原图的缩略图
     * @param srcURL 原图地址
     * @param deskURL 缩略图地址
     * @param comBase 压缩基数
     * @param scale 压缩限制(宽/高)比例  一般用1：
     * 当scale>=1,缩略图height=comBase,width按原图宽高比例;若scale<1,缩略图width=comBase,height按原图宽高比例
     * @throws Exception
     * @author shenbin
     * @createTime 2014-12-16
     * @lastModifyTime 2014-12-16
     */
    public static void compressPic(String srcURL, String deskURL, double comBase, double scale) throws Exception {
        File srcFile = new java.io.File(srcURL);
        Image src = ImageIO.read(srcFile);
        int srcHeight = src.getHeight(null);
        int srcWidth = src.getWidth(null);
        int deskHeight = 0;// 缩略图高
        int deskWidth = 0;// 缩略图宽
        double srcScale = (double) srcHeight / srcWidth;
        /**缩略图宽高算法*/
        if (srcHeight > comBase || srcWidth > comBase) {
            if (srcScale >= scale || 1 / srcScale > scale) {
                if (srcScale >= scale) {
                    deskHeight = (int) comBase;
                    deskWidth = srcWidth * deskHeight / srcHeight;
                } else {
                    deskWidth = (int) comBase;
                    deskHeight = srcHeight * deskWidth / srcWidth;
                }
            } else {
                if (srcHeight > comBase) {
                    deskHeight = (int) comBase;
                    deskWidth = srcWidth * deskHeight / srcHeight;
                } else {
                    deskWidth = (int) comBase;
                    deskHeight = srcHeight * deskWidth / srcWidth;
                }
            }
        } else {
            deskHeight = srcHeight;
            deskWidth = srcWidth;
        }
        BufferedImage tag = new BufferedImage(deskWidth, deskHeight, BufferedImage.TYPE_3BYTE_BGR);
        tag.getGraphics().drawImage(src, 0, 0, deskWidth, deskHeight, null); // 绘制缩小后的图
        FileOutputStream deskImage = new FileOutputStream(deskURL); // 输出到文件流
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(deskImage);
        encoder.encode(tag); // 近JPEG编码
        deskImage.close();
    }

    /**
     * 
     * @Title: getFileFromMultipartFile
     * @Description: 根据传入高度和宽度，0.6的压缩率压缩图片
     * @param @param fileCover
     * @param @param temSrc
     * @param @param width
     * @param @param heigth
     * @param @return   
     * @return byte[] 
     * @author yanlei 2016年7月29日 
     * @throws
     */
    public static byte[] getFileFromMultipartFile(MultipartFile fileCover, String temSrc, int width, int heigth,
            float scom) {
        // boolean isSuccess = true;
        File tempFile;
        BufferedOutputStream outStream = null;
        try {
            byte[] fileCoverByte = fileCover.getBytes();

            tempFile = new File(temSrc);
            FileOutputStream fstream = new FileOutputStream(tempFile);
            outStream = new BufferedOutputStream(fstream);
            outStream.write(fileCoverByte);
        } catch (Exception e1) {
            return null;
        } finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (IOException e1) {
                }
            }
        }
        try {
            zipImageFile(tempFile.getPath(), width, heigth, scom, "");
        } catch (Exception e) {
            return null;
        }
        tempFile = new File(temSrc);
        try {
            FileInputStream stream = new FileInputStream(tempFile);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
            byte[] b = new byte[1024];
            int n;
            while ((n = stream.read(b)) != -1)
                out.write(b, 0, n);
            stream.close();
            out.close();
            tempFile.delete();
            return out.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] s) {
        // try {
        // compressPic("C:\\Users\\RJS\\Desktop\\testImage\\y1.jpg",
        // "C:\\Users\\RJS\\Desktop\\testImage\\y1-1.jpeg");
        // compressPic("C:\\Users\\RJS\\Desktop\\testImage\\pexels-photo-128193.jpg",
        // "C:\\Users\\RJS\\Desktop\\testImage\\pexels-photo-128193-1.jpeg");
        // compressPic("C:\\Users\\RJS\\Desktop\\testImage\\y2.jpeg",
        // "C:\\Users\\RJS\\Desktop\\testImage\\y2-0.8压缩比例.jpeg");
        // compressPic("C:\\Users\\RJS\\Desktop\\testImage\\y3.jpeg",
        // "C:\\Users\\RJS\\Desktop\\testImage\\y3-0.8压缩比例.jpeg");
        // System.out.println("压缩成功");
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        zipImageFile("C:\\Users\\RJS\\Desktop\\testImage\\y3.jpg", 0, 0, 0.6f, "_0.6_bak");
        zipImageFile("C:\\Users\\RJS\\Desktop\\testImage\\y3.jpg", 0, 0, 0.7f, "_0.7_bak");
        zipImageFile("C:\\Users\\RJS\\Desktop\\testImage\\y4.jpg", 166, 178, 0.9f, "_small_0.9_bak");

    }

    /**
     * 直接指定压缩后的宽高：
     * (先保存原文件，再压缩、上传)
     * 壹拍项目中用于二维码压缩
     * @param oldFile 要进行压缩的文件全路径
     * @param width 压缩后的宽度
     * @param height 压缩后的高度
     * @param quality 压缩质量
     * @param smallIcon 文件名的小小后缀(注意，非文件后缀名称),入压缩文件名是yasuo.jpg,则压缩后文件名是yasuo(+smallIcon).jpg
     * @return 返回压缩后的文件的全路径
     */
    public static String zipImageFile(String oldFile, int width, int height, float quality, String smallIcon) {
        if (oldFile == null) {
            return null;
        }
        String newImage = null;
        try {
            File file = new java.io.File(oldFile);
            Image src = ImageIO.read(file);
            int srcHeight = src.getHeight(null);
            int srcWidth = src.getWidth(null);
            if (0 == width)
                width = srcWidth;
            if (0 == height)
                height = srcHeight;
            /**对服务器上的临时文件进行处理 */
            Image srcFile = ImageIO.read(new File(oldFile));
            /** 宽,高设定 */
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
            String filePrex = oldFile.substring(0, oldFile.indexOf('.'));
            /** 压缩后的文件名 */
            newImage = filePrex + smallIcon + oldFile.substring(filePrex.length());
            /** 压缩之后临时存放位置 */
            FileOutputStream out = new FileOutputStream(newImage);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
            /** 压缩质量 */
            jep.setQuality(quality, true);
            encoder.encode(tag, jep);
            out.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return newImage;
    }
}
