<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>
function myFunction(){
    var x = document.getElementById("myName").value + "<BR>" + document.getElementById("myEmail").value ;
    if (x != ""){
        alert("Thank you fill in the fields")
    } else{
        alert("Please don't empty any box")
    }
</script>


</head>
<body>

<font color='green'>${success}</font>
<font color='red'>${error}</font>
       
     
   
     <h2>Update Contact Here</h2>
     <form:form action="updateContact" modelAttribute="contact" method="POST">
     
        <table>
             <tr>
                 <td>Contact Name:-</td>
                 <td><form:input id="myName" type="text" path="contactName" placeholder="Enter ur full name" /></td>
                 
             
             </tr>
             <tr>
                 <td>Contact Email:-</td>
                 <td><form:input id="myEmail" type="text" path="contactEmail" placeholder="Enter ur valid email" /></td>
                
             
             </tr>
             <tr>
                 <td>Contact Number:-</td>
                 <td><form:input type="text" path="contactNumber" placeholder="Enter ur permanent mob"/></td>
                
             
             </tr>
             <tr>
                 <td></td>
                 <td><input type="submit" value="Update"/></td>
             </tr>
        </table>
     
     
     </form:form>
     <a href="viewContacts">View All Contacts</a>

</body>
</html>