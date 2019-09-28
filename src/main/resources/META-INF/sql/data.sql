insert into institutions (name, description) values ("Dbam o zdrowie", "Pomoc dzieciom z ubogich rodzin.")
insert into institutions (name, description) values ("A kogo", "Pomoc wybudzaniu dzieci ze śpiączki.")
insert into institutions (name, description) values ("Dla dzieci", "Pomoc osobom znajdującym się w trudnej sytuacji życiowej.")
insert into institutions (name, description) values ("Bez domu", "Pomoc dla osób nie posiadających miejsca zamieszkania.")

insert into donations (quantity, phoneNumber, street, city, zipCode, pickUpDate, pickUpTime, pickUpComment, institution_id) values (10, 501011122, "Olszynki Grochowskiej 61", "Warszawa", "04-281", "2019-09-21", "12:50", "Ubrania dla dzieci",1);
insert into donations (quantity, phoneNumber, street, city, zipCode, pickUpDate, pickUpTime, pickUpComment, institution_id) values (5, 790210222, "Łukowska 23", "Warszawa", "03-290", "2019-09-20", "12:50", "Zabawki",1);
insert into donations (quantity, phoneNumber, street, city, zipCode, pickUpDate, pickUpTime, pickUpComment, institution_id) values (7, 690210239, "Metalowców 3", "Warszawa", "04-201", "2019-09-20", "12:50", "Ubrania",4);
insert into donations (quantity, phoneNumber, street, city, zipCode, pickUpDate, pickUpTime, pickUpComment, institution_id) values (7, 555091122, "Marszałkowska 121", "Warszawa", "00-201", "2019-09-23", "18:00", "Podręczniki szkolne",4);


insert into categories (name) values ("Ubrania")
insert into categories (name) values ("Zabawki")
insert into categories (name) values ("Pomoce szkolne")
insert into categories (name) values ("Koce i pościel")

insert into donations_categories values (1, 1)
insert into donations_categories values (2, 2)
insert into donations_categories values (3, 1)
insert into donations_categories values (4, 3)

