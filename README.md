# LAPTOPS API REST

Proyecto Spring boot con las dependencias / starters:
Starters para Persistencia:
* Spring Data-jpa
* H2
  Starters para web:
* Spring Web
* Spring boot Devtools

Aplicación API REST con acceso a base de datos H2 para persistir la información.

El acceso se puede realizar desde Postman o Navegador.

## Entidad Laptop

1. Laptop
2. LaptopRepository
3. LaptopService
4. LaptopController
    * Buscar todas las laptops
    * Buscar una sola laptop
    * Crear una nueva laptop
    * Actualizar una laptop existente
    * Borrar una laptop
    * Borrar todas las laptops

## Documentación con Swagger
* SwaggerConfig
* http://localhost:8080/swagger-ui/

## Testing del Controlador
1. LaptopControllerTest
