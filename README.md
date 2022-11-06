# BACKEND NOVAE - GESTIONAR TARGETAS DE CRÉDITO

Este aplicación permite realizar las operaciones correspondientes a un CRUD (Create, Read, Update and Delete) de las entidades client (cliente), franchise (franquicia) y credit card (targeta de crédito). Además, contiene consultas sql específicas para anaizar la información, incluyendo auditoría de JPA.

## INSTALACIÓN

1. Descargar el proyeto en archivo .ZIP O clonarlo a través de Git.

```
$ git clone https://github.com/CesarTllez/NovaeBackEnd.git
```

2. Dentro del proyecto, actualizar MAVEN para descargar las dependencias necesarias.
3. Dentro de la carpeta [novae\src\main\resources\], modificar las siguientes propiedades del archivo "application.properties":
    
```
#SERVER
server.port=8080 -> Cambiar el puerto (OPCIONAL)

#DATABASE
spring.jpa.database=POSTGRESQL -> Cambiar base de datos (OPCIONAL)
spring.jpa.show-sql=true
spring.datasource.driver-class-name=org.postgresql.Driver -> Si se cambio la BD, cambiar el Driver.
spring.datasource.url=jdbc:postgresql://localhost:5432/novae -> Cambiar el nombre de la base de datos (OPCIONAL).
spring.datasource.username=postgres -> Usuario por defecto de postgreSQL, sino, cambiar.
spring.datasource.password=my_password -> Agregar la contraseña correspondiente al usuario.

#HIBERNATE
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL92Dialect
spring.jpa.hibernate.ddl-auto=update
```

4. Dentro de postgreSQL (Interfáz gráfica o línea de comandos), crear una base de datos llamada "novae" si se dejó la configuración del apartado anterior.

### LÍNEA DE COMANDOS - SQL: 
        
```
CREATE DATABASE novae;
``` 

5. Correr la aplicación desde el IDE.

## RUTAS DEL API REST

1. PATH: `/api/v1`
2. ENDPOINTS:
    - `/clients` -> GET, POST y PUT 
    - `/clients/{id}` -> GET y DELETE
    - `/clients/{id}/cards` -> GET (Punto 7.4)
    - `/clients/stored-process` -> PUT (Punto 7.2 - Procedimiento Almacenado)
    - `/credit-cards` -> GET, POST y PUT
    - `/credit-cards/{id}` -> GET y DELETE
    - `/franchises` -> GET, POST y PUT 
    - `/franchises/{id}` -> GET y DELETE

## EJEMPLOS REGISTROS

1. PATH: /api/v1
2. ENDPOINTS:
- `/clients` -> POST

```
{
    "dni": 1003587456,
    "name": "Usuario Ejemplo",
    "email": "usuarioejemplo@gmail.com"
}
```

- `/clients` -> PUT

```
{
    "id": 1,
    "dni": 1003587456,
    "name": "Usuario Actualizado",
    "email": "usuarioactualizado@gmail.com"
}
```

- `/clients/stored-process` -> PUT

```
{
    "dni": 1003587456,
    "name": "Usuario Actualizado SP",
    "email": "usuariosp@gmail.com"
}
```

- `/credit-cards` -> POST

```
{
    "id": 1,
    "primaryAccountNumber": 4857145886521700,
    "expMonth": 9,
    "expYear": 25,
    "internationalBrand": "MASTER CARD",
    "securityCode": 356,
    "franchise": {
        "id": 1
    },
    "client": {
        "id": 1
    }
}
```

- `/credit-cards` -> PUT

```
{
    "primaryAccountNumber": 4857145886521700,
    "expMonth": 9,
    "expYear": 25,
    "internationalBrand": "MASTER CARD",
    "securityCode": 356
}
```

- `/franchises` -> POST

```
{
    "name": "Franquicia Ejemplo"
}
```

- `/franchises` -> PUT

```
{
    "id": 1,
    "dni": 1003587456,
    "name": "Franquicia Actualizado",
    "email": "franquiciactualizado@gmail.com"
}
```

## QUERIES

### Punto 7

```
SELECT 
    u.id AS id_client, 
    u.name, c.id AS id_card, 
    c.primary_account_number AS pan 
FROM client u
INNER JOIN credit_card c
ON u.id = c.client_id
WHERE u.dni = 1003587456 OR u.email = 'usuarioejemplo@gmail.com';
```

### Punto 7.1

```
CREATE VIEW view_franchise_credit_cards
AS SELECT 
    f.id AS id_franchise, 
    f.name, c.id AS id_card, 
    c.primary_account_number AS pan, 
    c.international_brand AS i_brand
FROM franchise f
INNER JOIN credit_card c
ON f.id = c.franchise_id;
```

```
SELECT * FROM view_franchise_credit_cards;
```

### Punto 7.2

```
CREATE PROCEDURE update_client_procedure(
    nameC VARCHAR,
    emailC VARCHAR,
    dniC BIGINT
)
LANGUAGE SQL
AS $$
    UPDATE client SET name = nameC, email = emailC 
    WHERE dni = dniC;
$$;
```

```
CALL update_client_procedure('Usuario Actualizado SP', 'usuariosp@gmail.com', 1003587456);
```

### Punto 7.5

```
SELECT 
    date_part('day', c.created_date) AS day,
    COUNT(c.name) as clients_quantity
FROM client c
WHERE c.created_date >= '2022-10-07' AND c.created_date <= '2022-12-07'
GROUP BY date_part('day', c.created_date);
```
