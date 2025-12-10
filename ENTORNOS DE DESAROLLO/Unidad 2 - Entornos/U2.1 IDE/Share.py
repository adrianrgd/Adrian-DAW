import random
from colorama import Fore, Style, init

# IMPORTANTE PARA WINDOWS EN ESTE CASO
init(autoreset=True)

# HECHO POR ADRIAN RANGEL Y JAVIER SAN JUAN - DAW

c = "Hecho por Adrian Rangel y Javier San Juan"

nombres = ["Alex", "Sam", "Lucía", "Diego", "Marta", "Jules"] 
lugares = [
    f"{Fore.BLUE}en la biblioteca{Style.RESET_ALL}",
    f"{Fore.BLUE}en el laboratorio{Style.RESET_ALL}",
    f"{Fore.BLUE}en clase de programación{Style.RESET_ALL}",
    f"{Fore.BLUE}en la cafetería{Style.RESET_ALL}",
    f"{Fore.BLUE}en el aula virtual{Style.RESET_ALL}",
    f"{Fore.BLUE}en el pasillo del edificio de informática{Style.RESET_ALL}",
    f"{Fore.BLUE}en la sala de servidores{Style.RESET_ALL}",
    f"{Fore.BLUE}se comio una polla de goma{Style.RESET_ALL}"
]

acciones = [
    f"{Fore.YELLOW}rompió el código justo antes de entregarlo{Style.RESET_ALL}",
    f"{Fore.YELLOW}olvidó hacer el commit en GitHub{Style.RESET_ALL}",
    f"{Fore.YELLOW}descubrió un bug a las 3 de la mañana{Style.RESET_ALL}",
    f"{Fore.YELLOW}logró compilar a la primera (milagro){Style.RESET_ALL}",
    f"{Fore.YELLOW}confundió Python con Java durante el examen{Style.RESET_ALL}",
    f"{Fore.YELLOW}borró sin querer todo el proyecto con `rm -rf /`{Style.RESET_ALL}",
    f"{Fore.YELLOW}subió las credenciales a GitHub por accidente{Style.RESET_ALL}",
    f"{Fore.YELLOW}arregló un bug añadiendo un comentario mágico{Style.RESET_ALL}",
    f"{Fore.YELLOW}presentó su código con `print('funciona')` como prueba{Style.RESET_ALL}",
    f"{Fore.YELLOW}se meo en el saco de dormir{Style.RESET_ALL}"
]

emociones = [
    f"{Fore.RED}frustrado pero optimista{Style.RESET_ALL}",
    f"{Fore.RED}orgulloso de su bug favorito{Style.RESET_ALL}",
    f"{Fore.RED}al borde de un colapso nervioso{Style.RESET_ALL}",
    f"{Fore.RED}feliz porque por fin compiló{Style.RESET_ALL}",
    f"{Fore.RED}confundido por un error que ya no existe{Style.RESET_ALL}",
    f"{Fore.RED}motivado por la cafeína{Style.RESET_ALL}",
    f"{Fore.RED}desesperado pero funcional{Style.RESET_ALL}",
    f"{Fore.RED}riendo para no llorar{Style.RESET_ALL}",
    f"{Fore.RED}sorprendido de que funcionara{Style.RESET_ALL}",
    f"{Fore.RED}agotado pero satisfecho{Style.RESET_ALL}",
    f"{Fore.RED}enfadado porque no le cambiaba la escopeta{Style.RESET_ALL}"
]

def decoracionCreditos():
    for x in range(len(c)): 
        print(f'{Fore.YELLOW}-', end="")

decoracionCreditos()
print(f"\n{c}")
decoracionCreditos()

decision = str(input("\nQuieres añadir tu nombre? (Y/N)-> "))

if decision.upper() == "Y":
    listaNombre = str(input("Añade tu nombre -> "))

    if listaNombre:
        print("🎓 Generador de situaciones de estudiantes de informática 🎓\n") 
        lugar = random.choice(lugares) 
        accion = random.choice(acciones)
        emocion = random.choice(emociones)
        resultado = f"{listaNombre} estaba {lugar} y {accion}, y se le veia {emocion}."
        print(f"{resultado}") 
        f = str(input("Quieres guardar los resultados en un archivo .txt? -> "))
        if f.upper() == "Y":
            a = str(input("Nombre del archivo .txt (sin extensión): "))
            with open(f"{a}.txt", "a", encoding="utf-8") as f:
                f.write(f"{resultado}\n")
        elif f.upper() == "N":
            pass
        else:
            print("Pon una opción correcta.")
elif decision.upper() == "N":
    print("🎓 Generador de situaciones de estudiantes de informática 🎓\n") 
    nombre = random.choice(nombres) 
    lugar = random.choice(lugares) 
    accion = random.choice(acciones)
    emocion = random.choice(emociones)
    resultado = f"{nombre} estaba {lugar} y {accion}, y se le veia {emocion}."
    print(f"{resultado}") 
    f = str(input("Quieres guardar los resultados en un archivo .txt? (Y/N) -> "))
    if f.upper() == "Y":
        a = str(input("Nombre del archivo .txt (sin extensión): "))
        with open(f"{a}.txt", "a", encoding="utf-8") as f:
            f.write(f"{resultado}\n")
    elif f.upper() == "N":
        pass
    else:
        print("Pon una opción correcta.")
else:
    print("Pon una opción correcta.")