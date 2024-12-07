package com.universe.warehouse.controller;


import com.universe.warehouse.common.oss.MinIOTemplate;
import com.universe.warehouse.common.result.Result;
import io.minio.errors.*;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author universe7427
 * @since 2024-12-06
 */
@Api(value = "响应自定义",tags = "响应自定义")
@RestController
@RequestMapping("/bwDocumentMessage")
public class BwDocumentMessageController {


    @Autowired
    private MinIOTemplate minIOTemplate;

    @ApiOperation(value = "get")
    @GetMapping("get")
    public Result remove() throws Exception {


        Iterable<io.minio.Result<Item>> aPublic = minIOTemplate.listObjects("public", true);

        ArrayList<String> strings = new ArrayList<>(10);
        while (aPublic.iterator().hasNext()) {
            io.minio.Result<Item> next = aPublic.iterator().next();
            String s = next.get().objectName();
            strings.add(s);
        }
        return Result.ok(strings.toString());

    }

}

