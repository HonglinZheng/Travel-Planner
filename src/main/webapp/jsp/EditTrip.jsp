<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
<h1>Edit Trip Details</h1>
<form action="/trip/update" method="post">
    <input type="text" name="id" value="${trip.getId()}" hidden="">
    <div class="form-group">
        <label>Name</label>
        <input type="text" name="name" value="${trip.getName()}" required>
    </div>

    <div class="form-group">
        <label>Budget</label>
        <input type="number" name="budget" step="0.01" value="${trip.getBudget()}" required min="0">
    </div>

<div class="form-group">
    <label>Start Date</label>
    <input type="date" id="startDate" name="start_date" value="${trip.getStartDate()}" required>
</div>

<div class="form-group">
    <label>End Date</label>
    <input type="date" id="endDate" name="end_date" value="${trip.getEndDate()}" required>
</div>

<script>
    document.getElementById("startDate").addEventListener("input", function() {
        document.getElementById("endDate").setAttribute("min", this.value);
        document.getElementById("endDate").value = "";
    });

    document.getElementById("endDate").addEventListener("input", function() {
        var startDateValue = new Date(document.getElementById("startDate").value);
        var endDateValue = new Date(this.value);
        var dateError = document.getElementById("dateError");

        if (endDateValue < startDateValue) {
            dateError.style.display = "block";
            this.setCustomValidity("End date must be after start date.");
        } else {
            dateError.style.display = "none";
            this.setCustomValidity("");
        }
    });
</script>

    <button>Update</button>
    <button type="reset">Reset</button>
</form>
</div>

<div class="container">
<a href="/trip/home"><button>Back to Trips</button></a>
</div>

</body>
</html>