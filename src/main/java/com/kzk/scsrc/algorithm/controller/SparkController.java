package com.kzk.scsrc.algorithm.controller;

/**
 * Created by kangk_000 on 3/18/2017.
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

    private IterUtil iu = new IterUtil();

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

    @RequestMapping(value = "/getIteration", method = RequestMethod.GET)
    public
    @ResponseBody
    Integer getIterations() {
        //the value will return
        return iu.getIteration();
    }


}