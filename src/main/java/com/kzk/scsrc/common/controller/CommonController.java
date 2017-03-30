package com.kzk.scsrc.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kangk_000 on 3/21/2017.
 */
@Controller
@RequestMapping(value = "/common")
public class CommonController {

    @RequestMapping(value = "/upload")
    public String upload() {
        return "/common/content_upload";
    }

    @RequestMapping(value = "/spark")
    public String spark() {
        return "/common/content_spark";
    }

    @RequestMapping(value = "/menu")
    public String common3() {
        return "/menu";
    }

    @RequestMapping(value = "/testcase")
    public String common1() {
        return "/algorithm/select";
    }

    @RequestMapping(value = "/testcupload")
    public String common2() {
        return "/upload/uploadToHDFS";
    }

}
