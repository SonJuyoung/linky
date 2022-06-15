const inputImgElem = document.querySelector('#img-file');
if(inputImgElem) {
    const imgFirstSec = document.querySelector('.img-first-sec');
    const imgSecondSec = document.querySelector('.img-second-sec');

    const readImg = input => {
        if(input.files) {

            imgFirstSec.innerHTML = '';
            imgSecondSec.innerHTML = '';

            const fileArr = Array.from(input.files);
            fileArr.forEach( (item, index) => {
                const reader = new FileReader();

                const img = document.createElement('img');

                reader.onload = e => {
                    img.src = e.target.result;
                }

                if(index < 3) {
                    imgFirstSec.appendChild(img);
                } else {
                    imgSecondSec.appendChild(img);
                }
                reader.readAsDataURL(item);


            });
        }
    }

    inputImgElem.addEventListener('change', (e) => {
        readImg(e.target);
    });
}