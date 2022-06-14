let kakaoBtn = document.querySelector(".kakao-btn");
let paymentElem = document.querySelector(".payment-container");
let payMsg = document.querySelector(".payMsg");
let transferBtn = document.querySelector(".transferBtn");
let transferInfoElem = document.querySelector(".transferInfo");
let footerElem = document.querySelector("footer");

kakaoBtn.addEventListener("click", () => {
    let IMP = window.IMP;
    IMP.init("imp35612292");
    IMP.request_pay({
        pg: "kakaopay",
        pay_method: 'card',
        merchant_uid: 'merchant_' + new Date().getTime(),
        name: '결제',
        amount: 1,
        buyer_email: '구매자 이메일',
        buyer_name: '구매자 이름',
        buyer_tel: '구매자 번호',
        m_redirect_url: 'redirect url'
    }, function (rsp) {
        if (rsp.success) {
            var msg = '결제가 완료되었습니다.';

            payMsg.innerText = "결제완료"

            paymentElem.innerHTML = `
            <div class="d-flex flex-column justify-content-center align-items-center h-100">
            <h1>결제가 완료되었습니다.</h1>
            <h2>호스트가 곧 카카오톡 메세지로 안내드리겠습니다.</h2>
            <a href="/"><button type="button" class="btn btn-primary">홈으로</button></a>
            </div>
            `
        } else {
            var msg = '결제에 실패하였습니다.';
            rsp.error_msg;
        }
    });
})

transferBtn.addEventListener("click", () => {
    if (!transferInfoElem.classList.contains("d-none")) {
        transferInfoElem.classList.add("d-none");
        footerElem.classList.remove("mt-5");
    } else {
        transferInfoElem.classList.remove("d-none");
        footerElem.classList.add("mt-5");
    }
})

//계좌번호 복사
let copyBtn = document.querySelector(".copy-btn");

function copy_to_clipboard() {
    const copyText = document.querySelector('.account-number').textContent;
    const textarea = document.createElement('textarea');
    textarea.style.display = "none";
    textarea.textContent = copyText;
    document.body.append(textarea);
    textarea.select();
    document.execCommand("Copy");
    alert('복사되었습니다, 감사합니다.');
}

copyBtn.addEventListener("click", ()=> {
    copy_to_clipboard();
})
