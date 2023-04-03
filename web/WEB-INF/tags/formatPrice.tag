<%@ tag body-content="empty" pageEncoding="utf-8" %>
<%@ tag import="java.text.NumberFormat" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="value" required="true" type="java.lang.Integer" %>
<%@ attribute name="additional" required="false" type="java.lang.String" %>
<%
    String formatted = "-";
    if (value != null) {
        formatted = NumberFormat.getInstance().format(value);
        if(additional != null) {
            formatted = formatted.concat(additional);
        }
    }

%>
<%= formatted %>