<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <meta content="Forum for developers" name="description">
    <meta content="Grupa 2" name="author">

    <title>Sign in</title>

    <!-- Bootstrap css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-4.6.0-dist/css/bootstrap.min.css">

    <!-- Custom styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/auth.css">
</head>

<body>

<div class="container">
    <div class="py-3 text-center mt-5">
        <img alt="JaF" src="${pageContext.request.contextPath}/resources/images/logo_white.png" style="height: 116px; width: 200px;" class="mb-2">
    </div>

    <div class="row">

        <div class="col-md-6 order-md-1 offset-md-3">
            <div class="alert alert-info mb-4" role="alert" th:if="${confirmStart}">
                <h4 class="alert-heading">One more step</h4>
                <p th:text="${confirmStart}"></p>
            </div>

            <div class="alert alert-success mb-4" role="alert" th:if="${confirmDone}">
                <h4 class="alert-heading">Well done!</h4>
                <p th:text="${confirmDone}"></p>
            </div>

            <div class="alert alert-danger mb-4" role="alert" th:if="${confirmError}">
                <h4 class="alert-heading">Error!</h4>
                <p th:text="${confirmError}"></p>
            </div>
        </div>
    </div>

    <div class="row">

        <div class="col-md-4 order-md-1 offset-md-4">

            <form class="needs-validation" role="form" action="/login" method="post">

                <div class="mb-2">
                    <label class="sr-only" for="username">Username</label>
                    <input autofocus class="form-control" id="username" name="loginname" placeholder="Username" required
                           th:classappend="${loginError} ? is-invalid" type="text">
                    <div class="invalid-feedback">
                    </div>
                </div>

                <div class="mb-2">
                    <label class="sr-only" for="password">Password</label>
                    <input class="form-control" id="password" name="password" placeholder="Password" required
                           th:classappend="${loginError} ? is-invalid" type="password">
                    <div class="invalid-feedback">
                        Wrong username or password
                    </div>
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <input name="remember-me" type="checkbox"> Remember me
                    </label>
                </div>

                <button class="btn btn-info btn-lg btn-block mt-4" type="submit">Sign in</button>

                <div class="btn-group btn-group-sm mt-3 btn-block" role="group">
                    <a aria-disabled="true" class="btn btn-outline-info mr-2" href="/signup" role="button">Create new
                        account</a>
                    <a aria-disabled="true" class="btn btn-outline-secondary" href="/" role="button">Back to home
                        page</a>
                </div>

            </form>

        </div>

    </div>
    <footer class="mb-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">Just a Forum</p>
    </footer>
</div>

<!-- Bootstrap script-->
<script src="${pageContext.request.contextPath}/resources/bootstrap-4.6.0-dist/js/jquery-3.5.1.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap-4.6.0-dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
