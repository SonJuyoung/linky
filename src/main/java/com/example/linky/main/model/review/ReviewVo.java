package com.example.linky.main.model.review;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ReviewVo {

    private List<MultipartFile> img;
}
