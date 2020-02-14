package com.liman.www.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;
import java.net.URL;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2020年02月12日 19:57:00
 */
public class Test {
    public static void main(String[] args) throws IOException, MyException {
        String path = Test.class.getResource("tracker.conf").getPath();
        ClientGlobal.init("D:\\idea项目\\gmall_liman\\gmall-web-util\\src\\main\\resources\\tracker.conf");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();

    }
}
