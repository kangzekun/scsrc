package com.kzk.scsrc.algorithm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kangk_000 on 3/20/2017.
 */
public class ExtractDataUtil {
    private String dataName1;

    private String dataName2;

    private String dataName3;

    private Integer iteration;

    private List<Double> scsrcLineDtol = new ArrayList<Double>();

    private List<Double> scsrcLineIter = new ArrayList<Double>();

    private Map<String, Object> scsrcMap = new HashMap<String, Object>();

    public ExtractDataUtil() {
        this.dataName1 = "dtol";
        this.dataName2 = "iter time";
        this.dataName3 = "iter";
        this.iteration = 0;
    }

    public void readProcessBuf(String line) {
        //split iterations \ iter time  or dtol\  data
        //split(":");
        String[] s1 = line.split(":");
        //get number from s1[0]

        if (Character.isDigit(s1[0].charAt(0)) && s1[0].charAt(2) != '/') {


            String[] s5 = s1[0].split(" ");
            String iteration1 = s5[0];
            setIteration(Integer.parseInt(iteration1));

            //split("\\d");  get no num data or space
            String[] s2 = s1[0].split("\\d| ");
            StringBuilder sb1 = new StringBuilder();
            for (String s : s2) {
                sb1.append(s).append(" ");
            }
            //get iter time
            String s3 = sb1.toString().trim();
            //get time
            //put into list
            if (s3.equals(dataName1)) {
                String s4 = s1[1].trim();
                scsrcLineDtol.add(Double.parseDouble(s4));
            } else if (s3.equals(dataName2)) {
                String s4 = s1[1].trim();
                scsrcLineIter.add(Double.parseDouble(s4));
            }
        }

    }


    public Map<String, Object> getScsrcMap() {
        scsrcMap.put(dataName1, scsrcLineDtol);
        scsrcMap.put(dataName3, scsrcLineIter);
        return scsrcMap;
    }

    public void setScsrcMap(Map<String, Object> scsrcMap) {
        this.scsrcMap = scsrcMap;
    }

    public Integer getIteration() {
        return iteration;
    }

    public void setIteration(Integer iteration) {
        this.iteration = iteration;
    }
}
