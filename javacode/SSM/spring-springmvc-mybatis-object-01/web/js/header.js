let date = new Date();
let data1 = date.getFullYear()
    + " 年 " + (date.getMonth() + 1)
    +" 月 " + date.getDate() + " 日 ";
document.getElementById("demo").innerHTML = data1;