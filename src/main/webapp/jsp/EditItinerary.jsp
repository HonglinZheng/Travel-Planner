<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<h1>Edit Itinerary Details</h1>
<form action="/itinerary/update/${tripId}" method="post" enctype="multipart/form-data">
    <input type="text" name="id" value="${itinerary.getId()}" hidden="">
    <input type="text" name="expenseSum" value="${itinerary.getExpenseSum()}" hidden="">
    <div class="form-group">
        <label>Name</label>
        <input type="text" name="name" value="${itinerary.getName()}" required>
    </div>
    <div class="form-group">
        <label>Date</label>
        <input type="date" id="date" name="idate" required>
<p>must during the trip period ${trip.getStartDate()} and ${trip.getEndDate()}</p>
    </div>
    <script>
        var startDate = new Date("${trip.getStartDate()}");
        var endDate = new Date("${trip.getEndDate()}");

        var dateInput = document.getElementById("date");
        var dateError = document.getElementById("dateError");

        // Set min and max attributes for the date input field
        dateInput.setAttribute("min", formatDate(startDate));
        dateInput.setAttribute("max", formatDate(endDate));

        dateInput.addEventListener("input", function() {
            var selectedDate = new Date(this.value);

            if (selectedDate < startDate || selectedDate > endDate) {
                dateError.style.display = "block";
                this.setCustomValidity("Date must be during the trip period.");
            } else {
                dateError.style.display = "none";
                this.setCustomValidity("");
            }
        });

        // Function to format date as YYYY-MM-DD
        function formatDate(date) {
            var year = date.getFullYear();
            var month = ("0" + (date.getMonth() + 1)).slice(-2);
            var day = ("0" + date.getDate()).slice(-2);
            return year + "-" + month + "-" + day;
        }
    </script>
    <div class="form-group">
        <label>Location</label>
        <input type="text" name="location" value="${itinerary.getLocation()}" required>
    </div>
    <div class="form-group">
        <label>Attraction</label>
        <input type="text" name="attraction" value="${itinerary.getAttraction()}" required>
    </div>
    <div class="form-group">
        <label>WeatherForecast</label>
        <select name="weatherForecast">
            <option value="" ${itinerary.getWeatherForecast() eq '' ? 'selected' : ''}>Select Weather</option>
            <option value="Sunny" ${itinerary.getWeatherForecast() eq 'Sunny' ? 'selected' : ''}>Sunny</option>
            <option value="Cloudy" ${itinerary.getWeatherForecast() eq 'Cloudy' ? 'selected' : ''}>Cloudy</option>
            <option value="Rainy" ${itinerary.getWeatherForecast() eq 'Rainy' ? 'selected' : ''}>Rainy</option>
            <option value="Snowy" ${itinerary.getWeatherForecast() eq 'Snowy' ? 'selected' : ''}>Snowy</option>
        </select>
    </div>
    <div class="form-group">
        <label>Detail</label>
        <input type="text" name="detail" value="${itinerary.getDetail()}" required>
    </div>
    <div class="form-group">
        <label>Safety Tips</label>
        <input type="text" name="safetyTips" value="${itinerary.getSafetyTips()}" required>
    </div>

    <button>Update</button>
    <button type="reset">Reset</button>
</form>
</div>
<br>
<div class="container">
<a href="/itinerary/home/${tripId}"><button>Back to Itineraries</button></a>
</div>

</body>
</html>