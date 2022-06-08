let IMP = window.IMP;
IMP.init("{TC0ONETIME}");


let kakaoBtn = document.querySelector(".kakao-btn");

kakaoBtn.addEventListener("click", ()=> {
    // IMP.request_pay(param, callback) 결제창 호출
    IMP.request_pay({ // param
        pg : 'kakaopay',
        pay_method : 'card', //생략 가능
        merchant_uid: "order_no_0001", // 상점에서 관리하는 주문 번호
        name : '주문명:결제테스트',
        amount : 10000,
        buyer_name : '구매자이름',
        buyer_tel : '010-1234-5678'
    }, function (rsp) { // callback
        if (rsp.success) {
        alert("성공")
        } else {
        alert("실패")
        }
    });
})