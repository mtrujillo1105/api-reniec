

USE `configuration`;

/*Table structure for table `canal` */

DROP TABLE IF EXISTS `canal`;

CREATE TABLE `canal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `empresa` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `canal` */

insert  into `canal`(`id`,`codigo`,`empresa`,`descripcion`,`estado`) values 
(2,'1','1','La Protectora',1),
(3,'1','5','Caja Trujillo',1),
(4,'1','4','Canal 1',1),
(5,'1','5','Canal 1',1),
(6,'1','6','Canal 1',1),
(7,'1','7','Canal 1',1);

/*Table structure for table `empresa` */

DROP TABLE IF EXISTS `empresa`;

CREATE TABLE `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `codigo_reniec` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `servidor` varchar(255) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `empresa` */

insert  into `empresa`(`id`,`codigo`,`codigo_reniec`,`descripcion`,`servidor`,`estado`) values 
(2,'2',NULL,'La Protectora',NULL,1),
(3,'5',NULL,'Caja Trujillo',NULL,1),
(4,'4','KUBRO','Kubro planes de salud','http://localhost:8090/mq/request',1),
(5,'5','CONMEDI','Consorcio Médico Descentralizado','http://localhost:8091/mq/request',1),
(6,'6','SABSA','Sistemas Alternativos de Beneficios','http://localhost:8092/mq/request',1),
(7,'7','PROCOR','La Protectora Corredores de Seguros','http://localhost:8093/mq/request',1);

/*Table structure for table `hook_uris_destino` */

DROP TABLE IF EXISTS `hook_uris_destino`;

CREATE TABLE `hook_uris_destino` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_empresa` varchar(255) DEFAULT NULL,
  `codigo_canal` varchar(255) DEFAULT NULL,
  `uri_destino` varchar(2000) DEFAULT NULL,
  `estado` int(11) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `hook_uris_destino` */

insert  into `hook_uris_destino`(`id`,`codigo_empresa`,`codigo_canal`,`uri_destino`,`estado`) values 
(1,'1','1','',1),
(2,'4','4','',0),
(3,'5','5','',1),
(4,'6','6','',1),
(5,'7','7','',1);

/*Table structure for table `parametro_correo` */

DROP TABLE IF EXISTS `parametro_correo`;

CREATE TABLE `parametro_correo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad_tiempo` bigint(20) DEFAULT NULL,
  `cod_canal` varchar(255) DEFAULT NULL,
  `cod_empresa` varchar(255) DEFAULT NULL,
  `tipo_correo` bigint(20) DEFAULT NULL,
  `unidad_tiempo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `parametro_correo` */

insert  into `parametro_correo`(`id`,`cantidad_tiempo`,`cod_canal`,`cod_empresa`,`tipo_correo`,`unidad_tiempo`) values 
(1,2,'1','2',1,'MES'),
(2,20,'1','2',2,'DIA');

/*Table structure for table `parametro_ruc` */

DROP TABLE IF EXISTS `parametro_ruc`;

CREATE TABLE `parametro_ruc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad_tiempo` bigint(20) DEFAULT NULL,
  `cod_canal` varchar(255) DEFAULT NULL,
  `cod_empresa` varchar(255) DEFAULT NULL,
  `unidad_tiempo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `parametro_ruc` */

insert  into `parametro_ruc`(`id`,`cantidad_tiempo`,`cod_canal`,`cod_empresa`,`unidad_tiempo`) values 
(1,1,'1','2','DIA'),
(3,15,'2','2','DIA');

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;
SET SESSION innodb_strict_mode=OFF;
CREATE TABLE `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido_materno` varchar(255) DEFAULT NULL,
  `block` varchar(255) DEFAULT NULL,
  `casada` varchar(255) DEFAULT NULL,
  `cod_constancia_votacion` varchar(255) DEFAULT NULL,
  `cod_continente_domicilio` varchar(255) DEFAULT NULL,
  `cod_continente_nacimiento` varchar(255) DEFAULT NULL,
  `cod_departamento_domicilio` varchar(255) DEFAULT NULL,
  `cod_departamento_nacimiento` varchar(255) DEFAULT NULL,
  `cod_distrito_domicilio` varchar(255) DEFAULT NULL,
  `cod_distrito_nacimiento` varchar(255) DEFAULT NULL,
  `cod_estado_civil` varchar(255) DEFAULT NULL,
  `cod_grado_instruccion` varchar(255) DEFAULT NULL,
  `cod_pais_domicilio` varchar(255) DEFAULT NULL,
  `cod_pais_nacimiento` varchar(255) DEFAULT NULL,
  `cod_provincia_domicilio` varchar(255) DEFAULT NULL,
  `cod_provincia_nacimiento` varchar(255) DEFAULT NULL,
  `cod_restriccion` varchar(255) DEFAULT NULL,
  `cod_sexo` varchar(255) DEFAULT NULL,
  `constancia_votacion` varchar(255) DEFAULT NULL,
  `continente_domicilio` varchar(255) DEFAULT NULL,
  `continente_nacimiento` varchar(255) DEFAULT NULL,
  `departamento_domicilio` varchar(255) DEFAULT NULL,
  `departamento_nacimiento` varchar(255) DEFAULT NULL,
  `descripcion_prefijo_block` varchar(255) DEFAULT NULL,
  `descripcion_prefijo_departamento` varchar(255) DEFAULT NULL,
  `descripcion_prefijo_urbanizacion` varchar(255) DEFAULT NULL,
  `digito` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `distrito_domicilio` varchar(255) DEFAULT NULL,
  `distrito_nacimiento` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `domicilio` varchar(255) DEFAULT NULL,
  `error` varchar(255) DEFAULT NULL,
  `estado_civil` varchar(255) DEFAULT NULL,
  `estatura` varchar(255) DEFAULT NULL,
  `etapa` varchar(255) DEFAULT NULL,
  `fecha_emision` varchar(255) DEFAULT NULL,
  `fecha_inscripcion` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` varchar(255) DEFAULT NULL,
  `grado_instruccion` varchar(255) DEFAULT NULL,
  `interior` varchar(255) DEFAULT NULL,
  `lote` varchar(255) DEFAULT NULL,
  `manzana` varchar(255) DEFAULT NULL,
  `materno` varchar(255) DEFAULT NULL,
  `mensaje_error` varchar(255) DEFAULT NULL,
  `nombre_block` varchar(255) DEFAULT NULL,
  `nombre_madre` varchar(255) DEFAULT NULL,
  `nombre_padre` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `numero_direccion` varchar(255) DEFAULT NULL,
  `pais_domicilio` varchar(255) DEFAULT NULL,
  `pais_nacimiento` varchar(255) DEFAULT NULL,
  `paterno` varchar(255) DEFAULT NULL,
  `prefijo_block` varchar(255) DEFAULT NULL,
  `prefijo_departamento` varchar(255) DEFAULT NULL,
  `prefijo_direccion` varchar(255) DEFAULT NULL,
  `prefijo_urbanizacion` varchar(255) DEFAULT NULL,
  `provincia_domicilio` varchar(255) DEFAULT NULL,
  `provincia_nacimiento` varchar(255) DEFAULT NULL,
  `reservado` varchar(255) DEFAULT NULL,
  `restriccion` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `urbanizacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `persona` */

/*Table structure for table `token` */

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token` (
  `id` bigint(20) DEFAULT NULL,
  `tokens` varchar(255) DEFAULT NULL,
  `estado` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `token` */

/*Table structure for table `transaccion` */

DROP TABLE IF EXISTS `transaccion`;

CREATE TABLE `transaccion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anio` bigint(20) DEFAULT NULL,
  `ape_materno` varchar(255) DEFAULT NULL,
  `ape_paterno` varchar(255) DEFAULT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `chasis` varchar(255) DEFAULT NULL,
  `clase` varchar(255) DEFAULT NULL,
  `codigo_agente` varchar(255) DEFAULT NULL,
  `codigo_canal` varchar(255) DEFAULT NULL,
  `departamento` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `distrito` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `estado` bigint(20) DEFAULT NULL,
  `estado_evo` bigint(20) DEFAULT NULL,
  `fec_reg` datetime DEFAULT NULL,
  `fec_vig_fin` datetime DEFAULT NULL,
  `fec_vig_inicio` datetime DEFAULT NULL,
  `id_categoria` bigint(20) DEFAULT NULL,
  `id_certificado` bigint(20) DEFAULT NULL,
  `id_clase` bigint(20) DEFAULT NULL,
  `id_cotizacion` varchar(255) DEFAULT NULL,
  `id_departamento` varchar(255) DEFAULT NULL,
  `id_distrito` varchar(255) DEFAULT NULL,
  `id_marca` bigint(20) DEFAULT NULL,
  `id_modelo` bigint(20) DEFAULT NULL,
  `id_poliza` bigint(20) DEFAULT NULL,
  `id_provincia` varchar(255) DEFAULT NULL,
  `id_recibo` bigint(20) DEFAULT NULL,
  `id_tipo_documento` bigint(20) DEFAULT NULL,
  `id_tipo_persona` bigint(20) DEFAULT NULL,
  `id_transaccion` bigint(20) DEFAULT NULL,
  `id_uso` bigint(20) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `monto` float DEFAULT NULL,
  `nombre_completo` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `nro_doc` varchar(255) DEFAULT NULL,
  `nro_opera` varchar(255) DEFAULT NULL,
  `num_asientos` bigint(20) DEFAULT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `provincia` varchar(255) DEFAULT NULL,
  `serie` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipo_documento` varchar(255) DEFAULT NULL,
  `tipo_persona` varchar(255) DEFAULT NULL,
  `tipo_via` bigint(20) DEFAULT NULL,
  `ubigeo` varchar(255) DEFAULT NULL,
  `uso` varchar(255) DEFAULT NULL,
  `via` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `transaccion` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(60) DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`ID`,`USERNAME`,`PASSWORD`,`ESTADO`) values 
(1,'laprotectora','laprotectora',1),
(2,'cajatrujillo','123456',1);

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `canal` varchar(255) DEFAULT NULL,
  `registro` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `modificacion` datetime DEFAULT NULL,
  `estado` char(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `usuario` */

insert  into `usuario`(`id`,`username`,`password`,`canal`,`registro`,`modificacion`,`estado`) values 
(6,'martin','$2a$10$78Y.ipxRixRaGWGOrNqvCOkFgNwg5BPaQ3EOwo8gLWkwyxBfGBuaW','4','2021-07-16 16:34:59',NULL,'1'),
(9,'pedro','$2a$10$04kqLNMXD83EoCP0AE5pAO0o32ZRlx9J8OOqLVDhG25wsXZ0A.Cha','5','2021-07-16 16:35:05',NULL,'1'),
(10,'user22','$2a$10$7TPCe.AxzRW2ELP5Hnj24.QGfLBY0ivRSylRtowdcmHQrh9jrG3R2','25','2022-02-22 23:06:36',NULL,'1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
