<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@page import="java.util.List"%>
<%@page import="com.project275.travelplaner.entity.Recommend"%>
<div class="container">
<h1> Administrator Page </h1>
</div>


<div class="container">
<%
    List<Recommend> recommendations = (List<Recommend>) request.getAttribute("recommendations");
%>
<table class="table">
    <tr>
        <th>City</th>
        <th>Recommendation</th>
    </tr>
    <%
        for (Recommend recommendation : recommendations) {
    %>
    <tr>
        <td><%= recommendation.getCity() %></td>
        <td><%= recommendation.getRecommendation() %></td>
    </tr>
    <%
        }
    %>
</table>
</div>


<div class="container">
<a href="/administrator/add"><button>Add New Recommendation</button></a>
</div>

</body>
</html>