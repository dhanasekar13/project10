window.onload=function(){
	$(".image").html("<img src=/s1?image="+"X3-UD_9ZyEDX0WDjQxucWQ"+" class='img24'  >");

xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
  if (this.readyState == 4 && this.status == 200) {
	 
   ca(this.responseText);
  }
} 
xhttp.open("GET", "/g1", true);
xhttp.send();

}

var ji={};
function ca(sdf)
{

 obj = JSON.parse(sdf);
  j=obj;
  console.log(j);
  ji=j;


try{
	var f;
	for(var i=0;i<obj.length;i++)
		{
		if((typeof(obj[i].keyString) != 'undefined'))
			{
 f=obj[i].keyString;
			}
		else
			{
			$("#aa2").append("<a href='#' class='aa22' onclick='akk("+obj+","+j+")' value="+i+">"+"Article no--"+i+"</a><br>");
			
			}
		}
	if(f!=null)
		{
		$(".image").html("<img src=/s1?image="+f+" class='img24'  >");
		}

	
}
	catch(e)
	{
		console.log(e);
		}

}
$(document).on("click", ".aa22",function() {
var st=$(this).text();
console.log("inside the click event");
var value=parseInt(st.charAt(st.length-1));
var blobtit=j[value].blobtitle;
var blobcont=j[value].blobcontent;
var blobinfo=j[value].blobinfo;
var image=j[value].image;



$(".r1").val(blobtit);
$(".r3").val(blobcont);
$(".r4").val(blobinfo);
console.log(image);

if((typeof(image.keyString) != 'undefined'))
{
	var ob=image.keyString;

$(".r2").html("<img src=/s1?image="+ob+" class='img23'  >");
}
});

function btn()
{
	   $.ajax(
		        {		
		        url:"generate",
		        error: function(err) {
		        	
		        	        alert('Login Error: ' + err.responseText + '  Status: ' + err.status + ' Response Status: ' + err.responseStatus);
		        },
		        dataType: "json",
		        success: function(data) {
		         all1(data);
		        },
		        type: 'GET'
});
}	       
function all1(da)
{
	 daa=da;
 search=$("#sear").val();var i=0;
	for(var y=0;y<da.length;y++)
		{console.log(da[y].email+" ----"+search);
		if(da[y].email==search)
			{console.log("ciun");
			$(".left31").append("<a href='#' class='left11' value="+y+">"+"blog no--"+i+"</a><br>");
			i++;
			}
		else
			{
			
			}
		
		}
	
	
}

$(document).on("click", ".left11",function() {
	var st=$(this).text();
	console.log("inside the click event");
	var value=parseInt(st.charAt(st.length-1));
	var blobtit=daa[value].blobtitle;
	var blobcont=daa[value].blobcontent;
	var blobinfo=daa[value].blobinfo;
	var image=daa[value].image;
	$(".r1").val(blobtit);
	$(".r3").val(blobcont);
	$(".r4").val(blobinfo);
	console.log(image);

	if((typeof(image.keyString) != 'undefined'))
	{
		var ob=image.keyString;

	$(".r2").html("<img src=/s1?image="+ob+" class='img23'  >");
	}
	});