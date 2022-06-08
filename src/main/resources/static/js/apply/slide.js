var slideOption = {
    slidesPerView : 'auto', // 한 슬라이드에 보여줄 갯수
    spaceBetween : 6, // 슬라이드 사이 여백
    loop : true, // 슬라이드 반복 여부
    allowTouchMove : false,
    loopAdditionalSlides : 1, // 슬라이드 반복 시 마지막 슬라이드에서 다음 슬라이드가 보여지지 않는 현상 수정
    pagination : {   // 페이저 버튼 사용자 설정
        el : '.swiper-pagination',
        type : 'bullets'
    }
};

let realIndex = 0;

const slide = new Swiper('#test-slide', slideOption);

slide.on('transitionEnd', function() {
    console.log('now index :::', slide.realIndex);
    realIndex = slide.realIndex;
});

/*
    ex) mySlider.autoplay.start()
    .slideTo(index, speed, runCallbacks) // 해당 슬라이드로 이동
    .slidePrev(index, speed, runCallbacks) // 이전 슬라이드로 이동
    .slideNext(index, speed, runCallbacks) // 다음 슬라이드로 이동
    .autoplay.start(); // 자동 재생 시작
    .autoplay.stop(); // 자동 재생 정지
    .destroy() // 슬라이드 제거
 */

