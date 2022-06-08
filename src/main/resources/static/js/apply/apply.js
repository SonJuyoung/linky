const applyContainerElem = document.querySelector('.apply-container');
if(applyContainerElem) {
    const selectedIndex = {
        idx : ''
    };

    const data = {
        /** List<Answer> -> QuestionEntity **/
        answer : []
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
            selectedIndex.idx = elem.selectedIndex;
            button.classList.remove('hidden');
        } else {
            button.classList.add('hidden');
        }

        if(!bool) {
            return;
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
                const answerArr = applyContainerElem.querySelectorAll('.answer');
                answerArr.forEach(item => {
                    const nodeName = item.nodeName;
                    let val = '';
                    switch (nodeName) {
                        case "SELECT" :
                            const elem = item[item.selectedIndex];
                            const bool = elem.value !== '0' ? true : false;
                            val = elem.innerText;

                            if(!bool) {
                                return;
                            } else {
                                data.answer.push({'answer': val});
                            }
                            break;
                        case "INPUT" :
                            val = item.value;
                            if(val === null || val.length < 1) { return; }
                            data.answer.push({'answer' : val});
                            break;
                    }

                    /* todo - fetch -> data insert */
                    /**
                     * data.answer type : list
                     * ex ) {'answer' : 'ctnt1'}, {'answer' : 'ctnt2'} ...
                     **/

                    const f = document.createElement('form');

                    let cnt = 0;
                    data.answer.forEach(item => {
                        const obj = document.createElement('input');
                        obj.setAttribute('type', 'hidden');
                        obj.setAttribute('name', `answerVoList[${cnt}].answer`);
                        obj.setAttribute('value', item.answer);
                        f.appendChild(obj);
                    });

                    f.setAttribute('method', 'post');
                    f.setAttribute('action', '/apply');
                    document.body.appendChild(f);
                    f.submit();
                });
            }
        });
    });

    const prevArr = applyContainerElem.querySelectorAll('.prev-button');
    if((prevArr.length/3) > 0) {
        prevArr.forEach(item => {
            item.addEventListener('click', () => {
                slide.slidePrev(1, 1, 1);
            });
        });
    }
}
