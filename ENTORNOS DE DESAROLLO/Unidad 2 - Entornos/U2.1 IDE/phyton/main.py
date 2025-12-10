def suma(num1, num2):
    return num1 + num2

def resta(num1, num2):
    return num1 - num2

def multiplicacion(num1, num2):
    return num1 * num2

def division(num1 , num2):
    if num2 != 0:
        return num1 / num2
    else:
        return "Error, no se puede dividir por 0"
    
print("Por favor, elige una operación:")
print("1. Suma")
print("2. Resta")
print("3. Multiplicación")
print("4. División")

opcion = input("Ingresa una opción (1/2/3/4): ")

try:
    num1 = float(input("Ingresa el primer numero: "))
    num2 = float(input("Ingresa el segundo numero "))

if opcion == '1':
    print(f"{num1} + {num2} = {suma(num1, num2)}")
elif opcion == '2':
    print(f"{num1} - {num2} = {resta(num1, num2)}")
elif opcion == '3':
    print(f"{num1} * {num2} = {multiplicacion(num1, num2)}")
    elif opcion == '4':
print(f"{num1} / {num2} = {division(num1, num2)}")
else:
print("Opción inválida")
except ValueError:
print("Error: Por favor ingresa valores numéricos válidos.")