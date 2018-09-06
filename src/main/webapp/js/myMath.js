function numAdd(num1,num2){
	   var t1,t2,m;
	   //获取num1和num2各自小数位的长度
	   try{t1 = num1.toString().split(".")[1].length;}catch(e){t1 = 0;}
	   try{t2 = num2.toString().split(".")[1].length;}catch(e){t2 = 0;}
	   //取小数长度最长的数，让num1和num2都乘以10的该次幂，相加后再除以10的该次幂即可
	   m = Math.pow(10,Math.max(t1,t2));
	 /*   alert("t1:"+t1);
	   alert("t2:"+t2);
	   alert("m:"+m);
	   alert("结果："+(num1*m+num2*m)/m); */
	   var result = (num1*m+num2*m)/m;
	   //保留两位有效数字
	   
	   return result;
	   
   }

function numDec(num1,num2){
	   var t1,t2,m;
	   //获取num1和num2各自小数位的长度
	   try{t1 = num1.toString().split(".")[1].length;}catch(e){t1 = 0;}
	   try{t2 = num2.toString().split(".")[1].length;}catch(e){t2 = 0;}
	   //取小数长度最长的数，让num1和num2都乘以10的该次幂，相加后再除以10的该次幂即可
	   m = Math.pow(10,Math.max(t1,t2));
	 /*   alert("t1:"+t1);
	   alert("t2:"+t2);
	   alert("m:"+m);
	   alert("结果："+(num1*m+num2*m)/m); */
	   var result = (num1*m-num2*m)/m;
	   //保留两位有效数字
	  // alert(num1+"-"+num2+"="+result);
	   return result;
	   
}
   
 function numMul(num1,num2){
	   var m=0,str1=num1.toString(),str2=num2.toString();
	   //获取num1和num2各自小数位的长度
	   try{m += str1.split(".")[1].length;}catch(e){}
	   try{m += str2.split(".")[1].length;}catch(e){}
	   return Number(str1.replace(".",""))*Number(str2.replace(".",""))/Math.pow(10,m);   
 }
 
 function numDiv(num1,num2){
	   var t1=0,t2=0,str1=num1.toString(),str2=num2.toString();
	   //获取num1和num2各自小数位的长度
	   try{t1 = str1.split(".")[1].length;}catch(e){}
	   try{t2 = str2.split(".")[1].length;}catch(e){}
	  // alert(num1+"/"+num2+"="+Number(str1.replace(".",""))/Number(str2.replace(".",""))/Math.pow(10,t2-t1));
	   return Number(str1.replace(".",""))/Number(str2.replace(".",""))/Math.pow(10,t1-t2);  
 }
 
 function beGoodNum(num){
	 var temp = Math.round(num * 100) / 100;
	 //根据小数点后位数
	 
	 
	 
 }
 
 