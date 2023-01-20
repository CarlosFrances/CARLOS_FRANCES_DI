// guardar en variable llamada profesores todos los profesores de DAM 1 y DAM 2,
// donde todos los profesores tendran : NOMBRE, APELLIDO Y AASIGNATURAS,
// las asignaturas tendrán NOMBRE, CICLO, CURSO, HORAS

let profesores = [
  {
    nombre: "Fernando",
    apellido: "Sánchez",
    correo: "fernando@gmail.com",
    asignaturas: [
      {
        nombre: "Programacion",
        horas: 8,
        siglas: "PRO",
        ciclo: "DAM",
        curso: 1,
      },
      {
        nombre: "Bases de datos",
        horas: 6,
        siglas: "BD",
        ciclo: "DAM",
        curso: 1,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.correo);
      console.log(this.asignaturas);
    },
  },
  {
    nombre: "Carlos",
    apellido: "Sánchez",
    correo: "carlos@gmail.com",
    asignaturas: [
      {
        nombre: "Entornos de Desarrollo",
        horas: 3,
        siglas: "ED",
        ciclo: "DAM",
        curso: 1,
      },
      {
        nombre: "Sistemas de Gestion Empresarial",
        horas: 3,
        siglas: "SGE",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.correo);
      console.log(this.asignaturas);
    },
  },
  {
    nombre: "Borja",
    apellido: "Martin",
    correo: "borja@gmail.com",
    asignaturas: [
      {
        nombre: "Programacion Multimedia y Dispositivos Moviles",
        horas: 8,
        siglas: "PMDM",
        ciclo: "DAM",
        curso: 2,
      },
      {
        nombre: "Desarrolo de Interfaces",
        horas: 6,
        siglas: "DI",
        ciclo: "DAM",
        curso: 2,
      },
    ],
    mostrarDatos: function () {
      console.log(this.nombre);
      console.log(this.apellido);
      console.log(this.correo);
      console.log(this.asignaturas);
    },
  },
];

profesores.forEach((item) => {
  item.asignaturas.some((i) => i.curso == 1) && item.mostrarDatos();
});

// CREAR UNA FUNCION PARA A BORJA DARLE UNA ASIGNATURA NUEVA

function agregarAsignatura(asignatura) {
  profesores[0].asignaturas.push(asignatura);
}

agregarAsignatura({
  nombre: "Desarrollo de Interfaces",
  horas: 6,
  siglas: "DI",
});

profesores.forEach((item) => {
  item.asignaturas.some((i) => i.curso == 1) && item.mostrarDatos();
});
