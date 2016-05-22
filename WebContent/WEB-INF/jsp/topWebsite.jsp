<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
	<head>
		
		<title>Top Website Ranking</title>
		<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

		<script>
			function onload()
			{
				document.getElementsByName("order")[0].checked = true;
				ClickSorting();
			}
			
			function ClickButtonRefresh(form)
			{
				if (document.getElementsByName("typeSearch")[0].value == "orderByDate")
				{
					if(document.getElementsByName("dateString")[0].value == "")
					{
						alert("Please choose date");
					}
				}
			}
	
			function ChangeOrderAsc()
			{
				if (document.getElementsByName("order")[1].checked == true)
				{
					document.getElementsByName("order")[1].checked = false;
				}
			}
	
			function ChangeOrderDesc()
			{
				if (document.getElementsByName("order")[0].checked == true)
				{
					document.getElementsByName("order")[0].checked = false;
				}	
			}
	
			function ClickSorting()
			{
				if (document.getElementsByName("typeSearch")[0].value == "orderByDate")
				{
					document.getElementsByName("dateString")[0].disabled = false;
				}
				else
				{
					document.getElementsByName("dateString")[0].disabled = true;
				}
			}
		</script>
	</head>
	
	<body onload="onload();">


		
	
		<form:form  modelAttribute="topWebsite" action="topWebsite" method="get">				
	
			<div align="center">
		
				<table border="1">
					<col width="100">
   					<col width="280">
   					<col width="130">
					<tr >
						<td rowspan="1">
							<center><b>Sorting By</b></center>				
						</td>
						<td>		
							<form:select name="typeSearch" path="typeSearch" onclick="ClickSorting()">
								<form:option value="orderByDate">Date</form:option>
								<form:option value="orderByWebsite">Website</form:option>
								<form:option value="orderByVisits">Visits</form:option>
							</form:select>						
							<form:input type="date" path="dateString" name="dateString" />								
						</td>
						<td>							
							<center><p><b><form:radiobutton path="order" value="ascending" label="Ascending" onclick="ChangeOrderAsc()" /></b></p></center>
							<center><p><b><form:radiobutton path="order" value="descending" label="Descending" onclick="ChangeOrderDesc()" /></b></p></center>															
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
							<b>Record per page  </b>
							<form:select name="limit" path="limit">
								<form:option value="5">5</form:option>
								<form:option value="10">10</form:option>
								<form:option value="15">15</form:option>
								<form:option value="20">20</form:option>
								<form:option value="25">25</form:option>
								<form:option value="30">30</form:option>
								<form:option value="35">35</form:option>
								<form:option value="40">40</form:option>								
								<form:option value="45">45</form:option>
								<form:option value="50">50</form:option>																
							</form:select>	
						</td>
						<td>
						</td>				
					</tr>
					<tr>
						<td colspan="3" align="center">
							<INPUT TYPE="submit" VALUE="Refresh" ONCLICK="ClickButtonRefresh(this)">
						</td>
					</tr>			
				</table>
				
					
				<caption><h2>List of website</h2></caption>
			
				<table border="1">
				  	<col width="10">
   					<col width="100">
   					<col width="250">
   					<col width="150">
					<tr>
						<th>No</th>
						<th>Date</th>
						<th>Website</th>
						<th>Visits</th>
					</tr>
					<c:forEach var="listValue" items="${lists}">
						<tr>
							<td><center><c:out value="${listValue.no}" /></center></td>
							<td><center><c:out value="${listValue.date}" /></center></td>
							<td><center><c:out value="${listValue.name}" /></center></td>
							<td><center><c:out value="${listValue.visitCount}" /></center></td> 
						</tr>				
					</c:forEach>	
				</table>
			</div>
		</form:form>			
	</body>
</html>
