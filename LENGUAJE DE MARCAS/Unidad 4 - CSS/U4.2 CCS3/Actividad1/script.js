let nombreActual = "";
let numeroActual = "";

const inputNombre = document.getElementById("nombre");
const inputNumero = document.getElementById("numero");
const botonGuardar = document.getElementById("guardar");

const botonCerrarModal = document.getElementById("cerrarModal");
const modal = document.getElementById("modal");
const infoNombre = document.getElementById("infoNombre");
const infoNumero = document.getElementById("infoNumero");

const resultadosAnterioresContenedor = document.getElementById(
  "info-resultados-anteriores",
);

function abrirModal() {
  modal.style.display = "flex";
}

function cerrarModal() {
  modal.style.display = "none";
  mostrarResultadosAnteriores();
}

botonGuardar.addEventListener("click", function () {
  const nombre = inputNombre.value.trim();
  const numero = inputNumero.value.trim();

  if (nombre === "" || numero === "") {
    alert("Por favor, rellena todos los campos");
    return;
  }

  nombreActual = nombre;
  numeroActual = numero;

  infoNombre.innerHTML = `Saludos! Soy <span id="valNombre">${nombre}</span>!`;
  infoNumero.innerHTML = `Numero: <span id="valNumero">${numero}</span>`;

  parImpar.innerHTML = `El numero es <span id="valParImpar" style="color: ${numero % 2 === 0 ? "rgba(164, 255, 136, 1)" : "rgba(255, 151, 157, 1)"}">${numero % 2 === 0 ? "Par" : "Impar"}</span>`;
  primo.innerHTML = `El numero <span id="valPrimo" style="color: ${numero ? "rgba(164, 255, 136, 1)" : "rgba(255, 151, 157, 1)"}">${numero ? "es primo" : "no es primo"}</span>`;
  cuadrado.innerHTML = `El cuadrado del ${numero} es: <span id="valCuadrado">${numero * numero}</span>`;

  abrirModal();

  inputNombre.value = "";
  inputNumero.value = "";
});

botonCerrarModal.addEventListener("click", cerrarModal);

function mostrarResultadosAnteriores() {
  const noHayNada = document.getElementById("no-hay-nada");
  if (noHayNada) {
    noHayNada.remove();
  }

  const valNombre = document.getElementById("valNombre").innerText;
  const valNumero = document.getElementById("valNumero").innerText;
  const valParImpar = document.getElementById("valParImpar").innerText;
  const valPrimo = document.getElementById("valPrimo").innerText;
  const valCuadrado = document.getElementById("valCuadrado").innerText;

  const nuevoResultado = document.createElement("div");
  nuevoResultado.className = "resultado-fila";

  nuevoResultado.innerHTML = `
    <span><b>${valNombre}</b></span>
    <span>${valNumero}</span>
    <span>${valParImpar}</span>
    <span>${valPrimo}</span>
    <span>${valCuadrado}</span>
  `;

  resultadosAnterioresContenedor.appendChild(nuevoResultado);
}
