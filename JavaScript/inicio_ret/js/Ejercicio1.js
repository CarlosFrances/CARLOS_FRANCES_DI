/**
 * Nada mas arrancar la pagina, aparece un cuadro pidiendo el nombre
 * Si he metido nombre, aparece un cuadro de dialogo indicando que introduzca un operador
 * Aparece un cuadro de dialogo indicando que introduzca un operador
 * Aparece un cuadro de dialogo de confirmación con el texto "nombre", quieres ver todas las operaciones entre "4" y "7"
 *      - En el caso de pulsar SI
 *          - Se mostrara un cuadro de dialogo de alerta con cada una de las oepraciones x+y = resultado
 *          - Se mostrara un cuadro de dialogo de alerta con cada una de las oepraciones x-y = resultado
 *          - Se mostrara un cuadro de dialogo de alerta con cada una de las oepraciones x*y = resultado
 *          - Se mostrara un cuadro de dialogo de alerta con cada una de las oepraciones x/y = resultado
 *          - Se mostrara un cuadro de dialogo de alerta con cada una de las oepraciones x%y = resultado
 *      - En el caso de pulsar NO
 *          - Se mostrara un cuadro de alerta indicando que el proceso termina
 *
 * Comprobación de errores:
 *      - Si no introduzco nombre o uno de los operandos no es un numero, no deberia continuar con el proceso
 */
let nombre = prompt("Escribe tu nombre: ");
let operador1, operador2;
let aceptar = false;
if (nombre != null) operador1 = prompt("Primer operando: ");
if (!isNaN(operador1)) {
  operador2 = prompt("Segundo operando: ");
  if (!isNaN(operador2)) {
    if (
      confirm(
        `${nombre}, ¿quieres ver todas las operaciones entre ${operador1} y ${operador2}?.`
      )
    ) {
      operador1 = parseInt(operador1);
      operador2 = parseInt(operador2);
      alert(`${operador1} + ${operador2} = ${operador1 + operador2}`);
      alert(`${operador1} - ${operador2} = ${operador1 - operador2}`);
      alert(`${operador1} * ${operador2} = ${operador1 * operador2}`);
      alert(`${operador1} / ${operador2} = ${operador1 / operador2}`);
      alert(`${operador1} % ${operador2} = ${operador1 % operador2}`);
    }
  }
}
