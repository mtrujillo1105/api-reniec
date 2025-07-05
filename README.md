# API Subsistema DNI

## 1.Servicio de autenticación

http://localhost:8080/authenticate

![Authenticate](https://github.com/ccjuantrujillo/api-reniec/blob/main/documentation/images/authenticate.png)

El usuario y clave a utilizar para la autenticación del canal 4 es el siguiente:

![Usuario](https://github.com/ccjuantrujillo/api-reniec/blob/main/documentation/images/usuario.png)

## 2.Servicio consulta DNI RENIEC 

http://localhost:8080/dni/valida

![Valida DNI](https://github.com/ccjuantrujillo/api-reniec/blob/main/documentation/images/valida_dni1.png)

![Valida DNI](https://github.com/ccjuantrujillo/api-reniec/blob/main/documentation/images/valida_dni2.png)

Debido a que el consumo de este api genera un costo por consulta, se sugiere que no se trate de realizar pruebas recurrentes que tal vez no resulten necesarias, asimismo es importante considerar utilizar el api con el canal y empresa correcta, dado que los costos lo asumirán cada empresa que esté utilizando el servicio.

## 3.Modelo entidad – relación

Las tablas documento e inmueble, no se usan.

![Entidad Relación](https://github.com/ccjuantrujillo/api-reniec/blob/main/documentation/images/er.png)

## 4.Arquitecteura de la solución

![Arquitectura](https://github.com/ccjuantrujillo/api-reniec/blob/main/documentation/images/arquitectura.png)

El sistema está conformado por 3 partes un servidor MQ (Reniec), un servicio en Azure y un servicio en el datacenter que se conecta con el servidor de RENIEC MQ
4.1Servidor IBM MQ
4.2Servidor Mysql
4.3Servidor MongoDB