Feature: Como usuario final
  necesito ingresar al sistema
  con el fin de cumplir de ingresar al page home

  Scenario: Ingreso de un usuario final con login exitoso.
    Given que el usuario final se encuentra en la página del login
    When el usuario final ingresa user y password validos
    Then el sistema deberá mostrar por pantalla el mensaje de bienvenida

