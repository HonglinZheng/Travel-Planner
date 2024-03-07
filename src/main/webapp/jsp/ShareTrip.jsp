<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container">
<h1>Friend invitation!</h1>
</div>

<div class="container">
<form action="/trip/share/${id}" method="post">
    Enter Email: <input type="text" name="email" required>
    <button>Submit</button>
</form>
</div>
<br>
<div class="container">
<a href="/trip/home"><button>Cancel</button></a>
<div>
</body>
</html>
