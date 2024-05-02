<%@ page language="java" 

	import="com.ekart.models.*,java.util.List,java.util.ArrayList"
contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Kart</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<header>
<nav class="navbar-sticky bg-fixed-white navbar-airy navbar navbar-expand-lg navbar-light">
    <div class="container-fluid">
        <a aria-label="Back to homepage" href="#" class="py-1 navbar-brand">E-Kart</a>
        <div class="navbar-collapse collapse">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item"><a href="#" class="nav-link active">Home</a></li>
                <li class="nav-item"><a href="#store" class="nav-link">Shop</a></li>
                <li class="nav-item"><a href="cart.jsp" class="nav-link">Cart</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Contact</a></li>
            </ul>
            <div class="nav-item navbar-icon-link " >
            	<% if (session.getAttribute("LOGGEDIN") != null && session.getAttribute("LOGGEDIN").equals("yes")) {
			    			String username = (String) session.getAttribute("USERNAME");
				%>
					<span>Welcome, <%= username %></span>
			
				<%} else { %>
						<a class="text-dark" href="customer-login.jsp">Login</a>
				<%
					}
				%>
            </div>
        </div>
    </div>
</nav>
</header>
<div class="swiper-slide item d-flex align-items-end bg-gray-100 light-overlay light-overlay-md-0 swiper-slide-active" data-swiper-slide-index="0" style="width: 100%; margin: 0; color:black; margin:0px;">
    <div class="circle-slider-bg px-lg-5 h-100 position-relative container" style="background-image: url('iphone15.png'); background-size: cover; background-position: center; height: 100%;">
        <div data-swiper-parallax="-500" class="overlay-content align-items-center py-5 row">
            <div class="py-md-5 py-lg-7 col-lg-8">
                <h5 class="h-100 subtitle letter-spacing-5 text-uppercase text-danger mb-3">Special</h5>
                <h2 class="text-white mb-3" style="line-height:1">iPhone 15</h2>
                <p class="text-white mb-5">Lorem ipsum dolor sit amet.<br> Consectetur adipisicing elit.</p>
                <a role="button" tabindex="0" href="/category" class="text-secondary btn btn-outline-dark">View Collection</a>
            </div>
        </div>
    </div>
    
    
    
</div>
    <div class="row" style="width:100%;">
    <div class="mb-5 col-xl-8 text-center col-12 mt-4" style="align-items:center; width:100%;">
	<p class="text-uppercase text-muted fw-bold mb-1">Top choices</p><h3>Popular this week</h3><p class="lead text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p></div></div>
<%
	List<ProductCategory> li= (List<ProductCategory>) request.getAttribute("allCategories");
%>
<div class="row ms-4" id="store">
   <div class="mb-4 mb-lg-5 col-md-4 ms-4 ">
      <a href="viewproducts.jsp">
         <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0;position:relative;max-width:100%">
            <span style="box-sizing:border-box;display:block;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0;max-width:100%">
            <img style="display:block;max-width:100%;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0" alt="" aria-hidden="true" src="iphone15.png">
            </span>
            </span>
      </a>
      <div class="px-4 position-relative z-index-2 mt-3">
         <a class="text-dark text-decoration-none" href="viewproducts.jsp">
            <h3 class="position-relative z-index-10" style="word-spacing:100vw"><%= li.get(1).getCategoryName()%></h3>
         </a>
         <p><a role="button" tabindex="0" href="viewproducts.jsp" class="text-dark text-decoration-none px-0 btn btn-link">Shop now</a></p>
      </div>
   </div>
   <div class="ms-auto mb-4 mb-lg-5 col-md-7">
      <div class="position-flex z-index-5 py-6">
         <a class="text-dark text-decoration-none" href="viewproducts.jsp">
            <h3 class="position-relative z-index-10" style="word-spacing:100vw"><%= li.get(0).getCategoryName()%></h3>
         </a>
         <p><a role="button" tabindex="0" href="viewproducts.jsp" class="text-dark text-decoration-none px-0 btn btn-link">Shop now</a></p>
      </div>
      <div class="ms-6">
         <a href="viewproducts.jsp">
            <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0;position:relative;max-width:100%">
               <span style="box-sizing:border-box;display:block;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0;max-width:100%">
               		<img style="display:block;max-width:100%;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0" alt="Iphone 15 Image" aria-hidden="true" src="iphone15.png">
               </span>
            </span>
         </a>
      </div>
   </div>
   <div class="ms-auto pt-lg-6 mb-4 mb-lg-5 order-md-2 col-md-4">
      <a href="viewproducts.jsp">
         <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0;position:relative;max-width:100%">
            <span style="box-sizing:border-box;display:block;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0;max-width:100%">
            <img style="display:block;max-width:100%;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0" alt="" aria-hidden="true" src="iphone15.png">
            </span>
            </span>
      </a>
      <div class="px-4 position-relative z-index-2 mt-3">
         <a class="text-dark text-decoration-none" href="viewproducts.jsp">
            <h3 class="position-relative z-index-10" style="word-spacing:100vw"><%= li.get(2).getCategoryName()%></h3>
         </a>
         <p><a role="button" tabindex="0" href="viewproducts.jsp" class="text-dark text-decoration-none px-0 btn btn-link">Shop now</a></p>
      </div>
   </div>
   <div class="mb-4 mb-lg-5 order-md-1 col-md-7">
      <div class="position-flex z-index-5 py-6">
         <a class="text-dark text-decoration-none" href="viewproducts.jsp">
            <h3 class="position-relative z-index-10" style="word-spacing:100vw"><%= li.get(3).getCategoryName() %></h3>
         </a>
         <p><a role="button" tabindex="0" href="viewproducts.jsp" class="text-dark text-decoration-none px-0 btn btn-link">Shop now</a></p>
      </div>
      <div class="ms-6">
         <a href="viewproducts.jsp">
            <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0;position:relative;max-width:100%">
               <span style="box-sizing:border-box;display:block;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0;max-width:100%">
               	<img style="display:block;max-width:100%;width:initial;height:initial;background:none;opacity:1;border:0;margin:0;padding:0" alt="" aria-hidden="true" src="iphone15.png">
               	</span>
            </span>
         </a>
      </div>
   </div>
   
</div>


</body>
</html>