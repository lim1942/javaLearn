<%--1 ====================迭代标签--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
         <%--pageEncoding="UTF-8" isELIgnored="false"%>--%>

<%--<%@ taglib prefix="s" uri="/struts-tags"%>--%>

<%--<style>--%>
    <%--table {--%>
        <%--border-collapse: collapse;--%>
    <%--}--%>

    <%--td {--%>
        <%--border: 1px solid gray;--%>
    <%--}--%>
<%--</style>--%>

<%--<table align="center">--%>
    <%--<tr>--%>
        <%--<td>id</td>--%>
        <%--<td>name</td>--%>
        <%--<td>st.index</td>--%>
        <%--<td>st.count</td>--%>
        <%--<td>st.first</td>--%>
        <%--<td>st.last</td>--%>
        <%--<td>st.odd</td>--%>
        <%--<td>st.even</td>--%>

    <%--</tr>--%>

    <%--<s:iterator value="products" var="p" status="st">--%>
        <%--<tr>--%>
            <%--<td>${p.id}</td>--%>
            <%--<td>${p.name}</td>--%>
            <%--<td>${st.index}</td>--%>
            <%--<td>${st.count}</td>--%>
            <%--<td>${st.first}</td>--%>
            <%--<td>${st.last}</td>--%>
            <%--<td>${st.odd}</td>--%>
            <%--<td>${st.even}</td>--%>
        <%--</tr>--%>
    <%--</s:iterator>--%>

<%--</table>--%>

<%--2 ====================checkbox 标签--%>

<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
         <%--pageEncoding="UTF-8" isELIgnored="false"%>--%>

<%--<%@ taglib prefix="s" uri="/struts-tags"%>--%>

<%--<%@page isELIgnored="false"%>--%>

<%--<s:checkboxlist value="selectedProducts" name="product.id"--%>
                <%--list="products" listValue="name" listKey="id" />--%>


<%--3 ====================radio 标签--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
         <%--pageEncoding="UTF-8" isELIgnored="false"%>--%>

<%--<%@ taglib prefix="s" uri="/struts-tags"%>--%>

<%--<%@page isELIgnored="false"%>--%>

<%--<s:radio name="product.id" value="2" list="products" listValue="name"--%>
         <%--listKey="id" />--%>


<%--4 ====================check-box 标签--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page isELIgnored="false"%>

<s:select label="products"
          name="product.id"
          list="products"
          listKey="id"
          listValue="name"
          multiple="true"
          size="3"
          value="selectedProducts"
/>