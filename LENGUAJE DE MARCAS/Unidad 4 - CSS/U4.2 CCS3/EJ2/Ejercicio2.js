const botones = document.querySelectorAll("button");

botones.forEach((boton) => {
  boton.addEventListener("click", () => {
    alert("Has pulsado " + boton.textContent);
  });
});
