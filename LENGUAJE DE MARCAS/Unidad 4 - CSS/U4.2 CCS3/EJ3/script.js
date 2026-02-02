const input = document.getElementById("texto");
const contador = document.getElementById("contador");

const botonMostrar = document.getElementById("mostrarMensaje");
const mensaje = document.getElementById("mensaje");

const botonColor = document.getElementById("cambiarColor");
const colorInfo = document.getElementById("colorInfo");
const contenedor = document.getElementById("contenedor");

const botonMas = document.getElementById("mas");
const botonMenos = document.getElementById("menos");
const numero = document.getElementById("numero");
const numeroInfo = document.getElementById("numeroInfo");

let valor = 0;
let mostrar = true;
let index = 0;

const lista = [
  "rgb(6, 110, 96)",
  "rgba(13, 8, 88, 1)",
  "rgba(112, 122, 16, 1)",
  "rgba(3, 129, 9, 1)",
  "rgba(116, 3, 91, 1)",
];

const colores = [
  "verde pino",
  "azul noche",
  "verde oliva",
  "verde esmeralda",
  "magenta",
];

input.addEventListener("input", function () {
  const cantidad = input.value.length;
  contador.innerHTML =
    "Has escrito " +
    `<span style="color: rgb(164, 255, 164)">${cantidad}</span>` +
    " caracteres.";
});

botonMostrar.addEventListener("click", function () {
  if (mostrar) {
    mensaje.classList.add("show");
    botonMostrar.textContent = "Ocultar mensaje";
  } else {
    mensaje.classList.remove("show");
    botonMostrar.textContent = "Mostrar mensaje";
  }

  mostrar = !mostrar;
});

botonColor.addEventListener("click", function () {
  index++;
  if (index === lista.length) {
    index = 0;
  }

  contenedor.style.backgroundColor = lista[index];

  if (index === 0) {
    colorInfo.innerText = "Color actual: verde pino";
  } else {
    colorInfo.innerText = "Color actual: " + colores[index];
  }
});

botonMas.addEventListener("click", function () {
  valor++;
  numero.innerText = valor;
  actualizarMensaje();
});

botonMenos.addEventListener("click", function () {
  valor--;
  numero.innerText = valor;
  actualizarMensaje();
});

function actualizarMensaje() {
  if (valor > 0) {
    numeroInfo.innerHTML =
      "<span style='color: rgba(164, 255, 136, 1)'>Numero positivo</span>";
  } else if (valor < 0) {
    numeroInfo.innerHTML =
      "<span style='color: rgba(255, 151, 157, 1)'>Numero negativo</span>";
  } else {
    numeroInfo.innerText = "Numero cero";
  }
}
