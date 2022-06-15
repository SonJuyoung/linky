package com.example.linky.main.model.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ReviewService {

    @Autowired private ReviewRepository reviewRepository;
    @Autowired private MyFileUtils myFileUtils;

    public void insFileInFolder(ReviewVo reviewVo) {
        for(MultipartFile item : reviewVo.getImg()) {
            myFileUtils.transferTo(item, "review");
            String img = myFileUtils.getRandomFileNm(item);
            ReviewEntity review = new ReviewEntity();
            review.setImg(img);
            reviewRepository.save(review);
        }
    }
}
