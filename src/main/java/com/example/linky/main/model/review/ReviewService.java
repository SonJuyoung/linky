package com.example.linky.main.model.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MyFileUtils myFileUtils;

    public void delExcessItems() {
        reviewRepository.deleteOldReview();
    }
    public void insFileInFolder(ReviewVo reviewVo) {
        List<String> result = new ArrayList<>();

        for(MultipartFile item : reviewVo.getImg()) {
            String img = myFileUtils.getRandomFileNm(item);
            myFileUtils.transferTo(item, "review", img);
            ReviewEntity review = new ReviewEntity();
            review.setImg(img);
            ReviewEntity status = reviewRepository.save(review);

            List<ReviewEntity> list = reviewRepository.findAllByOrderByRdtDesc();

            if(list.size() > 6) {
                if (status != null) {
                    myFileUtils.delFile(reviewRepository.delTargetReview().getImg());
                    delExcessItems();
                }
            }

        }
    }
}
