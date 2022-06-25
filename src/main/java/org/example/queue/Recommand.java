/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:15 上午 2022/6/9
 **/


package org.example.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 推荐结果打散，给一个有图片和视频的List,要求每n个视频后出现一个图片
 */
public class Recommand {

    public List<String> getRecommandResult(List<String> picAndVideo, int maxInterval) {
        List<String> rsult = new ArrayList<>();
        if (picAndVideo == null || picAndVideo.isEmpty()) {
            return rsult;
        }
        Queue<String> picQueue = new LinkedList<>();
        Queue<String> videoQueue = new LinkedList<>();
        boolean firstPic = false;
        int size = picAndVideo.size();
        int index = 0;
        while (!firstPic && index <= size - 1) {
            if (isVideo(picAndVideo.get(index))) {
                rsult.add(picAndVideo.get(index));
            } else {
                firstPic = true;
            }
            index++;
        }
        while (index < size) {
            String str = picAndVideo.get(index);
            if (isVideo(str)) {
                videoQueue.offer(str);
            } else {
                picQueue.offer(str);
            }
            index++;
        }
        int currentSize = rsult.size();
        while (!videoQueue.isEmpty() && !picAndVideo.isEmpty()) {
            if (currentSize == maxInterval) {
                rsult.add(picQueue.poll());
                currentSize = 0;
            }
            if (currentSize < maxInterval) {
                rsult.add(videoQueue.poll());
                currentSize++;
            }
        }
        while (!videoQueue.isEmpty()) {
            rsult.add(videoQueue.poll());
        }
        if (currentSize >= maxInterval && !picQueue.isEmpty()) {
            rsult.add(picQueue.poll());
        }
        return rsult;
    }

    private boolean isVideo(String str) {
        if (str.startsWith("v")) {
            return true;
        }
        return false;
    }
}
