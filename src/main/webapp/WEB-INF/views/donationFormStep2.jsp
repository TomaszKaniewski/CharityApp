<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="2" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok 2/4 </div>

        <form method="post">
            <div data-step="2" class="active">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <input type="number" name="bags" step="1" min="1" max="100"/>
                    </label>
                </div>
                <c:if test="${error =='amountError'}">
                    <h1 style="color: red" >Proszę podać liczbę z zakresu 1 - 100</h1>
                </c:if>
                <c:if test="${error =='emptyFieldError'}">
                    <h1 style="color: red" >Proszę wybrać liczbę worków</h1>
                </c:if>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Dalej</button>
                </div>
            </div>

        </form>
    </div>
</section>

<%--<%@ include file="footer.jsp" %>--%>

<script src="<c:url value="/resources/js/app.js"/>"></script>

</body>
</html>
