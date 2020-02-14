package com.liman.www.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liman.www.bean.PmsProductImage;
import com.liman.www.bean.PmsProductInfo;
import com.liman.www.bean.PmsProductSaleAttr;
import com.liman.www.service.SpuService;
import com.liman.www.upload.PmsImage;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SpuController.java
 * @Description TODO
 * @createTime 2020年02月07日 00:36:00
 */
@RestController
@CrossOrigin
@Transactional
public class SpuController {
    @Reference
    SpuService spuService;

    @Autowired
    PmsImage pmsImage;

    @RequestMapping("spuList")
    public List<PmsProductInfo> spuList(String catalog3Id) {
        List<PmsProductInfo> pmsProductInfoList = spuService.spuList(catalog3Id);
        return pmsProductInfoList;
    }


    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile multipartFile) throws IOException, MyException {
        String imageUrl = pmsImage.fileupload(multipartFile);
        return imageUrl;
    }

    @RequestMapping("saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    @RequestMapping("spuSaleAttrList")
    @ResponseBody
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        List<PmsProductSaleAttr> pmsProductSaleAttrList = spuService.spuSaleAttrList(spuId);
        return pmsProductSaleAttrList;
    }


    @RequestMapping("spuImageList")
    @ResponseBody
    public List<PmsProductImage> spuImageList(String spuId) {
        List<PmsProductImage> pmsProductImageList = spuService.spuImageList(spuId);
        return pmsProductImageList;
    }
}
