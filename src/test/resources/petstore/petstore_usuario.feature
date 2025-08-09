Feature: Pruebas de API PetStore - Gestión de Usuario
  Background:
    * url 'https://petstore.swagger.io/v2'
    * def usuario =
    """
    {
      "id": 123456,
      "username": "usuario1",
      "firstName": "Juan",
      "lastName": "Pérez",
      "email": "juan@test.com",
      "password": "12345",
      "phone": "999888777",
      "userStatus": 1
    }
    """

  Scenario: Crear un usuario
    Given path 'user'
    And request usuario
    When method POST
    Then status 200
    And match response.message == '123456'

  Scenario: Buscar el usuario creado
    Given path 'user', usuario.username
    When method GET
    Then status 200
    And match response.username == usuario.username

  Scenario: Actualizar el nombre y correo del usuario
    * set usuario.firstName = 'Pedro'
    * set usuario.email = 'pedro@test.com'
    Given path 'user', usuario.username
    And request usuario
    When method PUT
    Then status 200

  Scenario: Buscar el usuario actualizado
    Given path 'user', usuario.username
    When method GET
    Then status 200
    And match response.firstName == 'Pedro'
    And match response.email == 'pedro@test.com'

  Scenario: Eliminar el usuario
    Given path 'user', usuario.username
    When method DELETE
    Then status 200
