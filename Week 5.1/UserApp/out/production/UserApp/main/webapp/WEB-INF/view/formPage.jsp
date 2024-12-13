
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Form</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/formPageStyle.css">
</head>
<body>
        <h1> welcome to form page</h1>
    <form:form modelAttribute="user" action="processForm" >
        <form:input path="name" placeholder="username" type="text"/>
        <br>
        <form:input path="password" placeholder="password" type="password"/>
        <br>
        <form:select path="nation">
            <form:option value="Egypt" label="Egy"/>
            <form:option value="Brazil" label="Brazil"/>
            <form:option value="Saudia Arabia" label="KSA"/>
            <form:option value="Uinted Kingdom" label="UK"/>
            <form:option value="Uinted States" label="US"/>
            <br>
        </form:select>
        <label>What's your favourite programming language</label><br>

        Java <form:radiobutton path="programmingLanguage" value="Java"/>
        C# <form:radiobutton path="programmingLanguage" value="C# <"/>
        Python <form:radiobutton path="programmingLanguage" value="Python"/>
        JavaScript <form:radiobutton path="programmingLanguage" value="JavaScript"/>


    <br>
    <label>Preferred Operating System</label><br>
    Linux<form:checkbox path="OS" value="linux"/>
    MS Windows<form:checkbox path="OS" value="Windows"/>
    Mac OS<form:checkbox path="OS" value="Mac"/>
        <br>
        <input type="submit">
    </form:form>
</body>
</html>

