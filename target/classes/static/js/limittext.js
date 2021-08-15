//限制显示文本
function jsLine(line,domName){
    var num = domName.length;  //获取该id的标签个数
    for(var i = 0;i<num;i++){  //修改每一个拥有该id的属性中的值
        var textLength = domName[i].innerText.length;//获取文本长度
        var strSize = window.getComputedStyle(domName[i]).fontSize;//获取字体大小，结果会显示为“xxpx”
        var newstrSize = strSize.substr(0,2);//提取前两个字符，也就是“xx”,(xx表示字体大小)
        var fontSize = parseInt(newstrSize);//将字符类型转化为int类型
        var lineNum = Math.round(domName[i].clientWidth/fontSize);//计算一行可以放多少字符
        if(textLength>lineNum){  //判断是否超出一行的长度
            var newText = domName[i].innerText.substr(0,(Math.round(lineNum*line)))+'...';
            domName[i].innerText = newText;//替换文本
        }
    }
}
//延迟执行
function getjavatext(){
    setTimeout('jsLine(1.5,$("[id=javatext]"))',500);
}
function getlinuxtext(){
    setTimeout('jsLine(1.5,$("[id=linuxtext]"))',500);
}
function getwebtext(){
    setTimeout('jsLine(1.5,$("[id=webtext]"))',500);
}