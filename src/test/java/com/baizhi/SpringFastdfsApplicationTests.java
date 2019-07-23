package com.baizhi;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.Timer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFastdfsApplicationTests {
    @Autowired
    FastFileStorageClient fastFileStorageClient;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test2() throws FileNotFoundException {

        File file = new File("E://aa.png");
        FileInputStream fileInputStream = new FileInputStream(file);
        StorePath png = fastFileStorageClient.uploadFile(fileInputStream, file.length(), "png", null);
        System.out.println("/"+png.getGroup() +"/"+ png.getPath());
    }
    @Test
    public void test3() throws IOException {

        byte[] b=fastFileStorageClient.downloadFile("group1","M00/00/00/wKgBPl0siZOAdg9WAADL41qS0Oo557.png",new DownloadByteArray());
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\2.png");
            fileOutputStream.write(b);
            fileOutputStream.close();
    }
    @Test
    public void Test4(){
        Timer timer = new Timer();
        timer.schedule(new Timetest(),1000,3000);


    }
}
