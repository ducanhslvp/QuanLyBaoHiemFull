
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REGISTER</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: 	#008080">
        <div>
            <a href="" class="navbar-brand"> REGISTER </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="index.jsp"
                   class="nav-link">LOGIN</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body" style="background-color:lightcyan">
                <form action="insert" method="post">

                    <caption>
                        <h2>REGISTER</h2>
                    </caption>
                    <fieldset class="form-group" >
                        <label>User Name</label> <input type="text" class="form-control"
                                                        name="username" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Password</label> <input type="text" class="form-control"
                                                       name="password">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Phone Number</label> <input type="text" class="form-control"
                                                       name="phoneNumber">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>FirstName</label> <input type="text" class="form-control"
                                                           name="firstName">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>MiddleName</label> <input type="text" class="form-control"
                                                           name="middleName">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Last Name</label> <input type="text" class="form-control"
                                                           name="lastName">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Age</label> <input type="text" class="form-control"
                                                  name="age">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Country</label> <input type="text" class="form-control"
                                                   name="country">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>City</label> <input type="text" class="form-control"
                                                           name="city">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Street</label> <input type="text" class="form-control"
                                                           name="street">
                    </fieldset>


                    <button type="submit" class="btn btn-success">Register</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>