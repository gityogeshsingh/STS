<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
 <c:choose>
 <c:when test="${!empty allEmpList}">
 <h1><a href="./">Click here to go home</a></h1>
 <h1 style="text-align:center;">${result}</h1>
 <a href="emp_add">Add</a>
 <h1 style="text-align:center;">Emplyee_Report</h1>
 <table align="center" border="1" color="grey">
 <tr><th>EID</th><th>ENAME</th><th>AGE</th><th>SALARY</th><th>DESIGINATON</th></tr>
 
 <c:forEach items="${allEmpList}" var="emp">
    <tr>
    <td>${emp.eid}</td><td>${emp.ename}</td><td>${emp.age}</td><td>${emp.salary}</td><td>${emp.desiginaton}</td>
    <td><a href="emp_edit?eno=${emp.eid}">edit</a>  <a href="emp_delete?eno=${emp.eid}">delete</a></td>  
    </tr>
</c:forEach>
 </table>
 </c:when>
 <c:otherwise> <h1 style="text-align:center;">Emplyee not found</h1></c:otherwise>
 </c:choose>
