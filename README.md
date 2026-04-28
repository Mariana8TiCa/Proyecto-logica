# Proyecto Lógica – Sistema de Compra

Aplicación de escritorio en **Java + Swing** que simula el flujo básico de una tienda de muebles.

## Funcionalidades

| Opción del menú | Descripción |
|---|---|
| Registrar cliente | Abre un formulario (JDialog) para ingresar documento, nombre y fecha de nacimiento. |
| Registrar un producto | Permite registrar mesas o sillas con sus atributos. |
| Registrar compra | Asocia productos a un cliente registrado y calcula el total (con descuento del 10 % si es el mes de cumpleaños). |

## Cómo ejecutar

```bash
cd Proyecto_logica
mvn compile exec:java
```

## Estructura modular (nuevas clases)

```
com.mycompany.proyecto_logica
├── Cliente.java              → Modelo / entidad del cliente
├── ClienteValidator.java     → Valida los datos antes de crear un cliente
├── ClienteService.java       → Registra y consulta clientes en memoria
├── ClienteRegistroDialog.java→ Formulario Swing (JDialog) de registro
├── Tienda.java               → Ventana principal y menú
├── Mueble.java               → Modelo base de productos
├── Mesa.java                 → Subclase de Mueble
└── Silla.java                → Subclase de Mueble
```

### Flujo de registro de cliente

1. Usuario hace clic en **Menú → Registrar cliente**.
2. Se abre `ClienteRegistroDialog` (ventana modal con campos de texto).
3. Al pulsar **Aceptar**, `ClienteValidator` verifica que los campos no estén vacíos y que la fecha tenga formato `DD/MM/AAAA`.
4. Si la validación pasa, `ClienteService.registrar(cliente)` guarda el cliente en un `HashMap` en memoria.
5. Si el documento ya existe, se muestra un aviso sin cerrar el diálogo.
6. Al pulsar **Cancelar**, el diálogo se cierra sin guardar nada.
