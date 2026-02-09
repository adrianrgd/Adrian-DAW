const inputNombre = document.getElementById("nombre");
const inputEdad = document.getElementById("edad");
const selectColor = document.getElementById("color");
const botonGuardar = document.getElementById("guardar");

const botonCerrarModal = document.getElementById("cerrarModal");
const modal = document.getElementById("modal");
const infoNombre = document.getElementById("infoNombre");
const infoEdad = document.getElementById("infoEdad");
const infoColor = document.getElementById("infoColor");

function abrirModal() {
  modal.style.display = "flex";
}

function cerrarModal() {
  modal.style.display = "none";
}

botonGuardar.addEventListener("click", function () {
  const nombre = inputNombre.value.trim();
  const edad = inputEdad.value.trim();
  const color = selectColor.value;

  if (nombre === "" || color === "" || edad === "") {
    alert("Por favor, completa todos los campos.");
    return;
  }

  infoNombre.innerText = `Nombre: ${nombre}`;
  infoEdad.innerText = `Edad: ${edad}`;
  infoColor.innerText = `Color favorito: ${color}`;

  abrirModal();

  inputNombre.value = "";
  inputEdad.value = "";
  selectColor.value = "";
});

botonCerrarModal.addEventListener("click", cerrarModal);
