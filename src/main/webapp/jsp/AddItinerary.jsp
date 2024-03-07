<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<h1>Add Itinerary Details</h1>
<form action="/itinerary/add/${tripId}" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label>Name</label>
        <input type="text" name="name" required>
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
        <input type="text" name="location" required>
    </div>
    <div class="form-group">
        <label>Attraction</label>
        <input type="text" name="attraction">
    </div>
    <div class="form-group">
        <label>WeatherForecast</label>
        <select name="weatherForecast">
            <option value="">Select Weather</option>
            <option value="Sunny">Sunny</option>
            <option value="Cloudy">Cloudy</option>
            <option value="Rainy">Rainy</option>
            <option value="Snowy">Snowy</option>
        </select>
    </div>
    <div class="form-group">
        <label>Detail</label>
        <input type="text" name="detail">
    </div>
    <div class="form-group">
        <label>Safety Tips</label>
        <input type="text" name="safetyTips">
    </div>
    <button>Add</button>
    <button type="reset">Reset</button>
</form>
</div>
<div class="container">
<a href="/itinerary/home/${tripId}"><button>Back to Itineraries</button></a>
</div>
</body>
</html>