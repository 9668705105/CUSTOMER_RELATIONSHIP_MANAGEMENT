<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script defer src="script.js"></script>

</head>
<body>

<font color='green'>${success}</font>
<font color='red'>${error}</font>
       
     
   
     <h2>Save Contact Here</h2>
     <form:form id="form" action="saveContact" modelAttribute="contact" method="POST">
     
        <table>
             <tr>
                 <td>Contact Name:-</td>
                 <td><form:input id="myName" type="text" path="contactName" placeholder="Enter ur full name" required="true" /></td>
                 
             
             </tr>
             <tr>
                 <td>Contact Email:-</td>
                 <td><form:input id="myEmail" type="Email" path="contactEmail" placeholder="Enter ur valid email" required="true" /></td>
                 
             
             </tr>
             <tr>
                 <td>Contact Number:-</td>
                 <td><form:input id="myMob" type="text" path="contactNumber" placeholder="Enter ur permanent mob" required="true"/></td>
                 
             
             </tr>
           
             <tr>
                 <td></td>
                 <td><input id="myButton" type="submit" value="Save" /></td>
             </tr>
        </table>
     
     
     </form:form>
     <a href="viewContacts">View All Contacts</a>

</body>
</html>