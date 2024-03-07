<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<h1>Edit Budget Details</h1>
<form action="/trip/editBudget/${tripId}" method="post" enctype="multipart/form-data">
    <input type="text" name="id" value="${budgetTracker.getId()}" hidden="">
    <div class="form-group">
        <label>Total Budget</label>
        $<input type="number" name="totalbudget" value="${budget}" readonly>
    </div>
    <div class="form-group">
        <label>Transportation Budget</label>
        $<input type="number" name="transportationBudget" step="0.01" value="${budgetTracker.getTransportationBudget()}"><br>
    </div>
    <div class="form-group">
        <label>Accommodation Budget</label>
        $<input type="number" name="accommodationBudget" step="0.01" value="${budgetTracker.getAccommodationBudget()}"><br>
    </div>
    <div class="form-group">
        <label>Meals Budget</label>
        $<input type="number" name="mealsBudget" step="0.01" value="${budgetTracker.getMealsBudget()}"><br>
    </div>
    <div class="form-group">
        <label>Activities Budget</label>
        $Activities:<input type="number" name="activitiesBudget" step="0.01" value="${budgetTracker.getActivitiesBudget()}"><br>
    </div>
    <button>Submit</button>
    <button type="reset">Reset</button>
</form>
</div>

<br>
<div class="container">
    <a href="/trip/home"><button>Back to Trips</button></a>
</div>
</body>
</html>