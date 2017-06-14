window.onload=function()
{console.log("this is onload data");
xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
  if (this.readyState == 4 && this.status == 200) {
    ca(this.responseText);
  }
};
xhttp.open("GET", "/g1", true);
xhttp.send();

}
var j;
function ca(sdf)
{
 obj = JSON.parse(sdf);
 j=obj;
for(i=0;i<obj.length;i++)
	{

$("#aa2").append("<a href='#' class='aa22' onclick='akk("+obj+","+i+")' value="+i+">"+"Article no--"+i+"</a><br>");
	}
}
$(document).on("click", ".aa22",function() {
	
var st=$(this).text();

var value=parseInt(st.charAt(st.length-1));
var blobtit=j[value].blobtitle;
var blobcont=j[value].blobcontent;
var blobinfo=j[value].blobinfo;
var image=j[value].image;
var ob=image.keyString;
$(".r1").val(blobtit).show();
$(".r3").val(blobcont);
$(".r4").val(blobinfo);
console.log(image);
$(".r2").html("<img src=/s1?image="+ob+" class='img23'  >");





});
