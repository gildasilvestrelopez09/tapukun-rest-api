CREATE USER 'getit'@'localhost' IDENTIFIED BY 'getit';
GRANT ALL PRIVILEGES ON * . * TO 'getit'@'localhost';

USE getitdb;

INSERT INTO work_area(id, name)
VALUES (1, 'Jardinería');

INSERT INTO work_area(id, name)
VALUES (2, 'Pintura');

INSERT INTO work_area(id, name)
VALUES (3, 'Plomería');

INSERT INTO work_area(id, name)
VALUES (4, 'Electricidad');

INSERT INTO work_area(id, name)
VALUES (5, 'Construcción');

INSERT INTO users(id, address, birthdate, email, firstname, lastname, password, phone, work_area_id)
VALUES (1, 'Av. Simon Lopez #3432', '2000-09-04', 'diego@gmail.com', 'Diego', 'Vallejos', 'diego12V', '75934733', 2);

INSERT INTO users(id, address, birthdate, email, firstname, lastname, password, phone, work_area_id)
VALUES (2, 'Av. America y Libertadores #7634', '1999-02-23', 'santiagoGomez@gmail.com', 'Santiago', 'Gomez', '1234Santi', '67323586', 4);

INSERT INTO publishing(id, address, created, description, publishing_type, tariff, time_required_or_offered, user_id, work_area_id)
VALUES (2, 'Av. Oquendo #7604', '2021-03-20', 'Construcción y montaje de estructuras, perfiles metálicos, costaneras, galvanizado, livianos o viga de madera, para cubiertas de columnas, singles, tejas cerámicas, policarbonatos, lunas mallas + cielo Drywall, PVC, presupuestos.', 'Offer', 2200, 'tiempo completo', 1, 5);

INSERT INTO publishing(id, address, created, description, publishing_type, tariff, time_required_or_offered, user_id, work_area_id)
VALUES (3, 'Av. Soto Mayor #74', '2021-04-25', 'Ofrezco mis servicios de pintura, para departamentos,casas, chalet, etc.', 'Offer', 2600, 'tiempo completo', 2, 5);

INSERT INTO publishing(id, address, created, description, publishing_type, tariff, time_required_or_offered, user_id, work_area_id)
VALUES (5, 'Av. Santa Cruz #764', '2021-03-20', 'Construcción y montaje de estructuras, NECESITO persona para limpieza de lunes a domingo, de 8:30 - 15:30.', 'Demand', 1800, 'tiempo completo', 2, 1);

INSERT INTO publishing(id, address, created, description, publishing_type, tariff, time_required_or_offered, user_id, work_area_id)
VALUES (6, 'Empresa de limpieza requiere personal con experiencia en lavado de alfombras y otros, que sepa utilizar maquinas, con preferencia varón.', 'Demand', 2100, 'tiempo completo', 1, 1);

SET GLOBAL event_scheduler = ON;

DELIMITER $$

CREATE EVENT IF NOT EXISTS event_monthly
    ON SCHEDULE
        EVERY 1 MONTH
    DO
    BEGIN
        DELETE FROM publishing WHERE UNIX_TIMESTAMP(`created`) < (UNIX_TIMESTAMP()-720*3600);
    END $$

DELIMITER ;
