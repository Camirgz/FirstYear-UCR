import datetime

# Inicialización de Variables
ciclo = True
nombre = []

while ciclo:
  lista_elementos = []
  # Solicitud de nombre y captura de únicamente el nombre
  print(
    "Buenas. Espero que esté teniendo un buen día. Soy su planeador de horario. \n"
  )
  nombre = input("¿Cuál es su nombre? ")
  solo_nombre = nombre.split()  # Separar palabras en lista
  nombre_mayuscula = solo_nombre[-1].capitalize()  # Nombre como última palabra
  print("\nHola", nombre_mayuscula, "¡Estoy lista para ayudarle!\n")

  # Creación de horario
  cantidad_elementos = int(input("\n¿Cuántas cosas ocupa hacer?: "))

  for i in range(cantidad_elementos):
    # Solicitud de Datos
    entrada = input("\nIngrese la actividad y la hora: ")
    datos = entrada.split()

    # Obtener la actividad (primera palabra)
    elemento = datos[0]

    # Convertir la hora a objeto de tiempo (ultima palabra)
    hora_str = datos[-1]
    hora = datetime.datetime.strptime(hora_str, "%H:%M").time()

    # Crear tupla con hora y elemento
    actividad = (hora, elemento)
    lista_elementos.append(actividad)

    # Ciclo de cantidad de actividades a introducir
    if i < cantidad_elementos - 1:
      print("\n¡Siguiente actividad!\n")
    else:
      print("\n¡Gracias!\n")

  # Ordenar la lista por hora (orden cronológico)
  lista_elementos.sort(key=lambda x: x[0])

  # Horario Final
  print("\nSu horario es:")
  for actividad in lista_elementos:
    hora = actividad[0].strftime("%H:%M")
    elemento = actividad[1]
    print(f"{hora}: {elemento.capitalize()}")

  # Hacer otro horario
  repetir_ciclo = input("\n¿Desea hacer otro horario? (Sí/No): ")
  if repetir_ciclo.lower() != "si" and repetir_ciclo.lower() != "sí":
    ciclo = False