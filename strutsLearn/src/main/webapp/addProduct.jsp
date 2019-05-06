<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2019-05-05
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%--中文问题--%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<body>

<s:form action="addProduct">

    <s:textfield name="product.name" label="product name" />
    <s:submit value="Submit" />

</s:form>

</body>
</html>
