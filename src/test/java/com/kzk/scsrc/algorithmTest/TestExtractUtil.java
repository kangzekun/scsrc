package com.kzk.scsrc.algorithmTest;

import com.kzk.scsrc.algorithm.util.ExtractDataUtil;
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;
import org.junit.Test;


import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by kangk_000 on 3/20/2017.
 */
public class TestExtractUtil extends BaseJunitTest {

    @Test
    public void testExtractData() {
//        String testString="1 dtol: 3.3593119313523746E32";
//        String testString="factor time:3.709137326";
        String testString2="3 iter time: 6.6841164740000005";
        String testString3="SCSRC.examples.SCSRC_feature2 --master spark://10.10.10.47:7077 --driver-memory 3g --executor-memory 4g --conf spark.akka.frameSize=100 /home/chenyf/shenjl/SCSRC_V1.jar /home/chenyf/shenjl/ 16 40";
        String filePath = "g:\\1\\scsrc_spark_data.txt";
        ExtractDataUtil extr=new ExtractDataUtil();
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;

                while ((lineTxt = br.readLine()) != null) {
                    //
                    if(lineTxt.isEmpty()) continue;
                    extr.readProcessBuf(lineTxt);
                }
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Map<String,Object> scsrcMap=extr.getScsrcMap();


    }
}
