<%@ include file="common/header.jspf"%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" >Travel Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/trip/home">Home <span class="sr-only">(current)</span></a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<h1 style="color: green;">${pos}</h1>
<h1 style="color: red;">${neg}</h1>
<div class="container">
    <h1>Login Page</h1>
    <form action="/user/login" method="post">
            <table class="table">
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" required></td>
                </tr>

                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" required></td>
                </tr>

                <tr>
                    <td><button>Cancel</button></td>
                    <td><button>Submit</button></td>
                </tr>
            </table>
    </form>

</div>
</body>
</html>