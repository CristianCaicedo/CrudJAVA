package app;

import myJDBC.MyJDBC;

public class App {

    public static MyJDBC myJDBC;

    public static void main(String[] args) {
        myJDBC = new MyJDBC("bdeco","root","");
        System.out.println(myJDBC.ConnectionMyDB());
        Create();
        Read();
        Update();
        Delete();
    }
    public static void Create(){
        /*Llenando la tabla bicicletas*/
        myJDBC.CREATE("insert into bicicletas values (1001,'Cannondale',1200000,2020);");
        myJDBC.CREATE("insert into bicicletas values (1002,'Trek',1450000,2019);");
        myJDBC.CREATE("insert into bicicletas values (1003,'Yeti',2000000,2020);");
        myJDBC.CREATE("insert into bicicletas values (1004,'Fuji',950000,2021);");
        myJDBC.CREATE("insert into bicicletas values (1005,'Bmc',1950000,1018);");

        /*Llenando la tabla clientes*/
        myJDBC.CREATE( "insert into clientes values ('lucky','Pedro','Perez','lucky@gmail.com','3115844540',16475487,'1990-07-10')," +
                "('malopez','Maria','Lopez','malopez@gmail.com','3153456778',21543578,'1988-01-20')," +
                "('diva','Ana','Diaz','diva@gmail.com','3104656771',51457899,'1997-05-05'),"+
                "('dreamer','Luis','Rojas','dreamer@hotmail.com','3112278451',12345764,'2000-11-22'),"+
                "('ninja','Andres','Cruz','ninja@hotmail.com','3145254776',34478944,'1995-09-15'),"+
                "('neon','Nelson','Ruiz','neon@hotmail.com','3158221234',94524532,'1985-08-07'),"+
                "('rose','Claudia','Mendez','rose@gmail.com','3148584474',75456811,'2001-06-19'),"+
                "('green','Jorge','Rodriguez','green@gmail.com','3106124435',85645877,'1999-02-16');");

        /*Llenando la tabla fabricantes*/
        myJDBC.CREATE( "insert into fabricantes values ('Cannondale')," +
                "('Trek'),('Yeti'),('Fuji'),('Bmc'),('Starker'),('Lucky Lion'),('Be Electric'),('Aima')," +
                "('Mec de Colombia'),('Atom Electric');");

        /*Llenando la tabla proveedor*/

        myJDBC.CREATE("insert into proveedor values (101,'Auteco','calle 7 No. 45-17','05713224459');");
        myJDBC.CREATE("insert into proveedor values (102,'Hitachi','calle 19 No. 108-26','05714223344');");
        myJDBC.CREATE("insert into proveedor values (103,'Bosch','carrera 68 No. 26-45','05715678798');");
        myJDBC.CREATE("insert into proveedor values (104,'Teco','calle 77 No. 68-33','05712213243');");
        myJDBC.CREATE("insert into proveedor values (105,'General Electric','calle 29 No. 26-12','05717239919');");

        /*Llenado tabla compra*/
        myJDBC.CREATE("insert into compras values (101,'lucky','Cannondale','2017-10-25 20:00:00');");
        myJDBC.CREATE("insert into compras values (102,'lucky','Trek','2019-03-15 18:30:00');");
        myJDBC.CREATE("insert into compras values (103,'lucky','Starker','2019-05-20 20:30:00');");
        myJDBC.CREATE("insert into compras values (104,'malopez','Cannondale','2018-05-20 20:30:00');");
        myJDBC.CREATE("insert into compras values (105,'malopez','Starker','2020-01-20 20:30:00');");
        myJDBC.CREATE("insert into compras values (106,'diva','Yeti','2019-05-20 20:30:00');");
        myJDBC.CREATE("insert into compras values (107,'diva','Fuji','2018-06-22 21:30:00');");
        myJDBC.CREATE("insert into compras values (108,'diva','Lucky Lion','2020-03-17 15:30:20');");
        myJDBC.CREATE("insert into compras values (109,'dreamer','Lucky Lion','2020-03-17 15:30:20');");
        myJDBC.CREATE("insert into compras values (110,'dreamer','Be Electric','2020-04-10 18:30:20');");
        myJDBC.CREATE("insert into compras values (111,'ninja','Aima','2020-02-17 20:30:20');");
        myJDBC.CREATE("insert into compras values (112,'ninja','Starker','2020-02-17 20:30:20');");
        myJDBC.CREATE("insert into compras values (113,'ninja','Mec de Colombia','2020-03-27 18:30:20');");
        myJDBC.CREATE("insert into compras values (114,'rose','Atom Electric','2020-03-20 21:30:20');");
        myJDBC.CREATE("insert into compras values (115,'green','Yeti','2020-01-10 17:30:20');");
        myJDBC.CREATE("insert into compras values (116,'green','Trek','2020-02-15 20:30:20');");
        myJDBC.CREATE("insert into compras values (117,'green','Bmc','2020-03-17 18:30:20');");

        /*Llenado tabla motocicletas*/
        myJDBC.CREATE("insert into motocicletas values (2001,'Starker',4200000,18,101);");
        myJDBC.CREATE("insert into motocicletas values (2002,'Lucky Lion',5600000,14,102);");
        myJDBC.CREATE("insert into motocicletas values (2003,'Be Electric',4600000,26,101);");
        myJDBC.CREATE("insert into motocicletas values (2004,'Aima',8000000,36,103);");
        myJDBC.CREATE("insert into motocicletas values (2005,'Mec de Colombia',5900000,20,104);");
        myJDBC.CREATE("insert into motocicletas values (2006,'Atom Electric',4500000,12,105);");

    }
    public static void Read(){
        String query;
        String[] listaCabeceras;
        /*Primer Consulta*/
        System.out.println("\n\n+++++++++++++\n\t Primera Consulta");
        query = "select fabricante from fabricantes order by fabricante;";
        listaCabeceras = new String[]{"fabricante"};
        myJDBC.READ(query, listaCabeceras, 1);

        /*Segunda Consulta*/
        System.out.println("\n\n+++++++++++++\n\t Segunda Consulta");
        query = "select * from bicicletas where año >= 2019 order by fabricante;";
        listaCabeceras = new String[]{"fabricante","precio","año"};
        myJDBC.READ(query, listaCabeceras, 3);

        /*Tercer Consulta*/
        System.out.println("\n\n+++++++++++++\n\t Tercer Consulta");
        query = "select fabricante from motocicletas where id_prov=101;";
        listaCabeceras = new String[]{"fabricante"};
        myJDBC.READ(query, listaCabeceras, 1);

        /*Cuarta Consulta*/
        System.out.println("\n\n+++++++++++++\n\t Cuarta Consulta");
        query = "select fabricante from compras where alias=\"lucky\" order by fabricante;";
        listaCabeceras = new String[]{"fabricante"};
        myJDBC.READ(query, listaCabeceras, 1);

        /*Quinta Consulta*/
        System.out.println("\n\n+++++++++++++\n\t Quinta Consulta");
        query = "select c.alias, c.nombre, c.apellidos from clientes c, compras p where p.alias=c.alias and p.fabricante=\"Yeti\" order by nombre;";
        listaCabeceras = new String[]{"c.alias","c.nombre","c.apellidos"};
        myJDBC.READ(query, listaCabeceras, 3);

        /*Sexta Consulta*/
        System.out.println("\n\n+++++++++++++\n\t Sexta Consulta");
        query = "select count(fabricante) from bicicletas where año >= 2019;";
        listaCabeceras = new String[]{"count(fabricante)"};
        myJDBC.READ(query, listaCabeceras, 1);
    }

    public static void Update(){
        String query;
        /*Actualizacion 1*/
        query = "update bicicletas set año=2017 where fabricante=\"Cannondale\";";
        myJDBC.UPDATE(query);

        /*Actualizacion 2*/
        query = "update clientes set celular=3115678432 where alias='ninja';";
        myJDBC.UPDATE(query);
    }

    public static void Delete(){
        String query;
        /*PRIMER DELTE*/
        query = "delete from compras where alias=\"green\" and fabricante=\"Trek\";";
        myJDBC.DELETE(query);
    }
}
