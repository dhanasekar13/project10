 $( window ).on( "load", function() {
        $.ajax(
        {		
        url:"generate",
        error: function(err) {
        	
        	        alert('Login Error: ' + err.responseText + '  Status: ' + err.status + ' Response Status: ' + err.responseStatus);
        },
        dataType: "json",
        success: function(data) {
         all(data);
        },
        type: 'GET'
 });
 });
 function all(data)
 {	  obj=data;
 for(var i=0;i<3;i++)
	 {
	 var g=Math.floor((Math.random() * obj.length-1) + 1);
	if(i==0)
		{
		$(".a1").text(obj[g].blobtitle);
		$(".a2").text(obj[g].blobinfo);
		$(".a3").text(obj[g].email);
		$(".a4").text(obj[g].blobcontent);
		}
	else 	if(i==1)
	{
		$(".b1").text(obj[g].blobtitle);
		$(".b2").text(obj[g].blobinfo);
		$(".b3").text(obj[g].email);
		$(".b4").text(obj[g].blobcontent);
	}
	else 	if(i==2)
	{
		$(".c1").text(obj[g].blobtitle);
		$(".c2").text(obj[g].blobinfo);
		$(".c3").text(obj[g].email);
		$(".c4").text(obj[g].blobcontent);
	}

	 }
 }