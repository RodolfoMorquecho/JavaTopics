# Base de Datos

Una base de datos, es una colección de datos almacenados de forma organizada con una lógica coherente.
Las bases de datos permiten compartir estos datos entre distintos usuarios y programas, con lo cual se
facilita el intercambio y consulta de información sin importar la ubicación geográfica.

En una base de datos, las entidades y atributos del mundo real, se convierten en registros y campos.
Estas entidades pueden ser tanto objetos materiales como libros o fotografías, pero tambien personas e,
incluso, conceptos o ideas abstractas.

## ¿Que es XAMPP?

Es un paquete de software libre que consiste principalmente en el sistema de gestion de base de datos
"MySQL", ademas provee algunas otras herramientas como, un servidor web "Apache" y los interpretes para
lenguajes de programación, como lo son, "PHP" y "Perl". La gran ventaja de trabajar con XAMPP es, que es una
distribucíón de apache completamente gratuita, lo que quiere decir, es que no se necesita comprar
ninguna licencia para poder utilizarlo. La otra gran ventaja es que cuenta con sistema de gestión de base
de datos en MySQL, y MySQL tambien es un software libre que no requiere que se compre ningun tipo de
licencia.


Permite montar un servidor local en nuestra PC, de esta manera podremos crear y gestionar bases de datos
que mas adelante concectaremos con nuestros desarrollos en java.


## Configuración XAMPP

- Presionar "start" en los modulos de "Apache" y "MySQL" en el panel de control inicial.

![](1PanelDeControl.png)

- Abrira una página donde esta el host de la base de datos que se creara, conocido como "localhost".
  Quiere decir que ya estamos dentro del servidor local que acabamos de instalar, por lo que ya se puede
  comenzar a crear y gestionar bases de datos para posteriormente conectarlas con Java.

![](2LocalHost.png)

## Creación de Base de Datos en XAMPP

- Se selecciona la opción "Base de Datos".

![](3SeleccionBaseDeDatos.png)

- Dentro del apartado "Base de Datos", tendremos al inicio 2 campos de texto, en el primero se inidica
  el nombre que tendra la "bd", y en el segundo se indica el tipo de cotejamiento, es decír, el tipo de
  caracteres que se van a utilizar, por ejemplo se suelen usar acentos, pero si no se utiliza la opción
  "utf8_unicode_ci" se mostraran simbolos extraños en su lugar.

- Se dara click en crear.

![](4CrearBaseDeDatos.png)

- Ya creada la base de datos, ahora se debe de crear una tabla, a la cual nombraremos "alumnos" y posteriormente
  indicar el "Número de columnas" que se utilizaran, es decír, el número de campos que va a tener la tabla.
  En este caso, usaremos 3 ya que se colocara un número de identificación(id), nombre y grupo al que pertenece.

- Dar click en "Continuar".

![](5CrearTabla.png)

- Se puede observar los apartados que se deben de llenar para las 3 columnas que previamente reservamos.

![](5_1Resultadotabla.png)

- Se llenara la tabla, explicación con columna ID:
  -Nombre: ID
  -Tipo: INT(Entero)
  -Longitud/Valores: 50(El numéro como maximo puede tener 50 digitos)
  -Cotejamiento: utf8_unicode_ci
  -Indice: Solo para el identificador "ID" se asigna el "primary key"(Llave primaria que permite relacionar tablas entre sí)
  -A_I: Seleccionar como marcado(Hace referencia a que cada que entre un nuevo registro, se auto-incrementa el ID)
  -Los campos no mencionados se pueden dejar como estan predeterminados.

- Por lo regular cuando se trabaja con nombres como variable, se utiliza el tipo "VARCHAR" ya que va de una long. de 0 a 65.

![](6LlenadoDeTabla.png)

- El "Comentario de tabla" generalmente se escribe para otro programador que vaya a trabajar con ella.
- El cotejamiento se utiliza el mismo que el de las columnas y el motor de almacenamiento se deja configurado como esta.
- Dar click en "Guardar".

![](7ComentarioDeTabla.png)


- Se tienen listos los 3 campos de la tabla, por lo que ya se puede iniciar a ingresar valores en la base de datos,
  mediante la conección de los programas desarrollados en Java.

![](8BaseDeDatosLista.png)