
$(document).ready(function(){
	callAllURLs();
	})
	$("#suv").click(function(){
		
			
	if(validateForm()==true){
		$.ajax({
			type: 'POST',
			url: '/shortenurl',
			cache: false,
			data: JSON.stringify({
				'longid': $("#urlInput").val()
			}),
			contentType: 'application/json',
			success: function(data) {
				$("#shortURl").val('http://localhost:8080/'+data.shortid);
				callAllURLs();
				
			},
			error: function (e) {
				alert('Internal Error with status ' +e.status)
				 console.log("ERROR : ", e);
				}

		});
		}
		else{
			alert('Please enter a proper url to continue')
		}
		})
		
		



function callAllURLs(){
	$.ajax({
			
			type: 'POST',
			url: '/allUrls',
			cache: false,
			contentType: 'application/json',
			success: function(data) {
				
				
			var tr='';
			tr+='<thead class="thead-dark"><tr><th scope="col">Short URL</th><th scope="col">Count of Hits</th></tr></thead>';
				for(var i = 0; i < data.length; i++) {
				tr+='<tr><td><a href=/longURl/'+data[i].shortid+'>http://localhost:8080/'+data[i].shortid+'</td><td>'+data[i].hitcount+'</td></tr>'
				}
				$("#dynamicTable").html(tr)
			},
			error: function (e) {
				 console.log("ERROR : ", e);
				}

		});
}


function validateForm() {
	var longurl=$("#urlInput").val();

   var pattern = new RegExp('^http[s]?:\/\/\*(:[0-9]+)?\/*'); // fragment locator
   
  return !!pattern.test(longurl);
  }

