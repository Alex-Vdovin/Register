package com.RegisterDemo.demo.controllers;

import com.RegisterDemo.demo.services.FridgeService;
import com.RegisterDemo.demo.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterController {
    public final FridgeService registerService;



}
