### 1. Nginx (El Recepcionista Inteligente)

* **¿Qué es `nginx.conf`?**
    Es el "cerebro" de Nginx. Es el archivo de configuración que le dice exactamente qué hacer: qué puertos escuchar, qué sitios web atender y cómo manejar las peticiones.

* **¿Cómo se usa en Docker?**
    Generalmente, creas tu propio archivo `nginx.conf` en tu computadora y usas un **volumen** de Docker para "montarlo" dentro del contenedor, reemplazando el archivo de configuración por defecto.

* **¿Nginx es un Gateway?**
    Sí, actúa como un tipo especial de gateway llamado **Proxy Inverso** (Reverse Proxy). Es como el "recepcionista" de toda tu aplicación.

* **¿Qué hace `proxy_pass`?**
    Es la regla principal del recepcionista. Le dice a Nginx: "Cuando alguien pida algo que empiece con `/api`, no busques un archivo. En lugar de eso, **pasa** esa solicitud a tu servidor de backend (tu API de Spring Boot) que está en `http://backend-api:8080`".

### 2. Dockerfile para Spring Boot (La Receta)

* **¿Qué `FROM` usar?**
    La mejor práctica es usar un **build multi-etapa** para crear imágenes ligeras y seguras.

* **Etapa 1: Build (Construcción)**
    * **Propósito:** Crear tu archivo `.jar`.
    * **`FROM`:** Usa una imagen "grande" que tenga el JDK completo y tu herramienta de build (Maven o Gradle).
    * **Ejemplo:** `FROM maven:3.9-eclipse-temurin-17`

* **Etapa 2: Run (Ejecución)**
    * **Propósito:** Solo ejecutar el `.jar` creado.
    * **`FROM`:** Usa una imagen "pequeña" que solo tenga el JRE (Runtime) y sea segura.
    * **Ejemplo:** `FROM eclipse-temurin:17-jre-alpine` (Alpine es una versión de Linux súper ligera).

### 3. Docker Compose (El Director de Orquesta)

* **Comando Moderno (V2)**
    * **Antes:** `docker-compose up` (con guion).
    * **Ahora:** `docker compose up` (con espacio). Es el mismo comando, pero ahora está integrado directamente en Docker.

* **Versión en `docker-compose.yml`**
    Ya **no es necesario** poner la línea `version: '3.9'` al inicio del archivo. Simplemente omítela y Docker usará la especificación más moderna.

* **Puertos (`ports: "3306:3306"`)**
    Es un mapeo de `[TU_MAQUINA]:[CONTENEDOR]`.
    * **`3306` (Izquierda):** Es el puerto en tu PC (Host). Es el que tú usas para conectarte.
    * **`3306` (Derecha):** Es el puerto *dentro* del contenedor (donde escucha la base de datos).

* **Volúmenes (`driver: local`)**
    Le dice a Docker *cómo* y *dónde* guardar los datos persistentes (como los de tu base de datos).
    * `driver: local`: Significa que los datos se guardan en el disco duro de la máquina donde se está ejecutando Docker. Es perfecto para desarrollo.
    * **En Producción:** Si tienes varios servidores (un cluster), se usan drivers de red o de nube (AWS, Google Cloud) para que los datos se guarden en un lugar centralizado y accesible desde cualquier máquina.