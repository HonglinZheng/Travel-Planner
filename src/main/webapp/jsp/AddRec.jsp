<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<h1>Add a new recommendation</h1>
<form action="/administrator/add" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label>City</label>
        <input type="text" name="city" required>
    </div>

    <div class="form-group">
        <label>Recommendation</label>
        <input type="text" name="recommendation" required>
    </div>
    <button>Add</button>
    <button type="reset">Reset</button>
</form>

</div>

<div class="container">
<a href="/administrator/view"><button>Back to Recommendations</button></a>
</div>

</body>
</html>