<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<h1>Expense Log</h1>
<h2>----the itinerary of ${name}</h2>
<form action="/itinerary/expenseLog/${tripId}/${itinerary.getId()}" method="post" enctype="multipart/form-data">
    <input type="text" name="id" value="${itinerary.getId()}" hidden="">
    <div class="form-group">
        <label>Transportation Fee</label>
        $<input type="number" name="transportationExpense" step="0.01" placeholder="Enter values" value="${expenseLog.getTransportationExpense()}" required>
    </div>
    <div class="form-group">
        <label>Accommodation Fee</label>
        $<input type="number" name="accommodationExpense" step="0.01" placeholder="Enter values" value="${expenseLog.getAccommodationExpense()}" required>
    </div>
    <div class="form-group">
        <label>Meals Fee</label>
        $<input type="number" name="mealsExpense" step="0.01" placeholder="Enter values" value="${expenseLog.getMealsExpense()}" required>
    </div>
    <div class="form-group">
        <label>Activities Fee</label>
        $<input type="number" name="activitiesExpense" step="0.01" placeholder="Enter values" value="${expenseLog.getActivitiesExpense()}" required>
    </div>

    <button>Submit</button>
    <button type="reset">Reset</button>
</form>
</div>

<br>
<div class="container">
<a href="/itinerary/home/${tripId}"><button>Back to itineraries</button></a>
</div>
</body>
</html>
