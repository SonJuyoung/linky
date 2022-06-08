const applyContainerElem = document.querySelector('.apply-container');
if(applyContainerElem) {

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
            button.classList.remove('hidden');
        } else {
            button.classList.add('hidden');
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

    const nextArr = applyContainerElem.querySelectorAll('.next');
    nextArr.forEach(item => {
        item.addEventListener('click', () => {
            slide.slideNext(1, 10, 1);
        });
    });
}
