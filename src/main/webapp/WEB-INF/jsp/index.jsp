<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Home page</title>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
         <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
         <style type="text/css">th , tr{
  		text-align: center;
		}
		</style>
    </head>
    <body>
     <nav class="navbar navbar-inverse">
       
    </nav>
    <div class="starter-template">
            <h1 align="center">Url Shortner Application</h1>
            
        </div>
        <!-- <form>
        <div class="form-group">
        <label for="urlInput">Full URL:</label>
        <input type="text" id="urlInput" name="urlInput" maxlength="255"/>
        </div>
        <div class="form-group">
        <label for="shortURl">Short URL:</label>
        <input type="text" id="shortURl" name="shortURl" maxlength="255"/>
        </div>
        <button type="button" class="btn btn-primary">Click here to get Shortened URL</button>
        </form> -->
        
        <form onsubmit="return validateForm()">
		<div class="form-group">
			<label for="urlInput">Full URL:</label> <input type="text"
				class="form-control" id="urlInput" name="urlInput"
				aria-describedby="urlInput" placeholder="Enter full URL">
		</div>
		<div class="form-group">
			<label for="shortURl">Short URL:</label> <input type="text" class="form-control" id="shortURl" disabled>
		</div>
		<div style="text-align:center">
				  <button  class="btn btn-primary" type="button" id="suv" >Submit</button>
		</div>
		</form>
		
		<br><br>
		<table class="table table-striped table-bordered" id ="dynamicTable">
		
		</table>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../scripts/shortner.js"></script>
    </body>
</html>