Feature: Como empleado administrativo
  necesito ingresar al sistema los estudiantes de los nuevos ciclos académicos
  con el fin de cumplir las políticas administrativas y de auditoría de la universidad.

  Background:
    Given que el empleado administrativo se encuentra en la página web de los ingresos de estudiantes

  Scenario: Ingreso de un estudiante con los campos obligatorios.
    When el empleado administrativo ingresa los campos obligatorios y confirma la acción
    Then el sistema deberá mostrar por pantalla el registro del estudiante ingresado.

  Scenario: Ingreso de un estudiante usando todos los campos.
    When el empleado administrativo ingresa valores en todos los campos del formulario y confirma la acción
    Then el sistema deberá mostrar por pantalla el registro del estudiante ingresado con todos los campos.

