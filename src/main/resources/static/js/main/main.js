const mainContainerElem = document.querySelector('.main-container');
const scheduleContainerElem = mainContainerElem.querySelector('.schedule-wrapper');
const scheduleModalBody = mainContainerElem.querySelector('.modal-body');

if(scheduleContainerElem) {
    /* insert schedule data in modal after open modal */
    const scheduleModButton = mainContainerElem.querySelectorAll('.schedule-mod-button');
    scheduleModButton.forEach(item => {
        item.addEventListener('click', (e) => {
            scheduleModalBody.innerHTML = '';

            const parent = e.target.closest('.schedule-data');
            const id = parent.querySelector('.id').value;
            const date = parent.querySelector('.date').innerText;
            const time = parent.querySelector('.time').innerText;
            const man = parent.querySelector('.man').value;
            const woman = parent.querySelector('.woman').value;
            const status = parent.querySelector('.status').innerText;

            scheduleModalBody.innerHTML = `
                <input type="hidden" class="modal-id" value="${id}">
                <div class="d-flex">
                    <div class="text-align-right mr10px w65px">날짜 </div>
                    <input class="w150px modal-date" type="date" value="${date}">
                    
                    <div class="text-align-right mr10px w65px">시간 </div> 
                    <input class="w150px modal-time" type="text" value="${time}">
                </div>
                <div class="d-flex">
                    <div class="text-align-right mr10px w65px">남 </div>
                    <input class="w150px modal-man" type="text" value="${man}">
                    
                    <div class="text-align-right mr10px w65px">여 </div> 
                    <input class="w150px modal-woman" type="text" value="${woman}">
                </div>
            `;

            const div = document.createElement('div');
            div.classList.add('d-flex');
            if(status === '모집중') {
                div.innerHTML = `
                    <div class="text-align-right mr10px w65px">모집여부 </div>
                    <label class="mr30px">
                        <input class="modal-status" name="modal-status" value="1" checked type="radio">모집중
                    </label>
                    
                    <label>
                        <input class="modal-status" name="modal-status" value="0" type="radio">마감
                    </label>
                `;
            } else {
                div.innerHTML = `
                    <div class="text-align-right mr10px w65px">모집여부 </div>
                    <label class="mr30px">
                        <input class="modal-status" name="modal-status" value="1" type="radio">모집중
                    </label>
                    
                    <label>
                        <input class="modal-status" name="modal-status" value="0" checked type="radio">마감
                    </label>
                `;
            }
            scheduleModalBody.appendChild(div);
        });
    });

    /* submit */
    const scheduleSubmitButton = mainContainerElem.querySelector('.schedule-submit-button');
    scheduleSubmitButton.addEventListener('click', () => {

        const modalId = parseInt(mainContainerElem.querySelector('.modal-id').value);
        const modalDate = mainContainerElem.querySelector('.modal-date').value;
        const modalTime = mainContainerElem.querySelector('.modal-time').value;
        const modalMan = mainContainerElem.querySelector('.modal-man').value;
        const modalWoman = mainContainerElem.querySelector('.modal-woman').value;
        let modalStatus = mainContainerElem.querySelectorAll('.modal-status');
        modalStatus.forEach(item => {
            if(item.checked) {
                modalStatus = parseInt(item.value);
            }
        });

        const data = {
            id: modalId,
            rdt : modalDate,
            time : modalTime,
            man : modalMan,
            woman : modalWoman,
            status : modalStatus
        }

        fetch('/schedule/mod', {
            method : 'post',
            headers : {'Content-Type' : 'application/json'},
            body : JSON.stringify(data)
        })
            .then(res => res.json())
            .then(data => {
                if(data === 1) {
                    location.reload();
                }
            })
            .catch(e => {
                console.error(e);
            });
    });
}

const reviewButton = document.querySelector('#review-button');
const reviewModal = document.querySelector('.review-modal');

const url = new URL(location.href);
const searchParams = url.searchParams;
const review = searchParams.get('review');
if(review === 'success') {
    reviewModal.style.display = 'flex';
    const div = document.createElement('div');
    div.classList.add('modal-backdrop');
    div.classList.add('show');
    document.body.appendChild(div);
    document.querySelector('.review-swiper').scrollIntoView(true);
}

/* Open the review modal */
if(reviewButton) {
    reviewButton.addEventListener('click', () => {
        reviewModal.style.display = 'flex';
        const div = document.createElement('div');
        div.classList.add('modal-backdrop');
        div.classList.add('show');
        document.body.appendChild(div);
    });
}

/* Close the review modal */
const reviewCloseButton = document.querySelector('.review-close');
if(reviewCloseButton) {
    reviewCloseButton.addEventListener('click', () => {
        reviewModal.style.display = 'none';
        const div = document.querySelector('.modal-backdrop');
        div.classList.remove('modal-backdrop');
        div.classList.remove('show');
    });
}

/* Open the review insert */
const reviewHistory = document.querySelector('.review-history');
if(reviewHistory) {
    reviewHistory.addEventListener('click', () => {
        window.open('/review', 'review', 'width=500px, height=700px')
    });
}

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


var swiper = new Swiper(".review-swiper", {
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
