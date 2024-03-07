<%@page import="java.util.Set"%>
<%@page import="com.project275.travelplaner.entity.Trip"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="jumbotron text-center">
  <h1>Travel Planner System</h1>
  <p>Hi, ${userName}! Get started on trip management!</p>
</div>

<div class="container">
<%
    Set<Trip> trips = (Set<Trip>) request.getAttribute("trips");
%>
<table class="table">
    <thead>
    <tr>
        <th>Trip Name</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Budget</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Trip t : trips) {
    %>
    <tr>
        <th><%=t.getName()%></th>
        <th><%=t.getStartDate()%></th>
        <th><%=t.getEndDate()%></th>
        <th>
            $<%=t.getBudget()%>
            <!--<a href="/trip/editBudget/<%=t.getId()%>">
                <button>Adjust Budget</button>
            </a>-->
        </th>
        <th><a href="/trip/edit/<%=t.getId()%>"><button>Edit</button></a></th>
        <th><a href="/trip/delete/<%=t.getId()%>"><button>Delete</button></a></th>
        <th><a href="/trip/share/<%=t.getId()%>"><button>Share</button></a></th>
        <th><a href="/trip/view/<%=t.getId()%>"><button>View Details</button></a></th>
    </tr>
    <%
        }
    %>

    </tbody>
</table><br>
<a href="/trip/add"><button>Create Another Trip</button></a>
<a href="/logout"><button>Logout</button></a>
</body>
</html>