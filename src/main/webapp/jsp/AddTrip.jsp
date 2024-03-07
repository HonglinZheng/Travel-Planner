<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
<h1>Add Trip Details</h1>
<form action="/trip/add" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label>Name</label>
        <input type="text" name="name" required>
    </div>

    <div class="form-group">
        <label>Budget</label>
        <input type="number" name="budget" step="0.01" required min = "0">
    </div>

    <div class="form-group">
        <label>Start Date</label>
        <input type="date" id="startDate" name="start_date" required>
    </div>

    <div class="form-group">
        <label>End Date</label>
        <input type="date" id="endDate" name="end_date" required>
        <small id="dateError" style="color: red; display: none;">End date must be after start date.</small>
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

    <button>Add</button>
    <button type="reset">Reset</button>

</form>
</div>

<br>
<div class="container">
    <a href="/trip/home"><button>Back</button></a>
</div>
</body>
</html>