<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>

<frm:form modelAttribute="emp">
<tr><td>Employee Registration Page</td></tr></br>
<tr><td>Employee Eno. :</td><td><frm:input path="eid" readonly="true"/></td></tr></br>
<tr><td>Employee Ename. :</td><td><frm:input path="ename"/></td></tr></br>
<tr><td>Employee Age :</td><td><frm:input path="age"/></td></tr></br>
<tr><td>Employee Salary :</td><td><frm:input path="salary"/></td></tr></br>
<tr><td>Employee Desiginaton :</td><td><frm:input path="desiginaton"/></td></tr></br>
<tr><td><input type="submit" value="register1"></td></tr>
</frm:form>
 <h1><a href="./">Click here to go home</a></h1>

