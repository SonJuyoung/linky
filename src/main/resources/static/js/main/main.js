const mainContainerElem = document.querySelector('.main-container');
const scheduleModButton = mainContainerElem.querySelector('.schedule-mod-button');
const scheduleDataArr = mainContainerElem.querySelectorAll('.schedule-data');
const scheduleCancelButton = mainContainerElem.querySelector('.schedule-cancel-button');

const changeScheduleModButton = () => {
    if(scheduleModButton.classList.contains('submit')) {
        scheduleModButton.innerText = '수정하기';
        scheduleModButton.classList.remove('submit');
        scheduleCancelButton.classList.add('hidden');
    } else {
        scheduleModButton.innerText = '확인';
        scheduleModButton.classList.add('submit');
        scheduleCancelButton.classList.remove('hidden');
    }
}

const modSwitchFunction = (arr, status) => {
    arr.forEach(item => {
        switch (status) {
            case 'on' :
                item.classList.add('schedule-mod-select');
                changeScheduleModButton();
                break;
            case 'off' :
                item.classList.remove('schedule-mod-select');
                changeScheduleModButton();
                break;
        }
    });
}

/* schedule mod button ready */
if(scheduleModButton) {
    scheduleModButton.addEventListener('click', (e) => {
        modSwitchFunction(scheduleDataArr, 'on', e.target);
        changeScheduleModButton();

        if(!scheduleModButton.classList.contains('submit')) {
            /** fetch **/
            location.reload();
        }
    });
}

/* schedule mod ready cancel */
scheduleCancelButton.addEventListener('click', () => {
    modSwitchFunction(scheduleDataArr, 'off');
    changeScheduleModButton();
});

// Process Swiper
var swiper = new Swiper(".mySwiper", {
    spaceBetween: 30,
    centeredSlides: true,
    autoplay: {
        delay: 3500,
        disableOnInteraction: false,
    },
    loop: true,
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});