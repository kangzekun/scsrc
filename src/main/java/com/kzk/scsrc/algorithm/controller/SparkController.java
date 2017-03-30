package com.kzk.scsrc.algorithm.controller;

/**
 * Created by kangk_000 on 3/18/2017.
 * Description: 操作Spark平台的controller
 */

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kzk.scsrc.algorithm.util.ExtractDataUtil;
import com.kzk.scsrc.algorithm.util.IterUtil;
import com.kzk.scsrc.algorithm.util.ShellUtil;
import com.kzk.scsrc.classifiedImage.util.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/spark")
public class SparkController {

/**
*@Param:接受console打印出的迭代次数（iteration）
**/
    private IterUtil iu = new IterUtil();
/**
*@Description:在这个方法里面执行shell命令
**/
    @RequestMapping(value = "/sparkShow")
    public
    @ResponseBody
    Map<String, Object> sparkShow() throws IOException {
        ExtractDataUtil extr = new ExtractDataUtil();
        //clear lasttime iteration
        iu.setIteration(0);
        SparkController spc = new SparkController();
        ShellUtil shell = new ShellUtil();
        Map<String, Object> scsrcMap = new HashMap<String, Object>();
        shell.submitSCSRC(extr, iu);
        String result = ImageUtil.imgUtil();
        if (result.equals("success")) {
            scsrcMap = extr.getScsrcMap();
        }
        return scsrcMap;
    }

/**
*@Description:方法响应前端kzk.js中定时器对迭代次数的请求
**/    
    @RequestMapping(value = "/getIteration", method = RequestMethod.GET)
    public
    @ResponseBody
    Integer getIterations() {
        //the value will return
        return iu.getIteration();
    }


}
