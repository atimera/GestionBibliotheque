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

---------------------------------------------------------------------------------------

-- INSERT PERSONS
INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE)
VALUES(300000, 'Claude', 'Delannoy', 'M', sysdate());

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE)
VALUES(300001, 'Jean', 'Dupond', 'M', sysdate());

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE)
VALUES(300002, 'Marine', 'Mendes', 'F', sysdate());

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE)
VALUES(300003, 'Thierry', 'Richard', 'M', sysdate());

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE)
VALUES(300004, 'Paul', 'Sifessalam', 'M', sysdate());

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE)
VALUES(300005, 'Yacine', 'foudj', 'M', sysdate());

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE)
VALUES(300006, 'Issa', 'Tall', 'M', sysdate());

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE)
VALUES(300007, 'Franck', 'Petit', 'M', sysdate());

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE)
VALUES(300008, 'Audré', 'Gomis', 'F', sysdate());

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE)
VALUES(300009, 'Pauline', 'Millet', 'F', sysdate());

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE)
VALUES(300010, 'Aimé', 'Lecompbe', 'M', sysdate());

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE)
VALUES(300011, 'Laurent', 'Audibert', 'M', sysdate());

INSERT INTO PERSON(ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE)
VALUES(300012, 'Hamza', 'Touré', 'M', sysdate());

---------------------------------------------------------------------------------------

-- PERSON_ADDRESS
INSERT INTO PERSON_ADDRESS(PERSON_ID, ADDRESS_ID)
VALUES(300000, 100010);

INSERT INTO PERSON_ADDRESS(PERSON_ID, ADDRESS_ID)
VALUES(300001, 100001);

INSERT INTO PERSON_ADDRESS(PERSON_ID, ADDRESS_ID)
VALUES(300002, 100002);

INSERT INTO PERSON_ADDRESS(PERSON_ID, ADDRESS_ID)
VALUES(300003, 100009);

INSERT INTO PERSON_ADDRESS(PERSON_ID, ADDRESS_ID)
VALUES(300004, 100004);

INSERT INTO PERSON_ADDRESS(PERSON_ID, ADDRESS_ID)
VALUES(300005, 100006);

INSERT INTO PERSON_ADDRESS(PERSON_ID, ADDRESS_ID)
VALUES(300006, 100003);

INSERT INTO PERSON_ADDRESS(PERSON_ID, ADDRESS_ID)
VALUES(300007, 100007);

INSERT INTO PERSON_ADDRESS(PERSON_ID, ADDRESS_ID)
VALUES(300008, 100001);

INSERT INTO PERSON_ADDRESS(PERSON_ID, ADDRESS_ID)
VALUES(300009, 100011);

INSERT INTO PERSON_ADDRESS(PERSON_ID, ADDRESS_ID)
VALUES(300010, 100011);

INSERT INTO PERSON_ADDRESS(PERSON_ID, ADDRESS_ID)
VALUES(300011, 100012);

-- INSERT INTO PERSON_ADDRESS(PERSON_ID, ADDRESS_ID)
-- VALUES(300012, null)














-- INSERT AUTHORS
INSERT INTO AUTHOR(ID)
VALUES(300000);

INSERT INTO AUTHOR(ID)
VALUES(300003);

INSERT INTO AUTHOR(ID)
VALUES(300011);

---------------------------------------------------------------------------------------

-- INSERT LIBRARIES
INSERT INTO LIBRARY(ID, NAME, PHONE_NUMBER, ADDRESS_ID)
VALUES(200000, 'Bibliothèque de France', '01 64 76 38 00', 100005);

INSERT INTO LIBRARY(ID, NAME, PHONE_NUMBER, ADDRESS_ID)
VALUES(200001, 'Bibliothèque Sainte-Geneviève', '01 40 46 30 97', 100006 );

INSERT INTO LIBRARY(ID, NAME, PHONE_NUMBER, ADDRESS_ID)
VALUES(200002, 'BULAC - Bibliothèque universitaire des langues et civilisations', '01 81 69 18 00', 100007 );

---------------------------------------------------------------------------------------

-- INSERT BOOKS
INSERT INTO BOOK(ID, TITLE, DATE_OF_PUBLICATION, COVER, LIBRARY_ID)
VALUES(400000, 'Programmer en Java', sysdate(), '', 200000);

INSERT INTO BOOK(ID, TITLE, DATE_OF_PUBLICATION, COVER, LIBRARY_ID )
VALUES(400001, 'Développez des application web  java', sysdate(), '', 200000);

INSERT INTO BOOK(ID, TITLE, DATE_OF_PUBLICATION, COVER, LIBRARY_ID )
VALUES(400002, 'UML2 de lappprentissage à la pratique', sysdate(), '', 200000);

INSERT INTO BOOK(ID, TITLE, DATE_OF_PUBLICATION, COVER, LIBRARY_ID )
VALUES(400003, 'Programmer en Java Edition 2', sysdate(), '', 200001);

INSERT INTO BOOK(ID, TITLE, DATE_OF_PUBLICATION, COVER, LIBRARY_ID )
VALUES(400004, 'Java EE - Développez des application "web" en java', sysdate(), '', 200001);

INSERT INTO BOOK(ID, TITLE, DATE_OF_PUBLICATION, COVER, LIBRARY_ID )
VALUES(400005, 'Dammy Book', sysdate(), '', 200002);

---------------------------------------------------------------------------------------

-- INSERT BOOKCOPIES todo relation between copy, member and employee

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500000, 1, sysdate(), sysdate(), sysdate(), 'PEJ1001', 400000,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500002, 1, sysdate(), sysdate(), sysdate(), 'JEEDDAWEJ1001', 400001,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500001, 1, sysdate(), sysdate(), sysdate(), 'UML2DAALP10001', 400002,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500004, 1, sysdate(), sysdate(), sysdate(), 'JEEDDAWEJ1002', 400001,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500003, 1, sysdate(), sysdate(), sysdate(), 'UML2DAALP10002', 400002,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500005, 1, sysdate(), sysdate(), sysdate(), 'PEJ1002', 400000,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500006, 1, sysdate(), sysdate(), sysdate(), 'JEEDDAWEJ1003', 400001,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500007, 1, sysdate(), sysdate(), sysdate(), 'UML2DAALP10003', 400002,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500008, 1, sysdate(), sysdate(), sysdate(), 'JEEDDAWEJ1004', 400001,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500009, 1, sysdate(), sysdate(), sysdate(), 'UML2DAALP10004', 400002,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500010, 1, sysdate(), sysdate(), sysdate(), 'PEJ1003', 400000,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500012, 1, sysdate(), sysdate(), sysdate(), 'JEEDDAWEJ1005', 400001,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500013, 1, sysdate(), sysdate(), sysdate(), 'UML2DAALP10005', 400003,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500014, 1, sysdate(), sysdate(), sysdate(), 'JEEDDAWEJ1006', 400001, null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500015, 1, sysdate(), sysdate(), sysdate(), 'UML2DAALP10006', 400004,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500016, 1, sysdate(), sysdate(), sysdate(), 'PEJ1004', 400000,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500017, 1, sysdate(), sysdate(), sysdate(), 'JEEDDAWEJ1007', 400001,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500018, 1, sysdate(), sysdate(), sysdate(), 'UML2DAALP10007', 400002,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500019, 1, sysdate(), sysdate(), sysdate(), 'JEEDDAWEJ1008', 400004,null, null);

 INSERT INTO BOOKCOPY(ID, available, DATE_OF_LEND, DATE_OF_PURCHASE, DATE_OF_RETURN, REFERENCE, BOOK_ID, EMPLOYEE_ID, member_id)
 VALUES(500020, 1, sysdate(), sysdate(), sysdate(), 'DB10000', 400005,null, null);

---------------------------------------------------------------------------------------

-- INSERT AUTHOR_BOOK
INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
VALUES(300000, 400000);

INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
VALUES(300003, 400001);

INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
VALUES(300011, 400002);

INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
VALUES(300000, 400003);

INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
VALUES(300003, 400004);

INSERT INTO AUTHOR_BOOK(AUTHOR_ID, BOOK_ID )
VALUES(300003, 400005);

-------------------------------------------------------------------------------------

-- INSERT USERS
INSERT INTO USER(ID, EMAIL, USERNAME, PASSWORD, REGISTERED_AT, ENABLED )
VALUES(300002, null, 'j_dupond', '123456', sysdate(), 1);

INSERT INTO USER(ID, EMAIL, USERNAME, PASSWORD, REGISTERED_AT, ENABLED )
VALUES(300004, null, 'm_memdoza', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', sysdate(), 0);

INSERT INTO USER(ID, EMAIL, USERNAME, PASSWORD, REGISTERED_AT, ENABLED )
VALUES(300005, null, 'yacine', 'Ode_P,de%oe', sysdate(), 1);

INSERT INTO USER(ID, EMAIL, USERNAME, PASSWORD, REGISTERED_AT, ENABLED )
VALUES(300006, null, 'issa', 'oooooo', sysdate(), 1);

INSERT INTO USER(ID, EMAIL, USERNAME, PASSWORD, REGISTERED_AT, ENABLED )
VALUES(300007, 'franck93@gmail.com', 'franck', 'azerty', sysdate(), 1);

INSERT INTO USER(ID, EMAIL, USERNAME, PASSWORD, REGISTERED_AT, ENABLED )
VALUES(300008, null, 'audré', 'ppoaz,dz', sysdate(), 1);

INSERT INTO USER(ID, EMAIL, USERNAME, PASSWORD, REGISTERED_AT, ENABLED )
VALUES(300009, null, 'pauline', 'paulinelabest', sysdate(), 0);

INSERT INTO USER(ID, EMAIL, USERNAME, PASSWORD, REGISTERED_AT, ENABLED )
VALUES(300010, 'aime@gmail.com', 'aimé', '_aimé_', sysdate(), 1);

INSERT INTO USER(ID, EMAIL, USERNAME, PASSWORD, REGISTERED_AT, ENABLED )
VALUES(300012, 'laenzo@hotmail.com', 'laenzo', 'laenzo', sysdate(), 1);


---------------------------------------------------------------------------------------

-- INSERT MEMBERS
INSERT INTO MEMBER(ID )
VALUES(300002);

INSERT INTO MEMBER(ID )
VALUES(300004);

INSERT INTO MEMBER(ID )
VALUES(300005);

INSERT INTO MEMBER(ID )
VALUES(300006);

INSERT INTO MEMBER(ID )
VALUES(300007);

---------------------------------------------------------------------------------------

-- INSERT EMPLOYEE
INSERT INTO EMPLOYEE(ID, LIBRARY_ID)
VALUES(300009, 200000);

INSERT INTO EMPLOYEE(ID, LIBRARY_ID )
VALUES(300010, 200000);

INSERT INTO EMPLOYEE(ID, LIBRARY_ID )
VALUES(300012, 200000);

--------------------------------------------------------------------------------------

-- INSERT LIBRARIES MEMBERS
INSERT INTO LIBRARY_MEMBER(LIBRARY_ID, MEMBER_ID)
VALUES(200000, 300002);

INSERT INTO LIBRARY_MEMBER(LIBRARY_ID, MEMBER_ID)
VALUES(200000, 300004);

INSERT INTO LIBRARY_MEMBER(LIBRARY_ID, MEMBER_ID)
VALUES(200000, 300005);

INSERT INTO LIBRARY_MEMBER(LIBRARY_ID, MEMBER_ID)
VALUES(200000, 300006);

INSERT INTO LIBRARY_MEMBER(LIBRARY_ID, MEMBER_ID)
VALUES(200000, 300007);

INSERT INTO LIBRARY_MEMBER(LIBRARY_ID, MEMBER_ID)
VALUES(200001, 300005);

INSERT INTO LIBRARY_MEMBER(LIBRARY_ID, MEMBER_ID)
VALUES(200001, 300006);

INSERT INTO LIBRARY_MEMBER(LIBRARY_ID, MEMBER_ID)
VALUES(200001, 300007);

INSERT INTO LIBRARY_MEMBER(LIBRARY_ID, MEMBER_ID)
VALUES(200002, 300007);

--------------------------------------------------------------------------------------

