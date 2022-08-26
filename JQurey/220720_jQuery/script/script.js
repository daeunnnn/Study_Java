$(document).ready(function(){

    $("#dish li").click(function(){
        $(this).hide();
    });

    //#btn1을 눌렀을 때 이런일이 벌어질 것이다.
    //#dish li들을 모두 보여준다.
    $("#btn1").click(function(){
        $("#dish li").show();
    });

    //#box1에 마우스를 올렸을 때 이런일이 벌어질 것이다.
    //(방금 마우스를 올린)그것의 내용을 "이제 마우스 치우세요."로
    //바꾼다.

    $("#box1").mouseenter(function(){
        $(this).text("이제 마우스 치우세요.");
    });

    $("#box1").mouseleave(function(){
        $(this).text("마우스를 올려보세요");
    });

    $("#btn2").click(function(){
        $("#box3").slideUp(2000);
    });

    $("#btn3").click(function(){
        $("#box3").slideDown(2000);
    });

    $("#btn4").click(function(){
        $("#box3").text("람보르기니");
    });

    $("#btn5").click(function(){
        $("#box3").text("아반떼");
    });

    $(".main").mouseenter(function(){
        $(this).children(".sub").stop().slideDown();
    });

    $(".main").mouseleave(function(){
        $(this).children(".sub").stop().slideUp();
    });

    $("#btn6").click(function(){
        $("#box4").slideUp(3000,"liner",function(){
            
        });
    });

    $("#para1").html("Gutten tag!");
    
    $("input[name='car']").click(function(){
        var car = $(this).val();
        if(car == 1){
            $("#car_price").show();
        }else{
            $("#car_price").hide();
        }
    });

    //#pw1에서 키가 눌렸다가 떼질 때 이런일이 벌어질 것이다.
    //방금 키 누른 그것의 value의 글자 수를 len이라고 하자
    //만약 그 len의 값이 0이라면(글자를 입력하지 않았다면)
    //#pw2를 잠근다
    //그렇지 않다면(글자를 입력 했다면)
    //#pw2를 풀어준다

    $("#pw1").keyup(function(){
        var len = $(this).val().length;
        if(len == 0){
            $("#pw2").attr("disabled","disabled");
        }else{
            $("#pw2").removeAttr("disabled");
        }
    });

    //#pw2에서 키가 눌렸다가 떼어질 때 마다 이런일이 벌어질 것이다.
    //#pw1의 값과 pw2의 값을 알아내서 
    //만약 그 두 값이 같다면
    //#pw_chk에 "비밀번호가 일치합니다"라는 글을 쓰기
    //#pw_chk의 속성 중 style이라는 속성의 내용을 "color:green"으로 바꾸기
    //그것이 아니라면(다르다)
    //#pw_chk에 "비밀번호가 틀립니다"라는 글을  쓰기
    //#pw_chk의 속성 중 style이라는 속성의 내용을 "color:red"으로 바꾸기

    $("#pw1, #pw2").keyup(function(){
        var pw1 = $("#pw1").val();
        var pw2 = $("#pw2").val();
        if(pw1 == pw2){
            $("#pw_chk").text("비밀번호가 일치합니다.").attr("style","color:green");
        }else{
            $("#pw_chk").text("비밀번호가 일치하지 않습니다.").css("color","red").css("font-weight","bold");
        }
    });


    //#btn7을 눌렀을 때 이런 일이 벌어질 것이다.
    //#list1의 안쪽에 "<li>탕수육</li>"을 추가한다

    var num =0;
    $("#btn7").click(function(){
        num++;
        $("#list1").prepend("<input type='text' placeholder='참가자 성명"+num+"'/>");
    });

    $("#btn8").click(function(){
        $("#list1 input:last-of-type").remove();
    });

    $("#btn9").click(function(){
        $("#box5").removeClass("blue");
    });
    $("#btn10").click(function(){
        $("#box5").addClass("blue");
    });


    $("#box6").click(function(){
        var w = $(this).width();
        var h = $(this).height();
        alert(w + "," + h);
    });

    //브라우저의 크기가 바뀔 때마다 
    //브라우저의 가로,세로 크기를 알아내서 
    //#para2에 내용으로 써 넣기

    $(window).resize(function(){
        var w = $(this).width();
        var h = $(this).height();
        $("#para2").text(w + "," + h);
    });

    //같은 말을 반복할 때 함수 만들어두기(코드의 재사용)
    // function chk_win(){
    //     var h = $(this).height();
    //     $("#box7").height(h);
    // }

    // chk_win();

    // $(window).resize(function(){
    //    chk_win();
    // });

    //#roha의 부모님의 부모님
    $("#roha").parent().parent();

    //#sunjae의 자식들 : #junha, #minyong
    $("#sunjae").children();
    //#sunjae의 자식들 중 #junha
    $("#sunjae").children("#junha");
    //#sunjae의 자식의 자식
    $("#sunjae").children().children();

    //#roha가 삼촌을 부르기
    //#roha의 부모의 형제
    $("#roha").parent().siblings();

    //#junha의 바로 아랫동생 
    $("#junha").next();
    //#junha의 바로 윗형
    $("#junha").prev();


});