const mainContainerElem = document.querySelector('.main-container');
const scheduleContainerElem = mainContainerElem.querySelector('.schedule-wrapper');
const scheduleModalBody = mainContainerElem.querySelector('.modal-body');

if(scheduleContainerElem) {
    const scheduleModButton = mainContainerElem.querySelectorAll('.schedule-mod-button');
    scheduleModButton.forEach(item => {
        item.addEventListener('click', (e) => {
            scheduleModalBody.innerHTML = '';

            const parent = e.target.closest('.schedule-data');
            const date = parent.querySelector('.date').innerText;
            const time = parent.querySelector('.time').innerText;

            scheduleModalBody.innerHTML = `
                <div class="d-flex">
                    <div class="text-align-right mr10px w65px">날짜 </div>
                    <input class="w150px modal-date" type="date" value="${date}">
                    
                    <div class="text-align-right mr10px w65px">시간 </div> 
                    <input class="w150px modal-time" type="text" value="${time}">
                </div>
                <div class="d-flex">
                    <div class="text-align-right mr10px w65px">남 </div>
                    <input class="w150px modal-man" type="text" value="${date}">
                    
                    <div class="text-align-right mr10px w65px">여 </div> 
                    <input class="w150px modal-woman" type="text" value="${time}">
                </div>
                <div class="d-flex">
                    <div class="text-align-right mr10px w65px">모집여부 </div>
                    <label class="mr30px">
                        <input class="modal-status" name="modal-status" type="radio">모집중
                    </label>
                    
                    <label>
                        <input class="modal-status" name="modal-status" type="radio">마감
                    </label>
                </div>
            `;

            const div = document.createElement('div');
        });
    });
}