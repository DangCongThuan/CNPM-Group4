<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<c:set var = "salary" scope = "session" value = "${2000*2}"/>
<c:out value = "${salary}"/>
</body>
</html>
