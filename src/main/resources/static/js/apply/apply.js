const applyContainerElem = document.querySelector('.apply-container');
if(applyContainerElem) {
    const selectedIndex = {
        idx : ''
    };

    const data = {
        q1 : '',
        q2 : '',
        q3 : '',
        q4 : ''
    };

    /* input태그 다음버튼 활성화 */
    const questionInput = applyContainerElem.querySelectorAll('.q-input');
    questionInput.forEach(item => {
        item.addEventListener('input', (e) => {
            const parent = e.target.closest('.question');
            const thisElem = e.target;
            const nextButton = parent.querySelector('.next');

            if(thisElem.value.length === 0) {
                nextButton.classList.add('hidden');
            } else {
                nextButton.classList.remove('hidden');
            }
        });
    });

    /* select태그 다음버튼 활성화 */
    const setSelectNextButton = (elem) => {
        const parent = elem.closest('.question');
        const button = parent.querySelector('.next');
        const bool = elem[elem.selectedIndex].value === '0' ? false : true;
        if(bool) {
            data.q1 = elem[elem.selectedIndex].innerText;
            selectedIndex.idx = elem.selectedIndex;
            button.classList.remove('hidden');
        } else {
            button.classList.add('hidden');
        }

        if(selectedIndex.idx > 0) {
            questionSelect.forEach(item => {
                item[selectedIndex.idx].selected = true;
                const parent = item.closest('.question');
                const button = parent.querySelector('.next');
                button.classList.remove('hidden');
            });
        }
    }
    const questionSelect = applyContainerElem.querySelectorAll('.q-select-1');
    if(questionSelect.length > 2) {
        questionSelect.forEach(item => {
            setSelectNextButton(item);
            item.addEventListener('change', (e) => {
                setSelectNextButton(e.target);
            });
        });
    }

    /* 다음,제출 버튼 */
    const nextArr = applyContainerElem.querySelectorAll('.next');
    const maxSwiperPage = (applyContainerElem.querySelectorAll('.swiper-slide').length / 3) - 1;
    nextArr.forEach(item => {
        item.addEventListener('click', () => {
            if(slide.realIndex < maxSwiperPage) {
                slide.slideNext(1, 10, 1);
            } else {
                /** submit 기능 **/
            }
        });
    });
}
