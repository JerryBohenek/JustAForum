<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <meta content="Forum for developers" name="description">
    <meta content="Grupa 2" name="author">

    <title>JaF</title>

    <!-- Bootstrap css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-4.6.0-dist/css/bootstrap.min.css">

    <!-- Custom styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-info">
        <a class="navbar-brand" href="/"><img alt="JaF"
                                              src="${pageContext.request.contextPath}/resources/images/logo_white_narrow.png" style="height: 20px; width: 55px; margin-bottom: 4px;" class="d-inline-block"></a>
        <button aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation"
                class="navbar-toggler"
                data-target="#navbarCollapse" data-toggle="collapse" type="button">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a aria-expanded="false" aria-haspopup="true" class="nav-link dropdown-toggle"
                       data-toggle="dropdown"
                       href="#" id="submenu" role="button"> Categories </a>

                    <div aria-labelledby="submenu" class="dropdown-menu">

                        <a class="dropdown-item" href="/frontend"> Frontend</a>
                        <a class="dropdown-item" href="/backend"> Backend </a>
                        <a class="dropdown-item" href="/mobile"> Mobile </a>

                    </div>

                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/my-posts">My posts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/about-us">About us</a>
                </li>
            </ul>

            <form class="form-inline mt-2 mt-md-0">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <span class="text-light font-weight-bold mr-2">
                            <c:out value="${pageContext.request.userPrincipal.name}" />
                        </span>
                        <a class="btn btn-info" href="/logout" role="button">Logout</a>
                    </c:when>
                    <c:otherwise>
                        <a class="btn btn-info mr-2" href="/login" role="button" >Log in</a>
                        <a class="btn btn-info" href="/signup" role="button">Sign up</a>
                    </c:otherwise>
                </c:choose>
            </form>
        </div>
    </nav>
</header>

<main role="main">

    <section class="title text-center mb-3 jumbotron">
        <div class="container">
            <h1 class="title-heading">Just a Forum</h1>
            <p class="lead text-muted mb-0">Welcome to the forum that is intended for developers.</p>
            <p class="lead text-muted mt-0">Choose your category and go ahead.</p>
        </div>
    </section>

    <div class="container py-5">
        <div class="row">

            <div class="col-md-4">
                <div class="card mb-4 bg-secondary">
                    <img alt="Frontend" class="card-img-top" src="${pageContext.request.contextPath}/resources/images/frontend.png">
                    <div class="card-body">
                        <h5 class="card-title">Frontend</h5>
                        <p class="card-text">Layout and all about user interaction.</p>
                        <a class="btn btn-outline-info" href="/frontend">View</a>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card mb-4 bg-secondary">
                    <img alt="Backend" class="card-img-top" src="${pageContext.request.contextPath}/resources/images/backend.png">
                    <div class="card-body">
                        <h5 class="card-title">Backend</h5>
                        <p class="card-text">Api, databases, servers and much more.</p>
                        <a class="btn btn-outline-info" href="/backend">View</a>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card mb-4 bg-secondary">
                    <img alt="Mobile" class="card-img-top" src="${pageContext.request.contextPath}/resources/images/mobile.jpg">
                    <div class="card-body">
                        <h5 class="card-title">Mobile</h5>
                        <p class="card-text">Posts about mobile app development.</p>
                        <a class="btn btn-outline-info" href="/mobile">View</a>
                    </div>
                </div>
            </div>

        </div>
    </div>

</main>

<footer class="footer text-muted">
    <div class="container">
        <p class="float-right">
            <a class="text-info" href="#">Back to top</a>
        </p>
        <p>Just a Forum &copy;</p>
    </div>
</footer>
<!-- Bootstrap script-->
<script src="${pageContext.request.contextPath}/resources/bootstrap-4.6.0-dist/js/jquery-3.5.1.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap-4.6.0-dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

