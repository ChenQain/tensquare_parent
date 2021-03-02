package com.tensquare.article;

import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * bilibili下载的视频批量重命名
 *
 * @Author : eden 2020-12-02 14:16
 */
public class BilibiliVideoTest {

    @Test
    public void testHandlerSingle() throws IOException {
        handlerSingle(new File("C:\\Users\\Eden\\Videos\\B站下载\\76728711"), "、", ".mp4");
    }

    private void handlerMultiple(String path, String suffix) throws IOException {
        File rootDir = new File(path);
        File[] files = rootDir.listFiles();
        if (files != null) {
            for (File file : files) {
                this.handlerSingle(file, null, suffix);
            }
        } else {
            System.err.println("File Not Find");
        }
    }

    private void handlerSingle(File source, String replaceStr, String suffix) throws IOException {
        String info = ".info";
        String aid = source.getName();
        String absolutePath = source.getAbsolutePath();
        String title = (String) new Gson().fromJson(new BufferedReader(new FileReader(absolutePath + "\\1\\" + aid + ".info")).readLine(), Map.class).get("Title");
        String outPath = absolutePath + "\\" + title;
        // 创建目标文件夹
        File file = new File(outPath);
        boolean mkdir = file.mkdir();
        File[] dirs = source.listFiles();

        if (dirs != null && mkdir) {
            // 遍历所有目录
            for (File dir : dirs) {
                if (dir.isDirectory() && dir.getName().matches("\\d+")) {
                    File infoFile = Arrays.stream(Objects.requireNonNull(dir.listFiles())).filter(f -> f.getName().endsWith(info)).findFirst().get();
                    String infoStr = new BufferedReader(new FileReader(infoFile)).readLine();
                    Map<String, Object> map = new Gson().fromJson(infoStr, Map.class);
                    String partName = (String) map.get("PartName");
                    String partNo = (String) map.get("PartNo");
                    File videoFile = Arrays.stream(dir.listFiles()).filter(f -> f.getName().endsWith(suffix)).findFirst().get();
                    FileChannel channel = new FileInputStream(videoFile).getChannel();
                    // 处理文件名
                    String fileName = partName;
                    if (!StringUtils.isEmpty(replaceStr)) {
                        if (Integer.parseInt(partNo) < 10) {
                            partNo = "0" + partNo;
                        }
                        fileName = partNo + "、" + partName.substring(partName.indexOf(replaceStr) + 1);
                    }
                    FileChannel outChannel = new FileOutputStream(outPath + "\\" + fileName + suffix).getChannel();
                    outChannel.transferFrom(channel, 0, channel.size());
                    System.out.println(fileName + "复制完成");
                }
            }
        } else {
            System.err.println("File Not Find");
        }
    }
}
