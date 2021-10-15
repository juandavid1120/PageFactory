Feature: Inicios de sesión
  Como un usuario registrado del sistema
  nececito validar que las operaciones de logueo y disponibilidad al sitio web
  para poder tener seguridad en el perfil de los usuarios

  Scenario: login exitoso
    Given el usuario está en l apágina de inicio de sesión con el correo de usuario "eve.holt@reqres.in" y la contraseña "cityslicka"
    When cuando el usuario hace una petición de inicio
    Then el usuario deberá ver un código de respuesta exitoso y un token de respuesta
