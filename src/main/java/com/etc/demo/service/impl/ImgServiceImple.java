package com.etc.demo.service.impl;


import com.etc.demo.dao.ImgsDao;
import com.etc.demo.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgServiceImple implements ImgService {
    @Autowired
    ImgsDao imgsDao;

}
