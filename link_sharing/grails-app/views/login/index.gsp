<%--
  Created by IntelliJ IDEA.
  User: ashima
  Date: 6/12/2015
  Time: 2:23 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
</head>

<body bgcolor="#AFEEEE">

<br>
<h4 align="right"/><b>LOGIN</b></h4>
<g:form name="LOGIN" controller="login" action="signin" method="post" align="right">
  Username:-  <g:textField name="userName" required=""/><br><br>
  Password:-      <g:passwordField name="password" required=""/><br><br>

  <g:link controller="login" action="forgot" method="post">forgot password</g:link>  &nbsp <g:submitButton
        name="Login"/>
</g:form>
<br><br>
<h4 align="right"><b>REGISTER</b></h4>
<g:form controller="login" action="register" method="post" align="right">
  First Name:-  <g:textField name="fname"/><br><br>
  Last Name:-  <g:textField name="lname"/><br><br>
  Email Id:-  <g:textField name="email"/><br><br>
  User Name:-  <g:textField name="userName"/><br><br>
  Password:-   <g:passwordField name="password"/><br><br>
  Confirm Password:-<g:passwordField name="confirmPassword"/><br><br>
  Photo:- <g:field type="File" name="photo"/><br><br>



  <g:submitButton name="Submit"/>

</g:form>

<g:form controller="login" action="recent" method="post" align="left-top " >

</g:form>



<div id="left" align="right">
  <table  border="1" style="width:100%">
    <tr>
      <th>Resource Title </th>
      <th>Create By </th>
      <th>Description </th>
    </tr>
    <g:each in="${resources}" var="rs">
      <tr>
        <td> ${rs.title}</td>
        <td>${rs.creator}</td>
        <td>${rs.description}</td>
      </tr>
    </g:each><br>

    <g:paginate total="${total}" max="5" params="[q:params.q]"/>
  </table>
  <table border="1" >
    <tr>
      <th>Post Name</th>
    </tr>
    <tr>
      <g:each in="${topic}" var="top">
        <td>${top.name}</td>
      </g:each><br>

    </tr>
  </table>

</div>

</body>
</html>
