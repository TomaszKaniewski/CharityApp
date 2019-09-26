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
    <title>Summary</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<section class="form--steps">
    <div class="form--steps-container">
        <form method="post">
            <div data-step="4" class="active">
                <div data-step="5">
                    <h3>Podsumowanie Twojej darowizny</h3>

                    <div class="summary">
                        <div class="form-section">
                            <h4>Oddajesz:</h4>
                            <ul>
                                <li>
                                    <span class="icon icon-bag"></span>
                                    <span class="summary--text"
                                    >${donationDetails.quantity}</span
                                    >
                                </li>

                                <li>
                                    <span class="icon icon-hand"></span>
                                    <span class="summary--text"
                                    >Dla fundacji ${donationDetails.institution.name}</span
                                    >
                                </li>
                            </ul>
                        </div>

                        <div class="form-section form-section--columns">
                            <div class="form-section--column">
                                <h4>Adres odbioru:</h4>
                                <ul>
                                    <li>${donationDetails.street}</li>
                                    <li>${donationDetails.city}</li>
                                    <li>${donationDetails.zipCode}</li>
                                    <li>${donationDetails.phoneNumber}</li>
                                </ul>
                            </div>

                            <div class="form-section--column">
                                <h4>Termin odbioru:</h4>
                                <ul>
                                    <li>${donationDetails.pickUpDate}</li>
                                    <li>${donationDetails.pickUpTime}</li>
                                    <li>${donationDetails.pickUpComment}</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Popraw</button>
                        <button type="submit" class="btn">Potwierdź</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>

<script src="<c:url value="/resources/js/app.js"/>"></script>

</body>
</html>
