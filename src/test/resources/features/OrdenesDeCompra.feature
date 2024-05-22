@pets
Feature: Gestion Ordenes de compra e inventario

  @ConsultarOrden
  Scenario Outline: Consultar una orden de compra existente
    When El usuario consulta la orden <idOrden> en la API
    Then La API responde un estatus code 200
    And El id de la compra es el mismo consultado por el usuario

    Examples:
      | idOrden |
      | 505     |

  @CrearYConsultarOrden
  Scenario: Buscar orden de compra creada
    Given el usuario crea una orden de compra
      | petId | quantity | shipDate                     | status | complete |
      | 20    | 0        | 2024-05-21T16:45:27.968+0000 | placed | true     |
    When el usuario consulta la orden creada anteriormente
    Then el usuario puede ver la orden correctamente

  @Inventario
  Scenario: Verificar el inventario de ventas
    When el usuario consulta las ventas realizadas
    Then el sistema le muestra todos los productos vendidos


    @EliminarOrden
    Scenario: Eliminar una orden de compra
      Given el usuario crea una orden de compra
        | petId | quantity | shipDate                     | status | complete |
        | 20    | 0        | 2024-05-21T16:45:27.968+0000 | placed | true     |
      When el usuario elimina la orden
      Then esta no puede ser consultada