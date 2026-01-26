const inputNombre = document.getElementById("nombre");
const botonSaludar = document.getElementById("saludar");
const botonCambiarColor = document.getElementById("cambiarColor");
const resultado = document.getElementById("resultado");
const contenedor = document.getElementById("contenedor");

let activo = false;

botonSaludar.addEventListener("click", function () {
  const nombre = inputNombre.value.trim();

  if (nombre === "") {
    resultado.innerText = "Introduce un nombre!";
    resultado.style.color = "#ff7878ff";
  } else {
    resultado.innerText = "Hola " + nombre + ", bienvenido!";
    resultado.style.color = "#90ff9fff";
  }
});
