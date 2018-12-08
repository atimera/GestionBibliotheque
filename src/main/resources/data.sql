-- INSERT ADDRESS
INSERT INTO ADDRESS(ID, ADDRESS, ADDRESS2, POSTAL_CODE, CITY)
VALUES(100001, '15 avenue auguste renoir', 'Résidence la renardiere', '77680', 'Roissy en brie' );

INSERT INTO ADDRESS(ID, ADDRESS, ADDRESS2, POSTAL_CODE, CITY)
VALUES(100002, '20 Rue du près', '', '75008', 'Paris' );

INSERT INTO ADDRESS(ID, ADDRESS, ADDRESS2, POSTAL_CODE, CITY)
VALUES(100003, '6 Allée Emile Roux', '', '77420', 'Champs sur marne' );

INSERT INTO ADDRESS(ID, ADDRESS, ADDRESS2, POSTAL_CODE, CITY)
VALUES(100004, '10 Allée Eugène Pottier', '', '77420', 'Champs sur marne' );

INSERT INTO ADDRESS(ID, ADDRESS, ADDRESS2, POSTAL_CODE, CITY)
VALUES(100005, '14 Avenue Gutenberg', '', '77600', 'Bussy-Saint-Georges' );

INSERT INTO ADDRESS(ID, ADDRESS, ADDRESS2, POSTAL_CODE, CITY)
VALUES(100006, '17 Rue de la Sorbonne', '', '75005', 'Paris' );

INSERT INTO ADDRESS(ID, ADDRESS, ADDRESS2, POSTAL_CODE, CITY)
VALUES(100007, '65 Rue des Grands Moulins', '', '75013', 'Paris' );

INSERT INTO ADDRESS(ID, ADDRESS, ADDRESS2, POSTAL_CODE, CITY)
VALUES(100008, '10 Allée Eugène Pottier', '', '77420', 'Champs sur marne' );

INSERT INTO ADDRESS(ID, ADDRESS, ADDRESS2, POSTAL_CODE, CITY)
VALUES(100009, 'Rue Benjamin Franklin', 'ZAC du Moulin Neuf', '44800', 'Saint HERBLAIN' );

INSERT INTO ADDRESS(ID, ADDRESS, ADDRESS2, POSTAL_CODE, CITY)
VALUES(100010, '61 Boulevard Saint-Germain', '', '75240', 'Paris' );

INSERT INTO ADDRESS(ID, ADDRESS, ADDRESS2, POSTAL_CODE, CITY)
VALUES(100011, '9 Avenue Saint-Germain', '', '92240', 'malakoff' );

INSERT INTO ADDRESS(ID, ADDRESS, ADDRESS2, POSTAL_CODE, CITY)
VALUES(100012, '32 Rue Bargue', '', '75740', 'PARIS' );


--------------------------------------------------------------------------------------

-- INSERT LIBRARIES
INSERT INTO LIBRARY(ID, NAME, PHONE_NUMBER, ADDRESS_ID)
VALUES(200000, 'Bibliothèque de France', '01 64 76 38 00', 100005);

INSERT INTO LIBRARY(ID, NAME, PHONE_NUMBER, ADDRESS_ID)
VALUES(200001, 'Bibliothèque Sainte-Geneviève', '01 40 46 30 97', 100006 );

INSERT INTO LIBRARY(ID, NAME, PHONE_NUMBER, ADDRESS_ID)
VALUES(200002, 'BULAC - Bibliothèque universitaire des langues et civilisations', '01 81 69 18 00', 100007 );


---------------------------------------------------------------------------------------

-- INSERT PERSONS
INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, ADDRESS_ID)
VALUES(300000, 'Claude', 'Delannoy', 'M', sysdate(), 100010);

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, ADDRESS_ID)
VALUES(300001, 'Jean', 'Dupond', 'M', sysdate(), 100001);

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, ADDRESS_ID)
VALUES(300002, 'Marine', 'Mendes', 'F', sysdate(), 100002);

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, ADDRESS_ID)
VALUES(300003, 'Thierry', 'Richard', 'M', sysdate(), 100009);

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, ADDRESS_ID)
VALUES(300004, 'Paul', 'Sifessalam', 'M', sysdate(), 100004);

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, ADDRESS_ID)
VALUES(300006, 'Issa', 'Tall', 'M', sysdate(), 100003);

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, ADDRESS_ID)
VALUES(300007, 'Franck', 'Petit', 'M', sysdate(), 100001);

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, ADDRESS_ID)
VALUES(300008, 'Audré', 'Gomis', 'F', sysdate(), 100001);

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, ADDRESS_ID)
VALUES(300009, 'Pauline', 'Millet', 'F', sysdate(), 100011);

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, ADDRESS_ID)
VALUES(300010, 'Aimé', 'Lecompbe', 'M', sysdate(), 100011);

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, ADDRESS_ID)
VALUES(300011, 'Laurent', 'Audibert', 'M', sysdate(), 100012);

---------------------------------------------------------------------------------------

-- INSERT AUTHORS
INSERT INTO AUTHOR(ID)
VALUES(300000);

INSERT INTO AUTHOR(ID)
VALUES(300003);

INSERT INTO AUTHOR(ID)
VALUES(300011);

---------------------------------------------------------------------------------------

-- INSERT BOOKS
INSERT INTO BOOK(ID, TITLE, DATE_OF_PUBLICATION, COVER )
VALUES(400000, 'Programmer en Java', sysdate(), '');

INSERT INTO BOOK(ID, TITLE, DATE_OF_PUBLICATION, COVER )
VALUES(400001, 'Java EE - Développez des application web ev java', sysdate(), '');

INSERT INTO BOOK(ID, TITLE, DATE_OF_PUBLICATION, COVER )
VALUES(400002, 'UML2 de lappprentissage à la pratique', sysdate(), '');

---------------------------------------------------------------------------------------

-- INSERT BOOKCOPIES

-- INSERT INTO BOOKCOPY(ID, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, LENDER_ID)
-- VALUES(500000, sysdate(), sysdate(), sysdate(), 'PEJ1001', 400000, '' , '');
--
-- INSERT INTO BOOKCOPY(ID, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, LENDER_ID)
-- VALUES(500002, sysdate(), sysdate(), sysdate(), 'JEEDDAWEJ1001', 400001, '' , '');
--
-- INSERT INTO BOOKCOPY(ID, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, LENDER_ID)
-- VALUES(500003, sysdate(), sysdate(), sysdate(), 'UML2DAALP10001', 400002, '' , '');

---------------------------------------------------------------------------------------

-- INSERT AUTHOR_BOOK
INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
VALUES(300000, 400000);

INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
VALUES(300003, 400001);

INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
VALUES(300011, 400002);

---------------------------------------------------------------------------------------

-- -- INSERT USERS
-- INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
-- VALUES(300000, 400000);
--
-- INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
-- VALUES(300003, 400001);
--
-- INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
-- VALUES(300011, 400002);
--
-- ---------------------------------------------------------------------------------------
--
-- -- INSERT MEMBERS
-- INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
-- VALUES(300000, 400000);
--
-- INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
-- VALUES(300003, 400001);
--
-- INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
-- VALUES(300011, 400002);
--
-- ---------------------------------------------------------------------------------------
--
-- -- INSERT EMPLOYEE
-- INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
-- VALUES(300000, 400000);
--
-- INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
-- VALUES(300003, 400001);
--
-- INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
-- VALUES(300011, 400002);

---------------------------------------------------------------------------------------

