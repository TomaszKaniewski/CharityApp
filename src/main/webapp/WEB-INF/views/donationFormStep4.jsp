<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <p data-step="4" class="active">
                Podaj adres oraz termin odbioru rzeczy.
            </p>
        </div>
    </div>


    <div class="form--steps-container">
        <div class="form--steps-counter">Krok 4/4</div>

        <form:form method="post"  modelAttribute="donationStep4">
            <div data-step="4" class="active">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label for="Address">Ulica </label>
                            <form:input type="text" path="street" id="Address"/>
                            <form:errors path="street" element="p" cssStyle="color: red; font-size: larger"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label for="City">Miasto </label>
                            <form:input type="text" path="city" id="City"/>
                            <form:errors path="city" element="p" cssStyle="color: red; font-size: larger"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label for="ZipCode">Kod pocztowy </label>
                            <form:input type="text" path="zipCode" id="ZipCode"/>
                            <form:errors path="zipCode" element="p" cssStyle="color: red; font-size: larger"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label for="PhoneNumber">Numer telefonu </label>
                            <form:input type="text" path="phoneNumber" id="PhoneNumber"/>
                            <form:errors path="phoneNumber" element="p" cssStyle="color: red; font-size: larger"/>
                        </div>

                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label for="Date">Data odbioru</label>
                            <form:input type="date" path="pickUpDate" id="Date"/>
                            <form:errors path="pickUpDate" element="p" cssStyle="color: red; font-size: larger"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label for="PickUpTime">Godzina odbioru</label>
                            <form:input type="time" path="pickUpTime" id="PickUpTime"/>
                            <form:errors path="pickUpTime" element="p" cssStyle="color: red; font-size: larger"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                <label for="PickUpTime">Uwagi dla kuriera</label>
                                <form:input textarea="time" path="pickUpComment" id="PickUpTime" rows="5"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Dalej</button>
                </div>
            </div>
        </form:form>
    </div>
</section>

<script src="<c:url value="/resources/js/app.js"/>"></script>

</body>
</html>
