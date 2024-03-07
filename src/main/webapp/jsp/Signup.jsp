<%@ include file="common/header.jspf"%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
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

<div class="container">
<form action="/user/signup" method="post"
      enctype="multipart/form-data">
    <fieldset style="width: 40vw">
        <h2> Join Us </h2>
        <table class="table">
            <tr>
                <th>Name:</th>
                <th><input type="text" name="name" required></th>
            </tr>

            <tr>
                <th>Email:</th>
                <th><input type="email" name="email" required></th>
            </tr>

            <tr>
                <th>Mobile:</th>
                <th><input type="text" name="mobile"></th>
            </tr>

            <tr>
                <th>Password:</th>
                <th><input type="password" name="password" required></th>
            </tr>

            <tr>
                <th><label>DOB: </label></th>
                <th><input type="date" name="dob"></th>
            </tr>

            <tr>
                <th><button>Signup</button></th>
                <th><button type="reset">Reset</button></th>
            </tr>

        </table>
    </fieldset>
</form>
</div>


</body>
</html>